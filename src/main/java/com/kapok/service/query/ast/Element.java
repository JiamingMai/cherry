package com.kapok.service.query.ast;

import com.kapok.service.query.parser.AstVisitor;

public interface Element {

    <T> T accept(AstVisitor<T> visitor);
}
