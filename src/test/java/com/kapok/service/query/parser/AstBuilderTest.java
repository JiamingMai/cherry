package com.kapok.service.query.parser;

import com.kapok.service.query.antlr4.SparqlLexer;
import com.kapok.service.query.antlr4.SparqlParser;
import com.kapok.service.query.ast.Query;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class AstBuilderTest {

    @Test
    public void testAstBuilder() throws Exception {
        String sparql = "SELECT ?s FROM <http://www.kapok.com> WHERE {?s ?p ?o}";
        ANTLRInputStream input = new ANTLRInputStream(new ByteArrayInputStream(sparql.getBytes()));
        SparqlLexer lexer = new SparqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SparqlParser parser = new SparqlParser(tokens);
        SparqlParser.QueryContext queryContext = parser.query();
        Query query = (Query) queryContext.accept(new AstBuilder());
        System.out.println(query);
    }

}
