package de.dailab.vsdt.jadltest;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.dailab.jiactng.agentcore.IAgent;
import de.dailab.jiactng.agentcore.IAgentBean;
import de.dailab.jiactng.agentcore.SimpleAgentNode;
import de.dailab.jiactng.agentcore.lifecycle.LifecycleException;
import de.dailab.jiactng.jadl.ServiceDeployAgentBean;
import de.dailab.jiactng.jadl.ServiceDeployAgentBean.DeployState;

/**
 * Test class for testing JADL code generated with the VSDT JIAC-TNG Export.
 * 
 * Derived from JadlInterpreterInvokeTest
 * 
 * @author kuester
 */
public class InterpreterTest {
	
	public static final String CONFIG= "de/dailab/vsdt/jadltest/TestConfiguration.xml";
	public static final String NODE= "InterpreterNode";
	public static final String AGENT_A= "InterpreterAgentA";
	public static final String AGENT_B= "InterpreterAgentB";

	private static final Logger log = Logger.getLogger(InterpreterTest.class);

	private ClassPathXmlApplicationContext context;
	
	private SimpleAgentNode simpleAgentNode = null;


	public void initPlatform(File[] servicesForAgentA, File[] servicesForAgentB) {
		log.setLevel(Level.INFO);
		context = new ClassPathXmlApplicationContext(CONFIG);
		context.start();
		simpleAgentNode = (SimpleAgentNode) context.getBean(NODE);
		
		deployServices(getAgent(AGENT_A), servicesForAgentA);
		deployServices(getAgent(AGENT_B), servicesForAgentB);
	}
	
	private void deployServices(IAgent agent, File[] serviceFiles) {
		if (serviceFiles != null && serviceFiles.length > 0) {
			ServiceDeployAgentBean serviceDeployAgentBean = getServiceDeployBean(agent);
			for (File file : serviceFiles) {
				try {
					serviceDeployAgentBean.deployFile(file);
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			try {
				while (serviceDeployAgentBean.getDState().equals(
						DeployState.WAITING)) {
					Thread.sleep(150);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private IAgent getAgent(String name) {
		List<IAgent> agents = simpleAgentNode.findAgents();
		for (IAgent agent : agents) {
			if (agent.getAgentName().equals(name)) {
				return agent;
			}
		}
		return null;
	}
	
	private ServiceDeployAgentBean getServiceDeployBean(IAgent agent) {
		List<IAgentBean> beanList = agent.getAgentBeans();
		for (IAgentBean iab : beanList) {
			if (iab instanceof ServiceDeployAgentBean) {
				return(ServiceDeployAgentBean) iab;
			}
		}
		return null;
	}
	
	public void shutdown() {
		try {
			simpleAgentNode.shutdown();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
		context.stop();
	}
	
	public Serializable[] invokeService(String agent, String service, boolean waitForResult, Serializable... params) {
		ServiceDeployAgentBean serviceBean= getServiceDeployBean(getAgent(agent));
		try {
			serviceBean.invokeJadlService(service, params);
			if (waitForResult) {
				while (! serviceBean.getDState().equals(DeployState.RESULT_RECEIVED)) {
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
					}
				}
				return serviceBean.getInvokedServiceResults();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
