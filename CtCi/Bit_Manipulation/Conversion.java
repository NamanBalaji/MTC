package CtCi.Bit_Manipulation;

public class Conversion {
	
	public static int conversion(int num1, int num2) {
		int xor = num1 ^ num2;
		return numOnes(xor);
	}
	
	public static int numOnes(int num) {
		int count = 0;
		for (int i=0; i < Integer.SIZE; i++) {
			if ((num & 1) == 1) {
				count++;
			}
			num >>= 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		 System.out.format("Bits required for converting %s to %2s is %d%n", Integer.toBinaryString(31),
	                Integer.toBinaryString(14), conversion(31, 14));
	}
}
