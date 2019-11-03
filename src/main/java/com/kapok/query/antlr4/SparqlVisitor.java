package com.kapok.query.antlr4;// Generated from sparql.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;

public interface SparqlVisitor<T> extends ParseTreeVisitor<T> {
	T visitWhereItem(SparqlParser.WhereItemContext ctx);

	T visitObjectItem(SparqlParser.ObjectItemContext ctx);

	T visitPredicateItem(SparqlParser.PredicateItemContext ctx);

	T visitQuery(SparqlParser.QueryContext ctx);

	T visitSelectItem(SparqlParser.SelectItemContext ctx);

	T visitSubjectItem(SparqlParser.SubjectItemContext ctx);

	T visitRelation(SparqlParser.RelationContext ctx);
}