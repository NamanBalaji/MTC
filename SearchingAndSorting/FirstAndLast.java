package SearchingAndSorting;

public class FirstAndLast {
    public static int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = firstOccurrence(nums, target);
        arr[1] = lastOccurrence(nums, target);
        
        return arr;
    }
    
    //first occurrence
    public static int firstOccurrence(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int res = -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                res = mid;
                end = mid-1;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return res;
    }
    
    //last occurrence
    public static int lastOccurrence(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int res = -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                res = mid;
                start = mid+1;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int[] ans = searchRange(arr, 5);

        System.out.println(ans[0] +" "+ ans[1]);
    }
}
