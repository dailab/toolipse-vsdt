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
  protected final String TEXT_2 = NL + NL + "import de.dailab.jiactng.agentcore.AbstractAgentBean;" + NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = "{" + NL + "int d = 0; " + NL + "int eps = 0;" + NL + "int n = 10;" + NL + "int dd = 20;";
  protected final String TEXT_5 = NL + "\t";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = NL + "\t/**" + NL + "\t *  delete the generated tag after you edited this method" + NL + "\t *  @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = NL + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     AgentBean bean = (AgentBean)argument; 
   String packageName = bean.getPackageName();
   String packageDeclaration = "";
   if(packageName.length()!=0){packageDeclaration = "package "+bean.getPackageName()+";";}
   String classDeclaration = "public class "+bean.getName()+" extends AbstractAgentBean";
   List<Method> methods = bean.getMethods();
   List<JavaVariable> attributes = bean.getAttributes();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageDeclaration);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(classDeclaration);
    stringBuffer.append(TEXT_4);
     for(JavaVariable var: attributes){
    stringBuffer.append(TEXT_5);
    stringBuffer.append( var.toString()+"\n");
    stringBuffer.append(TEXT_6);
    }
     for(Method method : methods){
    stringBuffer.append(TEXT_7);
    stringBuffer.append( method.toString()+"\n");
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
