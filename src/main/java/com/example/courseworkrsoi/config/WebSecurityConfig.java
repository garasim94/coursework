package com.example.courseworkrsoi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                    .requestMatchers("/").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    //.defaultSuccessUrl("/main")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
        return http.build();
    }

    @Bean
    //@Override
    public UserDetailsService userDetailsService() {
       UserDetails user = User.withDefaultPasswordEncoder()
               .username("user")
               .password("1994")
               .roles("USER")
               .build();
       return new InMemoryUserDetailsManager(user);
   }
}

