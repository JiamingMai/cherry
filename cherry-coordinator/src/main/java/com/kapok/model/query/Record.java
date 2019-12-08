package com.kapok.model.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Record implements Serializable {

    private List<String> fields = new ArrayList<>();

    public void add(String field) {
        fields.add(field);
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (String field : fields) {
            buffer.append(field + "\t");
        }
        buffer.append("\n");
        return buffer.toString();
    }
}