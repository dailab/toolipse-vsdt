package de.dailab.vsdt.parser.antlr.internal; 

import java.io.InputStream;
import java.util.HashMap;

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

import de.dailab.vsdt.services.VxlGrammarAccess;
public class InternalVxlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'!'", "'-'", "'$'", "'['", "']'", "'.'", "'true'", "'false'", "'null'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", "'+'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'++'"
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
            ruleMemo = new HashMap[62+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g"; }


     
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
        	return classLoader.getResourceAsStream("de/dailab/vsdt/parser/antlr/internal/InternalVxl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Term";	
       	} 



    // $ANTLR start entryRuleTerm
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:75:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;
        int entryRuleTerm_StartIndex = input.index();
        EObject iv_ruleTerm = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:75:46: (iv_ruleTerm= ruleTerm EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:76:2: iv_ruleTerm= ruleTerm EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTermRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm86);
            iv_ruleTerm=ruleTerm();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm96); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 1, entryRuleTerm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleTerm


    // $ANTLR start ruleTerm
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:83:1: ruleTerm returns [EObject current=null] : ( (lv_head_0= ruleHead ) (lv_tail_1= ruleTail )? ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;
        int ruleTerm_StartIndex = input.index();
        EObject lv_head_0 = null;

        EObject lv_tail_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:88:6: ( ( (lv_head_0= ruleHead ) (lv_tail_1= ruleTail )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:89:1: ( (lv_head_0= ruleHead ) (lv_tail_1= ruleTail )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:89:1: ( (lv_head_0= ruleHead ) (lv_tail_1= ruleTail )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:89:2: (lv_head_0= ruleHead ) (lv_tail_1= ruleTail )?
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:89:2: (lv_head_0= ruleHead )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:92:6: lv_head_0= ruleHead
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTermAccess().getHeadHeadParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleHead_in_ruleTerm155);
            lv_head_0=ruleHead();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTermRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		set(current, "head", lv_head_0, "Head", currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:110:2: (lv_tail_1= ruleTail )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14||(LA1_0>=22 && LA1_0<=34)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:113:6: lv_tail_1= ruleTail
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTermAccess().getTailTailParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTail_in_ruleTerm193);
                    lv_tail_1=ruleTail();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTermRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "tail", lv_tail_1, "Tail", currentNode);
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

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 2, ruleTerm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleTerm


    // $ANTLR start entryRuleHead
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:138:1: entryRuleHead returns [EObject current=null] : iv_ruleHead= ruleHead EOF ;
    public final EObject entryRuleHead() throws RecognitionException {
        EObject current = null;
        int entryRuleHead_StartIndex = input.index();
        EObject iv_ruleHead = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:138:46: (iv_ruleHead= ruleHead EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:139:2: iv_ruleHead= ruleHead EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getHeadRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleHead_in_entryRuleHead231);
            iv_ruleHead=ruleHead();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleHead; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHead241); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 3, entryRuleHead_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleHead


    // $ANTLR start ruleHead
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:146:1: ruleHead returns [EObject current=null] : (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Minus_2= ruleMinus | this_Atom_3= ruleAtom ) ;
    public final EObject ruleHead() throws RecognitionException {
        EObject current = null;
        int ruleHead_StartIndex = input.index();
        EObject this_BracketTerm_0 = null;

        EObject this_Negation_1 = null;

        EObject this_Minus_2 = null;

        EObject this_Atom_3 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:151:6: ( (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Minus_2= ruleMinus | this_Atom_3= ruleAtom ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:152:1: (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Minus_2= ruleMinus | this_Atom_3= ruleAtom )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:152:1: (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Minus_2= ruleMinus | this_Atom_3= ruleAtom )
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
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("152:1: (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Minus_2= ruleMinus | this_Atom_3= ruleAtom )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:153:5: this_BracketTerm_0= ruleBracketTerm
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getHeadAccess().getBracketTermParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBracketTerm_in_ruleHead288);
                    this_BracketTerm_0=ruleBracketTerm();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BracketTerm_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:163:5: this_Negation_1= ruleNegation
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getHeadAccess().getNegationParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNegation_in_ruleHead315);
                    this_Negation_1=ruleNegation();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Negation_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:173:5: this_Minus_2= ruleMinus
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getHeadAccess().getMinusParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleMinus_in_ruleHead342);
                    this_Minus_2=ruleMinus();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Minus_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:183:5: this_Atom_3= ruleAtom
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getHeadAccess().getAtomParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleAtom_in_ruleHead369);
                    this_Atom_3=ruleAtom();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Atom_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 4, ruleHead_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleHead


    // $ANTLR start entryRuleTail
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:198:1: entryRuleTail returns [EObject current=null] : iv_ruleTail= ruleTail EOF ;
    public final EObject entryRuleTail() throws RecognitionException {
        EObject current = null;
        int entryRuleTail_StartIndex = input.index();
        EObject iv_ruleTail = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:198:46: (iv_ruleTail= ruleTail EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:199:2: iv_ruleTail= ruleTail EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTailRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTail_in_entryRuleTail401);
            iv_ruleTail=ruleTail();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTail; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTail411); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 5, entryRuleTail_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleTail


    // $ANTLR start ruleTail
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:206:1: ruleTail returns [EObject current=null] : ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) ) ;
    public final EObject ruleTail() throws RecognitionException {
        EObject current = null;
        int ruleTail_StartIndex = input.index();
        Enumerator lv_operator_0 = null;

        EObject lv_term_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:211:6: ( ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:212:1: ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:212:1: ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:212:2: (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:212:2: (lv_operator_0= ruleOperator )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:215:6: lv_operator_0= ruleOperator
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTailAccess().getOperatorOperatorEnumRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOperator_in_ruleTail470);
            lv_operator_0=ruleOperator();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTailRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		set(current, "operator", lv_operator_0, "Operator", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:233:2: (lv_term_1= ruleTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:236:6: lv_term_1= ruleTerm
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTailAccess().getTermTermParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleTail508);
            lv_term_1=ruleTerm();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTailRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		set(current, "term", lv_term_1, "Term", currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 6, ruleTail_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleTail


    // $ANTLR start entryRuleBracketTerm
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:261:1: entryRuleBracketTerm returns [EObject current=null] : iv_ruleBracketTerm= ruleBracketTerm EOF ;
    public final EObject entryRuleBracketTerm() throws RecognitionException {
        EObject current = null;
        int entryRuleBracketTerm_StartIndex = input.index();
        EObject iv_ruleBracketTerm = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:261:53: (iv_ruleBracketTerm= ruleBracketTerm EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:262:2: iv_ruleBracketTerm= ruleBracketTerm EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBracketTermRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBracketTerm_in_entryRuleBracketTerm545);
            iv_ruleBracketTerm=ruleBracketTerm();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBracketTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBracketTerm555); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 7, entryRuleBracketTerm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleBracketTerm


    // $ANTLR start ruleBracketTerm
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:269:1: ruleBracketTerm returns [EObject current=null] : ( '(' (lv_term_1= ruleTerm ) ')' ) ;
    public final EObject ruleBracketTerm() throws RecognitionException {
        EObject current = null;
        int ruleBracketTerm_StartIndex = input.index();
        EObject lv_term_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 8) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:274:6: ( ( '(' (lv_term_1= ruleTerm ) ')' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:275:1: ( '(' (lv_term_1= ruleTerm ) ')' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:275:1: ( '(' (lv_term_1= ruleTerm ) ')' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:275:2: '(' (lv_term_1= ruleTerm ) ')'
            {
            match(input,11,FOLLOW_11_in_ruleBracketTerm589); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBracketTermAccess().getLeftParenthesisKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:279:1: (lv_term_1= ruleTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:282:6: lv_term_1= ruleTerm
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getBracketTermAccess().getTermTermParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleBracketTerm623);
            lv_term_1=ruleTerm();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getBracketTermRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		set(current, "term", lv_term_1, "Term", currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }

            match(input,12,FOLLOW_12_in_ruleBracketTerm636); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBracketTermAccess().getRightParenthesisKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 8, ruleBracketTerm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleBracketTerm


    // $ANTLR start entryRuleNegation
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:311:1: entryRuleNegation returns [EObject current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final EObject entryRuleNegation() throws RecognitionException {
        EObject current = null;
        int entryRuleNegation_StartIndex = input.index();
        EObject iv_ruleNegation = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:311:50: (iv_ruleNegation= ruleNegation EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:312:2: iv_ruleNegation= ruleNegation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNegationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation669);
            iv_ruleNegation=ruleNegation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNegation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation679); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 9, entryRuleNegation_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleNegation


    // $ANTLR start ruleNegation
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:319:1: ruleNegation returns [EObject current=null] : ( '!' (lv_head_1= ruleHead ) ) ;
    public final EObject ruleNegation() throws RecognitionException {
        EObject current = null;
        int ruleNegation_StartIndex = input.index();
        EObject lv_head_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 10) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:324:6: ( ( '!' (lv_head_1= ruleHead ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:325:1: ( '!' (lv_head_1= ruleHead ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:325:1: ( '!' (lv_head_1= ruleHead ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:325:2: '!' (lv_head_1= ruleHead )
            {
            match(input,13,FOLLOW_13_in_ruleNegation713); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getNegationAccess().getExclamationMarkKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:329:1: (lv_head_1= ruleHead )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:332:6: lv_head_1= ruleHead
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getNegationAccess().getHeadHeadParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleHead_in_ruleNegation747);
            lv_head_1=ruleHead();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getNegationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		set(current, "head", lv_head_1, "Head", currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 10, ruleNegation_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleNegation


    // $ANTLR start entryRuleMinus
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:357:1: entryRuleMinus returns [EObject current=null] : iv_ruleMinus= ruleMinus EOF ;
    public final EObject entryRuleMinus() throws RecognitionException {
        EObject current = null;
        int entryRuleMinus_StartIndex = input.index();
        EObject iv_ruleMinus = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:357:47: (iv_ruleMinus= ruleMinus EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:358:2: iv_ruleMinus= ruleMinus EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMinusRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleMinus_in_entryRuleMinus784);
            iv_ruleMinus=ruleMinus();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleMinus; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMinus794); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 11, entryRuleMinus_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleMinus


    // $ANTLR start ruleMinus
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:365:1: ruleMinus returns [EObject current=null] : ( '-' (lv_head_1= ruleHead ) ) ;
    public final EObject ruleMinus() throws RecognitionException {
        EObject current = null;
        int ruleMinus_StartIndex = input.index();
        EObject lv_head_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 12) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:370:6: ( ( '-' (lv_head_1= ruleHead ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:371:1: ( '-' (lv_head_1= ruleHead ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:371:1: ( '-' (lv_head_1= ruleHead ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:371:2: '-' (lv_head_1= ruleHead )
            {
            match(input,14,FOLLOW_14_in_ruleMinus828); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getMinusAccess().getHyphenMinusKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:375:1: (lv_head_1= ruleHead )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:378:6: lv_head_1= ruleHead
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getMinusAccess().getHeadHeadParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleHead_in_ruleMinus862);
            lv_head_1=ruleHead();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getMinusRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		set(current, "head", lv_head_1, "Head", currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 12, ruleMinus_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleMinus


    // $ANTLR start entryRuleAtom
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:403:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;
        int entryRuleAtom_StartIndex = input.index();
        EObject iv_ruleAtom = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:403:46: (iv_ruleAtom= ruleAtom EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:404:2: iv_ruleAtom= ruleAtom EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom899);
            iv_ruleAtom=ruleAtom();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAtom; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom909); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 13, entryRuleAtom_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleAtom


    // $ANTLR start ruleAtom
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:411:1: ruleAtom returns [EObject current=null] : (this_Value_0= ruleValue | this_Variable_1= ruleVariable ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;
        int ruleAtom_StartIndex = input.index();
        EObject this_Value_0 = null;

        EObject this_Variable_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 14) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:416:6: ( (this_Value_0= ruleValue | this_Variable_1= ruleVariable ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:417:1: (this_Value_0= ruleValue | this_Variable_1= ruleVariable )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:417:1: (this_Value_0= ruleValue | this_Variable_1= ruleVariable )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_INT)||(LA3_0>=19 && LA3_0<=21)) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("417:1: (this_Value_0= ruleValue | this_Variable_1= ruleVariable )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:418:5: this_Value_0= ruleValue
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomAccess().getValueParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleValue_in_ruleAtom956);
                    this_Value_0=ruleValue();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Value_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:428:5: this_Variable_1= ruleVariable
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomAccess().getVariableParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleVariable_in_ruleAtom983);
                    this_Variable_1=ruleVariable();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Variable_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 14, ruleAtom_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleVariable
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:443:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;
        int entryRuleVariable_StartIndex = input.index();
        EObject iv_ruleVariable = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:443:50: (iv_ruleVariable= ruleVariable EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:444:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable1015);
            iv_ruleVariable=ruleVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable1025); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 15, entryRuleVariable_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleVariable


    // $ANTLR start ruleVariable
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:451:1: ruleVariable returns [EObject current=null] : ( '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;
        int ruleVariable_StartIndex = input.index();
        Token lv_name_1=null;
        EObject lv_accessor_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:456:6: ( ( '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:457:1: ( '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:457:1: ( '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:457:2: '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )?
            {
            match(input,15,FOLLOW_15_in_ruleVariable1059); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getVariableAccess().getDollarSignKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:461:1: (lv_name_1= RULE_ID )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:463:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariable1081); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              	
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:481:2: (lv_accessor_2= ruleAccessor )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16||LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:484:6: lv_accessor_2= ruleAccessor
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getAccessorAccessorParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessor_in_ruleVariable1123);
                    lv_accessor_2=ruleAccessor();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "accessor", lv_accessor_2, "Accessor", currentNode);
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

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 16, ruleVariable_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleVariable


    // $ANTLR start entryRuleAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:509:1: entryRuleAccessor returns [EObject current=null] : iv_ruleAccessor= ruleAccessor EOF ;
    public final EObject entryRuleAccessor() throws RecognitionException {
        EObject current = null;
        int entryRuleAccessor_StartIndex = input.index();
        EObject iv_ruleAccessor = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:509:50: (iv_ruleAccessor= ruleAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:510:2: iv_ruleAccessor= ruleAccessor EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAccessorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAccessor_in_entryRuleAccessor1161);
            iv_ruleAccessor=ruleAccessor();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAccessor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessor1171); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 17, entryRuleAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleAccessor


    // $ANTLR start ruleAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:517:1: ruleAccessor returns [EObject current=null] : (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor ) ;
    public final EObject ruleAccessor() throws RecognitionException {
        EObject current = null;
        int ruleAccessor_StartIndex = input.index();
        EObject this_ArrayAccessor_0 = null;

        EObject this_FieldAccessor_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:522:6: ( (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:523:1: (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:523:1: (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("523:1: (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:524:5: this_ArrayAccessor_0= ruleArrayAccessor
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAccessorAccess().getArrayAccessorParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleArrayAccessor_in_ruleAccessor1218);
                    this_ArrayAccessor_0=ruleArrayAccessor();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ArrayAccessor_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:534:5: this_FieldAccessor_1= ruleFieldAccessor
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAccessorAccess().getFieldAccessorParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFieldAccessor_in_ruleAccessor1245);
                    this_FieldAccessor_1=ruleFieldAccessor();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_FieldAccessor_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 18, ruleAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleAccessor


    // $ANTLR start entryRuleArrayAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:549:1: entryRuleArrayAccessor returns [EObject current=null] : iv_ruleArrayAccessor= ruleArrayAccessor EOF ;
    public final EObject entryRuleArrayAccessor() throws RecognitionException {
        EObject current = null;
        int entryRuleArrayAccessor_StartIndex = input.index();
        EObject iv_ruleArrayAccessor = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:549:55: (iv_ruleArrayAccessor= ruleArrayAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:550:2: iv_ruleArrayAccessor= ruleArrayAccessor EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getArrayAccessorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleArrayAccessor_in_entryRuleArrayAccessor1277);
            iv_ruleArrayAccessor=ruleArrayAccessor();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleArrayAccessor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayAccessor1287); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 19, entryRuleArrayAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleArrayAccessor


    // $ANTLR start ruleArrayAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:557:1: ruleArrayAccessor returns [EObject current=null] : ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )? ) ;
    public final EObject ruleArrayAccessor() throws RecognitionException {
        EObject current = null;
        int ruleArrayAccessor_StartIndex = input.index();
        EObject lv_index_1 = null;

        EObject lv_accessor_3 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:562:6: ( ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:563:1: ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:563:1: ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:563:2: '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )?
            {
            match(input,16,FOLLOW_16_in_ruleArrayAccessor1321); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getArrayAccessorAccess().getLeftSquareBracketKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:567:1: (lv_index_1= ruleTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:570:6: lv_index_1= ruleTerm
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getArrayAccessorAccess().getIndexTermParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleArrayAccessor1355);
            lv_index_1=ruleTerm();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getArrayAccessorRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		set(current, "index", lv_index_1, "Term", currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }

            match(input,17,FOLLOW_17_in_ruleArrayAccessor1368); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getArrayAccessorAccess().getRightSquareBracketKeyword_2(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:592:1: (lv_accessor_3= ruleAccessor )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16||LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:595:6: lv_accessor_3= ruleAccessor
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getArrayAccessorAccess().getAccessorAccessorParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessor_in_ruleArrayAccessor1402);
                    lv_accessor_3=ruleAccessor();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getArrayAccessorRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "accessor", lv_accessor_3, "Accessor", currentNode);
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

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 20, ruleArrayAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleArrayAccessor


    // $ANTLR start entryRuleFieldAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:620:1: entryRuleFieldAccessor returns [EObject current=null] : iv_ruleFieldAccessor= ruleFieldAccessor EOF ;
    public final EObject entryRuleFieldAccessor() throws RecognitionException {
        EObject current = null;
        int entryRuleFieldAccessor_StartIndex = input.index();
        EObject iv_ruleFieldAccessor = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:620:55: (iv_ruleFieldAccessor= ruleFieldAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:621:2: iv_ruleFieldAccessor= ruleFieldAccessor EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFieldAccessorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFieldAccessor_in_entryRuleFieldAccessor1440);
            iv_ruleFieldAccessor=ruleFieldAccessor();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFieldAccessor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFieldAccessor1450); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 21, entryRuleFieldAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleFieldAccessor


    // $ANTLR start ruleFieldAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:628:1: ruleFieldAccessor returns [EObject current=null] : ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? ) ;
    public final EObject ruleFieldAccessor() throws RecognitionException {
        EObject current = null;
        int ruleFieldAccessor_StartIndex = input.index();
        Token lv_name_1=null;
        EObject lv_accessor_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:633:6: ( ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:634:1: ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:634:1: ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:634:2: '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )?
            {
            match(input,18,FOLLOW_18_in_ruleFieldAccessor1484); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFieldAccessorAccess().getFullStopKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:638:1: (lv_name_1= RULE_ID )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:640:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFieldAccessor1506); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getFieldAccessorAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              	
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFieldAccessorRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:658:2: (lv_accessor_2= ruleAccessor )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16||LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:661:6: lv_accessor_2= ruleAccessor
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFieldAccessorAccess().getAccessorAccessorParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessor_in_ruleFieldAccessor1548);
                    lv_accessor_2=ruleAccessor();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFieldAccessorRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "accessor", lv_accessor_2, "Accessor", currentNode);
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

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 22, ruleFieldAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleFieldAccessor


    // $ANTLR start entryRuleValue
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:686:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;
        int entryRuleValue_StartIndex = input.index();
        EObject iv_ruleValue = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:686:47: (iv_ruleValue= ruleValue EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:687:2: iv_ruleValue= ruleValue EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getValueRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1586);
            iv_ruleValue=ruleValue();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1596); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 23, entryRuleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleValue


    // $ANTLR start ruleValue
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:694:1: ruleValue returns [EObject current=null] : (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;
        int ruleValue_StartIndex = input.index();
        EObject this_StringConst_0 = null;

        EObject this_BooleanConst_1 = null;

        EObject this_NumericConst_2 = null;

        EObject this_NullConst_3 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:699:6: ( (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:700:1: (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:700:1: (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt8=1;
                }
                break;
            case 19:
            case 20:
                {
                alt8=2;
                }
                break;
            case RULE_INT:
                {
                alt8=3;
                }
                break;
            case 21:
                {
                alt8=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("700:1: (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst )", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:701:5: this_StringConst_0= ruleStringConst
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getValueAccess().getStringConstParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringConst_in_ruleValue1643);
                    this_StringConst_0=ruleStringConst();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_StringConst_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:711:5: this_BooleanConst_1= ruleBooleanConst
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getValueAccess().getBooleanConstParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanConst_in_ruleValue1670);
                    this_BooleanConst_1=ruleBooleanConst();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BooleanConst_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:721:5: this_NumericConst_2= ruleNumericConst
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getValueAccess().getNumericConstParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumericConst_in_ruleValue1697);
                    this_NumericConst_2=ruleNumericConst();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NumericConst_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:731:5: this_NullConst_3= ruleNullConst
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getValueAccess().getNullConstParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNullConst_in_ruleValue1724);
                    this_NullConst_3=ruleNullConst();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NullConst_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 24, ruleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleValue


    // $ANTLR start entryRuleStringConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:746:1: entryRuleStringConst returns [EObject current=null] : iv_ruleStringConst= ruleStringConst EOF ;
    public final EObject entryRuleStringConst() throws RecognitionException {
        EObject current = null;
        int entryRuleStringConst_StartIndex = input.index();
        EObject iv_ruleStringConst = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:746:53: (iv_ruleStringConst= ruleStringConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:747:2: iv_ruleStringConst= ruleStringConst EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringConstRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringConst_in_entryRuleStringConst1756);
            iv_ruleStringConst=ruleStringConst();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStringConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringConst1766); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 25, entryRuleStringConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleStringConst


    // $ANTLR start ruleStringConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:754:1: ruleStringConst returns [EObject current=null] : (lv_const_0= RULE_STRING ) ;
    public final EObject ruleStringConst() throws RecognitionException {
        EObject current = null;
        int ruleStringConst_StartIndex = input.index();
        Token lv_const_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 26) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:759:6: ( (lv_const_0= RULE_STRING ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:760:1: (lv_const_0= RULE_STRING )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:760:1: (lv_const_0= RULE_STRING )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:762:6: lv_const_0= RULE_STRING
            {
            lv_const_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringConst1812); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getStringConstAccess().getConstSTRINGTerminalRuleCall_0(), "const"); 
              	
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getStringConstRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "const", lv_const_0, "STRING", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 26, ruleStringConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleStringConst


    // $ANTLR start entryRuleNumericConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:787:1: entryRuleNumericConst returns [EObject current=null] : iv_ruleNumericConst= ruleNumericConst EOF ;
    public final EObject entryRuleNumericConst() throws RecognitionException {
        EObject current = null;
        int entryRuleNumericConst_StartIndex = input.index();
        EObject iv_ruleNumericConst = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:787:54: (iv_ruleNumericConst= ruleNumericConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:788:2: iv_ruleNumericConst= ruleNumericConst EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNumericConstRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNumericConst_in_entryRuleNumericConst1852);
            iv_ruleNumericConst=ruleNumericConst();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNumericConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericConst1862); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 27, entryRuleNumericConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleNumericConst


    // $ANTLR start ruleNumericConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:795:1: ruleNumericConst returns [EObject current=null] : (lv_const_0= ruleNUMERIC ) ;
    public final EObject ruleNumericConst() throws RecognitionException {
        EObject current = null;
        int ruleNumericConst_StartIndex = input.index();
        AntlrDatatypeRuleToken lv_const_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 28) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:800:6: ( (lv_const_0= ruleNUMERIC ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:801:1: (lv_const_0= ruleNUMERIC )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:801:1: (lv_const_0= ruleNUMERIC )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:804:6: lv_const_0= ruleNUMERIC
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getNumericConstAccess().getConstNUMERICParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleNUMERIC_in_ruleNumericConst1920);
            lv_const_0=ruleNUMERIC();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getNumericConstRule().getType().getClassifier());
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


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 28, ruleNumericConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleNumericConst


    // $ANTLR start entryRuleBooleanConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:829:1: entryRuleBooleanConst returns [EObject current=null] : iv_ruleBooleanConst= ruleBooleanConst EOF ;
    public final EObject entryRuleBooleanConst() throws RecognitionException {
        EObject current = null;
        int entryRuleBooleanConst_StartIndex = input.index();
        EObject iv_ruleBooleanConst = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:829:54: (iv_ruleBooleanConst= ruleBooleanConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:830:2: iv_ruleBooleanConst= ruleBooleanConst EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanConstRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBooleanConst_in_entryRuleBooleanConst1956);
            iv_ruleBooleanConst=ruleBooleanConst();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanConst1966); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 29, entryRuleBooleanConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanConst


    // $ANTLR start ruleBooleanConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:837:1: ruleBooleanConst returns [EObject current=null] : (lv_const_0= ( 'true' | 'false' ) ) ;
    public final EObject ruleBooleanConst() throws RecognitionException {
        EObject current = null;
        int ruleBooleanConst_StartIndex = input.index();

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:842:6: ( (lv_const_0= ( 'true' | 'false' ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:843:1: (lv_const_0= ( 'true' | 'false' ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:843:1: (lv_const_0= ( 'true' | 'false' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:845:6: lv_const_0= ( 'true' | 'false' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:845:17: ( 'true' | 'false' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            else if ( (LA9_0==20) ) {
                alt9=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("845:17: ( 'true' | 'false' )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:845:18: 'true'
                    {
                    match(input,19,FOLLOW_19_in_ruleBooleanConst2012); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanConstAccess().getConstTrueKeyword_0_0(), "const"); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:851:6: 'false'
                    {
                    match(input,20,FOLLOW_20_in_ruleBooleanConst2028); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanConstAccess().getConstFalseKeyword_0_1(), "const"); 
                          
                    }

                    }
                    break;

            }

            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getBooleanConstRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "const", /* lv_const_0 */ input.LT(-1), null, lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 30, ruleBooleanConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleBooleanConst


    // $ANTLR start entryRuleNullConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:878:1: entryRuleNullConst returns [EObject current=null] : iv_ruleNullConst= ruleNullConst EOF ;
    public final EObject entryRuleNullConst() throws RecognitionException {
        EObject current = null;
        int entryRuleNullConst_StartIndex = input.index();
        EObject iv_ruleNullConst = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:878:51: (iv_ruleNullConst= ruleNullConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:879:2: iv_ruleNullConst= ruleNullConst EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNullConstRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNullConst_in_entryRuleNullConst2075);
            iv_ruleNullConst=ruleNullConst();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNullConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullConst2085); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 31, entryRuleNullConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleNullConst


    // $ANTLR start ruleNullConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:886:1: ruleNullConst returns [EObject current=null] : (lv_const_0= 'null' ) ;
    public final EObject ruleNullConst() throws RecognitionException {
        EObject current = null;
        int ruleNullConst_StartIndex = input.index();

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:891:6: ( (lv_const_0= 'null' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:892:1: (lv_const_0= 'null' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:892:1: (lv_const_0= 'null' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:894:6: lv_const_0= 'null'
            {
            input.LT(1);
            match(input,21,FOLLOW_21_in_ruleNullConst2130); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getNullConstAccess().getConstNullKeyword_0(), "const"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getNullConstRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "const", /* lv_const_0 */ input.LT(-1), "null", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 32, ruleNullConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleNullConst


    // $ANTLR start entryRuleNUMERIC
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:920:1: entryRuleNUMERIC returns [String current=null] : iv_ruleNUMERIC= ruleNUMERIC EOF ;
    public final String entryRuleNUMERIC() throws RecognitionException {
        String current = null;
        int entryRuleNUMERIC_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleNUMERIC = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:920:48: (iv_ruleNUMERIC= ruleNUMERIC EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:921:2: iv_ruleNUMERIC= ruleNUMERIC EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNUMERICRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2176);
            iv_ruleNUMERIC=ruleNUMERIC();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNUMERIC.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUMERIC2187); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 33, entryRuleNUMERIC_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleNUMERIC


    // $ANTLR start ruleNUMERIC
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:928:1: ruleNUMERIC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMERIC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleNUMERIC_StartIndex = input.index();
        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 34) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:934:6: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:935:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:935:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:935:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2227); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:942:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:943:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleNUMERIC2246); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getNUMERICAccess().getFullStopKeyword_1_0(), null); 
                          
                    }
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2261); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_INT_2);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_1_1(), null); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
              	    lastConsumedDatatypeToken = current;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 34, ruleNUMERIC_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleNUMERIC


    // $ANTLR start ruleOperator
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:963:1: ruleOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;
        int ruleOperator_StartIndex = input.index();
         setCurrentLookahead(); resetLookahead(); 
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 35) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:967:6: ( ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:968:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:968:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) )
            int alt11=14;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt11=1;
                }
                break;
            case 23:
                {
                alt11=2;
                }
                break;
            case 24:
                {
                alt11=3;
                }
                break;
            case 25:
                {
                alt11=4;
                }
                break;
            case 26:
                {
                alt11=5;
                }
                break;
            case 27:
                {
                alt11=6;
                }
                break;
            case 28:
                {
                alt11=7;
                }
                break;
            case 14:
                {
                alt11=8;
                }
                break;
            case 29:
                {
                alt11=9;
                }
                break;
            case 30:
                {
                alt11=10;
                }
                break;
            case 31:
                {
                alt11=11;
                }
                break;
            case 32:
                {
                alt11=12;
                }
                break;
            case 33:
                {
                alt11=13;
                }
                break;
            case 34:
                {
                alt11=14;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("968:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) )", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:968:2: ( '<' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:968:2: ( '<' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:968:4: '<'
                    {
                    match(input,22,FOLLOW_22_in_ruleOperator2320); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getLTEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:974:6: ( '<=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:974:6: ( '<=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:974:8: '<='
                    {
                    match(input,23,FOLLOW_23_in_ruleOperator2335); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getLEEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:980:6: ( '==' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:980:6: ( '==' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:980:8: '=='
                    {
                    match(input,24,FOLLOW_24_in_ruleOperator2350); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getEQEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:986:6: ( '!=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:986:6: ( '!=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:986:8: '!='
                    {
                    match(input,25,FOLLOW_25_in_ruleOperator2365); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getNEQEnumLiteralDeclaration_3(), null); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:992:6: ( '>' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:992:6: ( '>' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:992:8: '>'
                    {
                    match(input,26,FOLLOW_26_in_ruleOperator2380); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getGTEnumLiteralDeclaration_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:998:6: ( '>=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:998:6: ( '>=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:998:8: '>='
                    {
                    match(input,27,FOLLOW_27_in_ruleOperator2395); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getGEEnumLiteralDeclaration_5(), null); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1004:6: ( '+' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1004:6: ( '+' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1004:8: '+'
                    {
                    match(input,28,FOLLOW_28_in_ruleOperator2410); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getADDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getADDEnumLiteralDeclaration_6(), null); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1010:6: ( '-' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1010:6: ( '-' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1010:8: '-'
                    {
                    match(input,14,FOLLOW_14_in_ruleOperator2425); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getSUBEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getSUBEnumLiteralDeclaration_7(), null); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1016:6: ( '*' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1016:6: ( '*' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1016:8: '*'
                    {
                    match(input,29,FOLLOW_29_in_ruleOperator2440); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getMULTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getMULTEnumLiteralDeclaration_8(), null); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1022:6: ( '/' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1022:6: ( '/' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1022:8: '/'
                    {
                    match(input,30,FOLLOW_30_in_ruleOperator2455); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getDIVEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getDIVEnumLiteralDeclaration_9(), null); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1028:6: ( '%' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1028:6: ( '%' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1028:8: '%'
                    {
                    match(input,31,FOLLOW_31_in_ruleOperator2470); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getMODEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getMODEnumLiteralDeclaration_10(), null); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1034:6: ( '&&' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1034:6: ( '&&' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1034:8: '&&'
                    {
                    match(input,32,FOLLOW_32_in_ruleOperator2485); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getANDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getANDEnumLiteralDeclaration_11(), null); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1040:6: ( '||' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1040:6: ( '||' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1040:8: '||'
                    {
                    match(input,33,FOLLOW_33_in_ruleOperator2500); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getOREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getOREnumLiteralDeclaration_12(), null); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1046:6: ( '++' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1046:6: ( '++' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:1046:8: '++'
                    {
                    match(input,34,FOLLOW_34_in_ruleOperator2515); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getCONCATEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getCONCATEnumLiteralDeclaration_13(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 35, ruleOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleOperator


 

    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm86 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHead_in_ruleTerm155 = new BitSet(new long[]{0x00000007FFC04002L});
    public static final BitSet FOLLOW_ruleTail_in_ruleTerm193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHead_in_entryRuleHead231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHead241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracketTerm_in_ruleHead288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleHead315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMinus_in_ruleHead342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleHead369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTail_in_entryRuleTail401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTail411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_ruleTail470 = new BitSet(new long[]{0x000000000038E860L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleTail508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracketTerm_in_entryRuleBracketTerm545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBracketTerm555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleBracketTerm589 = new BitSet(new long[]{0x000000000038E860L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleBracketTerm623 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleBracketTerm636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleNegation713 = new BitSet(new long[]{0x000000000038E860L});
    public static final BitSet FOLLOW_ruleHead_in_ruleNegation747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMinus_in_entryRuleMinus784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMinus794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleMinus828 = new BitSet(new long[]{0x000000000038E860L});
    public static final BitSet FOLLOW_ruleHead_in_ruleMinus862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleAtom956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleAtom983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable1015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVariable1059 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariable1081 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleAccessor_in_ruleVariable1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessor_in_entryRuleAccessor1161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessor1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayAccessor_in_ruleAccessor1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldAccessor_in_ruleAccessor1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayAccessor_in_entryRuleArrayAccessor1277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayAccessor1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleArrayAccessor1321 = new BitSet(new long[]{0x000000000038E860L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleArrayAccessor1355 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleArrayAccessor1368 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleAccessor_in_ruleArrayAccessor1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldAccessor_in_entryRuleFieldAccessor1440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFieldAccessor1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleFieldAccessor1484 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFieldAccessor1506 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleAccessor_in_ruleFieldAccessor1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1586 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConst_in_ruleValue1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanConst_in_ruleValue1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericConst_in_ruleValue1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullConst_in_ruleValue1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConst_in_entryRuleStringConst1756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringConst1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringConst1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericConst_in_entryRuleNumericConst1852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericConst1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_ruleNumericConst1920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanConst_in_entryRuleBooleanConst1956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanConst1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleBooleanConst2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleBooleanConst2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullConst_in_entryRuleNullConst2075 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullConst2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleNullConst2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUMERIC2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2227 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleNUMERIC2246 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOperator2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOperator2335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOperator2350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOperator2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOperator2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOperator2395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOperator2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOperator2425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOperator2440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOperator2455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOperator2470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOperator2485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOperator2500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOperator2515 = new BitSet(new long[]{0x0000000000000002L});

}