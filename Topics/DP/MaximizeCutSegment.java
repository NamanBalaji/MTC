package Topics.DP;

import java.util.Arrays;

public class MaximizeCutSegment {
    public static int maxCuts(int n, int x, int y, int z){
        int[] cutsLength = {x, y, z};
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        int loopBack;
        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<3; j++){
                if(cutsLength[j] <= i){
                    loopBack = dp[i-cutsLength[j]];
                    if(loopBack != Integer.MIN_VALUE){
                        dp[i] = Math.max(1+loopBack, dp[i]);
                    }
                }
            }
        }
        return dp[n] != Integer.MIN_VALUE ? dp[n] : 0;
    }

    public static void main(String[] args) {
        int n = 5;
        int x = 5, y = 3, z = 2;
        System.out.println(maxCuts(n, x, y, z));
    }
}
