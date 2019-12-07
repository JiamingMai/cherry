package com.kapok.model.store;

import java.io.Serializable;
import java.util.Objects;

public class RDF implements Serializable {

    private String id;

    private String subject;

    private String predicate;

    private String object;

    public RDF() {
    }

    public RDF(String id, String subject, String predicate, String object) {
        this.id = id;
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RDF rdf = (RDF) o;
        return Objects.equals(id, rdf.id) &&
                Objects.equals(subject, rdf.subject) &&
                Objects.equals(predicate, rdf.predicate) &&
                Objects.equals(object, rdf.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, predicate, object);
    }
}
