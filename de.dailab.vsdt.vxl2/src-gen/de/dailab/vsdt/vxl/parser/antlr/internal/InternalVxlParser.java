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

@SuppressWarnings("all")
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
    public String getGrammarFileName() { return "../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g"; }



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
       	
       	@Override
       	protected VxlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleVxlTerm
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:78:1: entryRuleVxlTerm returns [EObject current=null] : iv_ruleVxlTerm= ruleVxlTerm EOF ;
    public final EObject entryRuleVxlTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlTerm = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:79:2: (iv_ruleVxlTerm= ruleVxlTerm EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:80:2: iv_ruleVxlTerm= ruleVxlTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlTermRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlTerm_in_entryRuleVxlTerm75);
            iv_ruleVxlTerm=ruleVxlTerm();
            _fsp--;

             current =iv_ruleVxlTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlTerm85); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:1: ruleVxlTerm returns [EObject current=null] : ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? ) ;
    public final EObject ruleVxlTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_head_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_tail_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:92:6: ( ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:93:1: ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:93:1: ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:93:2: ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )?
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:93:2: ( (lv_head_0_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:94:1: (lv_head_0_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:94:1: (lv_head_0_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:95:3: lv_head_0_0= ruleVxlElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlTermAccess().getHeadVxlElementParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlTerm131);
            lv_head_0_0=ruleVxlElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlTermRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"head",
            	        		lv_head_0_0, 
            	        		"VxlElement", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:117:2: ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14||(LA1_0>=23 && LA1_0<=35)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:117:3: ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:117:3: ( (lv_operator_1_0= ruleVxlOperator ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:118:1: (lv_operator_1_0= ruleVxlOperator )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:118:1: (lv_operator_1_0= ruleVxlOperator )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:119:3: lv_operator_1_0= ruleVxlOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlTermAccess().getOperatorVxlOperatorEnumRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlOperator_in_ruleVxlTerm153);
                    lv_operator_1_0=ruleVxlOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlTermRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_1_0, 
                    	        		"VxlOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:141:2: ( (lv_tail_2_0= ruleVxlTerm ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:142:1: (lv_tail_2_0= ruleVxlTerm )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:142:1: (lv_tail_2_0= ruleVxlTerm )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:143:3: lv_tail_2_0= ruleVxlTerm
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlTermAccess().getTailVxlTermParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlTerm174);
                    lv_tail_2_0=ruleVxlTerm();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlTermRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"tail",
                    	        		lv_tail_2_0, 
                    	        		"VxlTerm", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


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
    // $ANTLR end ruleVxlTerm


    // $ANTLR start entryRuleVxlElement
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:173:1: entryRuleVxlElement returns [EObject current=null] : iv_ruleVxlElement= ruleVxlElement EOF ;
    public final EObject entryRuleVxlElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlElement = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:174:2: (iv_ruleVxlElement= ruleVxlElement EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:175:2: iv_ruleVxlElement= ruleVxlElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlElement_in_entryRuleVxlElement212);
            iv_ruleVxlElement=ruleVxlElement();
            _fsp--;

             current =iv_ruleVxlElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlElement222); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:182:1: ruleVxlElement returns [EObject current=null] : (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality ) ;
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
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:187:6: ( (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:188:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:188:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality )
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
                    new NoViableAltException("188:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:189:5: this_VxlBracketTerm_0= ruleVxlBracketTerm
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlBracketTermParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlBracketTerm_in_ruleVxlElement269);
                    this_VxlBracketTerm_0=ruleVxlBracketTerm();
                    _fsp--;

                     
                            current = this_VxlBracketTerm_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:199:5: this_VxlNegation_1= ruleVxlNegation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlNegationParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlNegation_in_ruleVxlElement296);
                    this_VxlNegation_1=ruleVxlNegation();
                    _fsp--;

                     
                            current = this_VxlNegation_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:209:5: this_VxlMinus_2= ruleVxlMinus
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlMinusParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlMinus_in_ruleVxlElement323);
                    this_VxlMinus_2=ruleVxlMinus();
                    _fsp--;

                     
                            current = this_VxlMinus_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:219:5: this_VxlValue_3= ruleVxlValue
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlValueParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlValue_in_ruleVxlElement350);
                    this_VxlValue_3=ruleVxlValue();
                    _fsp--;

                     
                            current = this_VxlValue_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:229:5: this_VxlVariable_4= ruleVxlVariable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlVariableParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlVariable_in_ruleVxlElement377);
                    this_VxlVariable_4=ruleVxlVariable();
                    _fsp--;

                     
                            current = this_VxlVariable_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:239:5: this_VxlList_5= ruleVxlList
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlListParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlList_in_ruleVxlElement404);
                    this_VxlList_5=ruleVxlList();
                    _fsp--;

                     
                            current = this_VxlList_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:249:5: this_VxlCardinality_6= ruleVxlCardinality
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlElementAccess().getVxlCardinalityParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlCardinality_in_ruleVxlElement431);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:265:1: entryRuleVxlBracketTerm returns [EObject current=null] : iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF ;
    public final EObject entryRuleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBracketTerm = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:266:2: (iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:267:2: iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlBracketTermRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlBracketTerm_in_entryRuleVxlBracketTerm466);
            iv_ruleVxlBracketTerm=ruleVxlBracketTerm();
            _fsp--;

             current =iv_ruleVxlBracketTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlBracketTerm476); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:274:1: ruleVxlBracketTerm returns [EObject current=null] : ( '(' ( (lv_term_1_0= ruleVxlTerm ) ) ')' ) ;
    public final EObject ruleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_term_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:279:6: ( ( '(' ( (lv_term_1_0= ruleVxlTerm ) ) ')' ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:280:1: ( '(' ( (lv_term_1_0= ruleVxlTerm ) ) ')' )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:280:1: ( '(' ( (lv_term_1_0= ruleVxlTerm ) ) ')' )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:280:3: '(' ( (lv_term_1_0= ruleVxlTerm ) ) ')'
            {
            match(input,11,FOLLOW_11_in_ruleVxlBracketTerm511); 

                    createLeafNode(grammarAccess.getVxlBracketTermAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:284:1: ( (lv_term_1_0= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:285:1: (lv_term_1_0= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:285:1: (lv_term_1_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:286:3: lv_term_1_0= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlBracketTermAccess().getTermVxlTermParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm532);
            lv_term_1_0=ruleVxlTerm();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlBracketTermRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"term",
            	        		lv_term_1_0, 
            	        		"VxlTerm", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleVxlBracketTerm542); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:320:1: entryRuleVxlNegation returns [EObject current=null] : iv_ruleVxlNegation= ruleVxlNegation EOF ;
    public final EObject entryRuleVxlNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNegation = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:321:2: (iv_ruleVxlNegation= ruleVxlNegation EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:322:2: iv_ruleVxlNegation= ruleVxlNegation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlNegationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation578);
            iv_ruleVxlNegation=ruleVxlNegation();
            _fsp--;

             current =iv_ruleVxlNegation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNegation588); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:329:1: ruleVxlNegation returns [EObject current=null] : ( 'not' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlNegation() throws RecognitionException {
        EObject current = null;

        EObject lv_element_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:334:6: ( ( 'not' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:335:1: ( 'not' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:335:1: ( 'not' ( (lv_element_1_0= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:335:3: 'not' ( (lv_element_1_0= ruleVxlElement ) )
            {
            match(input,13,FOLLOW_13_in_ruleVxlNegation623); 

                    createLeafNode(grammarAccess.getVxlNegationAccess().getNotKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:339:1: ( (lv_element_1_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:340:1: (lv_element_1_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:340:1: (lv_element_1_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:341:3: lv_element_1_0= ruleVxlElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlNegationAccess().getElementVxlElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlNegation644);
            lv_element_1_0=ruleVxlElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlNegationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"element",
            	        		lv_element_1_0, 
            	        		"VxlElement", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:371:1: entryRuleVxlMinus returns [EObject current=null] : iv_ruleVxlMinus= ruleVxlMinus EOF ;
    public final EObject entryRuleVxlMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMinus = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:372:2: (iv_ruleVxlMinus= ruleVxlMinus EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:373:2: iv_ruleVxlMinus= ruleVxlMinus EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlMinusRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus680);
            iv_ruleVxlMinus=ruleVxlMinus();
            _fsp--;

             current =iv_ruleVxlMinus; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlMinus690); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:380:1: ruleVxlMinus returns [EObject current=null] : ( '-' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlMinus() throws RecognitionException {
        EObject current = null;

        EObject lv_element_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:385:6: ( ( '-' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:386:1: ( '-' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:386:1: ( '-' ( (lv_element_1_0= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:386:3: '-' ( (lv_element_1_0= ruleVxlElement ) )
            {
            match(input,14,FOLLOW_14_in_ruleVxlMinus725); 

                    createLeafNode(grammarAccess.getVxlMinusAccess().getHyphenMinusKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:390:1: ( (lv_element_1_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:391:1: (lv_element_1_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:391:1: (lv_element_1_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:392:3: lv_element_1_0= ruleVxlElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlMinusAccess().getElementVxlElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlMinus746);
            lv_element_1_0=ruleVxlElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlMinusRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"element",
            	        		lv_element_1_0, 
            	        		"VxlElement", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:422:1: entryRuleVxlCardinality returns [EObject current=null] : iv_ruleVxlCardinality= ruleVxlCardinality EOF ;
    public final EObject entryRuleVxlCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlCardinality = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:423:2: (iv_ruleVxlCardinality= ruleVxlCardinality EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:424:2: iv_ruleVxlCardinality= ruleVxlCardinality EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlCardinalityRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlCardinality_in_entryRuleVxlCardinality782);
            iv_ruleVxlCardinality=ruleVxlCardinality();
            _fsp--;

             current =iv_ruleVxlCardinality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlCardinality792); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:431:1: ruleVxlCardinality returns [EObject current=null] : ( '#' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlCardinality() throws RecognitionException {
        EObject current = null;

        EObject lv_element_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:436:6: ( ( '#' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:437:1: ( '#' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:437:1: ( '#' ( (lv_element_1_0= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:437:3: '#' ( (lv_element_1_0= ruleVxlElement ) )
            {
            match(input,15,FOLLOW_15_in_ruleVxlCardinality827); 

                    createLeafNode(grammarAccess.getVxlCardinalityAccess().getNumberSignKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:441:1: ( (lv_element_1_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:442:1: (lv_element_1_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:442:1: (lv_element_1_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:443:3: lv_element_1_0= ruleVxlElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlCardinalityAccess().getElementVxlElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlCardinality848);
            lv_element_1_0=ruleVxlElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlCardinalityRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"element",
            	        		lv_element_1_0, 
            	        		"VxlElement", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:473:1: entryRuleVxlVariable returns [EObject current=null] : iv_ruleVxlVariable= ruleVxlVariable EOF ;
    public final EObject entryRuleVxlVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlVariable = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:474:2: (iv_ruleVxlVariable= ruleVxlVariable EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:475:2: iv_ruleVxlVariable= ruleVxlVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable884);
            iv_ruleVxlVariable=ruleVxlVariable();
            _fsp--;

             current =iv_ruleVxlVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlVariable894); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:482:1: ruleVxlVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_accessor_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:487:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:488:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:488:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:488:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )?
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:488:2: ( (lv_name_0_0= RULE_ID ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:489:1: (lv_name_0_0= RULE_ID )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:489:1: (lv_name_0_0= RULE_ID )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:490:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlVariable936); 

            			createLeafNode(grammarAccess.getVxlVariableAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlVariableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:512:2: ( (lv_accessor_1_0= ruleVxlAccessor ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16||LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:513:1: (lv_accessor_1_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:513:1: (lv_accessor_1_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:514:3: lv_accessor_1_0= ruleVxlAccessor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlVariableAccess().getAccessorVxlAccessorParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlVariable962);
                    lv_accessor_1_0=ruleVxlAccessor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlVariableRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"accessor",
                    	        		lv_accessor_1_0, 
                    	        		"VxlAccessor", 
                    	        		currentNode);
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
    // $ANTLR end ruleVxlVariable


    // $ANTLR start entryRuleVxlAccessor
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:544:1: entryRuleVxlAccessor returns [EObject current=null] : iv_ruleVxlAccessor= ruleVxlAccessor EOF ;
    public final EObject entryRuleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:545:2: (iv_ruleVxlAccessor= ruleVxlAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:546:2: iv_ruleVxlAccessor= ruleVxlAccessor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlAccessorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor999);
            iv_ruleVxlAccessor=ruleVxlAccessor();
            _fsp--;

             current =iv_ruleVxlAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlAccessor1009); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:553:1: ruleVxlAccessor returns [EObject current=null] : (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor ) ;
    public final EObject ruleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject this_VxlArrayAccessor_0 = null;

        EObject this_VxlFieldAccessor_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:558:6: ( (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:559:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:559:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )
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
                    new NoViableAltException("559:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:560:5: this_VxlArrayAccessor_0= ruleVxlArrayAccessor
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlArrayAccessorParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1056);
                    this_VxlArrayAccessor_0=ruleVxlArrayAccessor();
                    _fsp--;

                     
                            current = this_VxlArrayAccessor_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:570:5: this_VxlFieldAccessor_1= ruleVxlFieldAccessor
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlFieldAccessorParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1083);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:586:1: entryRuleVxlArrayAccessor returns [EObject current=null] : iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF ;
    public final EObject entryRuleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlArrayAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:587:2: (iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:588:2: iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlArrayAccessorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1118);
            iv_ruleVxlArrayAccessor=ruleVxlArrayAccessor();
            _fsp--;

             current =iv_ruleVxlArrayAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlArrayAccessor1128); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:595:1: ruleVxlArrayAccessor returns [EObject current=null] : ( '[' ( (lv_index_1_0= ruleVxlTerm ) ) ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        EObject lv_index_1_0 = null;

        EObject lv_accessor_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:600:6: ( ( '[' ( (lv_index_1_0= ruleVxlTerm ) ) ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:601:1: ( '[' ( (lv_index_1_0= ruleVxlTerm ) ) ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:601:1: ( '[' ( (lv_index_1_0= ruleVxlTerm ) ) ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:601:3: '[' ( (lv_index_1_0= ruleVxlTerm ) ) ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )?
            {
            match(input,16,FOLLOW_16_in_ruleVxlArrayAccessor1163); 

                    createLeafNode(grammarAccess.getVxlArrayAccessorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:605:1: ( (lv_index_1_0= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:606:1: (lv_index_1_0= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:606:1: (lv_index_1_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:607:3: lv_index_1_0= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getIndexVxlTermParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1184);
            lv_index_1_0=ruleVxlTerm();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlArrayAccessorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"index",
            	        		lv_index_1_0, 
            	        		"VxlTerm", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleVxlArrayAccessor1194); 

                    createLeafNode(grammarAccess.getVxlArrayAccessorAccess().getRightSquareBracketKeyword_2(), null); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:633:1: ( (lv_accessor_3_0= ruleVxlAccessor ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16||LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:634:1: (lv_accessor_3_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:634:1: (lv_accessor_3_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:635:3: lv_accessor_3_0= ruleVxlAccessor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getAccessorVxlAccessorParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1215);
                    lv_accessor_3_0=ruleVxlAccessor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlArrayAccessorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"accessor",
                    	        		lv_accessor_3_0, 
                    	        		"VxlAccessor", 
                    	        		currentNode);
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
    // $ANTLR end ruleVxlArrayAccessor


    // $ANTLR start entryRuleVxlFieldAccessor
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:665:1: entryRuleVxlFieldAccessor returns [EObject current=null] : iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF ;
    public final EObject entryRuleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlFieldAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:666:2: (iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:667:2: iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlFieldAccessorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1252);
            iv_ruleVxlFieldAccessor=ruleVxlFieldAccessor();
            _fsp--;

             current =iv_ruleVxlFieldAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlFieldAccessor1262); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:674:1: ruleVxlFieldAccessor returns [EObject current=null] : ( '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_accessor_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:679:6: ( ( '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:680:1: ( '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:680:1: ( '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:680:3: '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            {
            match(input,18,FOLLOW_18_in_ruleVxlFieldAccessor1297); 

                    createLeafNode(grammarAccess.getVxlFieldAccessorAccess().getFullStopKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:684:1: ( (lv_name_1_0= RULE_ID ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:685:1: (lv_name_1_0= RULE_ID )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:685:1: (lv_name_1_0= RULE_ID )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:686:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1314); 

            			createLeafNode(grammarAccess.getVxlFieldAccessorAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlFieldAccessorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:708:2: ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16||LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:709:1: (lv_accessor_2_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:709:1: (lv_accessor_2_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:710:3: lv_accessor_2_0= ruleVxlAccessor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlFieldAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1340);
                    lv_accessor_2_0=ruleVxlAccessor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlFieldAccessorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"accessor",
                    	        		lv_accessor_2_0, 
                    	        		"VxlAccessor", 
                    	        		currentNode);
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
    // $ANTLR end ruleVxlFieldAccessor


    // $ANTLR start entryRuleVxlList
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:740:1: entryRuleVxlList returns [EObject current=null] : iv_ruleVxlList= ruleVxlList EOF ;
    public final EObject entryRuleVxlList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlList = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:741:2: (iv_ruleVxlList= ruleVxlList EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:742:2: iv_ruleVxlList= ruleVxlList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlListRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlList_in_entryRuleVxlList1377);
            iv_ruleVxlList=ruleVxlList();
            _fsp--;

             current =iv_ruleVxlList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlList1387); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:749:1: ruleVxlList returns [EObject current=null] : ( '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) ']' ) ) ) ;
    public final EObject ruleVxlList() throws RecognitionException {
        EObject current = null;

        Token lv_empty_1_0=null;
        EObject lv_body_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:754:6: ( ( '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) ']' ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:755:1: ( '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) ']' ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:755:1: ( '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) ']' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:755:3: '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) ']' ) )
            {
            match(input,16,FOLLOW_16_in_ruleVxlList1422); 

                    createLeafNode(grammarAccess.getVxlListAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:759:1: ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) ']' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_INT)||LA7_0==11||(LA7_0>=13 && LA7_0<=16)||(LA7_0>=20 && LA7_0<=22)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("759:1: ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) ']' ) )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:759:2: ( (lv_empty_1_0= ']' ) )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:759:2: ( (lv_empty_1_0= ']' ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:760:1: (lv_empty_1_0= ']' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:760:1: (lv_empty_1_0= ']' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:761:3: lv_empty_1_0= ']'
                    {
                    lv_empty_1_0=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleVxlList1441); 

                            createLeafNode(grammarAccess.getVxlListAccess().getEmptyRightSquareBracketKeyword_1_0_0(), "empty"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlListRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "empty", true, "]", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:781:6: ( ( (lv_body_2_0= ruleVxlListElement ) ) ']' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:781:6: ( ( (lv_body_2_0= ruleVxlListElement ) ) ']' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:781:7: ( (lv_body_2_0= ruleVxlListElement ) ) ']'
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:781:7: ( (lv_body_2_0= ruleVxlListElement ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:782:1: (lv_body_2_0= ruleVxlListElement )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:782:1: (lv_body_2_0= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:783:3: lv_body_2_0= ruleVxlListElement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlListAccess().getBodyVxlListElementParserRuleCall_1_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlList1482);
                    lv_body_2_0=ruleVxlListElement();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlListRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"body",
                    	        		lv_body_2_0, 
                    	        		"VxlListElement", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,17,FOLLOW_17_in_ruleVxlList1492); 

                            createLeafNode(grammarAccess.getVxlListAccess().getRightSquareBracketKeyword_1_1_1(), null); 
                        

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
    // $ANTLR end ruleVxlList


    // $ANTLR start entryRuleVxlListElement
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:817:1: entryRuleVxlListElement returns [EObject current=null] : iv_ruleVxlListElement= ruleVxlListElement EOF ;
    public final EObject entryRuleVxlListElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlListElement = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:818:2: (iv_ruleVxlListElement= ruleVxlListElement EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:819:2: iv_ruleVxlListElement= ruleVxlListElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlListElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1530);
            iv_ruleVxlListElement=ruleVxlListElement();
            _fsp--;

             current =iv_ruleVxlListElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlListElement1540); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:826:1: ruleVxlListElement returns [EObject current=null] : ( ( (lv_first_0_0= ruleVxlTerm ) ) ( ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? ) ;
    public final EObject ruleVxlListElement() throws RecognitionException {
        EObject current = null;

        EObject lv_first_0_0 = null;

        EObject lv_rest_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:831:6: ( ( ( (lv_first_0_0= ruleVxlTerm ) ) ( ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:832:1: ( ( (lv_first_0_0= ruleVxlTerm ) ) ( ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:832:1: ( ( (lv_first_0_0= ruleVxlTerm ) ) ( ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:832:2: ( (lv_first_0_0= ruleVxlTerm ) ) ( ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )?
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:832:2: ( (lv_first_0_0= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:833:1: (lv_first_0_0= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:833:1: (lv_first_0_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:834:3: lv_first_0_0= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlListElementAccess().getFirstVxlTermParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlListElement1586);
            lv_first_0_0=ruleVxlTerm();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlListElementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"first",
            	        		lv_first_0_0, 
            	        		"VxlTerm", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:856:2: ( ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:856:4: ',' ( (lv_rest_2_0= ruleVxlListElement ) )
                    {
                    match(input,19,FOLLOW_19_in_ruleVxlListElement1597); 

                            createLeafNode(grammarAccess.getVxlListElementAccess().getCommaKeyword_1_0(), null); 
                        
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:860:1: ( (lv_rest_2_0= ruleVxlListElement ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:861:1: (lv_rest_2_0= ruleVxlListElement )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:861:1: (lv_rest_2_0= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:862:3: lv_rest_2_0= ruleVxlListElement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlListElementAccess().getRestVxlListElementParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlListElement1618);
                    lv_rest_2_0=ruleVxlListElement();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlListElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rest",
                    	        		lv_rest_2_0, 
                    	        		"VxlListElement", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:892:1: entryRuleVxlValue returns [EObject current=null] : iv_ruleVxlValue= ruleVxlValue EOF ;
    public final EObject entryRuleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlValue = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:893:2: (iv_ruleVxlValue= ruleVxlValue EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:894:2: iv_ruleVxlValue= ruleVxlValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlValue_in_entryRuleVxlValue1656);
            iv_ruleVxlValue=ruleVxlValue();
            _fsp--;

             current =iv_ruleVxlValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlValue1666); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:901:1: ruleVxlValue returns [EObject current=null] : (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) ;
    public final EObject ruleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject this_VxlNullConst_0 = null;

        EObject this_VxlBooleanConst_1 = null;

        EObject this_VxlNumericConst_2 = null;

        EObject this_VxlStringConst_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:906:6: ( (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:907:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:907:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
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
                    new NoViableAltException("907:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:908:5: this_VxlNullConst_0= ruleVxlNullConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlNullConstParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlNullConst_in_ruleVxlValue1713);
                    this_VxlNullConst_0=ruleVxlNullConst();
                    _fsp--;

                     
                            current = this_VxlNullConst_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:918:5: this_VxlBooleanConst_1= ruleVxlBooleanConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlBooleanConstParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue1740);
                    this_VxlBooleanConst_1=ruleVxlBooleanConst();
                    _fsp--;

                     
                            current = this_VxlBooleanConst_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:928:5: this_VxlNumericConst_2= ruleVxlNumericConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlNumericConstParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlNumericConst_in_ruleVxlValue1767);
                    this_VxlNumericConst_2=ruleVxlNumericConst();
                    _fsp--;

                     
                            current = this_VxlNumericConst_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:938:5: this_VxlStringConst_3= ruleVxlStringConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlStringConstParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlStringConst_in_ruleVxlValue1794);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:954:1: entryRuleVxlBooleanConst returns [EObject current=null] : iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF ;
    public final EObject entryRuleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBooleanConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:955:2: (iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:956:2: iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlBooleanConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst1829);
            iv_ruleVxlBooleanConst=ruleVxlBooleanConst();
            _fsp--;

             current =iv_ruleVxlBooleanConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlBooleanConst1839); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:963:1: ruleVxlBooleanConst returns [EObject current=null] : ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) ) ;
    public final EObject ruleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_1=null;
        Token lv_const_0_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:968:6: ( ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:969:1: ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:969:1: ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:970:1: ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:970:1: ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:971:1: (lv_const_0_1= 'true' | lv_const_0_2= 'false' )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:971:1: (lv_const_0_1= 'true' | lv_const_0_2= 'false' )
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
                    new NoViableAltException("971:1: (lv_const_0_1= 'true' | lv_const_0_2= 'false' )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:972:3: lv_const_0_1= 'true'
                    {
                    lv_const_0_1=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleVxlBooleanConst1883); 

                            createLeafNode(grammarAccess.getVxlBooleanConstAccess().getConstTrueKeyword_0_0(), "const"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlBooleanConstRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "const", lv_const_0_1, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:990:8: lv_const_0_2= 'false'
                    {
                    lv_const_0_2=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_ruleVxlBooleanConst1912); 

                            createLeafNode(grammarAccess.getVxlBooleanConstAccess().getConstFalseKeyword_0_1(), "const"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlBooleanConstRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "const", lv_const_0_2, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1019:1: entryRuleVxlNullConst returns [EObject current=null] : iv_ruleVxlNullConst= ruleVxlNullConst EOF ;
    public final EObject entryRuleVxlNullConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNullConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1020:2: (iv_ruleVxlNullConst= ruleVxlNullConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1021:2: iv_ruleVxlNullConst= ruleVxlNullConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlNullConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst1963);
            iv_ruleVxlNullConst=ruleVxlNullConst();
            _fsp--;

             current =iv_ruleVxlNullConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNullConst1973); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1028:1: ruleVxlNullConst returns [EObject current=null] : ( (lv_const_0_0= 'null' ) ) ;
    public final EObject ruleVxlNullConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1033:6: ( ( (lv_const_0_0= 'null' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1034:1: ( (lv_const_0_0= 'null' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1034:1: ( (lv_const_0_0= 'null' ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1035:1: (lv_const_0_0= 'null' )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1035:1: (lv_const_0_0= 'null' )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1036:3: lv_const_0_0= 'null'
            {
            lv_const_0_0=(Token)input.LT(1);
            match(input,22,FOLLOW_22_in_ruleVxlNullConst2015); 

                    createLeafNode(grammarAccess.getVxlNullConstAccess().getConstNullKeyword_0(), "const"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlNullConstRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "const", lv_const_0_0, "null", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1063:1: entryRuleVxlNumericConst returns [EObject current=null] : iv_ruleVxlNumericConst= ruleVxlNumericConst EOF ;
    public final EObject entryRuleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNumericConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1064:2: (iv_ruleVxlNumericConst= ruleVxlNumericConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1065:2: iv_ruleVxlNumericConst= ruleVxlNumericConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlNumericConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2063);
            iv_ruleVxlNumericConst=ruleVxlNumericConst();
            _fsp--;

             current =iv_ruleVxlNumericConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNumericConst2073); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1072:1: ruleVxlNumericConst returns [EObject current=null] : ( (lv_const_0_0= ruleNUMERIC ) ) ;
    public final EObject ruleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_const_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1077:6: ( ( (lv_const_0_0= ruleNUMERIC ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1078:1: ( (lv_const_0_0= ruleNUMERIC ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1078:1: ( (lv_const_0_0= ruleNUMERIC ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1079:1: (lv_const_0_0= ruleNUMERIC )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1079:1: (lv_const_0_0= ruleNUMERIC )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1080:3: lv_const_0_0= ruleNUMERIC
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlNumericConstAccess().getConstNUMERICParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2118);
            lv_const_0_0=ruleNUMERIC();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlNumericConstRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"const",
            	        		lv_const_0_0, 
            	        		"NUMERIC", 
            	        		currentNode);
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
    // $ANTLR end ruleVxlNumericConst


    // $ANTLR start entryRuleVxlStringConst
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1110:1: entryRuleVxlStringConst returns [EObject current=null] : iv_ruleVxlStringConst= ruleVxlStringConst EOF ;
    public final EObject entryRuleVxlStringConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlStringConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1111:2: (iv_ruleVxlStringConst= ruleVxlStringConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1112:2: iv_ruleVxlStringConst= ruleVxlStringConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlStringConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2153);
            iv_ruleVxlStringConst=ruleVxlStringConst();
            _fsp--;

             current =iv_ruleVxlStringConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlStringConst2163); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1119:1: ruleVxlStringConst returns [EObject current=null] : ( (lv_const_0_0= RULE_STRING ) ) ;
    public final EObject ruleVxlStringConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1124:6: ( ( (lv_const_0_0= RULE_STRING ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1125:1: ( (lv_const_0_0= RULE_STRING ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1125:1: ( (lv_const_0_0= RULE_STRING ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1126:1: (lv_const_0_0= RULE_STRING )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1126:1: (lv_const_0_0= RULE_STRING )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1127:3: lv_const_0_0= RULE_STRING
            {
            lv_const_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVxlStringConst2204); 

            			createLeafNode(grammarAccess.getVxlStringConstAccess().getConstSTRINGTerminalRuleCall_0(), "const"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlStringConstRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"const",
            	        		lv_const_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1157:1: entryRuleNUMERIC returns [String current=null] : iv_ruleNUMERIC= ruleNUMERIC EOF ;
    public final String entryRuleNUMERIC() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMERIC = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1158:2: (iv_ruleNUMERIC= ruleNUMERIC EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1159:2: iv_ruleNUMERIC= ruleNUMERIC EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNUMERICRule(), currentNode); 
            pushFollow(FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2245);
            iv_ruleNUMERIC=ruleNUMERIC();
            _fsp--;

             current =iv_ruleNUMERIC.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUMERIC2256); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1166:1: ruleNUMERIC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMERIC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1171:6: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1172:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1172:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1172:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2296); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_0(), null); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1179:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1180:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleNUMERIC2315); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getNUMERICAccess().getFullStopKeyword_1_0(), null); 
                        
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2330); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_1_1(), null); 
                        

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
    // $ANTLR end ruleNUMERIC


    // $ANTLR start ruleVxlOperator
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1200:1: ruleVxlOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) ) ;
    public final Enumerator ruleVxlOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1204:6: ( ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1205:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1205:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )
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
                    new NoViableAltException("1205:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1205:2: ( '<' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1205:2: ( '<' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1205:4: '<'
                    {
                    match(input,23,FOLLOW_23_in_ruleVxlOperator2389); 

                            current = grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1211:6: ( '<=' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1211:6: ( '<=' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1211:8: '<='
                    {
                    match(input,24,FOLLOW_24_in_ruleVxlOperator2404); 

                            current = grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1217:6: ( '==' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1217:6: ( '==' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1217:8: '=='
                    {
                    match(input,25,FOLLOW_25_in_ruleVxlOperator2419); 

                            current = grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1223:6: ( '!=' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1223:6: ( '!=' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1223:8: '!='
                    {
                    match(input,26,FOLLOW_26_in_ruleVxlOperator2434); 

                            current = grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1229:6: ( '>' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1229:6: ( '>' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1229:8: '>'
                    {
                    match(input,27,FOLLOW_27_in_ruleVxlOperator2449); 

                            current = grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1235:6: ( '>=' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1235:6: ( '>=' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1235:8: '>='
                    {
                    match(input,28,FOLLOW_28_in_ruleVxlOperator2464); 

                            current = grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1241:6: ( '+' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1241:6: ( '+' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1241:8: '+'
                    {
                    match(input,29,FOLLOW_29_in_ruleVxlOperator2479); 

                            current = grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1247:6: ( '-' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1247:6: ( '-' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1247:8: '-'
                    {
                    match(input,14,FOLLOW_14_in_ruleVxlOperator2494); 

                            current = grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1253:6: ( '*' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1253:6: ( '*' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1253:8: '*'
                    {
                    match(input,30,FOLLOW_30_in_ruleVxlOperator2509); 

                            current = grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1259:6: ( '/' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1259:6: ( '/' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1259:8: '/'
                    {
                    match(input,31,FOLLOW_31_in_ruleVxlOperator2524); 

                            current = grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9(), null); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1265:6: ( '%' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1265:6: ( '%' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1265:8: '%'
                    {
                    match(input,32,FOLLOW_32_in_ruleVxlOperator2539); 

                            current = grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10(), null); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1271:6: ( 'and' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1271:6: ( 'and' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1271:8: 'and'
                    {
                    match(input,33,FOLLOW_33_in_ruleVxlOperator2554); 

                            current = grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11(), null); 
                        

                    }


                    }
                    break;
                case 13 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1277:6: ( 'or' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1277:6: ( 'or' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1277:8: 'or'
                    {
                    match(input,34,FOLLOW_34_in_ruleVxlOperator2569); 

                            current = grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12(), null); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1283:6: ( '++' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1283:6: ( '++' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1283:8: '++'
                    {
                    match(input,35,FOLLOW_35_in_ruleVxlOperator2584); 

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


 

    public static final BitSet FOLLOW_ruleVxlTerm_in_entryRuleVxlTerm75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlTerm85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlTerm131 = new BitSet(new long[]{0x0000000FFF804002L});
    public static final BitSet FOLLOW_ruleVxlOperator_in_ruleVxlTerm153 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlTerm174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlElement_in_entryRuleVxlElement212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlElement222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBracketTerm_in_ruleVxlElement269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNegation_in_ruleVxlElement296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMinus_in_ruleVxlElement323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlValue_in_ruleVxlElement350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlVariable_in_ruleVxlElement377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlList_in_ruleVxlElement404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlCardinality_in_ruleVxlElement431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBracketTerm_in_entryRuleVxlBracketTerm466 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlBracketTerm476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleVxlBracketTerm511 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm532 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVxlBracketTerm542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNegation588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleVxlNegation623 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlNegation644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlMinus690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlMinus725 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlMinus746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlCardinality_in_entryRuleVxlCardinality782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlCardinality792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVxlCardinality827 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlCardinality848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable884 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlVariable894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlVariable936 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlVariable962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlAccessor1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlArrayAccessor1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVxlArrayAccessor1163 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1184 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVxlArrayAccessor1194 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlFieldAccessor1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVxlFieldAccessor1297 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1314 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlList_in_entryRuleVxlList1377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlList1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVxlList1422 = new BitSet(new long[]{0x000000000073E870L});
    public static final BitSet FOLLOW_17_in_ruleVxlList1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlList1482 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVxlList1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlListElement1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlListElement1586 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVxlListElement1597 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlListElement1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlValue_in_entryRuleVxlValue1656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlValue1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_ruleVxlValue1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_ruleVxlValue1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_ruleVxlValue1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst1829 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlBooleanConst1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVxlBooleanConst1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVxlBooleanConst1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst1963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNullConst1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVxlNullConst2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNumericConst2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlStringConst2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVxlStringConst2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2245 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUMERIC2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2296 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleNUMERIC2315 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVxlOperator2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVxlOperator2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVxlOperator2419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVxlOperator2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVxlOperator2449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVxlOperator2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVxlOperator2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlOperator2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVxlOperator2509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVxlOperator2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVxlOperator2539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVxlOperator2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleVxlOperator2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleVxlOperator2584 = new BitSet(new long[]{0x0000000000000002L});

}