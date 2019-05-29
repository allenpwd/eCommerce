package com.loser.ecommerce.shiro;


import com.loser.ecommerce.entity.Permissions;
import com.loser.ecommerce.entity.Roles;
import com.loser.ecommerce.entity.UsersExt;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ShiroUsers转换类
 */
public class ShiroUsersFactory {

    public static ShiroUsers create(UsersExt user) {
        return new ShiroUsers(
                user.getUsername(),
                user.getPassword(),
                user.getUserUuid(),
                parseRoleName(user.getRoles()),
                parsePermisionName(user.getPermissions())
        );
    }

    private static Set<String> parseRoleName(List<Roles> rolesList) {
        Set<String> roleSet = new HashSet<>();
        if (!rolesList.isEmpty())
            rolesList.forEach(e -> roleSet.add(e.getRoleName()));
        return roleSet;
    }

    private static Set<String> parsePermisionName(List<Permissions> permisionList) {
        Set<String> permisionSet = new HashSet<>();
        if (!permisionList.isEmpty())
            permisionList.forEach(e -> permisionSet.add(e.getPermissionName()));
        return permisionSet;
    }
}
