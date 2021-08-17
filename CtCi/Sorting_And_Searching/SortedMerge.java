package CtCi.Sorting_And_Searching;

import java.util.*;
public class SortedMerge {
    public static void merge(int[] a, int[] b, int lastA, int lastB){
        int curr = lastA + lastB + 1;
        while(lastA >= 0 && lastB >= 0) {
            if(a[lastA]>b[lastB]){
                a[curr--] = a[lastA--];
            } else {
                a[curr--] = b[lastB--];
            }
        }

        while (lastB >= 0) {
            a[curr--] = b[lastB--];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 3, 6, 8, 9, 0, 0, 0, 0 };
        int[] b =   new int[]{ 1, 2, 4, 7 };      
        merge(a, b, 3, 3);
        System.out.println("Merged: " + Arrays.toString(a));
    }
}
