package Topics.DP;

public class GoldMineProblem {
    public static int maxGold(int[][] mat){
        int[][] dp = new int[mat.length][mat[0].length];

        //set last column
        for(int j = mat.length-1; j>=0; j--){
            dp[j][mat.length-1] = mat[j][mat.length-1];
        }

        for(int j=mat[0].length-2;  j>=0; j--){
            for(int i=mat.length-1; i>=0; i--){
                int r, ru, rd;
                r = dp[i][j+1];

                if(i == 0){
                    ru = 0;
                }else {
                    ru = dp[i-1][j+1];
                }

                if(i == mat.length-1){
                    rd = 0;
                } else {
                    rd = dp[i+1][j+1];
                }

                dp[i][j]  = Math.max(r ,Math.max(ru, rd)) + mat[i][j];
            }
        }

        int maxGold = Integer.MIN_VALUE;
        for(int i=0; i<mat.length; i++){
            maxGold = Math.max(maxGold, dp[i][0]);
        }
        for(int i=0; i< mat.length; i++){
            for(int j=0; j< mat[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return maxGold;
    }

    public static void main(String[] args) {
        int mat[][] = {{10, 33, 13, 15},
        {22, 21, 04, 1},
        {5, 0, 2, 3},
        {0, 6, 14, 2}};

        System.out.println(maxGold(mat));
    }
}
