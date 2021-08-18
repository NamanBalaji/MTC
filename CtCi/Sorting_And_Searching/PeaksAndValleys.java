package CtCi.Sorting_And_Searching;

import java.util.Arrays;

public class PeaksAndValleys {
    public static void arrange(int[] array){
        for (int i = 1; i < array.length; i += 2){
            if(array[i-1]< array[i]){
                swap(array, i - 1, i);
            }
            if (i + 1 < array.length && array[i + 1] < array[i]) {
                swap(array, i + 1, i);
            }
        }
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 5, 3, 1, 2, 3 };
        System.out.println("\nOriginal: " + Arrays.toString(array));
        arrange(array);
        System.out.println("Altered:  " + Arrays.toString(array));
    }
}
