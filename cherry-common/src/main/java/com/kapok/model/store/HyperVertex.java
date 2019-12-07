package com.kapok.model.store;

import java.io.Serializable;
import java.util.Objects;

public class HyperVertex implements Serializable {

    private RDF rdf;

    public HyperVertex() {
    }

    public HyperVertex(RDF rdf) {
        this.rdf = rdf;
    }

    public void setRdf(RDF rdf) {
        this.rdf = rdf;
    }

    public RDF getRdf() {
        return rdf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HyperVertex vertex = (HyperVertex) o;
        return Objects.equals(rdf, vertex.rdf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rdf);
    }
}
