
package org.sercho.SheaSimulator.impl;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.rpc.holders.FloatHolder;
import javax.xml.rpc.holders.StringHolder;

import org.sercho.SheaSimulator.SheaSimulatorPT;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.dailab.jiactng.ruleengine.IJiacRuleEngineBean;
import de.dailab.shea.simulator.ontology.Light;
import de.dailab.shea.simulator.ontology.Person;
import de.dailab.shea.simulator.ontology.Appliance.ApplianceState;

public class SheaSimulatorServiceImpl implements SheaSimulatorPT{
    
	protected static ClassPathXmlApplicationContext context;
	
	protected static Zone[] zones= {
		new Zone("Sofa",185,215,270,290),
		// Room Names According to Ivistar
		new Zone("Kitchen",0,0,150,300),
		new Zone("Living Room",150,0,485,300),
		new Zone("Office",485,0,655,300),
		new Zone("Studio",655,0,1000,300)
	};

	@Override
	public String startSimulator() throws RemoteException {
		System.out.println("Invoking StartSimulator");
		context= new ClassPathXmlApplicationContext("/de/dailab/shea/simulator/sheaSimulatorAgent.xml");
		return "StartSimulator invoked";
    }

	@Override
    public void getLocation(String username, StringHolder roomname, FloatHolder posx, FloatHolder posy, FloatHolder posz, StringHolder zones) throws RemoteException {
    	System.out.print("Invoking getLocation...");
        if (username == null) {
    		System.err.println("Name is null");
    	}
        roomname.value = new java.lang.String();
        posx.value = 0;
        posy.value = 0;
        posz.value = 0;
        zones.value = new String();

        Person person= getPerson(username);
        if (person != null) {
        	posx.value= getX(person);
			posy.value= getY(person);
        	if (person.getRoom() != null) {
				roomname.value= person.getRoom().getName();
				if ("Outside".equals(person.getRoom().getName())) {
					posx.value= 0;
					posy.value= 0;
				}
			}
			zones.value= Arrays.toString(getZones(person));
        }
        System.out.print(roomname.value);
        System.out.print(posx.value);
        System.out.print(posy.value);
        System.out.print(zones.value);
    }

	@Override
    public BigInteger isInZone(String username, String zone) throws RemoteException {
    	System.out.print("Invoking IsInZone ("+username+", "+zone+") ...");
    	Person person= getPerson(username);
    	if (person != null) {
    		String[] zones= getZones(person);
    		for (String z : zones) {
    			System.out.println(z);
    			if (z.contains(zone)) {
    				System.out.println("true");
    				return BigInteger.ONE;
    			}
    		}
    	}
    	System.out.println("false");
        return BigInteger.ZERO;
    }
    
    protected Person getPerson(String username) {
    	IJiacRuleEngineBean bean= getBean();
    	if (bean != null) {
    		Object[] facts= bean.getFacts();
//    		System.out.println("Number of facts: " + facts.length);
    		for (Object fact : facts) {
    			if (fact instanceof Person) {
    				Person person= (Person) fact;
    				if (username.equals(person.getName())) {
//    					System.out.println("Person found");
    					return person;
    				}
				}
    		}
    	} else {
    		System.err.println("Rules Bean is null");
    	}
		return null;
    }

    protected IJiacRuleEngineBean getBean() {
    	if (context == null) {
    		System.err.println("Context is null");
    		return null;
    	}
    	IJiacRuleEngineBean bean= (IJiacRuleEngineBean) context.getBean("RuleEngineBean");
    	if (bean == null) {
    		System.err.println("Rules Bean is null");
    	}
    	return bean;
    }
    
    protected String[] getZones(Person person) {
		List<String> zones= new ArrayList<String>();
		// current room
		zones.add(person.getRoom().getName());
		// defined zones
		for (Zone z : SheaSimulatorServiceImpl.zones) {
			if (z.contains(getX(person), getY(person))) {
				zones.add(z.name);
			}
		}
		String[] array= new String[zones.size()];
		return zones.toArray(array);
    }
    
    private int getX(Person p) {
    	return p.getPosition().x;
    }
    
    private int getY(Person p) {
    	return p.getPosition().y - 150;
    }
    
    // -------------- Lights ----------------
    
    @Override
    public BigInteger getLight(String id) throws RemoteException {
    	Light light= getLightByName(id);
    	if (light != null) {
    		if (light.getState() == ApplianceState.ON) {
    			int val= (int) (light.getBrightness() * 100);
    			return BigInteger.valueOf(val);
    		} else {
    			return BigInteger.ZERO;
    		}
    	}
    	return BigInteger.valueOf(-1);
    }
    
    @Override
    public void setLight(String id, BigInteger state) throws RemoteException {
    	Light light= getLightByName(id);
    	if (light != null) {
    		int val= state.intValue();
    		light.setState( state.intValue() > 0 ? ApplianceState.ON : ApplianceState.OFF);
    		light.setBrightness(((float)val)/100f);
    	}
    }
    
    protected Light getLightByName(String name) {
    	for (Light light : getLights()) {
//    		System.out.println(light.getRoom().getName());
    		if (light.getRoom().getName().toLowerCase().contains(name.toLowerCase())) {
    			return light;
    		}
    	}
    	return null;
    }
    
    protected List<Light> getLights() {
    	IJiacRuleEngineBean bean= getBean();
    	List<Light> lights= new ArrayList<Light>();
    	if (bean != null) {
    		Object[] facts= bean.getFacts();
//    		System.out.println("Number of facts: " + facts.length);
    		for (Object fact : facts) {
    			if (fact instanceof Light) {
    				lights.add((Light) fact);
				}
    		}
    	} else {
    		System.err.println("Rules Bean is null");
    	}
		return lights;
    }
    
    
    public static void main(String[] args) {
		SheaSimulatorServiceImpl impl= new SheaSimulatorServiceImpl();
		try {
			
			impl.startSimulator();
			Thread.sleep(2000);
			System.out.println(impl.getLight("living"));
			Thread.sleep(10000);
			impl.setLight("living", BigInteger.ONE);
			System.out.println(impl.getLight("living"));
			Thread.sleep(10000);
			impl.setLight("living", BigInteger.ZERO);
			System.out.println(impl.getLight("living"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
