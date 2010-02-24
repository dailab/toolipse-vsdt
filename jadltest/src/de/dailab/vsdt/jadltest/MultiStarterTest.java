package de.dailab.vsdt.jadltest;

import java.io.File;
import java.io.Serializable;

public class MultiStarterTest {
	
	public static void main(String[] args) {
		// load service file
		File file= new File("code/Multi-Start-Service_MultiStartTest.jadl");
		if (! file.exists()) {
			System.err.println("file not found");
			System.exit(1);
		}
		// deploy service to agent
		InterpreterTest testPlatform= new InterpreterTest();
		testPlatform.initPlatform(new File[] {file}, null);
		
		Serializable[] result;
		
		// invoke service variant 1
		// expected result: "Hallo WeltHalloWelt", 529, true
		result= testPlatform.invokeService(InterpreterTest.AGENT_A, "MultiStartTest_0", true, "Ein String", 23, false );
		for (Serializable res : result) {
			System.err.println("Results: " + res);
		}
		
		// invoke service variant 2
		// expected result: "ein anderer stringein anderer string", 10000, false 
		result= testPlatform.invokeService(InterpreterTest.AGENT_A, "MultiStartTest_1_0", true, true, "ein anderer String");
		for (Serializable res : result) {
			System.err.println("Results: " + res);
		}
		
		// invoke service variant 3
		// expected result:  "Service 3 ausgeführtService 3 ausgeführt", 12321, true
		result= testPlatform.invokeService(InterpreterTest.AGENT_A, "MultiStartTest_1_1", true, 111, false);
		for (Serializable res : result) {
			System.err.println("Results: " + res);
		}
		
		// shutdown agent
		testPlatform.shutdown();
	}
	
}
