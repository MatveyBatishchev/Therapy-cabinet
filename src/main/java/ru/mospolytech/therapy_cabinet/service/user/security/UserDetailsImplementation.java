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

//@Service
@RequiredArgsConstructor
public class UserDetailsImplementation implements UserDetails {

    private final transient User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getRoleName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getIsEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getIsEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getIsEnabled();
    }

    @Override
    public boolean isEnabled() {
        return user.getIsEnabled();
    }

    public static UserDetails fromUser(User user) {
        Set<SimpleGrantedAuthority> authorities =
                user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getRoleName().name())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                user.getIsEnabled(), user.getIsEnabled(),
                user.getIsEnabled(), user.getIsEnabled(),
                authorities
        );
    }
}
