package com.loser.ecommerce.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UsersExt extends Users implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Roles> roles;
    private List<Permissions>permissions;

}
