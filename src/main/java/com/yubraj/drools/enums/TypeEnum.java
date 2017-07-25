package com.yubraj.drools.enums;

/**
 * Created by ypokhrel on 7/25/2017.
 */
public enum TypeEnum {
    MEDICAL("medical", "aaabbbccc"), ELECTRONIC("electronic", "cccbbbaaa");


    private final String type;
    private final String someOutputString;

    private TypeEnum(String type, String someOutputString) {
        this.type = type;
        this.someOutputString = someOutputString;
    }

    public String getType() {
        return type;
    }

    public String getSomeOutputString() {
        return someOutputString;
    }
}
