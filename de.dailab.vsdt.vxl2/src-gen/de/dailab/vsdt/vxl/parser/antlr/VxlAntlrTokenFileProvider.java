/*
 * generated by Xtext
 */
package de.dailab.vsdt.vxl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class VxlAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.tokens");
	}
}
