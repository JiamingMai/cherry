package com.kapok.service.query.ast;

import com.kapok.service.query.parser.AstVisitor;

import java.util.List;

public class Where implements Element {

    private List<WhereCondition> whereConditions;

    public List<WhereCondition> getWhereConditions() {
        return whereConditions;
    }

    public void setWhereConditions(List<WhereCondition> whereConditions) {
        this.whereConditions = whereConditions;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Where{" +
                "whereConditions=" + whereConditions +
                '}';
    }
}
