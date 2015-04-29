 grammar C;

 @header{
    package compiler2015.syntactic;
    import compiler2015.ast.*;
    import java.util.*;
 }

@parser::members {
    private List<Decl> curDecls;
    private List<VarDecl> curFields;
    private Type curType;
    private int nAnonymous; 
    private int postfixType;
    private Expr postfixExpr;
    private List<Expr> postfixArgs;
    private Symbol postfixSymbol;
    public final static int SPAN = 4;
}

/* Parser Rules */
 program returns [AST ret] 
    : {$ret = new AST();} ({curDecls = $ret.decls; } declaration
    |                      {curDecls = $ret.decls; } function_definition)+ 
    ;


 declaration 
    : ts = type_specifier {curType = $ts.ret;} init_declarators? ';' 
    ;
 
 function_definition
    : {List<VarDecl> params = new LinkedList<VarDecl>(); }
        ts = type_specifier {curType = $ts.ret; }
        pd = plain_declarator 
        '(' (pa = parameters {params = $pa.ret; })? ')' 
        cs = compound_statement 
        {
            curDecls.add(new FunctionDecl($pd.ret.type, $pd.ret.name, params, $cs.ret));
        }
    ;
 
 parameters returns [List<VarDecl> ret]
    : {$ret = new LinkedList<VarDecl>(); }
        fpd = plain_declaration {$ret.add($fpd.ret); }
        (',' spd = plain_declaration {$ret.add($spd.ret); })* ;
 
 declarators 
    : d1 = declarator {curFields.add($d1.ret); } 
        (',' d2 = declarator {curFields.add($d2.ret); })* ;
 
 init_declarators
    : id1 = init_declarator 
        (',' id2 = init_declarator )* ;
 
 init_declarator
    : {Initializer init = null; }
      d = declarator ('=' tmp = initializer {init = $tmp.ret; })? 
    {
        $d.ret.init = init;
        curDecls.add($d.ret);
    }
    ;
 
 initializer returns [Initializer ret]
    : ax = assignment_expression {$ret = new InitValue($ax.ret); }
    | 
    {
        List<Initializer> inits = new LinkedList<Initializer>(); 
    }
        '{' init1 = initializer {inits.add($init1.ret); }
        (',' init2 = initializer {inits.add($init2.ret); })* '}' 
        {$ret = new InitList(inits); }
    ;
 
 type_specifier returns [Type ret]
    : 'void' {$ret = new VoidType(); } 
    | 'char' {$ret = new CharType(); }
    | 'int'  {$ret = new IntType(); }
    | 
    {
        String id = "#" + (Integer)(nAnonymous++);
        List<VarDecl> fields = new LinkedList<VarDecl>();
        List<VarDecl> oldFields = curFields;
        curFields = fields;
    }
        sou = struct_or_union 
        (ide = Identifier {nAnonymous--; id = $ide.text;})? 
        '{' (ts = type_specifier {curType = $ts.ret; } declarators ';')+ '}'
        {
            curFields = oldFields;
            if ($sou.ret == Symbol.get("struct")) {
                curDecls.add(new StructDecl(Symbol.get(id), fields));
                $ret = new StructType(Symbol.get(id));
            } else {
                curDecls.add(new UnionDecl(Symbol.get(id), fields));
                $ret = new UnionType(Symbol.get(id));
            }
        }
    | 
        sou = struct_or_union ide = Identifier 
        {
            if ($sou.ret == Symbol.get("struct")) {
                $ret = new StructType(Symbol.get($ide.text));
            } else {
                $ret = new UnionType(Symbol.get($ide.text));
            }
        }
    ;
 
 struct_or_union returns [Symbol ret] 
    : 'struct' {$ret = Symbol.get("struct"); }
    | 'union'  {$ret = Symbol.get("union"); }
    ;
 
 plain_declaration returns [VarDecl ret]
    : ts = type_specifier {curType = $ts.ret; } decl = declarator
        {
            $ret = new VarDecl($decl.ret.type, $decl.ret.name, $decl.ret.init);
        }
    ;
 
 declarator returns [VarDecl ret]
    : 
        {
            $ret = new VarDecl(); 
            List<Expr> list = new LinkedList<Expr>();
        }
        pd = plain_declarator 
        {$ret.type = $pd.ret.type; $ret.name = $pd.ret.name; } 
        ('[' ce = constant_expression ']' {list.add($ce.ret); })*
        {
            for (int i = list.size() - 1; i >= 0; i--) {
                $ret.type = new ArrayType($ret.type, list.get(i));
            }
        }
    ;
 
 plain_declarator returns [VarDecl ret]
    : {$ret = new VarDecl(curType, Symbol.get(""), null); } 
        ('*'{$ret.type = new PointerType($ret.type); })* 
        ide = Identifier {$ret.name = Symbol.get($ide.text); };


 statement returns [Stmt ret]
    : es = expression_statement {$ret = $es.ret; }
    | cs = compound_statement {$ret = $cs.ret; }
    | ss = selection_statement {$ret = $ss.ret; }
    | it = iteration_statement {$ret = $it.ret; }
    | js = jump_statement {$ret = $js.ret; }
    ;
 
 expression_statement returns [Expr ret]
    : {$ret = new EmptyExpr(); }
        (expr = expression {$ret = $expr.ret; })? ';' 
    ;
 
 compound_statement returns [CompoundStmt ret]
    : 
        {
            $ret = new CompoundStmt(new LinkedList<Decl>(), new LinkedList<Stmt>());
            List<Decl> oldDecls = curDecls;
            curDecls = $ret.decls;
        } 
        '{' 
        declaration* 
        (sta = statement {$ret.stats.add($sta.ret); })* 
        '}' 
        {
            curDecls = oldDecls;
        }
    ;
 
 selection_statement returns [IfStmt ret]
    : {$ret = new IfStmt(); }
        'if' '(' 
        expr = expression {$ret.condition = $expr.ret; }
        ')' 
        stat = statement {$ret.consequent = $stat.ret; }
        ('else' stat2 = statement {$ret.alternative = $stat2.ret; })? 
    ;
 
 iteration_statement returns [Stmt ret]
    : {WhileLoop tmp = new WhileLoop(); }
        'while' '(' 
        expr = expression {tmp.condition = $expr.ret; } 
        ')' 
        stat = statement {tmp.body = $stat.ret; }
        {$ret = tmp; }
    | {ForLoop tmp = new ForLoop(new EmptyExpr(), new EmptyExpr(), new EmptyExpr(), null); }
        'for' '(' 
        (expr1 = expression {tmp.init = $expr1.ret; })? ';' 
        (expr2 = expression {tmp.condition = $expr2.ret; })? ';' 
        (expr3 = expression {tmp.step = $expr3.ret; })? ')' 
        stat = statement {tmp.body = $stat.ret; }
        {$ret = tmp; }
    ;
 
 jump_statement returns [Stmt ret]
    : {$ret = new ContinueStmt(); } 'continue' ';'
    | {$ret = new BreakStmt(); } 'break' ';'
    | {ReturnStmt tmp = new ReturnStmt(new EmptyExpr()); } 'return' 
        (expr = expression {tmp.expr = $expr.ret;})? ';' {$ret = tmp; } 
    ;


 expression returns [Expr ret]
    : ae1 = assignment_expression {$ret = $ae1.ret; }
        (',' ae2 = assignment_expression 
            {$ret = new BinaryExpr($ret, BinaryOp.COMMA, $ae2.ret); })* 
    ;
 
 assignment_expression returns [Expr ret]
    : loe = logical_or_expression {$ret = $loe.ret; }
    | ue = unary_expression ao = assignment_operator ae = assignment_expression 
        {$ret = new BinaryExpr($ue.ret, $ao.ret, $ae.ret); }
    ;
 
 assignment_operator returns [BinaryOp ret]
    : '=' {$ret = BinaryOp.ASSIGN; } 
    | '*=' {$ret = BinaryOp.ASSIGN_MUL; }
    | '/=' {$ret = BinaryOp.ASSIGN_DIV; }
    | '%=' {$ret = BinaryOp.ASSIGN_MOD; }
    | '+=' {$ret = BinaryOp.ASSIGN_ADD; }
    | '-=' {$ret = BinaryOp.ASSIGN_SUB; }
    | '<<=' {$ret = BinaryOp.ASSIGN_SHL; }
    | '>>=' {$ret = BinaryOp.ASSIGN_SHR; }
    | '&=' {$ret = BinaryOp.ASSIGN_AND; }
    | '^=' {$ret = BinaryOp.ASSIGN_XOR; }
    | '|=' {$ret = BinaryOp.ASSIGN_OR;}
    ;
 
 constant_expression returns [Expr ret]
    : loe = logical_or_expression {$ret = $loe.ret; } 
    ;
 
 logical_or_expression returns [Expr ret]
    : lae = logical_and_expression {$ret = $lae.ret; }
        ('||' lae2 = logical_and_expression 
            {$ret = new BinaryExpr($ret, BinaryOp.LOGICAL_OR, $lae2.ret); })* 
    ;
 
 logical_and_expression returns [Expr ret]
    : ioe = inclusive_or_expression {$ret = $ioe.ret; }
        ('&&' ioe2 = inclusive_or_expression
            {$ret = new BinaryExpr($ret, BinaryOp.LOGICAL_AND, $ioe2.ret); })* 
    ;
 
 inclusive_or_expression returns [Expr ret]
    : eoe = exclusive_or_expression {$ret = $eoe.ret; }
        ('|' eoe2 = exclusive_or_expression
            {$ret = new BinaryExpr($ret, BinaryOp.OR, $eoe2.ret); })* 
    ;
 
 exclusive_or_expression returns [Expr ret]
    : ae = and_expression {$ret = $ae.ret; }
        ('^' ae2 = and_expression {$ret = new BinaryExpr($ret, BinaryOp.XOR, $ae2.ret); })* 
    ;
 
 and_expression returns [Expr ret]
    : ee = equality_expression {$ret = $ee.ret; }
        ('&' ee2 = equality_expression {$ret = new BinaryExpr($ret, BinaryOp.AND, $ee2.ret); })* 
    ;
 
 equality_expression returns [Expr ret]
    : re = relational_expression {$ret = $re.ret; }
        (eo = equality_operator re2 = relational_expression
        {$ret = new BinaryExpr($ret, $eo.ret, $re2.ret); })* 
    ;
 
 equality_operator returns [BinaryOp ret]
    : '==' {$ret = BinaryOp.EQ; }
    | '!=' {$ret = BinaryOp.NE; }
    ;
 
 relational_expression returns [Expr ret]
    : se = shift_expression {$ret = $se.ret; }
        (ro = relational_operator se2 = shift_expression
        {$ret = new BinaryExpr($ret, $ro.ret, $se2.ret); })* 
    ;
 
 relational_operator returns [BinaryOp ret]
    : '<' {$ret = BinaryOp.LT; }
    | '>' {$ret = BinaryOp.GT; }
    | '<=' {$ret = BinaryOp.LE; }
    | '>=' {$ret = BinaryOp.GE; }
    ;
 
 shift_expression returns [Expr ret]
    : ae = additive_expression {$ret = $ae.ret; }
        (so = shift_operator ae2 = additive_expression
        {$ret = new BinaryExpr($ret, $so.ret, $ae2.ret); })* 
    ;
 
 shift_operator returns [BinaryOp ret]
    : '<<' {$ret = BinaryOp.SHL; }
    | '>>' {$ret = BinaryOp.SHR; }
    ;
 
 additive_expression returns [Expr ret]
    : me = multiplicative_expression {$ret = $me.ret; }
        (ao = additive_operator me2 = multiplicative_expression
        {$ret = new BinaryExpr($ret, $ao.ret, $me2.ret); })* 
    ;
 
 additive_operator returns [BinaryOp ret]
    : '+' {$ret = BinaryOp.ADD; }
    | '-' {$ret = BinaryOp.SUB; }
    ;
 
 multiplicative_expression returns [Expr ret]
    : ce = cast_expression {$ret = $ce.ret; } 
        (mo = multiplicative_operator ce2 = cast_expression
        {$ret = new BinaryExpr($ret, $mo.ret, $ce2.ret); })* 
    ;
 
 multiplicative_operator returns [BinaryOp ret]
    : '*' {$ret = BinaryOp.MUL; }
    | '/' {$ret = BinaryOp.DIV; }
    | '%' {$ret = BinaryOp.MOD; }
    ;
 
 cast_expression returns [Expr ret]
    : ue = unary_expression {$ret = $ue.ret; }
    | '(' tn = type_name ')' ce = cast_expression 
        {$ret = new CastExpr($tn.ret, $ce.ret); }
    ;
 
 type_name returns [Type ret]
    : ts = type_specifier {$ret = $ts.ret; }
        ('*' {$ret = new PointerType($ret); })* 
    ;
 
 unary_expression returns [Expr ret]
    : pe = postfix_expression {$ret = $pe.ret; }
    | '++' ue = unary_expression {$ret = new UnaryExpr(UnaryOp.INC, $ue.ret); }
    | '--' ue = unary_expression {$ret = new UnaryExpr(UnaryOp.DEC, $ue.ret); }
    | uo = unary_operator ce = cast_expression {$ret = new UnaryExpr($uo.ret, $ce.ret); }
    | 'sizeof' ue = unary_expression {$ret = new UnaryExpr(UnaryOp.SIZEOF, $ue.ret); }
    | 'sizeof' '(' tn = type_name ')' {$ret = new SizeofExpr($tn.ret); } 
    ;
 
 unary_operator returns [UnaryOp ret]
    : '&' {$ret = UnaryOp.AMPERSAND; }
    | '*' {$ret = UnaryOp.ASTERISK; }
    | '+' {$ret = UnaryOp.PLUS; }
    | '-' {$ret = UnaryOp.MINUS; }
    | '~' {$ret = UnaryOp.TILDE; }
    | '!' {$ret = UnaryOp.NOT; }
    ;
 
 postfix_expression returns [Expr ret]
    : pe = primary_expression 
        {
            $ret = $pe.ret;  
            Symbol sym = null;
            if (postfixSymbol != null) {
                sym = Symbol.get(postfixSymbol.toString());
            }
        }
        (postfix 
        {
            if (postfixType == 1) {
                $ret = new ArrayAccess($ret, postfixExpr);
            } else if (postfixType == 2) {
                $ret = new FunctionCall(sym, postfixArgs);
            } else if (postfixType == 3) {
                $ret = new RecordAccess($ret, postfixSymbol);
            } else if (postfixType == 4) {
                $ret = new PointerAccess($ret, postfixSymbol);
            } else if (postfixType == 5) {
                $ret = new SelfIncrement($ret);
            } else if (postfixType == 6) {
                $ret = new SelfDecrement($ret);
            }
        }
        )* 
    ;
 
 postfix
    : '[' expr = expression ']' {postfixType = 1; postfixExpr = $expr.ret; }
    | {postfixArgs = new LinkedList<Expr>(); } 
        '(' (args = arguments {postfixArgs = $args.ret; } )? ')' {postfixType = 2; }
    | '.' ide = Identifier      {postfixType = 3; postfixSymbol = Symbol.get($ide.text); }
    | '->' ide = Identifier     {postfixType = 4; postfixSymbol = Symbol.get($ide.text); }
    | '++'                      {postfixType = 5; }
    | '--'                      {postfixType = 6; }
    ;      
 
 arguments returns [List<Expr> ret]
    : {$ret = new LinkedList<Expr>(); }
        ae = assignment_expression {$ret.add($ae.ret); }
        (',' ae2 = assignment_expression {$ret.add($ae2.ret); })* 
    ;
 
 primary_expression returns [Expr ret]
    : ide = Identifier 
        {
            $ret = new Identifier(Symbol.get($ide.text)); 
            postfixSymbol = Symbol.get($ide.text);
        }
    | ic = integer_constant {$ret = $ic.ret; }
    | cc = character_constant {$ret = $cc.ret; }
    | sl = STRINGLITERAL {$ret = new StringConst($sl.text); }
    | '(' expr = expression ')' {$ret = $expr.ret; } 
    ;


integer_constant returns [IntConst ret]
  : Hex {$ret = new IntConst(Integer.parseInt($Hex.getText().substring(2), 16));}
  | Dec {$ret = new IntConst($Dec.int);}
  | Oct {$ret = new IntConst(Integer.parseInt($Oct.getText(), 8));}
  ;

character_constant returns[CharConst ret]
  : c=CHARACTERLITERAL {$ret=new CharConst(new StringBuilder($c.text).toString());}
  ;

// LEXER =====================================================

Whitespace : [ \r\t\n]+ -> channel(HIDDEN);

fragment EOL : '\r' | '\n' | ('\r''\n') ;

Multi_comment : '/*' .*? '*/' -> channel(HIDDEN);
Single_comment : '//' ~[\r\n]* (EOL) -> channel(HIDDEN);
Preprocessing : '#' ~[\r\n]* (EOL) -> channel(HIDDEN);

Hex : '0' ('x'|'X') HexDigit+ ;
Dec : '0' | ([1-9] Digit*)  ;
Oct : '0' OctDigit+  ;

fragment Digit : [0-9];
fragment HexDigit : (Digit | [a-f] | [A-F]) ;
fragment OctDigit : [0-7] ;
fragment Letter: '$' | [A-Z] | '_' |  [a-z];

CHARACTERLITERAL : '\'' ( ('\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')) 
    | ~('\''|'\\') ) '\'' 
    | '\'\\' OctDigit OctDigit OctDigit '\''
    | '\'\\' ('0x'|'0X') HexDigit HexDigit'\'';
STRINGLITERAL : '"' ( ('\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')) | ~('\\'|'"') )* '"' ;

Identifier : Letter (Letter | Digit)*;
