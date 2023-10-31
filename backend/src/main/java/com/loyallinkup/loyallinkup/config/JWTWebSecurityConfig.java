//package com.loyallinkup.loyallinkup.config;
//import com.loyallinkup.loyallinkup.config.filters.JWTAuthenticationFilter;
//import com.loyallinkup.loyallinkup.config.filters.JwtAuthorizationFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//import com.loyallinkup.loyallinkup.service.UserService;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//public class JWTWebSecurityConfig {
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .requestMatchers("/registerBusiness","/registerAdmin","/registerClient","/api/address/**","api/event/**", "/api/business/**", "/api/client/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/")
//                .and()
//                .addFilter(new JWTAuthenticationFilter(null, null, passwordEncoder()))
//                .addFilter(new JwtAuthorizationFilter(null, null))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.headers().frameOptions().sameOrigin();
//
//        return http.build();
//    }
//
//}