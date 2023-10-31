//package com.loyallinkup.loyallinkup.model;
//
//import com.loyallinkup.loyallinkup.model.Enum.Role;
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//@Data
//@Entity
//@Table(name = "users")
//public class User implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true)
//    private String username;
//
//    private String password;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    @Column(name = "is_account_not_expired")
//    private boolean isAccountNotExpired = true;
//
//    @Column(name = "is_account_non_locked")
//    private boolean isAccountNonLocked = true;
//
//    @Column(name = "is_credentials_not_expired")
//    private boolean isCredentialsNonExpired = true;
//
//    @Column(name = "is_enabled")
//    private boolean isEnabled = true;
//
//    @OneToOne
//    @JoinColumn(name = "business_id")
//    private Business business;
//
//    @OneToOne
//    @JoinColumn(name = "client_id")
//    private Client client;
//
//    public User(String username, String password, Role role, Business business) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.business = business;
//
//    }
//
//    public User(String username, String password, Role role, Client client) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.client = client;
//
//    }
//
//    public User() {
//
//    }
//
//    public User(String username, String password, Role role) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singletonList(role);
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return isAccountNotExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return isAccountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return isCredentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isEnabled;
//    }
//
//    public Business getBusiness() {
//        return business;
//    }
//
//    public Client getClient() {
//        return client;
//    }
//}
