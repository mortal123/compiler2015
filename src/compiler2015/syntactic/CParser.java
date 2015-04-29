// Generated from C.g4 by ANTLR 4.5

    package compiler2015.syntactic;
    import compiler2015.ast.*;
    import java.util.*;
 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, Whitespace=57, Multi_comment=58, 
		Single_comment=59, Preprocessing=60, Hex=61, Dec=62, Oct=63, CHARACTERLITERAL=64, 
		STRINGLITERAL=65, Identifier=66;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_function_definition = 2, 
		RULE_parameters = 3, RULE_declarators = 4, RULE_init_declarators = 5, 
		RULE_init_declarator = 6, RULE_initializer = 7, RULE_type_specifier = 8, 
		RULE_struct_or_union = 9, RULE_plain_declaration = 10, RULE_declarator = 11, 
		RULE_plain_declarator = 12, RULE_statement = 13, RULE_expression_statement = 14, 
		RULE_compound_statement = 15, RULE_selection_statement = 16, RULE_iteration_statement = 17, 
		RULE_jump_statement = 18, RULE_expression = 19, RULE_assignment_expression = 20, 
		RULE_assignment_operator = 21, RULE_constant_expression = 22, RULE_logical_or_expression = 23, 
		RULE_logical_and_expression = 24, RULE_inclusive_or_expression = 25, RULE_exclusive_or_expression = 26, 
		RULE_and_expression = 27, RULE_equality_expression = 28, RULE_equality_operator = 29, 
		RULE_relational_expression = 30, RULE_relational_operator = 31, RULE_shift_expression = 32, 
		RULE_shift_operator = 33, RULE_additive_expression = 34, RULE_additive_operator = 35, 
		RULE_multiplicative_expression = 36, RULE_multiplicative_operator = 37, 
		RULE_cast_expression = 38, RULE_type_name = 39, RULE_unary_expression = 40, 
		RULE_unary_operator = 41, RULE_postfix_expression = 42, RULE_postfix = 43, 
		RULE_arguments = 44, RULE_primary_expression = 45, RULE_integer_constant = 46, 
		RULE_character_constant = 47;
	public static final String[] ruleNames = {
		"program", "declaration", "function_definition", "parameters", "declarators", 
		"init_declarators", "init_declarator", "initializer", "type_specifier", 
		"struct_or_union", "plain_declaration", "declarator", "plain_declarator", 
		"statement", "expression_statement", "compound_statement", "selection_statement", 
		"iteration_statement", "jump_statement", "expression", "assignment_expression", 
		"assignment_operator", "constant_expression", "logical_or_expression", 
		"logical_and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"and_expression", "equality_expression", "equality_operator", "relational_expression", 
		"relational_operator", "shift_expression", "shift_operator", "additive_expression", 
		"additive_operator", "multiplicative_expression", "multiplicative_operator", 
		"cast_expression", "type_name", "unary_expression", "unary_operator", 
		"postfix_expression", "postfix", "arguments", "primary_expression", "integer_constant", 
		"character_constant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "','", "'='", "'{'", "'}'", "'void'", "'char'", 
		"'int'", "'struct'", "'union'", "'['", "']'", "'*'", "'if'", "'else'", 
		"'while'", "'for'", "'continue'", "'break'", "'return'", "'*='", "'/='", 
		"'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'||'", 
		"'&&'", "'|'", "'^'", "'&'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", 
		"'<<'", "'>>'", "'+'", "'-'", "'/'", "'%'", "'++'", "'--'", "'sizeof'", 
		"'~'", "'!'", "'.'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "Whitespace", "Multi_comment", 
		"Single_comment", "Preprocessing", "Hex", "Dec", "Oct", "CHARACTERLITERAL", 
		"STRINGLITERAL", "Identifier"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private List<Decl> curDecls;
	    private List<VarDecl> curFields;
	    private Type curType;
	    private int nAnonymous; 
	    private int postfixType;
	    private Expr postfixExpr;
	    private List<Expr> postfixArgs;
	    private Symbol postfixSymbol;
	    public final static int SPAN = 4;

	public CParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public AST ret;
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ProgramContext)_localctx).ret =  new AST();
			setState(101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(101);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					curDecls = _localctx.ret.decls; 
					setState(98);
					declaration();
					}
					break;
				case 2:
					{
					curDecls = _localctx.ret.decls; 
					setState(100);
					function_definition();
					}
					break;
				}
				}
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0) );
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

	public static class DeclarationContext extends ParserRuleContext {
		public Type_specifierContext ts;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Init_declaratorsContext init_declarators() {
			return getRuleContext(Init_declaratorsContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			((DeclarationContext)_localctx).ts = type_specifier();
			curType = ((DeclarationContext)_localctx).ts.ret;
			setState(108);
			_la = _input.LA(1);
			if (_la==T__14 || _la==Identifier) {
				{
				setState(107);
				init_declarators();
				}
			}

			setState(110);
			match(T__0);
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

	public static class Function_definitionContext extends ParserRuleContext {
		public Type_specifierContext ts;
		public Plain_declaratorContext pd;
		public ParametersContext pa;
		public Compound_statementContext cs;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Plain_declaratorContext plain_declarator() {
			return getRuleContext(Plain_declaratorContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitFunction_definition(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			List<VarDecl> params = new LinkedList<VarDecl>(); 
			setState(113);
			((Function_definitionContext)_localctx).ts = type_specifier();
			curType = ((Function_definitionContext)_localctx).ts.ret; 
			setState(115);
			((Function_definitionContext)_localctx).pd = plain_declarator();
			setState(116);
			match(T__1);
			setState(120);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				setState(117);
				((Function_definitionContext)_localctx).pa = parameters();
				params = ((Function_definitionContext)_localctx).pa.ret; 
				}
			}

			setState(122);
			match(T__2);
			setState(123);
			((Function_definitionContext)_localctx).cs = compound_statement();

			            curDecls.add(new FunctionDecl(((Function_definitionContext)_localctx).pd.ret.type, ((Function_definitionContext)_localctx).pd.ret.name, params, ((Function_definitionContext)_localctx).cs.ret));
			        
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

	public static class ParametersContext extends ParserRuleContext {
		public List<VarDecl> ret;
		public Plain_declarationContext fpd;
		public Plain_declarationContext spd;
		public List<Plain_declarationContext> plain_declaration() {
			return getRuleContexts(Plain_declarationContext.class);
		}
		public Plain_declarationContext plain_declaration(int i) {
			return getRuleContext(Plain_declarationContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ParametersContext)_localctx).ret =  new LinkedList<VarDecl>(); 
			setState(127);
			((ParametersContext)_localctx).fpd = plain_declaration();
			_localctx.ret.add(((ParametersContext)_localctx).fpd.ret); 
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(129);
				match(T__3);
				setState(130);
				((ParametersContext)_localctx).spd = plain_declaration();
				_localctx.ret.add(((ParametersContext)_localctx).spd.ret); 
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DeclaratorsContext extends ParserRuleContext {
		public DeclaratorContext d1;
		public DeclaratorContext d2;
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public DeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDeclarators(this);
		}
	}

	public final DeclaratorsContext declarators() throws RecognitionException {
		DeclaratorsContext _localctx = new DeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((DeclaratorsContext)_localctx).d1 = declarator();
			curFields.add(((DeclaratorsContext)_localctx).d1.ret); 
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(140);
				match(T__3);
				setState(141);
				((DeclaratorsContext)_localctx).d2 = declarator();
				curFields.add(((DeclaratorsContext)_localctx).d2.ret); 
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Init_declaratorsContext extends ParserRuleContext {
		public Init_declaratorContext id1;
		public Init_declaratorContext id2;
		public List<Init_declaratorContext> init_declarator() {
			return getRuleContexts(Init_declaratorContext.class);
		}
		public Init_declaratorContext init_declarator(int i) {
			return getRuleContext(Init_declaratorContext.class,i);
		}
		public Init_declaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInit_declarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInit_declarators(this);
		}
	}

	public final Init_declaratorsContext init_declarators() throws RecognitionException {
		Init_declaratorsContext _localctx = new Init_declaratorsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_init_declarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			((Init_declaratorsContext)_localctx).id1 = init_declarator();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(150);
				match(T__3);
				setState(151);
				((Init_declaratorsContext)_localctx).id2 = init_declarator();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Init_declaratorContext extends ParserRuleContext {
		public DeclaratorContext d;
		public InitializerContext tmp;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public Init_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInit_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInit_declarator(this);
		}
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			Initializer init = null; 
			setState(158);
			((Init_declaratorContext)_localctx).d = declarator();
			setState(163);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(159);
				match(T__4);
				setState(160);
				((Init_declaratorContext)_localctx).tmp = initializer();
				init = ((Init_declaratorContext)_localctx).tmp.ret; 
				}
			}


			        ((Init_declaratorContext)_localctx).d.ret.init = init;
			        curDecls.add(((Init_declaratorContext)_localctx).d.ret);
			    
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

	public static class InitializerContext extends ParserRuleContext {
		public Initializer ret;
		public Assignment_expressionContext ax;
		public InitializerContext init1;
		public InitializerContext init2;
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_initializer);
		int _la;
		try {
			setState(186);
			switch (_input.LA(1)) {
			case T__1:
			case T__14:
			case T__36:
			case T__45:
			case T__46:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case Hex:
			case Dec:
			case Oct:
			case CHARACTERLITERAL:
			case STRINGLITERAL:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				((InitializerContext)_localctx).ax = assignment_expression();
				((InitializerContext)_localctx).ret =  new InitValue(((InitializerContext)_localctx).ax.ret); 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{

				        List<Initializer> inits = new LinkedList<Initializer>(); 
				    
				setState(171);
				match(T__5);
				setState(172);
				((InitializerContext)_localctx).init1 = initializer();
				inits.add(((InitializerContext)_localctx).init1.ret); 
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(174);
					match(T__3);
					setState(175);
					((InitializerContext)_localctx).init2 = initializer();
					inits.add(((InitializerContext)_localctx).init2.ret); 
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(183);
				match(T__6);
				((InitializerContext)_localctx).ret =  new InitList(inits); 
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

	public static class Type_specifierContext extends ParserRuleContext {
		public Type ret;
		public Struct_or_unionContext sou;
		public Token ide;
		public Type_specifierContext ts;
		public Struct_or_unionContext struct_or_union() {
			return getRuleContext(Struct_or_unionContext.class,0);
		}
		public List<DeclaratorsContext> declarators() {
			return getRuleContexts(DeclaratorsContext.class);
		}
		public DeclaratorsContext declarators(int i) {
			return getRuleContext(DeclaratorsContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public List<Type_specifierContext> type_specifier() {
			return getRuleContexts(Type_specifierContext.class);
		}
		public Type_specifierContext type_specifier(int i) {
			return getRuleContext(Type_specifierContext.class,i);
		}
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterType_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitType_specifier(this);
		}
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type_specifier);
		int _la;
		try {
			setState(217);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(T__7);
				((Type_specifierContext)_localctx).ret =  new VoidType(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(T__8);
				((Type_specifierContext)_localctx).ret =  new CharType(); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(T__9);
				((Type_specifierContext)_localctx).ret =  new IntType(); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{

				        String id = "#" + (Integer)(nAnonymous++);
				        List<VarDecl> fields = new LinkedList<VarDecl>();
				        List<VarDecl> oldFields = curFields;
				        curFields = fields;
				    
				setState(195);
				((Type_specifierContext)_localctx).sou = struct_or_union();
				setState(198);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(196);
					((Type_specifierContext)_localctx).ide = match(Identifier);
					nAnonymous--; id = (((Type_specifierContext)_localctx).ide!=null?((Type_specifierContext)_localctx).ide.getText():null);
					}
				}

				setState(200);
				match(T__5);
				setState(206); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(201);
					((Type_specifierContext)_localctx).ts = type_specifier();
					curType = ((Type_specifierContext)_localctx).ts.ret; 
					setState(203);
					declarators();
					setState(204);
					match(T__0);
					}
					}
					setState(208); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0) );
				setState(210);
				match(T__6);

				            curFields = oldFields;
				            if (((Type_specifierContext)_localctx).sou.ret == Symbol.get("struct")) {
				                curDecls.add(new StructDecl(Symbol.get(id), fields));
				                ((Type_specifierContext)_localctx).ret =  new StructType(Symbol.get(id));
				            } else {
				                curDecls.add(new UnionDecl(Symbol.get(id), fields));
				                ((Type_specifierContext)_localctx).ret =  new UnionType(Symbol.get(id));
				            }
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
				((Type_specifierContext)_localctx).sou = struct_or_union();
				setState(214);
				((Type_specifierContext)_localctx).ide = match(Identifier);

				            if (((Type_specifierContext)_localctx).sou.ret == Symbol.get("struct")) {
				                ((Type_specifierContext)_localctx).ret =  new StructType(Symbol.get((((Type_specifierContext)_localctx).ide!=null?((Type_specifierContext)_localctx).ide.getText():null)));
				            } else {
				                ((Type_specifierContext)_localctx).ret =  new UnionType(Symbol.get((((Type_specifierContext)_localctx).ide!=null?((Type_specifierContext)_localctx).ide.getText():null)));
				            }
				        
				}
				break;
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

	public static class Struct_or_unionContext extends ParserRuleContext {
		public Symbol ret;
		public Struct_or_unionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_or_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStruct_or_union(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStruct_or_union(this);
		}
	}

	public final Struct_or_unionContext struct_or_union() throws RecognitionException {
		Struct_or_unionContext _localctx = new Struct_or_unionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_struct_or_union);
		try {
			setState(223);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(T__10);
				((Struct_or_unionContext)_localctx).ret =  Symbol.get("struct"); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(T__11);
				((Struct_or_unionContext)_localctx).ret =  Symbol.get("union"); 
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

	public static class Plain_declarationContext extends ParserRuleContext {
		public VarDecl ret;
		public Type_specifierContext ts;
		public DeclaratorContext decl;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Plain_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plain_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterPlain_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitPlain_declaration(this);
		}
	}

	public final Plain_declarationContext plain_declaration() throws RecognitionException {
		Plain_declarationContext _localctx = new Plain_declarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_plain_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			((Plain_declarationContext)_localctx).ts = type_specifier();
			curType = ((Plain_declarationContext)_localctx).ts.ret; 
			setState(227);
			((Plain_declarationContext)_localctx).decl = declarator();

			            ((Plain_declarationContext)_localctx).ret =  new VarDecl(((Plain_declarationContext)_localctx).decl.ret.type, ((Plain_declarationContext)_localctx).decl.ret.name, ((Plain_declarationContext)_localctx).decl.ret.init);
			        
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

	public static class DeclaratorContext extends ParserRuleContext {
		public VarDecl ret;
		public Plain_declaratorContext pd;
		public Constant_expressionContext ce;
		public Plain_declaratorContext plain_declarator() {
			return getRuleContext(Plain_declaratorContext.class,0);
		}
		public List<Constant_expressionContext> constant_expression() {
			return getRuleContexts(Constant_expressionContext.class);
		}
		public Constant_expressionContext constant_expression(int i) {
			return getRuleContext(Constant_expressionContext.class,i);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDeclarator(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            ((DeclaratorContext)_localctx).ret =  new VarDecl(); 
			            List<Expr> list = new LinkedList<Expr>();
			        
			setState(231);
			((DeclaratorContext)_localctx).pd = plain_declarator();
			_localctx.ret.type = ((DeclaratorContext)_localctx).pd.ret.type; _localctx.ret.name = ((DeclaratorContext)_localctx).pd.ret.name; 
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(233);
				match(T__12);
				setState(234);
				((DeclaratorContext)_localctx).ce = constant_expression();
				setState(235);
				match(T__13);
				list.add(((DeclaratorContext)_localctx).ce.ret); 
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			            for (int i = list.size() - 1; i >= 0; i--) {
			                _localctx.ret.type = new ArrayType(_localctx.ret.type, list.get(i));
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

	public static class Plain_declaratorContext extends ParserRuleContext {
		public VarDecl ret;
		public Token ide;
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public Plain_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plain_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterPlain_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitPlain_declarator(this);
		}
	}

	public final Plain_declaratorContext plain_declarator() throws RecognitionException {
		Plain_declaratorContext _localctx = new Plain_declaratorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_plain_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((Plain_declaratorContext)_localctx).ret =  new VarDecl(curType, Symbol.get(""), null); 
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(246);
				match(T__14);
				_localctx.ret.type = new PointerType(_localctx.ret.type); 
				}
				}
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(253);
			((Plain_declaratorContext)_localctx).ide = match(Identifier);
			_localctx.ret.name = Symbol.get((((Plain_declaratorContext)_localctx).ide!=null?((Plain_declaratorContext)_localctx).ide.getText():null)); 
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

	public static class StatementContext extends ParserRuleContext {
		public Stmt ret;
		public Expression_statementContext es;
		public Compound_statementContext cs;
		public Selection_statementContext ss;
		public Iteration_statementContext it;
		public Jump_statementContext js;
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Selection_statementContext selection_statement() {
			return getRuleContext(Selection_statementContext.class,0);
		}
		public Iteration_statementContext iteration_statement() {
			return getRuleContext(Iteration_statementContext.class,0);
		}
		public Jump_statementContext jump_statement() {
			return getRuleContext(Jump_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(271);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__14:
			case T__36:
			case T__45:
			case T__46:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case Hex:
			case Dec:
			case Oct:
			case CHARACTERLITERAL:
			case STRINGLITERAL:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				((StatementContext)_localctx).es = expression_statement();
				((StatementContext)_localctx).ret =  ((StatementContext)_localctx).es.ret; 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				((StatementContext)_localctx).cs = compound_statement();
				((StatementContext)_localctx).ret =  ((StatementContext)_localctx).cs.ret; 
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				((StatementContext)_localctx).ss = selection_statement();
				((StatementContext)_localctx).ret =  ((StatementContext)_localctx).ss.ret; 
				}
				break;
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(265);
				((StatementContext)_localctx).it = iteration_statement();
				((StatementContext)_localctx).ret =  ((StatementContext)_localctx).it.ret; 
				}
				break;
			case T__19:
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 5);
				{
				setState(268);
				((StatementContext)_localctx).js = jump_statement();
				((StatementContext)_localctx).ret =  ((StatementContext)_localctx).js.ret; 
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

	public static class Expression_statementContext extends ParserRuleContext {
		public Expr ret;
		public ExpressionContext expr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterExpression_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitExpression_statement(this);
		}
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expression_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((Expression_statementContext)_localctx).ret =  new EmptyExpr(); 
			setState(277);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__36) | (1L << T__45) | (1L << T__46) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << Hex) | (1L << Dec) | (1L << Oct))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTERLITERAL - 64)) | (1L << (STRINGLITERAL - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				setState(274);
				((Expression_statementContext)_localctx).expr = expression();
				((Expression_statementContext)_localctx).ret =  ((Expression_statementContext)_localctx).expr.ret; 
				}
			}

			setState(279);
			match(T__0);
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

	public static class Compound_statementContext extends ParserRuleContext {
		public CompoundStmt ret;
		public StatementContext sta;
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterCompound_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitCompound_statement(this);
		}
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            ((Compound_statementContext)_localctx).ret =  new CompoundStmt(new LinkedList<Decl>(), new LinkedList<Stmt>());
			            List<Decl> oldDecls = curDecls;
			            curDecls = _localctx.ret.decls;
			        
			setState(282);
			match(T__5);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				{
				setState(283);
				declaration();
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__36) | (1L << T__45) | (1L << T__46) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << Hex) | (1L << Dec) | (1L << Oct))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTERLITERAL - 64)) | (1L << (STRINGLITERAL - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(289);
				((Compound_statementContext)_localctx).sta = statement();
				_localctx.ret.stats.add(((Compound_statementContext)_localctx).sta.ret); 
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(297);
			match(T__6);

			            curDecls = oldDecls;
			        
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

	public static class Selection_statementContext extends ParserRuleContext {
		public IfStmt ret;
		public ExpressionContext expr;
		public StatementContext stat;
		public StatementContext stat2;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Selection_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterSelection_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitSelection_statement(this);
		}
	}

	public final Selection_statementContext selection_statement() throws RecognitionException {
		Selection_statementContext _localctx = new Selection_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_selection_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			((Selection_statementContext)_localctx).ret =  new IfStmt(); 
			setState(301);
			match(T__15);
			setState(302);
			match(T__1);
			setState(303);
			((Selection_statementContext)_localctx).expr = expression();
			_localctx.ret.condition = ((Selection_statementContext)_localctx).expr.ret; 
			setState(305);
			match(T__2);
			setState(306);
			((Selection_statementContext)_localctx).stat = statement();
			_localctx.ret.consequent = ((Selection_statementContext)_localctx).stat.ret; 
			setState(312);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(308);
				match(T__16);
				setState(309);
				((Selection_statementContext)_localctx).stat2 = statement();
				_localctx.ret.alternative = ((Selection_statementContext)_localctx).stat2.ret; 
				}
				break;
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

	public static class Iteration_statementContext extends ParserRuleContext {
		public Stmt ret;
		public ExpressionContext expr;
		public StatementContext stat;
		public ExpressionContext expr1;
		public ExpressionContext expr2;
		public ExpressionContext expr3;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Iteration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterIteration_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitIteration_statement(this);
		}
	}

	public final Iteration_statementContext iteration_statement() throws RecognitionException {
		Iteration_statementContext _localctx = new Iteration_statementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_iteration_statement);
		int _la;
		try {
			setState(349);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				WhileLoop tmp = new WhileLoop(); 
				setState(315);
				match(T__17);
				setState(316);
				match(T__1);
				setState(317);
				((Iteration_statementContext)_localctx).expr = expression();
				tmp.condition = ((Iteration_statementContext)_localctx).expr.ret; 
				setState(319);
				match(T__2);
				setState(320);
				((Iteration_statementContext)_localctx).stat = statement();
				tmp.body = ((Iteration_statementContext)_localctx).stat.ret; 
				((Iteration_statementContext)_localctx).ret =  tmp; 
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				ForLoop tmp = new ForLoop(new EmptyExpr(), new EmptyExpr(), new EmptyExpr(), null); 
				setState(325);
				match(T__18);
				setState(326);
				match(T__1);
				setState(330);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__36) | (1L << T__45) | (1L << T__46) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << Hex) | (1L << Dec) | (1L << Oct))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTERLITERAL - 64)) | (1L << (STRINGLITERAL - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(327);
					((Iteration_statementContext)_localctx).expr1 = expression();
					tmp.init = ((Iteration_statementContext)_localctx).expr1.ret; 
					}
				}

				setState(332);
				match(T__0);
				setState(336);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__36) | (1L << T__45) | (1L << T__46) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << Hex) | (1L << Dec) | (1L << Oct))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTERLITERAL - 64)) | (1L << (STRINGLITERAL - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(333);
					((Iteration_statementContext)_localctx).expr2 = expression();
					tmp.condition = ((Iteration_statementContext)_localctx).expr2.ret; 
					}
				}

				setState(338);
				match(T__0);
				setState(342);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__36) | (1L << T__45) | (1L << T__46) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << Hex) | (1L << Dec) | (1L << Oct))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTERLITERAL - 64)) | (1L << (STRINGLITERAL - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(339);
					((Iteration_statementContext)_localctx).expr3 = expression();
					tmp.step = ((Iteration_statementContext)_localctx).expr3.ret; 
					}
				}

				setState(344);
				match(T__2);
				setState(345);
				((Iteration_statementContext)_localctx).stat = statement();
				tmp.body = ((Iteration_statementContext)_localctx).stat.ret; 
				((Iteration_statementContext)_localctx).ret =  tmp; 
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

	public static class Jump_statementContext extends ParserRuleContext {
		public Stmt ret;
		public ExpressionContext expr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Jump_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterJump_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitJump_statement(this);
		}
	}

	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_jump_statement);
		int _la;
		try {
			setState(366);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				((Jump_statementContext)_localctx).ret =  new ContinueStmt(); 
				setState(352);
				match(T__19);
				setState(353);
				match(T__0);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				((Jump_statementContext)_localctx).ret =  new BreakStmt(); 
				setState(355);
				match(T__20);
				setState(356);
				match(T__0);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				ReturnStmt tmp = new ReturnStmt(new EmptyExpr()); 
				setState(358);
				match(T__21);
				setState(362);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__36) | (1L << T__45) | (1L << T__46) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << Hex) | (1L << Dec) | (1L << Oct))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTERLITERAL - 64)) | (1L << (STRINGLITERAL - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(359);
					((Jump_statementContext)_localctx).expr = expression();
					tmp.expr = ((Jump_statementContext)_localctx).expr.ret;
					}
				}

				setState(364);
				match(T__0);
				((Jump_statementContext)_localctx).ret =  tmp; 
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expr ret;
		public Assignment_expressionContext ae1;
		public Assignment_expressionContext ae2;
		public List<Assignment_expressionContext> assignment_expression() {
			return getRuleContexts(Assignment_expressionContext.class);
		}
		public Assignment_expressionContext assignment_expression(int i) {
			return getRuleContext(Assignment_expressionContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			((ExpressionContext)_localctx).ae1 = assignment_expression();
			((ExpressionContext)_localctx).ret =  ((ExpressionContext)_localctx).ae1.ret; 
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(370);
				match(T__3);
				setState(371);
				((ExpressionContext)_localctx).ae2 = assignment_expression();
				((ExpressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, BinaryOp.COMMA, ((ExpressionContext)_localctx).ae2.ret); 
				}
				}
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Assignment_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Logical_or_expressionContext loe;
		public Unary_expressionContext ue;
		public Assignment_operatorContext ao;
		public Assignment_expressionContext ae;
		public Logical_or_expressionContext logical_or_expression() {
			return getRuleContext(Logical_or_expressionContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Assignment_operatorContext assignment_operator() {
			return getRuleContext(Assignment_operatorContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAssignment_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAssignment_expression(this);
		}
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignment_expression);
		try {
			setState(387);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(379);
				((Assignment_expressionContext)_localctx).loe = logical_or_expression();
				((Assignment_expressionContext)_localctx).ret =  ((Assignment_expressionContext)_localctx).loe.ret; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				((Assignment_expressionContext)_localctx).ue = unary_expression();
				setState(383);
				((Assignment_expressionContext)_localctx).ao = assignment_operator();
				setState(384);
				((Assignment_expressionContext)_localctx).ae = assignment_expression();
				((Assignment_expressionContext)_localctx).ret =  new BinaryExpr(((Assignment_expressionContext)_localctx).ue.ret, ((Assignment_expressionContext)_localctx).ao.ret, ((Assignment_expressionContext)_localctx).ae.ret); 
				}
				break;
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

	public static class Assignment_operatorContext extends ParserRuleContext {
		public BinaryOp ret;
		public Assignment_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAssignment_operator(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignment_operator);
		try {
			setState(411);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				match(T__4);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN; 
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				match(T__22);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_MUL; 
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				match(T__23);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_DIV; 
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 4);
				{
				setState(395);
				match(T__24);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_MOD; 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 5);
				{
				setState(397);
				match(T__25);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_ADD; 
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 6);
				{
				setState(399);
				match(T__26);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_SUB; 
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 7);
				{
				setState(401);
				match(T__27);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_SHL; 
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 8);
				{
				setState(403);
				match(T__28);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_SHR; 
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 9);
				{
				setState(405);
				match(T__29);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_AND; 
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 10);
				{
				setState(407);
				match(T__30);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_XOR; 
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 11);
				{
				setState(409);
				match(T__31);
				((Assignment_operatorContext)_localctx).ret =  BinaryOp.ASSIGN_OR;
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

	public static class Constant_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Logical_or_expressionContext loe;
		public Logical_or_expressionContext logical_or_expression() {
			return getRuleContext(Logical_or_expressionContext.class,0);
		}
		public Constant_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterConstant_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitConstant_expression(this);
		}
	}

	public final Constant_expressionContext constant_expression() throws RecognitionException {
		Constant_expressionContext _localctx = new Constant_expressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constant_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			((Constant_expressionContext)_localctx).loe = logical_or_expression();
			((Constant_expressionContext)_localctx).ret =  ((Constant_expressionContext)_localctx).loe.ret; 
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

	public static class Logical_or_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Logical_and_expressionContext lae;
		public Logical_and_expressionContext lae2;
		public List<Logical_and_expressionContext> logical_and_expression() {
			return getRuleContexts(Logical_and_expressionContext.class);
		}
		public Logical_and_expressionContext logical_and_expression(int i) {
			return getRuleContext(Logical_and_expressionContext.class,i);
		}
		public Logical_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterLogical_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitLogical_or_expression(this);
		}
	}

	public final Logical_or_expressionContext logical_or_expression() throws RecognitionException {
		Logical_or_expressionContext _localctx = new Logical_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logical_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			((Logical_or_expressionContext)_localctx).lae = logical_and_expression();
			((Logical_or_expressionContext)_localctx).ret =  ((Logical_or_expressionContext)_localctx).lae.ret; 
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(418);
				match(T__32);
				setState(419);
				((Logical_or_expressionContext)_localctx).lae2 = logical_and_expression();
				((Logical_or_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, BinaryOp.LOGICAL_OR, ((Logical_or_expressionContext)_localctx).lae2.ret); 
				}
				}
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Logical_and_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Inclusive_or_expressionContext ioe;
		public Inclusive_or_expressionContext ioe2;
		public List<Inclusive_or_expressionContext> inclusive_or_expression() {
			return getRuleContexts(Inclusive_or_expressionContext.class);
		}
		public Inclusive_or_expressionContext inclusive_or_expression(int i) {
			return getRuleContext(Inclusive_or_expressionContext.class,i);
		}
		public Logical_and_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterLogical_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitLogical_and_expression(this);
		}
	}

	public final Logical_and_expressionContext logical_and_expression() throws RecognitionException {
		Logical_and_expressionContext _localctx = new Logical_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_logical_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			((Logical_and_expressionContext)_localctx).ioe = inclusive_or_expression();
			((Logical_and_expressionContext)_localctx).ret =  ((Logical_and_expressionContext)_localctx).ioe.ret; 
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33) {
				{
				{
				setState(429);
				match(T__33);
				setState(430);
				((Logical_and_expressionContext)_localctx).ioe2 = inclusive_or_expression();
				((Logical_and_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, BinaryOp.LOGICAL_AND, ((Logical_and_expressionContext)_localctx).ioe2.ret); 
				}
				}
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Inclusive_or_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Exclusive_or_expressionContext eoe;
		public Exclusive_or_expressionContext eoe2;
		public List<Exclusive_or_expressionContext> exclusive_or_expression() {
			return getRuleContexts(Exclusive_or_expressionContext.class);
		}
		public Exclusive_or_expressionContext exclusive_or_expression(int i) {
			return getRuleContext(Exclusive_or_expressionContext.class,i);
		}
		public Inclusive_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInclusive_or_expression(this);
		}
	}

	public final Inclusive_or_expressionContext inclusive_or_expression() throws RecognitionException {
		Inclusive_or_expressionContext _localctx = new Inclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			((Inclusive_or_expressionContext)_localctx).eoe = exclusive_or_expression();
			((Inclusive_or_expressionContext)_localctx).ret =  ((Inclusive_or_expressionContext)_localctx).eoe.ret; 
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__34) {
				{
				{
				setState(440);
				match(T__34);
				setState(441);
				((Inclusive_or_expressionContext)_localctx).eoe2 = exclusive_or_expression();
				((Inclusive_or_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, BinaryOp.OR, ((Inclusive_or_expressionContext)_localctx).eoe2.ret); 
				}
				}
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Exclusive_or_expressionContext extends ParserRuleContext {
		public Expr ret;
		public And_expressionContext ae;
		public And_expressionContext ae2;
		public List<And_expressionContext> and_expression() {
			return getRuleContexts(And_expressionContext.class);
		}
		public And_expressionContext and_expression(int i) {
			return getRuleContext(And_expressionContext.class,i);
		}
		public Exclusive_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterExclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitExclusive_or_expression(this);
		}
	}

	public final Exclusive_or_expressionContext exclusive_or_expression() throws RecognitionException {
		Exclusive_or_expressionContext _localctx = new Exclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			((Exclusive_or_expressionContext)_localctx).ae = and_expression();
			((Exclusive_or_expressionContext)_localctx).ret =  ((Exclusive_or_expressionContext)_localctx).ae.ret; 
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35) {
				{
				{
				setState(451);
				match(T__35);
				setState(452);
				((Exclusive_or_expressionContext)_localctx).ae2 = and_expression();
				((Exclusive_or_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, BinaryOp.XOR, ((Exclusive_or_expressionContext)_localctx).ae2.ret); 
				}
				}
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class And_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Equality_expressionContext ee;
		public Equality_expressionContext ee2;
		public List<Equality_expressionContext> equality_expression() {
			return getRuleContexts(Equality_expressionContext.class);
		}
		public Equality_expressionContext equality_expression(int i) {
			return getRuleContext(Equality_expressionContext.class,i);
		}
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAnd_expression(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			((And_expressionContext)_localctx).ee = equality_expression();
			((And_expressionContext)_localctx).ret =  ((And_expressionContext)_localctx).ee.ret; 
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(462);
				match(T__36);
				setState(463);
				((And_expressionContext)_localctx).ee2 = equality_expression();
				((And_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, BinaryOp.AND, ((And_expressionContext)_localctx).ee2.ret); 
				}
				}
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Equality_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Relational_expressionContext re;
		public Equality_operatorContext eo;
		public Relational_expressionContext re2;
		public List<Relational_expressionContext> relational_expression() {
			return getRuleContexts(Relational_expressionContext.class);
		}
		public Relational_expressionContext relational_expression(int i) {
			return getRuleContext(Relational_expressionContext.class,i);
		}
		public List<Equality_operatorContext> equality_operator() {
			return getRuleContexts(Equality_operatorContext.class);
		}
		public Equality_operatorContext equality_operator(int i) {
			return getRuleContext(Equality_operatorContext.class,i);
		}
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitEquality_expression(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			((Equality_expressionContext)_localctx).re = relational_expression();
			((Equality_expressionContext)_localctx).ret =  ((Equality_expressionContext)_localctx).re.ret; 
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__37 || _la==T__38) {
				{
				{
				setState(473);
				((Equality_expressionContext)_localctx).eo = equality_operator();
				setState(474);
				((Equality_expressionContext)_localctx).re2 = relational_expression();
				((Equality_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, ((Equality_expressionContext)_localctx).eo.ret, ((Equality_expressionContext)_localctx).re2.ret); 
				}
				}
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Equality_operatorContext extends ParserRuleContext {
		public BinaryOp ret;
		public Equality_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitEquality_operator(this);
		}
	}

	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_equality_operator);
		try {
			setState(486);
			switch (_input.LA(1)) {
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(482);
				match(T__37);
				((Equality_operatorContext)_localctx).ret =  BinaryOp.EQ; 
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(484);
				match(T__38);
				((Equality_operatorContext)_localctx).ret =  BinaryOp.NE; 
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

	public static class Relational_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Shift_expressionContext se;
		public Relational_operatorContext ro;
		public Shift_expressionContext se2;
		public List<Shift_expressionContext> shift_expression() {
			return getRuleContexts(Shift_expressionContext.class);
		}
		public Shift_expressionContext shift_expression(int i) {
			return getRuleContext(Shift_expressionContext.class,i);
		}
		public List<Relational_operatorContext> relational_operator() {
			return getRuleContexts(Relational_operatorContext.class);
		}
		public Relational_operatorContext relational_operator(int i) {
			return getRuleContext(Relational_operatorContext.class,i);
		}
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitRelational_expression(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			((Relational_expressionContext)_localctx).se = shift_expression();
			((Relational_expressionContext)_localctx).ret =  ((Relational_expressionContext)_localctx).se.ret; 
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) {
				{
				{
				setState(490);
				((Relational_expressionContext)_localctx).ro = relational_operator();
				setState(491);
				((Relational_expressionContext)_localctx).se2 = shift_expression();
				((Relational_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, ((Relational_expressionContext)_localctx).ro.ret, ((Relational_expressionContext)_localctx).se2.ret); 
				}
				}
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Relational_operatorContext extends ParserRuleContext {
		public BinaryOp ret;
		public Relational_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitRelational_operator(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_relational_operator);
		try {
			setState(507);
			switch (_input.LA(1)) {
			case T__39:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				match(T__39);
				((Relational_operatorContext)_localctx).ret =  BinaryOp.LT; 
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 2);
				{
				setState(501);
				match(T__40);
				((Relational_operatorContext)_localctx).ret =  BinaryOp.GT; 
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 3);
				{
				setState(503);
				match(T__41);
				((Relational_operatorContext)_localctx).ret =  BinaryOp.LE; 
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 4);
				{
				setState(505);
				match(T__42);
				((Relational_operatorContext)_localctx).ret =  BinaryOp.GE; 
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

	public static class Shift_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Additive_expressionContext ae;
		public Shift_operatorContext so;
		public Additive_expressionContext ae2;
		public List<Additive_expressionContext> additive_expression() {
			return getRuleContexts(Additive_expressionContext.class);
		}
		public Additive_expressionContext additive_expression(int i) {
			return getRuleContext(Additive_expressionContext.class,i);
		}
		public List<Shift_operatorContext> shift_operator() {
			return getRuleContexts(Shift_operatorContext.class);
		}
		public Shift_operatorContext shift_operator(int i) {
			return getRuleContext(Shift_operatorContext.class,i);
		}
		public Shift_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterShift_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitShift_expression(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			((Shift_expressionContext)_localctx).ae = additive_expression();
			((Shift_expressionContext)_localctx).ret =  ((Shift_expressionContext)_localctx).ae.ret; 
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__43 || _la==T__44) {
				{
				{
				setState(511);
				((Shift_expressionContext)_localctx).so = shift_operator();
				setState(512);
				((Shift_expressionContext)_localctx).ae2 = additive_expression();
				((Shift_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, ((Shift_expressionContext)_localctx).so.ret, ((Shift_expressionContext)_localctx).ae2.ret); 
				}
				}
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Shift_operatorContext extends ParserRuleContext {
		public BinaryOp ret;
		public Shift_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterShift_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitShift_operator(this);
		}
	}

	public final Shift_operatorContext shift_operator() throws RecognitionException {
		Shift_operatorContext _localctx = new Shift_operatorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_shift_operator);
		try {
			setState(524);
			switch (_input.LA(1)) {
			case T__43:
				enterOuterAlt(_localctx, 1);
				{
				setState(520);
				match(T__43);
				((Shift_operatorContext)_localctx).ret =  BinaryOp.SHL; 
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 2);
				{
				setState(522);
				match(T__44);
				((Shift_operatorContext)_localctx).ret =  BinaryOp.SHR; 
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

	public static class Additive_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Multiplicative_expressionContext me;
		public Additive_operatorContext ao;
		public Multiplicative_expressionContext me2;
		public List<Multiplicative_expressionContext> multiplicative_expression() {
			return getRuleContexts(Multiplicative_expressionContext.class);
		}
		public Multiplicative_expressionContext multiplicative_expression(int i) {
			return getRuleContext(Multiplicative_expressionContext.class,i);
		}
		public List<Additive_operatorContext> additive_operator() {
			return getRuleContexts(Additive_operatorContext.class);
		}
		public Additive_operatorContext additive_operator(int i) {
			return getRuleContext(Additive_operatorContext.class,i);
		}
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAdditive_expression(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			((Additive_expressionContext)_localctx).me = multiplicative_expression();
			((Additive_expressionContext)_localctx).ret =  ((Additive_expressionContext)_localctx).me.ret; 
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__45 || _la==T__46) {
				{
				{
				setState(528);
				((Additive_expressionContext)_localctx).ao = additive_operator();
				setState(529);
				((Additive_expressionContext)_localctx).me2 = multiplicative_expression();
				((Additive_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, ((Additive_expressionContext)_localctx).ao.ret, ((Additive_expressionContext)_localctx).me2.ret); 
				}
				}
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Additive_operatorContext extends ParserRuleContext {
		public BinaryOp ret;
		public Additive_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAdditive_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAdditive_operator(this);
		}
	}

	public final Additive_operatorContext additive_operator() throws RecognitionException {
		Additive_operatorContext _localctx = new Additive_operatorContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_additive_operator);
		try {
			setState(541);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(537);
				match(T__45);
				((Additive_operatorContext)_localctx).ret =  BinaryOp.ADD; 
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				setState(539);
				match(T__46);
				((Additive_operatorContext)_localctx).ret =  BinaryOp.SUB; 
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

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Cast_expressionContext ce;
		public Multiplicative_operatorContext mo;
		public Cast_expressionContext ce2;
		public List<Cast_expressionContext> cast_expression() {
			return getRuleContexts(Cast_expressionContext.class);
		}
		public Cast_expressionContext cast_expression(int i) {
			return getRuleContext(Cast_expressionContext.class,i);
		}
		public List<Multiplicative_operatorContext> multiplicative_operator() {
			return getRuleContexts(Multiplicative_operatorContext.class);
		}
		public Multiplicative_operatorContext multiplicative_operator(int i) {
			return getRuleContext(Multiplicative_operatorContext.class,i);
		}
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitMultiplicative_expression(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			((Multiplicative_expressionContext)_localctx).ce = cast_expression();
			((Multiplicative_expressionContext)_localctx).ret =  ((Multiplicative_expressionContext)_localctx).ce.ret; 
			setState(551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__47) | (1L << T__48))) != 0)) {
				{
				{
				setState(545);
				((Multiplicative_expressionContext)_localctx).mo = multiplicative_operator();
				setState(546);
				((Multiplicative_expressionContext)_localctx).ce2 = cast_expression();
				((Multiplicative_expressionContext)_localctx).ret =  new BinaryExpr(_localctx.ret, ((Multiplicative_expressionContext)_localctx).mo.ret, ((Multiplicative_expressionContext)_localctx).ce2.ret); 
				}
				}
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Multiplicative_operatorContext extends ParserRuleContext {
		public BinaryOp ret;
		public Multiplicative_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterMultiplicative_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitMultiplicative_operator(this);
		}
	}

	public final Multiplicative_operatorContext multiplicative_operator() throws RecognitionException {
		Multiplicative_operatorContext _localctx = new Multiplicative_operatorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_multiplicative_operator);
		try {
			setState(560);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(554);
				match(T__14);
				((Multiplicative_operatorContext)_localctx).ret =  BinaryOp.MUL; 
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 2);
				{
				setState(556);
				match(T__47);
				((Multiplicative_operatorContext)_localctx).ret =  BinaryOp.DIV; 
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 3);
				{
				setState(558);
				match(T__48);
				((Multiplicative_operatorContext)_localctx).ret =  BinaryOp.MOD; 
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

	public static class Cast_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Unary_expressionContext ue;
		public Type_nameContext tn;
		public Cast_expressionContext ce;
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Cast_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterCast_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitCast_expression(this);
		}
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_cast_expression);
		try {
			setState(571);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(562);
				((Cast_expressionContext)_localctx).ue = unary_expression();
				((Cast_expressionContext)_localctx).ret =  ((Cast_expressionContext)_localctx).ue.ret; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(565);
				match(T__1);
				setState(566);
				((Cast_expressionContext)_localctx).tn = type_name();
				setState(567);
				match(T__2);
				setState(568);
				((Cast_expressionContext)_localctx).ce = cast_expression();
				((Cast_expressionContext)_localctx).ret =  new CastExpr(((Cast_expressionContext)_localctx).tn.ret, ((Cast_expressionContext)_localctx).ce.ret); 
				}
				break;
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

	public static class Type_nameContext extends ParserRuleContext {
		public Type ret;
		public Type_specifierContext ts;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			((Type_nameContext)_localctx).ts = type_specifier();
			((Type_nameContext)_localctx).ret =  ((Type_nameContext)_localctx).ts.ret; 
			setState(579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(575);
				match(T__14);
				((Type_nameContext)_localctx).ret =  new PointerType(_localctx.ret); 
				}
				}
				setState(581);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Unary_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Postfix_expressionContext pe;
		public Unary_expressionContext ue;
		public Unary_operatorContext uo;
		public Cast_expressionContext ce;
		public Type_nameContext tn;
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_unary_expression);
		try {
			setState(607);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(582);
				((Unary_expressionContext)_localctx).pe = postfix_expression();
				((Unary_expressionContext)_localctx).ret =  ((Unary_expressionContext)_localctx).pe.ret; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(585);
				match(T__49);
				setState(586);
				((Unary_expressionContext)_localctx).ue = unary_expression();
				((Unary_expressionContext)_localctx).ret =  new UnaryExpr(UnaryOp.INC, ((Unary_expressionContext)_localctx).ue.ret); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(589);
				match(T__50);
				setState(590);
				((Unary_expressionContext)_localctx).ue = unary_expression();
				((Unary_expressionContext)_localctx).ret =  new UnaryExpr(UnaryOp.DEC, ((Unary_expressionContext)_localctx).ue.ret); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(593);
				((Unary_expressionContext)_localctx).uo = unary_operator();
				setState(594);
				((Unary_expressionContext)_localctx).ce = cast_expression();
				((Unary_expressionContext)_localctx).ret =  new UnaryExpr(((Unary_expressionContext)_localctx).uo.ret, ((Unary_expressionContext)_localctx).ce.ret); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(597);
				match(T__51);
				setState(598);
				((Unary_expressionContext)_localctx).ue = unary_expression();
				((Unary_expressionContext)_localctx).ret =  new UnaryExpr(UnaryOp.SIZEOF, ((Unary_expressionContext)_localctx).ue.ret); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(601);
				match(T__51);
				setState(602);
				match(T__1);
				setState(603);
				((Unary_expressionContext)_localctx).tn = type_name();
				setState(604);
				match(T__2);
				((Unary_expressionContext)_localctx).ret =  new SizeofExpr(((Unary_expressionContext)_localctx).tn.ret); 
				}
				break;
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

	public static class Unary_operatorContext extends ParserRuleContext {
		public UnaryOp ret;
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_unary_operator);
		try {
			setState(621);
			switch (_input.LA(1)) {
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(609);
				match(T__36);
				((Unary_operatorContext)_localctx).ret =  UnaryOp.AMPERSAND; 
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(611);
				match(T__14);
				((Unary_operatorContext)_localctx).ret =  UnaryOp.ASTERISK; 
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 3);
				{
				setState(613);
				match(T__45);
				((Unary_operatorContext)_localctx).ret =  UnaryOp.PLUS; 
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 4);
				{
				setState(615);
				match(T__46);
				((Unary_operatorContext)_localctx).ret =  UnaryOp.MINUS; 
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 5);
				{
				setState(617);
				match(T__52);
				((Unary_operatorContext)_localctx).ret =  UnaryOp.TILDE; 
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 6);
				{
				setState(619);
				match(T__53);
				((Unary_operatorContext)_localctx).ret =  UnaryOp.NOT; 
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

	public static class Postfix_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Primary_expressionContext pe;
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterPostfix_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitPostfix_expression(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_postfix_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			((Postfix_expressionContext)_localctx).pe = primary_expression();

			            ((Postfix_expressionContext)_localctx).ret =  ((Postfix_expressionContext)_localctx).pe.ret;  
			            Symbol sym = null;
			            if (postfixSymbol != null) {
			                sym = Symbol.get(postfixSymbol.toString());
			            }
			        
			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__12) | (1L << T__49) | (1L << T__50) | (1L << T__54) | (1L << T__55))) != 0)) {
				{
				{
				setState(625);
				postfix();

				            if (postfixType == 1) {
				                ((Postfix_expressionContext)_localctx).ret =  new ArrayAccess(_localctx.ret, postfixExpr);
				            } else if (postfixType == 2) {
				                ((Postfix_expressionContext)_localctx).ret =  new FunctionCall(sym, postfixArgs);
				            } else if (postfixType == 3) {
				                ((Postfix_expressionContext)_localctx).ret =  new RecordAccess(_localctx.ret, postfixSymbol);
				            } else if (postfixType == 4) {
				                ((Postfix_expressionContext)_localctx).ret =  new PointerAccess(_localctx.ret, postfixSymbol);
				            } else if (postfixType == 5) {
				                ((Postfix_expressionContext)_localctx).ret =  new SelfIncrement(_localctx.ret);
				            } else if (postfixType == 6) {
				                ((Postfix_expressionContext)_localctx).ret =  new SelfDecrement(_localctx.ret);
				            }
				        
				}
				}
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class PostfixContext extends ParserRuleContext {
		public ExpressionContext expr;
		public ArgumentsContext args;
		public Token ide;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_postfix);
		int _la;
		try {
			setState(657);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(633);
				match(T__12);
				setState(634);
				((PostfixContext)_localctx).expr = expression();
				setState(635);
				match(T__13);
				postfixType = 1; postfixExpr = ((PostfixContext)_localctx).expr.ret; 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				postfixArgs = new LinkedList<Expr>(); 
				setState(639);
				match(T__1);
				setState(643);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__36) | (1L << T__45) | (1L << T__46) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << Hex) | (1L << Dec) | (1L << Oct))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTERLITERAL - 64)) | (1L << (STRINGLITERAL - 64)) | (1L << (Identifier - 64)))) != 0)) {
					{
					setState(640);
					((PostfixContext)_localctx).args = arguments();
					postfixArgs = ((PostfixContext)_localctx).args.ret; 
					}
				}

				setState(645);
				match(T__2);
				postfixType = 2; 
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 3);
				{
				setState(647);
				match(T__54);
				setState(648);
				((PostfixContext)_localctx).ide = match(Identifier);
				postfixType = 3; postfixSymbol = Symbol.get((((PostfixContext)_localctx).ide!=null?((PostfixContext)_localctx).ide.getText():null)); 
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 4);
				{
				setState(650);
				match(T__55);
				setState(651);
				((PostfixContext)_localctx).ide = match(Identifier);
				postfixType = 4; postfixSymbol = Symbol.get((((PostfixContext)_localctx).ide!=null?((PostfixContext)_localctx).ide.getText():null)); 
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 5);
				{
				setState(653);
				match(T__49);
				postfixType = 5; 
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 6);
				{
				setState(655);
				match(T__50);
				postfixType = 6; 
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expr> ret;
		public Assignment_expressionContext ae;
		public Assignment_expressionContext ae2;
		public List<Assignment_expressionContext> assignment_expression() {
			return getRuleContexts(Assignment_expressionContext.class);
		}
		public Assignment_expressionContext assignment_expression(int i) {
			return getRuleContext(Assignment_expressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ArgumentsContext)_localctx).ret =  new LinkedList<Expr>(); 
			setState(660);
			((ArgumentsContext)_localctx).ae = assignment_expression();
			_localctx.ret.add(((ArgumentsContext)_localctx).ae.ret); 
			setState(668);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(662);
				match(T__3);
				setState(663);
				((ArgumentsContext)_localctx).ae2 = assignment_expression();
				_localctx.ret.add(((ArgumentsContext)_localctx).ae2.ret); 
				}
				}
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Primary_expressionContext extends ParserRuleContext {
		public Expr ret;
		public Token ide;
		public Integer_constantContext ic;
		public Character_constantContext cc;
		public Token sl;
		public ExpressionContext expr;
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public Integer_constantContext integer_constant() {
			return getRuleContext(Integer_constantContext.class,0);
		}
		public Character_constantContext character_constant() {
			return getRuleContext(Character_constantContext.class,0);
		}
		public TerminalNode STRINGLITERAL() { return getToken(CParser.STRINGLITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_primary_expression);
		try {
			setState(686);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(671);
				((Primary_expressionContext)_localctx).ide = match(Identifier);

				            ((Primary_expressionContext)_localctx).ret =  new Identifier(Symbol.get((((Primary_expressionContext)_localctx).ide!=null?((Primary_expressionContext)_localctx).ide.getText():null))); 
				            postfixSymbol = Symbol.get((((Primary_expressionContext)_localctx).ide!=null?((Primary_expressionContext)_localctx).ide.getText():null));
				        
				}
				break;
			case Hex:
			case Dec:
			case Oct:
				enterOuterAlt(_localctx, 2);
				{
				setState(673);
				((Primary_expressionContext)_localctx).ic = integer_constant();
				((Primary_expressionContext)_localctx).ret =  ((Primary_expressionContext)_localctx).ic.ret; 
				}
				break;
			case CHARACTERLITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(676);
				((Primary_expressionContext)_localctx).cc = character_constant();
				((Primary_expressionContext)_localctx).ret =  ((Primary_expressionContext)_localctx).cc.ret; 
				}
				break;
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(679);
				((Primary_expressionContext)_localctx).sl = match(STRINGLITERAL);
				((Primary_expressionContext)_localctx).ret =  new StringConst((((Primary_expressionContext)_localctx).sl!=null?((Primary_expressionContext)_localctx).sl.getText():null)); 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 5);
				{
				setState(681);
				match(T__1);
				setState(682);
				((Primary_expressionContext)_localctx).expr = expression();
				setState(683);
				match(T__2);
				((Primary_expressionContext)_localctx).ret =  ((Primary_expressionContext)_localctx).expr.ret; 
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

	public static class Integer_constantContext extends ParserRuleContext {
		public IntConst ret;
		public Token Hex;
		public Token Dec;
		public Token Oct;
		public TerminalNode Hex() { return getToken(CParser.Hex, 0); }
		public TerminalNode Dec() { return getToken(CParser.Dec, 0); }
		public TerminalNode Oct() { return getToken(CParser.Oct, 0); }
		public Integer_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInteger_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInteger_constant(this);
		}
	}

	public final Integer_constantContext integer_constant() throws RecognitionException {
		Integer_constantContext _localctx = new Integer_constantContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_integer_constant);
		try {
			setState(694);
			switch (_input.LA(1)) {
			case Hex:
				enterOuterAlt(_localctx, 1);
				{
				setState(688);
				((Integer_constantContext)_localctx).Hex = match(Hex);
				((Integer_constantContext)_localctx).ret =  new IntConst(Integer.parseInt(((Integer_constantContext)_localctx).Hex.getText().substring(2), 16));
				}
				break;
			case Dec:
				enterOuterAlt(_localctx, 2);
				{
				setState(690);
				((Integer_constantContext)_localctx).Dec = match(Dec);
				((Integer_constantContext)_localctx).ret =  new IntConst((((Integer_constantContext)_localctx).Dec!=null?Integer.valueOf(((Integer_constantContext)_localctx).Dec.getText()):0));
				}
				break;
			case Oct:
				enterOuterAlt(_localctx, 3);
				{
				setState(692);
				((Integer_constantContext)_localctx).Oct = match(Oct);
				((Integer_constantContext)_localctx).ret =  new IntConst(Integer.parseInt(((Integer_constantContext)_localctx).Oct.getText(), 8));
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

	public static class Character_constantContext extends ParserRuleContext {
		public CharConst ret;
		public Token c;
		public TerminalNode CHARACTERLITERAL() { return getToken(CParser.CHARACTERLITERAL, 0); }
		public Character_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterCharacter_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitCharacter_constant(this);
		}
	}

	public final Character_constantContext character_constant() throws RecognitionException {
		Character_constantContext _localctx = new Character_constantContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_character_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			((Character_constantContext)_localctx).c = match(CHARACTERLITERAL);
			((Character_constantContext)_localctx).ret = new CharConst(new StringBuilder((((Character_constantContext)_localctx).c!=null?((Character_constantContext)_localctx).c.getText():null)).toString());
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3D\u02be\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\6\2h\n"+
		"\2\r\2\16\2i\3\3\3\3\3\3\5\3o\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4{\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0088\n"+
		"\5\f\5\16\5\u008b\13\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0093\n\6\f\6\16\6"+
		"\u0096\13\6\3\7\3\7\3\7\7\7\u009b\n\7\f\7\16\7\u009e\13\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00a6\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\7\t\u00b5\n\t\f\t\16\t\u00b8\13\t\3\t\3\t\3\t\5\t\u00bd\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c9\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\6\n\u00d1\n\n\r\n\16\n\u00d2\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00dc"+
		"\n\n\3\13\3\13\3\13\3\13\5\13\u00e2\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f1\n\r\f\r\16\r\u00f4\13\r\3\r\3\r\3\16"+
		"\3\16\3\16\7\16\u00fb\n\16\f\16\16\16\u00fe\13\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0112\n\17\3\20\3\20\3\20\3\20\5\20\u0118\n\20\3\20\3\20\3\21\3"+
		"\21\3\21\7\21\u011f\n\21\f\21\16\21\u0122\13\21\3\21\3\21\3\21\7\21\u0127"+
		"\n\21\f\21\16\21\u012a\13\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u013b\n\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u014d"+
		"\n\23\3\23\3\23\3\23\3\23\5\23\u0153\n\23\3\23\3\23\3\23\3\23\5\23\u0159"+
		"\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0160\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u016d\n\24\3\24\3\24\5\24\u0171\n"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0179\n\25\f\25\16\25\u017c\13"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0186\n\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u019e\n\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u01a9\n\31\f\31\16\31\u01ac\13\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\7\32\u01b4\n\32\f\32\16\32\u01b7\13\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\7\33\u01bf\n\33\f\33\16\33\u01c2\13\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\7\34\u01ca\n\34\f\34\16\34\u01cd\13\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\7\35\u01d5\n\35\f\35\16\35\u01d8\13\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\7\36\u01e0\n\36\f\36\16\36\u01e3\13\36\3\37\3\37"+
		"\3\37\3\37\5\37\u01e9\n\37\3 \3 \3 \3 \3 \3 \7 \u01f1\n \f \16 \u01f4"+
		"\13 \3!\3!\3!\3!\3!\3!\3!\3!\5!\u01fe\n!\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0206"+
		"\n\"\f\"\16\"\u0209\13\"\3#\3#\3#\3#\5#\u020f\n#\3$\3$\3$\3$\3$\3$\7$"+
		"\u0217\n$\f$\16$\u021a\13$\3%\3%\3%\3%\5%\u0220\n%\3&\3&\3&\3&\3&\3&\7"+
		"&\u0228\n&\f&\16&\u022b\13&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0233\n\'\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\5(\u023e\n(\3)\3)\3)\3)\7)\u0244\n)\f)\16)\u0247"+
		"\13)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\5*\u0262\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0270\n"+
		"+\3,\3,\3,\3,\3,\7,\u0277\n,\f,\16,\u027a\13,\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\5-\u0286\n-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u0294\n-\3."+
		"\3.\3.\3.\3.\3.\3.\7.\u029d\n.\f.\16.\u02a0\13.\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\3/\5/\u02b1\n/\3\60\3\60\3\60\3\60\3\60\3\60\5\60"+
		"\u02b9\n\60\3\61\3\61\3\61\3\61\2\2\62\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`\2\2\u02e7\2b\3\2\2\2"+
		"\4k\3\2\2\2\6r\3\2\2\2\b\u0080\3\2\2\2\n\u008c\3\2\2\2\f\u0097\3\2\2\2"+
		"\16\u009f\3\2\2\2\20\u00bc\3\2\2\2\22\u00db\3\2\2\2\24\u00e1\3\2\2\2\26"+
		"\u00e3\3\2\2\2\30\u00e8\3\2\2\2\32\u00f7\3\2\2\2\34\u0111\3\2\2\2\36\u0113"+
		"\3\2\2\2 \u011b\3\2\2\2\"\u012e\3\2\2\2$\u015f\3\2\2\2&\u0170\3\2\2\2"+
		"(\u0172\3\2\2\2*\u0185\3\2\2\2,\u019d\3\2\2\2.\u019f\3\2\2\2\60\u01a2"+
		"\3\2\2\2\62\u01ad\3\2\2\2\64\u01b8\3\2\2\2\66\u01c3\3\2\2\28\u01ce\3\2"+
		"\2\2:\u01d9\3\2\2\2<\u01e8\3\2\2\2>\u01ea\3\2\2\2@\u01fd\3\2\2\2B\u01ff"+
		"\3\2\2\2D\u020e\3\2\2\2F\u0210\3\2\2\2H\u021f\3\2\2\2J\u0221\3\2\2\2L"+
		"\u0232\3\2\2\2N\u023d\3\2\2\2P\u023f\3\2\2\2R\u0261\3\2\2\2T\u026f\3\2"+
		"\2\2V\u0271\3\2\2\2X\u0293\3\2\2\2Z\u0295\3\2\2\2\\\u02b0\3\2\2\2^\u02b8"+
		"\3\2\2\2`\u02ba\3\2\2\2bg\b\2\1\2cd\b\2\1\2dh\5\4\3\2ef\b\2\1\2fh\5\6"+
		"\4\2gc\3\2\2\2ge\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\3\3\2\2\2kl\5"+
		"\22\n\2ln\b\3\1\2mo\5\f\7\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\3\2\2q\5"+
		"\3\2\2\2rs\b\4\1\2st\5\22\n\2tu\b\4\1\2uv\5\32\16\2vz\7\4\2\2wx\5\b\5"+
		"\2xy\b\4\1\2y{\3\2\2\2zw\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\5\2\2}~\5 \21"+
		"\2~\177\b\4\1\2\177\7\3\2\2\2\u0080\u0081\b\5\1\2\u0081\u0082\5\26\f\2"+
		"\u0082\u0089\b\5\1\2\u0083\u0084\7\6\2\2\u0084\u0085\5\26\f\2\u0085\u0086"+
		"\b\5\1\2\u0086\u0088\3\2\2\2\u0087\u0083\3\2\2\2\u0088\u008b\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\t\3\2\2\2\u008b\u0089\3\2\2\2"+
		"\u008c\u008d\5\30\r\2\u008d\u0094\b\6\1\2\u008e\u008f\7\6\2\2\u008f\u0090"+
		"\5\30\r\2\u0090\u0091\b\6\1\2\u0091\u0093\3\2\2\2\u0092\u008e\3\2\2\2"+
		"\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\13"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009c\5\16\b\2\u0098\u0099\7\6\2\2"+
		"\u0099\u009b\5\16\b\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\r\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\b\b\1\2\u00a0\u00a5\5\30\r\2\u00a1\u00a2\7\7\2\2\u00a2\u00a3\5"+
		"\20\t\2\u00a3\u00a4\b\b\1\2\u00a4\u00a6\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\b\1\2\u00a8\17\3\2\2"+
		"\2\u00a9\u00aa\5*\26\2\u00aa\u00ab\b\t\1\2\u00ab\u00bd\3\2\2\2\u00ac\u00ad"+
		"\b\t\1\2\u00ad\u00ae\7\b\2\2\u00ae\u00af\5\20\t\2\u00af\u00b6\b\t\1\2"+
		"\u00b0\u00b1\7\6\2\2\u00b1\u00b2\5\20\t\2\u00b2\u00b3\b\t\1\2\u00b3\u00b5"+
		"\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\t"+
		"\2\2\u00ba\u00bb\b\t\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00a9\3\2\2\2\u00bc"+
		"\u00ac\3\2\2\2\u00bd\21\3\2\2\2\u00be\u00bf\7\n\2\2\u00bf\u00dc\b\n\1"+
		"\2\u00c0\u00c1\7\13\2\2\u00c1\u00dc\b\n\1\2\u00c2\u00c3\7\f\2\2\u00c3"+
		"\u00dc\b\n\1\2\u00c4\u00c5\b\n\1\2\u00c5\u00c8\5\24\13\2\u00c6\u00c7\7"+
		"D\2\2\u00c7\u00c9\b\n\1\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00d0\7\b\2\2\u00cb\u00cc\5\22\n\2\u00cc\u00cd\b"+
		"\n\1\2\u00cd\u00ce\5\n\6\2\u00ce\u00cf\7\3\2\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00cb\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\t\2\2\u00d5\u00d6\b\n\1\2\u00d6"+
		"\u00dc\3\2\2\2\u00d7\u00d8\5\24\13\2\u00d8\u00d9\7D\2\2\u00d9\u00da\b"+
		"\n\1\2\u00da\u00dc\3\2\2\2\u00db\u00be\3\2\2\2\u00db\u00c0\3\2\2\2\u00db"+
		"\u00c2\3\2\2\2\u00db\u00c4\3\2\2\2\u00db\u00d7\3\2\2\2\u00dc\23\3\2\2"+
		"\2\u00dd\u00de\7\r\2\2\u00de\u00e2\b\13\1\2\u00df\u00e0\7\16\2\2\u00e0"+
		"\u00e2\b\13\1\2\u00e1\u00dd\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\25\3\2\2"+
		"\2\u00e3\u00e4\5\22\n\2\u00e4\u00e5\b\f\1\2\u00e5\u00e6\5\30\r\2\u00e6"+
		"\u00e7\b\f\1\2\u00e7\27\3\2\2\2\u00e8\u00e9\b\r\1\2\u00e9\u00ea\5\32\16"+
		"\2\u00ea\u00f2\b\r\1\2\u00eb\u00ec\7\17\2\2\u00ec\u00ed\5.\30\2\u00ed"+
		"\u00ee\7\20\2\2\u00ee\u00ef\b\r\1\2\u00ef\u00f1\3\2\2\2\u00f0\u00eb\3"+
		"\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\b\r\1\2\u00f6\31\3\2\2"+
		"\2\u00f7\u00fc\b\16\1\2\u00f8\u00f9\7\21\2\2\u00f9\u00fb\b\16\1\2\u00fa"+
		"\u00f8\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\7D\2\2\u0100"+
		"\u0101\b\16\1\2\u0101\33\3\2\2\2\u0102\u0103\5\36\20\2\u0103\u0104\b\17"+
		"\1\2\u0104\u0112\3\2\2\2\u0105\u0106\5 \21\2\u0106\u0107\b\17\1\2\u0107"+
		"\u0112\3\2\2\2\u0108\u0109\5\"\22\2\u0109\u010a\b\17\1\2\u010a\u0112\3"+
		"\2\2\2\u010b\u010c\5$\23\2\u010c\u010d\b\17\1\2\u010d\u0112\3\2\2\2\u010e"+
		"\u010f\5&\24\2\u010f\u0110\b\17\1\2\u0110\u0112\3\2\2\2\u0111\u0102\3"+
		"\2\2\2\u0111\u0105\3\2\2\2\u0111\u0108\3\2\2\2\u0111\u010b\3\2\2\2\u0111"+
		"\u010e\3\2\2\2\u0112\35\3\2\2\2\u0113\u0117\b\20\1\2\u0114\u0115\5(\25"+
		"\2\u0115\u0116\b\20\1\2\u0116\u0118\3\2\2\2\u0117\u0114\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\7\3\2\2\u011a\37\3\2\2"+
		"\2\u011b\u011c\b\21\1\2\u011c\u0120\7\b\2\2\u011d\u011f\5\4\3\2\u011e"+
		"\u011d\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0128\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\5\34\17\2\u0124"+
		"\u0125\b\21\1\2\u0125\u0127\3\2\2\2\u0126\u0123\3\2\2\2\u0127\u012a\3"+
		"\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012b\u012c\7\t\2\2\u012c\u012d\b\21\1\2\u012d!\3\2\2\2"+
		"\u012e\u012f\b\22\1\2\u012f\u0130\7\22\2\2\u0130\u0131\7\4\2\2\u0131\u0132"+
		"\5(\25\2\u0132\u0133\b\22\1\2\u0133\u0134\7\5\2\2\u0134\u0135\5\34\17"+
		"\2\u0135\u013a\b\22\1\2\u0136\u0137\7\23\2\2\u0137\u0138\5\34\17\2\u0138"+
		"\u0139\b\22\1\2\u0139\u013b\3\2\2\2\u013a\u0136\3\2\2\2\u013a\u013b\3"+
		"\2\2\2\u013b#\3\2\2\2\u013c\u013d\b\23\1\2\u013d\u013e\7\24\2\2\u013e"+
		"\u013f\7\4\2\2\u013f\u0140\5(\25\2\u0140\u0141\b\23\1\2\u0141\u0142\7"+
		"\5\2\2\u0142\u0143\5\34\17\2\u0143\u0144\b\23\1\2\u0144\u0145\b\23\1\2"+
		"\u0145\u0160\3\2\2\2\u0146\u0147\b\23\1\2\u0147\u0148\7\25\2\2\u0148\u014c"+
		"\7\4\2\2\u0149\u014a\5(\25\2\u014a\u014b\b\23\1\2\u014b\u014d\3\2\2\2"+
		"\u014c\u0149\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0152"+
		"\7\3\2\2\u014f\u0150\5(\25\2\u0150\u0151\b\23\1\2\u0151\u0153\3\2\2\2"+
		"\u0152\u014f\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0158"+
		"\7\3\2\2\u0155\u0156\5(\25\2\u0156\u0157\b\23\1\2\u0157\u0159\3\2\2\2"+
		"\u0158\u0155\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b"+
		"\7\5\2\2\u015b\u015c\5\34\17\2\u015c\u015d\b\23\1\2\u015d\u015e\b\23\1"+
		"\2\u015e\u0160\3\2\2\2\u015f\u013c\3\2\2\2\u015f\u0146\3\2\2\2\u0160%"+
		"\3\2\2\2\u0161\u0162\b\24\1\2\u0162\u0163\7\26\2\2\u0163\u0171\7\3\2\2"+
		"\u0164\u0165\b\24\1\2\u0165\u0166\7\27\2\2\u0166\u0171\7\3\2\2\u0167\u0168"+
		"\b\24\1\2\u0168\u016c\7\30\2\2\u0169\u016a\5(\25\2\u016a\u016b\b\24\1"+
		"\2\u016b\u016d\3\2\2\2\u016c\u0169\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e"+
		"\3\2\2\2\u016e\u016f\7\3\2\2\u016f\u0171\b\24\1\2\u0170\u0161\3\2\2\2"+
		"\u0170\u0164\3\2\2\2\u0170\u0167\3\2\2\2\u0171\'\3\2\2\2\u0172\u0173\5"+
		"*\26\2\u0173\u017a\b\25\1\2\u0174\u0175\7\6\2\2\u0175\u0176\5*\26\2\u0176"+
		"\u0177\b\25\1\2\u0177\u0179\3\2\2\2\u0178\u0174\3\2\2\2\u0179\u017c\3"+
		"\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b)\3\2\2\2\u017c\u017a"+
		"\3\2\2\2\u017d\u017e\5\60\31\2\u017e\u017f\b\26\1\2\u017f\u0186\3\2\2"+
		"\2\u0180\u0181\5R*\2\u0181\u0182\5,\27\2\u0182\u0183\5*\26\2\u0183\u0184"+
		"\b\26\1\2\u0184\u0186\3\2\2\2\u0185\u017d\3\2\2\2\u0185\u0180\3\2\2\2"+
		"\u0186+\3\2\2\2\u0187\u0188\7\7\2\2\u0188\u019e\b\27\1\2\u0189\u018a\7"+
		"\31\2\2\u018a\u019e\b\27\1\2\u018b\u018c\7\32\2\2\u018c\u019e\b\27\1\2"+
		"\u018d\u018e\7\33\2\2\u018e\u019e\b\27\1\2\u018f\u0190\7\34\2\2\u0190"+
		"\u019e\b\27\1\2\u0191\u0192\7\35\2\2\u0192\u019e\b\27\1\2\u0193\u0194"+
		"\7\36\2\2\u0194\u019e\b\27\1\2\u0195\u0196\7\37\2\2\u0196\u019e\b\27\1"+
		"\2\u0197\u0198\7 \2\2\u0198\u019e\b\27\1\2\u0199\u019a\7!\2\2\u019a\u019e"+
		"\b\27\1\2\u019b\u019c\7\"\2\2\u019c\u019e\b\27\1\2\u019d\u0187\3\2\2\2"+
		"\u019d\u0189\3\2\2\2\u019d\u018b\3\2\2\2\u019d\u018d\3\2\2\2\u019d\u018f"+
		"\3\2\2\2\u019d\u0191\3\2\2\2\u019d\u0193\3\2\2\2\u019d\u0195\3\2\2\2\u019d"+
		"\u0197\3\2\2\2\u019d\u0199\3\2\2\2\u019d\u019b\3\2\2\2\u019e-\3\2\2\2"+
		"\u019f\u01a0\5\60\31\2\u01a0\u01a1\b\30\1\2\u01a1/\3\2\2\2\u01a2\u01a3"+
		"\5\62\32\2\u01a3\u01aa\b\31\1\2\u01a4\u01a5\7#\2\2\u01a5\u01a6\5\62\32"+
		"\2\u01a6\u01a7\b\31\1\2\u01a7\u01a9\3\2\2\2\u01a8\u01a4\3\2\2\2\u01a9"+
		"\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\61\3\2\2"+
		"\2\u01ac\u01aa\3\2\2\2\u01ad\u01ae\5\64\33\2\u01ae\u01b5\b\32\1\2\u01af"+
		"\u01b0\7$\2\2\u01b0\u01b1\5\64\33\2\u01b1\u01b2\b\32\1\2\u01b2\u01b4\3"+
		"\2\2\2\u01b3\u01af\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6\63\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01b9\5\66\34"+
		"\2\u01b9\u01c0\b\33\1\2\u01ba\u01bb\7%\2\2\u01bb\u01bc\5\66\34\2\u01bc"+
		"\u01bd\b\33\1\2\u01bd\u01bf\3\2\2\2\u01be\u01ba\3\2\2\2\u01bf\u01c2\3"+
		"\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\65\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c3\u01c4\58\35\2\u01c4\u01cb\b\34\1\2\u01c5\u01c6\7"+
		"&\2\2\u01c6\u01c7\58\35\2\u01c7\u01c8\b\34\1\2\u01c8\u01ca\3\2\2\2\u01c9"+
		"\u01c5\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2"+
		"\2\2\u01cc\67\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01cf\5:\36\2\u01cf\u01d6"+
		"\b\35\1\2\u01d0\u01d1\7\'\2\2\u01d1\u01d2\5:\36\2\u01d2\u01d3\b\35\1\2"+
		"\u01d3\u01d5\3\2\2\2\u01d4\u01d0\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4"+
		"\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d79\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9"+
		"\u01da\5> \2\u01da\u01e1\b\36\1\2\u01db\u01dc\5<\37\2\u01dc\u01dd\5> "+
		"\2\u01dd\u01de\b\36\1\2\u01de\u01e0\3\2\2\2\u01df\u01db\3\2\2\2\u01e0"+
		"\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2;\3\2\2\2"+
		"\u01e3\u01e1\3\2\2\2\u01e4\u01e5\7(\2\2\u01e5\u01e9\b\37\1\2\u01e6\u01e7"+
		"\7)\2\2\u01e7\u01e9\b\37\1\2\u01e8\u01e4\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9"+
		"=\3\2\2\2\u01ea\u01eb\5B\"\2\u01eb\u01f2\b \1\2\u01ec\u01ed\5@!\2\u01ed"+
		"\u01ee\5B\"\2\u01ee\u01ef\b \1\2\u01ef\u01f1\3\2\2\2\u01f0\u01ec\3\2\2"+
		"\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3?"+
		"\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f6\7*\2\2\u01f6\u01fe\b!\1\2\u01f7"+
		"\u01f8\7+\2\2\u01f8\u01fe\b!\1\2\u01f9\u01fa\7,\2\2\u01fa\u01fe\b!\1\2"+
		"\u01fb\u01fc\7-\2\2\u01fc\u01fe\b!\1\2\u01fd\u01f5\3\2\2\2\u01fd\u01f7"+
		"\3\2\2\2\u01fd\u01f9\3\2\2\2\u01fd\u01fb\3\2\2\2\u01feA\3\2\2\2\u01ff"+
		"\u0200\5F$\2\u0200\u0207\b\"\1\2\u0201\u0202\5D#\2\u0202\u0203\5F$\2\u0203"+
		"\u0204\b\"\1\2\u0204\u0206\3\2\2\2\u0205\u0201\3\2\2\2\u0206\u0209\3\2"+
		"\2\2\u0207\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208C\3\2\2\2\u0209\u0207"+
		"\3\2\2\2\u020a\u020b\7.\2\2\u020b\u020f\b#\1\2\u020c\u020d\7/\2\2\u020d"+
		"\u020f\b#\1\2\u020e\u020a\3\2\2\2\u020e\u020c\3\2\2\2\u020fE\3\2\2\2\u0210"+
		"\u0211\5J&\2\u0211\u0218\b$\1\2\u0212\u0213\5H%\2\u0213\u0214\5J&\2\u0214"+
		"\u0215\b$\1\2\u0215\u0217\3\2\2\2\u0216\u0212\3\2\2\2\u0217\u021a\3\2"+
		"\2\2\u0218\u0216\3\2\2\2\u0218\u0219\3\2\2\2\u0219G\3\2\2\2\u021a\u0218"+
		"\3\2\2\2\u021b\u021c\7\60\2\2\u021c\u0220\b%\1\2\u021d\u021e\7\61\2\2"+
		"\u021e\u0220\b%\1\2\u021f\u021b\3\2\2\2\u021f\u021d\3\2\2\2\u0220I\3\2"+
		"\2\2\u0221\u0222\5N(\2\u0222\u0229\b&\1\2\u0223\u0224\5L\'\2\u0224\u0225"+
		"\5N(\2\u0225\u0226\b&\1\2\u0226\u0228\3\2\2\2\u0227\u0223\3\2\2\2\u0228"+
		"\u022b\3\2\2\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022aK\3\2\2\2"+
		"\u022b\u0229\3\2\2\2\u022c\u022d\7\21\2\2\u022d\u0233\b\'\1\2\u022e\u022f"+
		"\7\62\2\2\u022f\u0233\b\'\1\2\u0230\u0231\7\63\2\2\u0231\u0233\b\'\1\2"+
		"\u0232\u022c\3\2\2\2\u0232\u022e\3\2\2\2\u0232\u0230\3\2\2\2\u0233M\3"+
		"\2\2\2\u0234\u0235\5R*\2\u0235\u0236\b(\1\2\u0236\u023e\3\2\2\2\u0237"+
		"\u0238\7\4\2\2\u0238\u0239\5P)\2\u0239\u023a\7\5\2\2\u023a\u023b\5N(\2"+
		"\u023b\u023c\b(\1\2\u023c\u023e\3\2\2\2\u023d\u0234\3\2\2\2\u023d\u0237"+
		"\3\2\2\2\u023eO\3\2\2\2\u023f\u0240\5\22\n\2\u0240\u0245\b)\1\2\u0241"+
		"\u0242\7\21\2\2\u0242\u0244\b)\1\2\u0243\u0241\3\2\2\2\u0244\u0247\3\2"+
		"\2\2\u0245\u0243\3\2\2\2\u0245\u0246\3\2\2\2\u0246Q\3\2\2\2\u0247\u0245"+
		"\3\2\2\2\u0248\u0249\5V,\2\u0249\u024a\b*\1\2\u024a\u0262\3\2\2\2\u024b"+
		"\u024c\7\64\2\2\u024c\u024d\5R*\2\u024d\u024e\b*\1\2\u024e\u0262\3\2\2"+
		"\2\u024f\u0250\7\65\2\2\u0250\u0251\5R*\2\u0251\u0252\b*\1\2\u0252\u0262"+
		"\3\2\2\2\u0253\u0254\5T+\2\u0254\u0255\5N(\2\u0255\u0256\b*\1\2\u0256"+
		"\u0262\3\2\2\2\u0257\u0258\7\66\2\2\u0258\u0259\5R*\2\u0259\u025a\b*\1"+
		"\2\u025a\u0262\3\2\2\2\u025b\u025c\7\66\2\2\u025c\u025d\7\4\2\2\u025d"+
		"\u025e\5P)\2\u025e\u025f\7\5\2\2\u025f\u0260\b*\1\2\u0260\u0262\3\2\2"+
		"\2\u0261\u0248\3\2\2\2\u0261\u024b\3\2\2\2\u0261\u024f\3\2\2\2\u0261\u0253"+
		"\3\2\2\2\u0261\u0257\3\2\2\2\u0261\u025b\3\2\2\2\u0262S\3\2\2\2\u0263"+
		"\u0264\7\'\2\2\u0264\u0270\b+\1\2\u0265\u0266\7\21\2\2\u0266\u0270\b+"+
		"\1\2\u0267\u0268\7\60\2\2\u0268\u0270\b+\1\2\u0269\u026a\7\61\2\2\u026a"+
		"\u0270\b+\1\2\u026b\u026c\7\67\2\2\u026c\u0270\b+\1\2\u026d\u026e\78\2"+
		"\2\u026e\u0270\b+\1\2\u026f\u0263\3\2\2\2\u026f\u0265\3\2\2\2\u026f\u0267"+
		"\3\2\2\2\u026f\u0269\3\2\2\2\u026f\u026b\3\2\2\2\u026f\u026d\3\2\2\2\u0270"+
		"U\3\2\2\2\u0271\u0272\5\\/\2\u0272\u0278\b,\1\2\u0273\u0274\5X-\2\u0274"+
		"\u0275\b,\1\2\u0275\u0277\3\2\2\2\u0276\u0273\3\2\2\2\u0277\u027a\3\2"+
		"\2\2\u0278\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279W\3\2\2\2\u027a\u0278"+
		"\3\2\2\2\u027b\u027c\7\17\2\2\u027c\u027d\5(\25\2\u027d\u027e\7\20\2\2"+
		"\u027e\u027f\b-\1\2\u027f\u0294\3\2\2\2\u0280\u0281\b-\1\2\u0281\u0285"+
		"\7\4\2\2\u0282\u0283\5Z.\2\u0283\u0284\b-\1\2\u0284\u0286\3\2\2\2\u0285"+
		"\u0282\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0288\7\5"+
		"\2\2\u0288\u0294\b-\1\2\u0289\u028a\79\2\2\u028a\u028b\7D\2\2\u028b\u0294"+
		"\b-\1\2\u028c\u028d\7:\2\2\u028d\u028e\7D\2\2\u028e\u0294\b-\1\2\u028f"+
		"\u0290\7\64\2\2\u0290\u0294\b-\1\2\u0291\u0292\7\65\2\2\u0292\u0294\b"+
		"-\1\2\u0293\u027b\3\2\2\2\u0293\u0280\3\2\2\2\u0293\u0289\3\2\2\2\u0293"+
		"\u028c\3\2\2\2\u0293\u028f\3\2\2\2\u0293\u0291\3\2\2\2\u0294Y\3\2\2\2"+
		"\u0295\u0296\b.\1\2\u0296\u0297\5*\26\2\u0297\u029e\b.\1\2\u0298\u0299"+
		"\7\6\2\2\u0299\u029a\5*\26\2\u029a\u029b\b.\1\2\u029b\u029d\3\2\2\2\u029c"+
		"\u0298\3\2\2\2\u029d\u02a0\3\2\2\2\u029e\u029c\3\2\2\2\u029e\u029f\3\2"+
		"\2\2\u029f[\3\2\2\2\u02a0\u029e\3\2\2\2\u02a1\u02a2\7D\2\2\u02a2\u02b1"+
		"\b/\1\2\u02a3\u02a4\5^\60\2\u02a4\u02a5\b/\1\2\u02a5\u02b1\3\2\2\2\u02a6"+
		"\u02a7\5`\61\2\u02a7\u02a8\b/\1\2\u02a8\u02b1\3\2\2\2\u02a9\u02aa\7C\2"+
		"\2\u02aa\u02b1\b/\1\2\u02ab\u02ac\7\4\2\2\u02ac\u02ad\5(\25\2\u02ad\u02ae"+
		"\7\5\2\2\u02ae\u02af\b/\1\2\u02af\u02b1\3\2\2\2\u02b0\u02a1\3\2\2\2\u02b0"+
		"\u02a3\3\2\2\2\u02b0\u02a6\3\2\2\2\u02b0\u02a9\3\2\2\2\u02b0\u02ab\3\2"+
		"\2\2\u02b1]\3\2\2\2\u02b2\u02b3\7?\2\2\u02b3\u02b9\b\60\1\2\u02b4\u02b5"+
		"\7@\2\2\u02b5\u02b9\b\60\1\2\u02b6\u02b7\7A\2\2\u02b7\u02b9\b\60\1\2\u02b8"+
		"\u02b2\3\2\2\2\u02b8\u02b4\3\2\2\2\u02b8\u02b6\3\2\2\2\u02b9_\3\2\2\2"+
		"\u02ba\u02bb\7B\2\2\u02bb\u02bc\b\61\1\2\u02bca\3\2\2\29ginz\u0089\u0094"+
		"\u009c\u00a5\u00b6\u00bc\u00c8\u00d2\u00db\u00e1\u00f2\u00fc\u0111\u0117"+
		"\u0120\u0128\u013a\u014c\u0152\u0158\u015f\u016c\u0170\u017a\u0185\u019d"+
		"\u01aa\u01b5\u01c0\u01cb\u01d6\u01e1\u01e8\u01f2\u01fd\u0207\u020e\u0218"+
		"\u021f\u0229\u0232\u023d\u0245\u0261\u026f\u0278\u0285\u0293\u029e\u02b0"+
		"\u02b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}