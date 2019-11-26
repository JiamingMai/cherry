package com.kapok.query.antlr4;// Generated from sparql.g4 by ANTLR 4.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SparqlLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SELECT=2, FROM=3, WHERE=4, DEFAULT_RELATION=5, QUESTION_MARK=6, 
		BRACE_OPEN=7, BRACE_CLOSE=8, DOT=9, IDENTIFIER=10, SIMPLE_COMMENT=11, 
		BRACKETED_COMMENT=12, WS=13, UNRECOGNIZED=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'SELECT'", "'FROM'", "'WHERE'", "'<http://www.kapok.com>'", "'?'", 
		"'{'", "'}'", "'.'", "IDENTIFIER", "SIMPLE_COMMENT", "BRACKETED_COMMENT", 
		"WS", "UNRECOGNIZED"
	};
	public static final String[] ruleNames = {
		"T__0", "SELECT", "FROM", "WHERE", "DEFAULT_RELATION", "QUESTION_MARK", 
		"BRACE_OPEN", "BRACE_CLOSE", "DOT", "IDENTIFIER", "DIGIT", "LETTER", "SIMPLE_COMMENT", 
		"BRACKETED_COMMENT", "WS", "UNRECOGNIZED"
	};


	public SparqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "sparql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 12: SIMPLE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 13: BRACKETED_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 14: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void BRACKETED_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = HIDDEN;  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: _channel = HIDDEN;  break;
		}
	}
	private void SIMPLE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\20\u008e\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\5\13Y\n\13\3\13\3\13\3\13\7\13^\n\13\f\13\16\13a"+
		"\13\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\7\16k\n\16\f\16\16\16n\13\16"+
		"\3\16\5\16q\n\16\3\16\5\16t\n\16\3\16\3\16\3\17\3\17\3\17\3\17\7\17|\n"+
		"\17\f\17\16\17\177\13\17\3\17\3\17\3\17\3\17\3\17\3\20\6\20\u0087\n\20"+
		"\r\20\16\20\u0088\3\20\3\20\3\21\3\21\3}\22\3\3\1\5\4\1\7\5\1\t\6\1\13"+
		"\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\2\1\31\2\1\33\r\2\35\16\3\37"+
		"\17\4!\20\1\3\2\7\5<<BBaa\3\62;\4C\\c|\4\f\f\17\17\5\13\f\17\17\"\"\u0094"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7,\3\2\2\2"+
		"\t\61\3\2\2\2\13\67\3\2\2\2\rN\3\2\2\2\17P\3\2\2\2\21R\3\2\2\2\23T\3\2"+
		"\2\2\25X\3\2\2\2\27b\3\2\2\2\31d\3\2\2\2\33f\3\2\2\2\35w\3\2\2\2\37\u0086"+
		"\3\2\2\2!\u008c\3\2\2\2#$\7.\2\2$\4\3\2\2\2%&\7U\2\2&\'\7G\2\2\'(\7N\2"+
		"\2()\7G\2\2)*\7E\2\2*+\7V\2\2+\6\3\2\2\2,-\7H\2\2-.\7T\2\2./\7Q\2\2/\60"+
		"\7O\2\2\60\b\3\2\2\2\61\62\7Y\2\2\62\63\7J\2\2\63\64\7G\2\2\64\65\7T\2"+
		"\2\65\66\7G\2\2\66\n\3\2\2\2\678\7>\2\289\7j\2\29:\7v\2\2:;\7v\2\2;<\7"+
		"r\2\2<=\7<\2\2=>\7\61\2\2>?\7\61\2\2?@\7y\2\2@A\7y\2\2AB\7y\2\2BC\7\60"+
		"\2\2CD\7m\2\2DE\7c\2\2EF\7r\2\2FG\7q\2\2GH\7m\2\2HI\7\60\2\2IJ\7e\2\2"+
		"JK\7q\2\2KL\7o\2\2LM\7@\2\2M\f\3\2\2\2NO\7A\2\2O\16\3\2\2\2PQ\7}\2\2Q"+
		"\20\3\2\2\2RS\7\177\2\2S\22\3\2\2\2TU\7\60\2\2U\24\3\2\2\2VY\5\31\r\2"+
		"WY\7a\2\2XV\3\2\2\2XW\3\2\2\2Y_\3\2\2\2Z^\5\31\r\2[^\5\27\f\2\\^\t\2\2"+
		"\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\26\3"+
		"\2\2\2a_\3\2\2\2bc\t\3\2\2c\30\3\2\2\2de\t\4\2\2e\32\3\2\2\2fg\7/\2\2"+
		"gh\7/\2\2hl\3\2\2\2ik\n\5\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2"+
		"mp\3\2\2\2nl\3\2\2\2oq\7\17\2\2po\3\2\2\2pq\3\2\2\2qs\3\2\2\2rt\7\f\2"+
		"\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\b\16\2\2v\34\3\2\2\2wx\7\61\2\2xy\7"+
		",\2\2y}\3\2\2\2z|\13\2\2\2{z\3\2\2\2|\177\3\2\2\2}~\3\2\2\2}{\3\2\2\2"+
		"~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7,\2\2\u0081\u0082\7\61\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\b\17\3\2\u0084\36\3\2\2\2\u0085\u0087\t\6\2"+
		"\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\20\4\2\u008b \3\2\2\2\u008c"+
		"\u008d\13\2\2\2\u008d\"\3\2\2\2\13\2X]_lps}\u0088";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}