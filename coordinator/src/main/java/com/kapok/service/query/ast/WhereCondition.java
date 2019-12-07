package com.kapok.service.query.ast;

import com.kapok.service.query.parser.AstVisitor;

public class WhereCondition implements Element {

    private Field subjectVariable;

    private Field predicateVariable;

    private Field objectVariable;

    public Field getSubjectVariable() {
        return subjectVariable;
    }

    public void setSubjectVariable(Field subjectVariable) {
        this.subjectVariable = subjectVariable;
    }

    public Field getPredicateVariable() {
        return predicateVariable;
    }

    public void setPredicateVariable(Field predicateVariable) {
        this.predicateVariable = predicateVariable;
    }

    public Field getObjectVariable() {
        return objectVariable;
    }

    public void setObjectVariable(Field objectVariable) {
        this.objectVariable = objectVariable;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "WhereCondition{" +
                "subjectVariable=" + subjectVariable +
                ", predicateVariable=" + predicateVariable +
                ", objectVariable=" + objectVariable +
                '}';
    }
}
