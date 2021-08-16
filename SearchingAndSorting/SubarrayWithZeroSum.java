package SearchingAndSorting;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithZeroSum {
    public static int findSubArray(int[] nums){
        int preSum = 0;
        int zeroSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            preSum += num;
            if(preSum == 0) zeroSum = zeroSum +1;
            if(map.containsKey(preSum)){
                zeroSum += map.get(preSum);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) +1);
        }
        return zeroSum;
    }

    public static void main(String[] args) {
        int arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
        System.out.println(findSubArray(arr));
    }
    
}
