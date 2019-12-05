package com.kapok.service.query.antlr4;// Generated from sparql.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;

public interface SparqlListener extends ParseTreeListener {
	void enterConstString(SparqlParser.ConstStringContext ctx);
	void exitConstString(SparqlParser.ConstStringContext ctx);

	void enterWhereCondition(SparqlParser.WhereConditionContext ctx);
	void exitWhereCondition(SparqlParser.WhereConditionContext ctx);

	void enterWhereItem(SparqlParser.WhereItemContext ctx);
	void exitWhereItem(SparqlParser.WhereItemContext ctx);

	void enterObjectItem(SparqlParser.ObjectItemContext ctx);
	void exitObjectItem(SparqlParser.ObjectItemContext ctx);

	void enterPredicateItem(SparqlParser.PredicateItemContext ctx);
	void exitPredicateItem(SparqlParser.PredicateItemContext ctx);

	void enterQuery(SparqlParser.QueryContext ctx);
	void exitQuery(SparqlParser.QueryContext ctx);

	void enterSelectItem(SparqlParser.SelectItemContext ctx);
	void exitSelectItem(SparqlParser.SelectItemContext ctx);

	void enterVariable(SparqlParser.VariableContext ctx);
	void exitVariable(SparqlParser.VariableContext ctx);

	void enterSubjectItem(SparqlParser.SubjectItemContext ctx);
	void exitSubjectItem(SparqlParser.SubjectItemContext ctx);

	void enterRelation(SparqlParser.RelationContext ctx);
	void exitRelation(SparqlParser.RelationContext ctx);
}