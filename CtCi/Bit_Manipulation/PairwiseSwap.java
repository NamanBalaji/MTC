package CtCi.Bit_Manipulation;

public class PairwiseSwap {
    public static int pairwiseSwap(int num){
        int evenMask = 0xAAAAAAAA; // assumes 32-bit integer
        int oddMask  = 0x55555555; // assumes 32-bit integer
        return ((num & evenMask) >> 1) | ((num & oddMask) << 1);
    }

    public static void main(String[] args) {
        int num = 213309467;
        System.out.format("Original: %32s%n Swapped: %32s%n", Integer.toBinaryString(num),
        Integer.toBinaryString(pairwiseSwap(num)));
    }
   
}
