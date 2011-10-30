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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "import ";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = "{";
  protected final String TEXT_9 = NL + "\tpublic final static String ";
  protected final String TEXT_10 = " = \"";
  protected final String TEXT_11 = "\"; ";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "\t/**" + NL + "\t *  <!-- begin-user-doc -->" + NL + "\t *  <!-- end-user-doc -->" + NL + "\t *\tdelete the generated tag after you edited this method" + NL + "\t *  @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL + "\t/**" + NL + "\t *  <!-- begin-user-doc -->" + NL + "\t *  <!-- end-user-doc -->" + NL + "\t *\tdelete the generated tag after you edited this method" + NL + "\t *  @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_17 = NL + "\t@Expose(name = ";
  protected final String TEXT_18 = ", scope = ActionScope.GLOBAL)" + NL + "\t";
  protected final String TEXT_19 = NL + "\t";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = " ";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     AgentBean bean = (AgentBean)argument; 
   String packageName = bean.getPackageName();
   String packageDeclaration = "";
   if(packageName.length()!=0){packageDeclaration = "package "+bean.getPackageName()+";";}
   List<Method> methods = bean.getMethods();
   List<JavaVariable> attributes = bean.getAttributes();
   List<Action> actions = bean.getActions();
   List<String> imports = bean.getImports();
   List<SubProcess> subprocesses = bean.getSubprocesses();
   Map<String,Action> actionMap = new HashMap<String,Action>();
   for(Action act : actions){
   		String methodName = act.getLocation().split("#")[1];
   		actionMap.put(methodName,act);
   }
   SubProcessGenerator spg = new SubProcessGenerator();
   String importSuperClass = (actions.size()>0)? "import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;\nimport de.dailab.jiactng.agentcore.action.scope.ActionScope;":"import de.dailab.jiactng.agentcore.AbstractAgentBean;";
   String superClass = (actions.size()>0)?"AbstractMethodExposingBean" : "AbstractAgentBean";
   String classDeclaration = "public class "+bean.getName()+" extends "+superClass;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageDeclaration);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importSuperClass);
     for(String i : imports){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(classDeclaration);
    stringBuffer.append(TEXT_8);
     for(Action act: actions){
    stringBuffer.append(TEXT_9);
    stringBuffer.append( act.getName().toUpperCase());
    stringBuffer.append(TEXT_10);
    stringBuffer.append( act.getLocation());
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
     for(JavaVariable var: attributes){
    stringBuffer.append(TEXT_13);
    stringBuffer.append( var.toString());
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
     for(Method method : methods){
    stringBuffer.append(TEXT_16);
    Action act = actionMap.get(method.getName());
	if(act!=null){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(act.getName());
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    String cS = method.toString();
	  String result = "";
	  BufferedReader reader = new BufferedReader(new StringReader(cS));
	  try{
	  	String line = reader.readLine();
		while(line!=null){
		  if(!line.equals(""))result+="\t"+line+"\n";
		  line = reader.readLine();
		}
	  }catch(IOException e){}
	
    stringBuffer.append(TEXT_20);
    stringBuffer.append( result+"\n");
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
     for(SubProcess sub : subprocesses){
    String cS = spg.generate(sub);
	  String result = "";
	  BufferedReader reader = new BufferedReader(new StringReader(cS));
	  try{
	  	String line = reader.readLine();
		while(line!=null){
		  if(!line.equals(""))result+="\t"+line+"\n";
		  line = reader.readLine();
		}
	  }catch(IOException e){}
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append( result+"\n");
    }
    stringBuffer.append(TEXT_24);
     if(bean.isHandlingTimeoutEvent()){
    stringBuffer.append(TEXT_25);
    stringBuffer.append( new TimeoutEventHandlerGenerator().generate(null));
    }
     if(bean.isHandlingMessageEvent()){
    stringBuffer.append(TEXT_26);
    stringBuffer.append( new MessageEventHandlerGenerator().generate(null));
    }
     if(bean.isHandlingTimeEvent()){
    stringBuffer.append(TEXT_27);
    stringBuffer.append( new TimeEventHandlerGenerator().generate(null));
    }
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
