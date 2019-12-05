package com.kapok.service.query.antlr4;// Generated from sparql.g4 by ANTLR 4.0

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class SparqlBaseListener implements SparqlListener {
	@Override public void enterConstString(SparqlParser.ConstStringContext ctx) { }
	@Override public void exitConstString(SparqlParser.ConstStringContext ctx) { }

	@Override public void enterWhereCondition(SparqlParser.WhereConditionContext ctx) { }
	@Override public void exitWhereCondition(SparqlParser.WhereConditionContext ctx) { }

	@Override public void enterWhereItem(SparqlParser.WhereItemContext ctx) { }
	@Override public void exitWhereItem(SparqlParser.WhereItemContext ctx) { }

	@Override public void enterObjectItem(SparqlParser.ObjectItemContext ctx) { }
	@Override public void exitObjectItem(SparqlParser.ObjectItemContext ctx) { }

	@Override public void enterPredicateItem(SparqlParser.PredicateItemContext ctx) { }
	@Override public void exitPredicateItem(SparqlParser.PredicateItemContext ctx) { }

	@Override public void enterQuery(SparqlParser.QueryContext ctx) { }
	@Override public void exitQuery(SparqlParser.QueryContext ctx) { }

	@Override public void enterSelectItem(SparqlParser.SelectItemContext ctx) { }
	@Override public void exitSelectItem(SparqlParser.SelectItemContext ctx) { }

	@Override public void enterVariable(SparqlParser.VariableContext ctx) { }
	@Override public void exitVariable(SparqlParser.VariableContext ctx) { }

	@Override public void enterSubjectItem(SparqlParser.SubjectItemContext ctx) { }
	@Override public void exitSubjectItem(SparqlParser.SubjectItemContext ctx) { }

	@Override public void enterRelation(SparqlParser.RelationContext ctx) { }
	@Override public void exitRelation(SparqlParser.RelationContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}