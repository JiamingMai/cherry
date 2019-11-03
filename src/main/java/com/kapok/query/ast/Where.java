package com.kapok.query.ast;

public class Where implements Node {

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
    public String toString() {
        return "Where{" +
                "subjectVariable=" + subjectVariable +
                ", predicateVariable=" + predicateVariable +
                ", objectVariable=" + objectVariable +
                '}';
    }
}
