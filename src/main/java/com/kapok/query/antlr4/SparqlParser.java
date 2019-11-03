package com.kapok.query.antlr4;// Generated from sparql.g4 by ANTLR 4.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SparqlParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SELECT=2, FROM=3, WHERE=4, DEFAULT_RELATION=5, QUESTION_MARK=6, 
		BRACE_OPEN=7, BRACE_CLOSE=8, IDENTIFIER=9, SIMPLE_COMMENT=10, BRACKETED_COMMENT=11, 
		WS=12, UNRECOGNIZED=13;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'SELECT'", "'FROM'", "'WHERE'", "'<http://www.kapok.com>'", 
		"'?'", "'{'", "'}'", "IDENTIFIER", "SIMPLE_COMMENT", "BRACKETED_COMMENT", 
		"WS", "UNRECOGNIZED"
	};
	public static final int
		RULE_query = 0, RULE_selectItem = 1, RULE_whereItem = 2, RULE_subjectItem = 3, 
		RULE_predicateItem = 4, RULE_objectItem = 5, RULE_relation = 6;
	public static final String[] ruleNames = {
		"query", "selectItem", "whereItem", "subjectItem", "predicateItem", "objectItem", 
		"relation"
	};

	@Override
	public String getGrammarFileName() { return "sparql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public SparqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public WhereItemContext whereItem() {
			return getRuleContext(WhereItemContext.class,0);
		}
		public SelectItemContext selectItem(int i) {
			return getRuleContext(SelectItemContext.class,i);
		}
		public List<SelectItemContext> selectItem() {
			return getRuleContexts(SelectItemContext.class);
		}
		public TerminalNode FROM() { return getToken(SparqlParser.FROM, 0); }
		public TerminalNode WHERE() { return getToken(SparqlParser.WHERE, 0); }
		public TerminalNode SELECT() { return getToken(SparqlParser.SELECT, 0); }
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); match(SELECT);
			setState(15); selectItem();
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(16); match(1);
				setState(17); selectItem();
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(23); match(FROM);
				setState(24); relation();
				}
			}

			setState(29);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(27); match(WHERE);
				setState(28); whereItem();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectItemContext extends ParserRuleContext {
		public TerminalNode QUESTION_MARK() { return getToken(SparqlParser.QUESTION_MARK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SparqlParser.IDENTIFIER, 0); }
		public SelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitSelectItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitSelectItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectItemContext selectItem() throws RecognitionException {
		SelectItemContext _localctx = new SelectItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); match(QUESTION_MARK);
			setState(32); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereItemContext extends ParserRuleContext {
		public TerminalNode BRACE_OPEN() { return getToken(SparqlParser.BRACE_OPEN, 0); }
		public ObjectItemContext objectItem() {
			return getRuleContext(ObjectItemContext.class,0);
		}
		public PredicateItemContext predicateItem() {
			return getRuleContext(PredicateItemContext.class,0);
		}
		public TerminalNode BRACE_CLOSE() { return getToken(SparqlParser.BRACE_CLOSE, 0); }
		public SubjectItemContext subjectItem() {
			return getRuleContext(SubjectItemContext.class,0);
		}
		public WhereItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterWhereItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitWhereItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitWhereItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereItemContext whereItem() throws RecognitionException {
		WhereItemContext _localctx = new WhereItemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_whereItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); match(BRACE_OPEN);
			setState(35); subjectItem();
			setState(36); predicateItem();
			setState(37); objectItem();
			setState(38); match(BRACE_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubjectItemContext extends ParserRuleContext {
		public TerminalNode QUESTION_MARK() { return getToken(SparqlParser.QUESTION_MARK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SparqlParser.IDENTIFIER, 0); }
		public SubjectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subjectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterSubjectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitSubjectItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitSubjectItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubjectItemContext subjectItem() throws RecognitionException {
		SubjectItemContext _localctx = new SubjectItemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_subjectItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); match(QUESTION_MARK);
			setState(41); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateItemContext extends ParserRuleContext {
		public TerminalNode QUESTION_MARK() { return getToken(SparqlParser.QUESTION_MARK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SparqlParser.IDENTIFIER, 0); }
		public PredicateItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterPredicateItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitPredicateItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitPredicateItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateItemContext predicateItem() throws RecognitionException {
		PredicateItemContext _localctx = new PredicateItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_predicateItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(QUESTION_MARK);
			setState(44); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectItemContext extends ParserRuleContext {
		public TerminalNode QUESTION_MARK() { return getToken(SparqlParser.QUESTION_MARK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SparqlParser.IDENTIFIER, 0); }
		public ObjectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterObjectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitObjectItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitObjectItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectItemContext objectItem() throws RecognitionException {
		ObjectItemContext _localctx = new ObjectItemContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_objectItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(QUESTION_MARK);
			setState(47); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public TerminalNode DEFAULT_RELATION() { return getToken(SparqlParser.DEFAULT_RELATION, 0); }
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); match(DEFAULT_RELATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\17\66\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2"+
		"\3\2\3\2\3\2\7\2\25\n\2\f\2\16\2\30\13\2\3\2\3\2\5\2\34\n\2\3\2\3\2\5"+
		"\2 \n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\2\t\2\4\6\b\n\f\16\2\2\61\2\20\3\2\2\2\4!\3\2\2"+
		"\2\6$\3\2\2\2\b*\3\2\2\2\n-\3\2\2\2\f\60\3\2\2\2\16\63\3\2\2\2\20\21\7"+
		"\4\2\2\21\26\5\4\3\2\22\23\7\3\2\2\23\25\5\4\3\2\24\22\3\2\2\2\25\30\3"+
		"\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\33\3\2\2\2\30\26\3\2\2\2\31\32\7"+
		"\5\2\2\32\34\5\16\b\2\33\31\3\2\2\2\33\34\3\2\2\2\34\37\3\2\2\2\35\36"+
		"\7\6\2\2\36 \5\6\4\2\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!\"\7\b\2\2\""+
		"#\7\13\2\2#\5\3\2\2\2$%\7\t\2\2%&\5\b\5\2&\'\5\n\6\2\'(\5\f\7\2()\7\n"+
		"\2\2)\7\3\2\2\2*+\7\b\2\2+,\7\13\2\2,\t\3\2\2\2-.\7\b\2\2./\7\13\2\2/"+
		"\13\3\2\2\2\60\61\7\b\2\2\61\62\7\13\2\2\62\r\3\2\2\2\63\64\7\7\2\2\64"+
		"\17\3\2\2\2\5\26\33\37";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}