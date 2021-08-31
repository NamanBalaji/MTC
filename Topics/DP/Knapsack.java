package Topics.DP;

public class Knapsack {
    public static int getMax(int W, int[] wt, int[] val){
        int[][] cache = new int[val.length +1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    cache[i][j] = 0;
                    continue;
                }

                if(j - wt[i-1] >= 0){
                    cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[val.length][W];
    }

    public static void main(String[] args) {
        int val[] = {1,2,3};
        int wt[] = {4,5, 1};
        int W = 4;
        System.out.println(getMax(W, wt, val));
    }
}
