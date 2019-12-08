package com.kapok.service.query;

import com.kapok.model.discovery.Node;
import com.kapok.model.query.QueryResult;
import com.kapok.model.query.Record;
import com.kapok.model.store.HyperGraph;
import com.kapok.model.store.RDF;
import com.kapok.service.discovery.HttpCommandUtil;
import com.kapok.service.discovery.NodeManager;
import com.kapok.service.query.antlr4.SparqlLexer;
import com.kapok.service.query.antlr4.SparqlParser;
import com.kapok.service.query.ast.Query;
import com.kapok.service.query.parser.AstBuilder;
import com.kapok.service.query.parser.QueryConditionVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class QueryEngine {

    @Autowired
    private NodeManager nodeManager;

    public QueryEngine() {
    }

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
            HyperGraph hyperGraph = HttpCommandUtil.sendLoadRdfsCommand(node);
            rdfs.addAll(node.getStorageManager().filter(hyperGraph));
        }
        return convert(rdfs, queryCondition);
    }

    private QueryResult convert(Set<RDF> rdfs, QueryCondition queryCondition) {
        rdfs = filter(rdfs, queryCondition);

        List<Record> records = new ArrayList<>();
        for (RDF rdf : rdfs) {
            Record record = new Record();
            record.add(rdf.getSubject());
            record.add(rdf.getPredicate());
            record.add(rdf.getObject());
            records.add(record);
        }
        QueryResult queryResult = new QueryResult();
        queryResult.setRecords(records);
        queryResult.setReadableResult(queryResult.toString());
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
