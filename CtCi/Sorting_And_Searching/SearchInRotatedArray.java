package CtCi.Sorting_And_Searching;

public class SearchInRotatedArray {
    public static int search(int[] array, int target){
        int lo = 0;
        int hi = array.length-1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if (array[mid] == target) {
               return mid;
            }

            if(array[lo] < array[mid]) {
                if (array[lo] <= target && target < array[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (array[lo] > array[mid]) {
                if (array[mid] < target && target <= array[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else { // This iteration of while loop did not divide problem in half.
                lo++; // Removes just 1 invalid match.
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] rotatedArray = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
        int num = search(rotatedArray, 7);
        System.out.println(num);
    }
}
