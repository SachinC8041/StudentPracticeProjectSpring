package com.example.studentapiapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/public/**").permitAll()         // Public area
                        .requestMatchers("/admin/**").hasRole("ADMIN")     // Teacher/Admin
                        .requestMatchers("/user/**").hasRole("USER") // Student/User
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> {}) // Enable Basic Auth (Postman)
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder pe) {
        UserDetails teacher = User.withUsername("teacher")
                .password(pe.encode("teacher123"))
                .roles("ADMIN") // Teacher == ADMIN
                .build();

        UserDetails student = User.withUsername("student")
                .password(pe.encode("student123"))
                .roles("USER") // Student == USER
                .build();

        return new InMemoryUserDetailsManager(teacher, student);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
