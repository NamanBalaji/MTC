package Leetcode.containerWithMostWater;

import java.util.*;
public class ContainerWithMostWater {
    static int maxArea(int[] height){
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0 ; i<n; i++){
            System.out.println("Enter "+i+ "th element: ");
            arr[i] = sc.nextInt();
        }
        int ans = maxArea(arr);
        System.out.println("Area of container that can hold maximum amount of water is :" + ans);
    }
}
