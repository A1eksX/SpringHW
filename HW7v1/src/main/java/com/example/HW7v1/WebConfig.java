package com.example.HW7v1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/user.html").hasRole("USER")
                .antMatchers("/admin.html").hasRole("ADMIN")
             .and()
                .formLogin()
             .and()
                .logout().permitAll();
        return http.build();

    }

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username("user").password("{noop}pass").roles("USER").build();
        UserDetails admin = User.builder().username("admin").password("{noop}admin").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}
