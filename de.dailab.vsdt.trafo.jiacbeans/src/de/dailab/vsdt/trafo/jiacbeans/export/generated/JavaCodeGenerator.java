package de.dailab.vsdt.trafo.jiacbeans.export.generated;

import de.dailab.vsdt.trafo.jiacbeans.export.*;
import de.dailab.vsdt.trafo.jiacbeans.util.*;
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
  protected final String TEXT_3 = NL + "import ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "{" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     JavaCode jc = (JavaCode)argument; 
   String packageName = jc.getPackageName();
   String superClass = jc.getSuperClass();
   Set<String> interfaces = jc.getInterfaces();
   String packageDeclaration = "";
   if(packageName.length()!=0){packageDeclaration = "package "+jc.getPackageName()+";";}
   String classDeclaration = "public class "+jc.getClassName();
   if(superClass!=null)classDeclaration += " extends "+superClass;
   if(interfaces.size()!=0){
   		boolean first = true;
   		classDeclaration+=" implements ";
   		for(String  s : interfaces){
   			if(!first) classDeclaration += ", ";
   			classDeclaration += s;
   		}
   }

    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageDeclaration);
    stringBuffer.append(TEXT_2);
     for(String className : jc.getImports()){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(classDeclaration);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
