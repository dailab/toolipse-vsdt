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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVxlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'not'", "'-'", "'#'", "'['", "']'", "'.'", "','", "'{'", "'}'", "':'", "'new'", "'true'", "'false'", "'null'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", "'+'", "'*'", "'/'", "'%'", "'and'", "'or'", "'++'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalVxlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVxlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVxlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalVxl.g"; }



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



    // $ANTLR start "entryRuleVxlTerm"
    // InternalVxl.g:68:1: entryRuleVxlTerm returns [EObject current=null] : iv_ruleVxlTerm= ruleVxlTerm EOF ;
    public final EObject entryRuleVxlTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlTerm = null;


        try {
            // InternalVxl.g:69:2: (iv_ruleVxlTerm= ruleVxlTerm EOF )
            // InternalVxl.g:70:2: iv_ruleVxlTerm= ruleVxlTerm EOF
            {
             newCompositeNode(grammarAccess.getVxlTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlTerm=ruleVxlTerm();

            state._fsp--;

             current =iv_ruleVxlTerm; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlTerm"


    // $ANTLR start "ruleVxlTerm"
    // InternalVxl.g:77:1: ruleVxlTerm returns [EObject current=null] : ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? ) ;
    public final EObject ruleVxlTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_head_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_tail_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:80:28: ( ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? ) )
            // InternalVxl.g:81:1: ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? )
            {
            // InternalVxl.g:81:1: ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? )
            // InternalVxl.g:81:2: ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )?
            {
            // InternalVxl.g:81:2: ( (lv_head_0_0= ruleVxlElement ) )
            // InternalVxl.g:82:1: (lv_head_0_0= ruleVxlElement )
            {
            // InternalVxl.g:82:1: (lv_head_0_0= ruleVxlElement )
            // InternalVxl.g:83:3: lv_head_0_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlTermAccess().getHeadVxlElementParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_3);
            lv_head_0_0=ruleVxlElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlTermRule());
            	        }
                   		set(
                   			current, 
                   			"head",
                    		lv_head_0_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalVxl.g:99:2: ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14||(LA1_0>=27 && LA1_0<=39)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalVxl.g:99:3: ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) )
                    {
                    // InternalVxl.g:99:3: ( (lv_operator_1_0= ruleVxlOperator ) )
                    // InternalVxl.g:100:1: (lv_operator_1_0= ruleVxlOperator )
                    {
                    // InternalVxl.g:100:1: (lv_operator_1_0= ruleVxlOperator )
                    // InternalVxl.g:101:3: lv_operator_1_0= ruleVxlOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlTermAccess().getOperatorVxlOperatorEnumRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_operator_1_0=ruleVxlOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlTermRule());
                    	        }
                           		set(
                           			current, 
                           			"operator",
                            		lv_operator_1_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalVxl.g:117:2: ( (lv_tail_2_0= ruleVxlTerm ) )
                    // InternalVxl.g:118:1: (lv_tail_2_0= ruleVxlTerm )
                    {
                    // InternalVxl.g:118:1: (lv_tail_2_0= ruleVxlTerm )
                    // InternalVxl.g:119:3: lv_tail_2_0= ruleVxlTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlTermAccess().getTailVxlTermParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_tail_2_0=ruleVxlTerm();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlTermRule());
                    	        }
                           		set(
                           			current, 
                           			"tail",
                            		lv_tail_2_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlTerm");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlTerm"


    // $ANTLR start "entryRuleVxlElement"
    // InternalVxl.g:143:1: entryRuleVxlElement returns [EObject current=null] : iv_ruleVxlElement= ruleVxlElement EOF ;
    public final EObject entryRuleVxlElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlElement = null;


        try {
            // InternalVxl.g:144:2: (iv_ruleVxlElement= ruleVxlElement EOF )
            // InternalVxl.g:145:2: iv_ruleVxlElement= ruleVxlElement EOF
            {
             newCompositeNode(grammarAccess.getVxlElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlElement=ruleVxlElement();

            state._fsp--;

             current =iv_ruleVxlElement; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlElement"


    // $ANTLR start "ruleVxlElement"
    // InternalVxl.g:152:1: ruleVxlElement returns [EObject current=null] : (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlMap_6= ruleVxlMap | this_VxlCardinality_7= ruleVxlCardinality | this_VxlFunction_8= ruleVxlFunction | this_VxlConstructor_9= ruleVxlConstructor ) ;
    public final EObject ruleVxlElement() throws RecognitionException {
        EObject current = null;

        EObject this_VxlBracketTerm_0 = null;

        EObject this_VxlNegation_1 = null;

        EObject this_VxlMinus_2 = null;

        EObject this_VxlValue_3 = null;

        EObject this_VxlVariable_4 = null;

        EObject this_VxlList_5 = null;

        EObject this_VxlMap_6 = null;

        EObject this_VxlCardinality_7 = null;

        EObject this_VxlFunction_8 = null;

        EObject this_VxlConstructor_9 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:155:28: ( (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlMap_6= ruleVxlMap | this_VxlCardinality_7= ruleVxlCardinality | this_VxlFunction_8= ruleVxlFunction | this_VxlConstructor_9= ruleVxlConstructor ) )
            // InternalVxl.g:156:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlMap_6= ruleVxlMap | this_VxlCardinality_7= ruleVxlCardinality | this_VxlFunction_8= ruleVxlFunction | this_VxlConstructor_9= ruleVxlConstructor )
            {
            // InternalVxl.g:156:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlMap_6= ruleVxlMap | this_VxlCardinality_7= ruleVxlCardinality | this_VxlFunction_8= ruleVxlFunction | this_VxlConstructor_9= ruleVxlConstructor )
            int alt2=10;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalVxl.g:157:5: this_VxlBracketTerm_0= ruleVxlBracketTerm
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlBracketTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlBracketTerm_0=ruleVxlBracketTerm();

                    state._fsp--;

                     
                            current = this_VxlBracketTerm_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalVxl.g:167:5: this_VxlNegation_1= ruleVxlNegation
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlNegationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlNegation_1=ruleVxlNegation();

                    state._fsp--;

                     
                            current = this_VxlNegation_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalVxl.g:177:5: this_VxlMinus_2= ruleVxlMinus
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlMinusParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlMinus_2=ruleVxlMinus();

                    state._fsp--;

                     
                            current = this_VxlMinus_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalVxl.g:187:5: this_VxlValue_3= ruleVxlValue
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlValue_3=ruleVxlValue();

                    state._fsp--;

                     
                            current = this_VxlValue_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalVxl.g:197:5: this_VxlVariable_4= ruleVxlVariable
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlVariableParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlVariable_4=ruleVxlVariable();

                    state._fsp--;

                     
                            current = this_VxlVariable_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalVxl.g:207:5: this_VxlList_5= ruleVxlList
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlListParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlList_5=ruleVxlList();

                    state._fsp--;

                     
                            current = this_VxlList_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalVxl.g:217:5: this_VxlMap_6= ruleVxlMap
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlMapParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlMap_6=ruleVxlMap();

                    state._fsp--;

                     
                            current = this_VxlMap_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalVxl.g:227:5: this_VxlCardinality_7= ruleVxlCardinality
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlCardinalityParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlCardinality_7=ruleVxlCardinality();

                    state._fsp--;

                     
                            current = this_VxlCardinality_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // InternalVxl.g:237:5: this_VxlFunction_8= ruleVxlFunction
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlFunctionParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlFunction_8=ruleVxlFunction();

                    state._fsp--;

                     
                            current = this_VxlFunction_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // InternalVxl.g:247:5: this_VxlConstructor_9= ruleVxlConstructor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlConstructorParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlConstructor_9=ruleVxlConstructor();

                    state._fsp--;

                     
                            current = this_VxlConstructor_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlElement"


    // $ANTLR start "entryRuleVxlBracketTerm"
    // InternalVxl.g:263:1: entryRuleVxlBracketTerm returns [EObject current=null] : iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF ;
    public final EObject entryRuleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBracketTerm = null;


        try {
            // InternalVxl.g:264:2: (iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF )
            // InternalVxl.g:265:2: iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF
            {
             newCompositeNode(grammarAccess.getVxlBracketTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlBracketTerm=ruleVxlBracketTerm();

            state._fsp--;

             current =iv_ruleVxlBracketTerm; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlBracketTerm"


    // $ANTLR start "ruleVxlBracketTerm"
    // InternalVxl.g:272:1: ruleVxlBracketTerm returns [EObject current=null] : (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' ) ;
    public final EObject ruleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_term_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:275:28: ( (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' ) )
            // InternalVxl.g:276:1: (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' )
            {
            // InternalVxl.g:276:1: (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' )
            // InternalVxl.g:276:3: otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlBracketTermAccess().getLeftParenthesisKeyword_0());
                
            // InternalVxl.g:280:1: ( (lv_term_1_0= ruleVxlTerm ) )
            // InternalVxl.g:281:1: (lv_term_1_0= ruleVxlTerm )
            {
            // InternalVxl.g:281:1: (lv_term_1_0= ruleVxlTerm )
            // InternalVxl.g:282:3: lv_term_1_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlBracketTermAccess().getTermVxlTermParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_5);
            lv_term_1_0=ruleVxlTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlBracketTermRule());
            	        }
                   		set(
                   			current, 
                   			"term",
                    		lv_term_1_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlTerm");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getVxlBracketTermAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlBracketTerm"


    // $ANTLR start "entryRuleVxlNegation"
    // InternalVxl.g:310:1: entryRuleVxlNegation returns [EObject current=null] : iv_ruleVxlNegation= ruleVxlNegation EOF ;
    public final EObject entryRuleVxlNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNegation = null;


        try {
            // InternalVxl.g:311:2: (iv_ruleVxlNegation= ruleVxlNegation EOF )
            // InternalVxl.g:312:2: iv_ruleVxlNegation= ruleVxlNegation EOF
            {
             newCompositeNode(grammarAccess.getVxlNegationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlNegation=ruleVxlNegation();

            state._fsp--;

             current =iv_ruleVxlNegation; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlNegation"


    // $ANTLR start "ruleVxlNegation"
    // InternalVxl.g:319:1: ruleVxlNegation returns [EObject current=null] : (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlNegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_element_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:322:28: ( (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // InternalVxl.g:323:1: (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // InternalVxl.g:323:1: (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) )
            // InternalVxl.g:323:3: otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlNegationAccess().getNotKeyword_0());
                
            // InternalVxl.g:327:1: ( (lv_element_1_0= ruleVxlElement ) )
            // InternalVxl.g:328:1: (lv_element_1_0= ruleVxlElement )
            {
            // InternalVxl.g:328:1: (lv_element_1_0= ruleVxlElement )
            // InternalVxl.g:329:3: lv_element_1_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlNegationAccess().getElementVxlElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_element_1_0=ruleVxlElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlNegationRule());
            	        }
                   		set(
                   			current, 
                   			"element",
                    		lv_element_1_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlNegation"


    // $ANTLR start "entryRuleVxlMinus"
    // InternalVxl.g:353:1: entryRuleVxlMinus returns [EObject current=null] : iv_ruleVxlMinus= ruleVxlMinus EOF ;
    public final EObject entryRuleVxlMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMinus = null;


        try {
            // InternalVxl.g:354:2: (iv_ruleVxlMinus= ruleVxlMinus EOF )
            // InternalVxl.g:355:2: iv_ruleVxlMinus= ruleVxlMinus EOF
            {
             newCompositeNode(grammarAccess.getVxlMinusRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlMinus=ruleVxlMinus();

            state._fsp--;

             current =iv_ruleVxlMinus; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlMinus"


    // $ANTLR start "ruleVxlMinus"
    // InternalVxl.g:362:1: ruleVxlMinus returns [EObject current=null] : (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_element_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:365:28: ( (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // InternalVxl.g:366:1: (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // InternalVxl.g:366:1: (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) )
            // InternalVxl.g:366:3: otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlMinusAccess().getHyphenMinusKeyword_0());
                
            // InternalVxl.g:370:1: ( (lv_element_1_0= ruleVxlElement ) )
            // InternalVxl.g:371:1: (lv_element_1_0= ruleVxlElement )
            {
            // InternalVxl.g:371:1: (lv_element_1_0= ruleVxlElement )
            // InternalVxl.g:372:3: lv_element_1_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlMinusAccess().getElementVxlElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_element_1_0=ruleVxlElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlMinusRule());
            	        }
                   		set(
                   			current, 
                   			"element",
                    		lv_element_1_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlMinus"


    // $ANTLR start "entryRuleVxlCardinality"
    // InternalVxl.g:396:1: entryRuleVxlCardinality returns [EObject current=null] : iv_ruleVxlCardinality= ruleVxlCardinality EOF ;
    public final EObject entryRuleVxlCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlCardinality = null;


        try {
            // InternalVxl.g:397:2: (iv_ruleVxlCardinality= ruleVxlCardinality EOF )
            // InternalVxl.g:398:2: iv_ruleVxlCardinality= ruleVxlCardinality EOF
            {
             newCompositeNode(grammarAccess.getVxlCardinalityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlCardinality=ruleVxlCardinality();

            state._fsp--;

             current =iv_ruleVxlCardinality; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlCardinality"


    // $ANTLR start "ruleVxlCardinality"
    // InternalVxl.g:405:1: ruleVxlCardinality returns [EObject current=null] : (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlCardinality() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_element_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:408:28: ( (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // InternalVxl.g:409:1: (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // InternalVxl.g:409:1: (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) )
            // InternalVxl.g:409:3: otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlCardinalityAccess().getNumberSignKeyword_0());
                
            // InternalVxl.g:413:1: ( (lv_element_1_0= ruleVxlElement ) )
            // InternalVxl.g:414:1: (lv_element_1_0= ruleVxlElement )
            {
            // InternalVxl.g:414:1: (lv_element_1_0= ruleVxlElement )
            // InternalVxl.g:415:3: lv_element_1_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlCardinalityAccess().getElementVxlElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_element_1_0=ruleVxlElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlCardinalityRule());
            	        }
                   		set(
                   			current, 
                   			"element",
                    		lv_element_1_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlCardinality"


    // $ANTLR start "entryRuleVxlVariable"
    // InternalVxl.g:439:1: entryRuleVxlVariable returns [EObject current=null] : iv_ruleVxlVariable= ruleVxlVariable EOF ;
    public final EObject entryRuleVxlVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlVariable = null;


        try {
            // InternalVxl.g:440:2: (iv_ruleVxlVariable= ruleVxlVariable EOF )
            // InternalVxl.g:441:2: iv_ruleVxlVariable= ruleVxlVariable EOF
            {
             newCompositeNode(grammarAccess.getVxlVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlVariable=ruleVxlVariable();

            state._fsp--;

             current =iv_ruleVxlVariable; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlVariable"


    // $ANTLR start "ruleVxlVariable"
    // InternalVxl.g:448:1: ruleVxlVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_accessor_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:451:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? ) )
            // InternalVxl.g:452:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? )
            {
            // InternalVxl.g:452:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? )
            // InternalVxl.g:452:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )?
            {
            // InternalVxl.g:452:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalVxl.g:453:1: (lv_name_0_0= RULE_ID )
            {
            // InternalVxl.g:453:1: (lv_name_0_0= RULE_ID )
            // InternalVxl.g:454:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            			newLeafNode(lv_name_0_0, grammarAccess.getVxlVariableAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVxlVariableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalVxl.g:470:2: ( (lv_accessor_1_0= ruleVxlAccessor ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16||LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalVxl.g:471:1: (lv_accessor_1_0= ruleVxlAccessor )
                    {
                    // InternalVxl.g:471:1: (lv_accessor_1_0= ruleVxlAccessor )
                    // InternalVxl.g:472:3: lv_accessor_1_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlVariableAccess().getAccessorVxlAccessorParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_accessor_1_0=ruleVxlAccessor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlVariableRule());
                    	        }
                           		set(
                           			current, 
                           			"accessor",
                            		lv_accessor_1_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlAccessor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlVariable"


    // $ANTLR start "entryRuleVxlAccessor"
    // InternalVxl.g:496:1: entryRuleVxlAccessor returns [EObject current=null] : iv_ruleVxlAccessor= ruleVxlAccessor EOF ;
    public final EObject entryRuleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlAccessor = null;


        try {
            // InternalVxl.g:497:2: (iv_ruleVxlAccessor= ruleVxlAccessor EOF )
            // InternalVxl.g:498:2: iv_ruleVxlAccessor= ruleVxlAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlAccessorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlAccessor=ruleVxlAccessor();

            state._fsp--;

             current =iv_ruleVxlAccessor; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlAccessor"


    // $ANTLR start "ruleVxlAccessor"
    // InternalVxl.g:505:1: ruleVxlAccessor returns [EObject current=null] : (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor | this_VxlMethodAccessor_2= ruleVxlMethodAccessor ) ;
    public final EObject ruleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject this_VxlArrayAccessor_0 = null;

        EObject this_VxlFieldAccessor_1 = null;

        EObject this_VxlMethodAccessor_2 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:508:28: ( (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor | this_VxlMethodAccessor_2= ruleVxlMethodAccessor ) )
            // InternalVxl.g:509:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor | this_VxlMethodAccessor_2= ruleVxlMethodAccessor )
            {
            // InternalVxl.g:509:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor | this_VxlMethodAccessor_2= ruleVxlMethodAccessor )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==RULE_ID) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==11) ) {
                        alt4=3;
                    }
                    else if ( (LA4_3==EOF||LA4_3==12||LA4_3==14||(LA4_3>=16 && LA4_3<=19)||(LA4_3>=21 && LA4_3<=22)||(LA4_3>=27 && LA4_3<=39)) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalVxl.g:510:5: this_VxlArrayAccessor_0= ruleVxlArrayAccessor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlArrayAccessorParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlArrayAccessor_0=ruleVxlArrayAccessor();

                    state._fsp--;

                     
                            current = this_VxlArrayAccessor_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalVxl.g:520:5: this_VxlFieldAccessor_1= ruleVxlFieldAccessor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlFieldAccessorParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlFieldAccessor_1=ruleVxlFieldAccessor();

                    state._fsp--;

                     
                            current = this_VxlFieldAccessor_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalVxl.g:530:5: this_VxlMethodAccessor_2= ruleVxlMethodAccessor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlMethodAccessorParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlMethodAccessor_2=ruleVxlMethodAccessor();

                    state._fsp--;

                     
                            current = this_VxlMethodAccessor_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlAccessor"


    // $ANTLR start "entryRuleVxlArrayAccessor"
    // InternalVxl.g:546:1: entryRuleVxlArrayAccessor returns [EObject current=null] : iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF ;
    public final EObject entryRuleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlArrayAccessor = null;


        try {
            // InternalVxl.g:547:2: (iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF )
            // InternalVxl.g:548:2: iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlArrayAccessorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlArrayAccessor=ruleVxlArrayAccessor();

            state._fsp--;

             current =iv_ruleVxlArrayAccessor; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlArrayAccessor"


    // $ANTLR start "ruleVxlArrayAccessor"
    // InternalVxl.g:555:1: ruleVxlArrayAccessor returns [EObject current=null] : (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_index_1_0 = null;

        EObject lv_accessor_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:558:28: ( (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? ) )
            // InternalVxl.g:559:1: (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? )
            {
            // InternalVxl.g:559:1: (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? )
            // InternalVxl.g:559:3: otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlArrayAccessorAccess().getLeftSquareBracketKeyword_0());
                
            // InternalVxl.g:563:1: ( (lv_index_1_0= ruleVxlTerm ) )
            // InternalVxl.g:564:1: (lv_index_1_0= ruleVxlTerm )
            {
            // InternalVxl.g:564:1: (lv_index_1_0= ruleVxlTerm )
            // InternalVxl.g:565:3: lv_index_1_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getIndexVxlTermParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_7);
            lv_index_1_0=ruleVxlTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlArrayAccessorRule());
            	        }
                   		set(
                   			current, 
                   			"index",
                    		lv_index_1_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlTerm");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getVxlArrayAccessorAccess().getRightSquareBracketKeyword_2());
                
            // InternalVxl.g:585:1: ( (lv_accessor_3_0= ruleVxlAccessor ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16||LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalVxl.g:586:1: (lv_accessor_3_0= ruleVxlAccessor )
                    {
                    // InternalVxl.g:586:1: (lv_accessor_3_0= ruleVxlAccessor )
                    // InternalVxl.g:587:3: lv_accessor_3_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getAccessorVxlAccessorParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_accessor_3_0=ruleVxlAccessor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlArrayAccessorRule());
                    	        }
                           		set(
                           			current, 
                           			"accessor",
                            		lv_accessor_3_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlAccessor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlArrayAccessor"


    // $ANTLR start "entryRuleVxlFieldAccessor"
    // InternalVxl.g:611:1: entryRuleVxlFieldAccessor returns [EObject current=null] : iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF ;
    public final EObject entryRuleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlFieldAccessor = null;


        try {
            // InternalVxl.g:612:2: (iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF )
            // InternalVxl.g:613:2: iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlFieldAccessorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlFieldAccessor=ruleVxlFieldAccessor();

            state._fsp--;

             current =iv_ruleVxlFieldAccessor; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlFieldAccessor"


    // $ANTLR start "ruleVxlFieldAccessor"
    // InternalVxl.g:620:1: ruleVxlFieldAccessor returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_accessor_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:623:28: ( (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) )
            // InternalVxl.g:624:1: (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            {
            // InternalVxl.g:624:1: (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            // InternalVxl.g:624:3: otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlFieldAccessorAccess().getFullStopKeyword_0());
                
            // InternalVxl.g:628:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalVxl.g:629:1: (lv_name_1_0= RULE_ID )
            {
            // InternalVxl.g:629:1: (lv_name_1_0= RULE_ID )
            // InternalVxl.g:630:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            			newLeafNode(lv_name_1_0, grammarAccess.getVxlFieldAccessorAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVxlFieldAccessorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalVxl.g:646:2: ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16||LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalVxl.g:647:1: (lv_accessor_2_0= ruleVxlAccessor )
                    {
                    // InternalVxl.g:647:1: (lv_accessor_2_0= ruleVxlAccessor )
                    // InternalVxl.g:648:3: lv_accessor_2_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlFieldAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_accessor_2_0=ruleVxlAccessor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlFieldAccessorRule());
                    	        }
                           		set(
                           			current, 
                           			"accessor",
                            		lv_accessor_2_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlAccessor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlFieldAccessor"


    // $ANTLR start "entryRuleVxlMethodAccessor"
    // InternalVxl.g:672:1: entryRuleVxlMethodAccessor returns [EObject current=null] : iv_ruleVxlMethodAccessor= ruleVxlMethodAccessor EOF ;
    public final EObject entryRuleVxlMethodAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMethodAccessor = null;


        try {
            // InternalVxl.g:673:2: (iv_ruleVxlMethodAccessor= ruleVxlMethodAccessor EOF )
            // InternalVxl.g:674:2: iv_ruleVxlMethodAccessor= ruleVxlMethodAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlMethodAccessorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlMethodAccessor=ruleVxlMethodAccessor();

            state._fsp--;

             current =iv_ruleVxlMethodAccessor; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlMethodAccessor"


    // $ANTLR start "ruleVxlMethodAccessor"
    // InternalVxl.g:681:1: ruleVxlMethodAccessor returns [EObject current=null] : (otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlMethodAccessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_function_1_0 = null;

        EObject lv_accessor_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:684:28: ( (otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) )
            // InternalVxl.g:685:1: (otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            {
            // InternalVxl.g:685:1: (otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            // InternalVxl.g:685:3: otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlMethodAccessorAccess().getFullStopKeyword_0());
                
            // InternalVxl.g:689:1: ( (lv_function_1_0= ruleVxlFunction ) )
            // InternalVxl.g:690:1: (lv_function_1_0= ruleVxlFunction )
            {
            // InternalVxl.g:690:1: (lv_function_1_0= ruleVxlFunction )
            // InternalVxl.g:691:3: lv_function_1_0= ruleVxlFunction
            {
             
            	        newCompositeNode(grammarAccess.getVxlMethodAccessorAccess().getFunctionVxlFunctionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_6);
            lv_function_1_0=ruleVxlFunction();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlMethodAccessorRule());
            	        }
                   		set(
                   			current, 
                   			"function",
                    		lv_function_1_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlFunction");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalVxl.g:707:2: ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16||LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalVxl.g:708:1: (lv_accessor_2_0= ruleVxlAccessor )
                    {
                    // InternalVxl.g:708:1: (lv_accessor_2_0= ruleVxlAccessor )
                    // InternalVxl.g:709:3: lv_accessor_2_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlMethodAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_accessor_2_0=ruleVxlAccessor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlMethodAccessorRule());
                    	        }
                           		set(
                           			current, 
                           			"accessor",
                            		lv_accessor_2_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlAccessor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlMethodAccessor"


    // $ANTLR start "entryRuleVxlList"
    // InternalVxl.g:733:1: entryRuleVxlList returns [EObject current=null] : iv_ruleVxlList= ruleVxlList EOF ;
    public final EObject entryRuleVxlList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlList = null;


        try {
            // InternalVxl.g:734:2: (iv_ruleVxlList= ruleVxlList EOF )
            // InternalVxl.g:735:2: iv_ruleVxlList= ruleVxlList EOF
            {
             newCompositeNode(grammarAccess.getVxlListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlList=ruleVxlList();

            state._fsp--;

             current =iv_ruleVxlList; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlList"


    // $ANTLR start "ruleVxlList"
    // InternalVxl.g:742:1: ruleVxlList returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) ) ;
    public final EObject ruleVxlList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_empty_1_0=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:745:28: ( (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) ) )
            // InternalVxl.g:746:1: (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) )
            {
            // InternalVxl.g:746:1: (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) )
            // InternalVxl.g:746:3: otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlListAccess().getLeftSquareBracketKeyword_0());
                
            // InternalVxl.g:750:1: ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_INT)||LA8_0==11||(LA8_0>=13 && LA8_0<=16)||LA8_0==20||(LA8_0>=23 && LA8_0<=26)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalVxl.g:750:2: ( (lv_empty_1_0= ']' ) )
                    {
                    // InternalVxl.g:750:2: ( (lv_empty_1_0= ']' ) )
                    // InternalVxl.g:751:1: (lv_empty_1_0= ']' )
                    {
                    // InternalVxl.g:751:1: (lv_empty_1_0= ']' )
                    // InternalVxl.g:752:3: lv_empty_1_0= ']'
                    {
                    lv_empty_1_0=(Token)match(input,17,FOLLOW_2); 

                            newLeafNode(lv_empty_1_0, grammarAccess.getVxlListAccess().getEmptyRightSquareBracketKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVxlListRule());
                    	        }
                           		setWithLastConsumed(current, "empty", true, "]");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVxl.g:766:6: ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' )
                    {
                    // InternalVxl.g:766:6: ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' )
                    // InternalVxl.g:766:7: ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']'
                    {
                    // InternalVxl.g:766:7: ( (lv_body_2_0= ruleVxlListElement ) )
                    // InternalVxl.g:767:1: (lv_body_2_0= ruleVxlListElement )
                    {
                    // InternalVxl.g:767:1: (lv_body_2_0= ruleVxlListElement )
                    // InternalVxl.g:768:3: lv_body_2_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlListAccess().getBodyVxlListElementParserRuleCall_1_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_7);
                    lv_body_2_0=ruleVxlListElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlListRule());
                    	        }
                           		set(
                           			current, 
                           			"body",
                            		lv_body_2_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlListElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_2); 

                        	newLeafNode(otherlv_3, grammarAccess.getVxlListAccess().getRightSquareBracketKeyword_1_1_1());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlList"


    // $ANTLR start "entryRuleVxlListElement"
    // InternalVxl.g:796:1: entryRuleVxlListElement returns [EObject current=null] : iv_ruleVxlListElement= ruleVxlListElement EOF ;
    public final EObject entryRuleVxlListElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlListElement = null;


        try {
            // InternalVxl.g:797:2: (iv_ruleVxlListElement= ruleVxlListElement EOF )
            // InternalVxl.g:798:2: iv_ruleVxlListElement= ruleVxlListElement EOF
            {
             newCompositeNode(grammarAccess.getVxlListElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlListElement=ruleVxlListElement();

            state._fsp--;

             current =iv_ruleVxlListElement; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlListElement"


    // $ANTLR start "ruleVxlListElement"
    // InternalVxl.g:805:1: ruleVxlListElement returns [EObject current=null] : ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? ) ;
    public final EObject ruleVxlListElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_first_0_0 = null;

        EObject lv_rest_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:808:28: ( ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? ) )
            // InternalVxl.g:809:1: ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? )
            {
            // InternalVxl.g:809:1: ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? )
            // InternalVxl.g:809:2: ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )?
            {
            // InternalVxl.g:809:2: ( (lv_first_0_0= ruleVxlTerm ) )
            // InternalVxl.g:810:1: (lv_first_0_0= ruleVxlTerm )
            {
            // InternalVxl.g:810:1: (lv_first_0_0= ruleVxlTerm )
            // InternalVxl.g:811:3: lv_first_0_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlListElementAccess().getFirstVxlTermParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_10);
            lv_first_0_0=ruleVxlTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlListElementRule());
            	        }
                   		set(
                   			current, 
                   			"first",
                    		lv_first_0_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlTerm");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalVxl.g:827:2: (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalVxl.g:827:4: otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_9); 

                        	newLeafNode(otherlv_1, grammarAccess.getVxlListElementAccess().getCommaKeyword_1_0());
                        
                    // InternalVxl.g:831:1: ( (lv_rest_2_0= ruleVxlListElement ) )
                    // InternalVxl.g:832:1: (lv_rest_2_0= ruleVxlListElement )
                    {
                    // InternalVxl.g:832:1: (lv_rest_2_0= ruleVxlListElement )
                    // InternalVxl.g:833:3: lv_rest_2_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlListElementAccess().getRestVxlListElementParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_rest_2_0=ruleVxlListElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlListElementRule());
                    	        }
                           		set(
                           			current, 
                           			"rest",
                            		lv_rest_2_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlListElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlListElement"


    // $ANTLR start "entryRuleVxlMap"
    // InternalVxl.g:857:1: entryRuleVxlMap returns [EObject current=null] : iv_ruleVxlMap= ruleVxlMap EOF ;
    public final EObject entryRuleVxlMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMap = null;


        try {
            // InternalVxl.g:858:2: (iv_ruleVxlMap= ruleVxlMap EOF )
            // InternalVxl.g:859:2: iv_ruleVxlMap= ruleVxlMap EOF
            {
             newCompositeNode(grammarAccess.getVxlMapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlMap=ruleVxlMap();

            state._fsp--;

             current =iv_ruleVxlMap; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlMap"


    // $ANTLR start "ruleVxlMap"
    // InternalVxl.g:866:1: ruleVxlMap returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_empty_1_0= '}' ) ) | ( ( (lv_body_2_0= ruleVxlMapElement ) ) otherlv_3= '}' ) ) ) ;
    public final EObject ruleVxlMap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_empty_1_0=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:869:28: ( (otherlv_0= '{' ( ( (lv_empty_1_0= '}' ) ) | ( ( (lv_body_2_0= ruleVxlMapElement ) ) otherlv_3= '}' ) ) ) )
            // InternalVxl.g:870:1: (otherlv_0= '{' ( ( (lv_empty_1_0= '}' ) ) | ( ( (lv_body_2_0= ruleVxlMapElement ) ) otherlv_3= '}' ) ) )
            {
            // InternalVxl.g:870:1: (otherlv_0= '{' ( ( (lv_empty_1_0= '}' ) ) | ( ( (lv_body_2_0= ruleVxlMapElement ) ) otherlv_3= '}' ) ) )
            // InternalVxl.g:870:3: otherlv_0= '{' ( ( (lv_empty_1_0= '}' ) ) | ( ( (lv_body_2_0= ruleVxlMapElement ) ) otherlv_3= '}' ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_11); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlMapAccess().getLeftCurlyBracketKeyword_0());
                
            // InternalVxl.g:874:1: ( ( (lv_empty_1_0= '}' ) ) | ( ( (lv_body_2_0= ruleVxlMapElement ) ) otherlv_3= '}' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_INT)||LA10_0==11||(LA10_0>=13 && LA10_0<=16)||LA10_0==20||(LA10_0>=23 && LA10_0<=26)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalVxl.g:874:2: ( (lv_empty_1_0= '}' ) )
                    {
                    // InternalVxl.g:874:2: ( (lv_empty_1_0= '}' ) )
                    // InternalVxl.g:875:1: (lv_empty_1_0= '}' )
                    {
                    // InternalVxl.g:875:1: (lv_empty_1_0= '}' )
                    // InternalVxl.g:876:3: lv_empty_1_0= '}'
                    {
                    lv_empty_1_0=(Token)match(input,21,FOLLOW_2); 

                            newLeafNode(lv_empty_1_0, grammarAccess.getVxlMapAccess().getEmptyRightCurlyBracketKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVxlMapRule());
                    	        }
                           		setWithLastConsumed(current, "empty", true, "}");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVxl.g:890:6: ( ( (lv_body_2_0= ruleVxlMapElement ) ) otherlv_3= '}' )
                    {
                    // InternalVxl.g:890:6: ( ( (lv_body_2_0= ruleVxlMapElement ) ) otherlv_3= '}' )
                    // InternalVxl.g:890:7: ( (lv_body_2_0= ruleVxlMapElement ) ) otherlv_3= '}'
                    {
                    // InternalVxl.g:890:7: ( (lv_body_2_0= ruleVxlMapElement ) )
                    // InternalVxl.g:891:1: (lv_body_2_0= ruleVxlMapElement )
                    {
                    // InternalVxl.g:891:1: (lv_body_2_0= ruleVxlMapElement )
                    // InternalVxl.g:892:3: lv_body_2_0= ruleVxlMapElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlMapAccess().getBodyVxlMapElementParserRuleCall_1_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_12);
                    lv_body_2_0=ruleVxlMapElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlMapRule());
                    	        }
                           		set(
                           			current, 
                           			"body",
                            		lv_body_2_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlMapElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,21,FOLLOW_2); 

                        	newLeafNode(otherlv_3, grammarAccess.getVxlMapAccess().getRightCurlyBracketKeyword_1_1_1());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlMap"


    // $ANTLR start "entryRuleVxlMapElement"
    // InternalVxl.g:920:1: entryRuleVxlMapElement returns [EObject current=null] : iv_ruleVxlMapElement= ruleVxlMapElement EOF ;
    public final EObject entryRuleVxlMapElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMapElement = null;


        try {
            // InternalVxl.g:921:2: (iv_ruleVxlMapElement= ruleVxlMapElement EOF )
            // InternalVxl.g:922:2: iv_ruleVxlMapElement= ruleVxlMapElement EOF
            {
             newCompositeNode(grammarAccess.getVxlMapElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlMapElement=ruleVxlMapElement();

            state._fsp--;

             current =iv_ruleVxlMapElement; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlMapElement"


    // $ANTLR start "ruleVxlMapElement"
    // InternalVxl.g:929:1: ruleVxlMapElement returns [EObject current=null] : ( ( (lv_key_0_0= ruleVxlTerm ) ) otherlv_1= ':' ( (lv_value_2_0= ruleVxlTerm ) ) (otherlv_3= ',' ( (lv_rest_4_0= ruleVxlMapElement ) ) )? ) ;
    public final EObject ruleVxlMapElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_key_0_0 = null;

        EObject lv_value_2_0 = null;

        EObject lv_rest_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:932:28: ( ( ( (lv_key_0_0= ruleVxlTerm ) ) otherlv_1= ':' ( (lv_value_2_0= ruleVxlTerm ) ) (otherlv_3= ',' ( (lv_rest_4_0= ruleVxlMapElement ) ) )? ) )
            // InternalVxl.g:933:1: ( ( (lv_key_0_0= ruleVxlTerm ) ) otherlv_1= ':' ( (lv_value_2_0= ruleVxlTerm ) ) (otherlv_3= ',' ( (lv_rest_4_0= ruleVxlMapElement ) ) )? )
            {
            // InternalVxl.g:933:1: ( ( (lv_key_0_0= ruleVxlTerm ) ) otherlv_1= ':' ( (lv_value_2_0= ruleVxlTerm ) ) (otherlv_3= ',' ( (lv_rest_4_0= ruleVxlMapElement ) ) )? )
            // InternalVxl.g:933:2: ( (lv_key_0_0= ruleVxlTerm ) ) otherlv_1= ':' ( (lv_value_2_0= ruleVxlTerm ) ) (otherlv_3= ',' ( (lv_rest_4_0= ruleVxlMapElement ) ) )?
            {
            // InternalVxl.g:933:2: ( (lv_key_0_0= ruleVxlTerm ) )
            // InternalVxl.g:934:1: (lv_key_0_0= ruleVxlTerm )
            {
            // InternalVxl.g:934:1: (lv_key_0_0= ruleVxlTerm )
            // InternalVxl.g:935:3: lv_key_0_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlMapElementAccess().getKeyVxlTermParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_13);
            lv_key_0_0=ruleVxlTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlMapElementRule());
            	        }
                   		set(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlTerm");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getVxlMapElementAccess().getColonKeyword_1());
                
            // InternalVxl.g:955:1: ( (lv_value_2_0= ruleVxlTerm ) )
            // InternalVxl.g:956:1: (lv_value_2_0= ruleVxlTerm )
            {
            // InternalVxl.g:956:1: (lv_value_2_0= ruleVxlTerm )
            // InternalVxl.g:957:3: lv_value_2_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlMapElementAccess().getValueVxlTermParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_10);
            lv_value_2_0=ruleVxlTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlMapElementRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"de.dailab.vsdt.vxl.Vxl.VxlTerm");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalVxl.g:973:2: (otherlv_3= ',' ( (lv_rest_4_0= ruleVxlMapElement ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalVxl.g:973:4: otherlv_3= ',' ( (lv_rest_4_0= ruleVxlMapElement ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_11); 

                        	newLeafNode(otherlv_3, grammarAccess.getVxlMapElementAccess().getCommaKeyword_3_0());
                        
                    // InternalVxl.g:977:1: ( (lv_rest_4_0= ruleVxlMapElement ) )
                    // InternalVxl.g:978:1: (lv_rest_4_0= ruleVxlMapElement )
                    {
                    // InternalVxl.g:978:1: (lv_rest_4_0= ruleVxlMapElement )
                    // InternalVxl.g:979:3: lv_rest_4_0= ruleVxlMapElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlMapElementAccess().getRestVxlMapElementParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_rest_4_0=ruleVxlMapElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlMapElementRule());
                    	        }
                           		set(
                           			current, 
                           			"rest",
                            		lv_rest_4_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlMapElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlMapElement"


    // $ANTLR start "entryRuleVxlFunction"
    // InternalVxl.g:1003:1: entryRuleVxlFunction returns [EObject current=null] : iv_ruleVxlFunction= ruleVxlFunction EOF ;
    public final EObject entryRuleVxlFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlFunction = null;


        try {
            // InternalVxl.g:1004:2: (iv_ruleVxlFunction= ruleVxlFunction EOF )
            // InternalVxl.g:1005:2: iv_ruleVxlFunction= ruleVxlFunction EOF
            {
             newCompositeNode(grammarAccess.getVxlFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlFunction=ruleVxlFunction();

            state._fsp--;

             current =iv_ruleVxlFunction; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlFunction"


    // $ANTLR start "ruleVxlFunction"
    // InternalVxl.g:1012:1: ruleVxlFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) ) ) ;
    public final EObject ruleVxlFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_empty_2_0=null;
        Token otherlv_4=null;
        EObject lv_body_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:1015:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) ) ) )
            // InternalVxl.g:1016:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) ) )
            {
            // InternalVxl.g:1016:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) ) )
            // InternalVxl.g:1016:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) )
            {
            // InternalVxl.g:1016:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalVxl.g:1017:1: (lv_name_0_0= RULE_ID )
            {
            // InternalVxl.g:1017:1: (lv_name_0_0= RULE_ID )
            // InternalVxl.g:1018:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            			newLeafNode(lv_name_0_0, grammarAccess.getVxlFunctionAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVxlFunctionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_15); 

                	newLeafNode(otherlv_1, grammarAccess.getVxlFunctionAccess().getLeftParenthesisKeyword_1());
                
            // InternalVxl.g:1038:1: ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==12) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_INT)||LA12_0==11||(LA12_0>=13 && LA12_0<=16)||LA12_0==20||(LA12_0>=23 && LA12_0<=26)) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalVxl.g:1038:2: ( (lv_empty_2_0= ')' ) )
                    {
                    // InternalVxl.g:1038:2: ( (lv_empty_2_0= ')' ) )
                    // InternalVxl.g:1039:1: (lv_empty_2_0= ')' )
                    {
                    // InternalVxl.g:1039:1: (lv_empty_2_0= ')' )
                    // InternalVxl.g:1040:3: lv_empty_2_0= ')'
                    {
                    lv_empty_2_0=(Token)match(input,12,FOLLOW_2); 

                            newLeafNode(lv_empty_2_0, grammarAccess.getVxlFunctionAccess().getEmptyRightParenthesisKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVxlFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "empty", true, ")");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVxl.g:1054:6: ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' )
                    {
                    // InternalVxl.g:1054:6: ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' )
                    // InternalVxl.g:1054:7: ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')'
                    {
                    // InternalVxl.g:1054:7: ( (lv_body_3_0= ruleVxlListElement ) )
                    // InternalVxl.g:1055:1: (lv_body_3_0= ruleVxlListElement )
                    {
                    // InternalVxl.g:1055:1: (lv_body_3_0= ruleVxlListElement )
                    // InternalVxl.g:1056:3: lv_body_3_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlFunctionAccess().getBodyVxlListElementParserRuleCall_2_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_body_3_0=ruleVxlListElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"body",
                            		lv_body_3_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlListElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,12,FOLLOW_2); 

                        	newLeafNode(otherlv_4, grammarAccess.getVxlFunctionAccess().getRightParenthesisKeyword_2_1_1());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlFunction"


    // $ANTLR start "entryRuleVxlConstructor"
    // InternalVxl.g:1084:1: entryRuleVxlConstructor returns [EObject current=null] : iv_ruleVxlConstructor= ruleVxlConstructor EOF ;
    public final EObject entryRuleVxlConstructor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlConstructor = null;


        try {
            // InternalVxl.g:1085:2: (iv_ruleVxlConstructor= ruleVxlConstructor EOF )
            // InternalVxl.g:1086:2: iv_ruleVxlConstructor= ruleVxlConstructor EOF
            {
             newCompositeNode(grammarAccess.getVxlConstructorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlConstructor=ruleVxlConstructor();

            state._fsp--;

             current =iv_ruleVxlConstructor; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlConstructor"


    // $ANTLR start "ruleVxlConstructor"
    // InternalVxl.g:1093:1: ruleVxlConstructor returns [EObject current=null] : (otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) ) ) ;
    public final EObject ruleVxlConstructor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_empty_3_0=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_body_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:1096:28: ( (otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) ) ) )
            // InternalVxl.g:1097:1: (otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) ) )
            {
            // InternalVxl.g:1097:1: (otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) ) )
            // InternalVxl.g:1097:3: otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlConstructorAccess().getNewKeyword_0());
                
            // InternalVxl.g:1101:1: ( (lv_name_1_0= ruleFULLY_QUALIFIED ) )
            // InternalVxl.g:1102:1: (lv_name_1_0= ruleFULLY_QUALIFIED )
            {
            // InternalVxl.g:1102:1: (lv_name_1_0= ruleFULLY_QUALIFIED )
            // InternalVxl.g:1103:3: lv_name_1_0= ruleFULLY_QUALIFIED
            {
             
            	        newCompositeNode(grammarAccess.getVxlConstructorAccess().getNameFULLY_QUALIFIEDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_14);
            lv_name_1_0=ruleFULLY_QUALIFIED();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlConstructorRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"de.dailab.vsdt.vxl.Vxl.FULLY_QUALIFIED");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_15); 

                	newLeafNode(otherlv_2, grammarAccess.getVxlConstructorAccess().getLeftParenthesisKeyword_2());
                
            // InternalVxl.g:1123:1: ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==12) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_INT)||LA13_0==11||(LA13_0>=13 && LA13_0<=16)||LA13_0==20||(LA13_0>=23 && LA13_0<=26)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalVxl.g:1123:2: ( (lv_empty_3_0= ')' ) )
                    {
                    // InternalVxl.g:1123:2: ( (lv_empty_3_0= ')' ) )
                    // InternalVxl.g:1124:1: (lv_empty_3_0= ')' )
                    {
                    // InternalVxl.g:1124:1: (lv_empty_3_0= ')' )
                    // InternalVxl.g:1125:3: lv_empty_3_0= ')'
                    {
                    lv_empty_3_0=(Token)match(input,12,FOLLOW_2); 

                            newLeafNode(lv_empty_3_0, grammarAccess.getVxlConstructorAccess().getEmptyRightParenthesisKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVxlConstructorRule());
                    	        }
                           		setWithLastConsumed(current, "empty", true, ")");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVxl.g:1139:6: ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' )
                    {
                    // InternalVxl.g:1139:6: ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' )
                    // InternalVxl.g:1139:7: ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')'
                    {
                    // InternalVxl.g:1139:7: ( (lv_body_4_0= ruleVxlListElement ) )
                    // InternalVxl.g:1140:1: (lv_body_4_0= ruleVxlListElement )
                    {
                    // InternalVxl.g:1140:1: (lv_body_4_0= ruleVxlListElement )
                    // InternalVxl.g:1141:3: lv_body_4_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlConstructorAccess().getBodyVxlListElementParserRuleCall_3_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_body_4_0=ruleVxlListElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlConstructorRule());
                    	        }
                           		set(
                           			current, 
                           			"body",
                            		lv_body_4_0, 
                            		"de.dailab.vsdt.vxl.Vxl.VxlListElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,12,FOLLOW_2); 

                        	newLeafNode(otherlv_5, grammarAccess.getVxlConstructorAccess().getRightParenthesisKeyword_3_1_1());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlConstructor"


    // $ANTLR start "entryRuleVxlValue"
    // InternalVxl.g:1169:1: entryRuleVxlValue returns [EObject current=null] : iv_ruleVxlValue= ruleVxlValue EOF ;
    public final EObject entryRuleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlValue = null;


        try {
            // InternalVxl.g:1170:2: (iv_ruleVxlValue= ruleVxlValue EOF )
            // InternalVxl.g:1171:2: iv_ruleVxlValue= ruleVxlValue EOF
            {
             newCompositeNode(grammarAccess.getVxlValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlValue=ruleVxlValue();

            state._fsp--;

             current =iv_ruleVxlValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlValue"


    // $ANTLR start "ruleVxlValue"
    // InternalVxl.g:1178:1: ruleVxlValue returns [EObject current=null] : (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) ;
    public final EObject ruleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject this_VxlNullConst_0 = null;

        EObject this_VxlBooleanConst_1 = null;

        EObject this_VxlNumericConst_2 = null;

        EObject this_VxlStringConst_3 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:1181:28: ( (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) )
            // InternalVxl.g:1182:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
            {
            // InternalVxl.g:1182:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt14=1;
                }
                break;
            case 24:
            case 25:
                {
                alt14=2;
                }
                break;
            case RULE_INT:
                {
                alt14=3;
                }
                break;
            case RULE_STRING:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalVxl.g:1183:5: this_VxlNullConst_0= ruleVxlNullConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlNullConstParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlNullConst_0=ruleVxlNullConst();

                    state._fsp--;

                     
                            current = this_VxlNullConst_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalVxl.g:1193:5: this_VxlBooleanConst_1= ruleVxlBooleanConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlBooleanConstParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlBooleanConst_1=ruleVxlBooleanConst();

                    state._fsp--;

                     
                            current = this_VxlBooleanConst_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalVxl.g:1203:5: this_VxlNumericConst_2= ruleVxlNumericConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlNumericConstParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlNumericConst_2=ruleVxlNumericConst();

                    state._fsp--;

                     
                            current = this_VxlNumericConst_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalVxl.g:1213:5: this_VxlStringConst_3= ruleVxlStringConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlStringConstParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VxlStringConst_3=ruleVxlStringConst();

                    state._fsp--;

                     
                            current = this_VxlStringConst_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlValue"


    // $ANTLR start "entryRuleVxlBooleanConst"
    // InternalVxl.g:1229:1: entryRuleVxlBooleanConst returns [EObject current=null] : iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF ;
    public final EObject entryRuleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBooleanConst = null;


        try {
            // InternalVxl.g:1230:2: (iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF )
            // InternalVxl.g:1231:2: iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF
            {
             newCompositeNode(grammarAccess.getVxlBooleanConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlBooleanConst=ruleVxlBooleanConst();

            state._fsp--;

             current =iv_ruleVxlBooleanConst; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlBooleanConst"


    // $ANTLR start "ruleVxlBooleanConst"
    // InternalVxl.g:1238:1: ruleVxlBooleanConst returns [EObject current=null] : ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) ) ;
    public final EObject ruleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_1=null;
        Token lv_const_0_2=null;

         enterRule(); 
            
        try {
            // InternalVxl.g:1241:28: ( ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) ) )
            // InternalVxl.g:1242:1: ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) )
            {
            // InternalVxl.g:1242:1: ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) )
            // InternalVxl.g:1243:1: ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) )
            {
            // InternalVxl.g:1243:1: ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) )
            // InternalVxl.g:1244:1: (lv_const_0_1= 'true' | lv_const_0_2= 'false' )
            {
            // InternalVxl.g:1244:1: (lv_const_0_1= 'true' | lv_const_0_2= 'false' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            else if ( (LA15_0==25) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalVxl.g:1245:3: lv_const_0_1= 'true'
                    {
                    lv_const_0_1=(Token)match(input,24,FOLLOW_2); 

                            newLeafNode(lv_const_0_1, grammarAccess.getVxlBooleanConstAccess().getConstTrueKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVxlBooleanConstRule());
                    	        }
                           		setWithLastConsumed(current, "const", lv_const_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalVxl.g:1257:8: lv_const_0_2= 'false'
                    {
                    lv_const_0_2=(Token)match(input,25,FOLLOW_2); 

                            newLeafNode(lv_const_0_2, grammarAccess.getVxlBooleanConstAccess().getConstFalseKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVxlBooleanConstRule());
                    	        }
                           		setWithLastConsumed(current, "const", lv_const_0_2, null);
                    	    

                    }
                    break;

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlBooleanConst"


    // $ANTLR start "entryRuleVxlNullConst"
    // InternalVxl.g:1280:1: entryRuleVxlNullConst returns [EObject current=null] : iv_ruleVxlNullConst= ruleVxlNullConst EOF ;
    public final EObject entryRuleVxlNullConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNullConst = null;


        try {
            // InternalVxl.g:1281:2: (iv_ruleVxlNullConst= ruleVxlNullConst EOF )
            // InternalVxl.g:1282:2: iv_ruleVxlNullConst= ruleVxlNullConst EOF
            {
             newCompositeNode(grammarAccess.getVxlNullConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlNullConst=ruleVxlNullConst();

            state._fsp--;

             current =iv_ruleVxlNullConst; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlNullConst"


    // $ANTLR start "ruleVxlNullConst"
    // InternalVxl.g:1289:1: ruleVxlNullConst returns [EObject current=null] : ( (lv_const_0_0= 'null' ) ) ;
    public final EObject ruleVxlNullConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;

         enterRule(); 
            
        try {
            // InternalVxl.g:1292:28: ( ( (lv_const_0_0= 'null' ) ) )
            // InternalVxl.g:1293:1: ( (lv_const_0_0= 'null' ) )
            {
            // InternalVxl.g:1293:1: ( (lv_const_0_0= 'null' ) )
            // InternalVxl.g:1294:1: (lv_const_0_0= 'null' )
            {
            // InternalVxl.g:1294:1: (lv_const_0_0= 'null' )
            // InternalVxl.g:1295:3: lv_const_0_0= 'null'
            {
            lv_const_0_0=(Token)match(input,26,FOLLOW_2); 

                    newLeafNode(lv_const_0_0, grammarAccess.getVxlNullConstAccess().getConstNullKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVxlNullConstRule());
            	        }
                   		setWithLastConsumed(current, "const", lv_const_0_0, "null");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlNullConst"


    // $ANTLR start "entryRuleVxlNumericConst"
    // InternalVxl.g:1316:1: entryRuleVxlNumericConst returns [EObject current=null] : iv_ruleVxlNumericConst= ruleVxlNumericConst EOF ;
    public final EObject entryRuleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNumericConst = null;


        try {
            // InternalVxl.g:1317:2: (iv_ruleVxlNumericConst= ruleVxlNumericConst EOF )
            // InternalVxl.g:1318:2: iv_ruleVxlNumericConst= ruleVxlNumericConst EOF
            {
             newCompositeNode(grammarAccess.getVxlNumericConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlNumericConst=ruleVxlNumericConst();

            state._fsp--;

             current =iv_ruleVxlNumericConst; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlNumericConst"


    // $ANTLR start "ruleVxlNumericConst"
    // InternalVxl.g:1325:1: ruleVxlNumericConst returns [EObject current=null] : ( (lv_const_0_0= ruleNUMERIC ) ) ;
    public final EObject ruleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_const_0_0 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:1328:28: ( ( (lv_const_0_0= ruleNUMERIC ) ) )
            // InternalVxl.g:1329:1: ( (lv_const_0_0= ruleNUMERIC ) )
            {
            // InternalVxl.g:1329:1: ( (lv_const_0_0= ruleNUMERIC ) )
            // InternalVxl.g:1330:1: (lv_const_0_0= ruleNUMERIC )
            {
            // InternalVxl.g:1330:1: (lv_const_0_0= ruleNUMERIC )
            // InternalVxl.g:1331:3: lv_const_0_0= ruleNUMERIC
            {
             
            	        newCompositeNode(grammarAccess.getVxlNumericConstAccess().getConstNUMERICParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_const_0_0=ruleNUMERIC();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlNumericConstRule());
            	        }
                   		set(
                   			current, 
                   			"const",
                    		lv_const_0_0, 
                    		"de.dailab.vsdt.vxl.Vxl.NUMERIC");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlNumericConst"


    // $ANTLR start "entryRuleVxlStringConst"
    // InternalVxl.g:1355:1: entryRuleVxlStringConst returns [EObject current=null] : iv_ruleVxlStringConst= ruleVxlStringConst EOF ;
    public final EObject entryRuleVxlStringConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlStringConst = null;


        try {
            // InternalVxl.g:1356:2: (iv_ruleVxlStringConst= ruleVxlStringConst EOF )
            // InternalVxl.g:1357:2: iv_ruleVxlStringConst= ruleVxlStringConst EOF
            {
             newCompositeNode(grammarAccess.getVxlStringConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVxlStringConst=ruleVxlStringConst();

            state._fsp--;

             current =iv_ruleVxlStringConst; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVxlStringConst"


    // $ANTLR start "ruleVxlStringConst"
    // InternalVxl.g:1364:1: ruleVxlStringConst returns [EObject current=null] : ( (lv_const_0_0= RULE_STRING ) ) ;
    public final EObject ruleVxlStringConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;

         enterRule(); 
            
        try {
            // InternalVxl.g:1367:28: ( ( (lv_const_0_0= RULE_STRING ) ) )
            // InternalVxl.g:1368:1: ( (lv_const_0_0= RULE_STRING ) )
            {
            // InternalVxl.g:1368:1: ( (lv_const_0_0= RULE_STRING ) )
            // InternalVxl.g:1369:1: (lv_const_0_0= RULE_STRING )
            {
            // InternalVxl.g:1369:1: (lv_const_0_0= RULE_STRING )
            // InternalVxl.g:1370:3: lv_const_0_0= RULE_STRING
            {
            lv_const_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            			newLeafNode(lv_const_0_0, grammarAccess.getVxlStringConstAccess().getConstSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVxlStringConstRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"const",
                    		lv_const_0_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlStringConst"


    // $ANTLR start "entryRuleNUMERIC"
    // InternalVxl.g:1394:1: entryRuleNUMERIC returns [String current=null] : iv_ruleNUMERIC= ruleNUMERIC EOF ;
    public final String entryRuleNUMERIC() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMERIC = null;


        try {
            // InternalVxl.g:1395:2: (iv_ruleNUMERIC= ruleNUMERIC EOF )
            // InternalVxl.g:1396:2: iv_ruleNUMERIC= ruleNUMERIC EOF
            {
             newCompositeNode(grammarAccess.getNUMERICRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNUMERIC=ruleNUMERIC();

            state._fsp--;

             current =iv_ruleNUMERIC.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNUMERIC"


    // $ANTLR start "ruleNUMERIC"
    // InternalVxl.g:1403:1: ruleNUMERIC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMERIC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalVxl.g:1406:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // InternalVxl.g:1407:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // InternalVxl.g:1407:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // InternalVxl.g:1407:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_16); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_0()); 
                
            // InternalVxl.g:1414:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==18) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalVxl.g:1415:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,18,FOLLOW_17); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNUMERICAccess().getFullStopKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_1_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNUMERIC"


    // $ANTLR start "entryRuleFULLY_QUALIFIED"
    // InternalVxl.g:1435:1: entryRuleFULLY_QUALIFIED returns [String current=null] : iv_ruleFULLY_QUALIFIED= ruleFULLY_QUALIFIED EOF ;
    public final String entryRuleFULLY_QUALIFIED() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFULLY_QUALIFIED = null;


        try {
            // InternalVxl.g:1436:2: (iv_ruleFULLY_QUALIFIED= ruleFULLY_QUALIFIED EOF )
            // InternalVxl.g:1437:2: iv_ruleFULLY_QUALIFIED= ruleFULLY_QUALIFIED EOF
            {
             newCompositeNode(grammarAccess.getFULLY_QUALIFIEDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFULLY_QUALIFIED=ruleFULLY_QUALIFIED();

            state._fsp--;

             current =iv_ruleFULLY_QUALIFIED.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFULLY_QUALIFIED"


    // $ANTLR start "ruleFULLY_QUALIFIED"
    // InternalVxl.g:1444:1: ruleFULLY_QUALIFIED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )? ) ;
    public final AntlrDatatypeRuleToken ruleFULLY_QUALIFIED() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_FULLY_QUALIFIED_2 = null;


         enterRule(); 
            
        try {
            // InternalVxl.g:1447:28: ( (this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )? ) )
            // InternalVxl.g:1448:1: (this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )? )
            {
            // InternalVxl.g:1448:1: (this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )? )
            // InternalVxl.g:1448:6: this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFULLY_QUALIFIEDAccess().getIDTerminalRuleCall_0()); 
                
            // InternalVxl.g:1455:1: (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==18) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalVxl.g:1456:2: kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED
                    {
                    kw=(Token)match(input,18,FOLLOW_8); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFULLY_QUALIFIEDAccess().getFullStopKeyword_1_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getFULLY_QUALIFIEDAccess().getFULLY_QUALIFIEDParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_FULLY_QUALIFIED_2=ruleFULLY_QUALIFIED();

                    state._fsp--;


                    		current.merge(this_FULLY_QUALIFIED_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFULLY_QUALIFIED"


    // $ANTLR start "ruleVxlOperator"
    // InternalVxl.g:1480:1: ruleVxlOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) ) ;
    public final Enumerator ruleVxlOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;

         enterRule(); 
        try {
            // InternalVxl.g:1482:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) ) )
            // InternalVxl.g:1483:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) )
            {
            // InternalVxl.g:1483:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) )
            int alt18=14;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt18=1;
                }
                break;
            case 28:
                {
                alt18=2;
                }
                break;
            case 29:
                {
                alt18=3;
                }
                break;
            case 30:
                {
                alt18=4;
                }
                break;
            case 31:
                {
                alt18=5;
                }
                break;
            case 32:
                {
                alt18=6;
                }
                break;
            case 33:
                {
                alt18=7;
                }
                break;
            case 14:
                {
                alt18=8;
                }
                break;
            case 34:
                {
                alt18=9;
                }
                break;
            case 35:
                {
                alt18=10;
                }
                break;
            case 36:
                {
                alt18=11;
                }
                break;
            case 37:
                {
                alt18=12;
                }
                break;
            case 38:
                {
                alt18=13;
                }
                break;
            case 39:
                {
                alt18=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalVxl.g:1483:2: (enumLiteral_0= '<' )
                    {
                    // InternalVxl.g:1483:2: (enumLiteral_0= '<' )
                    // InternalVxl.g:1483:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,27,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalVxl.g:1489:6: (enumLiteral_1= '<=' )
                    {
                    // InternalVxl.g:1489:6: (enumLiteral_1= '<=' )
                    // InternalVxl.g:1489:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalVxl.g:1495:6: (enumLiteral_2= '==' )
                    {
                    // InternalVxl.g:1495:6: (enumLiteral_2= '==' )
                    // InternalVxl.g:1495:8: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,29,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalVxl.g:1501:6: (enumLiteral_3= '!=' )
                    {
                    // InternalVxl.g:1501:6: (enumLiteral_3= '!=' )
                    // InternalVxl.g:1501:8: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,30,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalVxl.g:1507:6: (enumLiteral_4= '>' )
                    {
                    // InternalVxl.g:1507:6: (enumLiteral_4= '>' )
                    // InternalVxl.g:1507:8: enumLiteral_4= '>'
                    {
                    enumLiteral_4=(Token)match(input,31,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalVxl.g:1513:6: (enumLiteral_5= '>=' )
                    {
                    // InternalVxl.g:1513:6: (enumLiteral_5= '>=' )
                    // InternalVxl.g:1513:8: enumLiteral_5= '>='
                    {
                    enumLiteral_5=(Token)match(input,32,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalVxl.g:1519:6: (enumLiteral_6= '+' )
                    {
                    // InternalVxl.g:1519:6: (enumLiteral_6= '+' )
                    // InternalVxl.g:1519:8: enumLiteral_6= '+'
                    {
                    enumLiteral_6=(Token)match(input,33,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalVxl.g:1525:6: (enumLiteral_7= '-' )
                    {
                    // InternalVxl.g:1525:6: (enumLiteral_7= '-' )
                    // InternalVxl.g:1525:8: enumLiteral_7= '-'
                    {
                    enumLiteral_7=(Token)match(input,14,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalVxl.g:1531:6: (enumLiteral_8= '*' )
                    {
                    // InternalVxl.g:1531:6: (enumLiteral_8= '*' )
                    // InternalVxl.g:1531:8: enumLiteral_8= '*'
                    {
                    enumLiteral_8=(Token)match(input,34,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalVxl.g:1537:6: (enumLiteral_9= '/' )
                    {
                    // InternalVxl.g:1537:6: (enumLiteral_9= '/' )
                    // InternalVxl.g:1537:8: enumLiteral_9= '/'
                    {
                    enumLiteral_9=(Token)match(input,35,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // InternalVxl.g:1543:6: (enumLiteral_10= '%' )
                    {
                    // InternalVxl.g:1543:6: (enumLiteral_10= '%' )
                    // InternalVxl.g:1543:8: enumLiteral_10= '%'
                    {
                    enumLiteral_10=(Token)match(input,36,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // InternalVxl.g:1549:6: (enumLiteral_11= 'and' )
                    {
                    // InternalVxl.g:1549:6: (enumLiteral_11= 'and' )
                    // InternalVxl.g:1549:8: enumLiteral_11= 'and'
                    {
                    enumLiteral_11=(Token)match(input,37,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_11, grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11()); 
                        

                    }


                    }
                    break;
                case 13 :
                    // InternalVxl.g:1555:6: (enumLiteral_12= 'or' )
                    {
                    // InternalVxl.g:1555:6: (enumLiteral_12= 'or' )
                    // InternalVxl.g:1555:8: enumLiteral_12= 'or'
                    {
                    enumLiteral_12=(Token)match(input,38,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_12, grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // InternalVxl.g:1561:6: (enumLiteral_13= '++' )
                    {
                    // InternalVxl.g:1561:6: (enumLiteral_13= '++' )
                    // InternalVxl.g:1561:8: enumLiteral_13= '++'
                    {
                    enumLiteral_13=(Token)match(input,39,FOLLOW_2); 

                            current = grammarAccess.getVxlOperatorAccess().getCONCATEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_13, grammarAccess.getVxlOperatorAccess().getCONCATEnumLiteralDeclaration_13()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVxlOperator"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\5\uffff\1\13\6\uffff";
    static final String dfa_3s = "\1\4\4\uffff\1\13\6\uffff";
    static final String dfa_4s = "\1\32\4\uffff\1\47\6\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\1\10\1\12\1\11\1\5";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\5\2\4\4\uffff\1\1\1\uffff\1\2\1\3\1\10\1\6\3\uffff\1\7\2\uffff\1\11\3\4",
            "",
            "",
            "",
            "",
            "\1\12\1\13\1\uffff\1\13\1\uffff\4\13\1\uffff\2\13\4\uffff\15\13",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "156:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlMap_6= ruleVxlMap | this_VxlCardinality_7= ruleVxlCardinality | this_VxlFunction_8= ruleVxlFunction | this_VxlConstructor_9= ruleVxlConstructor )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000FFF8004002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000791E870L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000000793E870L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000007B1E870L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000793F870L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000040L});

}