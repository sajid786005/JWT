package com.Abbas.Jwt_Security.User;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.UserDatabase;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.Abbas.Jwt_Security.User.Permission.*;

@RequiredArgsConstructor
public enum Role implements org.apache.catalina.Role {


    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    MANAGER_READ,
                    MANAGER_UPDATE,
                    MANAGER_DELETE,
                    MANAGER_CREATE
            )
    ),
    MANAGER(
            Set.of(
                    MANAGER_READ,
                    MANAGER_UPDATE,
                    MANAGER_DELETE,
                    MANAGER_CREATE
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

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void setDescription(String s) {

    }

    @Override
    public String getRolename() {
        return "";
    }

    @Override
    public void setRolename(String s) {

    }

    @Override
    public UserDatabase getUserDatabase() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }
}
