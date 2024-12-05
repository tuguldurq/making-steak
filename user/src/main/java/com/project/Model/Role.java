package com.project.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.project.Model.Permission.ADMIN_CREATE;
import static com.project.Model.Permission.ADMIN_DELETE;
import static com.project.Model.Permission.ADMIN_READ;
import static com.project.Model.Permission.ADMIN_UPDATE;

@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ADMIN(
        Set.of(
                ADMIN_READ,
                ADMIN_UPDATE,
                ADMIN_DELETE,
                ADMIN_CREATE
            )
    )
    ;

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
    
}
