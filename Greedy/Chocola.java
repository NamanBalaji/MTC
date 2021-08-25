package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class Chocola {
    public static int minCost(Integer[] x, Integer[] y, int m, int n){
        int res = 0;

        Arrays.sort(x, Collections.reverseOrder());
        Arrays.sort(y, Collections.reverseOrder());

        int h = 1; int v=1;

        int i =0, j=0;
        while(i<m && j <n){
            if(x[i] > y[j]){
                res += x[i]*v;
                h++;
                i++;
            } else{
                res += y[j]*h;
                v++;
                j++;
            }
        }

        int total = 0;
        while(i<m){
            total += x[i++]*v;
        }
        res += total;
        total = 0;
        while(j<n){
            total += y[j++]*v;
        }
        res+= total;
        return res;
    }

    public static void main(String[] args) {
        int m = 6, n = 4;
        Integer X[] = {2, 1, 3, 1, 4};
        Integer Y[] = {4, 1, 2};
        System.out.print(minCost(X, Y, m-1, n-1));
    }
}
