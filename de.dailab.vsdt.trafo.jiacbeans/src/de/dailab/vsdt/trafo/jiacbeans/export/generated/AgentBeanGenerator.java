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
  protected final String TEXT_2 = NL + NL + "import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;" + NL + "import de.dailab.jiactng.agentcore.action.scope.ActionScope;";
  protected final String TEXT_3 = NL + "import ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "{";
  protected final String TEXT_8 = NL + "\tpublic final static String ";
  protected final String TEXT_9 = " = \"";
  protected final String TEXT_10 = "\"; ";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "\t";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL + "\t/**" + NL + "\t *  delete the generated tag after you edited this method" + NL + "\t *  @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_16 = NL + "\t@Expose(name = ";
  protected final String TEXT_17 = ", scope = ActionScope.GLOBAL)" + NL + "\t";
  protected final String TEXT_18 = NL + "\t";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     AgentBean bean = (AgentBean)argument; 
   String packageName = bean.getPackageName();
   String packageDeclaration = "";
   if(packageName.length()!=0){packageDeclaration = "package "+bean.getPackageName()+";";}
   String classDeclaration = "public class "+bean.getName()+" extends AbstractMethodExposingBean";
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

    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageDeclaration);
    stringBuffer.append(TEXT_2);
     for(String i : imports){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(classDeclaration);
    stringBuffer.append(TEXT_7);
     for(Action act: actions){
    stringBuffer.append(TEXT_8);
    stringBuffer.append( act.getName().toUpperCase());
    stringBuffer.append(TEXT_9);
    stringBuffer.append( act.getLocation());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
     for(JavaVariable var: attributes){
    stringBuffer.append(TEXT_12);
    stringBuffer.append( var.toString());
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
     for(Method method : methods){
    stringBuffer.append(TEXT_15);
    Action act = actionMap.get(method.getName());
	if(act!=null){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(act.getName());
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
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
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append( result+"\n");
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
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
	
    stringBuffer.append(TEXT_22);
    stringBuffer.append( result+"\n");
    }
    stringBuffer.append(TEXT_23);
     if(bean.isHandlingTimeoutEvent()){
    String cS = new TimeoutEventHandlerGenerator().generate(null);
	  String result = "";
	  BufferedReader reader = new BufferedReader(new StringReader(cS));
	  try{
	  	String line = reader.readLine();
		while(line!=null){
		  if(!line.equals(""))result+="\t"+line+"\n";
		  line = reader.readLine();
		}
	  }catch(IOException e){}
	
    stringBuffer.append(TEXT_24);
    stringBuffer.append( result+"\n");
    }
     if(bean.isHandlingMessageEvent()){
    String cS = new MessageEventHandlerGenerator().generate(null);
	  String result = "";
	  BufferedReader reader = new BufferedReader(new StringReader(cS));
	  try{
	  	String line = reader.readLine();
		while(line!=null){
		  if(!line.equals(""))result+="\t"+line+"\n";
		  line = reader.readLine();
		}
	  }catch(IOException e){}
	
    stringBuffer.append(TEXT_25);
    stringBuffer.append( result+"\n");
    }
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
