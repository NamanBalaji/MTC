package medianOf2SortedArray;
import java.util.*;
public class medianOfArray {
    static double solution(int[] nums1, int[] nums2){
        int length = nums1.length + nums2.length;
        double arr[] = new double[length];
        int i=0, j=0, counter=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){
                arr[counter]=nums2[j];
                counter++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
               arr[counter]=nums1[i];
                counter++;
                i++; 
            }
            else {
                arr[counter] = nums1[i];
                counter++;
                i++;
                arr[counter] = nums2[j];
                counter++;
                j++;
            }
        }
            while(i<nums1.length){
                arr[counter] = nums1[i];
                counter++;
                i++;
            }
            while(j<nums2.length){
                arr[counter] = nums2[j];
                counter++;
                j++;
            }
        
           if(length%2==0){
               int mid = length/2;
               return (arr[mid] + arr[mid-1])/2;
           }
            int mid = length/2;
            return arr[mid];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2]; 
       
        for(int i=0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i=0; i<n1; i++){
            arr2[i] = sc.nextInt();
        }
        
        double ans = solution(arr1, arr2);
        System.out.println(ans);
    }
}
