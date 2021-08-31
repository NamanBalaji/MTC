package Topics.DP;

public class coinChange {
    public static int totalWays(int sum, int[] coins){
        int cache[][] = new int[coins.length +1][sum+1];
        for(int i =0; i<= coins.length; i++){
            cache[i][0] = 1;
        }
        for(int i=1; i<=coins.length; i++){
            for(int j = 1; j<=sum; j++){
                if(coins[i-1] >j){
                    cache[i][j] = cache[i-1][j]; 
                } else{
                    cache[i][j] = cache[i-1][j] + cache[i][j-coins[i-1]];
                }
            }
        }
        return cache[coins.length][sum];
    }

    public static void main(String[] args) {
        int total = 15;
        int coins[] = {3,4,6,7,9};

        System.out.println(totalWays(total, coins));
    }
}
