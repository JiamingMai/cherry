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
		BRACE_OPEN=7, BRACE_CLOSE=8, IDENTIFIER=9, SIMPLE_COMMENT=10, BRACKETED_COMMENT=11, 
		WS=12, UNRECOGNIZED=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'SELECT'", "'FROM'", "'WHERE'", "'<http://www.kapok.com>'", "'?'", 
		"'{'", "'}'", "IDENTIFIER", "SIMPLE_COMMENT", "BRACKETED_COMMENT", "WS", 
		"UNRECOGNIZED"
	};
	public static final String[] ruleNames = {
		"T__0", "SELECT", "FROM", "WHERE", "DEFAULT_RELATION", "QUESTION_MARK", 
		"BRACE_OPEN", "BRACE_CLOSE", "IDENTIFIER", "DIGIT", "LETTER", "SIMPLE_COMMENT", 
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
		case 11: SIMPLE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 12: BRACKETED_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 13: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\17\u008a\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\5\nU\n\n\3\n\3\n\3\n\7\nZ\n\n\f\n\16\n]\13\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\7\rg\n\r\f\r\16\rj\13\r\3\r\5\rm\n\r\3\r\5\rp\n\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\7\16x\n\16\f\16\16\16{\13\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\6\17\u0083\n\17\r\17\16\17\u0084\3\17\3\17\3\20\3\20\3y\21\3"+
		"\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\2\1\27\2"+
		"\1\31\f\2\33\r\3\35\16\4\37\17\1\3\2\7\5<<BBaa\3\62;\4C\\c|\4\f\f\17\17"+
		"\5\13\f\17\17\"\"\u0090\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2"+
		"\7*\3\2\2\2\t/\3\2\2\2\13\65\3\2\2\2\rL\3\2\2\2\17N\3\2\2\2\21P\3\2\2"+
		"\2\23T\3\2\2\2\25^\3\2\2\2\27`\3\2\2\2\31b\3\2\2\2\33s\3\2\2\2\35\u0082"+
		"\3\2\2\2\37\u0088\3\2\2\2!\"\7.\2\2\"\4\3\2\2\2#$\7U\2\2$%\7G\2\2%&\7"+
		"N\2\2&\'\7G\2\2\'(\7E\2\2()\7V\2\2)\6\3\2\2\2*+\7H\2\2+,\7T\2\2,-\7Q\2"+
		"\2-.\7O\2\2.\b\3\2\2\2/\60\7Y\2\2\60\61\7J\2\2\61\62\7G\2\2\62\63\7T\2"+
		"\2\63\64\7G\2\2\64\n\3\2\2\2\65\66\7>\2\2\66\67\7j\2\2\678\7v\2\289\7"+
		"v\2\29:\7r\2\2:;\7<\2\2;<\7\61\2\2<=\7\61\2\2=>\7y\2\2>?\7y\2\2?@\7y\2"+
		"\2@A\7\60\2\2AB\7m\2\2BC\7c\2\2CD\7r\2\2DE\7q\2\2EF\7m\2\2FG\7\60\2\2"+
		"GH\7e\2\2HI\7q\2\2IJ\7o\2\2JK\7@\2\2K\f\3\2\2\2LM\7A\2\2M\16\3\2\2\2N"+
		"O\7}\2\2O\20\3\2\2\2PQ\7\177\2\2Q\22\3\2\2\2RU\5\27\f\2SU\7a\2\2TR\3\2"+
		"\2\2TS\3\2\2\2U[\3\2\2\2VZ\5\27\f\2WZ\5\25\13\2XZ\t\2\2\2YV\3\2\2\2YW"+
		"\3\2\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\24\3\2\2\2][\3\2\2"+
		"\2^_\t\3\2\2_\26\3\2\2\2`a\t\4\2\2a\30\3\2\2\2bc\7/\2\2cd\7/\2\2dh\3\2"+
		"\2\2eg\n\5\2\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2il\3\2\2\2jh\3\2"+
		"\2\2km\7\17\2\2lk\3\2\2\2lm\3\2\2\2mo\3\2\2\2np\7\f\2\2on\3\2\2\2op\3"+
		"\2\2\2pq\3\2\2\2qr\b\r\2\2r\32\3\2\2\2st\7\61\2\2tu\7,\2\2uy\3\2\2\2v"+
		"x\13\2\2\2wv\3\2\2\2x{\3\2\2\2yz\3\2\2\2yw\3\2\2\2z|\3\2\2\2{y\3\2\2\2"+
		"|}\7,\2\2}~\7\61\2\2~\177\3\2\2\2\177\u0080\b\16\3\2\u0080\34\3\2\2\2"+
		"\u0081\u0083\t\6\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\b\17\4\2"+
		"\u0087\36\3\2\2\2\u0088\u0089\13\2\2\2\u0089 \3\2\2\2\13\2TY[hloy\u0084";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}