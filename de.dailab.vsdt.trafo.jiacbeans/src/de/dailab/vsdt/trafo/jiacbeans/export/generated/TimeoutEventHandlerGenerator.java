package de.dailab.vsdt.trafo.jiacbeans.export.generated;

public class TimeoutEventHandlerGenerator
{
  protected static String nl;
  public static synchronized TimeoutEventHandlerGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TimeoutEventHandlerGenerator result = new TimeoutEventHandlerGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t/**" + NL + "\t *  Inner class that handles timeout events" + NL + "\t *  @generated" + NL + "\t */" + NL + "\tclass TimeoutEventHandler extends Thread{" + NL + "\t\tlong timeout;" + NL + "\t\tThread toStop;" + NL + "\t\tboolean triggered = false;" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t *\tdelete the generated tag after you edited this method" + NL + "\t\t *  @generated" + NL + "\t\t */" + NL + "\t\tpublic TimeoutEventHandler(long timeout, Thread toStop){" + NL + "\t\t\tthis.timeout = timeout;" + NL + "\t\t\tthis.toStop = toStop;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t *\tdelete the generated tag after you edited this method" + NL + "\t\t *  @generated" + NL + "\t\t */" + NL + "\t\tpublic void run(){" + NL + "\t\t\ttry {" + NL + "\t\t\t\tThread.sleep(timeout);" + NL + "\t\t\t\ttriggered = true;" + NL + "\t\t\t\ttoStop.stop();" + NL + "\t\t\t}catch(InterruptedException e ) { }" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t *  returns the triggered flag" + NL + "\t\t *\tdelete the generated tag after you edited this method" + NL + "\t\t *  @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean hasBeenTriggered(){" + NL + "\t\t\treturn triggered;" + NL + "\t\t}" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
