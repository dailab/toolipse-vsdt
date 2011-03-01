package de.dailab.vsdt.vxl.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import de.dailab.vsdt.vxl.services.VxlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalVxlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'not'", "'-'", "'#'", "'['", "']'", "'.'", "','", "'true'", "'false'", "'null'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", "'+'", "'*'", "'/'", "'%'", "'and'", "'or'", "'++'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalVxlParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g"; }


     
     	private VxlGrammarAccess grammarAccess;
     	
        public InternalVxlParser(TokenStream input, IAstFactory factory, VxlGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "VxlTerm";	
       	} 



    // $ANTLR start entryRuleVxlTerm
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:73:1: entryRuleVxlTerm returns [EObject current=null] : iv_ruleVxlTerm= ruleVxlTerm EOF ;
    public final EObject entryRuleVxlTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlTerm = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:73:49: (iv_ruleVxlTerm= ruleVxlTerm EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:74:2: iv_ruleVxlTerm= ruleVxlTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlTermRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlTerm_in_entryRuleVxlTerm73);
            iv_ruleVxlTerm=ruleVxlTerm();
            _fsp--;

             current =iv_ruleVxlTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlTerm83); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlTerm


    // $ANTLR start ruleVxlTerm
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:81:1: ruleVxlTerm returns [EObject current=null] : ( (lv_head_0= ruleVxlElement ) (lv_tail_1= ruleVxLTail )? ) ;
    public final EObject ruleVxlTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_head_0 = null;

        EObject lv_tail_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:86:6: ( ( (lv_head_0= ruleVxlElement ) (lv_tail_1= ruleVxLTail )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:1: ( (lv_head_0= ruleVxlElement ) (lv_tail_1= ruleVxLTail )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:1: ( (lv_head_0= ruleVxlElement ) (lv_tail_1= ruleVxLTail )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:2: (lv_head_0= ruleVxlElement ) (lv_tail_1= ruleVxLTail )?
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:2: (lv_head_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:90:6: lv_head_0= ruleVxlElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlTermAccess().getHeadVxlElementParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlTerm142);
            lv_head_0=ruleVxlElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlTermRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "head", lv_head_0, "VxlElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:108:2: (lv_tail_1= ruleVxLTail )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14||(LA1_0>=23 && LA1_0<=35)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:111:6: lv_tail_1= ruleVxLTail
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlTermAccess().getTailVxLTailParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxLTail_in_ruleVxlTerm180);
                    lv_tail_1=ruleVxLTail();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlTermRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "tail", lv_tail_1, "VxLTail", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlTerm


    // $ANTLR start entryRuleVxLTail
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:136:1: entryRuleVxLTail returns [EObject current=null] : iv_ruleVxLTail= ruleVxLTail EOF ;
    public final EObject entryRuleVxLTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxLTail = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:136:49: (iv_ruleVxLTail= ruleVxLTail EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:137:2: iv_ruleVxLTail= ruleVxLTail EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxLTailRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxLTail_in_entryRuleVxLTail218);
            iv_ruleVxLTail=ruleVxLTail();
            _fsp--;

             current =iv_ruleVxLTail; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxLTail228); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxLTail


    // $ANTLR start ruleVxLTail
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:144:1: ruleVxLTail returns [EObject current=null] : ( (lv_operator_0= ruleVxlOperator ) (lv_tail_1= ruleVxlTerm ) ) ;
    public final EObject ruleVxLTail() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0 = null;

        EObject lv_tail_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:149:6: ( ( (lv_operator_0= ruleVxlOperator ) (lv_tail_1= ruleVxlTerm ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:150:1: ( (lv_operator_0= ruleVxlOperator ) (lv_tail_1= ruleVxlTerm ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:150:1: ( (lv_operator_0= ruleVxlOperator ) (lv_tail_1= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:150:2: (lv_operator_0= ruleVxlOperator ) (lv_tail_1= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:150:2: (lv_operator_0= ruleVxlOperator )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:153:6: lv_operator_0= ruleVxlOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxLTailAccess().getOperatorVxlOperatorEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlOperator_in_ruleVxLTail287);
            lv_operator_0=ruleVxlOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxLTailRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_0, "VxlOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:171:2: (lv_tail_1= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:174:6: lv_tail_1= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxLTailAccess().getTailVxlTermParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxLTail325);
            lv_tail_1=ruleVxlTerm();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxLTailRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "tail", lv_tail_1, "VxlTerm", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxLTail


    // $ANTLR start entryRuleVxlElement
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:199:1: entryRuleVxlElement returns [EObject current=null] : iv_ruleVxlElement= ruleVxlElement EOF ;
    public final EObject entryRuleVxlElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlElement = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:199:52: (iv_ruleVxlElement= ruleVxlElement EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:200:2: iv_ruleVxlElement= ruleVxlElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlElement_in_entryRuleVxlElement362);
            iv_ruleVxlElement=ruleVxlElement();
            _fsp--;

             current =iv_ruleVxlElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlElement372); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlElement


    // $ANTLR start ruleVxlElement
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:207:1: ruleVxlElement returns [EObject current=null] : (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality ) ;
    public final EObject ruleVxlElement() throws RecognitionException {
        EObject current = null;

        EObject this_VxlBracketTerm_0 = null;

        EObject this_VxlNegation_1 = null;

        EObject this_VxlMinus_2 = null;

        EObject this_VxlValue_3 = null;

        EObject this_VxlVariable_4 = null;

        EObject this_VxlList_5 = null;

        EObject this_VxlCardinality_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:212:6: ( (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:213:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:213:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality )
            int alt2=7;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 13:
                {
                alt2=2;
                }
                break;
            case 14:
                {
                alt2=3;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case 20:
            case 21:
            case 22:
                {
                alt2=4;
                }
                break;
            case RULE_ID:
                {
                alt2=5;
                }
                break;
            case 16:
                {
                alt2=6;
                }
                break;
            case 15:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("213:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:214:5: this_VxlBracketTerm_0= ruleVxlBracketTerm
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlBracketTermParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlBracketTerm_in_ruleVxlElement419);
                    this_VxlBracketTerm_0=ruleVxlBracketTerm();
                    _fsp--;

                     
                            current = this_VxlBracketTerm_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:224:5: this_VxlNegation_1= ruleVxlNegation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlNegationParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlNegation_in_ruleVxlElement446);
                    this_VxlNegation_1=ruleVxlNegation();
                    _fsp--;

                     
                            current = this_VxlNegation_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:234:5: this_VxlMinus_2= ruleVxlMinus
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlMinusParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlMinus_in_ruleVxlElement473);
                    this_VxlMinus_2=ruleVxlMinus();
                    _fsp--;

                     
                            current = this_VxlMinus_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:244:5: this_VxlValue_3= ruleVxlValue
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlValueParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlValue_in_ruleVxlElement500);
                    this_VxlValue_3=ruleVxlValue();
                    _fsp--;

                     
                            current = this_VxlValue_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:254:5: this_VxlVariable_4= ruleVxlVariable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlVariableParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlVariable_in_ruleVxlElement527);
                    this_VxlVariable_4=ruleVxlVariable();
                    _fsp--;

                     
                            current = this_VxlVariable_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:264:5: this_VxlList_5= ruleVxlList
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlListParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlList_in_ruleVxlElement554);
                    this_VxlList_5=ruleVxlList();
                    _fsp--;

                     
                            current = this_VxlList_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:274:5: this_VxlCardinality_6= ruleVxlCardinality
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlCardinalityParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlCardinality_in_ruleVxlElement581);
                    this_VxlCardinality_6=ruleVxlCardinality();
                    _fsp--;

                     
                            current = this_VxlCardinality_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlElement


    // $ANTLR start entryRuleVxlBracketTerm
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:289:1: entryRuleVxlBracketTerm returns [EObject current=null] : iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF ;
    public final EObject entryRuleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBracketTerm = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:289:56: (iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:290:2: iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlBracketTermRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlBracketTerm_in_entryRuleVxlBracketTerm613);
            iv_ruleVxlBracketTerm=ruleVxlBracketTerm();
            _fsp--;

             current =iv_ruleVxlBracketTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlBracketTerm623); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlBracketTerm


    // $ANTLR start ruleVxlBracketTerm
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:297:1: ruleVxlBracketTerm returns [EObject current=null] : ( '(' (lv_term_1= ruleVxlTerm ) ')' ) ;
    public final EObject ruleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_term_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:302:6: ( ( '(' (lv_term_1= ruleVxlTerm ) ')' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:303:1: ( '(' (lv_term_1= ruleVxlTerm ) ')' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:303:1: ( '(' (lv_term_1= ruleVxlTerm ) ')' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:303:2: '(' (lv_term_1= ruleVxlTerm ) ')'
            {
            match(input,11,FOLLOW_11_in_ruleVxlBracketTerm657); 

                    createLeafNode(grammarAccess.getVxlBracketTermAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:307:1: (lv_term_1= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:310:6: lv_term_1= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlBracketTermAccess().getTermVxlTermParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm691);
            lv_term_1=ruleVxlTerm();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlBracketTermRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "term", lv_term_1, "VxlTerm", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,12,FOLLOW_12_in_ruleVxlBracketTerm704); 

                    createLeafNode(grammarAccess.getVxlBracketTermAccess().getRightParenthesisKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlBracketTerm


    // $ANTLR start entryRuleVxlNegation
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:339:1: entryRuleVxlNegation returns [EObject current=null] : iv_ruleVxlNegation= ruleVxlNegation EOF ;
    public final EObject entryRuleVxlNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNegation = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:339:53: (iv_ruleVxlNegation= ruleVxlNegation EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:340:2: iv_ruleVxlNegation= ruleVxlNegation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlNegationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation737);
            iv_ruleVxlNegation=ruleVxlNegation();
            _fsp--;

             current =iv_ruleVxlNegation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNegation747); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlNegation


    // $ANTLR start ruleVxlNegation
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:347:1: ruleVxlNegation returns [EObject current=null] : ( 'not' (lv_element_1= ruleVxlElement ) ) ;
    public final EObject ruleVxlNegation() throws RecognitionException {
        EObject current = null;

        EObject lv_element_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:352:6: ( ( 'not' (lv_element_1= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:353:1: ( 'not' (lv_element_1= ruleVxlElement ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:353:1: ( 'not' (lv_element_1= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:353:2: 'not' (lv_element_1= ruleVxlElement )
            {
            match(input,13,FOLLOW_13_in_ruleVxlNegation781); 

                    createLeafNode(grammarAccess.getVxlNegationAccess().getNotKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:357:1: (lv_element_1= ruleVxlElement )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:360:6: lv_element_1= ruleVxlElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlNegationAccess().getElementVxlElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlNegation815);
            lv_element_1=ruleVxlElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlNegationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "element", lv_element_1, "VxlElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlNegation


    // $ANTLR start entryRuleVxlMinus
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:385:1: entryRuleVxlMinus returns [EObject current=null] : iv_ruleVxlMinus= ruleVxlMinus EOF ;
    public final EObject entryRuleVxlMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMinus = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:385:50: (iv_ruleVxlMinus= ruleVxlMinus EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:386:2: iv_ruleVxlMinus= ruleVxlMinus EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlMinusRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus852);
            iv_ruleVxlMinus=ruleVxlMinus();
            _fsp--;

             current =iv_ruleVxlMinus; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlMinus862); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlMinus


    // $ANTLR start ruleVxlMinus
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:393:1: ruleVxlMinus returns [EObject current=null] : ( '-' (lv_element_1= ruleVxlElement ) ) ;
    public final EObject ruleVxlMinus() throws RecognitionException {
        EObject current = null;

        EObject lv_element_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:398:6: ( ( '-' (lv_element_1= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:399:1: ( '-' (lv_element_1= ruleVxlElement ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:399:1: ( '-' (lv_element_1= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:399:2: '-' (lv_element_1= ruleVxlElement )
            {
            match(input,14,FOLLOW_14_in_ruleVxlMinus896); 

                    createLeafNode(grammarAccess.getVxlMinusAccess().getHyphenMinusKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:403:1: (lv_element_1= ruleVxlElement )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:406:6: lv_element_1= ruleVxlElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlMinusAccess().getElementVxlElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlMinus930);
            lv_element_1=ruleVxlElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlMinusRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "element", lv_element_1, "VxlElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlMinus


    // $ANTLR start entryRuleVxlCardinality
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:431:1: entryRuleVxlCardinality returns [EObject current=null] : iv_ruleVxlCardinality= ruleVxlCardinality EOF ;
    public final EObject entryRuleVxlCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlCardinality = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:431:56: (iv_ruleVxlCardinality= ruleVxlCardinality EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:432:2: iv_ruleVxlCardinality= ruleVxlCardinality EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlCardinalityRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlCardinality_in_entryRuleVxlCardinality967);
            iv_ruleVxlCardinality=ruleVxlCardinality();
            _fsp--;

             current =iv_ruleVxlCardinality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlCardinality977); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlCardinality


    // $ANTLR start ruleVxlCardinality
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:439:1: ruleVxlCardinality returns [EObject current=null] : ( '#' (lv_element_1= ruleVxlElement ) ) ;
    public final EObject ruleVxlCardinality() throws RecognitionException {
        EObject current = null;

        EObject lv_element_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:444:6: ( ( '#' (lv_element_1= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:445:1: ( '#' (lv_element_1= ruleVxlElement ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:445:1: ( '#' (lv_element_1= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:445:2: '#' (lv_element_1= ruleVxlElement )
            {
            match(input,15,FOLLOW_15_in_ruleVxlCardinality1011); 

                    createLeafNode(grammarAccess.getVxlCardinalityAccess().getNumberSignKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:449:1: (lv_element_1= ruleVxlElement )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:452:6: lv_element_1= ruleVxlElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlCardinalityAccess().getElementVxlElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlCardinality1045);
            lv_element_1=ruleVxlElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlCardinalityRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "element", lv_element_1, "VxlElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlCardinality


    // $ANTLR start entryRuleVxlVariable
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:477:1: entryRuleVxlVariable returns [EObject current=null] : iv_ruleVxlVariable= ruleVxlVariable EOF ;
    public final EObject entryRuleVxlVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlVariable = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:477:53: (iv_ruleVxlVariable= ruleVxlVariable EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:478:2: iv_ruleVxlVariable= ruleVxlVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable1082);
            iv_ruleVxlVariable=ruleVxlVariable();
            _fsp--;

             current =iv_ruleVxlVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlVariable1092); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlVariable


    // $ANTLR start ruleVxlVariable
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:485:1: ruleVxlVariable returns [EObject current=null] : ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )? ) ;
    public final EObject ruleVxlVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_accessor_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:490:6: ( ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:491:1: ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:491:1: ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:491:2: (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )?
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:491:2: (lv_name_0= RULE_ID )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:493:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlVariable1139); 

            		createLeafNode(grammarAccess.getVxlVariableAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlVariableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:511:2: (lv_accessor_1= ruleVxlAccessor )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16||LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:514:6: lv_accessor_1= ruleVxlAccessor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlVariableAccess().getAccessorVxlAccessorParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlVariable1181);
                    lv_accessor_1=ruleVxlAccessor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlVariableRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "accessor", lv_accessor_1, "VxlAccessor", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlVariable


    // $ANTLR start entryRuleVxlAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:539:1: entryRuleVxlAccessor returns [EObject current=null] : iv_ruleVxlAccessor= ruleVxlAccessor EOF ;
    public final EObject entryRuleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:539:53: (iv_ruleVxlAccessor= ruleVxlAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:540:2: iv_ruleVxlAccessor= ruleVxlAccessor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlAccessorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor1219);
            iv_ruleVxlAccessor=ruleVxlAccessor();
            _fsp--;

             current =iv_ruleVxlAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlAccessor1229); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlAccessor


    // $ANTLR start ruleVxlAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:547:1: ruleVxlAccessor returns [EObject current=null] : (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor ) ;
    public final EObject ruleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject this_VxlArrayAccessor_0 = null;

        EObject this_VxlFieldAccessor_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:552:6: ( (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:553:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:553:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("553:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:554:5: this_VxlArrayAccessor_0= ruleVxlArrayAccessor
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlArrayAccessorParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1276);
                    this_VxlArrayAccessor_0=ruleVxlArrayAccessor();
                    _fsp--;

                     
                            current = this_VxlArrayAccessor_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:564:5: this_VxlFieldAccessor_1= ruleVxlFieldAccessor
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlFieldAccessorParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1303);
                    this_VxlFieldAccessor_1=ruleVxlFieldAccessor();
                    _fsp--;

                     
                            current = this_VxlFieldAccessor_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlAccessor


    // $ANTLR start entryRuleVxlArrayAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:579:1: entryRuleVxlArrayAccessor returns [EObject current=null] : iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF ;
    public final EObject entryRuleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlArrayAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:579:58: (iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:580:2: iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlArrayAccessorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1335);
            iv_ruleVxlArrayAccessor=ruleVxlArrayAccessor();
            _fsp--;

             current =iv_ruleVxlArrayAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlArrayAccessor1345); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlArrayAccessor


    // $ANTLR start ruleVxlArrayAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:587:1: ruleVxlArrayAccessor returns [EObject current=null] : ( '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )? ) ;
    public final EObject ruleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        EObject lv_index_1 = null;

        EObject lv_accessor_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:592:6: ( ( '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:593:1: ( '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:593:1: ( '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:593:2: '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )?
            {
            match(input,16,FOLLOW_16_in_ruleVxlArrayAccessor1379); 

                    createLeafNode(grammarAccess.getVxlArrayAccessorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:597:1: (lv_index_1= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:600:6: lv_index_1= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getIndexVxlTermParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1413);
            lv_index_1=ruleVxlTerm();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlArrayAccessorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "index", lv_index_1, "VxlTerm", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,17,FOLLOW_17_in_ruleVxlArrayAccessor1426); 

                    createLeafNode(grammarAccess.getVxlArrayAccessorAccess().getRightSquareBracketKeyword_2(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:622:1: (lv_accessor_3= ruleVxlAccessor )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16||LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:625:6: lv_accessor_3= ruleVxlAccessor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getAccessorVxlAccessorParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1460);
                    lv_accessor_3=ruleVxlAccessor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlArrayAccessorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "accessor", lv_accessor_3, "VxlAccessor", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlArrayAccessor


    // $ANTLR start entryRuleVxlFieldAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:650:1: entryRuleVxlFieldAccessor returns [EObject current=null] : iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF ;
    public final EObject entryRuleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlFieldAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:650:58: (iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:651:2: iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlFieldAccessorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1498);
            iv_ruleVxlFieldAccessor=ruleVxlFieldAccessor();
            _fsp--;

             current =iv_ruleVxlFieldAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlFieldAccessor1508); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlFieldAccessor


    // $ANTLR start ruleVxlFieldAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:658:1: ruleVxlFieldAccessor returns [EObject current=null] : ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )? ) ;
    public final EObject ruleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_accessor_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:663:6: ( ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:664:1: ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:664:1: ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:664:2: '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )?
            {
            match(input,18,FOLLOW_18_in_ruleVxlFieldAccessor1542); 

                    createLeafNode(grammarAccess.getVxlFieldAccessorAccess().getFullStopKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:668:1: (lv_name_1= RULE_ID )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:670:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1564); 

            		createLeafNode(grammarAccess.getVxlFieldAccessorAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlFieldAccessorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:688:2: (lv_accessor_2= ruleVxlAccessor )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16||LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:691:6: lv_accessor_2= ruleVxlAccessor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlFieldAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1606);
                    lv_accessor_2=ruleVxlAccessor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlFieldAccessorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "accessor", lv_accessor_2, "VxlAccessor", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlFieldAccessor


    // $ANTLR start entryRuleVxlList
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:716:1: entryRuleVxlList returns [EObject current=null] : iv_ruleVxlList= ruleVxlList EOF ;
    public final EObject entryRuleVxlList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlList = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:716:49: (iv_ruleVxlList= ruleVxlList EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:717:2: iv_ruleVxlList= ruleVxlList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlListRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlList_in_entryRuleVxlList1644);
            iv_ruleVxlList=ruleVxlList();
            _fsp--;

             current =iv_ruleVxlList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlList1654); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlList


    // $ANTLR start ruleVxlList
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:724:1: ruleVxlList returns [EObject current=null] : ( '[' (lv_body_1= ruleVxlListElement )? ']' ) ;
    public final EObject ruleVxlList() throws RecognitionException {
        EObject current = null;

        EObject lv_body_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:729:6: ( ( '[' (lv_body_1= ruleVxlListElement )? ']' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:730:1: ( '[' (lv_body_1= ruleVxlListElement )? ']' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:730:1: ( '[' (lv_body_1= ruleVxlListElement )? ']' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:730:2: '[' (lv_body_1= ruleVxlListElement )? ']'
            {
            match(input,16,FOLLOW_16_in_ruleVxlList1688); 

                    createLeafNode(grammarAccess.getVxlListAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:734:1: (lv_body_1= ruleVxlListElement )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_INT)||LA7_0==11||(LA7_0>=13 && LA7_0<=16)||(LA7_0>=20 && LA7_0<=22)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:737:6: lv_body_1= ruleVxlListElement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlListAccess().getBodyVxlListElementParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlList1722);
                    lv_body_1=ruleVxlListElement();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlListRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "body", lv_body_1, "VxlListElement", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }

            match(input,17,FOLLOW_17_in_ruleVxlList1736); 

                    createLeafNode(grammarAccess.getVxlListAccess().getRightSquareBracketKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlList


    // $ANTLR start entryRuleVxlListElement
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:766:1: entryRuleVxlListElement returns [EObject current=null] : iv_ruleVxlListElement= ruleVxlListElement EOF ;
    public final EObject entryRuleVxlListElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlListElement = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:766:56: (iv_ruleVxlListElement= ruleVxlListElement EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:767:2: iv_ruleVxlListElement= ruleVxlListElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlListElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1769);
            iv_ruleVxlListElement=ruleVxlListElement();
            _fsp--;

             current =iv_ruleVxlListElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlListElement1779); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlListElement


    // $ANTLR start ruleVxlListElement
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:774:1: ruleVxlListElement returns [EObject current=null] : ( (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )? ) ;
    public final EObject ruleVxlListElement() throws RecognitionException {
        EObject current = null;

        EObject lv_first_0 = null;

        EObject lv_rest_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:779:6: ( ( (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:780:1: ( (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:780:1: ( (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:780:2: (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )?
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:780:2: (lv_first_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:783:6: lv_first_0= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlListElementAccess().getFirstVxlTermParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlListElement1838);
            lv_first_0=ruleVxlTerm();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlListElementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "first", lv_first_0, "VxlTerm", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:801:2: ( ',' (lv_rest_2= ruleVxlListElement ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:801:3: ',' (lv_rest_2= ruleVxlListElement )
                    {
                    match(input,19,FOLLOW_19_in_ruleVxlListElement1852); 

                            createLeafNode(grammarAccess.getVxlListElementAccess().getCommaKeyword_1_0(), null); 
                        
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:805:1: (lv_rest_2= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:808:6: lv_rest_2= ruleVxlListElement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlListElementAccess().getRestVxlListElementParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlListElement1886);
                    lv_rest_2=ruleVxlListElement();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlListElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "rest", lv_rest_2, "VxlListElement", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlListElement


    // $ANTLR start entryRuleVxlValue
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:833:1: entryRuleVxlValue returns [EObject current=null] : iv_ruleVxlValue= ruleVxlValue EOF ;
    public final EObject entryRuleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlValue = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:833:50: (iv_ruleVxlValue= ruleVxlValue EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:834:2: iv_ruleVxlValue= ruleVxlValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlValue_in_entryRuleVxlValue1925);
            iv_ruleVxlValue=ruleVxlValue();
            _fsp--;

             current =iv_ruleVxlValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlValue1935); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlValue


    // $ANTLR start ruleVxlValue
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:841:1: ruleVxlValue returns [EObject current=null] : (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) ;
    public final EObject ruleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject this_VxlNullConst_0 = null;

        EObject this_VxlBooleanConst_1 = null;

        EObject this_VxlNumericConst_2 = null;

        EObject this_VxlStringConst_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:846:6: ( (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:847:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:847:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt9=1;
                }
                break;
            case 20:
            case 21:
                {
                alt9=2;
                }
                break;
            case RULE_INT:
                {
                alt9=3;
                }
                break;
            case RULE_STRING:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("847:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:848:5: this_VxlNullConst_0= ruleVxlNullConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlNullConstParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlNullConst_in_ruleVxlValue1982);
                    this_VxlNullConst_0=ruleVxlNullConst();
                    _fsp--;

                     
                            current = this_VxlNullConst_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:858:5: this_VxlBooleanConst_1= ruleVxlBooleanConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlBooleanConstParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue2009);
                    this_VxlBooleanConst_1=ruleVxlBooleanConst();
                    _fsp--;

                     
                            current = this_VxlBooleanConst_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:868:5: this_VxlNumericConst_2= ruleVxlNumericConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlNumericConstParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlNumericConst_in_ruleVxlValue2036);
                    this_VxlNumericConst_2=ruleVxlNumericConst();
                    _fsp--;

                     
                            current = this_VxlNumericConst_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:878:5: this_VxlStringConst_3= ruleVxlStringConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlStringConstParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlStringConst_in_ruleVxlValue2063);
                    this_VxlStringConst_3=ruleVxlStringConst();
                    _fsp--;

                     
                            current = this_VxlStringConst_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlValue


    // $ANTLR start entryRuleVxlBooleanConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:893:1: entryRuleVxlBooleanConst returns [EObject current=null] : iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF ;
    public final EObject entryRuleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBooleanConst = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:893:57: (iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:894:2: iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlBooleanConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst2095);
            iv_ruleVxlBooleanConst=ruleVxlBooleanConst();
            _fsp--;

             current =iv_ruleVxlBooleanConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlBooleanConst2105); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlBooleanConst


    // $ANTLR start ruleVxlBooleanConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:901:1: ruleVxlBooleanConst returns [EObject current=null] : (lv_const_0= ( 'true' | 'false' ) ) ;
    public final EObject ruleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:906:6: ( (lv_const_0= ( 'true' | 'false' ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:907:1: (lv_const_0= ( 'true' | 'false' ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:907:1: (lv_const_0= ( 'true' | 'false' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:909:6: lv_const_0= ( 'true' | 'false' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:909:17: ( 'true' | 'false' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            else if ( (LA10_0==21) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("909:17: ( 'true' | 'false' )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:909:18: 'true'
                    {
                    match(input,20,FOLLOW_20_in_ruleVxlBooleanConst2151); 

                            createLeafNode(grammarAccess.getVxlBooleanConstAccess().getConstTrueKeyword_0_0(), "const"); 
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:915:6: 'false'
                    {
                    match(input,21,FOLLOW_21_in_ruleVxlBooleanConst2167); 

                            createLeafNode(grammarAccess.getVxlBooleanConstAccess().getConstFalseKeyword_0_1(), "const"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlBooleanConstRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "const", /* lv_const_0 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlBooleanConst


    // $ANTLR start entryRuleVxlNullConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:942:1: entryRuleVxlNullConst returns [EObject current=null] : iv_ruleVxlNullConst= ruleVxlNullConst EOF ;
    public final EObject entryRuleVxlNullConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNullConst = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:942:54: (iv_ruleVxlNullConst= ruleVxlNullConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:943:2: iv_ruleVxlNullConst= ruleVxlNullConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlNullConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst2214);
            iv_ruleVxlNullConst=ruleVxlNullConst();
            _fsp--;

             current =iv_ruleVxlNullConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNullConst2224); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlNullConst


    // $ANTLR start ruleVxlNullConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:950:1: ruleVxlNullConst returns [EObject current=null] : (lv_const_0= 'null' ) ;
    public final EObject ruleVxlNullConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:955:6: ( (lv_const_0= 'null' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:956:1: (lv_const_0= 'null' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:956:1: (lv_const_0= 'null' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:958:6: lv_const_0= 'null'
            {
            lv_const_0=(Token)input.LT(1);
            match(input,22,FOLLOW_22_in_ruleVxlNullConst2269); 

                    createLeafNode(grammarAccess.getVxlNullConstAccess().getConstNullKeyword_0(), "const"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlNullConstRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "const", /* lv_const_0 */ input.LT(-1), "null", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlNullConst


    // $ANTLR start entryRuleVxlNumericConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:984:1: entryRuleVxlNumericConst returns [EObject current=null] : iv_ruleVxlNumericConst= ruleVxlNumericConst EOF ;
    public final EObject entryRuleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNumericConst = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:984:57: (iv_ruleVxlNumericConst= ruleVxlNumericConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:985:2: iv_ruleVxlNumericConst= ruleVxlNumericConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlNumericConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2314);
            iv_ruleVxlNumericConst=ruleVxlNumericConst();
            _fsp--;

             current =iv_ruleVxlNumericConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNumericConst2324); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlNumericConst


    // $ANTLR start ruleVxlNumericConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:992:1: ruleVxlNumericConst returns [EObject current=null] : (lv_const_0= ruleNUMERIC ) ;
    public final EObject ruleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_const_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:997:6: ( (lv_const_0= ruleNUMERIC ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:998:1: (lv_const_0= ruleNUMERIC )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:998:1: (lv_const_0= ruleNUMERIC )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1001:6: lv_const_0= ruleNUMERIC
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlNumericConstAccess().getConstNUMERICParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2382);
            lv_const_0=ruleNUMERIC();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlNumericConstRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "const", lv_const_0, "NUMERIC", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlNumericConst


    // $ANTLR start entryRuleVxlStringConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1026:1: entryRuleVxlStringConst returns [EObject current=null] : iv_ruleVxlStringConst= ruleVxlStringConst EOF ;
    public final EObject entryRuleVxlStringConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlStringConst = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1026:56: (iv_ruleVxlStringConst= ruleVxlStringConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1027:2: iv_ruleVxlStringConst= ruleVxlStringConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlStringConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2418);
            iv_ruleVxlStringConst=ruleVxlStringConst();
            _fsp--;

             current =iv_ruleVxlStringConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlStringConst2428); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVxlStringConst


    // $ANTLR start ruleVxlStringConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1034:1: ruleVxlStringConst returns [EObject current=null] : (lv_const_0= RULE_STRING ) ;
    public final EObject ruleVxlStringConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1039:6: ( (lv_const_0= RULE_STRING ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1040:1: (lv_const_0= RULE_STRING )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1040:1: (lv_const_0= RULE_STRING )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1042:6: lv_const_0= RULE_STRING
            {
            lv_const_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVxlStringConst2474); 

            		createLeafNode(grammarAccess.getVxlStringConstAccess().getConstSTRINGTerminalRuleCall_0(), "const"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlStringConstRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "const", lv_const_0, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlStringConst


    // $ANTLR start entryRuleNUMERIC
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1067:1: entryRuleNUMERIC returns [String current=null] : iv_ruleNUMERIC= ruleNUMERIC EOF ;
    public final String entryRuleNUMERIC() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMERIC = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1067:48: (iv_ruleNUMERIC= ruleNUMERIC EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1068:2: iv_ruleNUMERIC= ruleNUMERIC EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNUMERICRule(), currentNode); 
            pushFollow(FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2515);
            iv_ruleNUMERIC=ruleNUMERIC();
            _fsp--;

             current =iv_ruleNUMERIC.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUMERIC2526); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNUMERIC


    // $ANTLR start ruleNUMERIC
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1075:1: ruleNUMERIC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMERIC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1081:6: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1082:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1082:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1082:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2566); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1089:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1090:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleNUMERIC2585); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getNUMERICAccess().getFullStopKeyword_1_0(), null); 
                        
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2600); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_1_1(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNUMERIC


    // $ANTLR start ruleVxlOperator
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1110:1: ruleVxlOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) ) ;
    public final Enumerator ruleVxlOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1114:6: ( ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1115:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1115:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )
            int alt12=14;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt12=1;
                }
                break;
            case 24:
                {
                alt12=2;
                }
                break;
            case 25:
                {
                alt12=3;
                }
                break;
            case 26:
                {
                alt12=4;
                }
                break;
            case 27:
                {
                alt12=5;
                }
                break;
            case 28:
                {
                alt12=6;
                }
                break;
            case 29:
                {
                alt12=7;
                }
                break;
            case 14:
                {
                alt12=8;
                }
                break;
            case 30:
                {
                alt12=9;
                }
                break;
            case 31:
                {
                alt12=10;
                }
                break;
            case 32:
                {
                alt12=11;
                }
                break;
            case 33:
                {
                alt12=12;
                }
                break;
            case 34:
                {
                alt12=13;
                }
                break;
            case 35:
                {
                alt12=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1115:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1115:2: ( '<' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1115:2: ( '<' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1115:4: '<'
                    {
                    match(input,23,FOLLOW_23_in_ruleVxlOperator2659); 

                            current = grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1121:6: ( '<=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1121:6: ( '<=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1121:8: '<='
                    {
                    match(input,24,FOLLOW_24_in_ruleVxlOperator2674); 

                            current = grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1127:6: ( '==' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1127:6: ( '==' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1127:8: '=='
                    {
                    match(input,25,FOLLOW_25_in_ruleVxlOperator2689); 

                            current = grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1133:6: ( '!=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1133:6: ( '!=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1133:8: '!='
                    {
                    match(input,26,FOLLOW_26_in_ruleVxlOperator2704); 

                            current = grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1139:6: ( '>' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1139:6: ( '>' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1139:8: '>'
                    {
                    match(input,27,FOLLOW_27_in_ruleVxlOperator2719); 

                            current = grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1145:6: ( '>=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1145:6: ( '>=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1145:8: '>='
                    {
                    match(input,28,FOLLOW_28_in_ruleVxlOperator2734); 

                            current = grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1151:6: ( '+' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1151:6: ( '+' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1151:8: '+'
                    {
                    match(input,29,FOLLOW_29_in_ruleVxlOperator2749); 

                            current = grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1157:6: ( '-' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1157:6: ( '-' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1157:8: '-'
                    {
                    match(input,14,FOLLOW_14_in_ruleVxlOperator2764); 

                            current = grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1163:6: ( '*' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1163:6: ( '*' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1163:8: '*'
                    {
                    match(input,30,FOLLOW_30_in_ruleVxlOperator2779); 

                            current = grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1169:6: ( '/' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1169:6: ( '/' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1169:8: '/'
                    {
                    match(input,31,FOLLOW_31_in_ruleVxlOperator2794); 

                            current = grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9(), null); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1175:6: ( '%' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1175:6: ( '%' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1175:8: '%'
                    {
                    match(input,32,FOLLOW_32_in_ruleVxlOperator2809); 

                            current = grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10(), null); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1181:6: ( 'and' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1181:6: ( 'and' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1181:8: 'and'
                    {
                    match(input,33,FOLLOW_33_in_ruleVxlOperator2824); 

                            current = grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11(), null); 
                        

                    }


                    }
                    break;
                case 13 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1187:6: ( 'or' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1187:6: ( 'or' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1187:8: 'or'
                    {
                    match(input,34,FOLLOW_34_in_ruleVxlOperator2839); 

                            current = grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12(), null); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1193:6: ( '++' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1193:6: ( '++' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1193:8: '++'
                    {
                    match(input,35,FOLLOW_35_in_ruleVxlOperator2854); 

                            current = grammarAccess.getVxlOperatorAccess().getCONCATEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getCONCATEnumLiteralDeclaration_13(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVxlOperator


 

    public static final BitSet FOLLOW_ruleVxlTerm_in_entryRuleVxlTerm73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlTerm83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlTerm142 = new BitSet(new long[]{0x0000000FFF804002L});
    public static final BitSet FOLLOW_ruleVxLTail_in_ruleVxlTerm180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxLTail_in_entryRuleVxLTail218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxLTail228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlOperator_in_ruleVxLTail287 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxLTail325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlElement_in_entryRuleVxlElement362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlElement372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBracketTerm_in_ruleVxlElement419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNegation_in_ruleVxlElement446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMinus_in_ruleVxlElement473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlValue_in_ruleVxlElement500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlVariable_in_ruleVxlElement527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlList_in_ruleVxlElement554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlCardinality_in_ruleVxlElement581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBracketTerm_in_entryRuleVxlBracketTerm613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlBracketTerm623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleVxlBracketTerm657 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm691 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVxlBracketTerm704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNegation747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleVxlNegation781 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlNegation815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlMinus862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlMinus896 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlMinus930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlCardinality_in_entryRuleVxlCardinality967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlCardinality977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVxlCardinality1011 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlCardinality1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable1082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlVariable1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlVariable1139 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlVariable1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor1219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlAccessor1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlArrayAccessor1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVxlArrayAccessor1379 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1413 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVxlArrayAccessor1426 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1498 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlFieldAccessor1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVxlFieldAccessor1542 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1564 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlList_in_entryRuleVxlList1644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlList1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVxlList1688 = new BitSet(new long[]{0x000000000073E870L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlList1722 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVxlList1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlListElement1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlListElement1838 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVxlListElement1852 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlListElement1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlValue_in_entryRuleVxlValue1925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlValue1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_ruleVxlValue1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_ruleVxlValue2036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_ruleVxlValue2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst2095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlBooleanConst2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVxlBooleanConst2151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVxlBooleanConst2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst2214 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNullConst2224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVxlNullConst2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNumericConst2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlStringConst2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVxlStringConst2474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUMERIC2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2566 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleNUMERIC2585 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVxlOperator2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVxlOperator2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVxlOperator2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVxlOperator2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVxlOperator2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVxlOperator2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVxlOperator2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlOperator2764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVxlOperator2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVxlOperator2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVxlOperator2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVxlOperator2824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleVxlOperator2839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleVxlOperator2854 = new BitSet(new long[]{0x0000000000000002L});

}