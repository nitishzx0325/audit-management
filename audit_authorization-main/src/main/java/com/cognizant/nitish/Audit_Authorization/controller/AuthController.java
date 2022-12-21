package com.cognizant.nitish.Audit_Authorization.controller;

import com.cognizant.nitish.Audit_Authorization.Service.JwtService;
import com.cognizant.nitish.Audit_Authorization.Service.ProjectManagerDetailsService;
import com.cognizant.nitish.Audit_Authorization.model.AuthenticationRequest;
import com.cognizant.nitish.Audit_Authorization.model.AuthenticationResponse;
import com.cognizant.nitish.Audit_Authorization.model.ProjectManagerDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")	//Context Root
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ProjectManagerDetailsService projectManagerDetailsService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck(){	// for Health check [PERMITTED FOR ALL]
        return new ResponseEntity<String>("Audit-Authorization MS Running Fine!!", HttpStatus.OK);
    }

    // authentication - for the very first login
    @PostMapping("/authenticate")
    public ResponseEntity<String> generateJwt(@Valid @RequestBody AuthenticationRequest request){
        ResponseEntity<String> response = null;

        // authenticating the User-Credentials
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            // else when it authenticates successfully
            final ProjectManagerDetails projectManagerDetails = projectManagerDetailsService
                    .loadUserByUsername(request.getUsername());


//			2 object a) authencicate me object users ka details object send kar raha hai
//			b)backend loadByUserName wo v userdetail ko authenticate







            final String jwt = jwtService.generateToken(projectManagerDetails);	// returning the token as response

            //test
            log.info("Authenticated User :: " + projectManagerDetails);

            response = new ResponseEntity<String>(jwt, HttpStatus.OK);

            log.info("Successfully Authenticated user!");

        }catch (Exception e) {
            log.error(e.getMessage() + "!! info about request-body : " + request);
            response = new ResponseEntity<String>("Not Authorized Project Manager", HttpStatus.FORBIDDEN);
        }
        log.info("-------- Exiting /authenticate");
        return response;
    }

    // validate - for every request it validates the user-credentials from the provided Jwt token in Authorization req. header
    @PostMapping("/validate")
    public ResponseEntity<AuthenticationResponse> validateJwt(@RequestHeader("Authorization") String jwt){

        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Invalid", "Invalid", false);
        ResponseEntity<AuthenticationResponse> response = null;

        //first remove Bearer from Header
        jwt = jwt.substring(7);

        //check token
        log.info("--------JWT :: "+jwt);


        // check the jwt is proper or not
        final ProjectManagerDetails projectManagerDetails = projectManagerDetailsService
                .loadUserByUsername(jwtService.extractUsername(jwt));

        // now validating the jwt
        try {
            if(jwtService.validateToken(jwt, projectManagerDetails)) {
                authenticationResponse.setName(projectManagerDetails.getName());
                authenticationResponse.setProjectName(projectManagerDetails.getProjectName());
                authenticationResponse.setValid(true);
                response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
                log.info("Successfully validated the jwt and sending response back!");
            }
            else {
                response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.BAD_REQUEST);
                log.error("JWT Token validation failed!");
            }
        }catch (Exception e) {
            log.error(e.getMessage());
            response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
            log.error("Exception occured whil validating JWT : Exception info : " + e.getMessage());
        }
        log.info("-------- Exiting /validate");
        return response;
    }
}
