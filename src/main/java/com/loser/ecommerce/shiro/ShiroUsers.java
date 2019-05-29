package com.loser.ecommerce.shiro;

import lombok.Data;

import java.util.Set;

@Data
public class ShiroUsers {

    private String username;
    private String password;

    private String userUuid;

    private Set<String> role;
    private Set<String> permissions;

    public ShiroUsers(String username, String password, String userUuid, Set<String> role, Set<String> permissions) {
        this.username = username;
        this.password = password;
        this.userUuid = userUuid;
        this.role = role;
        this.permissions = permissions;
    }

}
