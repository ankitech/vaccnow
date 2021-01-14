package com.ankitech.vaccnow.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Payment {
    CASH("cash"),
    CREDIT("credit"),
    FAWRY("fawry");

    private final String value;

    Payment(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Payment fromValue(String text) {
        for (Payment b : Payment.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
