package Topics.SearchingAndSorting;

import java.util.*;

public class fourSum {
    public static ArrayList<ArrayList<Integer>> findNums(int[] nums, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return null;

        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int target2 = target - nums[i] - nums[j];
                int front = j+1;
                int back = n-1;

                while(front<back){
                    int twoSum = nums[front] + nums[back];
                    if(twoSum < target2) front++;
                    else if (twoSum > target2) back--;
                    
                    else{
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        res.add(quad);

                        while(front<back && nums[front] == quad.get(2)) ++front;
                        while(front<back && nums[back] == quad.get(3)) --back;
                    }
                }

                while(j+1 < n && nums[j+1] == nums[j]) ++j;
                while(i+1 < n && nums[i+1] == nums[i]) ++i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,2,1,1};
        ArrayList<ArrayList<Integer>> ans = findNums(arr, 3);
        System.out.println(ans);
    }
}
