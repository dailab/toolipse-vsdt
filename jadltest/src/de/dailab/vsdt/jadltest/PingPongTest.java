package de.dailab.vsdt.jadltest;

import java.io.File;

public class PingPongTest {
	
	public static void main(String[] args) {
		// load service files
		File filePing= new File("code/Ping-Agent.jadl");
		File filePong= new File("code/Pong-Agent.jadl");
		if (! (filePing.exists() && filePong.exists())) {
			System.err.println("file not found");
			System.exit(1);
		}
		
		// deploy services to agents
		final InterpreterTest testPlatform= new InterpreterTest();
		testPlatform.initPlatform(new File[] {filePing}, new File[] {filePong});
		
		// invoke services
		testPlatform.invokeService(InterpreterTest.AGENT_A, "Ping-Agent", false, 1 );
		testPlatform.invokeService(InterpreterTest.AGENT_B, "Pong-Agent", true);

		// shutdown agent
		testPlatform.shutdown();
	}
	
}
