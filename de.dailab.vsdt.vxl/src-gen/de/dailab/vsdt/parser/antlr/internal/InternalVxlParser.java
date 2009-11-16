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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'!'", "'$'", "'['", "']'", "'.'", "'true'", "'false'", "'null'", "'-'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", "'+'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'++'"
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
            ruleMemo = new HashMap[60+1];
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
            switch ( input.LA(1) ) {
                case 22:
                    {
                    input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 23:
                    {
                    input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 24:
                    {
                    input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 25:
                    {
                    input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 26:
                    {
                    input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 27:
                    {
                     input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 28:
                    {
                     input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 21:
                    {
                     input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 29:
                    {
                    input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 30:
                    {
                    input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 31:
                    {
                     input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 32:
                    {
                     input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 33:
                    {
                     input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
                case 34:
                    {
                    input.LA(2);

                    if ( (synpred1()) ) {
                        alt1=1;
                    }
                    }
                    break;
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:146:1: ruleHead returns [EObject current=null] : (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Atom_2= ruleAtom ) ;
    public final EObject ruleHead() throws RecognitionException {
        EObject current = null;
        int ruleHead_StartIndex = input.index();
        EObject this_BracketTerm_0 = null;

        EObject this_Negation_1 = null;

        EObject this_Atom_2 = null;


          setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:151:6: ( (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Atom_2= ruleAtom ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:152:1: (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Atom_2= ruleAtom )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:152:1: (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Atom_2= ruleAtom )
            int alt2=3;
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
            case RULE_STRING:
            case RULE_INT:
            case 14:
            case 18:
            case 19:
            case 20:
            case 21:
                {
                alt2=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("152:1: (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Atom_2= ruleAtom )", 2, 0, input);

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
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:173:5: this_Atom_2= ruleAtom
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getHeadAccess().getAtomParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleAtom_in_ruleHead342);
                    this_Atom_2=ruleAtom();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Atom_2; 
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:188:1: entryRuleTail returns [EObject current=null] : iv_ruleTail= ruleTail EOF ;
    public final EObject entryRuleTail() throws RecognitionException {
        EObject current = null;
        int entryRuleTail_StartIndex = input.index();
        EObject iv_ruleTail = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:188:46: (iv_ruleTail= ruleTail EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:189:2: iv_ruleTail= ruleTail EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTailRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTail_in_entryRuleTail374);
            iv_ruleTail=ruleTail();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTail; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTail384); if (failed) return current;

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:196:1: ruleTail returns [EObject current=null] : ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) ) ;
    public final EObject ruleTail() throws RecognitionException {
        EObject current = null;
        int ruleTail_StartIndex = input.index();
        Enumerator lv_operator_0 = null;

        EObject lv_term_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:201:6: ( ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:202:1: ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:202:1: ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:202:2: (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:202:2: (lv_operator_0= ruleOperator )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:205:6: lv_operator_0= ruleOperator
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTailAccess().getOperatorOperatorEnumRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOperator_in_ruleTail443);
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

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:223:2: (lv_term_1= ruleTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:226:6: lv_term_1= ruleTerm
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTailAccess().getTermTermParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleTail481);
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:251:1: entryRuleBracketTerm returns [EObject current=null] : iv_ruleBracketTerm= ruleBracketTerm EOF ;
    public final EObject entryRuleBracketTerm() throws RecognitionException {
        EObject current = null;
        int entryRuleBracketTerm_StartIndex = input.index();
        EObject iv_ruleBracketTerm = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:251:53: (iv_ruleBracketTerm= ruleBracketTerm EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:252:2: iv_ruleBracketTerm= ruleBracketTerm EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBracketTermRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBracketTerm_in_entryRuleBracketTerm518);
            iv_ruleBracketTerm=ruleBracketTerm();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBracketTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBracketTerm528); if (failed) return current;

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:259:1: ruleBracketTerm returns [EObject current=null] : ( '(' (lv_term_1= ruleTerm ) ')' ) ;
    public final EObject ruleBracketTerm() throws RecognitionException {
        EObject current = null;
        int ruleBracketTerm_StartIndex = input.index();
        EObject lv_term_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 8) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:264:6: ( ( '(' (lv_term_1= ruleTerm ) ')' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:265:1: ( '(' (lv_term_1= ruleTerm ) ')' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:265:1: ( '(' (lv_term_1= ruleTerm ) ')' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:265:2: '(' (lv_term_1= ruleTerm ) ')'
            {
            match(input,11,FOLLOW_11_in_ruleBracketTerm562); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBracketTermAccess().getLeftParenthesisKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:269:1: (lv_term_1= ruleTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:272:6: lv_term_1= ruleTerm
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getBracketTermAccess().getTermTermParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleBracketTerm596);
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

            match(input,12,FOLLOW_12_in_ruleBracketTerm609); if (failed) return current;
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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:301:1: entryRuleNegation returns [EObject current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final EObject entryRuleNegation() throws RecognitionException {
        EObject current = null;
        int entryRuleNegation_StartIndex = input.index();
        EObject iv_ruleNegation = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:301:50: (iv_ruleNegation= ruleNegation EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:302:2: iv_ruleNegation= ruleNegation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNegationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation642);
            iv_ruleNegation=ruleNegation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNegation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation652); if (failed) return current;

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
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:309:1: ruleNegation returns [EObject current=null] : ( '!' (lv_term_1= ruleTerm ) ) ;
    public final EObject ruleNegation() throws RecognitionException {
        EObject current = null;
        int ruleNegation_StartIndex = input.index();
        EObject lv_term_1 = null;


        setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 10) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:314:6: ( ( '!' (lv_term_1= ruleTerm ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:315:1: ( '!' (lv_term_1= ruleTerm ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:315:1: ( '!' (lv_term_1= ruleTerm ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:315:2: '!' (lv_term_1= ruleTerm )
            {
            match(input,13,FOLLOW_13_in_ruleNegation686); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getNegationAccess().getExclamationMarkKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:319:1: (lv_term_1= ruleTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:322:6: lv_term_1= ruleTerm
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getNegationAccess().getTermTermParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleNegation720);
            lv_term_1=ruleTerm();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getNegationRule().getType().getClassifier());
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
            if ( backtracking>0 ) { memoize(input, 10, ruleNegation_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleNegation


    // $ANTLR start entryRuleAtom
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:347:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;
        int entryRuleAtom_StartIndex = input.index();
        EObject iv_ruleAtom = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:347:46: (iv_ruleAtom= ruleAtom EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:348:2: iv_ruleAtom= ruleAtom EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom757);
            iv_ruleAtom=ruleAtom();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAtom; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom767); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 11, entryRuleAtom_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleAtom


    // $ANTLR start ruleAtom
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:355:1: ruleAtom returns [EObject current=null] : (this_Value_0= ruleValue | this_Variable_1= ruleVariable ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;
        int ruleAtom_StartIndex = input.index();
        EObject this_Value_0 = null;

        EObject this_Variable_1 = null;

setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 12) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:360:6: ( (this_Value_0= ruleValue | this_Variable_1= ruleVariable ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:361:1: (this_Value_0= ruleValue | this_Variable_1= ruleVariable )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:361:1: (this_Value_0= ruleValue | this_Variable_1= ruleVariable )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_INT)||(LA3_0>=18 && LA3_0<=21)) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("361:1: (this_Value_0= ruleValue | this_Variable_1= ruleVariable )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:362:5: this_Value_0= ruleValue
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomAccess().getValueParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleValue_in_ruleAtom814);
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
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:372:5: this_Variable_1= ruleVariable
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomAccess().getVariableParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleVariable_in_ruleAtom841);
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
            if ( backtracking>0 ) { memoize(input, 12, ruleAtom_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleVariable
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:387:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;
        int entryRuleVariable_StartIndex = input.index();
        EObject iv_ruleVariable = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:387:50: (iv_ruleVariable= ruleVariable EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:388:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable873);
            iv_ruleVariable=ruleVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable883); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 13, entryRuleVariable_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleVariable


    // $ANTLR start ruleVariable
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:395:1: ruleVariable returns [EObject current=null] : ( '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;
        int ruleVariable_StartIndex = input.index();
        Token lv_name_1=null;
        EObject lv_accessor_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 14) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:400:6: ( ( '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:401:1: ( '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:401:1: ( '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:401:2: '$' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )?
            {
            match(input,14,FOLLOW_14_in_ruleVariable917); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getVariableAccess().getDollarSignKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:405:1: (lv_name_1= RULE_ID )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:407:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariable939); if (failed) return current;
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

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:425:2: (lv_accessor_2= ruleAccessor )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15||LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:428:6: lv_accessor_2= ruleAccessor
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getAccessorAccessorParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessor_in_ruleVariable981);
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
            if ( backtracking>0 ) { memoize(input, 14, ruleVariable_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleVariable


    // $ANTLR start entryRuleAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:453:1: entryRuleAccessor returns [EObject current=null] : iv_ruleAccessor= ruleAccessor EOF ;
    public final EObject entryRuleAccessor() throws RecognitionException {
        EObject current = null;
        int entryRuleAccessor_StartIndex = input.index();
        EObject iv_ruleAccessor = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:453:50: (iv_ruleAccessor= ruleAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:454:2: iv_ruleAccessor= ruleAccessor EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAccessorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAccessor_in_entryRuleAccessor1019);
            iv_ruleAccessor=ruleAccessor();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAccessor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessor1029); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 15, entryRuleAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleAccessor


    // $ANTLR start ruleAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:461:1: ruleAccessor returns [EObject current=null] : (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor ) ;
    public final EObject ruleAccessor() throws RecognitionException {
        EObject current = null;
        int ruleAccessor_StartIndex = input.index();
        EObject this_ArrayAccessor_0 = null;

        EObject this_FieldAccessor_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:466:6: ( (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:467:1: (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:467:1: (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==17) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("467:1: (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:468:5: this_ArrayAccessor_0= ruleArrayAccessor
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAccessorAccess().getArrayAccessorParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleArrayAccessor_in_ruleAccessor1076);
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
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:478:5: this_FieldAccessor_1= ruleFieldAccessor
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAccessorAccess().getFieldAccessorParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFieldAccessor_in_ruleAccessor1103);
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
            if ( backtracking>0 ) { memoize(input, 16, ruleAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleAccessor


    // $ANTLR start entryRuleArrayAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:493:1: entryRuleArrayAccessor returns [EObject current=null] : iv_ruleArrayAccessor= ruleArrayAccessor EOF ;
    public final EObject entryRuleArrayAccessor() throws RecognitionException {
        EObject current = null;
        int entryRuleArrayAccessor_StartIndex = input.index();
        EObject iv_ruleArrayAccessor = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:493:55: (iv_ruleArrayAccessor= ruleArrayAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:494:2: iv_ruleArrayAccessor= ruleArrayAccessor EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getArrayAccessorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleArrayAccessor_in_entryRuleArrayAccessor1135);
            iv_ruleArrayAccessor=ruleArrayAccessor();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleArrayAccessor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayAccessor1145); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 17, entryRuleArrayAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleArrayAccessor


    // $ANTLR start ruleArrayAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:501:1: ruleArrayAccessor returns [EObject current=null] : ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )? ) ;
    public final EObject ruleArrayAccessor() throws RecognitionException {
        EObject current = null;
        int ruleArrayAccessor_StartIndex = input.index();
        EObject lv_index_1 = null;

        EObject lv_accessor_3 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:506:6: ( ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:507:1: ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:507:1: ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:507:2: '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )?
            {
            match(input,15,FOLLOW_15_in_ruleArrayAccessor1179); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getArrayAccessorAccess().getLeftSquareBracketKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:511:1: (lv_index_1= ruleTerm )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:514:6: lv_index_1= ruleTerm
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getArrayAccessorAccess().getIndexTermParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleArrayAccessor1213);
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

            match(input,16,FOLLOW_16_in_ruleArrayAccessor1226); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getArrayAccessorAccess().getRightSquareBracketKeyword_2(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:536:1: (lv_accessor_3= ruleAccessor )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15||LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:539:6: lv_accessor_3= ruleAccessor
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getArrayAccessorAccess().getAccessorAccessorParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessor_in_ruleArrayAccessor1260);
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
            if ( backtracking>0 ) { memoize(input, 18, ruleArrayAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleArrayAccessor


    // $ANTLR start entryRuleFieldAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:564:1: entryRuleFieldAccessor returns [EObject current=null] : iv_ruleFieldAccessor= ruleFieldAccessor EOF ;
    public final EObject entryRuleFieldAccessor() throws RecognitionException {
        EObject current = null;
        int entryRuleFieldAccessor_StartIndex = input.index();
        EObject iv_ruleFieldAccessor = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:564:55: (iv_ruleFieldAccessor= ruleFieldAccessor EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:565:2: iv_ruleFieldAccessor= ruleFieldAccessor EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFieldAccessorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFieldAccessor_in_entryRuleFieldAccessor1298);
            iv_ruleFieldAccessor=ruleFieldAccessor();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFieldAccessor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFieldAccessor1308); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 19, entryRuleFieldAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleFieldAccessor


    // $ANTLR start ruleFieldAccessor
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:572:1: ruleFieldAccessor returns [EObject current=null] : ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? ) ;
    public final EObject ruleFieldAccessor() throws RecognitionException {
        EObject current = null;
        int ruleFieldAccessor_StartIndex = input.index();
        Token lv_name_1=null;
        EObject lv_accessor_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:577:6: ( ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:578:1: ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:578:1: ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:578:2: '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )?
            {
            match(input,17,FOLLOW_17_in_ruleFieldAccessor1342); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFieldAccessorAccess().getFullStopKeyword_0(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:582:1: (lv_name_1= RULE_ID )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:584:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFieldAccessor1364); if (failed) return current;
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

            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:602:2: (lv_accessor_2= ruleAccessor )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15||LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:605:6: lv_accessor_2= ruleAccessor
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFieldAccessorAccess().getAccessorAccessorParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAccessor_in_ruleFieldAccessor1406);
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
            if ( backtracking>0 ) { memoize(input, 20, ruleFieldAccessor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleFieldAccessor


    // $ANTLR start entryRuleValue
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:630:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;
        int entryRuleValue_StartIndex = input.index();
        EObject iv_ruleValue = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:630:47: (iv_ruleValue= ruleValue EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:631:2: iv_ruleValue= ruleValue EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getValueRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1444);
            iv_ruleValue=ruleValue();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1454); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 21, entryRuleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleValue


    // $ANTLR start ruleValue
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:638:1: ruleValue returns [EObject current=null] : (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;
        int ruleValue_StartIndex = input.index();
        EObject this_StringConst_0 = null;

        EObject this_BooleanConst_1 = null;

        EObject this_NumericConst_2 = null;

        EObject this_NullConst_3 = null;


        setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:643:6: ( (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:644:1: (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:644:1: (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt8=1;
                }
                break;
            case 18:
            case 19:
                {
                alt8=2;
                }
                break;
            case RULE_INT:
            case 21:
                {
                alt8=3;
                }
                break;
            case 20:
                {
                alt8=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("644:1: (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst )", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:645:5: this_StringConst_0= ruleStringConst
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getValueAccess().getStringConstParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringConst_in_ruleValue1501);
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
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:655:5: this_BooleanConst_1= ruleBooleanConst
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getValueAccess().getBooleanConstParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanConst_in_ruleValue1528);
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
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:665:5: this_NumericConst_2= ruleNumericConst
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getValueAccess().getNumericConstParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumericConst_in_ruleValue1555);
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
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:675:5: this_NullConst_3= ruleNullConst
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getValueAccess().getNullConstParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNullConst_in_ruleValue1582);
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
            if ( backtracking>0 ) { memoize(input, 22, ruleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleValue


    // $ANTLR start entryRuleStringConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:690:1: entryRuleStringConst returns [EObject current=null] : iv_ruleStringConst= ruleStringConst EOF ;
    public final EObject entryRuleStringConst() throws RecognitionException {
        EObject current = null;
        int entryRuleStringConst_StartIndex = input.index();
        EObject iv_ruleStringConst = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:690:53: (iv_ruleStringConst= ruleStringConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:691:2: iv_ruleStringConst= ruleStringConst EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringConstRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringConst_in_entryRuleStringConst1614);
            iv_ruleStringConst=ruleStringConst();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStringConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringConst1624); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 23, entryRuleStringConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleStringConst


    // $ANTLR start ruleStringConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:698:1: ruleStringConst returns [EObject current=null] : (lv_const_0= RULE_STRING ) ;
    public final EObject ruleStringConst() throws RecognitionException {
        EObject current = null;
        int ruleStringConst_StartIndex = input.index();
        Token lv_const_0=null;

        setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:703:6: ( (lv_const_0= RULE_STRING ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:704:1: (lv_const_0= RULE_STRING )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:704:1: (lv_const_0= RULE_STRING )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:706:6: lv_const_0= RULE_STRING
            {
            lv_const_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringConst1670); if (failed) return current;
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
            if ( backtracking>0 ) { memoize(input, 24, ruleStringConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleStringConst


    // $ANTLR start entryRuleNumericConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:731:1: entryRuleNumericConst returns [EObject current=null] : iv_ruleNumericConst= ruleNumericConst EOF ;
    public final EObject entryRuleNumericConst() throws RecognitionException {
        EObject current = null;
        int entryRuleNumericConst_StartIndex = input.index();
        EObject iv_ruleNumericConst = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:731:54: (iv_ruleNumericConst= ruleNumericConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:732:2: iv_ruleNumericConst= ruleNumericConst EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNumericConstRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNumericConst_in_entryRuleNumericConst1710);
            iv_ruleNumericConst=ruleNumericConst();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNumericConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericConst1720); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 25, entryRuleNumericConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleNumericConst


    // $ANTLR start ruleNumericConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:739:1: ruleNumericConst returns [EObject current=null] : (lv_const_0= ruleNUMERIC ) ;
    public final EObject ruleNumericConst() throws RecognitionException {
        EObject current = null;
        int ruleNumericConst_StartIndex = input.index();
        AntlrDatatypeRuleToken lv_const_0 = null;


        setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 26) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:744:6: ( (lv_const_0= ruleNUMERIC ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:745:1: (lv_const_0= ruleNUMERIC )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:745:1: (lv_const_0= ruleNUMERIC )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:748:6: lv_const_0= ruleNUMERIC
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getNumericConstAccess().getConstNUMERICParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleNUMERIC_in_ruleNumericConst1778);
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
            if ( backtracking>0 ) { memoize(input, 26, ruleNumericConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleNumericConst


    // $ANTLR start entryRuleBooleanConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:773:1: entryRuleBooleanConst returns [EObject current=null] : iv_ruleBooleanConst= ruleBooleanConst EOF ;
    public final EObject entryRuleBooleanConst() throws RecognitionException {
        EObject current = null;
        int entryRuleBooleanConst_StartIndex = input.index();
        EObject iv_ruleBooleanConst = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:773:54: (iv_ruleBooleanConst= ruleBooleanConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:774:2: iv_ruleBooleanConst= ruleBooleanConst EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanConstRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBooleanConst_in_entryRuleBooleanConst1814);
            iv_ruleBooleanConst=ruleBooleanConst();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanConst1824); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 27, entryRuleBooleanConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanConst


    // $ANTLR start ruleBooleanConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:781:1: ruleBooleanConst returns [EObject current=null] : (lv_const_0= ( 'true' | 'false' ) ) ;
    public final EObject ruleBooleanConst() throws RecognitionException {
        EObject current = null;
        int ruleBooleanConst_StartIndex = input.index();
       

        setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 28) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:786:6: ( (lv_const_0= ( 'true' | 'false' ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:787:1: (lv_const_0= ( 'true' | 'false' ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:787:1: (lv_const_0= ( 'true' | 'false' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:789:6: lv_const_0= ( 'true' | 'false' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:789:17: ( 'true' | 'false' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            else if ( (LA9_0==19) ) {
                alt9=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("789:17: ( 'true' | 'false' )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:789:18: 'true'
                    {
                    match(input,18,FOLLOW_18_in_ruleBooleanConst1870); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanConstAccess().getConstTrueKeyword_0_0(), "const"); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:795:6: 'false'
                    {
                    match(input,19,FOLLOW_19_in_ruleBooleanConst1886); if (failed) return current;
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
            if ( backtracking>0 ) { memoize(input, 28, ruleBooleanConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleBooleanConst


    // $ANTLR start entryRuleNullConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:822:1: entryRuleNullConst returns [EObject current=null] : iv_ruleNullConst= ruleNullConst EOF ;
    public final EObject entryRuleNullConst() throws RecognitionException {
        EObject current = null;
        int entryRuleNullConst_StartIndex = input.index();
        EObject iv_ruleNullConst = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:822:51: (iv_ruleNullConst= ruleNullConst EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:823:2: iv_ruleNullConst= ruleNullConst EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNullConstRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNullConst_in_entryRuleNullConst1933);
            iv_ruleNullConst=ruleNullConst();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNullConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullConst1943); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 29, entryRuleNullConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleNullConst


    // $ANTLR start ruleNullConst
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:830:1: ruleNullConst returns [EObject current=null] : (lv_const_0= 'null' ) ;
    public final EObject ruleNullConst() throws RecognitionException {
        EObject current = null;
        int ruleNullConst_StartIndex = input.index();
        

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:835:6: ( (lv_const_0= 'null' ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:836:1: (lv_const_0= 'null' )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:836:1: (lv_const_0= 'null' )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:838:6: lv_const_0= 'null'
            {
            input.LT(1);
            match(input,20,FOLLOW_20_in_ruleNullConst1988); if (failed) return current;
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
            if ( backtracking>0 ) { memoize(input, 30, ruleNullConst_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleNullConst


    // $ANTLR start entryRuleNUMERIC
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:864:1: entryRuleNUMERIC returns [String current=null] : iv_ruleNUMERIC= ruleNUMERIC EOF ;
    public final String entryRuleNUMERIC() throws RecognitionException {
        String current = null;
        int entryRuleNUMERIC_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleNUMERIC = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:864:48: (iv_ruleNUMERIC= ruleNUMERIC EOF )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:865:2: iv_ruleNUMERIC= ruleNUMERIC EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNUMERICRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2034);
            iv_ruleNUMERIC=ruleNUMERIC();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNUMERIC.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUMERIC2045); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 31, entryRuleNUMERIC_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleNUMERIC


    // $ANTLR start ruleNUMERIC
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:872:1: ruleNUMERIC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMERIC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleNUMERIC_StartIndex = input.index();
        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:878:6: ( ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:879:1: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:879:1: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:879:2: (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )?
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:879:2: (kw= '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:880:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_ruleNUMERIC2084); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getNUMERICAccess().getHyphenMinusKeyword_0(), null); 
                          
                    }

                    }
                    break;

            }

            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2101); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_INT_1);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_1(), null); 
                  
            }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:892:1: (kw= '.' this_INT_3= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:893:2: kw= '.' this_INT_3= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleNUMERIC2120); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getNUMERICAccess().getFullStopKeyword_2_0(), null); 
                          
                    }
                    this_INT_3=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2135); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_INT_3);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_2_1(), null); 
                          
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
            if ( backtracking>0 ) { memoize(input, 32, ruleNUMERIC_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleNUMERIC


    // $ANTLR start ruleOperator
    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:913:1: ruleOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;
        int ruleOperator_StartIndex = input.index();
         setCurrentLookahead(); resetLookahead(); 
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:917:6: ( ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) ) )
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:918:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) )
            {
            // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:918:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) )
            int alt12=14;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt12=1;
                }
                break;
            case 23:
                {
                alt12=2;
                }
                break;
            case 24:
                {
                alt12=3;
                }
                break;
            case 25:
                {
                alt12=4;
                }
                break;
            case 26:
                {
                alt12=5;
                }
                break;
            case 27:
                {
                alt12=6;
                }
                break;
            case 28:
                {
                alt12=7;
                }
                break;
            case 21:
                {
                alt12=8;
                }
                break;
            case 29:
                {
                alt12=9;
                }
                break;
            case 30:
                {
                alt12=10;
                }
                break;
            case 31:
                {
                alt12=11;
                }
                break;
            case 32:
                {
                alt12=12;
                }
                break;
            case 33:
                {
                alt12=13;
                }
                break;
            case 34:
                {
                alt12=14;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("918:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '&&' ) | ( '||' ) | ( '++' ) )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:918:2: ( '<' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:918:2: ( '<' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:918:4: '<'
                    {
                    match(input,22,FOLLOW_22_in_ruleOperator2194); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getLTEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:924:6: ( '<=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:924:6: ( '<=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:924:8: '<='
                    {
                    match(input,23,FOLLOW_23_in_ruleOperator2209); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getLEEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:930:6: ( '==' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:930:6: ( '==' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:930:8: '=='
                    {
                    match(input,24,FOLLOW_24_in_ruleOperator2224); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getEQEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:936:6: ( '!=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:936:6: ( '!=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:936:8: '!='
                    {
                    match(input,25,FOLLOW_25_in_ruleOperator2239); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getNEQEnumLiteralDeclaration_3(), null); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:942:6: ( '>' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:942:6: ( '>' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:942:8: '>'
                    {
                    match(input,26,FOLLOW_26_in_ruleOperator2254); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getGTEnumLiteralDeclaration_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:948:6: ( '>=' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:948:6: ( '>=' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:948:8: '>='
                    {
                    match(input,27,FOLLOW_27_in_ruleOperator2269); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getGEEnumLiteralDeclaration_5(), null); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:954:6: ( '+' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:954:6: ( '+' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:954:8: '+'
                    {
                    match(input,28,FOLLOW_28_in_ruleOperator2284); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getADDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getADDEnumLiteralDeclaration_6(), null); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:960:6: ( '-' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:960:6: ( '-' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:960:8: '-'
                    {
                    match(input,21,FOLLOW_21_in_ruleOperator2299); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getSUBEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getSUBEnumLiteralDeclaration_7(), null); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:966:6: ( '*' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:966:6: ( '*' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:966:8: '*'
                    {
                    match(input,29,FOLLOW_29_in_ruleOperator2314); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getMULTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getMULTEnumLiteralDeclaration_8(), null); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:972:6: ( '/' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:972:6: ( '/' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:972:8: '/'
                    {
                    match(input,30,FOLLOW_30_in_ruleOperator2329); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getDIVEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getDIVEnumLiteralDeclaration_9(), null); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:978:6: ( '%' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:978:6: ( '%' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:978:8: '%'
                    {
                    match(input,31,FOLLOW_31_in_ruleOperator2344); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getMODEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getMODEnumLiteralDeclaration_10(), null); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:984:6: ( '&&' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:984:6: ( '&&' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:984:8: '&&'
                    {
                    match(input,32,FOLLOW_32_in_ruleOperator2359); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getANDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getANDEnumLiteralDeclaration_11(), null); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:990:6: ( '||' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:990:6: ( '||' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:990:8: '||'
                    {
                    match(input,33,FOLLOW_33_in_ruleOperator2374); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getOperatorAccess().getOREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getOperatorAccess().getOREnumLiteralDeclaration_12(), null); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:996:6: ( '++' )
                    {
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:996:6: ( '++' )
                    // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:996:8: '++'
                    {
                    match(input,34,FOLLOW_34_in_ruleOperator2389); if (failed) return current;
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
            if ( backtracking>0 ) { memoize(input, 33, ruleOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleOperator

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:113:6: ( ruleTail )
        // ../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/parser/antlr/internal/InternalVxl.g:113:6: ruleTail
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getTermAccess().getTailTailParserRuleCall_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleTail_in_synpred1193);
        ruleTail();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm86 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHead_in_ruleTerm155 = new BitSet(new long[]{0x00000007FFE00002L});
    public static final BitSet FOLLOW_ruleTail_in_ruleTerm193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHead_in_entryRuleHead231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHead241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracketTerm_in_ruleHead288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleHead315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleHead342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTail_in_entryRuleTail374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTail384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_ruleTail443 = new BitSet(new long[]{0x00000000003C6860L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleTail481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracketTerm_in_entryRuleBracketTerm518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBracketTerm528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleBracketTerm562 = new BitSet(new long[]{0x00000000003C6860L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleBracketTerm596 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleBracketTerm609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation642 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleNegation686 = new BitSet(new long[]{0x00000000003C6860L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleNegation720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleAtom814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleAtom841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable873 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVariable917 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariable939 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_ruleAccessor_in_ruleVariable981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessor_in_entryRuleAccessor1019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessor1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayAccessor_in_ruleAccessor1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldAccessor_in_ruleAccessor1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayAccessor_in_entryRuleArrayAccessor1135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayAccessor1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleArrayAccessor1179 = new BitSet(new long[]{0x00000000003C6860L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleArrayAccessor1213 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleArrayAccessor1226 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_ruleAccessor_in_ruleArrayAccessor1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldAccessor_in_entryRuleFieldAccessor1298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFieldAccessor1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleFieldAccessor1342 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFieldAccessor1364 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_ruleAccessor_in_ruleFieldAccessor1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConst_in_ruleValue1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanConst_in_ruleValue1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericConst_in_ruleValue1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullConst_in_ruleValue1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConst_in_entryRuleStringConst1614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringConst1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringConst1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericConst_in_entryRuleNumericConst1710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericConst1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_ruleNumericConst1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanConst_in_entryRuleBooleanConst1814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanConst1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleBooleanConst1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleBooleanConst1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullConst_in_entryRuleNullConst1933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullConst1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleNullConst1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUMERIC2045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleNUMERIC2084 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2101 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleNUMERIC2120 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOperator2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOperator2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOperator2224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOperator2239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOperator2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOperator2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOperator2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOperator2299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOperator2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOperator2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOperator2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOperator2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOperator2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOperator2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTail_in_synpred1193 = new BitSet(new long[]{0x0000000000000002L});

}