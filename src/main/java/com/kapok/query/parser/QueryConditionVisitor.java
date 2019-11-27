package com.kapok.query.parser;

import com.kapok.query.ConditionItem;
import com.kapok.query.QueryCondition;
import com.kapok.query.ast.*;

import java.util.List;

public class QueryConditionVisitor implements AstVisitor<QueryCondition> {

    @Override
    public QueryCondition visit(Query query) {
        QueryCondition queryCondition = query.getWhere().accept(this);
        for (Field selectItem : query.getSelect().getSelectItems()) {
            ConditionItem subjectCondtionItem = queryCondition.getSubject();
            ConditionItem predicateConditionItem = queryCondition.getPredicate();
            ConditionItem objectCondtionItem = queryCondition.getObject();
            if (subjectCondtionItem.isVariable()) {
                if (subjectCondtionItem.getValue().equals(selectItem.getValue())) {
                    queryCondition.getVariables().add(subjectCondtionItem.getValue());
                }
            }
            if (predicateConditionItem.isVariable()) {
                if (predicateConditionItem.getValue().equals(selectItem.getValue())) {
                    queryCondition.getVariables().add(predicateConditionItem.getValue());
                }
            }
            if (objectCondtionItem.isVariable()) {
                if (objectCondtionItem.getValue().equals(selectItem.getValue())) {
                    queryCondition.getVariables().add(objectCondtionItem.getValue());
                }
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
        QueryCondition queryCondition = new QueryCondition();
        List<WhereCondition> whereConditions = where.getWhereConditions();
        for (WhereCondition condition : whereConditions) {
            // set subject condition
            Field subject = condition.getSubjectVariable();
            ConditionItem subjectItem = new ConditionItem();
            subjectItem.setValue(subject.getValue());
            if (subject instanceof VariableField) {
                subjectItem.setVariable(true);
            } else {
                subjectItem.setVariable(false);
            }
            queryCondition.setSubject(subjectItem);

            // set predicate condition
            Field predicate = condition.getPredicateVariable();
            ConditionItem predicateItem = new ConditionItem();
            predicateItem.setValue(predicate.getValue());
            if (predicate instanceof VariableField) {
                predicateItem.setVariable(true);
            } else {
                predicateItem.setVariable(false);
            }
            queryCondition.setPredicate(predicateItem);

            // set object condition
            Field object = condition.getObjectVariable();
            ConditionItem objectItem = new ConditionItem();
            objectItem.setValue(object.getValue());
            if (object instanceof VariableField) {
                objectItem.setVariable(true);
            } else {
                objectItem.setVariable(false);
            }
            queryCondition.setObject(objectItem);
        }
        return queryCondition;
    }

    @Override
    public QueryCondition visit(WhereCondition whereCondition) {
        // no need to implement this method
        return null;
    }

    @Override
    public QueryCondition visit(Field field) {
        // no need to implement this method
        return null;
    }
}
