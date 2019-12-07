package com.kapok.service.query.antlr4;// Generated from sparql.g4 by ANTLR 4.0
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
		BRACE_OPEN=7, BRACE_CLOSE=8, DOT=9, IDENTIFIER=10, SIMPLE_COMMENT=11, 
		BRACKETED_COMMENT=12, WS=13, UNRECOGNIZED=14;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'SELECT'", "'FROM'", "'WHERE'", "'<http://www.kapok.com>'", 
		"'?'", "'{'", "'}'", "'.'", "IDENTIFIER", "SIMPLE_COMMENT", "BRACKETED_COMMENT", 
		"WS", "UNRECOGNIZED"
	};
	public static final int
		RULE_query = 0, RULE_selectItem = 1, RULE_whereItem = 2, RULE_whereCondition = 3, 
		RULE_subjectItem = 4, RULE_predicateItem = 5, RULE_objectItem = 6, RULE_constString = 7, 
		RULE_variable = 8, RULE_relation = 9;
	public static final String[] ruleNames = {
		"query", "selectItem", "whereItem", "whereCondition", "subjectItem", "predicateItem", 
		"objectItem", "constString", "variable", "relation"
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
			setState(20); match(SELECT);
			setState(21); selectItem();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(22); match(1);
				setState(23); selectItem();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(29); match(FROM);
				setState(30); relation();
				}
			}

			setState(35);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(33); match(WHERE);
				setState(34); whereItem();
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
			setState(37); match(QUESTION_MARK);
			setState(38); match(IDENTIFIER);
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
		public List<WhereConditionContext> whereCondition() {
			return getRuleContexts(WhereConditionContext.class);
		}
		public WhereConditionContext whereCondition(int i) {
			return getRuleContext(WhereConditionContext.class,i);
		}
		public TerminalNode BRACE_CLOSE() { return getToken(SparqlParser.BRACE_CLOSE, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); match(BRACE_OPEN);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QUESTION_MARK || _la==IDENTIFIER) {
				{
				{
				setState(41); whereCondition();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47); match(BRACE_CLOSE);
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

	public static class WhereConditionContext extends ParserRuleContext {
		public ObjectItemContext objectItem() {
			return getRuleContext(ObjectItemContext.class,0);
		}
		public PredicateItemContext predicateItem() {
			return getRuleContext(PredicateItemContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SparqlParser.DOT, 0); }
		public SubjectItemContext subjectItem() {
			return getRuleContext(SubjectItemContext.class,0);
		}
		public WhereConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterWhereCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitWhereCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitWhereCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereConditionContext whereCondition() throws RecognitionException {
		WhereConditionContext _localctx = new WhereConditionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whereCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); subjectItem();
			setState(50); predicateItem();
			setState(51); objectItem();
			setState(52); match(DOT);
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
		public ConstStringContext constString() {
			return getRuleContext(ConstStringContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_subjectItem);
		try {
			setState(56);
			switch (_input.LA(1)) {
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); variable();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); constString();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public ConstStringContext constString() {
			return getRuleContext(ConstStringContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 10, RULE_predicateItem);
		try {
			setState(60);
			switch (_input.LA(1)) {
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 1);
				{
				setState(58); variable();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); constString();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public ConstStringContext constString() {
			return getRuleContext(ConstStringContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_objectItem);
		try {
			setState(64);
			switch (_input.LA(1)) {
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 1);
				{
				setState(62); variable();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(63); constString();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConstStringContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SparqlParser.IDENTIFIER, 0); }
		public ConstStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterConstString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitConstString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitConstString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstStringContext constString() throws RecognitionException {
		ConstStringContext _localctx = new ConstStringContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(IDENTIFIER);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode QUESTION_MARK() { return getToken(SparqlParser.QUESTION_MARK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SparqlParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener) ((SparqlListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparqlVisitor) return ((SparqlVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(QUESTION_MARK);
			setState(69); match(IDENTIFIER);
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
		enterRule(_localctx, 18, RULE_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); match(DEFAULT_RELATION);
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
		"\2\3\20L\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\3\2\3\2\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\3"+
		"\2\5\2\"\n\2\3\2\3\2\5\2&\n\2\3\3\3\3\3\3\3\4\3\4\7\4-\n\4\f\4\16\4\60"+
		"\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6;\n\6\3\7\3\7\5\7?\n\7\3"+
		"\b\3\b\5\bC\n\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\2\f\2\4\6\b\n\f\16"+
		"\20\22\24\2\2H\2\26\3\2\2\2\4\'\3\2\2\2\6*\3\2\2\2\b\63\3\2\2\2\n:\3\2"+
		"\2\2\f>\3\2\2\2\16B\3\2\2\2\20D\3\2\2\2\22F\3\2\2\2\24I\3\2\2\2\26\27"+
		"\7\4\2\2\27\34\5\4\3\2\30\31\7\3\2\2\31\33\5\4\3\2\32\30\3\2\2\2\33\36"+
		"\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35!\3\2\2\2\36\34\3\2\2\2\37 \7\5"+
		"\2\2 \"\5\24\13\2!\37\3\2\2\2!\"\3\2\2\2\"%\3\2\2\2#$\7\6\2\2$&\5\6\4"+
		"\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'(\7\b\2\2()\7\f\2\2)\5\3\2\2\2*.\7"+
		"\t\2\2+-\5\b\5\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2"+
		"\60.\3\2\2\2\61\62\7\n\2\2\62\7\3\2\2\2\63\64\5\n\6\2\64\65\5\f\7\2\65"+
		"\66\5\16\b\2\66\67\7\13\2\2\67\t\3\2\2\28;\5\22\n\29;\5\20\t\2:8\3\2\2"+
		"\2:9\3\2\2\2;\13\3\2\2\2<?\5\22\n\2=?\5\20\t\2><\3\2\2\2>=\3\2\2\2?\r"+
		"\3\2\2\2@C\5\22\n\2AC\5\20\t\2B@\3\2\2\2BA\3\2\2\2C\17\3\2\2\2DE\7\f\2"+
		"\2E\21\3\2\2\2FG\7\b\2\2GH\7\f\2\2H\23\3\2\2\2IJ\7\7\2\2J\25\3\2\2\2\t"+
		"\34!%.:>B";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}