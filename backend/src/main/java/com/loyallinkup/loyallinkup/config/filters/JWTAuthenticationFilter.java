//package com.loyallinkup.loyallinkup.config.filters;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.loyallinkup.loyallinkup.config.JWTTokenProvider;
//import com.loyallinkup.loyallinkup.model.dto.UserDto;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//import java.util.Map;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final AuthenticationManager authenticationManager;
//    private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            StringBuilder builder = new StringBuilder();
//            request.getReader().lines().forEach(builder::append);
//            String requestBody = builder.toString().trim();
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            UserDto userDTO = objectMapper.readValue(requestBody, UserDto.class);
//            String username = userDTO.getUsername();
//            String password = userDTO.getPassword();
//
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
//                throw new RuntimeException("Credentials do not match");
//            }
//
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            userDetails.getUsername(),
//                            userDetails.getPassword(),
//                            userDetails.getAuthorities()
//                    )
//            );
//        } catch (IOException e) {
//            throw new RuntimeException("Error parsing request body", e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
//        UserDetails user = (UserDetails) authResult.getPrincipal();
//        JWTTokenProvider tokenProvider = new JWTTokenProvider();
//        String token = tokenProvider.generateJwtToken(user);
//
//        response.setContentType("application/json");
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.writeValue(response.getOutputStream(), Map.of("access_token", token, "user", user));
//        } catch (IOException e) {
//            throw new RuntimeException("Error writing response body", e);
//        }
//    }
//}