package Topics.SearchingAndSorting;

import java.util.ArrayList;

import java.util.*;

public class MinSwapsToSort {
    public static int minSwaps(int[] arr, int n){
        ArrayList<pair> lst = new ArrayList<>();
        boolean vis[] = new boolean[n];
        int ans = 0;

        for(int i = 0; i < n; i++){
            lst.add(new pair(arr[i], i));
        }

        Collections.sort(lst, new MyComp());

        for(int i = 0; i < n; i++){

            pair p = lst.get(i);

            if(p.index == i){
                continue;
            }

            int j = p.index;
            int count = 0;

            while(j != i && !vis[j]){
                count++;
                vis[j] = true;
                j = lst.get(j).index;
            }

            vis[j] = true;

            ans += count;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {10, 19, 6, 3, 5};
        System.out.println(minSwaps(nums, 5));
    }
}


class pair{
    int num; 
    int index;

    pair(int num, int index){
        this.num = num;
        this.index = index;
    }
}

class MyComp implements Comparator<pair>{
    public int compare(pair p1, pair p2){
        return Integer.compare(p1.num, p2.num);
    }
}