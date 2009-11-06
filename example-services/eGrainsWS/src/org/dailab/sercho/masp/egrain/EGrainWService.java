package org.dailab.sercho.masp.egrain;


public class EGrainWService {

	private Controller controller ;
	private CommLink comm ;
	private static String COMM_PORT = "COM2";
	private static int TIMEOUT = 2000;
	
	public EGrainWService() {
		super();
		comm = new CommLink(COMM_PORT,TIMEOUT);
		controller = comm.getController();
		while (true) {
			try {
				comm.connect();
				System.out.println(comm.readInput());
				
				Thread.sleep(3000);
				comm.disconnect();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public int[] getIds(){
		return controller.getIDs();
	}
	
	public String getTemperature(Integer id){
		return controller.getNode(id).getTemperatureValue();
	}
	/**
	 * 
	 * @return true if the node was registered but don't appear any more
	 */
	public boolean isEnabled(int id) {
		return controller.getNode(id).isEnabled();
	}

	/**
	 * 
	 * @return true if the node is registered
	 */
	public boolean isRegistered(int id) {
		return controller.getNode(id).isRegistered();
	}
}
