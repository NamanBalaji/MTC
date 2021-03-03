package peakElement;

import java.util.Scanner;

public class PeakElement {
    static int findPeak(int[] nums){
        return helper(nums, 0, nums.length-1);
    }
    static int helper(int[] nums, int start, int end){
        if (start == end){
            return start;
        }
        int mid = (start+end)/2;
        if(nums[mid] > nums[mid+1]) return helper(nums, start, mid);
        else return helper(nums, mid+1, end);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            System.out.println("Enter element: ");
            int val= sc.nextInt();
            arr[i] = val;
        }
       int ans =  findPeak(arr);
       System.out.println(ans);
    }
}
