package CtCi.Recursion_and_Dynamic_Programming;

public class Coins {
    public static int coins(int amount, int[] coins){
        int[] ways = new int[amount+1];
        ways[0] = 1;
        for(int i=1; i<amount+1; i++){
            for(int j = 0; j< coins.length; j++){
                if(i>=coins[j]){
                    ways[i] += ways[i-coins[j]];
                }
            }
        }
        return ways[amount];
    }

    public static void main(String[] args) {
        int n = 100;
        int[] coins = new int[]{1, 5, 10, 25};
        System.out.format("# of ways to make %3d cents (Using Quarters, Dimes, Nickels, Pennies) = %d\n", n, coins(n, coins));
    }
}
