// Generated from C.g4 by ANTLR 4.5

    package compiler2015.syntactic;
    import compiler2015.ast.*;
    import java.util.*;
 
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CParser}.
 */
public interface CListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(CParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(CParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(CParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(CParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#declarators}.
	 * @param ctx the parse tree
	 */
	void enterDeclarators(CParser.DeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#declarators}.
	 * @param ctx the parse tree
	 */
	void exitDeclarators(CParser.DeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#init_declarators}.
	 * @param ctx the parse tree
	 */
	void enterInit_declarators(CParser.Init_declaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#init_declarators}.
	 * @param ctx the parse tree
	 */
	void exitInit_declarators(CParser.Init_declaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#init_declarator}.
	 * @param ctx the parse tree
	 */
	void enterInit_declarator(CParser.Init_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#init_declarator}.
	 * @param ctx the parse tree
	 */
	void exitInit_declarator(CParser.Init_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(CParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(CParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterType_specifier(CParser.Type_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitType_specifier(CParser.Type_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#struct_or_union}.
	 * @param ctx the parse tree
	 */
	void enterStruct_or_union(CParser.Struct_or_unionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#struct_or_union}.
	 * @param ctx the parse tree
	 */
	void exitStruct_or_union(CParser.Struct_or_unionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#plain_declaration}.
	 * @param ctx the parse tree
	 */
	void enterPlain_declaration(CParser.Plain_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#plain_declaration}.
	 * @param ctx the parse tree
	 */
	void exitPlain_declaration(CParser.Plain_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(CParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(CParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#plain_declarator}.
	 * @param ctx the parse tree
	 */
	void enterPlain_declarator(CParser.Plain_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#plain_declarator}.
	 * @param ctx the parse tree
	 */
	void exitPlain_declarator(CParser.Plain_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(CParser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(CParser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(CParser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(CParser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void enterSelection_statement(CParser.Selection_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void exitSelection_statement(CParser.Selection_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void enterIteration_statement(CParser.Iteration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void exitIteration_statement(CParser.Iteration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void enterJump_statement(CParser.Jump_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void exitJump_statement(CParser.Jump_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_expression(CParser.Assignment_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_expression(CParser.Assignment_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_operator(CParser.Assignment_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_operator(CParser.Assignment_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant_expression(CParser.Constant_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant_expression(CParser.Constant_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_or_expression(CParser.Logical_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_or_expression(CParser.Logical_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_and_expression(CParser.Logical_and_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_and_expression(CParser.Logical_and_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterInclusive_or_expression(CParser.Inclusive_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitInclusive_or_expression(CParser.Inclusive_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterExclusive_or_expression(CParser.Exclusive_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitExclusive_or_expression(CParser.Exclusive_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expression(CParser.And_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expression(CParser.And_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expression(CParser.Equality_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expression(CParser.Equality_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void enterEquality_operator(CParser.Equality_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void exitEquality_operator(CParser.Equality_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expression(CParser.Relational_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expression(CParser.Relational_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator(CParser.Relational_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator(CParser.Relational_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShift_expression(CParser.Shift_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShift_expression(CParser.Shift_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#shift_operator}.
	 * @param ctx the parse tree
	 */
	void enterShift_operator(CParser.Shift_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#shift_operator}.
	 * @param ctx the parse tree
	 */
	void exitShift_operator(CParser.Shift_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expression(CParser.Additive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expression(CParser.Additive_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#additive_operator}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_operator(CParser.Additive_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#additive_operator}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_operator(CParser.Additive_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expression(CParser.Multiplicative_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expression(CParser.Multiplicative_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#multiplicative_operator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_operator(CParser.Multiplicative_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#multiplicative_operator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_operator(CParser.Multiplicative_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void enterCast_expression(CParser.Cast_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void exitCast_expression(CParser.Cast_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#type_name}.
	 * @param ctx the parse tree
	 */
	void enterType_name(CParser.Type_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#type_name}.
	 * @param ctx the parse tree
	 */
	void exitType_name(CParser.Type_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(CParser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(CParser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(CParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(CParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expression(CParser.Postfix_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expression(CParser.Postfix_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(CParser.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(CParser.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(CParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(CParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(CParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(CParser.Primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#integer_constant}.
	 * @param ctx the parse tree
	 */
	void enterInteger_constant(CParser.Integer_constantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#integer_constant}.
	 * @param ctx the parse tree
	 */
	void exitInteger_constant(CParser.Integer_constantContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#character_constant}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_constant(CParser.Character_constantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#character_constant}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_constant(CParser.Character_constantContext ctx);
}