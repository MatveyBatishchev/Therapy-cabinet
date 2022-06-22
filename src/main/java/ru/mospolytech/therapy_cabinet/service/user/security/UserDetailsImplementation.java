package ru.mospolytech.therapy_cabinet.service.user.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Dimevision
 * @version 0.1
 */

@RequiredArgsConstructor
public class UserDetailsImplementation implements UserDetails {

    private final transient User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.name()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
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

    public static UserDetails fromUser(User user) {
        Set<SimpleGrantedAuthority> authorities =
                user.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority(r.name()))
                        .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(),
                authorities
        );
    }
}
