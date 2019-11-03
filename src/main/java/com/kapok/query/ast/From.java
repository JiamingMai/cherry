package com.kapok.query.ast;

public class From implements Node {

    private Field relationName;

    public Field getRelationName() {
        return relationName;
    }

    public void setRelationName(Field relationName) {
        this.relationName = relationName;
    }

    @Override
    public String toString() {
        return "From{" +
                "relationName=" + relationName +
                '}';
    }
}
