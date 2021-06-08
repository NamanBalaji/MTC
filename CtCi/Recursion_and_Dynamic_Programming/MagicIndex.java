package CtCi.Recursion_and_Dynamic_Programming;

public class MagicIndex {
    public static int magicIndex(int[] array) {
        return magicHelper(array, 0, array.length-1);
    }

    private static int magicHelper(int[] array, int start, int end) {
        if(end < start){
            return -1;
        }
        int mid = (start+end)/2;
        if(mid == array[mid]) return mid;
        else if (array[mid] > mid) return magicHelper(array, 0, mid-1);
        else return magicHelper(array, mid+1, end);
    }

    public static void main(String[] args) {
        int[] sortedArray = { -5, -3, -1, 3, 5 };
        System.out.println("(Result should be 3) = " +magicIndex(sortedArray));
    }
}
