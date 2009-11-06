package org.sercho.IvistarProxy.impl;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.sercho.IvistarProxy.IvistarProxyPT;
import org.sercho.controller.ivistar.service.IvistarService;
import org.sercho.controller.ivistar.service.IvistarServiceImpl;

public class IvistarProxyServiceImpl implements IvistarProxyPT{

	public static IvistarService service= new IvistarServiceImpl();

	@Override
    public String getRooms() throws RemoteException {
    	System.out.print("Invoking getRooms...");
    	String[] rooms= service.getRooms();
    	String ret= Arrays.toString(rooms);
    	System.out.println(ret);
    	return ret;
    }

	@Override
    public String getLights(String room) throws RemoteException {
    	System.out.print("Invoking getLights for "+room+"...");
    	List<String> lights= service.getLights(room);
    	String ret= Arrays.toString(lights.toArray());
    	System.out.println(ret);
        return ret;
    }

	@Override
    public String getShades(String room) throws RemoteException {
    	System.out.print("Invoking getShades for "+room+"...");
    	List<String> shades= service.getWindowShade(room);
    	String ret= Arrays.toString(shades.toArray());
    	System.out.println(ret);
    	return ret;
    }

	@Override
    public String getValue(String room, String line) throws  RemoteException {
    	System.out.print("Invoking setValue for "+room+", "+line+"...");
    	String ret= service.getValue(room, line);
    	System.out.println(ret);
    	return ret;
    }

    /**
     * this allows to set multiple lines at once
     */
	@Override
    public void setValue(String room, String line, String value) throws RemoteException {
    	System.out.println("Invoking setValue for "+room+", "+line+", "+value);
    	StringTokenizer st= new StringTokenizer(line);
    	while (st.hasMoreTokens()) {
    		String token= st.nextToken();
        	service.setValue(room, token, value);
    	}
    }
    
    public static void main(String[] args) {
		IvistarProxyServiceImpl proxy= new IvistarProxyServiceImpl();
		try {
			Thread.sleep(5000);
			
			System.out.println(proxy.getRooms());
			System.out.println(proxy.getLights("Studio"));
			System.out.println(proxy.getShades("Studio"));
			proxy.setValue("Studio", "28", "0");
			proxy.setValue("Studio", "34", "0");
			proxy.setValue("Studio", "31", "0");
			
			Thread.sleep(8000);
			System.exit(0);
		} catch (Exception e) {
		}
	}

}
