package com.kapok.query.ast;

import com.kapok.query.parser.AstVisitor;

public class Field implements Element {

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
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Field{" +
                "value='" + value + '\'' +
                '}';
    }
}
