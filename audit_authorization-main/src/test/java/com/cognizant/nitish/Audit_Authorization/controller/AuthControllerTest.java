package com.cognizant.nitish.Audit_Authorization.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.cognizant.nitish.Audit_Authorization.Service.JwtService;
import com.cognizant.nitish.Audit_Authorization.Service.ProjectManagerDetailsService;
import com.cognizant.nitish.Audit_Authorization.model.AuthenticationRequest;
import com.cognizant.nitish.Audit_Authorization.model.ProjectManagerDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class, AuthenticationRequest.class})
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationRequest authenticationRequest;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private ProjectManagerDetailsService projectManagerDetailsService;

    /**
     * Method under test: {@link AuthController#generateJwt(AuthenticationRequest)}
     */
    @Test
    void testGenerateJwt() throws Exception {
        when(jwtService.generateToken((ProjectManagerDetails) any())).thenReturn("ABC123");
        when(projectManagerDetailsService.loadUserByUsername((String) any()))
                .thenReturn(new ProjectManagerDetails(1, "Name", "janedoe", "iloveyou", "Project Name"));
        when(authenticationManager.authenticate((Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest();
        authenticationRequest1.setPassword("iloveyou");
        authenticationRequest1.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequest1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("ABC123"));
    }

    /**
     * Method under test: {@link AuthController#healthCheck()}
     */
    @Test
    void testHealthCheck() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auth/health-check");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit-Authorization MS Running Fine!!"));
    }

    /**
     * Method under test: {@link AuthController#healthCheck()}
     */
    @Test
    void testHealthCheck2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/auth/health-check");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit-Authorization MS Running Fine!!"));
    }

    /**
     * Method under test: {@link AuthController#validateJwt(String)}
     */
    @Test
    void testValidateJwt() throws Exception {
        when(jwtService.validateToken((String) any(), (ProjectManagerDetails) any())).thenReturn(true);
        when(jwtService.extractUsername((String) any())).thenReturn("janedoe");
        when(projectManagerDetailsService.loadUserByUsername((String) any()))
                .thenReturn(new ProjectManagerDetails(1, "Name", "janedoe", "iloveyou", "Project Name"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/validate")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"name\":\"Name\",\"projectName\":\"Project Name\",\"valid\":true}"));
    }

    /**
     * Method under test: {@link AuthController#validateJwt(String)}
     */
    @Test
    void testValidateJwt2() throws Exception {
        when(jwtService.validateToken((String) any(), (ProjectManagerDetails) any())).thenReturn(false);
        when(jwtService.extractUsername((String) any())).thenReturn("janedoe");
        when(projectManagerDetailsService.loadUserByUsername((String) any()))
                .thenReturn(new ProjectManagerDetails(1, "Name", "janedoe", "iloveyou", "Project Name"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/validate")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"name\":\"Invalid\",\"projectName\":\"Invalid\",\"valid\":false}"));
    }

    /**
     * Method under test: {@link AuthController#validateJwt(String)}
     */
    @Test
    void testValidateJwt3() throws Exception {
        when(jwtService.validateToken((String) any(), (ProjectManagerDetails) any())).thenReturn(true);
        when(jwtService.extractUsername((String) any())).thenReturn("janedoe");
        when(projectManagerDetailsService.loadUserByUsername((String) any())).thenReturn(null);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/validate")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"name\":\"Invalid\",\"projectName\":\"Invalid\",\"valid\":false}"));
    }
}

