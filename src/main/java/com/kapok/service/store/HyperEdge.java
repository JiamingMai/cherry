package com.kapok.service.store;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class HyperEdge implements Serializable {

    private Set<HyperVertex> vertices = new HashSet<>();

    public void addVertex(HyperVertex vertex) {
        vertices.add(vertex);
    }

    public Set<HyperVertex> getVertices() {
        return vertices;
    }

    public void setVertices(Set<HyperVertex> vertices) {
        this.vertices = vertices;
    }
}
