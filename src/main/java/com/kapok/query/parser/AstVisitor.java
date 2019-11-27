package com.kapok.query.parser;

import com.kapok.query.ast.*;

public interface AstVisitor<T> {

    T visit(Query query);

    T visit(Select select);

    T visit(From from);

    T visit(Where where);

    T visit(WhereCondition whereCondition);

    T visit(Field field);

}
