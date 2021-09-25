package Topics.DP;


public class PartitionEqualSubsetSum {
    public static boolean possiblePartition(int[] nums){
        int total = 0;
        
        for(int x : nums)
            total += x;
        
        if(total % 2 != 0)return false;
        
        int sum = total/2;
        
        boolean[] dp = new boolean[sum+1];
        
        dp[0] = true;

        for(int i=nums.length-1;i>=0;i--){
            for(int j=sum;j>=nums[i];j--)
                if(!dp[j])
                    dp[j] = dp[j - nums[i]];
        }
        
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 11, 10, 5};
        System.out.println(possiblePartition(arr));
    }
}
