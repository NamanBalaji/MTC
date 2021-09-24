package Topics.DP;

public class NCR {
    public static int ncr(int n, int r){
        if(n < r){
            return 0;
        } 
        if(n==r) return 1;

        long[] cache = new long[n+1];
        cache[0] = 1;
        for(int i=1; i<n+1; i++){
            cache[i] = cache[i-1] * i;
        }
        int mod = 1000000007;
        long binomial = cache[n]/(cache[r]*cache[n-r]);
        return (int) (binomial%mod);
    }

    public static void main(String[] args) {
        System.out.println(ncr(15, 3));
    }
}
