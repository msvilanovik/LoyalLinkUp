//package com.loyallinkup.loyallinkup.config.filters;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.loyallinkup.loyallinkup.config.JWTAuthConstants;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import java.io.IOException;
//
//public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
//
//    private final UserDetailsService userDetailsService;
//
//    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
//        super(authenticationManager);
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String header = request.getHeader(JWTAuthConstants.HEADER_STRING);
//        if (header == null || !header.startsWith(JWTAuthConstants.TOKEN_PREFIX)) {
//            chain.doFilter(request, response);
//            return;
//        }
//        String token = header.replace(JWTAuthConstants.TOKEN_PREFIX, "");
//
//        String username = JWT.require(Algorithm.HMAC256(JWTAuthConstants.SECRET.getBytes()))
//                .build()
//                .verify(token)
//                .getSubject();
//        if (username == null) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                userDetails.getUsername(),
//                userDetails.getAuthorities()
//        );
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        chain.doFilter(request, response);
//    }
//}