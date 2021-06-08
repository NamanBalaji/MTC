package CtCi.Recursion_and_Dynamic_Programming;

import java.util.ArrayList;

public class PowerSet {
    public static ArrayList<ArrayList<Integer>> getAllSubsets(int[] array) {
        int totalSubsets = (int)Math.pow(2, array.length);
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

        for (int i=0; i< totalSubsets; i++){
            ArrayList<Integer> subset = new ArrayList<Integer>();
            int temp = i;
            for (int j = array.length-1; j >= 0; j--){
                int rem = temp % 2;
                temp  = temp/2;
                if(rem == 0){
                    continue;
                } else {
                    subset.add(array[j]);
                }
            }
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,5,4};
        System.out.println(getAllSubsets(array));
    }
}
