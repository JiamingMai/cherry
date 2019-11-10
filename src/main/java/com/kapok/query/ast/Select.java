package com.kapok.query.ast;

import com.kapok.query.parser.AstVisitor;

import java.util.List;

public class Select implements Element {

    private List<Field> selectItems;

    public List<Field> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<Field> selectItems) {
        this.selectItems = selectItems;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Select{" +
                "selectItems=" + selectItems +
                '}';
    }
}
