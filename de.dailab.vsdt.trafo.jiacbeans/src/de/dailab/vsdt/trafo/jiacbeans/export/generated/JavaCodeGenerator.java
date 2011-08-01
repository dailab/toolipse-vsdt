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
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "{" + NL;
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = NL + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     AgentBean bean = (AgentBean)argument; 
   String packageName = bean.getPackageName();
   String packageDeclaration = "";
   if(packageName.length()!=0){packageDeclaration = "package "+bean.getPackageName()+";";}
   String classDeclaration = "public class "+bean.getName()+" extends AbstractAgentBean";
   List<Method> methods = bean.getMethods();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(packageDeclaration);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(classDeclaration);
    stringBuffer.append(TEXT_5);
     for(Method method : methods){
    stringBuffer.append(TEXT_6);
    stringBuffer.append( method.toString()+"\n");
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
