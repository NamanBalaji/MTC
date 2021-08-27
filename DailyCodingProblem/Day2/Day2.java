package DailyCodingProblem.Day2;

// Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

public class Day2 {
    public static int[] productArray(int[] arr){
        if(arr == null || arr.length == 0) return new int[0];

        int ans[] = new int[arr.length];
        int product = 1;
        for(int i : arr){
            product *= i; 
        }

        for(int i = 0; i< arr.length; i++){
            ans[i] = product/arr[i];
        }
        return ans;
    }

    public static void print(int[] arr){
        for(int i: arr){
            System.out.print(i + ", ");
        }
    }
    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 4, 5};
        int nums2[] = {3, 2, 1};
        int []ans1 = productArray(nums1);
        int []ans2 = productArray(nums2);

        print(ans1);
        System.out.println();
        print(ans2);
    }
}

//Time: O(n)
//Space: O(1)