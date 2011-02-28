package de.dailab.vsdt.vxl.parser.antlr.internal; 

import java.io.InputStream;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

import de.dailab.vsdt.vxl.services.VxlGrammarAccess;

public class InternalVxlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'not'", "'-'", "'['", "']'", "'.'", "','", "'true'", "'false'", "'null'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", "'+'", "'*'", "'/'", "'%'", "'and'", "'or'", "'++'"
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:81:1: ruleVxlTerm returns [EObject current=null] : ( (lv_head_0= ruleVxlHead ) (lv_tail_1= ruleVxlTail )? ) ;
    public final EObject ruleVxlTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_head_0 = null;

        EObject lv_tail_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:86:6: ( ( (lv_head_0= ruleVxlHead ) (lv_tail_1= ruleVxlTail )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:1: ( (lv_head_0= ruleVxlHead ) (lv_tail_1= ruleVxlTail )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:1: ( (lv_head_0= ruleVxlHead ) (lv_tail_1= ruleVxlTail )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:2: (lv_head_0= ruleVxlHead ) (lv_tail_1= ruleVxlTail )?
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:2: (lv_head_0= ruleVxlHead )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:90:6: lv_head_0= ruleVxlHead
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlTermAccess().getHeadVxlHeadParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlHead_in_ruleVxlTerm142);
            lv_head_0=ruleVxlHead();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlTermRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "head", lv_head_0, "VxlHead", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:108:2: (lv_tail_1= ruleVxlTail )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14||(LA1_0>=22 && LA1_0<=34)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:111:6: lv_tail_1= ruleVxlTail
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlTermAccess().getTailVxlTailParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlTail_in_ruleVxlTerm180);
                    lv_tail_1=ruleVxlTail();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVxlTermRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "tail", lv_tail_1, "VxlTail", currentNode);
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


    // $ANTLR start entryRuleVxlHead
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:136:1: entryRuleVxlHead returns [EObject current=null] : iv_ruleVxlHead= ruleVxlHead EOF ;
    public final EObject entryRuleVxlHead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlHead = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:136:49: (iv_ruleVxlHead= ruleVxlHead EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:137:2: iv_ruleVxlHead= ruleVxlHead EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlHeadRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlHead_in_entryRuleVxlHead218);
            iv_ruleVxlHead=ruleVxlHead();
            _fsp--;

             current =iv_ruleVxlHead; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlHead228); 

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
    // $ANTLR end entryRuleVxlHead


    // $ANTLR start ruleVxlHead
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:144:1: ruleVxlHead returns [EObject current=null] : (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlAtom_3= ruleVxlAtom ) ;
    public final EObject ruleVxlHead() throws RecognitionException {
        EObject current = null;

        EObject this_VxlBracketTerm_0 = null;

        EObject this_VxlNegation_1 = null;

        EObject this_VxlMinus_2 = null;

        EObject this_VxlAtom_3 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:149:6: ( (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlAtom_3= ruleVxlAtom ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:150:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlAtom_3= ruleVxlAtom )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:150:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlAtom_3= ruleVxlAtom )
            int alt2=4;
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
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
            case 15:
            case 19:
            case 20:
            case 21:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("150:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlAtom_3= ruleVxlAtom )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:151:5: this_VxlBracketTerm_0= ruleVxlBracketTerm
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlHeadAccess().getVxlBracketTermParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlBracketTerm_in_ruleVxlHead275);
                    this_VxlBracketTerm_0=ruleVxlBracketTerm();
                    _fsp--;

                     
                            current = this_VxlBracketTerm_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:161:5: this_VxlNegation_1= ruleVxlNegation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlHeadAccess().getVxlNegationParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlNegation_in_ruleVxlHead302);
                    this_VxlNegation_1=ruleVxlNegation();
                    _fsp--;

                     
                            current = this_VxlNegation_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:171:5: this_VxlMinus_2= ruleVxlMinus
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlHeadAccess().getVxlMinusParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlMinus_in_ruleVxlHead329);
                    this_VxlMinus_2=ruleVxlMinus();
                    _fsp--;

                     
                            current = this_VxlMinus_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:181:5: this_VxlAtom_3= ruleVxlAtom
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlHeadAccess().getVxlAtomParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlAtom_in_ruleVxlHead356);
                    this_VxlAtom_3=ruleVxlAtom();
                    _fsp--;

                     
                            current = this_VxlAtom_3; 
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
    // $ANTLR end ruleVxlHead


    // $ANTLR start entryRuleVxlTail
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:196:1: entryRuleVxlTail returns [EObject current=null] : iv_ruleVxlTail= ruleVxlTail EOF ;
    public final EObject entryRuleVxlTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlTail = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:196:49: (iv_ruleVxlTail= ruleVxlTail EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:197:2: iv_ruleVxlTail= ruleVxlTail EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlTailRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlTail_in_entryRuleVxlTail388);
            iv_ruleVxlTail=ruleVxlTail();
            _fsp--;

             current =iv_ruleVxlTail; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlTail398); 

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
    // $ANTLR end entryRuleVxlTail


    // $ANTLR start ruleVxlTail
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:204:1: ruleVxlTail returns [EObject current=null] : ( (lv_operator_0= ruleVxlOperator ) (lv_term_1= ruleVxlTerm ) ) ;
    public final EObject ruleVxlTail() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0 = null;

        EObject lv_term_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:209:6: ( ( (lv_operator_0= ruleVxlOperator ) (lv_term_1= ruleVxlTerm ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:210:1: ( (lv_operator_0= ruleVxlOperator ) (lv_term_1= ruleVxlTerm ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:210:1: ( (lv_operator_0= ruleVxlOperator ) (lv_term_1= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:210:2: (lv_operator_0= ruleVxlOperator ) (lv_term_1= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:210:2: (lv_operator_0= ruleVxlOperator )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:213:6: lv_operator_0= ruleVxlOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlTailAccess().getOperatorVxlOperatorEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlOperator_in_ruleVxlTail457);
            lv_operator_0=ruleVxlOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlTailRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_0, "VxlOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:231:2: (lv_term_1= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:234:6: lv_term_1= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlTailAccess().getTermVxlTermParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlTail495);
            lv_term_1=ruleVxlTerm();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlTailRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "term", lv_term_1, "VxlTerm", currentNode);
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
    // $ANTLR end ruleVxlTail


    // $ANTLR start entryRuleVxlBracketTerm
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:259:1: entryRuleVxlBracketTerm returns [EObject current=null] : iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF ;
    public final EObject entryRuleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBracketTerm = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:259:56: (iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:260:2: iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlBracketTermRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlBracketTerm_in_entryRuleVxlBracketTerm532);
            iv_ruleVxlBracketTerm=ruleVxlBracketTerm();
            _fsp--;

             current =iv_ruleVxlBracketTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlBracketTerm542); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:267:1: ruleVxlBracketTerm returns [EObject current=null] : ( '(' (lv_term_1= ruleVxlTerm ) ')' ) ;
    public final EObject ruleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_term_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:272:6: ( ( '(' (lv_term_1= ruleVxlTerm ) ')' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:273:1: ( '(' (lv_term_1= ruleVxlTerm ) ')' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:273:1: ( '(' (lv_term_1= ruleVxlTerm ) ')' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:273:2: '(' (lv_term_1= ruleVxlTerm ) ')'
            {
            match(input,11,FOLLOW_11_in_ruleVxlBracketTerm576); 

                    createLeafNode(grammarAccess.getVxlBracketTermAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:277:1: (lv_term_1= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:280:6: lv_term_1= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlBracketTermAccess().getTermVxlTermParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm610);
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

            match(input,12,FOLLOW_12_in_ruleVxlBracketTerm623); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:309:1: entryRuleVxlNegation returns [EObject current=null] : iv_ruleVxlNegation= ruleVxlNegation EOF ;
    public final EObject entryRuleVxlNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNegation = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:309:53: (iv_ruleVxlNegation= ruleVxlNegation EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:310:2: iv_ruleVxlNegation= ruleVxlNegation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlNegationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation656);
            iv_ruleVxlNegation=ruleVxlNegation();
            _fsp--;

             current =iv_ruleVxlNegation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNegation666); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:317:1: ruleVxlNegation returns [EObject current=null] : ( 'not' (lv_head_1= ruleVxlHead ) ) ;
    public final EObject ruleVxlNegation() throws RecognitionException {
        EObject current = null;

        EObject lv_head_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:322:6: ( ( 'not' (lv_head_1= ruleVxlHead ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:323:1: ( 'not' (lv_head_1= ruleVxlHead ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:323:1: ( 'not' (lv_head_1= ruleVxlHead ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:323:2: 'not' (lv_head_1= ruleVxlHead )
            {
            match(input,13,FOLLOW_13_in_ruleVxlNegation700); 

                    createLeafNode(grammarAccess.getVxlNegationAccess().getNotKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:327:1: (lv_head_1= ruleVxlHead )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:330:6: lv_head_1= ruleVxlHead
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlNegationAccess().getHeadVxlHeadParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlHead_in_ruleVxlNegation734);
            lv_head_1=ruleVxlHead();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlNegationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "head", lv_head_1, "VxlHead", currentNode);
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:355:1: entryRuleVxlMinus returns [EObject current=null] : iv_ruleVxlMinus= ruleVxlMinus EOF ;
    public final EObject entryRuleVxlMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMinus = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:355:50: (iv_ruleVxlMinus= ruleVxlMinus EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:356:2: iv_ruleVxlMinus= ruleVxlMinus EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlMinusRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus771);
            iv_ruleVxlMinus=ruleVxlMinus();
            _fsp--;

             current =iv_ruleVxlMinus; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlMinus781); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:363:1: ruleVxlMinus returns [EObject current=null] : ( '-' (lv_head_1= ruleVxlHead ) ) ;
    public final EObject ruleVxlMinus() throws RecognitionException {
        EObject current = null;

        EObject lv_head_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:368:6: ( ( '-' (lv_head_1= ruleVxlHead ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:369:1: ( '-' (lv_head_1= ruleVxlHead ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:369:1: ( '-' (lv_head_1= ruleVxlHead ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:369:2: '-' (lv_head_1= ruleVxlHead )
            {
            match(input,14,FOLLOW_14_in_ruleVxlMinus815); 

                    createLeafNode(grammarAccess.getVxlMinusAccess().getHyphenMinusKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:373:1: (lv_head_1= ruleVxlHead )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:376:6: lv_head_1= ruleVxlHead
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlMinusAccess().getHeadVxlHeadParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlHead_in_ruleVxlMinus849);
            lv_head_1=ruleVxlHead();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVxlMinusRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "head", lv_head_1, "VxlHead", currentNode);
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


    // $ANTLR start entryRuleVxlAtom
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:401:1: entryRuleVxlAtom returns [EObject current=null] : iv_ruleVxlAtom= ruleVxlAtom EOF ;
    public final EObject entryRuleVxlAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlAtom = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:401:49: (iv_ruleVxlAtom= ruleVxlAtom EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:402:2: iv_ruleVxlAtom= ruleVxlAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlAtomRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlAtom_in_entryRuleVxlAtom886);
            iv_ruleVxlAtom=ruleVxlAtom();
            _fsp--;

             current =iv_ruleVxlAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlAtom896); 

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
    // $ANTLR end entryRuleVxlAtom


    // $ANTLR start ruleVxlAtom
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:409:1: ruleVxlAtom returns [EObject current=null] : (this_VxlValue_0= ruleVxlValue | this_VxlVariable_1= ruleVxlVariable | this_VxlList_2= ruleVxlList ) ;
    public final EObject ruleVxlAtom() throws RecognitionException {
        EObject current = null;

        EObject this_VxlValue_0 = null;

        EObject this_VxlVariable_1 = null;

        EObject this_VxlList_2 = null;


        setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:414:6: ( (this_VxlValue_0= ruleVxlValue | this_VxlVariable_1= ruleVxlVariable | this_VxlList_2= ruleVxlList ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:415:1: (this_VxlValue_0= ruleVxlValue | this_VxlVariable_1= ruleVxlVariable | this_VxlList_2= ruleVxlList )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:415:1: (this_VxlValue_0= ruleVxlValue | this_VxlVariable_1= ruleVxlVariable | this_VxlList_2= ruleVxlList )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case 19:
            case 20:
            case 21:
                {
                alt3=1;
                }
                break;
            case RULE_ID:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("415:1: (this_VxlValue_0= ruleVxlValue | this_VxlVariable_1= ruleVxlVariable | this_VxlList_2= ruleVxlList )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:416:5: this_VxlValue_0= ruleVxlValue
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlAtomAccess().getVxlValueParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlValue_in_ruleVxlAtom943);
                    this_VxlValue_0=ruleVxlValue();
                    _fsp--;

                     
                            current = this_VxlValue_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:426:5: this_VxlVariable_1= ruleVxlVariable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlAtomAccess().getVxlVariableParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlVariable_in_ruleVxlAtom970);
                    this_VxlVariable_1=ruleVxlVariable();
                    _fsp--;

                     
                            current = this_VxlVariable_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:436:5: this_VxlList_2= ruleVxlList
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlAtomAccess().getVxlListParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlList_in_ruleVxlAtom997);
                    this_VxlList_2=ruleVxlList();
                    _fsp--;

                     
                            current = this_VxlList_2; 
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
    // $ANTLR end ruleVxlAtom


    // $ANTLR start entryRuleVxlVariable
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:451:1: entryRuleVxlVariable returns [EObject current=null] : iv_ruleVxlVariable= ruleVxlVariable EOF ;
    public final EObject entryRuleVxlVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlVariable = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:451:53: (iv_ruleVxlVariable= ruleVxlVariable EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:452:2: iv_ruleVxlVariable= ruleVxlVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable1029);
            iv_ruleVxlVariable=ruleVxlVariable();
            _fsp--;

             current =iv_ruleVxlVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlVariable1039); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:459:1: ruleVxlVariable returns [EObject current=null] : ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )? ) ;
    public final EObject ruleVxlVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_accessor_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:464:6: ( ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:465:1: ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:465:1: ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:465:2: (lv_name_0= RULE_ID ) (lv_accessor_1= ruleVxlAccessor )?
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:465:2: (lv_name_0= RULE_ID )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:467:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlVariable1086); 

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

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:485:2: (lv_accessor_1= ruleVxlAccessor )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15||LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:488:6: lv_accessor_1= ruleVxlAccessor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlVariableAccess().getAccessorVxlAccessorParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlVariable1128);
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:513:1: entryRuleVxlAccessor returns [EObject current=null] : iv_ruleVxlAccessor= ruleVxlAccessor EOF ;
    public final EObject entryRuleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:513:53: (iv_ruleVxlAccessor= ruleVxlAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:514:2: iv_ruleVxlAccessor= ruleVxlAccessor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlAccessorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor1166);
            iv_ruleVxlAccessor=ruleVxlAccessor();
            _fsp--;

             current =iv_ruleVxlAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlAccessor1176); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:521:1: ruleVxlAccessor returns [EObject current=null] : (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor ) ;
    public final EObject ruleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject this_VxlArrayAccessor_0 = null;

        EObject this_VxlFieldAccessor_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:526:6: ( (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:527:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:527:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==17) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("527:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:528:5: this_VxlArrayAccessor_0= ruleVxlArrayAccessor
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlArrayAccessorParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1223);
                    this_VxlArrayAccessor_0=ruleVxlArrayAccessor();
                    _fsp--;

                     
                            current = this_VxlArrayAccessor_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:538:5: this_VxlFieldAccessor_1= ruleVxlFieldAccessor
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlFieldAccessorParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1250);
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:553:1: entryRuleVxlArrayAccessor returns [EObject current=null] : iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF ;
    public final EObject entryRuleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlArrayAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:553:58: (iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:554:2: iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlArrayAccessorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1282);
            iv_ruleVxlArrayAccessor=ruleVxlArrayAccessor();
            _fsp--;

             current =iv_ruleVxlArrayAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlArrayAccessor1292); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:561:1: ruleVxlArrayAccessor returns [EObject current=null] : ( '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )? ) ;
    public final EObject ruleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        EObject lv_index_1 = null;

        EObject lv_accessor_3 = null;

 setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:566:6: ( ( '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:567:1: ( '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:567:1: ( '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:567:2: '[' (lv_index_1= ruleVxlTerm ) ']' (lv_accessor_3= ruleVxlAccessor )?
            {
            match(input,15,FOLLOW_15_in_ruleVxlArrayAccessor1326); 

                    createLeafNode(grammarAccess.getVxlArrayAccessorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:571:1: (lv_index_1= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:574:6: lv_index_1= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getIndexVxlTermParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1360);
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

            match(input,16,FOLLOW_16_in_ruleVxlArrayAccessor1373); 

                    createLeafNode(grammarAccess.getVxlArrayAccessorAccess().getRightSquareBracketKeyword_2(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:596:1: (lv_accessor_3= ruleVxlAccessor )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15||LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:599:6: lv_accessor_3= ruleVxlAccessor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getAccessorVxlAccessorParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1407);
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:624:1: entryRuleVxlFieldAccessor returns [EObject current=null] : iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF ;
    public final EObject entryRuleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlFieldAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:624:58: (iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:625:2: iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlFieldAccessorRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1445);
            iv_ruleVxlFieldAccessor=ruleVxlFieldAccessor();
            _fsp--;

             current =iv_ruleVxlFieldAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlFieldAccessor1455); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:632:1: ruleVxlFieldAccessor returns [EObject current=null] : ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )? ) ;
    public final EObject ruleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_accessor_2 = null;


        setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:637:6: ( ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:638:1: ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:638:1: ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:638:2: '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleVxlAccessor )?
            {
            match(input,17,FOLLOW_17_in_ruleVxlFieldAccessor1489); 

                    createLeafNode(grammarAccess.getVxlFieldAccessorAccess().getFullStopKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:642:1: (lv_name_1= RULE_ID )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:644:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1511); 

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

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:662:2: (lv_accessor_2= ruleVxlAccessor )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15||LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:665:6: lv_accessor_2= ruleVxlAccessor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlFieldAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1553);
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:690:1: entryRuleVxlList returns [EObject current=null] : iv_ruleVxlList= ruleVxlList EOF ;
    public final EObject entryRuleVxlList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlList = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:690:49: (iv_ruleVxlList= ruleVxlList EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:691:2: iv_ruleVxlList= ruleVxlList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlListRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlList_in_entryRuleVxlList1591);
            iv_ruleVxlList=ruleVxlList();
            _fsp--;

             current =iv_ruleVxlList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlList1601); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:698:1: ruleVxlList returns [EObject current=null] : ( '[' (lv_body_1= ruleVxlListElement )? ']' ) ;
    public final EObject ruleVxlList() throws RecognitionException {
        EObject current = null;

        EObject lv_body_1 = null;


        setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:703:6: ( ( '[' (lv_body_1= ruleVxlListElement )? ']' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:704:1: ( '[' (lv_body_1= ruleVxlListElement )? ']' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:704:1: ( '[' (lv_body_1= ruleVxlListElement )? ']' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:704:2: '[' (lv_body_1= ruleVxlListElement )? ']'
            {
            match(input,15,FOLLOW_15_in_ruleVxlList1635); 

                    createLeafNode(grammarAccess.getVxlListAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:708:1: (lv_body_1= ruleVxlListElement )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_INT)||LA8_0==11||(LA8_0>=13 && LA8_0<=15)||(LA8_0>=19 && LA8_0<=21)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:711:6: lv_body_1= ruleVxlListElement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlListAccess().getBodyVxlListElementParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlList1669);
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

            match(input,16,FOLLOW_16_in_ruleVxlList1683); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:740:1: entryRuleVxlListElement returns [EObject current=null] : iv_ruleVxlListElement= ruleVxlListElement EOF ;
    public final EObject entryRuleVxlListElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlListElement = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:740:56: (iv_ruleVxlListElement= ruleVxlListElement EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:741:2: iv_ruleVxlListElement= ruleVxlListElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlListElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1716);
            iv_ruleVxlListElement=ruleVxlListElement();
            _fsp--;

             current =iv_ruleVxlListElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlListElement1726); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:748:1: ruleVxlListElement returns [EObject current=null] : ( (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )? ) ;
    public final EObject ruleVxlListElement() throws RecognitionException {
        EObject current = null;

        EObject lv_first_0 = null;

        EObject lv_rest_2 = null;


       setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:753:6: ( ( (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:754:1: ( (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:754:1: ( (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:754:2: (lv_first_0= ruleVxlTerm ) ( ',' (lv_rest_2= ruleVxlListElement ) )?
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:754:2: (lv_first_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:757:6: lv_first_0= ruleVxlTerm
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlListElementAccess().getFirstVxlTermParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlListElement1785);
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

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:775:2: ( ',' (lv_rest_2= ruleVxlListElement ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:775:3: ',' (lv_rest_2= ruleVxlListElement )
                    {
                    match(input,18,FOLLOW_18_in_ruleVxlListElement1799); 

                            createLeafNode(grammarAccess.getVxlListElementAccess().getCommaKeyword_1_0(), null); 
                        
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:779:1: (lv_rest_2= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:782:6: lv_rest_2= ruleVxlListElement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVxlListElementAccess().getRestVxlListElementParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlListElement1833);
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:807:1: entryRuleVxlValue returns [EObject current=null] : iv_ruleVxlValue= ruleVxlValue EOF ;
    public final EObject entryRuleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlValue = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:807:50: (iv_ruleVxlValue= ruleVxlValue EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:808:2: iv_ruleVxlValue= ruleVxlValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlValue_in_entryRuleVxlValue1872);
            iv_ruleVxlValue=ruleVxlValue();
            _fsp--;

             current =iv_ruleVxlValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlValue1882); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:815:1: ruleVxlValue returns [EObject current=null] : (this_VxlStringConst_0= ruleVxlStringConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlNullConst_3= ruleVxlNullConst ) ;
    public final EObject ruleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject this_VxlStringConst_0 = null;

        EObject this_VxlBooleanConst_1 = null;

        EObject this_VxlNumericConst_2 = null;

        EObject this_VxlNullConst_3 = null;


        setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:820:6: ( (this_VxlStringConst_0= ruleVxlStringConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlNullConst_3= ruleVxlNullConst ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:821:1: (this_VxlStringConst_0= ruleVxlStringConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlNullConst_3= ruleVxlNullConst )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:821:1: (this_VxlStringConst_0= ruleVxlStringConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlNullConst_3= ruleVxlNullConst )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt10=1;
                }
                break;
            case 19:
            case 20:
                {
                alt10=2;
                }
                break;
            case RULE_INT:
                {
                alt10=3;
                }
                break;
            case 21:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("821:1: (this_VxlStringConst_0= ruleVxlStringConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlNullConst_3= ruleVxlNullConst )", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:822:5: this_VxlStringConst_0= ruleVxlStringConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlStringConstParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlStringConst_in_ruleVxlValue1929);
                    this_VxlStringConst_0=ruleVxlStringConst();
                    _fsp--;

                     
                            current = this_VxlStringConst_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:832:5: this_VxlBooleanConst_1= ruleVxlBooleanConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlBooleanConstParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue1956);
                    this_VxlBooleanConst_1=ruleVxlBooleanConst();
                    _fsp--;

                     
                            current = this_VxlBooleanConst_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:842:5: this_VxlNumericConst_2= ruleVxlNumericConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlNumericConstParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlNumericConst_in_ruleVxlValue1983);
                    this_VxlNumericConst_2=ruleVxlNumericConst();
                    _fsp--;

                     
                            current = this_VxlNumericConst_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:852:5: this_VxlNullConst_3= ruleVxlNullConst
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVxlValueAccess().getVxlNullConstParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVxlNullConst_in_ruleVxlValue2010);
                    this_VxlNullConst_3=ruleVxlNullConst();
                    _fsp--;

                     
                            current = this_VxlNullConst_3; 
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


    // $ANTLR start entryRuleVxlStringConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:867:1: entryRuleVxlStringConst returns [EObject current=null] : iv_ruleVxlStringConst= ruleVxlStringConst EOF ;
    public final EObject entryRuleVxlStringConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlStringConst = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:867:56: (iv_ruleVxlStringConst= ruleVxlStringConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:868:2: iv_ruleVxlStringConst= ruleVxlStringConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlStringConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2042);
            iv_ruleVxlStringConst=ruleVxlStringConst();
            _fsp--;

             current =iv_ruleVxlStringConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlStringConst2052); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:875:1: ruleVxlStringConst returns [EObject current=null] : (lv_const_0= RULE_STRING ) ;
    public final EObject ruleVxlStringConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0=null;

        setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:880:6: ( (lv_const_0= RULE_STRING ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:881:1: (lv_const_0= RULE_STRING )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:881:1: (lv_const_0= RULE_STRING )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:883:6: lv_const_0= RULE_STRING
            {
            lv_const_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVxlStringConst2098); 

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


    // $ANTLR start entryRuleVxlNumericConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:908:1: entryRuleVxlNumericConst returns [EObject current=null] : iv_ruleVxlNumericConst= ruleVxlNumericConst EOF ;
    public final EObject entryRuleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNumericConst = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:908:57: (iv_ruleVxlNumericConst= ruleVxlNumericConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:909:2: iv_ruleVxlNumericConst= ruleVxlNumericConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlNumericConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2138);
            iv_ruleVxlNumericConst=ruleVxlNumericConst();
            _fsp--;

             current =iv_ruleVxlNumericConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNumericConst2148); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:916:1: ruleVxlNumericConst returns [EObject current=null] : (lv_const_0= ruleNUMERIC ) ;
    public final EObject ruleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_const_0 = null;


        setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:921:6: ( (lv_const_0= ruleNUMERIC ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:922:1: (lv_const_0= ruleNUMERIC )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:922:1: (lv_const_0= ruleNUMERIC )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:925:6: lv_const_0= ruleNUMERIC
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVxlNumericConstAccess().getConstNUMERICParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2206);
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


    // $ANTLR start entryRuleVxlBooleanConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:950:1: entryRuleVxlBooleanConst returns [EObject current=null] : iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF ;
    public final EObject entryRuleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBooleanConst = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:950:57: (iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:951:2: iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlBooleanConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst2242);
            iv_ruleVxlBooleanConst=ruleVxlBooleanConst();
            _fsp--;

             current =iv_ruleVxlBooleanConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlBooleanConst2252); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:958:1: ruleVxlBooleanConst returns [EObject current=null] : (lv_const_0= ( 'true' | 'false' ) ) ;
    public final EObject ruleVxlBooleanConst() throws RecognitionException {
        EObject current = null;


        setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:963:6: ( (lv_const_0= ( 'true' | 'false' ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:964:1: (lv_const_0= ( 'true' | 'false' ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:964:1: (lv_const_0= ( 'true' | 'false' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:966:6: lv_const_0= ( 'true' | 'false' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:966:17: ( 'true' | 'false' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            else if ( (LA11_0==20) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("966:17: ( 'true' | 'false' )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:966:18: 'true'
                    {
                    match(input,19,FOLLOW_19_in_ruleVxlBooleanConst2298); 

                            createLeafNode(grammarAccess.getVxlBooleanConstAccess().getConstTrueKeyword_0_0(), "const"); 
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:972:6: 'false'
                    {
                    match(input,20,FOLLOW_20_in_ruleVxlBooleanConst2314); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:999:1: entryRuleVxlNullConst returns [EObject current=null] : iv_ruleVxlNullConst= ruleVxlNullConst EOF ;
    public final EObject entryRuleVxlNullConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNullConst = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:999:54: (iv_ruleVxlNullConst= ruleVxlNullConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1000:2: iv_ruleVxlNullConst= ruleVxlNullConst EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVxlNullConstRule(), currentNode); 
            pushFollow(FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst2361);
            iv_ruleVxlNullConst=ruleVxlNullConst();
            _fsp--;

             current =iv_ruleVxlNullConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNullConst2371); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1007:1: ruleVxlNullConst returns [EObject current=null] : (lv_const_0= 'null' ) ;
    public final EObject ruleVxlNullConst() throws RecognitionException {
        EObject current = null;

        

       setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1012:6: ( (lv_const_0= 'null' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1013:1: (lv_const_0= 'null' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1013:1: (lv_const_0= 'null' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1015:6: lv_const_0= 'null'
            {
            input.LT(1);
            match(input,21,FOLLOW_21_in_ruleVxlNullConst2416); 

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


    // $ANTLR start entryRuleNUMERIC
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1041:1: entryRuleNUMERIC returns [String current=null] : iv_ruleNUMERIC= ruleNUMERIC EOF ;
    public final String entryRuleNUMERIC() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMERIC = null;


        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1041:48: (iv_ruleNUMERIC= ruleNUMERIC EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1042:2: iv_ruleNUMERIC= ruleNUMERIC EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNUMERICRule(), currentNode); 
            pushFollow(FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2462);
            iv_ruleNUMERIC=ruleNUMERIC();
            _fsp--;

             current =iv_ruleNUMERIC.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUMERIC2473); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1049:1: ruleNUMERIC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMERIC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1055:6: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1056:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1056:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1056:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2513); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_0(), null); 
                
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1063:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1064:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleNUMERIC2532); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getNUMERICAccess().getFullStopKeyword_1_0(), null); 
                        
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2547); 

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1084:1: ruleVxlOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) ) ;
    public final Enumerator ruleVxlOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1088:6: ( ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1089:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1089:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )
            int alt13=14;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt13=1;
                }
                break;
            case 23:
                {
                alt13=2;
                }
                break;
            case 24:
                {
                alt13=3;
                }
                break;
            case 25:
                {
                alt13=4;
                }
                break;
            case 26:
                {
                alt13=5;
                }
                break;
            case 27:
                {
                alt13=6;
                }
                break;
            case 28:
                {
                alt13=7;
                }
                break;
            case 14:
                {
                alt13=8;
                }
                break;
            case 29:
                {
                alt13=9;
                }
                break;
            case 30:
                {
                alt13=10;
                }
                break;
            case 31:
                {
                alt13=11;
                }
                break;
            case 32:
                {
                alt13=12;
                }
                break;
            case 33:
                {
                alt13=13;
                }
                break;
            case 34:
                {
                alt13=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1089:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1089:2: ( '<' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1089:2: ( '<' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1089:4: '<'
                    {
                    match(input,22,FOLLOW_22_in_ruleVxlOperator2606); 

                            current = grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1095:6: ( '<=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1095:6: ( '<=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1095:8: '<='
                    {
                    match(input,23,FOLLOW_23_in_ruleVxlOperator2621); 

                            current = grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1101:6: ( '==' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1101:6: ( '==' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1101:8: '=='
                    {
                    match(input,24,FOLLOW_24_in_ruleVxlOperator2636); 

                            current = grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1107:6: ( '!=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1107:6: ( '!=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1107:8: '!='
                    {
                    match(input,25,FOLLOW_25_in_ruleVxlOperator2651); 

                            current = grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1113:6: ( '>' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1113:6: ( '>' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1113:8: '>'
                    {
                    match(input,26,FOLLOW_26_in_ruleVxlOperator2666); 

                            current = grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1119:6: ( '>=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1119:6: ( '>=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1119:8: '>='
                    {
                    match(input,27,FOLLOW_27_in_ruleVxlOperator2681); 

                            current = grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1125:6: ( '+' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1125:6: ( '+' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1125:8: '+'
                    {
                    match(input,28,FOLLOW_28_in_ruleVxlOperator2696); 

                            current = grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1131:6: ( '-' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1131:6: ( '-' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1131:8: '-'
                    {
                    match(input,14,FOLLOW_14_in_ruleVxlOperator2711); 

                            current = grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1137:6: ( '*' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1137:6: ( '*' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1137:8: '*'
                    {
                    match(input,29,FOLLOW_29_in_ruleVxlOperator2726); 

                            current = grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1143:6: ( '/' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1143:6: ( '/' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1143:8: '/'
                    {
                    match(input,30,FOLLOW_30_in_ruleVxlOperator2741); 

                            current = grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9(), null); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1149:6: ( '%' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1149:6: ( '%' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1149:8: '%'
                    {
                    match(input,31,FOLLOW_31_in_ruleVxlOperator2756); 

                            current = grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10(), null); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1155:6: ( 'and' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1155:6: ( 'and' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1155:8: 'and'
                    {
                    match(input,32,FOLLOW_32_in_ruleVxlOperator2771); 

                            current = grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11(), null); 
                        

                    }


                    }
                    break;
                case 13 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1161:6: ( 'or' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1161:6: ( 'or' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1161:8: 'or'
                    {
                    match(input,33,FOLLOW_33_in_ruleVxlOperator2786); 

                            current = grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12(), null); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1167:6: ( '++' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1167:6: ( '++' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1167:8: '++'
                    {
                    match(input,34,FOLLOW_34_in_ruleVxlOperator2801); 

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
    public static final BitSet FOLLOW_ruleVxlHead_in_ruleVxlTerm142 = new BitSet(new long[]{0x00000007FFC04002L});
    public static final BitSet FOLLOW_ruleVxlTail_in_ruleVxlTerm180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlHead_in_entryRuleVxlHead218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlHead228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBracketTerm_in_ruleVxlHead275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNegation_in_ruleVxlHead302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMinus_in_ruleVxlHead329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlAtom_in_ruleVxlHead356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlTail_in_entryRuleVxlTail388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlTail398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlOperator_in_ruleVxlTail457 = new BitSet(new long[]{0x000000000038E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlTail495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBracketTerm_in_entryRuleVxlBracketTerm532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlBracketTerm542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleVxlBracketTerm576 = new BitSet(new long[]{0x000000000038E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm610 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVxlBracketTerm623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNegation666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleVxlNegation700 = new BitSet(new long[]{0x000000000038E870L});
    public static final BitSet FOLLOW_ruleVxlHead_in_ruleVxlNegation734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlMinus781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlMinus815 = new BitSet(new long[]{0x000000000038E870L});
    public static final BitSet FOLLOW_ruleVxlHead_in_ruleVxlMinus849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlAtom_in_entryRuleVxlAtom886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlAtom896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlValue_in_ruleVxlAtom943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlVariable_in_ruleVxlAtom970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlList_in_ruleVxlAtom997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable1029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlVariable1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlVariable1086 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlVariable1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor1166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlAccessor1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlArrayAccessor1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVxlArrayAccessor1326 = new BitSet(new long[]{0x000000000038E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1360 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVxlArrayAccessor1373 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlFieldAccessor1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVxlFieldAccessor1489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1511 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlList_in_entryRuleVxlList1591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlList1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVxlList1635 = new BitSet(new long[]{0x000000000039E870L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlList1669 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVxlList1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1716 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlListElement1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlListElement1785 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleVxlListElement1799 = new BitSet(new long[]{0x000000000038E870L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlListElement1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlValue_in_entryRuleVxlValue1872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlValue1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_ruleVxlValue1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_ruleVxlValue1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_ruleVxlValue2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlStringConst2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVxlStringConst2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNumericConst2148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst2242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlBooleanConst2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleVxlBooleanConst2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVxlBooleanConst2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst2361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNullConst2371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVxlNullConst2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUMERIC2473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2513 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleNUMERIC2532 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVxlOperator2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVxlOperator2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVxlOperator2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVxlOperator2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVxlOperator2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVxlOperator2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVxlOperator2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlOperator2711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVxlOperator2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVxlOperator2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVxlOperator2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVxlOperator2771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVxlOperator2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleVxlOperator2801 = new BitSet(new long[]{0x0000000000000002L});

}