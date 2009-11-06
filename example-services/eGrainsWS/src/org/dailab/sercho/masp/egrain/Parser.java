package org.dailab.sercho.masp.egrain;

import java.util.StringTokenizer;

/**
 * 
 * @author bedime
 * class parsing the string from the comm port to EGrainNode
 */
public class Parser {

	private static float NAN = -1;
	
	private final Controller controller;
	
	public Parser() {
		super();
		this.controller = new Controller();
	} 
	/**
	 * parse the string from the comm line
	 */
	public void parse(String input){
		StringTokenizer token = new StringTokenizer(input,";");
		String prefix;
		String suffix;
		int id = -1;
		String temp= Node.TEMPERATUR_VALUE_NULL;
		while (token.hasMoreTokens()) {
			String str = (String)token.nextElement();
			if (str.contains("ID")) {
				prefix = str.substring(0, str.indexOf(':'));
				suffix = str.substring(str.indexOf(':')+1,str.length());
				id = Integer.parseInt(suffix);
			}
			if (str.contains("Temperatur")) {
				prefix = str.substring(0, str.indexOf(':'));
				suffix = str.substring(str.indexOf(':')+1,str.length());
				if (! suffix.equals("noack")) {
					temp = Float.toString(hexDec(suffix));
				}
				else {
					temp = Node.TEMPERATUR_VALUE_NOACK;
				}
			}
//			System.out.println("prefix "+id);
			
		}
		Node n = controller.getNode(id);
		if (n != null) {
			if (n.isRegistered()) {
				if (temp.equals(Node.TEMPERATUR_VALUE_NULL)) {
					n.setTemperatureValue(Node.TEMPERATUR_VALUE_NOACK);
					n.setEnabled(false);
				}
				else if (temp.equals(Node.TEMPERATUR_VALUE_NOACK)) {
					n.setTemperatureValue(Node.TEMPERATUR_VALUE_NOACK);
					n.setEnabled(false);
				}
				else{
					n.setTemperatureValue(temp);
					n.setEnabled(true);
				}
			}
			else{
				n.setRegistered(true);
				if (temp.equals(Node.TEMPERATUR_VALUE_NULL)) {
					n.setTemperatureValue(Node.TEMPERATUR_VALUE_NOACK);
					n.setEnabled(false);
				}
				else if (temp.equals(Node.TEMPERATUR_VALUE_NOACK)) {
					n.setTemperatureValue(Node.TEMPERATUR_VALUE_NOACK);
					n.setEnabled(false);
				}
				else{
					n.setTemperatureValue(temp);
					n.setEnabled(true);
				}
			}
			System.out.println(n.toString());
		}
 	}
	
	public Controller getController() {
		return controller;
	}

	private float hexDec(String hex){
		
		if (hex.equals("NOACK")) {
			return -1;
		}
		String m="";
		String c="";
		if (hex.contains(",")) {
			m = hex.substring(0,hex.indexOf(','));
			c = hex.substring(hex.indexOf(',')+1,hex.length());
		}
		float dec = 0;
		float mdec = 0;
		float cdec = 0;
        for ( int i = 0; i < m.length(); i++ ) {
           int digit = hexValue( hex.charAt(i) );
           digit = hexValue( hex.charAt(i) );
           if (digit == -1) {
               System.err.println("Error:  Input is not a hexadecimal number.");
               return NAN;
           }
           mdec = 16*mdec + digit;
           
        }
        for (int i = 0; i < c.length(); i++) {
        	int digit = hexValue( hex.charAt(i) );
            digit = hexValue( hex.charAt(i) );
        	if (digit == -1) {
                System.err.println("Error:  Input is not a hexadecimal number.");
                return NAN;
            }
        	cdec =cdec + digit * (float)Math.pow(16, -(i+1));
        	
		}
        dec = mdec + cdec;
		return dec;
		
	}
	
	 static int hexValue(char ch) {
         // Returns the hexadecimal value of ch, or returns
         // -1 if ch is not one of the hexadecimal digits.
      switch (ch) {
         case '0':
            return 0;
         case '1':
            return 1;
         case '2':
            return 2;
         case '3':
            return 3;
         case '4':
            return 4;
         case '5':
            return 5;
         case '6':
            return 6;
         case '7':
            return 7;
         case '8':
            return 8;
         case '9':
            return 9;
         case 'a':
         case 'A':
            return 10;
         case 'b':
         case 'B':
            return 11;
         case 'c':
         case 'C':
            return 12;
         case 'd':
         case 'D':
            return 13;
         case 'e':
         case 'E':
            return 14;
         case 'f':
         case 'F':
            return 15;
         default:
            return -1;
      }
   }  // end hexValue()
}
