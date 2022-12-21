package com.cognizant.nitish.Audit_Authorization.Service;

import io.jsonwebtoken.Claims;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtService.class})
@ExtendWith(SpringExtension.class)
class JwtServiceTest {
    @Autowired
    private JwtService jwtService;

    /**
     * Method under test: {@link JwtService#extractClaim(String, Function)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExtractClaim() {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: reactor.netty.http.server.HttpServer
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String token = "";
        Function<Claims, Object> claimsResolver = null;

        // Act
        Object actualExtractClaimResult = this.jwtService.extractClaim(token, claimsResolver);

        // Assert
        // TODO: Add assertions on result
    }
}

