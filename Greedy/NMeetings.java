package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetings {
    public static int maxMeetings(int[] start, int[] end, int n){
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++){
            pairs[i] = new Pair(start[i], end[i]);
        }

        Arrays.sort(pairs, new Comparator<Pair>(){
            public int compare(Pair x,  Pair y){
                return x.second - y.second;
            }
        });

        int next = 0;
        int count = 0;

        for(int i = 0; i < n; i++){
            if(pairs[i].first > next){
                count+=1;
                next = pairs[i].second;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] =  {2,4,6,7,9,9};

        System.out.println("Maximum meetings: " + maxMeetings(start, end, n));

        n = 3;
        int[] start1 = {10, 12, 20};
        int[] end1 = {20, 25, 30};

        System.out.println("Maximum meetings: " + maxMeetings(start1, end1, n));
    }
}

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

}