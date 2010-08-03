package de.dailab.vsdt.jadltest;

import java.io.File;
import java.io.Serializable;

public class SquareRootTest {
	
	public static void main(String[] args) {
		// load service file
		File file= new File("code/ExtractRoot_Mathematican.jadl");
		if (! file.exists()) {
			System.err.println("file not found");
			System.exit(1);
		}
		// deploy service to agent
		InterpreterTest testPlatform= new InterpreterTest();
		testPlatform.initPlatform(new File[] {file}, null);
		
		// invoke service
		Serializable[] result= testPlatform.invokeService(InterpreterTest.AGENT_A, "ExtractRoot_Mathematican_start", true, 2d, 0.01 );
		Double res= (Double) result[0];
		System.out.println("--> SQUARE ROOT RESULT: " + res);
		
		// shutdown agent
		testPlatform.shutdown();
	}
	
}
