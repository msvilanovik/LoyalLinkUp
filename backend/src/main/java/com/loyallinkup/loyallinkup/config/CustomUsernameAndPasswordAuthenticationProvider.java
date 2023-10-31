//package com.loyallinkup.loyallinkup.config;
//
//import com.loyallinkup.loyallinkup.service.UserService;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class CustomUsernameAndPasswordAuthenticationProvider implements AuthenticationProvider {
//
//
//    private final UserService userService;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public CustomUsernameAndPasswordAuthenticationProvider(UserService userService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//         String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        UserDetails userDetails = this.userService.loadUserByUsername(username);
//
//        return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
