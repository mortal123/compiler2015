 grammar Grammar;

 program: (declaration | function_definition)+ ;


 declaration: type_specifier init_declarators? ';' ;
 
 function_definition: type_specifier plain_declarator '(' parameters? ')' compound_statement ;
 
 parameters: plain_declaration (',' plain_declaration)* ;
 
 declarators: declarator (',' declarator)* ;
 
 init_declarators: init_declarator (',' init_declarator)* ;
 
 init_declarator: declarator ('=' initializer)? ;
 
 initializer: assignment_expression
            | '{' initializer (',' initializer)* '}' ;
 
 type_specifier: 'void' | 'char' | 'int'
               | struct_or_union Identifier? '{' (type_specifier declarators ';')+ '}'
               | struct_or_union Identifier ;
 
 struct_or_union: 'struct' | 'union' ;
 
 plain_declaration: type_specifier declarator ;
 
 declarator: plain_declarator '(' parameters? ')'
           | plain_declarator ('[' constant_expression ']')* ;
 
 plain_declarator: '*'* Identifier ;


 statement: expression_statement
          | compound_statement
          | selection_statement
          | iteration_statement
          | jump_statement ;
 
 expression_statement: expression? ';' ;
 
 compound_statement: '{' declaration* statement* '}' ;
 
 selection_statement: 'if' '(' expression ')' statement ('else' statement)? ;
 
 iteration_statement: 'while' '(' expression ')' statement
                    | 'for' '(' expression? ';' expression? ';' expression? ')' statement ;
 
 jump_statement: 'continue' ';'
               | 'break' ';'
               | 'return' expression? ';' ;



 expression: assignment_expression (',' assignment_expression)* ;
 
 assignment_expression: logical_or_expression
                      | unary_expression assignment_operator assignment_expression ;
 
 assignment_operator: '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' ;
 
 constant_expression: logical_or_expression ;
 
 logical_or_expression: logical_and_expression ('||' logical_and_expression)* ;
 
 logical_and_expression: inclusive_or_expression ('&&' inclusive_or_expression)* ;
 
 inclusive_or_expression: exclusive_or_expression ('|' exclusive_or_expression)* ;
 
 exclusive_or_expression: and_expression ('^' and_expression)* ;
 
 and_expression: equality_expression ('&' equality_expression)* ;
 
 equality_expression: relational_expression (equality_operator relational_expression)* ;
 
 equality_operator: '==' | '!=' ;
 
 relational_expression: shift_expression (relational_operator shift_expression)* ;
 
 relational_operator: '<' | '>' | '<=' | '>=' ;
 
 shift_expression: additive_expression (shift_operator additive_expression)* ;
 
 shift_operator: '<<' | '>>' ;
 
 additive_expression: multiplicative_expression (additive_operator multiplicative_expression)* ;
 
 additive_operator: '+' | '-' ;
 
 multiplicative_expression: cast_expression (multiplicative_operator cast_expression)* ;
 
 multiplicative_operator: '*' | '/' | '%' ;
 
 cast_expression: unary_expression
                | '(' type_name ')' cast_expression ;
 
 type_name: type_specifier '*'* ;
 
 unary_expression: postfix_expression
                 | '++' unary_expression
                 | '--' unary_expression
                 | unary_operator cast_expression
                 | 'sizeof' unary_expression
                 | 'sizeof' '(' type_name ')' ;
 
 unary_operator: '&' | '*' | '+' | '-' | '~' | '!' ;
 
 postfix_expression: primary_expression postfix* ;
 
 postfix: '[' expression ']'
        | '(' arguments? ')'
        | '.' Identifier
        | '->' Identifier
        | '++'
        | '--' ;
 
 arguments: assignment_expression (',' assignment_expression)* ;
 
 primary_expression: Identifier
                   | Constant
                   | StringLiteral
                   | '(' expression ')' ;






  Identifier
    :   IdentifierNondigit
        (   IdentifierNondigit
        |   Digit
        )*
    ;

fragment
IdentifierNondigit
    :   Nondigit
    |   UniversalCharacterName
    //|   // other implementation-defined characters...
    ;

fragment
Nondigit
    :   [a-zA-Z_]
    ;

fragment
Digit
    :   [0-9]
    ;

fragment
UniversalCharacterName
    :   '\\u' HexQuad
    |   '\\U' HexQuad HexQuad
    ;

fragment
HexQuad
    :   HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit
    ;

Constant
    :   IntegerConstant
    |   CharacterConstant
    ;

fragment
IntegerConstant
    :   DecimalConstant IntegerSuffix?
    |   OctalConstant IntegerSuffix?
    |   HexadecimalConstant IntegerSuffix?
    ;

fragment
DecimalConstant
    :   NonzeroDigit Digit*
    ;

fragment
OctalConstant
    :   '0' OctalDigit*
    ;

fragment
HexadecimalConstant
    :   HexadecimalPrefix HexadecimalDigit+
    ;

fragment
HexadecimalPrefix
    :   '0' [xX]
    ;

fragment
NonzeroDigit
    :   [1-9]
    ;

fragment
OctalDigit
    :   [0-7]
    ;

fragment
HexadecimalDigit
    :   [0-9a-fA-F]
    ;

fragment
IntegerSuffix
    :   UnsignedSuffix LongSuffix?
    |   UnsignedSuffix LongLongSuffix
    |   LongSuffix UnsignedSuffix?
    |   LongLongSuffix UnsignedSuffix?
    ;

fragment
UnsignedSuffix
    :   [uU]
    ;

fragment
LongSuffix
    :   [lL]
    ;

fragment
LongLongSuffix
    :   'll' | 'LL'
    ;

fragment
FloatingConstant
    :   DecimalFloatingConstant
    |   HexadecimalFloatingConstant
    ;

fragment
DecimalFloatingConstant
    :   FractionalConstant ExponentPart? FloatingSuffix?
    |   DigitSequence ExponentPart FloatingSuffix?
    ;

fragment
HexadecimalFloatingConstant
    :   HexadecimalPrefix HexadecimalFractionalConstant BinaryExponentPart FloatingSuffix?
    |   HexadecimalPrefix HexadecimalDigitSequence BinaryExponentPart FloatingSuffix?
    ;

fragment
FractionalConstant
    :   DigitSequence? '.' DigitSequence
    |   DigitSequence '.'
    ;

fragment
ExponentPart
    :   'e' Sign? DigitSequence
    |   'E' Sign? DigitSequence
    ;

fragment
Sign
    :   '+' | '-'
    ;

fragment
DigitSequence
    :   Digit+
    ;

fragment
HexadecimalFractionalConstant
    :   HexadecimalDigitSequence? '.' HexadecimalDigitSequence
    |   HexadecimalDigitSequence '.'
    ;

fragment
BinaryExponentPart
    :   'p' Sign? DigitSequence
    |   'P' Sign? DigitSequence
    ;

fragment
HexadecimalDigitSequence
    :   HexadecimalDigit+
    ;

fragment
FloatingSuffix
    :   'f' | 'l' | 'F' | 'L'
    ;

fragment
CharacterConstant
    :   '\'' CCharSequence '\''
    |   'L\'' CCharSequence '\''
    |   'u\'' CCharSequence '\''
    |   'U\'' CCharSequence '\''
    ;

fragment
CCharSequence
    :   CChar+
    ;

fragment
CChar
    :   ~['\\\r\n]
    |   EscapeSequence
    ;
fragment
EscapeSequence
    :   SimpleEscapeSequence
    |   OctalEscapeSequence
    |   HexadecimalEscapeSequence
    |   UniversalCharacterName
    ;
fragment
SimpleEscapeSequence
    :   '\\' ['"?abfnrtv\\]
    ;
fragment
OctalEscapeSequence
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' OctalDigit OctalDigit OctalDigit
    ;
fragment
HexadecimalEscapeSequence
    :   '\\x' HexadecimalDigit+
    ;
StringLiteral
    :   EncodingPrefix? '"' SCharSequence? '"'
    ;
fragment
EncodingPrefix
    :   'u8'
    |   'u'
    |   'U'
    |   'L'
    ;
fragment
SCharSequence
    :   SChar+
    ;
fragment
SChar
    :   ~["\\\r\n]
    |   EscapeSequence
    ;

LineDirective
    :   '#' Whitespace? DecimalConstant Whitespace? StringLiteral ~[\r\n]*
        -> skip
    ;

PragmaDirective
    :   '#' Whitespace? 'pragma' Whitespace ~[\r\n]*
        -> skip
    ;

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;