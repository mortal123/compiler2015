// Generated from Grammar.g4 by ANTLR 4.5

    package Grammar;
 
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(GrammarParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(GrammarParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(GrammarParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(GrammarParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declarators}.
	 * @param ctx the parse tree
	 */
	void enterDeclarators(GrammarParser.DeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declarators}.
	 * @param ctx the parse tree
	 */
	void exitDeclarators(GrammarParser.DeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#init_declarators}.
	 * @param ctx the parse tree
	 */
	void enterInit_declarators(GrammarParser.Init_declaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#init_declarators}.
	 * @param ctx the parse tree
	 */
	void exitInit_declarators(GrammarParser.Init_declaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#init_declarator}.
	 * @param ctx the parse tree
	 */
	void enterInit_declarator(GrammarParser.Init_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#init_declarator}.
	 * @param ctx the parse tree
	 */
	void exitInit_declarator(GrammarParser.Init_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(GrammarParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(GrammarParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterType_specifier(GrammarParser.Type_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitType_specifier(GrammarParser.Type_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#struct_or_union}.
	 * @param ctx the parse tree
	 */
	void enterStruct_or_union(GrammarParser.Struct_or_unionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#struct_or_union}.
	 * @param ctx the parse tree
	 */
	void exitStruct_or_union(GrammarParser.Struct_or_unionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#plain_declaration}.
	 * @param ctx the parse tree
	 */
	void enterPlain_declaration(GrammarParser.Plain_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#plain_declaration}.
	 * @param ctx the parse tree
	 */
	void exitPlain_declaration(GrammarParser.Plain_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(GrammarParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(GrammarParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#plain_declarator}.
	 * @param ctx the parse tree
	 */
	void enterPlain_declarator(GrammarParser.Plain_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#plain_declarator}.
	 * @param ctx the parse tree
	 */
	void exitPlain_declarator(GrammarParser.Plain_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(GrammarParser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(GrammarParser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(GrammarParser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(GrammarParser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void enterSelection_statement(GrammarParser.Selection_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void exitSelection_statement(GrammarParser.Selection_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void enterIteration_statement(GrammarParser.Iteration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void exitIteration_statement(GrammarParser.Iteration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void enterJump_statement(GrammarParser.Jump_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void exitJump_statement(GrammarParser.Jump_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_expression(GrammarParser.Assignment_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_expression(GrammarParser.Assignment_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_operator(GrammarParser.Assignment_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_operator(GrammarParser.Assignment_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant_expression(GrammarParser.Constant_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant_expression(GrammarParser.Constant_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_or_expression(GrammarParser.Logical_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_or_expression(GrammarParser.Logical_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_and_expression(GrammarParser.Logical_and_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_and_expression(GrammarParser.Logical_and_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterInclusive_or_expression(GrammarParser.Inclusive_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitInclusive_or_expression(GrammarParser.Inclusive_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterExclusive_or_expression(GrammarParser.Exclusive_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitExclusive_or_expression(GrammarParser.Exclusive_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expression(GrammarParser.And_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expression(GrammarParser.And_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expression(GrammarParser.Equality_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expression(GrammarParser.Equality_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void enterEquality_operator(GrammarParser.Equality_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void exitEquality_operator(GrammarParser.Equality_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expression(GrammarParser.Relational_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expression(GrammarParser.Relational_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator(GrammarParser.Relational_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator(GrammarParser.Relational_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShift_expression(GrammarParser.Shift_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShift_expression(GrammarParser.Shift_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#shift_operator}.
	 * @param ctx the parse tree
	 */
	void enterShift_operator(GrammarParser.Shift_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#shift_operator}.
	 * @param ctx the parse tree
	 */
	void exitShift_operator(GrammarParser.Shift_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expression(GrammarParser.Additive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expression(GrammarParser.Additive_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#additive_operator}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_operator(GrammarParser.Additive_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#additive_operator}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_operator(GrammarParser.Additive_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expression(GrammarParser.Multiplicative_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expression(GrammarParser.Multiplicative_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#multiplicative_operator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_operator(GrammarParser.Multiplicative_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#multiplicative_operator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_operator(GrammarParser.Multiplicative_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void enterCast_expression(GrammarParser.Cast_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void exitCast_expression(GrammarParser.Cast_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type_name}.
	 * @param ctx the parse tree
	 */
	void enterType_name(GrammarParser.Type_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type_name}.
	 * @param ctx the parse tree
	 */
	void exitType_name(GrammarParser.Type_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(GrammarParser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(GrammarParser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(GrammarParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(GrammarParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expression(GrammarParser.Postfix_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expression(GrammarParser.Postfix_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(GrammarParser.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(GrammarParser.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(GrammarParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(GrammarParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(GrammarParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(GrammarParser.Primary_expressionContext ctx);
}