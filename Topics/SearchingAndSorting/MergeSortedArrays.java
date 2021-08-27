package Topics.SearchingAndSorting;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void merge(int[] arr1, int[] arr2){
        int i = arr1.length -1;
        int j = 0;
        while(j < arr2.length && i >= 0){
            if(arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {0, 2, 6, 8, 9};
        merge(arr1, arr2);
        for(int i=0;i<arr1.length; i++){
            System.out.print(arr1[i] + ", ");
        }
        for(int i=0; i< arr2.length; i++){
            System.out.print(arr2[i]+ ", ");
        }
    }
}
