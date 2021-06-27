package Leetcode.longestIncreasingSubsequence;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    static int lis(int[] arr){
        if(arr.length==0){
            return 0;
        }
        int[] dp = new int[arr.length];
        for(int k=0; k<arr.length; k++){
            dp[k] = 1;
        }
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i]= dp[j]+1;
                    }
                }
            }
        }
        Arrays.sort(dp);;
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0 ; i<n; i++){
            System.out.println("Enter "+i+ "th element: ");
            arr[i] = sc.nextInt();
        }
        int ans = lis(arr);
        System.out.println("Longest increasing subsequence is of length: "+ ans);
    }
}
