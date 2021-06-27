package Leetcode.coinChange;

import java.util.Arrays;
import java.util.Scanner;

class CoinChange{
    public static int coin(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] == i) {
                    dp[i] = 1;
                }
                else if(coins[j] < i && dp[i - coins[j]] > 0) {
                    dp[i] = (dp[i] == -1) ? dp[i - coins[j]] + 1 : Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        int ans = coin(coins, amount);
        System.out.println(ans);
    }
}