package Topics.DP;

public class PaintFence {
    static int totalWays(int k, int n){
        if(n == 1) return 1;
        int same = k*1;
        int diff = k*(k-1);
        int total = same + diff;

        for(int i=3; i<=n; i++){
            same = diff*1;
            diff = total*(k-1);
            total = same + diff;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(totalWays(3, 5));
    }
}
