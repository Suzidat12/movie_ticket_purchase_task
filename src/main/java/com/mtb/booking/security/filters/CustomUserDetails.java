package com.mtb.booking.security.filters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mtb.booking.model.Roleuser;
import com.mtb.booking.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final Collection<? extends GrantedAuthority> authorities;
    private final String password;
    private final String username;

    public CustomUserDetails (Users user, List<Roleuser> list) {
        this.username = user.getUsersEmail();
        this.password = user.getPassword();
        this.authorities = translate(list);
    }

    private Collection<? extends GrantedAuthority> translate(List<Roleuser> roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Roleuser role : roles) {
            String name = role.getRoleid().getName().toUpperCase();
                name = "ROLE_" + name; // ROLE_USER
            grantedAuthorities.add(new SimpleGrantedAuthority(name));
        }
        return grantedAuthorities;
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
        return username;
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
