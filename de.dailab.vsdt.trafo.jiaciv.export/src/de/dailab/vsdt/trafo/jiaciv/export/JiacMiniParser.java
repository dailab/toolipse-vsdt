package de.dailab.vsdt.trafo.jiaciv.export;

import java.io.PushbackReader;
import java.io.StringReader;

import javax.xml.bind.JAXBException;

import de.dailab.jadltools.model.tree.JADLDocument;
import de.dailab.jadltools.model.xmlbind.ActModel;
import de.dailab.jadltools.model.xmlbind.BindModel;
import de.dailab.jadltools.model.xmlbind.CompFormulaModel;
import de.dailab.jadltools.model.xmlbind.FormulaModel;
import de.dailab.jadltools.model.xmlbind.ObjectFactory;
import de.dailab.jadltools.model.xmlbind.ScriptModel;
import de.dailab.jadltools.model.xmlbind.ScriptbodyModel;
import de.dailab.jadltools.model.xmlbind.SeqExecutionModel;
import de.dailab.jadltools.model.xmlbind.StepModel;
import de.dailab.jadltools.model.xmlbind.StringModel;
import de.dailab.jadltools.model.xmlbind.TermModel;
import de.dailab.jadltools.parser.ASTModelTransformer;
import de.dailab.jadltools.parser.lexer.Lexer;
import de.dailab.jadltools.parser.node.Start;
import de.dailab.jadltools.parser.parser.Parser;
import de.dailab.vsdt.Expression;

/**
 * This supporting class can be used to parse various JADL expressions, e.g. formulas, terms or 
 * scripts, from strings, by wrapping the strings in a complete JADL file and delegating to the parser
 * from de.dailab.jadltools. 
 * 
 * @author kuester
 */
public class JiacMiniParser {
	
	/**JAXB-ObjectFactory for JADL elements*/
	public static ObjectFactory jadlFac= new ObjectFactory();
	
	/**
	 * Parse String to FormulaModel.
	 * 
	 * @param formulaString	some formula, e.g. in a loop condition
	 * @return				the formula as a model
	 */
	public static FormulaModel parseFormula(String formulaString) throws JAXBException {
		CompFormulaModel compFormulaModel= jadlFac.createCompFormulaModel();
		compFormulaModel.setName(formulaString);
		
		FormulaModel formula= compFormulaModel;
		try {
			//get Abstract syntax tree with term
			String jadl= "(package de.dailab.test (act Test (pre " + formulaString + ") (eff true) abstract ) )";
		    Lexer lexer = new Lexer(new PushbackReader(new StringReader(jadl)));
		    Parser parser = new Parser(lexer);
		    Start ast = parser.parse();
		    
		    // transform model
		    ASTModelTransformer trans = new ASTModelTransformer(ast);
		    JADLDocument jadlDoc = (JADLDocument) trans.transform();
		    
		    //get FormulaModel
		    ActModel act= (ActModel) jadlDoc.getAct().get(0);
		    formula= act.getPrecondition();
			
		} catch (Exception e) {
			System.err.println("Parsing formula failed: \"" + formulaString + "\"");
		}
		return formula;
	}
	
	/**
	 * Parse String to Precondition and effect
	 * 
	 * @param act			action element
	 * @param formulaString	precondition and effect
	 */
	public static void parsePreEff(ActModel act, String formulaString) throws JAXBException {
		try {
			//get Abstract syntax tree with term
			String jadl= "(package de.dailab.test (act Test "+ formulaString + " abstract ) )";
		    Lexer lexer = new Lexer(new PushbackReader(new StringReader(jadl)));
		    Parser parser = new Parser(lexer);
		    Start ast = parser.parse();
		    
		    // transform model
		    ASTModelTransformer trans = new ASTModelTransformer(ast);
		    JADLDocument jadlDoc = (JADLDocument) trans.transform();
		    
		    //get FormulaModel
		    ActModel act2= (ActModel) jadlDoc.getAct().get(0);
		    act.setPrecondition(act2.getPrecondition());
		    act.getEffect().clear();
		    act.getEffect().addAll(act2.getEffect());
			
		} catch (Exception e) {
			System.err.println("Parsing pre-eff failed: \"" + formulaString + "\"");
		}
	}
	

	/**
	 * Parse BPMN Expression to TermModel. Here, if the expression is "unbind", then null is returned,
	 * else the method delegates to parseTerm(String).
	 * 
	 * @param expression	BPMN expression
	 * @return				JADL term
	 * @throws JAXBException
	 */
	public static TermModel parseTerm(Expression expression) throws JAXBException {
		TermModel termModel= null;
		if (expression != null) {
			if (expression.getExpression() == null ||
					expression.getExpression().equals("unbind")) {
				return null;
			}
			termModel= JiacMiniParser.parseTerm(expression.getExpression());
		}
		return termModel;
	}
	
	/**
	 * Parse String to TermModel.
	 * 
	 * @param termString	some string holding a valid JADL term
	 * @return				the term model according to the term
	 * @throws JAXBException
	 */
	public static TermModel parseTerm(String termString) throws JAXBException {
		StringModel stringModel= jadlFac.createStringModel();
		stringModel.setString(termString);
		TermModel term= stringModel;
		try {
			//get Abstract syntax tree with term
			String jadl= "(package de.dailab.test (act Test (pre true) (eff true) (script (seq (bind ?i " + termString + ") ) ) ) )";
		    Lexer lexer = new Lexer(new PushbackReader(new StringReader(jadl)));
		    Parser parser = new Parser(lexer);
		    Start ast = parser.parse();
		    
		    // transform model
		    ASTModelTransformer trans = new ASTModelTransformer(ast);
		    JADLDocument jadlDoc = (JADLDocument) trans.transform();
		    
		    //get TermModel
		    ActModel act= (ActModel) jadlDoc.getAct().get(0);
		    ScriptModel script= (ScriptModel) act.getBody();
		    SeqExecutionModel seq= (SeqExecutionModel) script.getScript();
		    StepModel step= (StepModel) seq.getSteps().get(0);
		    BindModel bind= (BindModel) step.getBind();
		    term= bind.getValue();
			
		} catch (Exception e) {
			System.err.println("Parsing term failed: \"" + termString + "\"");
		}
		return term;
	}
	
	/**
	 * Parse String to Script
	 * 
	 * @param scriptString	some string holding a valid JADL script
	 * @return				the model according to the script
	 * @throws JAXBException
	 */
	public static ScriptbodyModel parseScript(String scriptString) throws JAXBException {
		try {
			//get Abstract syntax tree with term
			String jadl= "(package de.dailab.test (act Test (pre true) (eff true) (script (seq  " + scriptString + ") ) ) )";
		    Lexer lexer = new Lexer(new PushbackReader(new StringReader(jadl)));
		    Parser parser = new Parser(lexer);
		    Start ast = parser.parse();
		    
		    // transform model
		    ASTModelTransformer trans = new ASTModelTransformer(ast);
		    JADLDocument jadlDoc = (JADLDocument) trans.transform();
		    
		    //get TermModel
		    ActModel act= (ActModel) jadlDoc.getAct().get(0);
		    ScriptModel script= (ScriptModel) act.getBody();
		    SeqExecutionModel seq= (SeqExecutionModel) script.getScript();
		    if (seq.getSteps().size() == 1) {
		    	return (ScriptbodyModel) seq.getSteps().get(0);
		    } else {
		    	return seq;
		    }
		} catch (Exception e) {
			System.err.println("Parsing script failed: \"" + scriptString + "\"");
		}
		return null;
	}	

}
