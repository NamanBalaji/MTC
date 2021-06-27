package Leetcode.jumpGame;

import java.util.Scanner;

public class JumpGame {
    static boolean canJump(int[] nums){
        if(nums == null || nums.length == 0) 
            return false; 
        int reachable = 0;
        for (int i=0; i<nums.length; i++){
           if(i>reachable) return false;
            else reachable = Math.max(reachable, i+ nums[i]);
       }
       return true;
    }
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0 ; i<n; i++){
            System.out.println("Enter "+i+ "th element: ");
            arr[i] = sc.nextInt();
        }
        boolean ans = canJump(arr);
        if(ans){
            System.out.println("Possible to jump.");
        }else{
            System.out.println("Cant jump.");
        }
    }
}
