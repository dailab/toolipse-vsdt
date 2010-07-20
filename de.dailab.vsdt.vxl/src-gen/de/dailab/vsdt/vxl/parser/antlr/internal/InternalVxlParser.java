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
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT",
			"RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER",
			"'('", "')'", "'not'", "'-'", "'['", "']'", "'.'", "'true'",
			"'false'", "'null'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='",
			"'+'", "'*'", "'/'", "'%'", "'and'", "'or'", "'++'" };
	public static final int RULE_ID = 4;
	public static final int RULE_STRING = 5;
	public static final int RULE_ANY_OTHER = 10;
	public static final int RULE_INT = 6;
	public static final int RULE_WS = 9;
	public static final int RULE_SL_COMMENT = 8;
	public static final int EOF = -1;
	public static final int RULE_ML_COMMENT = 7;

	public InternalVxlParser(TokenStream input) {
		super(input);
	}

	public String[] getTokenNames() {
		return tokenNames;
	}

	public String getGrammarFileName() {
		return "../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g";
	}

	private VxlGrammarAccess grammarAccess;

	public InternalVxlParser(TokenStream input, IAstFactory factory,
			VxlGrammarAccess grammarAccess) {
		this(input);
		this.factory = factory;
		registerRules(grammarAccess.getGrammar());
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected InputStream getTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader
				.getResourceAsStream("de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.tokens");
	}

	@Override
	protected String getFirstRuleName() {
		return "Term";
	}

	// $ANTLR start entryRuleTerm
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:73:1:
	// entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF
	// ;
	public final EObject entryRuleTerm() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTerm = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:73:46:
			// (iv_ruleTerm= ruleTerm EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:74:2:
			// iv_ruleTerm= ruleTerm EOF
			{
				currentNode = createCompositeNode(grammarAccess.getTermRule(),
						currentNode);
				pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm73);
				iv_ruleTerm = ruleTerm();
				_fsp--;

				current = iv_ruleTerm;
				match(input, EOF, FOLLOW_EOF_in_entryRuleTerm83);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleTerm

	// $ANTLR start ruleTerm
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:81:1:
	// ruleTerm returns [EObject current=null] : ( (lv_head_0= ruleHead )
	// (lv_tail_1= ruleTail )? ) ;
	public final EObject ruleTerm() throws RecognitionException {
		EObject current = null;

		EObject lv_head_0 = null;

		EObject lv_tail_1 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:86:6:
			// ( ( (lv_head_0= ruleHead ) (lv_tail_1= ruleTail )? ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:1:
			// ( (lv_head_0= ruleHead ) (lv_tail_1= ruleTail )? )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:1:
				// ( (lv_head_0= ruleHead ) (lv_tail_1= ruleTail )? )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:2:
				// (lv_head_0= ruleHead ) (lv_tail_1= ruleTail )?
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:87:2:
					// (lv_head_0= ruleHead )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:90:6:
					// lv_head_0= ruleHead
					{

						currentNode = createCompositeNode(grammarAccess
								.getTermAccess()
								.getHeadHeadParserRuleCall_0_0(), currentNode);

						pushFollow(FOLLOW_ruleHead_in_ruleTerm142);
						lv_head_0 = ruleHead();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getTermRule().getType().getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
						}

						try {
							set(current, "head", lv_head_0, "Head", currentNode);
						} catch (ValueConverterException vce) {
							handleValueConverterException(vce);
						}
						currentNode = currentNode.getParent();

					}

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:108:2:
					// (lv_tail_1= ruleTail )?
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == 14 || (LA1_0 >= 21 && LA1_0 <= 33))) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
						// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:111:6:
						// lv_tail_1= ruleTail
					{

						currentNode = createCompositeNode(grammarAccess
								.getTermAccess()
								.getTailTailParserRuleCall_1_0(), currentNode);

						pushFollow(FOLLOW_ruleTail_in_ruleTerm180);
						lv_tail_1 = ruleTail();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getTermRule().getType().getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
						}

						try {
							set(current, "tail", lv_tail_1, "Tail", currentNode);
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
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleTerm

	// $ANTLR start entryRuleHead
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:136:1:
	// entryRuleHead returns [EObject current=null] : iv_ruleHead= ruleHead EOF
	// ;
	public final EObject entryRuleHead() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleHead = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:136:46:
			// (iv_ruleHead= ruleHead EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:137:2:
			// iv_ruleHead= ruleHead EOF
			{
				currentNode = createCompositeNode(grammarAccess.getHeadRule(),
						currentNode);
				pushFollow(FOLLOW_ruleHead_in_entryRuleHead218);
				iv_ruleHead = ruleHead();
				_fsp--;

				current = iv_ruleHead;
				match(input, EOF, FOLLOW_EOF_in_entryRuleHead228);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleHead

	// $ANTLR start ruleHead
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:144:1:
	// ruleHead returns [EObject current=null] : (this_BracketTerm_0=
	// ruleBracketTerm | this_Negation_1= ruleNegation | this_Minus_2= ruleMinus
	// | this_Atom_3= ruleAtom ) ;
	public final EObject ruleHead() throws RecognitionException {
		EObject current = null;

		EObject this_BracketTerm_0 = null;

		EObject this_Negation_1 = null;

		EObject this_Minus_2 = null;

		EObject this_Atom_3 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:149:6:
			// ( (this_BracketTerm_0= ruleBracketTerm | this_Negation_1=
			// ruleNegation | this_Minus_2= ruleMinus | this_Atom_3= ruleAtom )
			// )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:150:1:
			// (this_BracketTerm_0= ruleBracketTerm | this_Negation_1=
			// ruleNegation | this_Minus_2= ruleMinus | this_Atom_3= ruleAtom )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:150:1:
				// (this_BracketTerm_0= ruleBracketTerm | this_Negation_1=
				// ruleNegation | this_Minus_2= ruleMinus | this_Atom_3=
				// ruleAtom )
				int alt2 = 4;
				switch (input.LA(1)) {
				case 11: {
					alt2 = 1;
				}
					break;
				case 13: {
					alt2 = 2;
				}
					break;
				case 14: {
					alt2 = 3;
				}
					break;
				case RULE_ID:
				case RULE_STRING:
				case RULE_INT:
				case 18:
				case 19:
				case 20: {
					alt2 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException(
							"150:1: (this_BracketTerm_0= ruleBracketTerm | this_Negation_1= ruleNegation | this_Minus_2= ruleMinus | this_Atom_3= ruleAtom )",
							2, 0, input);

					throw nvae;
				}

				switch (alt2) {
				case 1:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:151:5:
					// this_BracketTerm_0= ruleBracketTerm
				{

					currentNode = createCompositeNode(grammarAccess
							.getHeadAccess().getBracketTermParserRuleCall_0(),
							currentNode);

					pushFollow(FOLLOW_ruleBracketTerm_in_ruleHead275);
					this_BracketTerm_0 = ruleBracketTerm();
					_fsp--;

					current = this_BracketTerm_0;
					currentNode = currentNode.getParent();

				}
					break;
				case 2:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:161:5:
					// this_Negation_1= ruleNegation
				{

					currentNode = createCompositeNode(grammarAccess
							.getHeadAccess().getNegationParserRuleCall_1(),
							currentNode);

					pushFollow(FOLLOW_ruleNegation_in_ruleHead302);
					this_Negation_1 = ruleNegation();
					_fsp--;

					current = this_Negation_1;
					currentNode = currentNode.getParent();

				}
					break;
				case 3:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:171:5:
					// this_Minus_2= ruleMinus
				{

					currentNode = createCompositeNode(grammarAccess
							.getHeadAccess().getMinusParserRuleCall_2(),
							currentNode);

					pushFollow(FOLLOW_ruleMinus_in_ruleHead329);
					this_Minus_2 = ruleMinus();
					_fsp--;

					current = this_Minus_2;
					currentNode = currentNode.getParent();

				}
					break;
				case 4:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:181:5:
					// this_Atom_3= ruleAtom
				{

					currentNode = createCompositeNode(grammarAccess
							.getHeadAccess().getAtomParserRuleCall_3(),
							currentNode);

					pushFollow(FOLLOW_ruleAtom_in_ruleHead356);
					this_Atom_3 = ruleAtom();
					_fsp--;

					current = this_Atom_3;
					currentNode = currentNode.getParent();

				}
					break;

				}

			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleHead

	// $ANTLR start entryRuleTail
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:196:1:
	// entryRuleTail returns [EObject current=null] : iv_ruleTail= ruleTail EOF
	// ;
	public final EObject entryRuleTail() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTail = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:196:46:
			// (iv_ruleTail= ruleTail EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:197:2:
			// iv_ruleTail= ruleTail EOF
			{
				currentNode = createCompositeNode(grammarAccess.getTailRule(),
						currentNode);
				pushFollow(FOLLOW_ruleTail_in_entryRuleTail388);
				iv_ruleTail = ruleTail();
				_fsp--;

				current = iv_ruleTail;
				match(input, EOF, FOLLOW_EOF_in_entryRuleTail398);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleTail

	// $ANTLR start ruleTail
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:204:1:
	// ruleTail returns [EObject current=null] : ( (lv_operator_0= ruleOperator
	// ) (lv_term_1= ruleTerm ) ) ;
	public final EObject ruleTail() throws RecognitionException {
		EObject current = null;

		Enumerator lv_operator_0 = null;

		EObject lv_term_1 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:209:6:
			// ( ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:210:1:
			// ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:210:1:
				// ( (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm ) )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:210:2:
				// (lv_operator_0= ruleOperator ) (lv_term_1= ruleTerm )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:210:2:
					// (lv_operator_0= ruleOperator )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:213:6:
					// lv_operator_0= ruleOperator
					{

						currentNode = createCompositeNode(grammarAccess
								.getTailAccess()
								.getOperatorOperatorEnumRuleCall_0_0(),
								currentNode);

						pushFollow(FOLLOW_ruleOperator_in_ruleTail457);
						lv_operator_0 = ruleOperator();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getTailRule().getType().getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
						}

						try {
							set(current, "operator", lv_operator_0, "Operator",
									lastConsumedNode);
						} catch (ValueConverterException vce) {
							handleValueConverterException(vce);
						}
						currentNode = currentNode.getParent();

					}

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:231:2:
					// (lv_term_1= ruleTerm )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:234:6:
					// lv_term_1= ruleTerm
					{

						currentNode = createCompositeNode(grammarAccess
								.getTailAccess()
								.getTermTermParserRuleCall_1_0(), currentNode);

						pushFollow(FOLLOW_ruleTerm_in_ruleTail495);
						lv_term_1 = ruleTerm();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getTailRule().getType().getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
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

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleTail

	// $ANTLR start entryRuleBracketTerm
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:259:1:
	// entryRuleBracketTerm returns [EObject current=null] : iv_ruleBracketTerm=
	// ruleBracketTerm EOF ;
	public final EObject entryRuleBracketTerm() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleBracketTerm = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:259:53:
			// (iv_ruleBracketTerm= ruleBracketTerm EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:260:2:
			// iv_ruleBracketTerm= ruleBracketTerm EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getBracketTermRule(), currentNode);
				pushFollow(FOLLOW_ruleBracketTerm_in_entryRuleBracketTerm532);
				iv_ruleBracketTerm = ruleBracketTerm();
				_fsp--;

				current = iv_ruleBracketTerm;
				match(input, EOF, FOLLOW_EOF_in_entryRuleBracketTerm542);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleBracketTerm

	// $ANTLR start ruleBracketTerm
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:267:1:
	// ruleBracketTerm returns [EObject current=null] : ( '(' (lv_term_1=
	// ruleTerm ) ')' ) ;
	public final EObject ruleBracketTerm() throws RecognitionException {
		EObject current = null;

		EObject lv_term_1 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:272:6:
			// ( ( '(' (lv_term_1= ruleTerm ) ')' ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:273:1:
			// ( '(' (lv_term_1= ruleTerm ) ')' )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:273:1:
				// ( '(' (lv_term_1= ruleTerm ) ')' )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:273:2:
				// '(' (lv_term_1= ruleTerm ) ')'
				{
					match(input, 11, FOLLOW_11_in_ruleBracketTerm576);

					createLeafNode(grammarAccess.getBracketTermAccess()
							.getLeftParenthesisKeyword_0(), null);

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:277:1:
					// (lv_term_1= ruleTerm )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:280:6:
					// lv_term_1= ruleTerm
					{

						currentNode = createCompositeNode(grammarAccess
								.getBracketTermAccess()
								.getTermTermParserRuleCall_1_0(), currentNode);

						pushFollow(FOLLOW_ruleTerm_in_ruleBracketTerm610);
						lv_term_1 = ruleTerm();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getBracketTermRule().getType()
									.getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
						}

						try {
							set(current, "term", lv_term_1, "Term", currentNode);
						} catch (ValueConverterException vce) {
							handleValueConverterException(vce);
						}
						currentNode = currentNode.getParent();

					}

					match(input, 12, FOLLOW_12_in_ruleBracketTerm623);

					createLeafNode(grammarAccess.getBracketTermAccess()
							.getRightParenthesisKeyword_2(), null);

				}

			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleBracketTerm

	// $ANTLR start entryRuleNegation
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:309:1:
	// entryRuleNegation returns [EObject current=null] : iv_ruleNegation=
	// ruleNegation EOF ;
	public final EObject entryRuleNegation() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNegation = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:309:50:
			// (iv_ruleNegation= ruleNegation EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:310:2:
			// iv_ruleNegation= ruleNegation EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getNegationRule(), currentNode);
				pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation656);
				iv_ruleNegation = ruleNegation();
				_fsp--;

				current = iv_ruleNegation;
				match(input, EOF, FOLLOW_EOF_in_entryRuleNegation666);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleNegation

	// $ANTLR start ruleNegation
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:317:1:
	// ruleNegation returns [EObject current=null] : ( 'not' (lv_head_1=
	// ruleHead ) ) ;
	public final EObject ruleNegation() throws RecognitionException {
		EObject current = null;

		EObject lv_head_1 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:322:6:
			// ( ( 'not' (lv_head_1= ruleHead ) ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:323:1:
			// ( 'not' (lv_head_1= ruleHead ) )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:323:1:
				// ( 'not' (lv_head_1= ruleHead ) )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:323:2:
				// 'not' (lv_head_1= ruleHead )
				{
					match(input, 13, FOLLOW_13_in_ruleNegation700);

					createLeafNode(grammarAccess.getNegationAccess()
							.getNotKeyword_0(), null);

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:327:1:
					// (lv_head_1= ruleHead )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:330:6:
					// lv_head_1= ruleHead
					{

						currentNode = createCompositeNode(grammarAccess
								.getNegationAccess()
								.getHeadHeadParserRuleCall_1_0(), currentNode);

						pushFollow(FOLLOW_ruleHead_in_ruleNegation734);
						lv_head_1 = ruleHead();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getNegationRule().getType()
									.getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
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

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleNegation

	// $ANTLR start entryRuleMinus
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:355:1:
	// entryRuleMinus returns [EObject current=null] : iv_ruleMinus= ruleMinus
	// EOF ;
	public final EObject entryRuleMinus() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMinus = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:355:47:
			// (iv_ruleMinus= ruleMinus EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:356:2:
			// iv_ruleMinus= ruleMinus EOF
			{
				currentNode = createCompositeNode(grammarAccess.getMinusRule(),
						currentNode);
				pushFollow(FOLLOW_ruleMinus_in_entryRuleMinus771);
				iv_ruleMinus = ruleMinus();
				_fsp--;

				current = iv_ruleMinus;
				match(input, EOF, FOLLOW_EOF_in_entryRuleMinus781);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleMinus

	// $ANTLR start ruleMinus
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:363:1:
	// ruleMinus returns [EObject current=null] : ( '-' (lv_head_1= ruleHead ) )
	// ;
	public final EObject ruleMinus() throws RecognitionException {
		EObject current = null;

		EObject lv_head_1 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:368:6:
			// ( ( '-' (lv_head_1= ruleHead ) ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:369:1:
			// ( '-' (lv_head_1= ruleHead ) )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:369:1:
				// ( '-' (lv_head_1= ruleHead ) )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:369:2:
				// '-' (lv_head_1= ruleHead )
				{
					match(input, 14, FOLLOW_14_in_ruleMinus815);

					createLeafNode(grammarAccess.getMinusAccess()
							.getHyphenMinusKeyword_0(), null);

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:373:1:
					// (lv_head_1= ruleHead )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:376:6:
					// lv_head_1= ruleHead
					{

						currentNode = createCompositeNode(grammarAccess
								.getMinusAccess()
								.getHeadHeadParserRuleCall_1_0(), currentNode);

						pushFollow(FOLLOW_ruleHead_in_ruleMinus849);
						lv_head_1 = ruleHead();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getMinusRule().getType().getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
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

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleMinus

	// $ANTLR start entryRuleAtom
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:401:1:
	// entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF
	// ;
	public final EObject entryRuleAtom() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleAtom = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:401:46:
			// (iv_ruleAtom= ruleAtom EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:402:2:
			// iv_ruleAtom= ruleAtom EOF
			{
				currentNode = createCompositeNode(grammarAccess.getAtomRule(),
						currentNode);
				pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom886);
				iv_ruleAtom = ruleAtom();
				_fsp--;

				current = iv_ruleAtom;
				match(input, EOF, FOLLOW_EOF_in_entryRuleAtom896);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleAtom

	// $ANTLR start ruleAtom
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:409:1:
	// ruleAtom returns [EObject current=null] : (this_Value_0= ruleValue |
	// this_Variable_1= ruleVariable ) ;
	public final EObject ruleAtom() throws RecognitionException {
		EObject current = null;

		EObject this_Value_0 = null;

		EObject this_Variable_1 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:414:6:
			// ( (this_Value_0= ruleValue | this_Variable_1= ruleVariable ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:415:1:
			// (this_Value_0= ruleValue | this_Variable_1= ruleVariable )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:415:1:
				// (this_Value_0= ruleValue | this_Variable_1= ruleVariable )
				int alt3 = 2;
				int LA3_0 = input.LA(1);

				if (((LA3_0 >= RULE_STRING && LA3_0 <= RULE_INT) || (LA3_0 >= 18 && LA3_0 <= 20))) {
					alt3 = 1;
				} else if ((LA3_0 == RULE_ID)) {
					alt3 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException(
							"415:1: (this_Value_0= ruleValue | this_Variable_1= ruleVariable )",
							3, 0, input);

					throw nvae;
				}
				switch (alt3) {
				case 1:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:416:5:
					// this_Value_0= ruleValue
				{

					currentNode = createCompositeNode(grammarAccess
							.getAtomAccess().getValueParserRuleCall_0(),
							currentNode);

					pushFollow(FOLLOW_ruleValue_in_ruleAtom943);
					this_Value_0 = ruleValue();
					_fsp--;

					current = this_Value_0;
					currentNode = currentNode.getParent();

				}
					break;
				case 2:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:426:5:
					// this_Variable_1= ruleVariable
				{

					currentNode = createCompositeNode(grammarAccess
							.getAtomAccess().getVariableParserRuleCall_1(),
							currentNode);

					pushFollow(FOLLOW_ruleVariable_in_ruleAtom970);
					this_Variable_1 = ruleVariable();
					_fsp--;

					current = this_Variable_1;
					currentNode = currentNode.getParent();

				}
					break;

				}

			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleAtom

	// $ANTLR start entryRuleVariable
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:441:1:
	// entryRuleVariable returns [EObject current=null] : iv_ruleVariable=
	// ruleVariable EOF ;
	public final EObject entryRuleVariable() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleVariable = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:441:50:
			// (iv_ruleVariable= ruleVariable EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:442:2:
			// iv_ruleVariable= ruleVariable EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getVariableRule(), currentNode);
				pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable1002);
				iv_ruleVariable = ruleVariable();
				_fsp--;

				current = iv_ruleVariable;
				match(input, EOF, FOLLOW_EOF_in_entryRuleVariable1012);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleVariable

	// $ANTLR start ruleVariable
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:449:1:
	// ruleVariable returns [EObject current=null] : ( (lv_name_0= RULE_ID )
	// (lv_accessor_1= ruleAccessor )? ) ;
	public final EObject ruleVariable() throws RecognitionException {
		EObject current = null;

		Token lv_name_0 = null;
		EObject lv_accessor_1 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:454:6:
			// ( ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleAccessor )? ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:455:1:
			// ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleAccessor )? )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:455:1:
				// ( (lv_name_0= RULE_ID ) (lv_accessor_1= ruleAccessor )? )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:455:2:
				// (lv_name_0= RULE_ID ) (lv_accessor_1= ruleAccessor )?
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:455:2:
					// (lv_name_0= RULE_ID )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:457:6:
					// lv_name_0= RULE_ID
					{
						lv_name_0 = (Token) input.LT(1);
						match(input, RULE_ID,
								FOLLOW_RULE_ID_in_ruleVariable1059);

						createLeafNode(grammarAccess.getVariableAccess()
								.getNameIDTerminalRuleCall_0_0(), "name");

						if (current == null) {
							current = factory.create(grammarAccess
									.getVariableRule().getType()
									.getClassifier());
							associateNodeWithAstElement(currentNode, current);
						}

						try {
							set(current, "name", lv_name_0, "ID",
									lastConsumedNode);
						} catch (ValueConverterException vce) {
							handleValueConverterException(vce);
						}

					}

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:475:2:
					// (lv_accessor_1= ruleAccessor )?
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == 15 || LA4_0 == 17)) {
						alt4 = 1;
					}
					switch (alt4) {
					case 1:
						// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:478:6:
						// lv_accessor_1= ruleAccessor
					{

						currentNode = createCompositeNode(grammarAccess
								.getVariableAccess()
								.getAccessorAccessorParserRuleCall_1_0(),
								currentNode);

						pushFollow(FOLLOW_ruleAccessor_in_ruleVariable1101);
						lv_accessor_1 = ruleAccessor();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getVariableRule().getType()
									.getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
						}

						try {
							set(current, "accessor", lv_accessor_1, "Accessor",
									currentNode);
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
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleVariable

	// $ANTLR start entryRuleAccessor
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:503:1:
	// entryRuleAccessor returns [EObject current=null] : iv_ruleAccessor=
	// ruleAccessor EOF ;
	public final EObject entryRuleAccessor() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleAccessor = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:503:50:
			// (iv_ruleAccessor= ruleAccessor EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:504:2:
			// iv_ruleAccessor= ruleAccessor EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getAccessorRule(), currentNode);
				pushFollow(FOLLOW_ruleAccessor_in_entryRuleAccessor1139);
				iv_ruleAccessor = ruleAccessor();
				_fsp--;

				current = iv_ruleAccessor;
				match(input, EOF, FOLLOW_EOF_in_entryRuleAccessor1149);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleAccessor

	// $ANTLR start ruleAccessor
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:511:1:
	// ruleAccessor returns [EObject current=null] : (this_ArrayAccessor_0=
	// ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor ) ;
	public final EObject ruleAccessor() throws RecognitionException {
		EObject current = null;

		EObject this_ArrayAccessor_0 = null;

		EObject this_FieldAccessor_1 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:516:6:
			// ( (this_ArrayAccessor_0= ruleArrayAccessor |
			// this_FieldAccessor_1= ruleFieldAccessor ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:517:1:
			// (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1=
			// ruleFieldAccessor )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:517:1:
				// (this_ArrayAccessor_0= ruleArrayAccessor |
				// this_FieldAccessor_1= ruleFieldAccessor )
				int alt5 = 2;
				int LA5_0 = input.LA(1);

				if ((LA5_0 == 15)) {
					alt5 = 1;
				} else if ((LA5_0 == 17)) {
					alt5 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException(
							"517:1: (this_ArrayAccessor_0= ruleArrayAccessor | this_FieldAccessor_1= ruleFieldAccessor )",
							5, 0, input);

					throw nvae;
				}
				switch (alt5) {
				case 1:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:518:5:
					// this_ArrayAccessor_0= ruleArrayAccessor
				{

					currentNode = createCompositeNode(grammarAccess
							.getAccessorAccess()
							.getArrayAccessorParserRuleCall_0(), currentNode);

					pushFollow(FOLLOW_ruleArrayAccessor_in_ruleAccessor1196);
					this_ArrayAccessor_0 = ruleArrayAccessor();
					_fsp--;

					current = this_ArrayAccessor_0;
					currentNode = currentNode.getParent();

				}
					break;
				case 2:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:528:5:
					// this_FieldAccessor_1= ruleFieldAccessor
				{

					currentNode = createCompositeNode(grammarAccess
							.getAccessorAccess()
							.getFieldAccessorParserRuleCall_1(), currentNode);

					pushFollow(FOLLOW_ruleFieldAccessor_in_ruleAccessor1223);
					this_FieldAccessor_1 = ruleFieldAccessor();
					_fsp--;

					current = this_FieldAccessor_1;
					currentNode = currentNode.getParent();

				}
					break;

				}

			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleAccessor

	// $ANTLR start entryRuleArrayAccessor
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:543:1:
	// entryRuleArrayAccessor returns [EObject current=null] :
	// iv_ruleArrayAccessor= ruleArrayAccessor EOF ;
	public final EObject entryRuleArrayAccessor() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleArrayAccessor = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:543:55:
			// (iv_ruleArrayAccessor= ruleArrayAccessor EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:544:2:
			// iv_ruleArrayAccessor= ruleArrayAccessor EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getArrayAccessorRule(), currentNode);
				pushFollow(FOLLOW_ruleArrayAccessor_in_entryRuleArrayAccessor1255);
				iv_ruleArrayAccessor = ruleArrayAccessor();
				_fsp--;

				current = iv_ruleArrayAccessor;
				match(input, EOF, FOLLOW_EOF_in_entryRuleArrayAccessor1265);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleArrayAccessor

	// $ANTLR start ruleArrayAccessor
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:551:1:
	// ruleArrayAccessor returns [EObject current=null] : ( '[' (lv_index_1=
	// ruleTerm ) ']' (lv_accessor_3= ruleAccessor )? ) ;
	public final EObject ruleArrayAccessor() throws RecognitionException {
		EObject current = null;

		EObject lv_index_1 = null;

		EObject lv_accessor_3 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:556:6:
			// ( ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor
			// )? ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:557:1:
			// ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor )?
			// )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:557:1:
				// ( '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3=
				// ruleAccessor )? )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:557:2:
				// '[' (lv_index_1= ruleTerm ) ']' (lv_accessor_3= ruleAccessor
				// )?
				{
					match(input, 15, FOLLOW_15_in_ruleArrayAccessor1299);

					createLeafNode(grammarAccess.getArrayAccessorAccess()
							.getLeftSquareBracketKeyword_0(), null);

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:561:1:
					// (lv_index_1= ruleTerm )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:564:6:
					// lv_index_1= ruleTerm
					{

						currentNode = createCompositeNode(grammarAccess
								.getArrayAccessorAccess()
								.getIndexTermParserRuleCall_1_0(), currentNode);

						pushFollow(FOLLOW_ruleTerm_in_ruleArrayAccessor1333);
						lv_index_1 = ruleTerm();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getArrayAccessorRule().getType()
									.getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
						}

						try {
							set(current, "index", lv_index_1, "Term",
									currentNode);
						} catch (ValueConverterException vce) {
							handleValueConverterException(vce);
						}
						currentNode = currentNode.getParent();

					}

					match(input, 16, FOLLOW_16_in_ruleArrayAccessor1346);

					createLeafNode(grammarAccess.getArrayAccessorAccess()
							.getRightSquareBracketKeyword_2(), null);

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:586:1:
					// (lv_accessor_3= ruleAccessor )?
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if ((LA6_0 == 15 || LA6_0 == 17)) {
						alt6 = 1;
					}
					switch (alt6) {
					case 1:
						// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:589:6:
						// lv_accessor_3= ruleAccessor
					{

						currentNode = createCompositeNode(grammarAccess
								.getArrayAccessorAccess()
								.getAccessorAccessorParserRuleCall_3_0(),
								currentNode);

						pushFollow(FOLLOW_ruleAccessor_in_ruleArrayAccessor1380);
						lv_accessor_3 = ruleAccessor();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getArrayAccessorRule().getType()
									.getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
						}

						try {
							set(current, "accessor", lv_accessor_3, "Accessor",
									currentNode);
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
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleArrayAccessor

	// $ANTLR start entryRuleFieldAccessor
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:614:1:
	// entryRuleFieldAccessor returns [EObject current=null] :
	// iv_ruleFieldAccessor= ruleFieldAccessor EOF ;
	public final EObject entryRuleFieldAccessor() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleFieldAccessor = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:614:55:
			// (iv_ruleFieldAccessor= ruleFieldAccessor EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:615:2:
			// iv_ruleFieldAccessor= ruleFieldAccessor EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getFieldAccessorRule(), currentNode);
				pushFollow(FOLLOW_ruleFieldAccessor_in_entryRuleFieldAccessor1418);
				iv_ruleFieldAccessor = ruleFieldAccessor();
				_fsp--;

				current = iv_ruleFieldAccessor;
				match(input, EOF, FOLLOW_EOF_in_entryRuleFieldAccessor1428);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleFieldAccessor

	// $ANTLR start ruleFieldAccessor
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:622:1:
	// ruleFieldAccessor returns [EObject current=null] : ( '.' (lv_name_1=
	// RULE_ID ) (lv_accessor_2= ruleAccessor )? ) ;
	public final EObject ruleFieldAccessor() throws RecognitionException {
		EObject current = null;

		Token lv_name_1 = null;
		EObject lv_accessor_2 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:627:6:
			// ( ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:628:1:
			// ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:628:1:
				// ( '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )? )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:628:2:
				// '.' (lv_name_1= RULE_ID ) (lv_accessor_2= ruleAccessor )?
				{
					match(input, 17, FOLLOW_17_in_ruleFieldAccessor1462);

					createLeafNode(grammarAccess.getFieldAccessorAccess()
							.getFullStopKeyword_0(), null);

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:632:1:
					// (lv_name_1= RULE_ID )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:634:6:
					// lv_name_1= RULE_ID
					{
						lv_name_1 = (Token) input.LT(1);
						match(input, RULE_ID,
								FOLLOW_RULE_ID_in_ruleFieldAccessor1484);

						createLeafNode(grammarAccess.getFieldAccessorAccess()
								.getNameIDTerminalRuleCall_1_0(), "name");

						if (current == null) {
							current = factory.create(grammarAccess
									.getFieldAccessorRule().getType()
									.getClassifier());
							associateNodeWithAstElement(currentNode, current);
						}

						try {
							set(current, "name", lv_name_1, "ID",
									lastConsumedNode);
						} catch (ValueConverterException vce) {
							handleValueConverterException(vce);
						}

					}

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:652:2:
					// (lv_accessor_2= ruleAccessor )?
					int alt7 = 2;
					int LA7_0 = input.LA(1);

					if ((LA7_0 == 15 || LA7_0 == 17)) {
						alt7 = 1;
					}
					switch (alt7) {
					case 1:
						// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:655:6:
						// lv_accessor_2= ruleAccessor
					{

						currentNode = createCompositeNode(grammarAccess
								.getFieldAccessorAccess()
								.getAccessorAccessorParserRuleCall_2_0(),
								currentNode);

						pushFollow(FOLLOW_ruleAccessor_in_ruleFieldAccessor1526);
						lv_accessor_2 = ruleAccessor();
						_fsp--;

						if (current == null) {
							current = factory.create(grammarAccess
									.getFieldAccessorRule().getType()
									.getClassifier());
							associateNodeWithAstElement(
									currentNode.getParent(), current);
						}

						try {
							set(current, "accessor", lv_accessor_2, "Accessor",
									currentNode);
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
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleFieldAccessor

	// $ANTLR start entryRuleValue
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:680:1:
	// entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue
	// EOF ;
	public final EObject entryRuleValue() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleValue = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:680:47:
			// (iv_ruleValue= ruleValue EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:681:2:
			// iv_ruleValue= ruleValue EOF
			{
				currentNode = createCompositeNode(grammarAccess.getValueRule(),
						currentNode);
				pushFollow(FOLLOW_ruleValue_in_entryRuleValue1564);
				iv_ruleValue = ruleValue();
				_fsp--;

				current = iv_ruleValue;
				match(input, EOF, FOLLOW_EOF_in_entryRuleValue1574);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleValue

	// $ANTLR start ruleValue
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:688:1:
	// ruleValue returns [EObject current=null] : (this_StringConst_0=
	// ruleStringConst | this_BooleanConst_1= ruleBooleanConst |
	// this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst )
	// ;
	public final EObject ruleValue() throws RecognitionException {
		EObject current = null;

		EObject this_StringConst_0 = null;

		EObject this_BooleanConst_1 = null;

		EObject this_NumericConst_2 = null;

		EObject this_NullConst_3 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:693:6:
			// ( (this_StringConst_0= ruleStringConst | this_BooleanConst_1=
			// ruleBooleanConst | this_NumericConst_2= ruleNumericConst |
			// this_NullConst_3= ruleNullConst ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:694:1:
			// (this_StringConst_0= ruleStringConst | this_BooleanConst_1=
			// ruleBooleanConst | this_NumericConst_2= ruleNumericConst |
			// this_NullConst_3= ruleNullConst )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:694:1:
				// (this_StringConst_0= ruleStringConst | this_BooleanConst_1=
				// ruleBooleanConst | this_NumericConst_2= ruleNumericConst |
				// this_NullConst_3= ruleNullConst )
				int alt8 = 4;
				switch (input.LA(1)) {
				case RULE_STRING: {
					alt8 = 1;
				}
					break;
				case 18:
				case 19: {
					alt8 = 2;
				}
					break;
				case RULE_INT: {
					alt8 = 3;
				}
					break;
				case 20: {
					alt8 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException(
							"694:1: (this_StringConst_0= ruleStringConst | this_BooleanConst_1= ruleBooleanConst | this_NumericConst_2= ruleNumericConst | this_NullConst_3= ruleNullConst )",
							8, 0, input);

					throw nvae;
				}

				switch (alt8) {
				case 1:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:695:5:
					// this_StringConst_0= ruleStringConst
				{

					currentNode = createCompositeNode(grammarAccess
							.getValueAccess().getStringConstParserRuleCall_0(),
							currentNode);

					pushFollow(FOLLOW_ruleStringConst_in_ruleValue1621);
					this_StringConst_0 = ruleStringConst();
					_fsp--;

					current = this_StringConst_0;
					currentNode = currentNode.getParent();

				}
					break;
				case 2:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:705:5:
					// this_BooleanConst_1= ruleBooleanConst
				{

					currentNode = createCompositeNode(
							grammarAccess.getValueAccess()
									.getBooleanConstParserRuleCall_1(),
							currentNode);

					pushFollow(FOLLOW_ruleBooleanConst_in_ruleValue1648);
					this_BooleanConst_1 = ruleBooleanConst();
					_fsp--;

					current = this_BooleanConst_1;
					currentNode = currentNode.getParent();

				}
					break;
				case 3:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:715:5:
					// this_NumericConst_2= ruleNumericConst
				{

					currentNode = createCompositeNode(
							grammarAccess.getValueAccess()
									.getNumericConstParserRuleCall_2(),
							currentNode);

					pushFollow(FOLLOW_ruleNumericConst_in_ruleValue1675);
					this_NumericConst_2 = ruleNumericConst();
					_fsp--;

					current = this_NumericConst_2;
					currentNode = currentNode.getParent();

				}
					break;
				case 4:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:725:5:
					// this_NullConst_3= ruleNullConst
				{

					currentNode = createCompositeNode(grammarAccess
							.getValueAccess().getNullConstParserRuleCall_3(),
							currentNode);

					pushFollow(FOLLOW_ruleNullConst_in_ruleValue1702);
					this_NullConst_3 = ruleNullConst();
					_fsp--;

					current = this_NullConst_3;
					currentNode = currentNode.getParent();

				}
					break;

				}

			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleValue

	// $ANTLR start entryRuleStringConst
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:740:1:
	// entryRuleStringConst returns [EObject current=null] : iv_ruleStringConst=
	// ruleStringConst EOF ;
	public final EObject entryRuleStringConst() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleStringConst = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:740:53:
			// (iv_ruleStringConst= ruleStringConst EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:741:2:
			// iv_ruleStringConst= ruleStringConst EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getStringConstRule(), currentNode);
				pushFollow(FOLLOW_ruleStringConst_in_entryRuleStringConst1734);
				iv_ruleStringConst = ruleStringConst();
				_fsp--;

				current = iv_ruleStringConst;
				match(input, EOF, FOLLOW_EOF_in_entryRuleStringConst1744);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleStringConst

	// $ANTLR start ruleStringConst
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:748:1:
	// ruleStringConst returns [EObject current=null] : (lv_const_0= RULE_STRING
	// ) ;
	public final EObject ruleStringConst() throws RecognitionException {
		EObject current = null;

		Token lv_const_0 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:753:6:
			// ( (lv_const_0= RULE_STRING ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:754:1:
			// (lv_const_0= RULE_STRING )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:754:1:
				// (lv_const_0= RULE_STRING )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:756:6:
				// lv_const_0= RULE_STRING
				{
					lv_const_0 = (Token) input.LT(1);
					match(input, RULE_STRING,
							FOLLOW_RULE_STRING_in_ruleStringConst1790);

					createLeafNode(grammarAccess.getStringConstAccess()
							.getConstSTRINGTerminalRuleCall_0(), "const");

					if (current == null) {
						current = factory
								.create(grammarAccess.getStringConstRule()
										.getType().getClassifier());
						associateNodeWithAstElement(currentNode, current);
					}

					try {
						set(current, "const", lv_const_0, "STRING",
								lastConsumedNode);
					} catch (ValueConverterException vce) {
						handleValueConverterException(vce);
					}

				}

			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleStringConst

	// $ANTLR start entryRuleNumericConst
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:781:1:
	// entryRuleNumericConst returns [EObject current=null] :
	// iv_ruleNumericConst= ruleNumericConst EOF ;
	public final EObject entryRuleNumericConst() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNumericConst = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:781:54:
			// (iv_ruleNumericConst= ruleNumericConst EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:782:2:
			// iv_ruleNumericConst= ruleNumericConst EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getNumericConstRule(), currentNode);
				pushFollow(FOLLOW_ruleNumericConst_in_entryRuleNumericConst1830);
				iv_ruleNumericConst = ruleNumericConst();
				_fsp--;

				current = iv_ruleNumericConst;
				match(input, EOF, FOLLOW_EOF_in_entryRuleNumericConst1840);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleNumericConst

	// $ANTLR start ruleNumericConst
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:789:1:
	// ruleNumericConst returns [EObject current=null] : (lv_const_0=
	// ruleNUMERIC ) ;
	public final EObject ruleNumericConst() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_const_0 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:794:6:
			// ( (lv_const_0= ruleNUMERIC ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:795:1:
			// (lv_const_0= ruleNUMERIC )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:795:1:
				// (lv_const_0= ruleNUMERIC )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:798:6:
				// lv_const_0= ruleNUMERIC
				{

					currentNode = createCompositeNode(grammarAccess
							.getNumericConstAccess()
							.getConstNUMERICParserRuleCall_0(), currentNode);

					pushFollow(FOLLOW_ruleNUMERIC_in_ruleNumericConst1898);
					lv_const_0 = ruleNUMERIC();
					_fsp--;

					if (current == null) {
						current = factory.create(grammarAccess
								.getNumericConstRule().getType()
								.getClassifier());
						associateNodeWithAstElement(currentNode.getParent(),
								current);
					}

					try {
						set(current, "const", lv_const_0, "NUMERIC",
								currentNode);
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
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleNumericConst

	// $ANTLR start entryRuleBooleanConst
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:823:1:
	// entryRuleBooleanConst returns [EObject current=null] :
	// iv_ruleBooleanConst= ruleBooleanConst EOF ;
	public final EObject entryRuleBooleanConst() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleBooleanConst = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:823:54:
			// (iv_ruleBooleanConst= ruleBooleanConst EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:824:2:
			// iv_ruleBooleanConst= ruleBooleanConst EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getBooleanConstRule(), currentNode);
				pushFollow(FOLLOW_ruleBooleanConst_in_entryRuleBooleanConst1934);
				iv_ruleBooleanConst = ruleBooleanConst();
				_fsp--;

				current = iv_ruleBooleanConst;
				match(input, EOF, FOLLOW_EOF_in_entryRuleBooleanConst1944);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleBooleanConst

	// $ANTLR start ruleBooleanConst
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:831:1:
	// ruleBooleanConst returns [EObject current=null] : (lv_const_0= ( 'true' |
	// 'false' ) ) ;
	public final EObject ruleBooleanConst() throws RecognitionException {
		EObject current = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:836:6:
			// ( (lv_const_0= ( 'true' | 'false' ) ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:837:1:
			// (lv_const_0= ( 'true' | 'false' ) )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:837:1:
				// (lv_const_0= ( 'true' | 'false' ) )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:839:6:
				// lv_const_0= ( 'true' | 'false' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:839:17:
					// ( 'true' | 'false' )
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if ((LA9_0 == 18)) {
						alt9 = 1;
					} else if ((LA9_0 == 19)) {
						alt9 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException(
								"839:17: ( 'true' | 'false' )", 9, 0, input);

						throw nvae;
					}
					switch (alt9) {
					case 1:
						// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:839:18:
						// 'true'
					{
						match(input, 18, FOLLOW_18_in_ruleBooleanConst1990);

						createLeafNode(grammarAccess.getBooleanConstAccess()
								.getConstTrueKeyword_0_0(), "const");

					}
						break;
					case 2:
						// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:845:6:
						// 'false'
					{
						match(input, 19, FOLLOW_19_in_ruleBooleanConst2006);

						createLeafNode(grammarAccess.getBooleanConstAccess()
								.getConstFalseKeyword_0_1(), "const");

					}
						break;

					}

					if (current == null) {
						current = factory.create(grammarAccess
								.getBooleanConstRule().getType()
								.getClassifier());
						associateNodeWithAstElement(currentNode, current);
					}

					try {
						set(current, "const", /* lv_const_0 */input.LT(-1), null,
								lastConsumedNode);
					} catch (ValueConverterException vce) {
						handleValueConverterException(vce);
					}

				}

			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleBooleanConst

	// $ANTLR start entryRuleNullConst
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:872:1:
	// entryRuleNullConst returns [EObject current=null] : iv_ruleNullConst=
	// ruleNullConst EOF ;
	public final EObject entryRuleNullConst() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNullConst = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:872:51:
			// (iv_ruleNullConst= ruleNullConst EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:873:2:
			// iv_ruleNullConst= ruleNullConst EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getNullConstRule(), currentNode);
				pushFollow(FOLLOW_ruleNullConst_in_entryRuleNullConst2053);
				iv_ruleNullConst = ruleNullConst();
				_fsp--;

				current = iv_ruleNullConst;
				match(input, EOF, FOLLOW_EOF_in_entryRuleNullConst2063);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleNullConst

	// $ANTLR start ruleNullConst
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:880:1:
	// ruleNullConst returns [EObject current=null] : (lv_const_0= 'null' ) ;
	public final EObject ruleNullConst() throws RecognitionException {
		EObject current = null;


		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:885:6:
			// ( (lv_const_0= 'null' ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:886:1:
			// (lv_const_0= 'null' )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:886:1:
				// (lv_const_0= 'null' )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:888:6:
				// lv_const_0= 'null'
				{
					input.LT(1);
					match(input, 20, FOLLOW_20_in_ruleNullConst2108);

					createLeafNode(grammarAccess.getNullConstAccess()
							.getConstNullKeyword_0(), "const");

					if (current == null) {
						current = factory.create(grammarAccess
								.getNullConstRule().getType().getClassifier());
						associateNodeWithAstElement(currentNode, current);
					}

					try {
						set(current, "const", /* lv_const_0 */input.LT(-1),
								"null", lastConsumedNode);
					} catch (ValueConverterException vce) {
						handleValueConverterException(vce);
					}

				}

			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleNullConst

	// $ANTLR start entryRuleNUMERIC
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:914:1:
	// entryRuleNUMERIC returns [String current=null] : iv_ruleNUMERIC=
	// ruleNUMERIC EOF ;
	public final String entryRuleNUMERIC() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleNUMERIC = null;

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:914:48:
			// (iv_ruleNUMERIC= ruleNUMERIC EOF )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:915:2:
			// iv_ruleNUMERIC= ruleNUMERIC EOF
			{
				currentNode = createCompositeNode(grammarAccess
						.getNUMERICRule(), currentNode);
				pushFollow(FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2154);
				iv_ruleNUMERIC = ruleNUMERIC();
				_fsp--;

				current = iv_ruleNUMERIC.getText();
				match(input, EOF, FOLLOW_EOF_in_entryRuleNUMERIC2165);

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end entryRuleNUMERIC

	// $ANTLR start ruleNUMERIC
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:922:1:
	// ruleNUMERIC returns [AntlrDatatypeRuleToken current=new
	// AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2=
	// RULE_INT )? ) ;
	public final AntlrDatatypeRuleToken ruleNUMERIC()
			throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_INT_0 = null;
		Token kw = null;
		Token this_INT_2 = null;

		setCurrentLookahead();
		resetLookahead();

		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:928:6:
			// ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:929:1:
			// (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:929:1:
				// (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:929:6:
				// this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
				{
					this_INT_0 = (Token) input.LT(1);
					match(input, RULE_INT, FOLLOW_RULE_INT_in_ruleNUMERIC2205);

					current.merge(this_INT_0);

					createLeafNode(grammarAccess.getNUMERICAccess()
							.getINTTerminalRuleCall_0(), null);

					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:936:1:
					// (kw= '.' this_INT_2= RULE_INT )?
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if ((LA10_0 == 17)) {
						alt10 = 1;
					}
					switch (alt10) {
					case 1:
						// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:937:2:
						// kw= '.' this_INT_2= RULE_INT
					{
						kw = (Token) input.LT(1);
						match(input, 17, FOLLOW_17_in_ruleNUMERIC2224);

						current.merge(kw);
						createLeafNode(grammarAccess.getNUMERICAccess()
								.getFullStopKeyword_1_0(), null);

						this_INT_2 = (Token) input.LT(1);
						match(input, RULE_INT,
								FOLLOW_RULE_INT_in_ruleNUMERIC2239);

						current.merge(this_INT_2);

						createLeafNode(grammarAccess.getNUMERICAccess()
								.getINTTerminalRuleCall_1_1(), null);

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
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleNUMERIC

	// $ANTLR start ruleOperator
	// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:957:1:
	// ruleOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | (
	// '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | (
	// '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) ) ;
	public final Enumerator ruleOperator() throws RecognitionException {
		Enumerator current = null;

		setCurrentLookahead();
		resetLookahead();
		try {
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:961:6:
			// ( ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' )
			// | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | (
			// 'or' ) | ( '++' ) ) )
			// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:962:1:
			// ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) |
			// ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | (
			// 'or' ) | ( '++' ) )
			{
				// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:962:1:
				// ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>='
				// ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and'
				// ) | ( 'or' ) | ( '++' ) )
				int alt11 = 14;
				switch (input.LA(1)) {
				case 21: {
					alt11 = 1;
				}
					break;
				case 22: {
					alt11 = 2;
				}
					break;
				case 23: {
					alt11 = 3;
				}
					break;
				case 24: {
					alt11 = 4;
				}
					break;
				case 25: {
					alt11 = 5;
				}
					break;
				case 26: {
					alt11 = 6;
				}
					break;
				case 27: {
					alt11 = 7;
				}
					break;
				case 14: {
					alt11 = 8;
				}
					break;
				case 28: {
					alt11 = 9;
				}
					break;
				case 29: {
					alt11 = 10;
				}
					break;
				case 30: {
					alt11 = 11;
				}
					break;
				case 31: {
					alt11 = 12;
				}
					break;
				case 32: {
					alt11 = 13;
				}
					break;
				case 33: {
					alt11 = 14;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException(
							"962:1: ( ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '>=' ) | ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'and' ) | ( 'or' ) | ( '++' ) )",
							11, 0, input);

					throw nvae;
				}

				switch (alt11) {
				case 1:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:962:2:
					// ( '<' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:962:2:
					// ( '<' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:962:4:
					// '<'
					{
						match(input, 21, FOLLOW_21_in_ruleOperator2298);

						current = grammarAccess.getOperatorAccess()
								.getLTEnumLiteralDeclaration_0()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getLTEnumLiteralDeclaration_0(), null);

					}

				}
					break;
				case 2:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:968:6:
					// ( '<=' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:968:6:
					// ( '<=' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:968:8:
					// '<='
					{
						match(input, 22, FOLLOW_22_in_ruleOperator2313);

						current = grammarAccess.getOperatorAccess()
								.getLEEnumLiteralDeclaration_1()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getLEEnumLiteralDeclaration_1(), null);

					}

				}
					break;
				case 3:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:974:6:
					// ( '==' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:974:6:
					// ( '==' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:974:8:
					// '=='
					{
						match(input, 23, FOLLOW_23_in_ruleOperator2328);

						current = grammarAccess.getOperatorAccess()
								.getEQEnumLiteralDeclaration_2()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getEQEnumLiteralDeclaration_2(), null);

					}

				}
					break;
				case 4:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:980:6:
					// ( '!=' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:980:6:
					// ( '!=' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:980:8:
					// '!='
					{
						match(input, 24, FOLLOW_24_in_ruleOperator2343);

						current = grammarAccess.getOperatorAccess()
								.getNEQEnumLiteralDeclaration_3()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getNEQEnumLiteralDeclaration_3(), null);

					}

				}
					break;
				case 5:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:986:6:
					// ( '>' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:986:6:
					// ( '>' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:986:8:
					// '>'
					{
						match(input, 25, FOLLOW_25_in_ruleOperator2358);

						current = grammarAccess.getOperatorAccess()
								.getGTEnumLiteralDeclaration_4()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getGTEnumLiteralDeclaration_4(), null);

					}

				}
					break;
				case 6:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:992:6:
					// ( '>=' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:992:6:
					// ( '>=' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:992:8:
					// '>='
					{
						match(input, 26, FOLLOW_26_in_ruleOperator2373);

						current = grammarAccess.getOperatorAccess()
								.getGEEnumLiteralDeclaration_5()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getGEEnumLiteralDeclaration_5(), null);

					}

				}
					break;
				case 7:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:998:6:
					// ( '+' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:998:6:
					// ( '+' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:998:8:
					// '+'
					{
						match(input, 27, FOLLOW_27_in_ruleOperator2388);

						current = grammarAccess.getOperatorAccess()
								.getADDEnumLiteralDeclaration_6()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getADDEnumLiteralDeclaration_6(), null);

					}

				}
					break;
				case 8:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1004:6:
					// ( '-' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1004:6:
					// ( '-' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1004:8:
					// '-'
					{
						match(input, 14, FOLLOW_14_in_ruleOperator2403);

						current = grammarAccess.getOperatorAccess()
								.getSUBEnumLiteralDeclaration_7()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getSUBEnumLiteralDeclaration_7(), null);

					}

				}
					break;
				case 9:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1010:6:
					// ( '*' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1010:6:
					// ( '*' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1010:8:
					// '*'
					{
						match(input, 28, FOLLOW_28_in_ruleOperator2418);

						current = grammarAccess.getOperatorAccess()
								.getMULTEnumLiteralDeclaration_8()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getMULTEnumLiteralDeclaration_8(), null);

					}

				}
					break;
				case 10:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1016:6:
					// ( '/' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1016:6:
					// ( '/' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1016:8:
					// '/'
					{
						match(input, 29, FOLLOW_29_in_ruleOperator2433);

						current = grammarAccess.getOperatorAccess()
								.getDIVEnumLiteralDeclaration_9()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getDIVEnumLiteralDeclaration_9(), null);

					}

				}
					break;
				case 11:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1022:6:
					// ( '%' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1022:6:
					// ( '%' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1022:8:
					// '%'
					{
						match(input, 30, FOLLOW_30_in_ruleOperator2448);

						current = grammarAccess.getOperatorAccess()
								.getMODEnumLiteralDeclaration_10()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getMODEnumLiteralDeclaration_10(), null);

					}

				}
					break;
				case 12:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1028:6:
					// ( 'and' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1028:6:
					// ( 'and' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1028:8:
					// 'and'
					{
						match(input, 31, FOLLOW_31_in_ruleOperator2463);

						current = grammarAccess.getOperatorAccess()
								.getANDEnumLiteralDeclaration_11()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getANDEnumLiteralDeclaration_11(), null);

					}

				}
					break;
				case 13:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1034:6:
					// ( 'or' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1034:6:
					// ( 'or' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1034:8:
					// 'or'
					{
						match(input, 32, FOLLOW_32_in_ruleOperator2478);

						current = grammarAccess.getOperatorAccess()
								.getOREnumLiteralDeclaration_12()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getOREnumLiteralDeclaration_12(), null);

					}

				}
					break;
				case 14:
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1040:6:
					// ( '++' )
				{
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1040:6:
					// ( '++' )
					// ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1040:8:
					// '++'
					{
						match(input, 33, FOLLOW_33_in_ruleOperator2493);

						current = grammarAccess.getOperatorAccess()
								.getCONCATEnumLiteralDeclaration_13()
								.getEnumLiteral().getInstance();
						createLeafNode(grammarAccess.getOperatorAccess()
								.getCONCATEnumLiteralDeclaration_13(), null);

					}

				}
					break;

				}

			}

			resetLookahead();
			lastConsumedNode = currentNode;

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}

	// $ANTLR end ruleOperator

	public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm73 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleTerm83 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleHead_in_ruleTerm142 = new BitSet(
			new long[] { 0x00000003FFE04002L });
	public static final BitSet FOLLOW_ruleTail_in_ruleTerm180 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleHead_in_entryRuleHead218 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleHead228 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleBracketTerm_in_ruleHead275 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNegation_in_ruleHead302 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleMinus_in_ruleHead329 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleAtom_in_ruleHead356 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleTail_in_entryRuleTail388 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleTail398 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleOperator_in_ruleTail457 = new BitSet(
			new long[] { 0x00000000001C6870L });
	public static final BitSet FOLLOW_ruleTerm_in_ruleTail495 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleBracketTerm_in_entryRuleBracketTerm532 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleBracketTerm542 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_11_in_ruleBracketTerm576 = new BitSet(
			new long[] { 0x00000000001C6870L });
	public static final BitSet FOLLOW_ruleTerm_in_ruleBracketTerm610 = new BitSet(
			new long[] { 0x0000000000001000L });
	public static final BitSet FOLLOW_12_in_ruleBracketTerm623 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation656 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleNegation666 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_13_in_ruleNegation700 = new BitSet(
			new long[] { 0x00000000001C6870L });
	public static final BitSet FOLLOW_ruleHead_in_ruleNegation734 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleMinus_in_entryRuleMinus771 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleMinus781 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_14_in_ruleMinus815 = new BitSet(
			new long[] { 0x00000000001C6870L });
	public static final BitSet FOLLOW_ruleHead_in_ruleMinus849 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom886 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleAtom896 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleValue_in_ruleAtom943 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleVariable_in_ruleAtom970 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable1002 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleVariable1012 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_ID_in_ruleVariable1059 = new BitSet(
			new long[] { 0x0000000000028002L });
	public static final BitSet FOLLOW_ruleAccessor_in_ruleVariable1101 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleAccessor_in_entryRuleAccessor1139 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleAccessor1149 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleArrayAccessor_in_ruleAccessor1196 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleFieldAccessor_in_ruleAccessor1223 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleArrayAccessor_in_entryRuleArrayAccessor1255 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleArrayAccessor1265 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_15_in_ruleArrayAccessor1299 = new BitSet(
			new long[] { 0x00000000001C6870L });
	public static final BitSet FOLLOW_ruleTerm_in_ruleArrayAccessor1333 = new BitSet(
			new long[] { 0x0000000000010000L });
	public static final BitSet FOLLOW_16_in_ruleArrayAccessor1346 = new BitSet(
			new long[] { 0x0000000000028002L });
	public static final BitSet FOLLOW_ruleAccessor_in_ruleArrayAccessor1380 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleFieldAccessor_in_entryRuleFieldAccessor1418 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleFieldAccessor1428 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_17_in_ruleFieldAccessor1462 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_RULE_ID_in_ruleFieldAccessor1484 = new BitSet(
			new long[] { 0x0000000000028002L });
	public static final BitSet FOLLOW_ruleAccessor_in_ruleFieldAccessor1526 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1564 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleValue1574 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleStringConst_in_ruleValue1621 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleBooleanConst_in_ruleValue1648 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNumericConst_in_ruleValue1675 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNullConst_in_ruleValue1702 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleStringConst_in_entryRuleStringConst1734 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleStringConst1744 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_STRING_in_ruleStringConst1790 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNumericConst_in_entryRuleNumericConst1830 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleNumericConst1840 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNUMERIC_in_ruleNumericConst1898 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleBooleanConst_in_entryRuleBooleanConst1934 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleBooleanConst1944 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_18_in_ruleBooleanConst1990 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_19_in_ruleBooleanConst2006 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNullConst_in_entryRuleNullConst2053 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleNullConst2063 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_20_in_ruleNullConst2108 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNUMERIC_in_entryRuleNUMERIC2154 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleNUMERIC2165 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2205 = new BitSet(
			new long[] { 0x0000000000020002L });
	public static final BitSet FOLLOW_17_in_ruleNUMERIC2224 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_RULE_INT_in_ruleNUMERIC2239 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_21_in_ruleOperator2298 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_22_in_ruleOperator2313 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_23_in_ruleOperator2328 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_24_in_ruleOperator2343 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_25_in_ruleOperator2358 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_26_in_ruleOperator2373 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_27_in_ruleOperator2388 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_14_in_ruleOperator2403 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_28_in_ruleOperator2418 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_29_in_ruleOperator2433 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_30_in_ruleOperator2448 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_31_in_ruleOperator2463 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_32_in_ruleOperator2478 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_33_in_ruleOperator2493 = new BitSet(
			new long[] { 0x0000000000000002L });

}