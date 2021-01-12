package com.ankitech.vaccnow.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Location {
    DELHI("delhi"),
    PUNE("pune"),
    MUMBAI("mumbai");

    private final String value;

    Location(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Location fromValue(String text) {
        for (Location b : Location.values()) {
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
