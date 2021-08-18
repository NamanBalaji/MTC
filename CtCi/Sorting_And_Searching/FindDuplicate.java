package CtCi.Sorting_And_Searching;

import java.util.BitSet;

public class FindDuplicate {
    public static void checkDuplicates(int[] array) {
        BitSet bitset = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (bitset.get(num)) {
                System.out.print(num + " ");
            } else {
                bitset.set(num);
            }
        }
    }

    public static void main(String[] args) {
        checkDuplicates(new int[] { 3, 4, 4, 4, 1, 6, 1 });
    }
}
