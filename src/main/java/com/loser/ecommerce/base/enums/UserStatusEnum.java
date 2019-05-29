package com.loser.ecommerce.base.enums;

/**
 * 0:正常 1:冻结
 */
public enum UserStatusEnum {
    InUse(0, "InUse"),
    Forbidden(1, "Forbidden")
    ;

    private int statusCode;
    private String StatusName;
    UserStatusEnum(int statusCode, String statusName) {
        this.statusCode = statusCode;
        StatusName = statusName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String statusName) {
        StatusName = statusName;
    }
}
