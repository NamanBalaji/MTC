package spiralMatrix;

import java.util.ArrayList;

public class SpiralMatrix {
    static ArrayList<Integer> traverse(int[][] nums){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int top =0; 
        int bottom = nums.length-1;
        int left =0;
        int right = nums[0].length-1;
        int size = nums.length*nums[0].length;
        while(ans.size()<size){
            for(int i=left; i<= right && ans.size()<size; i++){
                ans.add(nums[top][i]);
            }
            top++;
            for(int i=top; i<=bottom&&ans.size()<size; i++){
                ans.add(nums[i][right]);
            }
            right--;
            for(int i=right; i>=left&&ans.size()<size; i--){
                ans.add(nums[bottom][i]);
            }
            bottom--;
            for(int i =bottom;i>=top&&ans.size()<size; i--){
                ans.add(nums[i][left]);
            }
            left++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        ArrayList<Integer> answer = traverse(matrix);
        for (int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }
}
