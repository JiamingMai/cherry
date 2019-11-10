package com.kapok.query.ast;

import com.kapok.query.parser.AstVisitor;

public interface Element {

    <T> T accept(AstVisitor<T> visitor);
}
