package de.dailab.vsdt.vxl.parser.antlr.internal; 

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

import de.dailab.vsdt.vxl.services.VxlGrammarAccess;

@SuppressWarnings("all")
public class InternalVxlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'not'", "'-'", "'#'", "'['", "']'", "'.'", "','", "'true'", "'false'", "'null'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", "'+'", "'*'", "'/'", "'%'", "'and'", "'or'", "'++'"
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

            if ( (LA1_0==14||(LA1_0>=23 && LA1_0<=35)) ) {
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:152:1: ruleVxlElement returns [EObject current=null] : (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality ) ;
    public final EObject ruleVxlElement() throws RecognitionException {
        EObject current = null;

        EObject this_VxlBracketTerm_0 = null;

        EObject this_VxlNegation_1 = null;

        EObject this_VxlMinus_2 = null;

        EObject this_VxlValue_3 = null;

        EObject this_VxlVariable_4 = null;

        EObject this_VxlList_5 = null;

        EObject this_VxlCardinality_6 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:155:28: ( (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:156:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:156:1: (this_VxlBracketTerm_0= ruleVxlBracketTerm | this_VxlNegation_1= ruleVxlNegation | this_VxlMinus_2= ruleVxlMinus | this_VxlValue_3= ruleVxlValue | this_VxlVariable_4= ruleVxlVariable | this_VxlList_5= ruleVxlList | this_VxlCardinality_6= ruleVxlCardinality )
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
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:233:1: entryRuleVxlBracketTerm returns [EObject current=null] : iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF ;
    public final EObject entryRuleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBracketTerm = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:234:2: (iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:235:2: iv_ruleVxlBracketTerm= ruleVxlBracketTerm EOF
            {
             newCompositeNode(grammarAccess.getVxlBracketTermRule()); 
            pushFollow(FOLLOW_ruleVxlBracketTerm_in_entryRuleVxlBracketTerm466);
            iv_ruleVxlBracketTerm=ruleVxlBracketTerm();

            state._fsp--;

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
    // $ANTLR end "entryRuleVxlBracketTerm"


    // $ANTLR start "ruleVxlBracketTerm"
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:242:1: ruleVxlBracketTerm returns [EObject current=null] : (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' ) ;
    public final EObject ruleVxlBracketTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_term_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:245:28: ( (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:246:1: (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:246:1: (otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')' )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:246:3: otherlv_0= '(' ( (lv_term_1_0= ruleVxlTerm ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleVxlBracketTerm513); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlBracketTermAccess().getLeftParenthesisKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:250:1: ( (lv_term_1_0= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:251:1: (lv_term_1_0= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:251:1: (lv_term_1_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:252:3: lv_term_1_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlBracketTermAccess().getTermVxlTermParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm534);
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

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleVxlBracketTerm546); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:280:1: entryRuleVxlNegation returns [EObject current=null] : iv_ruleVxlNegation= ruleVxlNegation EOF ;
    public final EObject entryRuleVxlNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNegation = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:281:2: (iv_ruleVxlNegation= ruleVxlNegation EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:282:2: iv_ruleVxlNegation= ruleVxlNegation EOF
            {
             newCompositeNode(grammarAccess.getVxlNegationRule()); 
            pushFollow(FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation582);
            iv_ruleVxlNegation=ruleVxlNegation();

            state._fsp--;

             current =iv_ruleVxlNegation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNegation592); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:289:1: ruleVxlNegation returns [EObject current=null] : (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlNegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_element_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:292:28: ( (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:293:1: (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:293:1: (otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:293:3: otherlv_0= 'not' ( (lv_element_1_0= ruleVxlElement ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleVxlNegation629); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlNegationAccess().getNotKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:297:1: ( (lv_element_1_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:298:1: (lv_element_1_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:298:1: (lv_element_1_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:299:3: lv_element_1_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlNegationAccess().getElementVxlElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlNegation650);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:323:1: entryRuleVxlMinus returns [EObject current=null] : iv_ruleVxlMinus= ruleVxlMinus EOF ;
    public final EObject entryRuleVxlMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlMinus = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:324:2: (iv_ruleVxlMinus= ruleVxlMinus EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:325:2: iv_ruleVxlMinus= ruleVxlMinus EOF
            {
             newCompositeNode(grammarAccess.getVxlMinusRule()); 
            pushFollow(FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus686);
            iv_ruleVxlMinus=ruleVxlMinus();

            state._fsp--;

             current =iv_ruleVxlMinus; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlMinus696); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:332:1: ruleVxlMinus returns [EObject current=null] : (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_element_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:335:28: ( (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:336:1: (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:336:1: (otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:336:3: otherlv_0= '-' ( (lv_element_1_0= ruleVxlElement ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleVxlMinus733); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlMinusAccess().getHyphenMinusKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:340:1: ( (lv_element_1_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:341:1: (lv_element_1_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:341:1: (lv_element_1_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:342:3: lv_element_1_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlMinusAccess().getElementVxlElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlMinus754);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:366:1: entryRuleVxlCardinality returns [EObject current=null] : iv_ruleVxlCardinality= ruleVxlCardinality EOF ;
    public final EObject entryRuleVxlCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlCardinality = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:367:2: (iv_ruleVxlCardinality= ruleVxlCardinality EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:368:2: iv_ruleVxlCardinality= ruleVxlCardinality EOF
            {
             newCompositeNode(grammarAccess.getVxlCardinalityRule()); 
            pushFollow(FOLLOW_ruleVxlCardinality_in_entryRuleVxlCardinality790);
            iv_ruleVxlCardinality=ruleVxlCardinality();

            state._fsp--;

             current =iv_ruleVxlCardinality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlCardinality800); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:375:1: ruleVxlCardinality returns [EObject current=null] : (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) ) ;
    public final EObject ruleVxlCardinality() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_element_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:378:28: ( (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:379:1: (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:379:1: (otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:379:3: otherlv_0= '#' ( (lv_element_1_0= ruleVxlElement ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleVxlCardinality837); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlCardinalityAccess().getNumberSignKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:383:1: ( (lv_element_1_0= ruleVxlElement ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:384:1: (lv_element_1_0= ruleVxlElement )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:384:1: (lv_element_1_0= ruleVxlElement )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:385:3: lv_element_1_0= ruleVxlElement
            {
             
            	        newCompositeNode(grammarAccess.getVxlCardinalityAccess().getElementVxlElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlElement_in_ruleVxlCardinality858);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:409:1: entryRuleVxlVariable returns [EObject current=null] : iv_ruleVxlVariable= ruleVxlVariable EOF ;
    public final EObject entryRuleVxlVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlVariable = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:410:2: (iv_ruleVxlVariable= ruleVxlVariable EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:411:2: iv_ruleVxlVariable= ruleVxlVariable EOF
            {
             newCompositeNode(grammarAccess.getVxlVariableRule()); 
            pushFollow(FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable894);
            iv_ruleVxlVariable=ruleVxlVariable();

            state._fsp--;

             current =iv_ruleVxlVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlVariable904); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:418:1: ruleVxlVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_accessor_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:421:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:422:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:422:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:422:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_accessor_1_0= ruleVxlAccessor ) )?
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:422:2: ( (lv_name_0_0= RULE_ID ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:423:1: (lv_name_0_0= RULE_ID )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:423:1: (lv_name_0_0= RULE_ID )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:424:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlVariable946); 

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

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:440:2: ( (lv_accessor_1_0= ruleVxlAccessor ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16||LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:441:1: (lv_accessor_1_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:441:1: (lv_accessor_1_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:442:3: lv_accessor_1_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlVariableAccess().getAccessorVxlAccessorParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlVariable972);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:466:1: entryRuleVxlAccessor returns [EObject current=null] : iv_ruleVxlAccessor= ruleVxlAccessor EOF ;
    public final EObject entryRuleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:467:2: (iv_ruleVxlAccessor= ruleVxlAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:468:2: iv_ruleVxlAccessor= ruleVxlAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlAccessorRule()); 
            pushFollow(FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor1009);
            iv_ruleVxlAccessor=ruleVxlAccessor();

            state._fsp--;

             current =iv_ruleVxlAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlAccessor1019); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:475:1: ruleVxlAccessor returns [EObject current=null] : (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor ) ;
    public final EObject ruleVxlAccessor() throws RecognitionException {
        EObject current = null;

        EObject this_VxlArrayAccessor_0 = null;

        EObject this_VxlFieldAccessor_1 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:478:28: ( (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:479:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:479:1: (this_VxlArrayAccessor_0= ruleVxlArrayAccessor | this_VxlFieldAccessor_1= ruleVxlFieldAccessor )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:480:5: this_VxlArrayAccessor_0= ruleVxlArrayAccessor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlArrayAccessorParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1066);
                    this_VxlArrayAccessor_0=ruleVxlArrayAccessor();

                    state._fsp--;

                     
                            current = this_VxlArrayAccessor_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:490:5: this_VxlFieldAccessor_1= ruleVxlFieldAccessor
                    {
                     
                            newCompositeNode(grammarAccess.getVxlAccessorAccess().getVxlFieldAccessorParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1093);
                    this_VxlFieldAccessor_1=ruleVxlFieldAccessor();

                    state._fsp--;

                     
                            current = this_VxlFieldAccessor_1; 
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:506:1: entryRuleVxlArrayAccessor returns [EObject current=null] : iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF ;
    public final EObject entryRuleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlArrayAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:507:2: (iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:508:2: iv_ruleVxlArrayAccessor= ruleVxlArrayAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlArrayAccessorRule()); 
            pushFollow(FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1128);
            iv_ruleVxlArrayAccessor=ruleVxlArrayAccessor();

            state._fsp--;

             current =iv_ruleVxlArrayAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlArrayAccessor1138); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:515:1: ruleVxlArrayAccessor returns [EObject current=null] : (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlArrayAccessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_index_1_0 = null;

        EObject lv_accessor_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:518:28: ( (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:519:1: (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:519:1: (otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:519:3: otherlv_0= '[' ( (lv_index_1_0= ruleVxlTerm ) ) otherlv_2= ']' ( (lv_accessor_3_0= ruleVxlAccessor ) )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVxlArrayAccessor1175); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlArrayAccessorAccess().getLeftSquareBracketKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:523:1: ( (lv_index_1_0= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:524:1: (lv_index_1_0= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:524:1: (lv_index_1_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:525:3: lv_index_1_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getIndexVxlTermParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1196);
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

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleVxlArrayAccessor1208); 

                	newLeafNode(otherlv_2, grammarAccess.getVxlArrayAccessorAccess().getRightSquareBracketKeyword_2());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:545:1: ( (lv_accessor_3_0= ruleVxlAccessor ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16||LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:546:1: (lv_accessor_3_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:546:1: (lv_accessor_3_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:547:3: lv_accessor_3_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlArrayAccessorAccess().getAccessorVxlAccessorParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1229);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:571:1: entryRuleVxlFieldAccessor returns [EObject current=null] : iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF ;
    public final EObject entryRuleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlFieldAccessor = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:572:2: (iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:573:2: iv_ruleVxlFieldAccessor= ruleVxlFieldAccessor EOF
            {
             newCompositeNode(grammarAccess.getVxlFieldAccessorRule()); 
            pushFollow(FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1266);
            iv_ruleVxlFieldAccessor=ruleVxlFieldAccessor();

            state._fsp--;

             current =iv_ruleVxlFieldAccessor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlFieldAccessor1276); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:580:1: ruleVxlFieldAccessor returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) ;
    public final EObject ruleVxlFieldAccessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_accessor_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:583:28: ( (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:584:1: (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:584:1: (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:584:3: otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleVxlFieldAccessor1313); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlFieldAccessorAccess().getFullStopKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:588:1: ( (lv_name_1_0= RULE_ID ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:589:1: (lv_name_1_0= RULE_ID )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:589:1: (lv_name_1_0= RULE_ID )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:590:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1330); 

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

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:606:2: ( (lv_accessor_2_0= ruleVxlAccessor ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16||LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:607:1: (lv_accessor_2_0= ruleVxlAccessor )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:607:1: (lv_accessor_2_0= ruleVxlAccessor )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:608:3: lv_accessor_2_0= ruleVxlAccessor
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlFieldAccessorAccess().getAccessorVxlAccessorParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1356);
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


    // $ANTLR start "entryRuleVxlList"
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:632:1: entryRuleVxlList returns [EObject current=null] : iv_ruleVxlList= ruleVxlList EOF ;
    public final EObject entryRuleVxlList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlList = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:633:2: (iv_ruleVxlList= ruleVxlList EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:634:2: iv_ruleVxlList= ruleVxlList EOF
            {
             newCompositeNode(grammarAccess.getVxlListRule()); 
            pushFollow(FOLLOW_ruleVxlList_in_entryRuleVxlList1393);
            iv_ruleVxlList=ruleVxlList();

            state._fsp--;

             current =iv_ruleVxlList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlList1403); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:641:1: ruleVxlList returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) ) ;
    public final EObject ruleVxlList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_empty_1_0=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:644:28: ( (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:645:1: (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:645:1: (otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:645:3: otherlv_0= '[' ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVxlList1440); 

                	newLeafNode(otherlv_0, grammarAccess.getVxlListAccess().getLeftSquareBracketKeyword_0());
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:649:1: ( ( (lv_empty_1_0= ']' ) ) | ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' ) )
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
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:649:2: ( (lv_empty_1_0= ']' ) )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:649:2: ( (lv_empty_1_0= ']' ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:650:1: (lv_empty_1_0= ']' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:650:1: (lv_empty_1_0= ']' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:651:3: lv_empty_1_0= ']'
                    {
                    lv_empty_1_0=(Token)match(input,17,FOLLOW_17_in_ruleVxlList1459); 

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
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:665:6: ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:665:6: ( ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:665:7: ( (lv_body_2_0= ruleVxlListElement ) ) otherlv_3= ']'
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:665:7: ( (lv_body_2_0= ruleVxlListElement ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:666:1: (lv_body_2_0= ruleVxlListElement )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:666:1: (lv_body_2_0= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:667:3: lv_body_2_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlListAccess().getBodyVxlListElementParserRuleCall_1_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlList1500);
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

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleVxlList1512); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:695:1: entryRuleVxlListElement returns [EObject current=null] : iv_ruleVxlListElement= ruleVxlListElement EOF ;
    public final EObject entryRuleVxlListElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlListElement = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:696:2: (iv_ruleVxlListElement= ruleVxlListElement EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:697:2: iv_ruleVxlListElement= ruleVxlListElement EOF
            {
             newCompositeNode(grammarAccess.getVxlListElementRule()); 
            pushFollow(FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1550);
            iv_ruleVxlListElement=ruleVxlListElement();

            state._fsp--;

             current =iv_ruleVxlListElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlListElement1560); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:704:1: ruleVxlListElement returns [EObject current=null] : ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? ) ;
    public final EObject ruleVxlListElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_first_0_0 = null;

        EObject lv_rest_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:707:28: ( ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:708:1: ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:708:1: ( ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:708:2: ( (lv_first_0_0= ruleVxlTerm ) ) (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )?
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:708:2: ( (lv_first_0_0= ruleVxlTerm ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:709:1: (lv_first_0_0= ruleVxlTerm )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:709:1: (lv_first_0_0= ruleVxlTerm )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:710:3: lv_first_0_0= ruleVxlTerm
            {
             
            	        newCompositeNode(grammarAccess.getVxlListElementAccess().getFirstVxlTermParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVxlTerm_in_ruleVxlListElement1606);
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

            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:726:2: (otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:726:4: otherlv_1= ',' ( (lv_rest_2_0= ruleVxlListElement ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleVxlListElement1619); 

                        	newLeafNode(otherlv_1, grammarAccess.getVxlListElementAccess().getCommaKeyword_1_0());
                        
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:730:1: ( (lv_rest_2_0= ruleVxlListElement ) )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:731:1: (lv_rest_2_0= ruleVxlListElement )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:731:1: (lv_rest_2_0= ruleVxlListElement )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:732:3: lv_rest_2_0= ruleVxlListElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getVxlListElementAccess().getRestVxlListElementParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVxlListElement_in_ruleVxlListElement1640);
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


    // $ANTLR start "entryRuleVxlValue"
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:756:1: entryRuleVxlValue returns [EObject current=null] : iv_ruleVxlValue= ruleVxlValue EOF ;
    public final EObject entryRuleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlValue = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:757:2: (iv_ruleVxlValue= ruleVxlValue EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:758:2: iv_ruleVxlValue= ruleVxlValue EOF
            {
             newCompositeNode(grammarAccess.getVxlValueRule()); 
            pushFollow(FOLLOW_ruleVxlValue_in_entryRuleVxlValue1678);
            iv_ruleVxlValue=ruleVxlValue();

            state._fsp--;

             current =iv_ruleVxlValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlValue1688); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:765:1: ruleVxlValue returns [EObject current=null] : (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) ;
    public final EObject ruleVxlValue() throws RecognitionException {
        EObject current = null;

        EObject this_VxlNullConst_0 = null;

        EObject this_VxlBooleanConst_1 = null;

        EObject this_VxlNumericConst_2 = null;

        EObject this_VxlStringConst_3 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:768:28: ( (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:769:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:769:1: (this_VxlNullConst_0= ruleVxlNullConst | this_VxlBooleanConst_1= ruleVxlBooleanConst | this_VxlNumericConst_2= ruleVxlNumericConst | this_VxlStringConst_3= ruleVxlStringConst )
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
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:770:5: this_VxlNullConst_0= ruleVxlNullConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlNullConstParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVxlNullConst_in_ruleVxlValue1735);
                    this_VxlNullConst_0=ruleVxlNullConst();

                    state._fsp--;

                     
                            current = this_VxlNullConst_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:780:5: this_VxlBooleanConst_1= ruleVxlBooleanConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlBooleanConstParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue1762);
                    this_VxlBooleanConst_1=ruleVxlBooleanConst();

                    state._fsp--;

                     
                            current = this_VxlBooleanConst_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:790:5: this_VxlNumericConst_2= ruleVxlNumericConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlNumericConstParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVxlNumericConst_in_ruleVxlValue1789);
                    this_VxlNumericConst_2=ruleVxlNumericConst();

                    state._fsp--;

                     
                            current = this_VxlNumericConst_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:800:5: this_VxlStringConst_3= ruleVxlStringConst
                    {
                     
                            newCompositeNode(grammarAccess.getVxlValueAccess().getVxlStringConstParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVxlStringConst_in_ruleVxlValue1816);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:816:1: entryRuleVxlBooleanConst returns [EObject current=null] : iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF ;
    public final EObject entryRuleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlBooleanConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:817:2: (iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:818:2: iv_ruleVxlBooleanConst= ruleVxlBooleanConst EOF
            {
             newCompositeNode(grammarAccess.getVxlBooleanConstRule()); 
            pushFollow(FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst1851);
            iv_ruleVxlBooleanConst=ruleVxlBooleanConst();

            state._fsp--;

             current =iv_ruleVxlBooleanConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlBooleanConst1861); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:825:1: ruleVxlBooleanConst returns [EObject current=null] : ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) ) ;
    public final EObject ruleVxlBooleanConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_1=null;
        Token lv_const_0_2=null;

         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:828:28: ( ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:829:1: ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:829:1: ( ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:830:1: ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:830:1: ( (lv_const_0_1= 'true' | lv_const_0_2= 'false' ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:831:1: (lv_const_0_1= 'true' | lv_const_0_2= 'false' )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:831:1: (lv_const_0_1= 'true' | lv_const_0_2= 'false' )
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
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:832:3: lv_const_0_1= 'true'
                    {
                    lv_const_0_1=(Token)match(input,20,FOLLOW_20_in_ruleVxlBooleanConst1905); 

                            newLeafNode(lv_const_0_1, grammarAccess.getVxlBooleanConstAccess().getConstTrueKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVxlBooleanConstRule());
                    	        }
                           		setWithLastConsumed(current, "const", lv_const_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:844:8: lv_const_0_2= 'false'
                    {
                    lv_const_0_2=(Token)match(input,21,FOLLOW_21_in_ruleVxlBooleanConst1934); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:867:1: entryRuleVxlNullConst returns [EObject current=null] : iv_ruleVxlNullConst= ruleVxlNullConst EOF ;
    public final EObject entryRuleVxlNullConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNullConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:868:2: (iv_ruleVxlNullConst= ruleVxlNullConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:869:2: iv_ruleVxlNullConst= ruleVxlNullConst EOF
            {
             newCompositeNode(grammarAccess.getVxlNullConstRule()); 
            pushFollow(FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst1985);
            iv_ruleVxlNullConst=ruleVxlNullConst();

            state._fsp--;

             current =iv_ruleVxlNullConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNullConst1995); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:876:1: ruleVxlNullConst returns [EObject current=null] : ( (lv_const_0_0= 'null' ) ) ;
    public final EObject ruleVxlNullConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;

         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:879:28: ( ( (lv_const_0_0= 'null' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:880:1: ( (lv_const_0_0= 'null' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:880:1: ( (lv_const_0_0= 'null' ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:881:1: (lv_const_0_0= 'null' )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:881:1: (lv_const_0_0= 'null' )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:882:3: lv_const_0_0= 'null'
            {
            lv_const_0_0=(Token)match(input,22,FOLLOW_22_in_ruleVxlNullConst2037); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:903:1: entryRuleVxlNumericConst returns [EObject current=null] : iv_ruleVxlNumericConst= ruleVxlNumericConst EOF ;
    public final EObject entryRuleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlNumericConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:904:2: (iv_ruleVxlNumericConst= ruleVxlNumericConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:905:2: iv_ruleVxlNumericConst= ruleVxlNumericConst EOF
            {
             newCompositeNode(grammarAccess.getVxlNumericConstRule()); 
            pushFollow(FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2085);
            iv_ruleVxlNumericConst=ruleVxlNumericConst();

            state._fsp--;

             current =iv_ruleVxlNumericConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlNumericConst2095); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:912:1: ruleVxlNumericConst returns [EObject current=null] : ( (lv_const_0_0= ruleNUMERIC ) ) ;
    public final EObject ruleVxlNumericConst() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_const_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:915:28: ( ( (lv_const_0_0= ruleNUMERIC ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:916:1: ( (lv_const_0_0= ruleNUMERIC ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:916:1: ( (lv_const_0_0= ruleNUMERIC ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:917:1: (lv_const_0_0= ruleNUMERIC )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:917:1: (lv_const_0_0= ruleNUMERIC )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:918:3: lv_const_0_0= ruleNUMERIC
            {
             
            	        newCompositeNode(grammarAccess.getVxlNumericConstAccess().getConstNUMERICParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2140);
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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:942:1: entryRuleVxlStringConst returns [EObject current=null] : iv_ruleVxlStringConst= ruleVxlStringConst EOF ;
    public final EObject entryRuleVxlStringConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVxlStringConst = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:943:2: (iv_ruleVxlStringConst= ruleVxlStringConst EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:944:2: iv_ruleVxlStringConst= ruleVxlStringConst EOF
            {
             newCompositeNode(grammarAccess.getVxlStringConstRule()); 
            pushFollow(FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2175);
            iv_ruleVxlStringConst=ruleVxlStringConst();

            state._fsp--;

             current =iv_ruleVxlStringConst; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVxlStringConst2185); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:951:1: ruleVxlStringConst returns [EObject current=null] : ( (lv_const_0_0= RULE_STRING ) ) ;
    public final EObject ruleVxlStringConst() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;

         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:954:28: ( ( (lv_const_0_0= RULE_STRING ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:955:1: ( (lv_const_0_0= RULE_STRING ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:955:1: ( (lv_const_0_0= RULE_STRING ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:956:1: (lv_const_0_0= RULE_STRING )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:956:1: (lv_const_0_0= RULE_STRING )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:957:3: lv_const_0_0= RULE_STRING
            {
            lv_const_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVxlStringConst2226); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:981:1: entryRuleNUMERIC returns [String current=null] : iv_ruleNUMERIC= ruleNUMERIC EOF ;
    public final String entryRuleNUMERIC() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMERIC = null;


        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:982:2: (iv_ruleNUMERIC= ruleNUMERIC EOF )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:983:2: iv_ruleNUMERIC= ruleNUMERIC EOF
            {
             newCompositeNode(grammarAccess.getNUMERICRule()); 
            pushFollow(FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2267);
            iv_ruleNUMERIC=ruleNUMERIC();

            state._fsp--;

             current =iv_ruleNUMERIC.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUMERIC2278); 

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
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:990:1: ruleNUMERIC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMERIC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:993:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:994:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:994:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:994:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2318); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getNUMERICAccess().getINTTerminalRuleCall_0()); 
                
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1001:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1002:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleNUMERIC2337); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNUMERICAccess().getFullStopKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMERIC2352); 

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


    // $ANTLR start "ruleVxlOperator"
    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1022:1: ruleVxlOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) ) ;
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
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1024:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) ) )
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1025:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) )
            {
            // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1025:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>' ) | (enumLiteral_5= '>=' ) | (enumLiteral_6= '+' ) | (enumLiteral_7= '-' ) | (enumLiteral_8= '*' ) | (enumLiteral_9= '/' ) | (enumLiteral_10= '%' ) | (enumLiteral_11= 'and' ) | (enumLiteral_12= 'or' ) | (enumLiteral_13= '++' ) )
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
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1025:2: (enumLiteral_0= '<' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1025:2: (enumLiteral_0= '<' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1025:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,23,FOLLOW_23_in_ruleVxlOperator2413); 

                            current = grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVxlOperatorAccess().getLTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1031:6: (enumLiteral_1= '<=' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1031:6: (enumLiteral_1= '<=' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1031:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,24,FOLLOW_24_in_ruleVxlOperator2430); 

                            current = grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVxlOperatorAccess().getLEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1037:6: (enumLiteral_2= '==' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1037:6: (enumLiteral_2= '==' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1037:8: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,25,FOLLOW_25_in_ruleVxlOperator2447); 

                            current = grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVxlOperatorAccess().getEQEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1043:6: (enumLiteral_3= '!=' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1043:6: (enumLiteral_3= '!=' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1043:8: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,26,FOLLOW_26_in_ruleVxlOperator2464); 

                            current = grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVxlOperatorAccess().getNEQEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1049:6: (enumLiteral_4= '>' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1049:6: (enumLiteral_4= '>' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1049:8: enumLiteral_4= '>'
                    {
                    enumLiteral_4=(Token)match(input,27,FOLLOW_27_in_ruleVxlOperator2481); 

                            current = grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getVxlOperatorAccess().getGTEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1055:6: (enumLiteral_5= '>=' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1055:6: (enumLiteral_5= '>=' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1055:8: enumLiteral_5= '>='
                    {
                    enumLiteral_5=(Token)match(input,28,FOLLOW_28_in_ruleVxlOperator2498); 

                            current = grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getVxlOperatorAccess().getGEEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1061:6: (enumLiteral_6= '+' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1061:6: (enumLiteral_6= '+' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1061:8: enumLiteral_6= '+'
                    {
                    enumLiteral_6=(Token)match(input,29,FOLLOW_29_in_ruleVxlOperator2515); 

                            current = grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getVxlOperatorAccess().getADDEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1067:6: (enumLiteral_7= '-' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1067:6: (enumLiteral_7= '-' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1067:8: enumLiteral_7= '-'
                    {
                    enumLiteral_7=(Token)match(input,14,FOLLOW_14_in_ruleVxlOperator2532); 

                            current = grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getVxlOperatorAccess().getSUBEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1073:6: (enumLiteral_8= '*' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1073:6: (enumLiteral_8= '*' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1073:8: enumLiteral_8= '*'
                    {
                    enumLiteral_8=(Token)match(input,30,FOLLOW_30_in_ruleVxlOperator2549); 

                            current = grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getVxlOperatorAccess().getMULTEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1079:6: (enumLiteral_9= '/' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1079:6: (enumLiteral_9= '/' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1079:8: enumLiteral_9= '/'
                    {
                    enumLiteral_9=(Token)match(input,31,FOLLOW_31_in_ruleVxlOperator2566); 

                            current = grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getVxlOperatorAccess().getDIVEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1085:6: (enumLiteral_10= '%' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1085:6: (enumLiteral_10= '%' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1085:8: enumLiteral_10= '%'
                    {
                    enumLiteral_10=(Token)match(input,32,FOLLOW_32_in_ruleVxlOperator2583); 

                            current = grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getVxlOperatorAccess().getMODEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1091:6: (enumLiteral_11= 'and' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1091:6: (enumLiteral_11= 'and' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1091:8: enumLiteral_11= 'and'
                    {
                    enumLiteral_11=(Token)match(input,33,FOLLOW_33_in_ruleVxlOperator2600); 

                            current = grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_11, grammarAccess.getVxlOperatorAccess().getANDEnumLiteralDeclaration_11()); 
                        

                    }


                    }
                    break;
                case 13 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1097:6: (enumLiteral_12= 'or' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1097:6: (enumLiteral_12= 'or' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1097:8: enumLiteral_12= 'or'
                    {
                    enumLiteral_12=(Token)match(input,34,FOLLOW_34_in_ruleVxlOperator2617); 

                            current = grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_12, grammarAccess.getVxlOperatorAccess().getOREnumLiteralDeclaration_12()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1103:6: (enumLiteral_13= '++' )
                    {
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1103:6: (enumLiteral_13= '++' )
                    // ../de.dailab.vsdt.vxl2/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1103:8: enumLiteral_13= '++'
                    {
                    enumLiteral_13=(Token)match(input,35,FOLLOW_35_in_ruleVxlOperator2634); 

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
    public static final BitSet FOLLOW_11_in_ruleVxlBracketTerm513 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlBracketTerm534 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVxlBracketTerm546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNegation_in_entryRuleVxlNegation582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNegation592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleVxlNegation629 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlNegation650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlMinus_in_entryRuleVxlMinus686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlMinus696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlMinus733 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlMinus754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlCardinality_in_entryRuleVxlCardinality790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlCardinality800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVxlCardinality837 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlElement_in_ruleVxlCardinality858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlVariable_in_entryRuleVxlVariable894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlVariable904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlVariable946 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlVariable972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_entryRuleVxlAccessor1009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlAccessor1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_ruleVxlAccessor1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_ruleVxlAccessor1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlArrayAccessor_in_entryRuleVxlArrayAccessor1128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlArrayAccessor1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVxlArrayAccessor1175 = new BitSet(new long[]{0x000000000071E870L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlArrayAccessor1196 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVxlArrayAccessor1208 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlArrayAccessor1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlFieldAccessor_in_entryRuleVxlFieldAccessor1266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlFieldAccessor1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVxlFieldAccessor1313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVxlFieldAccessor1330 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleVxlAccessor_in_ruleVxlFieldAccessor1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlList_in_entryRuleVxlList1393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlList1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVxlList1440 = new BitSet(new long[]{0x000000000073E870L});
    public static final BitSet FOLLOW_17_in_ruleVxlList1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlList1500 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVxlList1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_entryRuleVxlListElement1550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlListElement1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlTerm_in_ruleVxlListElement1606 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVxlListElement1619 = new BitSet(new long[]{0x000000000073E870L});
    public static final BitSet FOLLOW_ruleVxlListElement_in_ruleVxlListElement1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlValue_in_entryRuleVxlValue1678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlValue1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_ruleVxlValue1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_ruleVxlValue1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_ruleVxlValue1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_ruleVxlValue1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlBooleanConst_in_entryRuleVxlBooleanConst1851 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlBooleanConst1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVxlBooleanConst1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVxlBooleanConst1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNullConst_in_entryRuleVxlNullConst1985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNullConst1995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVxlNullConst2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlNumericConst_in_entryRuleVxlNumericConst2085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlNumericConst2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_ruleVxlNumericConst2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVxlStringConst_in_entryRuleVxlStringConst2175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVxlStringConst2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVxlStringConst2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUMERIC2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2318 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleNUMERIC2337 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVxlOperator2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVxlOperator2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVxlOperator2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVxlOperator2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVxlOperator2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVxlOperator2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVxlOperator2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVxlOperator2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVxlOperator2549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVxlOperator2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVxlOperator2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVxlOperator2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleVxlOperator2617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleVxlOperator2634 = new BitSet(new long[]{0x0000000000000002L});

}