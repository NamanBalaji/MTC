package CtCi.Bit_Manipulation;

public class NextNumber {
	
	public static int getNext(int num) {
		int indexOfZero = -1;
		int c0 = 0;
		int c1 = 0;
		
		for (int i = 0; i< 32; i++) {
			boolean bit = BitFunctions.getBit(num, i);
			if (!bit && c1>0) {
				indexOfZero = i;
				break;
			}
			if (bit) {
				c1++;
			} else {
				c0++;
			}
		}
		if (indexOfZero == -1) {
			return -1;
		}
		num = BitFunctions.setBit(num, indexOfZero);
		num = BitFunctions.clearBitsIthrough0(num, indexOfZero - 1);
		 for (int i = 0; i < c1 - 1; i++) {
	        num = BitFunctions.setBit(num, i);
	     }
		 return num;
	}
	
	public static int getPrev(int num) {
		int indexOfOne = -1;
		int c0 = 0;
		int c1 = 0;
		
		for (int i = 0; i < 32; i++) {
			boolean bit = BitFunctions.getBit(num, i);
			if (bit && c0 >0) {
				indexOfOne= i;
				break;
			}
			if (bit) {
				c1++;
			} else {
				c0 ++;
			}
		}
	    if (indexOfOne == -1) {
            return -1;
        }
		
	    int onesToAdd = c1+1;
	    int i = indexOfOne - 1;
	    while (onesToAdd > 0) {
	    	num = BitFunctions.setBit(num, i);
            onesToAdd--;
            i--;
	    }
	    return num;
	}
	
	public static void main(String[] args) {
		System.out.println("Original = " + 4);
        System.out.println("Smaller  = " + NextNumber.getPrev(4));
        System.out.println("Larger   = " + NextNumber.getNext(4) + "\n");
	}
}
