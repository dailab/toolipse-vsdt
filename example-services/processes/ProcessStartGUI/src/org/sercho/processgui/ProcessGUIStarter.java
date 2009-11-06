package org.sercho.processgui;

public class ProcessGUIStarter {

	private static final AbstractProcessStartGUI[] guis= new AbstractProcessStartGUI[] {
			new EnergySavingGUI(),
			new LightAlarmGUI()
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String par= args[0];
		
		System.out.println("Delegating to GUI for specified Process...");
		System.out.println("Looking for Start GUI for Process " + par);
		for (AbstractProcessStartGUI gui : guis) {
			if (gui.getProcessName().equals(par)) {
				gui.initializeGUI();
				gui.initializeProperties();
				gui.initializeRuleClient();
				return;
			}
		}
		System.out.println("No matching Process Start GUI found");
		System.exit(1);
	}

}
