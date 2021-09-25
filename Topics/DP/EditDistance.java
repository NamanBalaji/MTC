package Topics.DP;

public class EditDistance {
    public static int minChanges(String s1, String s2){
        int n= s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j = 0; j<= m; j++){
                if(i==0) dp[i][j] = j;
                if(j==0) dp[i][j] = i;
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) != s2.charAt(j-1)){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) +1;
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1 = "HelloThere";
        String s2 = "HiThere";
        
        System.out.println(minChanges(s1, s2));
    }
}
