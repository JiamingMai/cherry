package com.kapok.query.parser;

import com.kapok.query.QueryCondition;
import com.kapok.query.ast.*;

public class QueryConditionVisitor implements AstVisitor<QueryCondition> {

    @Override
    public QueryCondition visit(Query query) {
        QueryCondition whereCondition = query.getWhere().accept(this);
        QueryCondition queryCondition = new QueryCondition();
        if (null != whereCondition) {
            queryCondition.setSubject(whereCondition.getSubject());
            queryCondition.setPredicate(whereCondition.getPredicate());
            queryCondition.setObject(whereCondition.getObject());
        }
        for (Field selectItem : query.getSelect().getSelectItems()) {
            if (queryCondition.getSubject().equals(selectItem.getValue())) {
                queryCondition.setShowSubject(true);
            }
            if (queryCondition.getPredicate().equals(selectItem.getValue())) {
                queryCondition.setShowPredicate(true);
            }
            if (queryCondition.getObject().equals(selectItem.getValue())) {
                queryCondition.setShowObject(true);
            }
        }
        return queryCondition;
    }

    @Override
    public QueryCondition visit(Select select) {
        return null;
    }

    @Override
    public QueryCondition visit(From from) {
        return null;
    }

    @Override
    public QueryCondition visit(Where where) {
        QueryCondition whereCondition = new QueryCondition();
        whereCondition.setSubject(where.getSubjectVariable().getValue());
        whereCondition.setPredicate(where.getPredicateVariable().getValue());
        whereCondition.setObject(where.getObjectVariable().getValue());
        return whereCondition;
    }

    @Override
    public QueryCondition visit(Field field) {
        return null;
    }
}
