/*
* generated by Xtext
*/
package de.dailab.vsdt.vxl.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import de.dailab.vsdt.vxl.services.VxlGrammarAccess;

public class VxlParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private VxlGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected de.dailab.vsdt.vxl.parser.antlr.internal.InternalVxlParser createParser(XtextTokenStream stream) {
		return new de.dailab.vsdt.vxl.parser.antlr.internal.InternalVxlParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "VxlTerm";
	}
	
	public VxlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(VxlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
