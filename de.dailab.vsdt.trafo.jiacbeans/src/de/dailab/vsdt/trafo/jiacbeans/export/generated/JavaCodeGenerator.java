package de.dailab.vsdt.trafo.jiacbeans.export.generated;

import de.dailab.vsdt.trafo.jiacbeans.export.*;
import jiacbeans.*;
import java.util.*;

public class JavaCodeGenerator
{
  protected static String nl;
  public static synchronized JavaCodeGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    JavaCodeGenerator result = new JavaCodeGenerator();
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
  protected final String TEXT_19 = " ";
  protected final String TEXT_20 = NL + NL + "}";

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
   Map<String,Action> actionMap = new HashMap<String,Action>();
   for(Action act : actions){
   		String methodName = act.getLocation().split("#")[1];
   		actionMap.put(methodName,act);
   }

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
    stringBuffer.append( method.toString()+"\n");
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
