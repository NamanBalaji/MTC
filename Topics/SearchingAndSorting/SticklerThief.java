package Topics.SearchingAndSorting;

public class SticklerThief {
    public static int maxLoot(int[] houses){
        if(houses.length == 0 || houses == null) return 0;

        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        
        for(int i=2; i<houses.length; i++){
            dp[i] =  Math.max(dp[i-1], houses[i] + dp[i-2]);
        }
        return dp[dp.length -1];
    } 

    public static void main(String[] args) {
        int  a[] = {5,5,10,100,10,5};
        System.out.println(maxLoot(a));
    }
}
