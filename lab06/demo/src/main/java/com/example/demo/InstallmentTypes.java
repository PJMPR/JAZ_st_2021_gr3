package com.example.demo;

import java.util.Arrays;

public enum InstallmentTypes {
    DECREASING("decreasing"),
    FIXED("constant");

    private String type;

    InstallmentTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static InstallmentTypes getType(String type) {
        return Arrays.stream(InstallmentTypes.values()).filter(installmentType -> installmentType.getType().equals(type)).findFirst().orElse(null);
    }
}

