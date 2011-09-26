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
  protected final String TEXT_1 = "class TimeoutEventHandler extends Thread{" + NL + "\tlong timeout;" + NL + "\tThread toStop;" + NL + "\tboolean triggered = false;" + NL + "\t/**" + NL + "\t *  delete the generated tag after you edited this method" + NL + "\t *  @generated" + NL + "\t */" + NL + "\tpublic TimeoutEventHandler(long timeout, Thread toStop){" + NL + "\t\tthis.timeout = timeout;" + NL + "\t\tthis.toStop = toStop;" + NL + "\t}" + NL + "\tpublic void run(){" + NL + "\t\ttry {" + NL + "\t\t\tThread.sleep(timeout);" + NL + "\t\t\ttriggered = true;" + NL + "\t\t\ttoStop.stop();" + NL + "\t\t}catch(InterruptedException e ) { }" + NL + "\t}" + NL + "\tpublic boolean hasBeenTriggered(){" + NL + "\t\treturn triggered;" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
