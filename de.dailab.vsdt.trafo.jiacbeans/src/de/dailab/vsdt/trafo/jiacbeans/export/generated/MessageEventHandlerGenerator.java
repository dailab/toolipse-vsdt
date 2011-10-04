package de.dailab.vsdt.trafo.jiacbeans.export.generated;

public class MessageEventHandlerGenerator
{
  protected static String nl;
  public static synchronized MessageEventHandlerGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    MessageEventHandlerGenerator result = new MessageEventHandlerGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "class MessageEventHandler extends Thread{" + NL + "\tThread toStop;" + NL + "\tboolean triggered = false;" + NL + "\tString address;" + NL + "\tClass payloadClass;" + NL + "\tSpaceObserver<IFact> observer;" + NL + "\tAction joinAction;" + NL + "\tAction leaveAction;" + NL + "\tIGroupAddress groupAddress;" + NL + "\t" + NL + "\tpublic MessageEventHandler(String channel, String payloadType, Thread toStop){" + NL + "\t\taddress = channel;" + NL + "\t\tthis.toStop = toStop;" + NL + "\t\tjoinAction = retrieveAction(ICommunicationBean.ACTION_JOIN_GROUP);" + NL + "\t\tleaveAction = retrieveAction(ICommunicationBean.ACTION_LEAVE_GROUP);" + NL + "\t\tgroupAddress = CommunicationAddressFactory.createGroupAddress(address);" + NL + "\t\ttry {" + NL + "\t\t\tpayloadClass = ClassLoader.getSystemClassLoader().loadClass(payloadType);" + NL + "\t\t} catch (ClassNotFoundException e) {" + NL + "\t\t\tlog.error(\"Class \"+payloadType+\" not Found!\");" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t} " + NL + "\t\tobserver = new SpaceObserver<IFact>(){" + NL + "\t\t\tpublic void notify(SpaceEvent<? extends IFact> event) {" + NL + "\t\t\t\tWriteCallEvent<IJiacMessage> wce = (WriteCallEvent<IJiacMessage>) event;" + NL + "\t\t\t\tIJiacMessage msg = wce.getObject();" + NL + "\t\t\t\tif(msg.getHeader(IJiacMessage.Header.SEND_TO).equals(address) &&" + NL + "\t\t\t\t   payloadClass.isInstance(wce.getObject().getPayload())){" + NL + "\t\t\t\t\tmemory.remove(wce.getObject());" + NL + "\t\t\t\t\tcompensate();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};\t\t" + NL + "\t}" + NL + "\t" + NL + "\tpublic void run(){" + NL + "\t\tinvoke(joinAction, new Serializable[]{groupAddress});" + NL + "\t\tmemory.attach(observer);" + NL + "\t}" + NL + "\t" + NL + "\tpublic void compensate(){" + NL + "\t\ttriggered = true;" + NL + "\t\tdetach();" + NL + "\t}" + NL + "\t" + NL + "\tpublic void detach(){" + NL + "\t\tmemory.detach(observer);" + NL + "\t\tinvoke(leaveAction, new Serializable[]{groupAddress});" + NL + "\t}" + NL + "\t" + NL + "\tpublic boolean hasBeenTriggered(){" + NL + "\t\treturn triggered;" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
