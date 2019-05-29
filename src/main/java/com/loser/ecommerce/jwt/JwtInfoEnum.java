package com.loser.ecommerce.jwt;

/**
 * username/password/company
 */
public enum JwtInfoEnum {
    USERNAME("USERNAME"),
    PASSWORD("PASSWORD"),
    DATE("DATE"),
    ROLE("ROLE"),
    PERMISSION("PERMISSION"),
    USER_UUID("USER_UUID");

    private String infoName;

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    JwtInfoEnum(String infoName) {
        this.infoName = infoName;
    }
}
