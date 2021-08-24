package Greedy;

import java.util.*;

public class MaximumTrainStops {
    public static int maxStoppingTrains(int[] arrivals, int[] departures, int[] platforms){
        int n = arrivals.length;
        Train[] trains = new Train[n];
        HashMap<Integer, ArrayList<Train>> map = new HashMap<>();
        for(int i =0; i<n; i++){
            trains[i] = new Train(arrivals[i], departures[i], platforms[i]);
            if(map.containsKey(platforms[i])){
                map.get(platforms[i]).add(trains[i]);
            } else {
                ArrayList<Train> t = new ArrayList<>();
                t.add(trains[i]);
                map.put(platforms[i], t);
            }
        }

        for(Map.Entry<Integer, ArrayList<Train>> trainList : map.entrySet()){
            Collections.sort(trainList.getValue(), new Comparator<Train>(){
                public int compare(Train x, Train y){
                    return x.depart - y.depart;
                }
            });
        }

        int totalTrains = 0;
        for(Map.Entry<Integer, ArrayList<Train>> trainList : map.entrySet()){
            ArrayList<Train> trainsOnPlatform = trainList.getValue();
            int next = 0;
            int count = 0;
            for(int i = 0; i < trainsOnPlatform.size(); i++){
                if(trainsOnPlatform.get(i).arrival > next){
                    count+=1;
                    next = trainsOnPlatform.get(i).depart;
                }
            }
            totalTrains += count;
        }
        return totalTrains;
    }

    public static void main(String[] args) {
        int[] arrivals = {1000, 1010, 1025, 1130, 1130};
        int[] departures = {1030, 1020, 1040, 1145, 1140};
        int[] platforms = {1,1,1,2,2};

        System.out.println(maxStoppingTrains(arrivals, departures, platforms));
    }
}

class Train {
    int arrival;
    int depart;
    int platform;

    Train(int arrival, int depart, int platform){
        this.arrival = arrival;
        this.depart = depart;
        this.platform = platform;
    }
}