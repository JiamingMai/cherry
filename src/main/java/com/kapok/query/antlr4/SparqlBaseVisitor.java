package com.kapok.query.antlr4;// Generated from sparql.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;

public class SparqlBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SparqlVisitor<T> {
	@Override public T visitWhereItem(SparqlParser.WhereItemContext ctx) { return visitChildren(ctx); }

	@Override public T visitObjectItem(SparqlParser.ObjectItemContext ctx) { return visitChildren(ctx); }

	@Override public T visitPredicateItem(SparqlParser.PredicateItemContext ctx) { return visitChildren(ctx); }

	@Override public T visitQuery(SparqlParser.QueryContext ctx) { return visitChildren(ctx); }

	@Override public T visitSelectItem(SparqlParser.SelectItemContext ctx) { return visitChildren(ctx); }

	@Override public T visitSubjectItem(SparqlParser.SubjectItemContext ctx) { return visitChildren(ctx); }

	@Override public T visitRelation(SparqlParser.RelationContext ctx) { return visitChildren(ctx); }
}