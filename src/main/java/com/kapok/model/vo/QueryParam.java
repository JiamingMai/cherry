package com.kapok.model.vo;

import java.io.Serializable;

public class QueryParam implements Serializable {

    private String sparql;

    public String getSparql() {
        return sparql;
    }

    public void setSparql(String sparql) {
        this.sparql = sparql;
    }
}
