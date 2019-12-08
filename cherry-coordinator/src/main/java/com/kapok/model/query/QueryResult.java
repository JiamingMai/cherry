package com.kapok.model.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryResult implements Serializable {

    private List<Record> records = new ArrayList<>();

    private String readableResult;

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public String getReadableResult() {
        return readableResult;
    }

    public void setReadableResult(String readableResult) {
        this.readableResult = readableResult;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Record record : records) {
            buffer.append(record.toString());
        }
        return buffer.toString();
    }

}
