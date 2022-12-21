package com.cognizant.nitish.Audit_Authorization.security;

import com.cognizant.nitish.Audit_Authorization.Service.ProjectManagerDetailsService;
//import com.cognizant.nitish.Audit_Authorization.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ProjectManagerDetailsService projectManagerDetailsService;

//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;	//jwt request filter

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);		// strength of BCrypthPasswordEncoder = 10
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(projectManagerDetailsService).passwordEncoder(passwordEncoder());	//authentication bean
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/health-check", "/auth/authenticate", "/auth/validate","/auth/v3/api-docs","/auth/swagger-resources/**","/auth/swagger-ui/**","/auth/v2/api-docs").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);	// stopping default session creation

//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);	// adding the filter
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/auth/db/**");
    }
}