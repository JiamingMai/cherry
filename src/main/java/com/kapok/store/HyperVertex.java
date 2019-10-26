package com.kapok.store;

public class HyperVertex {

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
}
