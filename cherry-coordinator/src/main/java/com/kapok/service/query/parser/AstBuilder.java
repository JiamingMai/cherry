package com.kapok.service.query.parser;

import com.kapok.service.query.antlr4.SparqlBaseVisitor;
import com.kapok.service.query.antlr4.SparqlParser;
import com.kapok.service.query.ast.*;

import java.util.ArrayList;
import java.util.List;

public class AstBuilder extends SparqlBaseVisitor<Element> {

    @Override
    public Element visitQuery(SparqlParser.QueryContext ctx) {
        Query query = new Query();

        // build SELECT node
        Select select = new Select();
        List<Field> fields = new ArrayList<>();
        List<SparqlParser.SelectItemContext> selectItems = ctx.selectItem();
        for (int i = 0; i < selectItems.size(); i++) {
            SparqlParser.SelectItemContext selectItemContext = selectItems.get(i);
            Element field = selectItemContext.accept(this);
            fields.add((Field) field);
        }
        select.setSelectItems(fields);
        query.setSelect(select);

        // build FROM node
        Element from = ctx.relation().accept(this);
        query.setFrom((From) from);

        // build WHERE node
        Element where = ctx.whereItem().accept(this);
        query.setWhere((Where) where);

        return query;
    }

    @Override
    public Element visitSelectItem(SparqlParser.SelectItemContext ctx) {
        Field field = new Field();
        field.setValue(ctx.IDENTIFIER().getText());
        return field;
    }

    @Override
    public Element visitRelation(SparqlParser.RelationContext ctx) {
        From from = new From();
        Field field = new Field();
        field.setValue(ctx.DEFAULT_RELATION().getText());
        from.setRelationName(field);
        return from;
    }

    @Override
    public Element visitWhereItem(SparqlParser.WhereItemContext ctx) {
        Where where = new Where();
        List<WhereCondition> whereConditions = new ArrayList<>();
        List<SparqlParser.WhereConditionContext> whereConditionContexts = ctx.whereCondition();
        for (SparqlParser.WhereConditionContext whereConditionContext : whereConditionContexts) {
            Field subjectField;
            Field predicateField;
            Field objectField;
            if (null != whereConditionContext.subjectItem().constString()) {
                subjectField = new Field(whereConditionContext.subjectItem().constString().IDENTIFIER().getText());
            } else {
                subjectField = new VariableField(whereConditionContext.subjectItem().variable().IDENTIFIER().getText());
            }
            if (null != whereConditionContext.predicateItem().constString()) {
                predicateField = new Field(whereConditionContext.predicateItem().constString().IDENTIFIER().getText());
            } else {
                predicateField = new VariableField(whereConditionContext.predicateItem().variable().IDENTIFIER().getText());
            }
            if (null != whereConditionContext.objectItem().constString()) {
                objectField = new Field(whereConditionContext.objectItem().constString().IDENTIFIER().getText());
            } else {
                objectField = new VariableField(whereConditionContext.objectItem().variable().IDENTIFIER().getText());
            }
            WhereCondition whereCondition = new WhereCondition();
            whereCondition.setSubjectVariable(subjectField);
            whereCondition.setPredicateVariable(predicateField);
            whereCondition.setObjectVariable(objectField);
            whereConditions.add(whereCondition);
        }
        where.setWhereConditions(whereConditions);
        return where;
    }
}
