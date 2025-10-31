package com.hex.trs.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.hex.trs.service.MyUserSecurityService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
	
	private final MyUserSecurityService myUserSecurityService;

    @Bean
    SecurityFilterChain securedFilterChain(HttpSecurity http) throws Exception {
        http
        	   .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(authorize -> authorize	   
                       .requestMatchers(HttpMethod.GET, "/api/auth/public/hello").permitAll()
                       .requestMatchers(HttpMethod.GET, "/api/auth/employee/hello").authenticated()
                       .requestMatchers(HttpMethod.GET, "/api/auth/customer/hello").hasAnyAuthority("CUSTOMER")
                       .requestMatchers(HttpMethod.GET, "/api/auth/executive/hello").hasAnyAuthority("EXECUTIVE")
                       .requestMatchers(HttpMethod.POST, "/api/customer/signup").permitAll()
                       .requestMatchers(HttpMethod.POST, "/api/customer/plan/{planId}").hasAnyAuthority("CUSTOMER")
                       .requestMatchers(HttpMethod.GET, "/api/customer/ticket/info/2").hasAnyAuthority("CUSTOMER")
                       .anyRequest().authenticated()
               )
               .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(myUserSecurityService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authenticationProvider);
    }
}