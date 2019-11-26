package com.kapok.query.ast;

import java.util.List;

public class Where implements Node {

    private List<WhereCondition> whereConditions;

    public List<WhereCondition> getWhereConditions() {
        return whereConditions;
    }

    public void setWhereConditions(List<WhereCondition> whereConditions) {
        this.whereConditions = whereConditions;
    }

    @Override
    public String toString() {
        return "Where{" +
                "whereConditions=" + whereConditions +
                '}';
    }
}
