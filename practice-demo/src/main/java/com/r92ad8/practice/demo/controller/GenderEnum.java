package com.r92ad8.practice.demo.controller;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum GenderEnum implements BaseEnum {
    UNKNOWN(0), MALE(110), FEMALE(2);

    private int value;
    private static Map<Integer, GenderEnum> valueMap = new HashMap<>();

    static {
        for (GenderEnum gender : GenderEnum.values()) {
            valueMap.put(gender.value, gender);
        }
    }

    GenderEnum(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public static GenderEnum getByValue(int value) {
        GenderEnum result = valueMap.get(value);
        if (result == null) {
            throw new IllegalArgumentException("No element matches " + value);
        }
        return result;
    }

    @JsonCreator
    public static GenderEnum getValue(int code) {
        for (GenderEnum item : GenderEnum.values()) {
            if (item.getValue() == code) {
                return item;
            }
        }
        return null;
    }

}
