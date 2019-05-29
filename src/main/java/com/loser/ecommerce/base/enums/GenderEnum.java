package com.loser.ecommerce.base.enums;

public enum GenderEnum {
    Female(0, "Female"),
    Male(1, "Male"),
    Unknown(2, "Unknown");
    private int genderCode;
    private String genderName;

    public int getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(int genderCode) {
        this.genderCode = genderCode;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    GenderEnum(int genderCode, String genderName) {
        this.genderCode = genderCode;
        this.genderName = genderName;
    }
}
