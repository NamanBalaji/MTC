package Topics.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class WaterConnectionProblem {
    private static int[] outgoing;
    private static int[] incoming;
    private static int[] wt;

    private static ArrayList<ArrayList<Integer>> layout;

    private static void dfs(int w, int count, int i){
        if(outgoing[i] == 0){
            layout.get(count).add(i);
            layout.get(count).add(w);
            return;
        }
        w = wt[i];
        dfs(w, count, outgoing[i]);
    }

    public static ArrayList<ArrayList<Integer>> makeLayout(int h, int p, int a[], int b[], int c[]){
        outgoing = new int[h+1];
        incoming  = new int[h+1];
        wt = new int[h+1];
        layout  = new ArrayList<>();

        Arrays.fill(outgoing, 0);
        Arrays.fill(incoming, 0);
        Arrays.fill(wt, 0);

        int[][] graph  = new int[p][3];
        for(int i=0; i<p; i++){
            graph[i][0] =  a[i];
            graph[i][1] =  b[i];
            graph[i][2] =  c[i];
        }

        for(int i=0; i<p; i++){
            outgoing[graph[i][0]] = graph[i][1];
            wt[graph[i][0]] =  graph[i][2];
            incoming[graph[i][1]] = graph[i][0];
        }

        int count = 0;
        for(int i=1; i<h; i++){
            if(incoming[i] == 0 && outgoing[i] != 0){
                int minWt = Integer.MAX_VALUE;
                layout.add(new ArrayList<>());
                layout.get(count).add(i);
                dfs(minWt, count, i);
                count++;
            }
        }

        return layout;
    }

    public static void main(String[] args) {
        int h = 9;
        int p = 6;
        int[] a = {7,5,4,2,9,3};
        int[] b = {4,9,6,8,7,1};
        int[] c= {98,72,10,22,17,66}; 

        ArrayList<ArrayList<Integer>> ans  = makeLayout(h, p, a, b, c);
        System.out.println(ans);

    }
}
