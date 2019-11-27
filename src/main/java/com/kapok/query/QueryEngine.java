package com.kapok.query;

import com.kapok.query.antlr4.SparqlLexer;
import com.kapok.query.antlr4.SparqlParser;
import com.kapok.query.ast.Query;
import com.kapok.query.parser.AstBuilder;
import com.kapok.query.parser.QueryConditionVisitor;
import com.kapok.service.Node;
import com.kapok.service.NodeManager;
import com.kapok.store.HyperGraph;
import com.kapok.store.RDF;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

public class QueryEngine {

    private NodeManager nodeManager;

    public QueryEngine(NodeManager nodeManager) {
        this.nodeManager = nodeManager;
    }

    public QueryResult query(String sparql) throws IOException {
        // build AST with SPARQL
        ANTLRInputStream input = new ANTLRInputStream(new ByteArrayInputStream(sparql.getBytes()));
        SparqlLexer lexer = new SparqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SparqlParser parser = new SparqlParser(tokens);
        SparqlParser.QueryContext queryContext = parser.query();
        Query query = (Query) queryContext.accept(new AstBuilder());
        System.out.println(query);

        QueryConditionVisitor queryConditionVisitor = new QueryConditionVisitor();
        QueryCondition queryCondition = queryConditionVisitor.visit(query);

        Set<Node> nodes = nodeManager.getNodeTable().keySet();
        Set<RDF> rdfs = new HashSet<>();
        for (Node node : nodes) {
            String rdfFileName = node.getNodeId() + ".rdf";
            HyperGraph hyperGraph = node.getStorageManager().readRdfInfo(rdfFileName);
            rdfs.addAll(node.getStorageManager().filter(hyperGraph, queryCondition));
        }
        return convert(rdfs, queryCondition);
    }

    private QueryResult convert(Set<RDF> rdfs, QueryCondition queryCondition) {
        rdfs = filter(rdfs, queryCondition);

        List<QueryResult.Record> records = new ArrayList<>();
        for (RDF rdf : rdfs) {
            QueryResult.Record record = new QueryResult.Record();
            record.add(rdf.getSubject());
            record.add(rdf.getPredicate());
            record.add(rdf.getObject());
            records.add(record);
        }
        QueryResult queryResult = new QueryResult();
        queryResult.setRecords(records);
        return queryResult;
    }

    Set<RDF> filter(Set<RDF> rdfs, QueryCondition queryCondition) {
        Map<RDF, Boolean> filteredRdfsMap = new HashMap<>();
        for (RDF rdf : rdfs) {
            filteredRdfsMap.put(rdf, true);
        }
        for (RDF rdf : rdfs) {
            if (null != queryCondition.getSubject()) {
                if (!queryCondition.getSubject().isVariable()) {
                    if (!rdf.getSubject().equals(queryCondition.getSubject().getValue())) {
                        filteredRdfsMap.put(rdf, false);
                    }
                }
            }
        }
        for (RDF rdf : filteredRdfsMap.keySet()) {
            if (null != queryCondition.getPredicate()) {
                if (!queryCondition.getPredicate().isVariable()) {
                    if (!rdf.getPredicate().equals(queryCondition.getPredicate().getValue())) {
                        filteredRdfsMap.put(rdf, false);
                    }
                }
            }
        }
        for (RDF rdf : filteredRdfsMap.keySet()) {
            if (null != queryCondition.getObject()) {
                if (!queryCondition.getObject().isVariable()) {
                    if (!rdf.getObject().equals(queryCondition.getObject().getValue())) {
                        filteredRdfsMap.put(rdf, false);
                    }
                }
            }
        }
        Set<RDF> filteredRdfs = new HashSet<>();
        for (Map.Entry<RDF, Boolean> rdfEntry : filteredRdfsMap.entrySet()) {
            if (rdfEntry.getValue()) {
                filteredRdfs.add(rdfEntry.getKey());
            }
        }
        return filteredRdfs;
    }

}
