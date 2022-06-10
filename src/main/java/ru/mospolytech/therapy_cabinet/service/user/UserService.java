package ru.mospolytech.therapy_cabinet.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mospolytech.therapy_cabinet.models.domain.user.Role;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Dimevision
 * @version 0.1
 */

//@Service
@RequiredArgsConstructor
public class UserService implements UserDetails {

    private final transient User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Role> test = user.getRoles();

        Set<Set<SimpleGrantedAuthority>> test2 = user.getRoles().stream()
                .map(r -> r.getRoleName().getAuthorities())
                .collect(Collectors.toSet());

        Set<SimpleGrantedAuthority> roles =
                user.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority(r.getRoleName().name()))
                        .collect(Collectors.toSet());

        System.out.println("\t\troles: " + roles);
        System.out.println("\t\ttest: " + test);
        System.out.println("\t\ttest2: " + test2);

        return new ArrayList<>(roles);
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
