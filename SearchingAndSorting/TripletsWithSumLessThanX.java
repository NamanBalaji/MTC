package SearchingAndSorting;

import java.util.Arrays;

public class TripletsWithSumLessThanX {
    public static int countTriplets(int[] nums, int sum){
        int count = 0;

        if(nums.length == 0 || nums == null) return count;

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            int target = sum - nums[i];
            int left = i + 1;
            int right = nums.length -1;
            
            while(left<=right){
                if(nums[left] + nums[right] >= target){
                    right--;
                } else{
                    count = count + 1;
                    left++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {-2, 0, 1, 3};
        System.out.println(countTriplets(arr, 2));
        int arr2[] = {5, 1, 3, 4, 7};
        System.out.println(countTriplets(arr2, 12));
    }
}
