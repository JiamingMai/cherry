grammar sparql;


query
    : SELECT selectItem (',' selectItem)*
      (FROM relation)?
      (WHERE whereItem)?
    ;

selectItem
    : QUESTION_MARK IDENTIFIER
    ;

whereItem
    : BRACE_OPEN subjectItem predicateItem objectItem BRACE_CLOSE
    ;

subjectItem
    : QUESTION_MARK IDENTIFIER
    ;

predicateItem
    : QUESTION_MARK IDENTIFIER
    ;

objectItem
    : QUESTION_MARK IDENTIFIER
    ;

relation
    : DEFAULT_RELATION
    ;

SELECT: 'SELECT';
FROM: 'FROM';
WHERE: 'WHERE';
DEFAULT_RELATION: '<http://www.kapok.com>';
QUESTION_MARK: '?';
BRACE_OPEN: '{';
BRACE_CLOSE: '}';

IDENTIFIER
    : (LETTER | '_') (LETTER | DIGIT | '_' | '@' | ':')*
    ;

fragment DIGIT
    : [0-9]
    ;

fragment LETTER
    : [A-Z]
    ;

SIMPLE_COMMENT
    : '--' ~[\r\n]* '\r'? '\n'? -> channel(HIDDEN)
    ;

BRACKETED_COMMENT
    : '/*' .*? '*/' -> channel(HIDDEN)
    ;

WS
    : [ \r\n\t]+ -> channel(HIDDEN)
    ;

// Catch-all for anything we can't recognize.
// We use this to be able to ignore and recover all the text
// when splitting statements with DelimiterLexer
UNRECOGNIZED
    : .
    ;