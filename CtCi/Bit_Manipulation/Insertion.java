package CtCi.Bit_Manipulation;

public class Insertion {
	public static int insertMintoN(int N, int M, int i, int j) {
		for (int index = i; index <= j; index++) {
			N = BitFunctions.clearBit(N, index);
		}
		M <<= i;
		return M|N;
	}
	
	public static void main(String[] args) {
		 int result = insertMintoN(0b10000000000, 0b10011, 2, 6);
	        System.out.println(Integer.toBinaryString(result));
	}
}
