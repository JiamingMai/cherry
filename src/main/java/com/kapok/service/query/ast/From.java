package com.kapok.service.query.ast;

import com.kapok.service.query.parser.AstVisitor;

public class From implements Element {

    private Field relationName;

    public Field getRelationName() {
        return relationName;
    }

    public void setRelationName(Field relationName) {
        this.relationName = relationName;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "From{" +
                "relationName=" + relationName +
                '}';
    }
}
