package Topics.Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Defkin {

    public static int findPenalty(int[] w, int[] h, int n, int e){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        a.add(0);
        b.add(0);
        for(int i = 0; i<n; i++){
            a.add(w[i]);
            b.add(h[i]);
        }

        a.add(e);
        a.add(n);

        Collections.sort(a);
        Collections.sort(b);

        int mx = 0, my = 0;
        for(int i = 0; i< a.size()-1; i++){
            mx = Math.max(mx, a.get(i+1) - a.get(i) -1);
            my = Math.max(my, b.get(i+1) - b.get(i) -1);
        }
        return mx*my;
    }
}
