package DailyCodingProblem.Day4;

// Given an array of integers, find the first missing positive integer in linear time and constant space. 
//In other words, find the lowest positive integer that does not exist in the array. 
//The array can contain duplicates and negative numbers as well.
// For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

public class Day4 {
    public static int minMissingPositive(int[] arr){
        if(arr == null || arr.length == 0){
            return 1;
        }
        int n = arr.length, containsOne =0;

        for(int i=0; i< n; i++){
            if(arr[i] == 1){
                containsOne = 1;
            } else if(arr[i] <= 0 || arr[i] > n){
                arr[i] = 1;
            }
        }

        if(containsOne == 0) return 1;

        for(int i=0; i<n; i++){
            int index = Math.abs(arr[i]) -1;  
            if(arr[index]>0){
                arr[index] *= -1;
            }
        }

        for(int i=0; i<n; i++){
            if(arr[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int nums[] = {3, 4, -1, 1};
        int nums2[] = {1, 2, 0};

        System.out.println(minMissingPositive(nums));
        System.out.println(minMissingPositive(nums2));
    }
}

//Time: O(n)
//Space: O(1)