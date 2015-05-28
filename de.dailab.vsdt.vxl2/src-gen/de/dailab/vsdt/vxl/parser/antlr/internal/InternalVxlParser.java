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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'not'", "'-'", "'#'", "'['", "']'", "'.'", "','", "'new'", "'true'", "'false'", "'null'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", "'+'", "'*'", "'/'", "'%'", "'and'", "'or'", "'++'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalVxlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVxlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVxlParser.tokenNames; }
    public String getGrammarFileName() { return "../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g"; }



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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:68:1: entryRuleVxlTerm returns [EObject current=null] : iv_ruleVxlTerm= ruleVxlTerm EOF ;
    public final EObject entryRuleVxlTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlTerm = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:69:2: (iv_ruleVxlTerm= ruleVxlTerm EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:70:2: iv_ruleVxlTerm= ruleVxlTerm EOF
            {
             newCompositeNode(grammarAccess.getVxlTermRule()); 
            pushFollow(FOLLOW_ruleVxlTerm_in_entryRuleVxlTerm75);
            iv_ruleVxlTerm=ruleVxlTerm();

            state._fsp--;

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
    // $ANTLR end "entryRuleVxlTerm"


    // $ANTLR start "ruleVxlTerm"
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:77:1: ruleVxlTerm returns [EObject current=null] : ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? ) ;
    public final EObject ruleVxlTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_head_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_tail_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:80:28: ( ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:81:1: ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:81:1: ( ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:81:2: ( (lv_head_0_0= ruleVxlElement ) ) ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )?
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:81:2: ( (lv_head_0_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:82:1: (lv_head_0_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:82:1: (lv_head_0_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:83:3: lv_head_0_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlTermAccess().getHeadVxlElementParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlTerm131);
            lv_head_0_0=ruleVxlElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlTermRule());
            	        }
                   		set(
                   			current, 
                   			"head",
                    		lv_head_0_0, 
                    		"VxlElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:99:2: ( ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14||(LA1_0>=24 && LA1_0<=36)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:99:3: ( (lv_operator_1_0= ruleVxlOperator ) ) ( (lv_tail_2_0= ruleVxlTerm ) )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:99:3: ( (lv_operator_1_0= ruleVxlOperator ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:100:1: (lv_operator_1_0= ruleVxlOperator )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:100:1: (lv_operator_1_0= ruleVxlOperator )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:101:3: lv_operator_1_0= ruleVxlOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlTermAccess().getOperatorVxlOperatorEnumRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlOperator_in_ruleVxlTerm153);
                    lv_operator_1_0=ruleVxlOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlTermRule());
                    	        }
                           		set(
                           			current, 
                           			"operator",
                            		lv_operator_1_0, 
                            		"VxlOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:117:2: ( (lv_tail_2_0= ruleVxlTerm ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:118:1: (lv_tail_2_0= ruleVxlTerm )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:118:1: (lv_tail_2_0= ruleVxlTerm )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:119:3: lv_tail_2_0= ruleVxlTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlTermAccess().getTailVxlTermParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlTerm174);
                    lv_tail_2_0=ruleVxlTerm();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlTermRule());
                    	        }
                           		set(
                           			current, 
                           			"tail",
                            		lv_tail_2_0, 
                            		"VxlTerm");
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:143:1: entryRuleVxlElement returns [EObject current=null] : iv_ruleVxlElement= ruleVxlElement EOF ;
    public final EObject entryRuleVxlElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlElement = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:144:2: (iv_ruleVxlElement= ruleVxlElement EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:145:2: iv_ruleVxlElement= ruleVxlElement EOF
            {
             newCompositeNode(grammarAccess.getVxlElementRule()); 
            pushFollow(FOLLOW_ruleVxlElement_in_entryRuleVxlElement212);
            iv_ruleVxlElement=ruleVxlElement();

            state._fsp--;

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
    // $ANTLR end "entryRuleVxlElement"


    // $ANTLR start "ruleVxlElement"
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:152:1: ruleVxlElement returns [EObject current=null] : (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality | this_VxlFunction_7= ruleVxlFunction | this_VxlConstructor_8= ruleVxlConstructor ) ;
    public final EObject ruleVxlElement() throws RecognitionException {
        EObject current = null;

        EObject this_VxlBracketTerm_0 = null;

        EObject this_VxlNegation_1 = null;

        EObject this_VxlMinus_2 = null;

        EObject this_VxlValue_3 = null;

        EObject this_VxlVariable_4 = null;

        EObject this_VxlList_5 = null;

        EObject this_VxlCardinality_6 = null;

        EObject this_VxlFunction_7 = null;

        EObject this_VxlConstructor_8 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:155:28: ( (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality | this_VxlFunction_7= ruleVxlFunction | this_VxlConstructor_8= ruleVxlConstructor ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:156:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality | this_VxlFunction_7= ruleVxlFunction | this_VxlConstructor_8= ruleVxlConstructor )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:156:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality | this_VxlFunction_7= ruleVxlFunction | this_VxlConstructor_8= ruleVxlConstructor )
            int alt2=9;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:157:5: this_VxlBracketTerm_0= ruleVxlBracketTerm
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlBracketTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVxlBracketTerm_in_ruleVxlElement269);
                    this_VxlBracketTerm_0=ruleVxlBracketTerm();

                    state._fsp--;

                     
                            current = this_VxlBracketTerm_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:167:5: this_VxlNegation_1= ruleVxlNegation
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlNegationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVxlNegation_in_ruleVxlElement296);
                    this_VxlNegation_1=ruleVxlNegation();

                    state._fsp--;

                     
                            current = this_VxlNegation_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:177:5: this_VxlMinus_2= ruleVxlMinus
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlMinusParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVxlMinus_in_ruleVxlElement323);
                    this_VxlMinus_2=ruleVxlMinus();

                    state._fsp--;

                     
                            current = this_VxlMinus_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:187:5: this_VxlValue_3= ruleVxlValue
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVxlValue_in_ruleVxlElement350);
                    this_VxlValue_3=ruleVxlValue();

                    state._fsp--;

                     
                            current = this_VxlValue_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:197:5: this_VxlVariable_4= ruleVxlVariable
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlVariableParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleVxlVariable_in_ruleVxlElement377);
                    this_VxlVariable_4=ruleVxlVariable();

                    state._fsp--;

                     
                            current = this_VxlVariable_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:207:5: this_VxlList_5= ruleVxlList
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlListParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleVxlList_in_ruleVxlElement404);
                    this_VxlList_5=ruleVxlList();

                    state._fsp--;

                     
                            current = this_VxlList_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:217:5: this_VxlCardinality_6= ruleVxlCardinality
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlCardinalityParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleVxlCardinality_in_ruleVxlElement431);
                    this_VxlCardinality_6=ruleVxlCardinality();

                    state._fsp--;

                     
                            current = this_VxlCardinality_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:227:5: this_VxlFunction_7= ruleVxlFunction
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlFunctionParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleVxlFunction_in_ruleVxlElement458);
                    this_VxlFunction_7=ruleVxlFunction();

                    state._fsp--;

                     
                            current = this_VxlFunction_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:237:5: this_VxlConstructor_8= ruleVxlConstructor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlElementAccess().getVxlConstructorParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleVxlConstructor_in_ruleVxlElement485);
                    this_VxlConstructor_8=ruleVxlConstructor();

                    state._fsp--;

                     
                            current = this_VxlConstructor_8; 
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:253:1: entryRuleVxlBracketTerm returns [EObject current=null] : iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF ;
    public final EObject entryRuleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBracketTerm = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:254:2: (iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:255:2: iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF
            {
             newCompositeNode(grammarAccess.getVxlBracketTermRule()); 
            pushFollow(FOLLOW_ruleVxlBracketTerm_in_entryRuleVxlBracketTerm520);
            iv_ruleVxlBracketTerm=ruleVxlBracketTerm();

            state._fsp--;

             current =iv_ruleVxlBracketTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlBracketTerm530); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:262:1: ruleVxlBracketTerm returns [EObject current=null] : (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' ) ;
    public final EObject ruleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_term_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:265:28: ( (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:266:1: (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:266:1: (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:266:3: otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleVxlBracketTerm567); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlBracketTermAccess().getLeftParenthesisKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:270:1: ( (lv_term_1_0= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:271:1: (lv_term_1_0= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:271:1: (lv_term_1_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:272:3: lv_term_1_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlBracketTermAccess().getTermVxlTermParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm588);
            lv_term_1_0=ruleVxlTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlBracketTermRule());
            	        }
                   		set(
                   			current, 
                   			"term",
                    		lv_term_1_0, 
                    		"VxlTerm");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleVxlBracketTerm600); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:300:1: entryRuleVxlNegation returns [EObject current=null] : iv_ruleVxlNegation= ruleVxlNegation EOF ;
    public final EObject entryRuleVxlNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNegation = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:301:2: (iv_ruleVxlNegation= ruleVxlNegation EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:302:2: iv_ruleVxlNegation= ruleVxlNegation EOF
            {
             newCompositeNode(grammarAccess.getVxlNegationRule()); 
            pushFollow(FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation636);
            iv_ruleVxlNegation=ruleVxlNegation();

            state._fsp--;

             current =iv_ruleVxlNegation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNegation646); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:309:1: ruleVxlNegation returns [EObject current=null] : (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlNegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_element_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:312:28: ( (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:313:1: (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:313:1: (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:313:3: otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleVxlNegation683); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlNegationAccess().getNotKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:317:1: ( (lv_element_1_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:318:1: (lv_element_1_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:318:1: (lv_element_1_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:319:3: lv_element_1_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlNegationAccess().getElementVxlElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlNegation704);
            lv_element_1_0=ruleVxlElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlNegationRule());
            	        }
                   		set(
                   			current, 
                   			"element",
                    		lv_element_1_0, 
                    		"VxlElement");
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:343:1: entryRuleVxlMinus returns [EObject current=null] : iv_ruleVxlMinus= ruleVxlMinus EOF ;
    public final EObject entryRuleVxlMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMinus = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:344:2: (iv_ruleVxlMinus= ruleVxlMinus EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:345:2: iv_ruleVxlMinus= ruleVxlMinus EOF
            {
             newCompositeNode(grammarAccess.getVxlMinusRule()); 
            pushFollow(FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus740);
            iv_ruleVxlMinus=ruleVxlMinus();

            state._fsp--;

             current =iv_ruleVxlMinus; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlMinus750); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:352:1: ruleVxlMinus returns [EObject current=null] : (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_element_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:355:28: ( (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:356:1: (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:356:1: (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:356:3: otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleVxlMinus787); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlMinusAccess().getHyphenMinusKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:360:1: ( (lv_element_1_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:361:1: (lv_element_1_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:361:1: (lv_element_1_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:362:3: lv_element_1_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlMinusAccess().getElementVxlElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlMinus808);
            lv_element_1_0=ruleVxlElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlMinusRule());
            	        }
                   		set(
                   			current, 
                   			"element",
                    		lv_element_1_0, 
                    		"VxlElement");
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:386:1: entryRuleVxlCardinality returns [EObject current=null] : iv_ruleVxlCardinality= ruleVxlCardinality EOF ;
    public final EObject entryRuleVxlCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlCardinality = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:387:2: (iv_ruleVxlCardinality= ruleVxlCardinality EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:388:2: iv_ruleVxlCardinality= ruleVxlCardinality EOF
            {
             newCompositeNode(grammarAccess.getVxlCardinalityRule()); 
            pushFollow(FOLLOW_ruleVxlCardinality_in_entryRuleVxlCardinality844);
            iv_ruleVxlCardinality=ruleVxlCardinality();

            state._fsp--;

             current =iv_ruleVxlCardinality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlCardinality854); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:395:1: ruleVxlCardinality returns [EObject current=null] : (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlCardinality() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_element_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:398:28: ( (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:399:1: (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:399:1: (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:399:3: otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleVxlCardinality891); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlCardinalityAccess().getNumberSignKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:403:1: ( (lv_element_1_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:404:1: (lv_element_1_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:404:1: (lv_element_1_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:405:3: lv_element_1_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlCardinalityAccess().getElementVxlElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlCardinality912);
            lv_element_1_0=ruleVxlElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlCardinalityRule());
            	        }
                   		set(
                   			current, 
                   			"element",
                    		lv_element_1_0, 
                    		"VxlElement");
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:429:1: entryRuleVxlVariable returns [EObject current=null] : iv_ruleVxlVariable= ruleVxlVariable EOF ;
    public final EObject entryRuleVxlVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlVariable = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:430:2: (iv_ruleVxlVariable= ruleVxlVariable EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:431:2: iv_ruleVxlVariable= ruleVxlVariable EOF
            {
             newCompositeNode(grammarAccess.getVxlVariableRule()); 
            pushFollow(FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable948);
            iv_ruleVxlVariable=ruleVxlVariable();

            state._fsp--;

             current =iv_ruleVxlVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlVariable958); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:438:1: ruleVxlVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_accessor_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:441:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:442:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:442:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:442:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )?
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:442:2: ( (lv_name_0_0= RULE_ID ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:443:1: (lv_name_0_0= RULE_ID )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:443:1: (lv_name_0_0= RULE_ID )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:444:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlVariable1000); 

            			newLeafNode(lv_name_0_0, grammarAccess.getVxlVariableAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVxlVariableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:460:2: ( (lv_accessor_1_0= ruleVxlAccessor ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16||LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:461:1: (lv_accessor_1_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:461:1: (lv_accessor_1_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:462:3: lv_accessor_1_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlVariableAccess().getAccessorVxlAccessorParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlVariable1026);
                    lv_accessor_1_0=ruleVxlAccessor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlVariableRule());
                    	        }
                           		set(
                           			current, 
                           			"accessor",
                            		lv_accessor_1_0, 
                            		"VxlAccessor");
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:486:1: entryRuleVxlAccessor returns [EObject current=null] : iv_ruleVxlAccessor= ruleVxlAccessor EOF ;
    public final EObject entryRuleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:487:2: (iv_ruleVxlAccessor= ruleVxlAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:488:2: iv_ruleVxlAccessor= ruleVxlAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlAccessorRule()); 
            pushFollow(FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor1063);
            iv_ruleVxlAccessor=ruleVxlAccessor();

            state._fsp--;

             current =iv_ruleVxlAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlAccessor1073); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:495:1: ruleVxlAccessor returns [EObject current=null] : (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor | this_VxlMethodAccessor_2= ruleVxlMethodAccessor ) ;
    public final EObject ruleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject this_VxlArrayAccessor_0 = null;

        EObject this_VxlFieldAccessor_1 = null;

        EObject this_VxlMethodAccessor_2 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:498:28: ( (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor | this_VxlMethodAccessor_2= ruleVxlMethodAccessor ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:499:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor | this_VxlMethodAccessor_2= ruleVxlMethodAccessor )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:499:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor | this_VxlMethodAccessor_2= ruleVxlMethodAccessor )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==RULE_ID) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==EOF||LA4_3==12||LA4_3==14||(LA4_3>=16 && LA4_3<=19)||(LA4_3>=24 && LA4_3<=36)) ) {
                        alt4=2;
                    }
                    else if ( (LA4_3==11) ) {
                        alt4=3;
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
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:500:5: this_VxlArrayAccessor_0= ruleVxlArrayAccessor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlArrayAccessorParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1120);
                    this_VxlArrayAccessor_0=ruleVxlArrayAccessor();

                    state._fsp--;

                     
                            current = this_VxlArrayAccessor_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:510:5: this_VxlFieldAccessor_1= ruleVxlFieldAccessor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlFieldAccessorParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1147);
                    this_VxlFieldAccessor_1=ruleVxlFieldAccessor();

                    state._fsp--;

                     
                            current = this_VxlFieldAccessor_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:520:5: this_VxlMethodAccessor_2= ruleVxlMethodAccessor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlMethodAccessorParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVxlMethodAccessor_in_ruleVxlAccessor1174);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:536:1: entryRuleVxlArrayAccessor returns [EObject current=null] : iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF ;
    public final EObject entryRuleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlArrayAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:537:2: (iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:538:2: iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlArrayAccessorRule()); 
            pushFollow(FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1209);
            iv_ruleVxlArrayAccessor=ruleVxlArrayAccessor();

            state._fsp--;

             current =iv_ruleVxlArrayAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlArrayAccessor1219); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:545:1: ruleVxlArrayAccessor returns [EObject current=null] : (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_index_1_0 = null;

        EObject lv_accessor_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:548:28: ( (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:549:1: (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:549:1: (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:549:3: otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVxlArrayAccessor1256); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlArrayAccessorAccess().getLeftSquareBracketKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:553:1: ( (lv_index_1_0= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:554:1: (lv_index_1_0= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:554:1: (lv_index_1_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:555:3: lv_index_1_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getIndexVxlTermParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1277);
            lv_index_1_0=ruleVxlTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlArrayAccessorRule());
            	        }
                   		set(
                   			current, 
                   			"index",
                    		lv_index_1_0, 
                    		"VxlTerm");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleVxlArrayAccessor1289); 

                	newLeafNode(otherlv_2, grammarAccess.getVxlArrayAccessorAccess().getRightSquareBracketKeyword_2());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:575:1: ( (lv_accessor_3_0= ruleVxlAccessor ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16||LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:576:1: (lv_accessor_3_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:576:1: (lv_accessor_3_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:577:3: lv_accessor_3_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getAccessorVxlAccessorParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1310);
                    lv_accessor_3_0=ruleVxlAccessor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlArrayAccessorRule());
                    	        }
                           		set(
                           			current, 
                           			"accessor",
                            		lv_accessor_3_0, 
                            		"VxlAccessor");
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:601:1: entryRuleVxlFieldAccessor returns [EObject current=null] : iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF ;
    public final EObject entryRuleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlFieldAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:602:2: (iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:603:2: iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlFieldAccessorRule()); 
            pushFollow(FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1347);
            iv_ruleVxlFieldAccessor=ruleVxlFieldAccessor();

            state._fsp--;

             current =iv_ruleVxlFieldAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlFieldAccessor1357); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:610:1: ruleVxlFieldAccessor returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_accessor_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:613:28: ( (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:614:1: (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:614:1: (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:614:3: otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleVxlFieldAccessor1394); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlFieldAccessorAccess().getFullStopKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:618:1: ( (lv_name_1_0= RULE_ID ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:619:1: (lv_name_1_0= RULE_ID )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:619:1: (lv_name_1_0= RULE_ID )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:620:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1411); 

            			newLeafNode(lv_name_1_0, grammarAccess.getVxlFieldAccessorAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVxlFieldAccessorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:636:2: ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16||LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:637:1: (lv_accessor_2_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:637:1: (lv_accessor_2_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:638:3: lv_accessor_2_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlFieldAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1437);
                    lv_accessor_2_0=ruleVxlAccessor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlFieldAccessorRule());
                    	        }
                           		set(
                           			current, 
                           			"accessor",
                            		lv_accessor_2_0, 
                            		"VxlAccessor");
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:662:1: entryRuleVxlMethodAccessor returns [EObject current=null] : iv_ruleVxlMethodAccessor= ruleVxlMethodAccessor EOF ;
    public final EObject entryRuleVxlMethodAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMethodAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:663:2: (iv_ruleVxlMethodAccessor= ruleVxlMethodAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:664:2: iv_ruleVxlMethodAccessor= ruleVxlMethodAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlMethodAccessorRule()); 
            pushFollow(FOLLOW_ruleVxlMethodAccessor_in_entryRuleVxlMethodAccessor1474);
            iv_ruleVxlMethodAccessor=ruleVxlMethodAccessor();

            state._fsp--;

             current =iv_ruleVxlMethodAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlMethodAccessor1484); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:671:1: ruleVxlMethodAccessor returns [EObject current=null] : (otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlMethodAccessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_function_1_0 = null;

        EObject lv_accessor_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:674:28: ( (otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:675:1: (otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:675:1: (otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:675:3: otherlv_0= '.' ( (lv_function_1_0= ruleVxlFunction ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleVxlMethodAccessor1521); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlMethodAccessorAccess().getFullStopKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:679:1: ( (lv_function_1_0= ruleVxlFunction ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:680:1: (lv_function_1_0= ruleVxlFunction )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:680:1: (lv_function_1_0= ruleVxlFunction )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:681:3: lv_function_1_0= ruleVxlFunction
            {
             
            	        newCompositeNode(grammarAccess.getVxlMethodAccessorAccess().getFunctionVxlFunctionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlFunction_in_ruleVxlMethodAccessor1542);
            lv_function_1_0=ruleVxlFunction();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlMethodAccessorRule());
            	        }
                   		set(
                   			current, 
                   			"function",
                    		lv_function_1_0, 
                    		"VxlFunction");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:697:2: ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16||LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:698:1: (lv_accessor_2_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:698:1: (lv_accessor_2_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:699:3: lv_accessor_2_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlMethodAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlMethodAccessor1563);
                    lv_accessor_2_0=ruleVxlAccessor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlMethodAccessorRule());
                    	        }
                           		set(
                           			current, 
                           			"accessor",
                            		lv_accessor_2_0, 
                            		"VxlAccessor");
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:723:1: entryRuleVxlList returns [EObject current=null] : iv_ruleVxlList= ruleVxlList EOF ;
    public final EObject entryRuleVxlList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlList = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:724:2: (iv_ruleVxlList= ruleVxlList EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:725:2: iv_ruleVxlList= ruleVxlList EOF
            {
             newCompositeNode(grammarAccess.getVxlListRule()); 
            pushFollow(FOLLOW_ruleVxlList_in_entryRuleVxlList1600);
            iv_ruleVxlList=ruleVxlList();

            state._fsp--;

             current =iv_ruleVxlList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlList1610); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:732:1: ruleVxlList returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) ) ;
    public final EObject ruleVxlList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_empty_1_0=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:735:28: ( (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:736:1: (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:736:1: (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:736:3: otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVxlList1647); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlListAccess().getLeftSquareBracketKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:740:1: ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_INT)||LA8_0==11||(LA8_0>=13 && LA8_0<=16)||(LA8_0>=20 && LA8_0<=23)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:740:2: ( (lv_empty_1_0= ']' ) )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:740:2: ( (lv_empty_1_0= ']' ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:741:1: (lv_empty_1_0= ']' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:741:1: (lv_empty_1_0= ']' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:742:3: lv_empty_1_0= ']'
                    {
                    lv_empty_1_0=(Token)match(input,17,FOLLOW_17_in_ruleVxlList1666); 

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
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:756:6: ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:756:6: ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:756:7: ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']'
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:756:7: ( (lv_body_2_0= ruleVxlListElement ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:757:1: (lv_body_2_0= ruleVxlListElement )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:757:1: (lv_body_2_0= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:758:3: lv_body_2_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlListAccess().getBodyVxlListElementParserRuleCall_1_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlList1707);
                    lv_body_2_0=ruleVxlListElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlListRule());
                    	        }
                           		set(
                           			current, 
                           			"body",
                            		lv_body_2_0, 
                            		"VxlListElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleVxlList1719); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:786:1: entryRuleVxlListElement returns [EObject current=null] : iv_ruleVxlListElement= ruleVxlListElement EOF ;
    public final EObject entryRuleVxlListElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlListElement = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:787:2: (iv_ruleVxlListElement= ruleVxlListElement EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:788:2: iv_ruleVxlListElement= ruleVxlListElement EOF
            {
             newCompositeNode(grammarAccess.getVxlListElementRule()); 
            pushFollow(FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1757);
            iv_ruleVxlListElement=ruleVxlListElement();

            state._fsp--;

             current =iv_ruleVxlListElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlListElement1767); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:795:1: ruleVxlListElement returns [EObject current=null] : ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? ) ;
    public final EObject ruleVxlListElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_first_0_0 = null;

        EObject lv_rest_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:798:28: ( ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:799:1: ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:799:1: ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:799:2: ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )?
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:799:2: ( (lv_first_0_0= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:800:1: (lv_first_0_0= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:800:1: (lv_first_0_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:801:3: lv_first_0_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlListElementAccess().getFirstVxlTermParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlListElement1813);
            lv_first_0_0=ruleVxlTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlListElementRule());
            	        }
                   		set(
                   			current, 
                   			"first",
                    		lv_first_0_0, 
                    		"VxlTerm");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:817:2: (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:817:4: otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleVxlListElement1826); 

                        	newLeafNode(otherlv_1, grammarAccess.getVxlListElementAccess().getCommaKeyword_1_0());
                        
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:821:1: ( (lv_rest_2_0= ruleVxlListElement ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:822:1: (lv_rest_2_0= ruleVxlListElement )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:822:1: (lv_rest_2_0= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:823:3: lv_rest_2_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlListElementAccess().getRestVxlListElementParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlListElement1847);
                    lv_rest_2_0=ruleVxlListElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlListElementRule());
                    	        }
                           		set(
                           			current, 
                           			"rest",
                            		lv_rest_2_0, 
                            		"VxlListElement");
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


    // $ANTLR start "entryRuleVxlFunction"
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:847:1: entryRuleVxlFunction returns [EObject current=null] : iv_ruleVxlFunction= ruleVxlFunction EOF ;
    public final EObject entryRuleVxlFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlFunction = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:848:2: (iv_ruleVxlFunction= ruleVxlFunction EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:849:2: iv_ruleVxlFunction= ruleVxlFunction EOF
            {
             newCompositeNode(grammarAccess.getVxlFunctionRule()); 
            pushFollow(FOLLOW_ruleVxlFunction_in_entryRuleVxlFunction1885);
            iv_ruleVxlFunction=ruleVxlFunction();

            state._fsp--;

             current =iv_ruleVxlFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlFunction1895); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:856:1: ruleVxlFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) ) ) ;
    public final EObject ruleVxlFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_empty_2_0=null;
        Token otherlv_4=null;
        EObject lv_body_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:859:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:860:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:860:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:860:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:860:2: ( (lv_name_0_0= RULE_ID ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:861:1: (lv_name_0_0= RULE_ID )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:861:1: (lv_name_0_0= RULE_ID )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:862:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlFunction1937); 

            			newLeafNode(lv_name_0_0, grammarAccess.getVxlFunctionAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVxlFunctionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleVxlFunction1954); 

                	newLeafNode(otherlv_1, grammarAccess.getVxlFunctionAccess().getLeftParenthesisKeyword_1());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:882:1: ( ( (lv_empty_2_0= ')' ) ) | ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==12) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_INT)||LA10_0==11||(LA10_0>=13 && LA10_0<=16)||(LA10_0>=20 && LA10_0<=23)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:882:2: ( (lv_empty_2_0= ')' ) )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:882:2: ( (lv_empty_2_0= ')' ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:883:1: (lv_empty_2_0= ')' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:883:1: (lv_empty_2_0= ')' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:884:3: lv_empty_2_0= ')'
                    {
                    lv_empty_2_0=(Token)match(input,12,FOLLOW_12_in_ruleVxlFunction1973); 

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
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:898:6: ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:898:6: ( ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:898:7: ( (lv_body_3_0= ruleVxlListElement ) ) otherlv_4= ')'
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:898:7: ( (lv_body_3_0= ruleVxlListElement ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:899:1: (lv_body_3_0= ruleVxlListElement )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:899:1: (lv_body_3_0= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:900:3: lv_body_3_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlFunctionAccess().getBodyVxlListElementParserRuleCall_2_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlFunction2014);
                    lv_body_3_0=ruleVxlListElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"body",
                            		lv_body_3_0, 
                            		"VxlListElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleVxlFunction2026); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:928:1: entryRuleVxlConstructor returns [EObject current=null] : iv_ruleVxlConstructor= ruleVxlConstructor EOF ;
    public final EObject entryRuleVxlConstructor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlConstructor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:929:2: (iv_ruleVxlConstructor= ruleVxlConstructor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:930:2: iv_ruleVxlConstructor= ruleVxlConstructor EOF
            {
             newCompositeNode(grammarAccess.getVxlConstructorRule()); 
            pushFollow(FOLLOW_ruleVxlConstructor_in_entryRuleVxlConstructor2064);
            iv_ruleVxlConstructor=ruleVxlConstructor();

            state._fsp--;

             current =iv_ruleVxlConstructor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlConstructor2074); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:937:1: ruleVxlConstructor returns [EObject current=null] : (otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) ) ) ;
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
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:940:28: ( (otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:941:1: (otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:941:1: (otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:941:3: otherlv_0= 'new' ( (lv_name_1_0= ruleFULLY_QUALIFIED ) ) otherlv_2= '(' ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleVxlConstructor2111); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlConstructorAccess().getNewKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:945:1: ( (lv_name_1_0= ruleFULLY_QUALIFIED ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:946:1: (lv_name_1_0= ruleFULLY_QUALIFIED )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:946:1: (lv_name_1_0= ruleFULLY_QUALIFIED )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:947:3: lv_name_1_0= ruleFULLY_QUALIFIED
            {
             
            	        newCompositeNode(grammarAccess.getVxlConstructorAccess().getNameFULLY_QUALIFIEDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFULLY_QUALIFIED_in_ruleVxlConstructor2132);
            lv_name_1_0=ruleFULLY_QUALIFIED();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlConstructorRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"FULLY_QUALIFIED");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleVxlConstructor2144); 

                	newLeafNode(otherlv_2, grammarAccess.getVxlConstructorAccess().getLeftParenthesisKeyword_2());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:967:1: ( ( (lv_empty_3_0= ')' ) ) | ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==12) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_INT)||LA11_0==11||(LA11_0>=13 && LA11_0<=16)||(LA11_0>=20 && LA11_0<=23)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:967:2: ( (lv_empty_3_0= ')' ) )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:967:2: ( (lv_empty_3_0= ')' ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:968:1: (lv_empty_3_0= ')' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:968:1: (lv_empty_3_0= ')' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:969:3: lv_empty_3_0= ')'
                    {
                    lv_empty_3_0=(Token)match(input,12,FOLLOW_12_in_ruleVxlConstructor2163); 

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
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:983:6: ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:983:6: ( ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:983:7: ( (lv_body_4_0= ruleVxlListElement ) ) otherlv_5= ')'
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:983:7: ( (lv_body_4_0= ruleVxlListElement ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:984:1: (lv_body_4_0= ruleVxlListElement )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:984:1: (lv_body_4_0= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:985:3: lv_body_4_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlConstructorAccess().getBodyVxlListElementParserRuleCall_3_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlConstructor2204);
                    lv_body_4_0=ruleVxlListElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVxlConstructorRule());
                    	        }
                           		set(
                           			current, 
                           			"body",
                            		lv_body_4_0, 
                            		"VxlListElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleVxlConstructor2216); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1013:1: entryRuleVxlValue returns [EObject current=null] : iv_ruleVxlValue= ruleVxlValue EOF ;
    public final EObject entryRuleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlValue = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1014:2: (iv_ruleVxlValue= ruleVxlValue EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1015:2: iv_ruleVxlValue= ruleVxlValue EOF
            {
             newCompositeNode(grammarAccess.getVxlValueRule()); 
            pushFollow(FOLLOW_ruleVxlValue_in_entryRuleVxlValue2254);
            iv_ruleVxlValue=ruleVxlValue();

            state._fsp--;

             current =iv_ruleVxlValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlValue2264); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1022:1: ruleVxlValue returns [EObject current=null] : (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) ;
    public final EObject ruleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject this_VxlNullConst_0 = null;

        EObject this_VxlBooleanConst_1 = null;

        EObject this_VxlNumericConst_2 = null;

        EObject this_VxlStringConst_3 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1025:28: ( (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1026:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1026:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt12=1;
                }
                break;
            case 21:
            case 22:
                {
                alt12=2;
                }
                break;
            case RULE_INT:
                {
                alt12=3;
                }
                break;
            case RULE_STRING:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1027:5: this_VxlNullConst_0= ruleVxlNullConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlNullConstParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVxlNullConst_in_ruleVxlValue2311);
                    this_VxlNullConst_0=ruleVxlNullConst();

                    state._fsp--;

                     
                            current = this_VxlNullConst_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1037:5: this_VxlBooleanConst_1= ruleVxlBooleanConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlBooleanConstParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue2338);
                    this_VxlBooleanConst_1=ruleVxlBooleanConst();

                    state._fsp--;

                     
                            current = this_VxlBooleanConst_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1047:5: this_VxlNumericConst_2= ruleVxlNumericConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlNumericConstParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVxlNumericConst_in_ruleVxlValue2365);
                    this_VxlNumericConst_2=ruleVxlNumericConst();

                    state._fsp--;

                     
                            current = this_VxlNumericConst_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1057:5: this_VxlStringConst_3= ruleVxlStringConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlStringConstParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVxlStringConst_in_ruleVxlValue2392);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1073:1: entryRuleVxlBooleanConst returns [EObject current=null] : iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF ;
    public final EObject entryRuleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBooleanConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1074:2: (iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1075:2: iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF
            {
             newCompositeNode(grammarAccess.getVxlBooleanConstRule()); 
            pushFollow(FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst2427);
            iv_ruleVxlBooleanConst=ruleVxlBooleanConst();

            state._fsp--;

             current =iv_ruleVxlBooleanConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlBooleanConst2437); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1082:1: ruleVxlBooleanConst returns [EObject current=null] : ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) ) ;
    public final EObject ruleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_1=null;
        Token lv_const_0_2=null;

         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1085:28: ( ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1086:1: ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1086:1: ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1087:1: ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1087:1: ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1088:1: (lv_const_0_1= 'true' | lv_const_0_2= 'false' )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1088:1: (lv_const_0_1= 'true' | lv_const_0_2= 'false' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            else if ( (LA13_0==22) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1089:3: lv_const_0_1= 'true'
                    {
                    lv_const_0_1=(Token)match(input,21,FOLLOW_21_in_ruleVxlBooleanConst2481); 

                            newLeafNode(lv_const_0_1, grammarAccess.getVxlBooleanConstAccess().getConstTrueKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVxlBooleanConstRule());
                    	        }
                           		setWithLastConsumed(current, "const", lv_const_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1101:8: lv_const_0_2= 'false'
                    {
                    lv_const_0_2=(Token)match(input,22,FOLLOW_22_in_ruleVxlBooleanConst2510); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1124:1: entryRuleVxlNullConst returns [EObject current=null] : iv_ruleVxlNullConst= ruleVxlNullConst EOF ;
    public final EObject entryRuleVxlNullConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNullConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1125:2: (iv_ruleVxlNullConst= ruleVxlNullConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1126:2: iv_ruleVxlNullConst= ruleVxlNullConst EOF
            {
             newCompositeNode(grammarAccess.getVxlNullConstRule()); 
            pushFollow(FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst2561);
            iv_ruleVxlNullConst=ruleVxlNullConst();

            state._fsp--;

             current =iv_ruleVxlNullConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNullConst2571); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1133:1: ruleVxlNullConst returns [EObject current=null] : ( (lv_const_0_0= 'null' ) ) ;
    public final EObject ruleVxlNullConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;

         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1136:28: ( ( (lv_const_0_0= 'null' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1137:1: ( (lv_const_0_0= 'null' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1137:1: ( (lv_const_0_0= 'null' ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1138:1: (lv_const_0_0= 'null' )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1138:1: (lv_const_0_0= 'null' )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1139:3: lv_const_0_0= 'null'
            {
            lv_const_0_0=(Token)match(input,23,FOLLOW_23_in_ruleVxlNullConst2613); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1160:1: entryRuleVxlNumericConst returns [EObject current=null] : iv_ruleVxlNumericConst= ruleVxlNumericConst EOF ;
    public final EObject entryRuleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNumericConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1161:2: (iv_ruleVxlNumericConst= ruleVxlNumericConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1162:2: iv_ruleVxlNumericConst= ruleVxlNumericConst EOF
            {
             newCompositeNode(grammarAccess.getVxlNumericConstRule()); 
            pushFollow(FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2661);
            iv_ruleVxlNumericConst=ruleVxlNumericConst();

            state._fsp--;

             current =iv_ruleVxlNumericConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNumericConst2671); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1169:1: ruleVxlNumericConst returns [EObject current=null] : ( (lv_const_0_0= ruleNUMERIC ) ) ;
    public final EObject ruleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_const_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1172:28: ( ( (lv_const_0_0= ruleNUMERIC ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1173:1: ( (lv_const_0_0= ruleNUMERIC ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1173:1: ( (lv_const_0_0= ruleNUMERIC ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1174:1: (lv_const_0_0= ruleNUMERIC )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1174:1: (lv_const_0_0= ruleNUMERIC )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1175:3: lv_const_0_0= ruleNUMERIC
            {
             
            	        newCompositeNode(grammarAccess.getVxlNumericConstAccess().getConstNUMERICParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2716);
            lv_const_0_0=ruleNUMERIC();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVxlNumericConstRule());
            	        }
                   		set(
                   			current, 
                   			"const",
                    		lv_const_0_0, 
                    		"NUMERIC");
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1199:1: entryRuleVxlStringConst returns [EObject current=null] : iv_ruleVxlStringConst= ruleVxlStringConst EOF ;
    public final EObject entryRuleVxlStringConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlStringConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1200:2: (iv_ruleVxlStringConst= ruleVxlStringConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1201:2: iv_ruleVxlStringConst= ruleVxlStringConst EOF
            {
             newCompositeNode(grammarAccess.getVxlStringConstRule()); 
            pushFollow(FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2751);
            iv_ruleVxlStringConst=ruleVxlStringConst();

            state._fsp--;

             current =iv_ruleVxlStringConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlStringConst2761); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1208:1: ruleVxlStringConst returns [EObject current=null] : ( (lv_const_0_0= RULE_STRING ) ) ;
    public final EObject ruleVxlStringConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;

         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1211:28: ( ( (lv_const_0_0= RULE_STRING ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1212:1: ( (lv_const_0_0= RULE_STRING ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1212:1: ( (lv_const_0_0= RULE_STRING ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1213:1: (lv_const_0_0= RULE_STRING )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1213:1: (lv_const_0_0= RULE_STRING )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1214:3: lv_const_0_0= RULE_STRING
            {
            lv_const_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVxlStringConst2802); 

            			newLeafNode(lv_const_0_0, grammarAccess.getVxlStringConstAccess().getConstSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVxlStringConstRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"const",
                    		lv_const_0_0, 
                    		"STRING");
            	    

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1238:1: entryRuleNUMERIC returns [String current=null] : iv_ruleNUMERIC= ruleNUMERIC EOF ;
    public final String entryRuleNUMERIC() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMERIC = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1239:2: (iv_ruleNUMERIC= ruleNUMERIC EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1240:2: iv_ruleNUMERIC= ruleNUMERIC EOF
            {
             newCompositeNode(grammarAccess.getNUMERICRule()); 
            pushFollow(FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2843);
            iv_ruleNUMERIC=ruleNUMERIC();

            state._fsp--;

             current =iv_ruleNUMERIC.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUMERIC2854); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1247:1: ruleNUMERIC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMERIC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1250:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1251:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1251:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1251:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2894); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_0()); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1258:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1259:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleNUMERIC2913); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNUMERICAccess().getFullStopKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2928); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1279:1: entryRuleFULLY_QUALIFIED returns [String current=null] : iv_ruleFULLY_QUALIFIED= ruleFULLY_QUALIFIED EOF ;
    public final String entryRuleFULLY_QUALIFIED() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFULLY_QUALIFIED = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1280:2: (iv_ruleFULLY_QUALIFIED= ruleFULLY_QUALIFIED EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1281:2: iv_ruleFULLY_QUALIFIED= ruleFULLY_QUALIFIED EOF
            {
             newCompositeNode(grammarAccess.getFULLY_QUALIFIEDRule()); 
            pushFollow(FOLLOW_ruleFULLY_QUALIFIED_in_entryRuleFULLY_QUALIFIED2976);
            iv_ruleFULLY_QUALIFIED=ruleFULLY_QUALIFIED();

            state._fsp--;

             current =iv_ruleFULLY_QUALIFIED.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFULLY_QUALIFIED2987); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1288:1: ruleFULLY_QUALIFIED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )? ) ;
    public final AntlrDatatypeRuleToken ruleFULLY_QUALIFIED() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_FULLY_QUALIFIED_2 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1291:28: ( (this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1292:1: (this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1292:1: (this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1292:6: this_ID_0= RULE_ID (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFULLY_QUALIFIED3027); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFULLY_QUALIFIEDAccess().getIDTerminalRuleCall_0()); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1299:1: (kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1300:2: kw= '.' this_FULLY_QUALIFIED_2= ruleFULLY_QUALIFIED
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleFULLY_QUALIFIED3046); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFULLY_QUALIFIEDAccess().getFullStopKeyword_1_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getFULLY_QUALIFIEDAccess().getFULLY_QUALIFIEDParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleFULLY_QUALIFIED_in_ruleFULLY_QUALIFIED3068);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1324:1: ruleVxlOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) ) ;
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
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1326:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1327:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1327:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) )
            int alt16=14;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt16=1;
                }
                break;
            case 25:
                {
                alt16=2;
                }
                break;
            case 26:
                {
                alt16=3;
                }
                break;
            case 27:
                {
                alt16=4;
                }
                break;
            case 28:
                {
                alt16=5;
                }
                break;
            case 29:
                {
                alt16=6;
                }
                break;
            case 30:
                {
                alt16=7;
                }
                break;
            case 14:
                {
                alt16=8;
                }
                break;
            case 31:
                {
                alt16=9;
                }
                break;
            case 32:
                {
                alt16=10;
                }
                break;
            case 33:
                {
                alt16=11;
                }
                break;
            case 34:
                {
                alt16=12;
                }
                break;
            case 35:
                {
                alt16=13;
                }
                break;
            case 36:
                {
                alt16=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1327:2: (enumLiteral_0= '<' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1327:2: (enumLiteral_0= '<' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1327:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,24,FOLLOW_24_in_ruleVxlOperator3129); 

                            current = grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1333:6: (enumLiteral_1= '<=' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1333:6: (enumLiteral_1= '<=' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1333:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,25,FOLLOW_25_in_ruleVxlOperator3146); 

                            current = grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1339:6: (enumLiteral_2= '==' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1339:6: (enumLiteral_2= '==' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1339:8: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,26,FOLLOW_26_in_ruleVxlOperator3163); 

                            current = grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1345:6: (enumLiteral_3= '!=' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1345:6: (enumLiteral_3= '!=' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1345:8: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,27,FOLLOW_27_in_ruleVxlOperator3180); 

                            current = grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1351:6: (enumLiteral_4= '>' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1351:6: (enumLiteral_4= '>' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1351:8: enumLiteral_4= '>'
                    {
                    enumLiteral_4=(Token)match(input,28,FOLLOW_28_in_ruleVxlOperator3197); 

                            current = grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1357:6: (enumLiteral_5= '>=' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1357:6: (enumLiteral_5= '>=' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1357:8: enumLiteral_5= '>='
                    {
                    enumLiteral_5=(Token)match(input,29,FOLLOW_29_in_ruleVxlOperator3214); 

                            current = grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1363:6: (enumLiteral_6= '+' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1363:6: (enumLiteral_6= '+' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1363:8: enumLiteral_6= '+'
                    {
                    enumLiteral_6=(Token)match(input,30,FOLLOW_30_in_ruleVxlOperator3231); 

                            current = grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1369:6: (enumLiteral_7= '-' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1369:6: (enumLiteral_7= '-' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1369:8: enumLiteral_7= '-'
                    {
                    enumLiteral_7=(Token)match(input,14,FOLLOW_14_in_ruleVxlOperator3248); 

                            current = grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1375:6: (enumLiteral_8= '*' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1375:6: (enumLiteral_8= '*' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1375:8: enumLiteral_8= '*'
                    {
                    enumLiteral_8=(Token)match(input,31,FOLLOW_31_in_ruleVxlOperator3265); 

                            current = grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1381:6: (enumLiteral_9= '/' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1381:6: (enumLiteral_9= '/' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1381:8: enumLiteral_9= '/'
                    {
                    enumLiteral_9=(Token)match(input,32,FOLLOW_32_in_ruleVxlOperator3282); 

                            current = grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1387:6: (enumLiteral_10= '%' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1387:6: (enumLiteral_10= '%' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1387:8: enumLiteral_10= '%'
                    {
                    enumLiteral_10=(Token)match(input,33,FOLLOW_33_in_ruleVxlOperator3299); 

                            current = grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1393:6: (enumLiteral_11= 'and' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1393:6: (enumLiteral_11= 'and' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1393:8: enumLiteral_11= 'and'
                    {
                    enumLiteral_11=(Token)match(input,34,FOLLOW_34_in_ruleVxlOperator3316); 

                            current = grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_11, grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11()); 
                        

                    }


                    }
                    break;
                case 13 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1399:6: (enumLiteral_12= 'or' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1399:6: (enumLiteral_12= 'or' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1399:8: enumLiteral_12= 'or'
                    {
                    enumLiteral_12=(Token)match(input,35,FOLLOW_35_in_ruleVxlOperator3333); 

                            current = grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_12, grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1405:6: (enumLiteral_13= '++' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1405:6: (enumLiteral_13= '++' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1405:8: enumLiteral_13= '++'
                    {
                    enumLiteral_13=(Token)match(input,36,FOLLOW_36_in_ruleVxlOperator3350); 

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
    static final String DFA2_eotS =
        "\13\uffff";
    static final String DFA2_eofS =
        "\5\uffff\1\12\5\uffff";
    static final String DFA2_minS =
        "\1\4\4\uffff\1\13\5\uffff";
    static final String DFA2_maxS =
        "\1\27\4\uffff\1\44\5\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\1\11\1\10\1\5";
    static final String DFA2_specialS =
        "\13\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\5\2\4\4\uffff\1\1\1\uffff\1\2\1\3\1\7\1\6\3\uffff\1\10\3\4",
            "",
            "",
            "",
            "",
            "\1\11\1\12\1\uffff\1\12\1\uffff\4\12\4\uffff\15\12",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "156:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality | this_VxlFunction_7= ruleVxlFunction | this_VxlConstructor_8= ruleVxlConstructor )";
        }
    }
 

    public static final BitSet FOLLOW_ruleVxlTerm_in_entryRuleVxlTerm75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlTerm85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlTerm131 = new BitSet(new long[]{0x0000001FFF004002L});
    public static final BitSet FOLLOW_ruleVxlOperator_in_ruleVxlTerm153 = new BitSet(new long[]{0x0000000000F1E870L});
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
    public static final BitSet FOLLOW_ruleVxlFunction_in_ruleVxlElement458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlConstructor_in_ruleVxlElement485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBracketTerm_in_entryRuleVxlBracketTerm520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlBracketTerm530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleVxlBracketTerm567 = new BitSet(new long[]{0x0000000000F1E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm588 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVxlBracketTerm600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNegation646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleVxlNegation683 = new BitSet(new long[]{0x0000000000F1E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlNegation704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlMinus750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlMinus787 = new BitSet(new long[]{0x0000000000F1E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlMinus808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlCardinality_in_entryRuleVxlCardinality844 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlCardinality854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVxlCardinality891 = new BitSet(new long[]{0x0000000000F1E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlCardinality912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlVariable958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlVariable1000 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlVariable1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor1063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlAccessor1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMethodAccessor_in_ruleVxlAccessor1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlArrayAccessor1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVxlArrayAccessor1256 = new BitSet(new long[]{0x0000000000F1E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1277 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVxlArrayAccessor1289 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlFieldAccessor1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVxlFieldAccessor1394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1411 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMethodAccessor_in_entryRuleVxlMethodAccessor1474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlMethodAccessor1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVxlMethodAccessor1521 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVxlFunction_in_ruleVxlMethodAccessor1542 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlMethodAccessor1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlList_in_entryRuleVxlList1600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlList1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVxlList1647 = new BitSet(new long[]{0x0000000000F3E870L});
    public static final BitSet FOLLOW_17_in_ruleVxlList1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlList1707 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVxlList1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlListElement1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlListElement1813 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVxlListElement1826 = new BitSet(new long[]{0x0000000000F3E870L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlListElement1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFunction_in_entryRuleVxlFunction1885 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlFunction1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlFunction1937 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleVxlFunction1954 = new BitSet(new long[]{0x0000000000F3F870L});
    public static final BitSet FOLLOW_12_in_ruleVxlFunction1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlFunction2014 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVxlFunction2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlConstructor_in_entryRuleVxlConstructor2064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlConstructor2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVxlConstructor2111 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFULLY_QUALIFIED_in_ruleVxlConstructor2132 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleVxlConstructor2144 = new BitSet(new long[]{0x0000000000F3F870L});
    public static final BitSet FOLLOW_12_in_ruleVxlConstructor2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlConstructor2204 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVxlConstructor2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlValue_in_entryRuleVxlValue2254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlValue2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_ruleVxlValue2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_ruleVxlValue2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_ruleVxlValue2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst2427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlBooleanConst2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVxlBooleanConst2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVxlBooleanConst2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst2561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNullConst2571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVxlNullConst2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNumericConst2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2751 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlStringConst2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVxlStringConst2802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUMERIC2854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2894 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleNUMERIC2913 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFULLY_QUALIFIED_in_entryRuleFULLY_QUALIFIED2976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFULLY_QUALIFIED2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFULLY_QUALIFIED3027 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleFULLY_QUALIFIED3046 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFULLY_QUALIFIED_in_ruleFULLY_QUALIFIED3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVxlOperator3129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVxlOperator3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVxlOperator3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVxlOperator3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVxlOperator3197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVxlOperator3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVxlOperator3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlOperator3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVxlOperator3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVxlOperator3282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVxlOperator3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleVxlOperator3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleVxlOperator3333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleVxlOperator3350 = new BitSet(new long[]{0x0000000000000002L});

}