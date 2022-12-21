package com.cognizant.nitish.Audit_Authorization.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Component
@Getter
@Setter
@ToString
@Data
public class AuthenticationRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}