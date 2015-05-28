/*
 * generated by Xtext
 */
grammar InternalVxl;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package de.dailab.vsdt.vxl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package de.dailab.vsdt.vxl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.dailab.vsdt.vxl.services.VxlGrammarAccess;

}

@parser::members {

 	private VxlGrammarAccess grammarAccess;
 	
    public InternalVxlParser(TokenStream input, VxlGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "VxlTerm";	
   	}
   	
   	@Override
   	protected VxlGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleVxlTerm
entryRuleVxlTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlTermRule()); }
	 iv_ruleVxlTerm=ruleVxlTerm 
	 { $current=$iv_ruleVxlTerm.current; } 
	 EOF 
;

// Rule VxlTerm
ruleVxlTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getVxlTermAccess().getHeadVxlElementParserRuleCall_0_0()); 
	    }
		lv_head_0_0=ruleVxlElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlTermRule());
	        }
       		set(
       			$current, 
       			"head",
        		lv_head_0_0, 
        		"VxlElement");
	        afterParserOrEnumRuleCall();
	    }

)
)((
(
		{ 
	        newCompositeNode(grammarAccess.getVxlTermAccess().getOperatorVxlOperatorEnumRuleCall_1_0_0()); 
	    }
		lv_operator_1_0=ruleVxlOperator		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlTermRule());
	        }
       		set(
       			$current, 
       			"operator",
        		lv_operator_1_0, 
        		"VxlOperator");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlTermAccess().getTailVxlTermParserRuleCall_1_1_0()); 
	    }
		lv_tail_2_0=ruleVxlTerm		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlTermRule());
	        }
       		set(
       			$current, 
       			"tail",
        		lv_tail_2_0, 
        		"VxlTerm");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleVxlElement
entryRuleVxlElement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlElementRule()); }
	 iv_ruleVxlElement=ruleVxlElement 
	 { $current=$iv_ruleVxlElement.current; } 
	 EOF 
;

// Rule VxlElement
ruleVxlElement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getVxlElementAccess().getVxlBracketTermParserRuleCall_0()); 
    }
    this_VxlBracketTerm_0=ruleVxlBracketTerm
    { 
        $current = $this_VxlBracketTerm_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlElementAccess().getVxlNegationParserRuleCall_1()); 
    }
    this_VxlNegation_1=ruleVxlNegation
    { 
        $current = $this_VxlNegation_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlElementAccess().getVxlMinusParserRuleCall_2()); 
    }
    this_VxlMinus_2=ruleVxlMinus
    { 
        $current = $this_VxlMinus_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlElementAccess().getVxlValueParserRuleCall_3()); 
    }
    this_VxlValue_3=ruleVxlValue
    { 
        $current = $this_VxlValue_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlElementAccess().getVxlVariableParserRuleCall_4()); 
    }
    this_VxlVariable_4=ruleVxlVariable
    { 
        $current = $this_VxlVariable_4.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlElementAccess().getVxlListParserRuleCall_5()); 
    }
    this_VxlList_5=ruleVxlList
    { 
        $current = $this_VxlList_5.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlElementAccess().getVxlCardinalityParserRuleCall_6()); 
    }
    this_VxlCardinality_6=ruleVxlCardinality
    { 
        $current = $this_VxlCardinality_6.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlElementAccess().getVxlFunctionParserRuleCall_7()); 
    }
    this_VxlFunction_7=ruleVxlFunction
    { 
        $current = $this_VxlFunction_7.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlElementAccess().getVxlConstructorParserRuleCall_8()); 
    }
    this_VxlConstructor_8=ruleVxlConstructor
    { 
        $current = $this_VxlConstructor_8.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleVxlBracketTerm
entryRuleVxlBracketTerm returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlBracketTermRule()); }
	 iv_ruleVxlBracketTerm=ruleVxlBracketTerm 
	 { $current=$iv_ruleVxlBracketTerm.current; } 
	 EOF 
;

// Rule VxlBracketTerm
ruleVxlBracketTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='(' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVxlBracketTermAccess().getLeftParenthesisKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlBracketTermAccess().getTermVxlTermParserRuleCall_1_0()); 
	    }
		lv_term_1_0=ruleVxlTerm		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlBracketTermRule());
	        }
       		set(
       			$current, 
       			"term",
        		lv_term_1_0, 
        		"VxlTerm");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=')' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getVxlBracketTermAccess().getRightParenthesisKeyword_2());
    }
)
;





// Entry rule entryRuleVxlNegation
entryRuleVxlNegation returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlNegationRule()); }
	 iv_ruleVxlNegation=ruleVxlNegation 
	 { $current=$iv_ruleVxlNegation.current; } 
	 EOF 
;

// Rule VxlNegation
ruleVxlNegation returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='not' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVxlNegationAccess().getNotKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlNegationAccess().getElementVxlElementParserRuleCall_1_0()); 
	    }
		lv_element_1_0=ruleVxlElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlNegationRule());
	        }
       		set(
       			$current, 
       			"element",
        		lv_element_1_0, 
        		"VxlElement");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleVxlMinus
entryRuleVxlMinus returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlMinusRule()); }
	 iv_ruleVxlMinus=ruleVxlMinus 
	 { $current=$iv_ruleVxlMinus.current; } 
	 EOF 
;

// Rule VxlMinus
ruleVxlMinus returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='-' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVxlMinusAccess().getHyphenMinusKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlMinusAccess().getElementVxlElementParserRuleCall_1_0()); 
	    }
		lv_element_1_0=ruleVxlElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlMinusRule());
	        }
       		set(
       			$current, 
       			"element",
        		lv_element_1_0, 
        		"VxlElement");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleVxlCardinality
entryRuleVxlCardinality returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlCardinalityRule()); }
	 iv_ruleVxlCardinality=ruleVxlCardinality 
	 { $current=$iv_ruleVxlCardinality.current; } 
	 EOF 
;

// Rule VxlCardinality
ruleVxlCardinality returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='#' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVxlCardinalityAccess().getNumberSignKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlCardinalityAccess().getElementVxlElementParserRuleCall_1_0()); 
	    }
		lv_element_1_0=ruleVxlElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlCardinalityRule());
	        }
       		set(
       			$current, 
       			"element",
        		lv_element_1_0, 
        		"VxlElement");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleVxlVariable
entryRuleVxlVariable returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlVariableRule()); }
	 iv_ruleVxlVariable=ruleVxlVariable 
	 { $current=$iv_ruleVxlVariable.current; } 
	 EOF 
;

// Rule VxlVariable
ruleVxlVariable returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getVxlVariableAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlVariableRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlVariableAccess().getAccessorVxlAccessorParserRuleCall_1_0()); 
	    }
		lv_accessor_1_0=ruleVxlAccessor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlVariableRule());
	        }
       		set(
       			$current, 
       			"accessor",
        		lv_accessor_1_0, 
        		"VxlAccessor");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleVxlAccessor
entryRuleVxlAccessor returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlAccessorRule()); }
	 iv_ruleVxlAccessor=ruleVxlAccessor 
	 { $current=$iv_ruleVxlAccessor.current; } 
	 EOF 
;

// Rule VxlAccessor
ruleVxlAccessor returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlArrayAccessorParserRuleCall_0()); 
    }
    this_VxlArrayAccessor_0=ruleVxlArrayAccessor
    { 
        $current = $this_VxlArrayAccessor_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlFieldAccessorParserRuleCall_1()); 
    }
    this_VxlFieldAccessor_1=ruleVxlFieldAccessor
    { 
        $current = $this_VxlFieldAccessor_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlMethodAccessorParserRuleCall_2()); 
    }
    this_VxlMethodAccessor_2=ruleVxlMethodAccessor
    { 
        $current = $this_VxlMethodAccessor_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleVxlArrayAccessor
entryRuleVxlArrayAccessor returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlArrayAccessorRule()); }
	 iv_ruleVxlArrayAccessor=ruleVxlArrayAccessor 
	 { $current=$iv_ruleVxlArrayAccessor.current; } 
	 EOF 
;

// Rule VxlArrayAccessor
ruleVxlArrayAccessor returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVxlArrayAccessorAccess().getLeftSquareBracketKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getIndexVxlTermParserRuleCall_1_0()); 
	    }
		lv_index_1_0=ruleVxlTerm		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlArrayAccessorRule());
	        }
       		set(
       			$current, 
       			"index",
        		lv_index_1_0, 
        		"VxlTerm");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=']' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getVxlArrayAccessorAccess().getRightSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getAccessorVxlAccessorParserRuleCall_3_0()); 
	    }
		lv_accessor_3_0=ruleVxlAccessor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlArrayAccessorRule());
	        }
       		set(
       			$current, 
       			"accessor",
        		lv_accessor_3_0, 
        		"VxlAccessor");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleVxlFieldAccessor
entryRuleVxlFieldAccessor returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlFieldAccessorRule()); }
	 iv_ruleVxlFieldAccessor=ruleVxlFieldAccessor 
	 { $current=$iv_ruleVxlFieldAccessor.current; } 
	 EOF 
;

// Rule VxlFieldAccessor
ruleVxlFieldAccessor returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='.' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVxlFieldAccessorAccess().getFullStopKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getVxlFieldAccessorAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlFieldAccessorRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlFieldAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0()); 
	    }
		lv_accessor_2_0=ruleVxlAccessor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlFieldAccessorRule());
	        }
       		set(
       			$current, 
       			"accessor",
        		lv_accessor_2_0, 
        		"VxlAccessor");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleVxlMethodAccessor
entryRuleVxlMethodAccessor returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlMethodAccessorRule()); }
	 iv_ruleVxlMethodAccessor=ruleVxlMethodAccessor 
	 { $current=$iv_ruleVxlMethodAccessor.current; } 
	 EOF 
;

// Rule VxlMethodAccessor
ruleVxlMethodAccessor returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='.' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVxlMethodAccessorAccess().getFullStopKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlMethodAccessorAccess().getFunctionVxlFunctionParserRuleCall_1_0()); 
	    }
		lv_function_1_0=ruleVxlFunction		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlMethodAccessorRule());
	        }
       		set(
       			$current, 
       			"function",
        		lv_function_1_0, 
        		"VxlFunction");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlMethodAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0()); 
	    }
		lv_accessor_2_0=ruleVxlAccessor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlMethodAccessorRule());
	        }
       		set(
       			$current, 
       			"accessor",
        		lv_accessor_2_0, 
        		"VxlAccessor");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleVxlList
entryRuleVxlList returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlListRule()); }
	 iv_ruleVxlList=ruleVxlList 
	 { $current=$iv_ruleVxlList.current; } 
	 EOF 
;

// Rule VxlList
ruleVxlList returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVxlListAccess().getLeftSquareBracketKeyword_0());
    }
((
(
		lv_empty_1_0=	']' 
    {
        newLeafNode(lv_empty_1_0, grammarAccess.getVxlListAccess().getEmptyRightSquareBracketKeyword_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlListRule());
	        }
       		setWithLastConsumed($current, "empty", true, "]");
	    }

)
)
    |((
(
		{ 
	        newCompositeNode(grammarAccess.getVxlListAccess().getBodyVxlListElementParserRuleCall_1_1_0_0()); 
	    }
		lv_body_2_0=ruleVxlListElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlListRule());
	        }
       		set(
       			$current, 
       			"body",
        		lv_body_2_0, 
        		"VxlListElement");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=']' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVxlListAccess().getRightSquareBracketKeyword_1_1_1());
    }
)))
;





// Entry rule entryRuleVxlListElement
entryRuleVxlListElement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlListElementRule()); }
	 iv_ruleVxlListElement=ruleVxlListElement 
	 { $current=$iv_ruleVxlListElement.current; } 
	 EOF 
;

// Rule VxlListElement
ruleVxlListElement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getVxlListElementAccess().getFirstVxlTermParserRuleCall_0_0()); 
	    }
		lv_first_0_0=ruleVxlTerm		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlListElementRule());
	        }
       		set(
       			$current, 
       			"first",
        		lv_first_0_0, 
        		"VxlTerm");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=',' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getVxlListElementAccess().getCommaKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlListElementAccess().getRestVxlListElementParserRuleCall_1_1_0()); 
	    }
		lv_rest_2_0=ruleVxlListElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlListElementRule());
	        }
       		set(
       			$current, 
       			"rest",
        		lv_rest_2_0, 
        		"VxlListElement");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleVxlFunction
entryRuleVxlFunction returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlFunctionRule()); }
	 iv_ruleVxlFunction=ruleVxlFunction 
	 { $current=$iv_ruleVxlFunction.current; } 
	 EOF 
;

// Rule VxlFunction
ruleVxlFunction returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getVxlFunctionAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlFunctionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getVxlFunctionAccess().getLeftParenthesisKeyword_1());
    }
((
(
		lv_empty_2_0=	')' 
    {
        newLeafNode(lv_empty_2_0, grammarAccess.getVxlFunctionAccess().getEmptyRightParenthesisKeyword_2_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlFunctionRule());
	        }
       		setWithLastConsumed($current, "empty", true, ")");
	    }

)
)
    |((
(
		{ 
	        newCompositeNode(grammarAccess.getVxlFunctionAccess().getBodyVxlListElementParserRuleCall_2_1_0_0()); 
	    }
		lv_body_3_0=ruleVxlListElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlFunctionRule());
	        }
       		set(
       			$current, 
       			"body",
        		lv_body_3_0, 
        		"VxlListElement");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=')' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getVxlFunctionAccess().getRightParenthesisKeyword_2_1_1());
    }
)))
;





// Entry rule entryRuleVxlConstructor
entryRuleVxlConstructor returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlConstructorRule()); }
	 iv_ruleVxlConstructor=ruleVxlConstructor 
	 { $current=$iv_ruleVxlConstructor.current; } 
	 EOF 
;

// Rule VxlConstructor
ruleVxlConstructor returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='new' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVxlConstructorAccess().getNewKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlConstructorAccess().getNameFULLY_QUALIFIEDParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleFULLY_QUALIFIED		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlConstructorRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"FULLY_QUALIFIED");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getVxlConstructorAccess().getLeftParenthesisKeyword_2());
    }
((
(
		lv_empty_3_0=	')' 
    {
        newLeafNode(lv_empty_3_0, grammarAccess.getVxlConstructorAccess().getEmptyRightParenthesisKeyword_3_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlConstructorRule());
	        }
       		setWithLastConsumed($current, "empty", true, ")");
	    }

)
)
    |((
(
		{ 
	        newCompositeNode(grammarAccess.getVxlConstructorAccess().getBodyVxlListElementParserRuleCall_3_1_0_0()); 
	    }
		lv_body_4_0=ruleVxlListElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlConstructorRule());
	        }
       		set(
       			$current, 
       			"body",
        		lv_body_4_0, 
        		"VxlListElement");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getVxlConstructorAccess().getRightParenthesisKeyword_3_1_1());
    }
)))
;





// Entry rule entryRuleVxlValue
entryRuleVxlValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlValueRule()); }
	 iv_ruleVxlValue=ruleVxlValue 
	 { $current=$iv_ruleVxlValue.current; } 
	 EOF 
;

// Rule VxlValue
ruleVxlValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getVxlValueAccess().getVxlNullConstParserRuleCall_0()); 
    }
    this_VxlNullConst_0=ruleVxlNullConst
    { 
        $current = $this_VxlNullConst_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlValueAccess().getVxlBooleanConstParserRuleCall_1()); 
    }
    this_VxlBooleanConst_1=ruleVxlBooleanConst
    { 
        $current = $this_VxlBooleanConst_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlValueAccess().getVxlNumericConstParserRuleCall_2()); 
    }
    this_VxlNumericConst_2=ruleVxlNumericConst
    { 
        $current = $this_VxlNumericConst_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVxlValueAccess().getVxlStringConstParserRuleCall_3()); 
    }
    this_VxlStringConst_3=ruleVxlStringConst
    { 
        $current = $this_VxlStringConst_3.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleVxlBooleanConst
entryRuleVxlBooleanConst returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlBooleanConstRule()); }
	 iv_ruleVxlBooleanConst=ruleVxlBooleanConst 
	 { $current=$iv_ruleVxlBooleanConst.current; } 
	 EOF 
;

// Rule VxlBooleanConst
ruleVxlBooleanConst returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
(
		lv_const_0_1=	'true' 
    {
        newLeafNode(lv_const_0_1, grammarAccess.getVxlBooleanConstAccess().getConstTrueKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlBooleanConstRule());
	        }
       		setWithLastConsumed($current, "const", lv_const_0_1, null);
	    }

    |		lv_const_0_2=	'false' 
    {
        newLeafNode(lv_const_0_2, grammarAccess.getVxlBooleanConstAccess().getConstFalseKeyword_0_1());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlBooleanConstRule());
	        }
       		setWithLastConsumed($current, "const", lv_const_0_2, null);
	    }

)

)
)
;





// Entry rule entryRuleVxlNullConst
entryRuleVxlNullConst returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlNullConstRule()); }
	 iv_ruleVxlNullConst=ruleVxlNullConst 
	 { $current=$iv_ruleVxlNullConst.current; } 
	 EOF 
;

// Rule VxlNullConst
ruleVxlNullConst returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_const_0_0=	'null' 
    {
        newLeafNode(lv_const_0_0, grammarAccess.getVxlNullConstAccess().getConstNullKeyword_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlNullConstRule());
	        }
       		setWithLastConsumed($current, "const", lv_const_0_0, "null");
	    }

)
)
;





// Entry rule entryRuleVxlNumericConst
entryRuleVxlNumericConst returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlNumericConstRule()); }
	 iv_ruleVxlNumericConst=ruleVxlNumericConst 
	 { $current=$iv_ruleVxlNumericConst.current; } 
	 EOF 
;

// Rule VxlNumericConst
ruleVxlNumericConst returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getVxlNumericConstAccess().getConstNUMERICParserRuleCall_0()); 
	    }
		lv_const_0_0=ruleNUMERIC		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVxlNumericConstRule());
	        }
       		set(
       			$current, 
       			"const",
        		lv_const_0_0, 
        		"NUMERIC");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleVxlStringConst
entryRuleVxlStringConst returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVxlStringConstRule()); }
	 iv_ruleVxlStringConst=ruleVxlStringConst 
	 { $current=$iv_ruleVxlStringConst.current; } 
	 EOF 
;

// Rule VxlStringConst
ruleVxlStringConst returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_const_0_0=RULE_STRING
		{
			newLeafNode(lv_const_0_0, grammarAccess.getVxlStringConstAccess().getConstSTRINGTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVxlStringConstRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"const",
        		lv_const_0_0, 
        		"STRING");
	    }

)
)
;





// Entry rule entryRuleNUMERIC
entryRuleNUMERIC returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getNUMERICRule()); } 
	 iv_ruleNUMERIC=ruleNUMERIC 
	 { $current=$iv_ruleNUMERIC.current.getText(); }  
	 EOF 
;

// Rule NUMERIC
ruleNUMERIC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getNUMERICAccess().getFullStopKeyword_1_0()); 
    }
    this_INT_2=RULE_INT    {
		$current.merge(this_INT_2);
    }

    { 
    newLeafNode(this_INT_2, grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_1_1()); 
    }
)?)
    ;





// Entry rule entryRuleFULLY_QUALIFIED
entryRuleFULLY_QUALIFIED returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getFULLY_QUALIFIEDRule()); } 
	 iv_ruleFULLY_QUALIFIED=ruleFULLY_QUALIFIED 
	 { $current=$iv_ruleFULLY_QUALIFIED.current.getText(); }  
	 EOF 
;

// Rule FULLY_QUALIFIED
ruleFULLY_QUALIFIED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getFULLY_QUALIFIEDAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFULLY_QUALIFIEDAccess().getFullStopKeyword_1_0()); 
    }

    { 
        newCompositeNode(grammarAccess.getFULLY_QUALIFIEDAccess().getFULLY_QUALIFIEDParserRuleCall_1_1()); 
    }
    this_FULLY_QUALIFIED_2=ruleFULLY_QUALIFIED    {
		$current.merge(this_FULLY_QUALIFIED_2);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)?)
    ;





// Rule VxlOperator
ruleVxlOperator returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='<' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='<=' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='==' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='!=' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='>' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='>=' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5()); 
    }
)
    |(	enumLiteral_6='+' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_6, grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6()); 
    }
)
    |(	enumLiteral_7='-' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_7, grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7()); 
    }
)
    |(	enumLiteral_8='*' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_8, grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8()); 
    }
)
    |(	enumLiteral_9='/' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_9, grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9()); 
    }
)
    |(	enumLiteral_10='%' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_10, grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10()); 
    }
)
    |(	enumLiteral_11='and' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_11, grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11()); 
    }
)
    |(	enumLiteral_12='or' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_12, grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12()); 
    }
)
    |(	enumLiteral_13='++' 
	{
        $current = grammarAccess.getVxlOperatorAccess().getCONCATEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_13, grammarAccess.getVxlOperatorAccess().getCONCATEnumLiteralDeclaration_13()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


