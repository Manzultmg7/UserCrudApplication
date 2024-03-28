package com.example.UserCrudApplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
//    @Value("#{${auth.not.required.urls}}")
    String[] permittedApis={"/v3/api-docs","/v3/api-docs/**","/swagger-ui.html","/swagger-ui/**","/api/**"} ;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors().disable()
                .csrf().disable() // Disable CSRF for simplicity, enable it in a production environment
                .authorizeRequests()
                .requestMatchers(permittedApis).permitAll()
                .anyRequest().authenticated().and().formLogin()  ;

        return http.build();
    }
}
