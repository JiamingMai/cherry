package com.kapok.query.ast;

public class Query implements Node {

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
    public String toString() {
        return "Query{" +
                "select=" + select +
                ", from=" + from +
                ", where=" + where +
                '}';
    }
}