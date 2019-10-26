package com.kapok.store;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HyperEdge {

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
