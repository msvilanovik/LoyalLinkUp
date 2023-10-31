//package com.loyallinkup.loyallinkup.config;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.loyallinkup.loyallinkup.model.Enum.Role;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//public class JWTTokenProvider {
//
//    public String generateJwtToken(UserDetails user){
//        Algorithm algorithm = Algorithm.HMAC256(JWTAuthConstants.SECRET);
//        List<String> roles = user.getAuthorities()
//                .stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//
//        return JWT.create()
//                .withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + JWTAuthConstants.EXPIRATION_TIME))
//                .withIssuer(JWTAuthConstants.HEADER_STRING)
//                .withClaim("roles", roles)
//                .sign(algorithm);
//    }
//}
