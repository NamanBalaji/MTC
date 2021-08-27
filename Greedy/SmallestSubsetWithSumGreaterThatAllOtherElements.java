package Greedy;
import java.util.*;

public class SmallestSubsetWithSumGreaterThatAllOtherElements {
    public static int minElements(int arr[], int n){
        int halfSum = 0;
        for (int i = 0; i < n; i++)
            halfSum = halfSum + arr[i];
        halfSum = halfSum / 2;

        Arrays.sort(arr);
        int res = 0; 
        int currSum = 0;
        for (int i=n-1; i>=0; i--){
            currSum += arr[i];
            res++;
            if(currSum > halfSum){
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 7, 1};
        int n = arr.length;
        System.out.println(minElements(arr, n));
    }
}
