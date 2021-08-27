package DailyCodingProblem.Day1;

import java.util.HashSet;

// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

public class Day1 {
    public static boolean findPair(int[] arr, int k){
        if(arr == null || arr.length <= 1) return false;

        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< n; i++){
            if(set.contains(k-arr[i])){
                return true;
            } 
            set.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {10, 15, 3, 7};
        System.out.println(findPair(nums, 17));
    }
}
