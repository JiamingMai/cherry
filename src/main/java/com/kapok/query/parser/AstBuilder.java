package com.kapok.query.parser;

import com.kapok.query.antlr4.SparqlBaseVisitor;
import com.kapok.query.antlr4.SparqlParser;
import com.kapok.query.ast.*;

import java.util.ArrayList;
import java.util.List;

public class AstBuilder extends SparqlBaseVisitor<Node> {

    @Override
    public Node visitQuery(SparqlParser.QueryContext ctx) {
        Query query = new Query();

        // build SELECT node
        Select select = new Select();
        List<Field> fields = new ArrayList<>();
        List<SparqlParser.SelectItemContext> selectItems = ctx.selectItem();
        for (int i = 0; i < selectItems.size(); i++) {
            SparqlParser.SelectItemContext selectItemContext = selectItems.get(i);
            Node field = selectItemContext.accept(this);
            fields.add((Field) field);
        }
        select.setSelectItems(fields);
        query.setSelect(select);

        // build FROM node
        Node from = ctx.relation().accept(this);
        query.setFrom((From) from);

        // build WHERE node
        Node where = ctx.whereItem().accept(this);
        query.setWhere((Where) where);

        return query;
    }

    @Override
    public Node visitSelectItem(SparqlParser.SelectItemContext ctx) {
        Field field = new Field();
        field.setValue(ctx.IDENTIFIER().getText());
        return field;
    }

    @Override
    public Node visitRelation(SparqlParser.RelationContext ctx) {
        From from = new From();
        Field field = new Field();
        field.setValue(ctx.DEFAULT_RELATION().getText());
        from.setRelationName(field);
        return from;
    }

    @Override
    public Node visitWhereItem(SparqlParser.WhereItemContext ctx) {
        Where where = new Where();
        Field subjectField = new Field(ctx.subjectItem().IDENTIFIER().getText());
        Field predicateField = new Field(ctx.predicateItem().IDENTIFIER().getText());
        Field objectField = new Field(ctx.objectItem().IDENTIFIER().getText());
        where.setSubjectVariable(subjectField);
        where.setPredicateVariable(predicateField);
        where.setObjectVariable(objectField);
        return where;
    }
}