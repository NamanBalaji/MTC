package SearchingAndSorting;

public class FirstAndLast {
    public static int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
    
        // the first binary search to find the left boundary
        int l = 0, r = nums.length-1;
        while(l < r) {
            int mid = (l+r)/2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
    
        // if target can not be found, return {-1, -1}
        if (nums[l] != target)
            return ret;
    
        ret[0] = l;
        // second binary search to find the right boundary
        r = nums.length-1;
        while(l < r) {
            // mid is calculated differently
            int mid = (l + r+1)/2;
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid;
        }
        ret[1] = l;
        return ret;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int[] ans = searchRange(arr, 5);

        System.out.println(ans[0] +" "+ ans[1]);
    }
}
