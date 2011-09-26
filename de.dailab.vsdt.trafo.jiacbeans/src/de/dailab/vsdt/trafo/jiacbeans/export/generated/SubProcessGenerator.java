package de.dailab.vsdt.trafo.jiacbeans.export.generated;

import de.dailab.vsdt.trafo.jiacbeans.export.*;
import jiacbeans.*;
import java.util.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "{" + NL + "" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\t";
  protected final String TEXT_4 = ";" + NL + "\t";
  protected final String TEXT_5 = NL + NL + "\t";
  protected final String TEXT_6 = NL + "\t\t/**" + NL + "\t \t *  delete the generated tag after you edited this method" + NL + "\t\t *  @generated" + NL + "\t\t */" + NL + "\t\t";
  protected final String TEXT_7 = " " + NL + "\t";
  protected final String TEXT_8 = NL + NL + "\t";
  protected final String TEXT_9 = NL + "\t\t";
  protected final String TEXT_10 = NL + "\t";
  protected final String TEXT_11 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     SubProcess process = (SubProcess)argument; 
   String classDeclaration = "class "+process.getName();
   List<Method> methods = process.getMethods();
   List<JavaVariable> attributes = process.getAttributes();
   List<SubProcess> subprocesses = process.getSubprocesses();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(classDeclaration);
    stringBuffer.append(TEXT_2);
     for(JavaVariable var: attributes){
    stringBuffer.append(TEXT_3);
    stringBuffer.append( var.toString());
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
     for(Method method : methods){
    stringBuffer.append(TEXT_6);
    stringBuffer.append( method.toString()+"\n");
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
     for(SubProcess sub : subprocesses){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(generate(sub));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
