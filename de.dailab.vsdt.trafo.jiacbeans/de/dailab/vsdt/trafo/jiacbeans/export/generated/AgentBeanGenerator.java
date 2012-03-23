package de.dailab.vsdt.trafo.jiacbeans.export.generated;

import jiacbeans.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;

public class AgentBeanGenerator
{
  protected static String nl;
  public static synchronized AgentBeanGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    AgentBeanGenerator result = new AgentBeanGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// VERSION 2" + NL + "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + NL + "public class ";
  protected final String TEXT_6 = " extends WorkflowBean {" + NL;
  protected final String TEXT_7 = NL + "\tpublic final static String ";
  protected final String TEXT_8 = " = \"";
  protected final String TEXT_9 = "\"; " + NL;
  protected final String TEXT_10 = NL + "\t/**" + NL + "\t *  <!-- begin-user-doc -->" + NL + "\t *  <!-- end-user-doc -->" + NL + "\t *  @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_11 = ";" + NL;
  protected final String TEXT_12 = NL + "\t/**" + NL + "\t *  <!-- begin-user-doc -->" + NL + "\t *  <!-- end-user-doc -->" + NL + "\t *  @generated" + NL + "\t */";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    	AgentBean bean = (AgentBean) argument; 
	Map<String, Action> actionMap = new HashMap<String, Action>();
	for (Action act : bean.getActions()) {
		String methodName = act.getLocation().split("#")[1];
		actionMap.put(methodName, act);
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append( bean.getPackageName() );
    stringBuffer.append(TEXT_2);
    	for (String i : bean.getImports()) { 
    stringBuffer.append(TEXT_3);
    stringBuffer.append( i );
    stringBuffer.append(TEXT_4);
    	} 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(bean.getName());
    stringBuffer.append(TEXT_6);
    	for (Action act: bean.getActions()) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append( act.getName().toUpperCase() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( act.getLocation() );
    stringBuffer.append(TEXT_9);
    	}

	for (JavaVariable var: bean.getAttributes()) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append( var.toString());
    stringBuffer.append(TEXT_11);
    	}

	for (Method method : bean.getMethods()) {
		String cS = method.toString();
		String result = "";
		BufferedReader reader = new BufferedReader(new StringReader(cS));
		try{
			String line = reader.readLine();
			while (line != null) {
				if (! line.isEmpty()) {
					result += "\t" + line + "\n";
				}
				line = reader.readLine();
			}
		} catch (IOException e) {}
		// add expose tag?
		Action act = actionMap.get(method.getName());
		if (act != null) {
			String expose = "\t@Expose(name=" + act.getName() + ", scope=ActionScope.GLOBAL)"; 
			result = expose + "\n" + result;
		} 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( result);
    stringBuffer.append(TEXT_14);
    	}

	SubProcessGenerator spg = new SubProcessGenerator();
	for (SubProcess sub : bean.getSubprocesses()) {
		String cS = spg.generate(sub);
		String result = "";
		BufferedReader reader = new BufferedReader(new StringReader(cS));
		try {
			String line = reader.readLine();
			while (line != null) {
				if (! line.isEmpty()) {
					result += "\t" + line + "\n";
				}
				line = reader.readLine();
			}
		} catch (IOException e) {}

    stringBuffer.append(TEXT_15);
    stringBuffer.append( result+"\n");
    	} 
    stringBuffer.append(TEXT_16);
    	/*
<%	if (bean.isHandlingTimeoutEvent()) { 
    stringBuffer.append(TEXT_17);
    stringBuffer.append( new TimeoutEventHandlerGenerator().generate(null));
    	} 
    	if (bean.isHandlingMessageEvent()) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append( new MessageEventHandlerGenerator().generate(null));
    	} 
    	if (bean.isHandlingTimeEvent()) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append( new TimeEventHandlerGenerator().generate(null));
    	} 
    	*/ 
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
