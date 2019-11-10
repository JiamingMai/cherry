package com.kapok.query.ast;

import com.kapok.query.parser.AstVisitor;

public class Query implements Element {

    private Select select;

    private From from;

    private Where where;

    public Select getSelect() {
        return select;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public Where getWhere() {
        return where;
    }

    public void setWhere(Where where) {
        this.where = where;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Query{" +
                "select=" + select +
                ", from=" + from +
                ", where=" + where +
                '}';
    }
}
