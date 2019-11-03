package com.kapok.query.ast;

public class Field implements Node {

    private String value;

    public Field() {
    }

    public Field(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Field{" +
                "value='" + value + '\'' +
                '}';
    }
}
