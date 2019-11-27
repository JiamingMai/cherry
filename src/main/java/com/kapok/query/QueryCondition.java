package com.kapok.query;

import java.util.ArrayList;
import java.util.List;

public class QueryCondition {

    private List<String> variables = new ArrayList<>();

    private ConditionItem subject;

    private ConditionItem predicate;

    private ConditionItem object;

    public List<String> getVariables() {
        return variables;
    }

    public void setVariables(List<String> variables) {
        this.variables = variables;
    }

    public ConditionItem getSubject() {
        return subject;
    }

    public void setSubject(ConditionItem subject) {
        this.subject = subject;
    }

    public ConditionItem getPredicate() {
        return predicate;
    }

    public void setPredicate(ConditionItem predicate) {
        this.predicate = predicate;
    }

    public ConditionItem getObject() {
        return object;
    }

    public void setObject(ConditionItem object) {
        this.object = object;
    }
}
