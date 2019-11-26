package com.kapok.query.ast;

public class VariableField extends Field {

    private String variableValue;

    public VariableField(String value) {
        super(value);
    }

    public String getVariableValue() {
        return variableValue;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }

    @Override
    public String toString() {
        return "VariableField{" +
                "variableValue='" + variableValue + '\'' +
                '}';
    }

}
