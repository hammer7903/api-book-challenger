package com.mx.api.book.challenge.app.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
public class UserRoles implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String roleName;

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }

}
