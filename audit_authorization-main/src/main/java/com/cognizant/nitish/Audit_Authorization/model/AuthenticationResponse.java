package com.cognizant.nitish.Audit_Authorization.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuthenticationResponse {
    private String name;
    private String projectName;
    private boolean isValid;
}