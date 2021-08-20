package Greedy;

import java.util.*;


public class JobSequencing {
    public static int maxProfit(int[] profit, int[] deadline, int n){
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        Job[] pairs = new Job[n];
        for(int i = 0; i < n; i++){
            pairs[i] = new Job(profit[i], deadline[i]);
        }

        Arrays.sort(pairs, new Comparator<Job>(){
            public int compare(Job x,  Job y){
                return y.profit - x.profit;
            }
        });

        int p = 0;
        for(int i=0; i<n; i++){
            if(used[pairs[i].deadline -1]){
                int time = pairs[i].deadline -2;
                while (time >=0){
                    if(!used[time]){
                        p += pairs[i].profit;
                        used[time] = true;
                        break;
                    }
                    time--;
                }
            } else{
                p += pairs[i].profit;
                used[pairs[i].deadline -1] = true;
            }
        }

        return p;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] profit = {100, 19, 27, 25, 15};
        int[] deadline = {2, 1, 2, 1, 1};

        System.out.println("Max Profit: " + maxProfit(profit, deadline, n));
    }
}

class Job {
    int profit;
    int deadline;

    Job(int profit, int deadline){
        this.profit = profit;
        this.deadline = deadline;
    }

}