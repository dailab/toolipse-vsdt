package de.dailab.vsdt.trafo.jiacbeans.export.generated;

import de.dailab.vsdt.trafo.jiacbeans.*;
import jiacbeans.*;

public class SubProcessGenerator
{
  protected static String nl;
  public static synchronized SubProcessGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SubProcessGenerator result = new SubProcessGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * ";
  protected final String TEXT_2 = NL + " *  " + NL + " * @generated" + NL + " */" + NL + "class ";
  protected final String TEXT_3 = " {" + NL;
  protected final String TEXT_4 = NL + "\t/** @generated */" + NL + "\tprotected ";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = ";" + NL + "\t";
  protected final String TEXT_7 = NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_8 = NL + "\t *  " + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + " ";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    	SubProcess process = (SubProcess) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append( process.getDocumentation() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( process.getName() );
    stringBuffer.append(TEXT_3);
    	for (Variable var: process.getVariables()) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append( var.getType() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( var.getName() );
    stringBuffer.append(TEXT_6);
    	}

	for (Method method : process.getMethods()) {
		String result = Util.indent(SnippetGenerator.methodToCode(method));

    stringBuffer.append(TEXT_7);
    stringBuffer.append( method.getDocumentation() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( result );
    stringBuffer.append(TEXT_10);
    	} 

	for (SubProcess sub : process.getSubprocesses()) {
		String result = Util.indent(generate(sub));

    stringBuffer.append(TEXT_11);
    stringBuffer.append(	result );
    stringBuffer.append(TEXT_12);
    	} 
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
