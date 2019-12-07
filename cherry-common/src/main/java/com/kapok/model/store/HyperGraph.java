package com.kapok.model.store;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HyperGraph implements Serializable {

    private Map<String, HyperEdge> subjectEdges = new HashMap<>();

    private Map<String, HyperEdge> predicateEdges = new HashMap<>();

    private Map<String, HyperEdge> objectEdge = new HashMap<>();

    public void addVertex(HyperVertex vertex) {
        String subject = vertex.getRdf().getSubject();
        String predicate = vertex.getRdf().getPredicate();
        String object = vertex.getRdf().getObject();

        // update the map subjectEdges
        if (!subjectEdges.containsKey(subject)) {
            HyperEdge hyperEdge = new HyperEdge();
            hyperEdge.addVertex(vertex);
            subjectEdges.put(subject, hyperEdge);
        } else {
            subjectEdges.get(subject).addVertex(vertex);
        }

        // update the map predicateEdges
        if (!predicateEdges.containsKey(predicate)) {
            HyperEdge hyperEdge = new HyperEdge();
            hyperEdge.addVertex(vertex);
            predicateEdges.put(predicate, hyperEdge);
        } else {
            predicateEdges.get(predicate).addVertex(vertex);
        }

        // update the map objectEdges
        if (!objectEdge.containsKey(object)) {
            HyperEdge hyperEdge = new HyperEdge();
            hyperEdge.addVertex(vertex);
            objectEdge.put(object, hyperEdge);
        } else {
            objectEdge.get(object).addVertex(vertex);
        }
    }

    public Map<String, HyperEdge> getSubjectEdges() {
        return subjectEdges;
    }

    public Map<String, HyperEdge> getPredicateEdges() {
        return predicateEdges;
    }

    public Map<String, HyperEdge> getObjectEdge() {
        return objectEdge;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        // print the subject edges
        buffer.append("==== Subject Edges ====\n");
        for (Map.Entry<String, HyperEdge> entry : subjectEdges.entrySet()) {
            buffer.append(entry.getKey() + ": ");
            for (HyperVertex vertex : entry.getValue().getVertices()) {
                buffer.append(vertex.getRdf().getId() + " ");
            }
            buffer.append("\n");
        }
        buffer.append("\n");
        // print the predicate edges
        buffer.append("==== Predicate Edges ====\n");
        for (Map.Entry<String, HyperEdge> entry : predicateEdges.entrySet()) {
            buffer.append(entry.getKey() + ": ");
            for (HyperVertex vertex : entry.getValue().getVertices()) {
                buffer.append(vertex.getRdf().getId() + " ");
            }
            buffer.append("\n");
        }
        buffer.append("\n");
        // print the object edges
        buffer.append("==== Object Edges ====\n");
        for (Map.Entry<String, HyperEdge> entry : objectEdge.entrySet()) {
            buffer.append(entry.getKey() + ": ");
            for (HyperVertex vertex : entry.getValue().getVertices()) {
                buffer.append(vertex.getRdf().getId() + " ");
            }
            buffer.append("\n");
        }
        buffer.append("\n");
        return buffer.toString();
    }
}
