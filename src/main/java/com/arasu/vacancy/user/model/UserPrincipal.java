package com.arasu.vacancy.user.model;

import com.arasu.vacancy.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private String userEmail;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String userEmail, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userEmail = userEmail;
        this.password = password;
        this.authorities = authorities;
    }
    public static UserPrincipal create(User userInput) {
       return new UserPrincipal(userInput.getEmail(), userInput.getPassword(), null);
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
