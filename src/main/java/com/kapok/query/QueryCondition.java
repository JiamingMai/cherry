package com.kapok.query;

import java.util.List;

public class QueryCondition {

    boolean showSubject;

    boolean showPredicate;

    boolean showObject;

    private String subject;

    private String predicate;

    private String object;

    public boolean isShowSubject() {
        return showSubject;
    }

    public void setShowSubject(boolean showSubject) {
        this.showSubject = showSubject;
    }

    public boolean isShowPredicate() {
        return showPredicate;
    }

    public void setShowPredicate(boolean showPredicate) {
        this.showPredicate = showPredicate;
    }

    public boolean isShowObject() {
        return showObject;
    }

    public void setShowObject(boolean showObject) {
        this.showObject = showObject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
