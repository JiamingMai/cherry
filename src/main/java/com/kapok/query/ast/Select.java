package com.kapok.query.ast;

import java.util.List;

public class Select {

    private List<Field> selectItems;

    public List<Field> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<Field> selectItems) {
        this.selectItems = selectItems;
    }

    @Override
    public String toString() {
        return "Select{" +
                "selectItems=" + selectItems +
                '}';
    }
}
