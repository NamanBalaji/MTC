package CtCi.Bit_Manipulation;

public class BitFunctions {
	
	public static boolean getBit(int num, int bit) {
		return (num & (1 << bit)) != 0;
	}
	
	public static int setBit(int num, int bit) {
	    return num | (1 << bit);
	}

    public static int clearBit(int num, int bit) {
    	int mask = ~(1 << bit);
	    return num & mask;
    }

    public static int clearBitsMSBthroughI(int num, int bit) {
        int mask = (1 << bit) - 1; // subtracting 1 is the main trick.
        return num & mask;
    }

    public static int clearBitsIthrough0(int num, int bit) {
        int mask = ~((1 << (bit + 1)) - 1);
        return num & mask;
    }
}
