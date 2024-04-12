package com.example.HW8.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         http
                //для методов изменяющих данные
                .csrf(csrf -> csrf.ignoringRequestMatchers("/news"))
                 // включить поддержку Basic-аутентификации
                 .httpBasic(Customizer.withDefaults());
        // собрать цепочку фильтров
        return http.build();

    }

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username("user").password("{noop}pass").roles("USER").build();
        UserDetails admin = User.builder().username("admin").password("{noop}admin").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}