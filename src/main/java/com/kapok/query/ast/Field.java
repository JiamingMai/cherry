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

    public boolean isVariable() {
        if (this instanceof VariableField) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Field{" +
                "value='" + value + '\'' +
                '}';
    }
}
