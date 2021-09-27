package Topics.DP;

import java.util.Arrays;

public class longestIncreasingSubsequence {
    public static int lis(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(lis(arr));
    }
}
