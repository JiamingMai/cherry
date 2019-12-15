package com.kapok.service.store;

import com.kapok.model.discovery.ServerConfig;
import com.kapok.model.store.HyperGraph;
import com.kapok.model.store.HyperVertex;
import com.kapok.model.store.RDF;
import org.apache.jena.rdf.model.*;
import org.springframework.stereotype.Service;

@Service
public class HyperGraphConvertor {

    public HyperGraph convert(Model model) {
        HyperGraph hyperGraph = new HyperGraph();

        // list the statements in the Model
        StmtIterator iter = model.listStatements();

        // print out the predicate, subject and object of each statement
        while (iter.hasNext()) {
            // get next statement
            Statement stmt = iter.nextStatement();
            // get the subject
            Resource subject = stmt.getSubject();
            // get the predicate
            Property predicate = stmt.getPredicate();
            // get the object
            RDFNode object = stmt.getObject();

            // build a RDF and then add it to the hyper graph
            RDF rdf;
            if (object instanceof Resource) {
                rdf = new RDF(ServerConfig.getIdCounter().getAndAdd(1) + "",
                        subject.toString(), predicate.toString(), object.toString());
            } else {
                // object is a literal
                rdf = new RDF(ServerConfig.getIdCounter().getAndAdd(1) + "",
                        subject.toString(), predicate.toString(), object.toString());
            }
            HyperVertex hyperVertex = new HyperVertex(rdf);
            hyperGraph.addVertex(hyperVertex);
        }
        return hyperGraph;
    }

}
