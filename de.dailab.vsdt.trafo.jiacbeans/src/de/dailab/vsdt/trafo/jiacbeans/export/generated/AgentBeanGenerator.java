package de.dailab.vsdt.trafo.jiacbeans.export.generated;

import de.dailab.vsdt.trafo.jiacbeans.*;
import jiacbeans.*;

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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "// common imports" + NL + "import java.io.Serializable;" + NL + "import org.sercho.masp.space.event.SpaceEvent;" + NL + "import org.sercho.masp.space.event.SpaceObserver;" + NL + "import org.sercho.masp.space.event.WriteCallEvent;" + NL + "import de.dailab.jiactng.agentcore.action.Action;" + NL + "import de.dailab.jiactng.agentcore.action.ActionResult;" + NL + "import de.dailab.jiactng.agentcore.action.scope.ActionScope;" + NL + "import de.dailab.jiactng.agentcore.comm.message.IJiacMessage;" + NL + "import de.dailab.jiactng.agentcore.comm.message.JiacMessage;" + NL + "import de.dailab.jiactng.agentcore.knowledge.IFact;" + NL + "import de.dailab.jiactng.agentcore.ontology.IActionDescription;" + NL + "import de.dailab.jiactng.agentcore.workflow.AbstractWorkflowBean;" + NL;
  protected final String TEXT_3 = NL + "// bean-specific imports";
  protected final String TEXT_4 = NL + "import ";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_7 = NL + " *" + NL + " * This Bean was created with the VSDT's BPMN-to-AgentBeans Transformation" + NL + " *" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends AbstractWorkflowBean {" + NL;
  protected final String TEXT_9 = NL + "\tpublic final static String ";
  protected final String TEXT_10 = " = \"";
  protected final String TEXT_11 = "\"; " + NL;
  protected final String TEXT_12 = NL + "\t/** @generated */" + NL + "\tprotected ";
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = ";" + NL;
  protected final String TEXT_15 = NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_16 = NL + "\t *  " + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = " ";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    	AgentBean bean = (AgentBean) argument; 

    stringBuffer.append(TEXT_1);
    stringBuffer.append( bean.getPackageName() );
    stringBuffer.append(TEXT_2);
    	if (! bean.getImports().isEmpty()) { 
    stringBuffer.append(TEXT_3);
    		for (String imprt: bean.getImports()) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append( imprt );
    stringBuffer.append(TEXT_5);
    		}
	} 
    stringBuffer.append(TEXT_6);
    stringBuffer.append( bean.getDocumentation() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(bean.getName());
    stringBuffer.append(TEXT_8);
    	for (Action act: bean.getActions()) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append( act.getVariableName().toUpperCase() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( act.getActionId() );
    stringBuffer.append(TEXT_11);
    	}

	for (Variable var: bean.getVariables()) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append( var.getType() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( var.getName() );
    stringBuffer.append(TEXT_14);
    	}

	for (Method method : bean.getMethods()) {
		String result = Util.indent(SnippetGenerator.methodToCode(method));
		// add expose tag?
		Action act = method.getExposedAs();
		if (act != null) {
			String expose = "\t@Expose(name=" + act.getVariableName() + ", scope=" + act.getScope() + ")"; 
			result = expose + "\n" + result;
		}

    stringBuffer.append(TEXT_15);
    stringBuffer.append( method.getDocumentation() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( result );
    stringBuffer.append(TEXT_18);
    	}

	SubProcessGenerator spg = new SubProcessGenerator();
	for (SubProcess sub : bean.getSubprocesses()) {
		String result = Util.indent(spg.generate(sub));

    stringBuffer.append(TEXT_19);
    stringBuffer.append( result );
    	} 
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
