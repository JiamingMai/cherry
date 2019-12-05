package com.kapok.service.query;

import java.util.ArrayList;
import java.util.List;

public class QueryResult {

    private List<Record> records = new ArrayList<>();

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Record record : records) {
            buffer.append(record.toString());
        }
        return buffer.toString();
    }

    static class Record {

        private List<String> fields = new ArrayList<>();

        public void add(String field) {
            fields.add(field);
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

}
