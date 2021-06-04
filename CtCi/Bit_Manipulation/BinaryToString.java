package CtCi.Bit_Manipulation;

public class BinaryToString {
	
	private final static int MAX_CHARACTERS = 32;
	
	public static String binaryToString(double num) {
     	 if (num >= 1 || num <= 0) {
	            return "ERROR";
	     }
     	 
     	StringBuffer binary = new StringBuffer();
        binary.append(".");
        
        while(num > 0) {
        	num *= 2;
        	if (num >=1) {
        		binary.append(1);
        		num = num -1;
        	} else {
        		binary.append(0);
        	}
        	
        	if (binary.length() > MAX_CHARACTERS) {
        		return "ERROR";
        	}
        }
        
        return binary.toString();
	}
	
	public static void main(String[] args) {

        System.out.println("Decimal: " + 0.625 + "   Binary: " + binaryToString(0.625));
	}
}
