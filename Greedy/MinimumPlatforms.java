package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumPlatforms {
    public static int minPlatforms(int[] arrivals, int[] departures){
        int n = arrivals.length;
        Times[] times = new Times[n];
        for(int i=0; i<n; i++){
            times[i] = new Times(arrivals[i], departures[i]);
        }
        Arrays.sort(times, new Comparator<Times>(){
            public int compare(Times x, Times y){
                return x.departure - y.departure;
            }
        });

        int c = 1; int next= 0;
        for(int i=1; i<times.length; i++){
            if(times[i].arrival <= times[next].departure){
                c++;
            } else {
                next++;
            }

        }
        return c;
    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(minPlatforms(arr, dep));

        int[] arr1 = {900, 1100, 1235};
        int[] dep1 = {1000, 1200, 1240};

        System.out.println(minPlatforms(arr1, dep1));

    }
}

class Times{
    int arrival;
    int departure;

    Times(int arrival, int departure){
        this.arrival = arrival;
        this.departure = departure;
    }
}
