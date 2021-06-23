package CtCi.Recursion_and_Dynamic_Programming;

public class RecursiveMultiply {
    public static int recursiveMultiply(int m, int n) {
        int bigger =  m < n ? m : n;
        int smaller =  m < n ? n : m;
        return helper(smaller, bigger);
    }

    public static int helper(int smaller, int bigger){
        if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		} 
		
		int s = smaller >> 1;
		int halfProd = helper(s, bigger);
		
		if (smaller % 2 == 0) {
			return halfProd + halfProd;
		} else {
			return halfProd + halfProd + bigger;
		}
    }

    public static void main(String[] args) {
        System.out.println(recursiveMultiply(4, 3));
        System.out.println(recursiveMultiply(0, 3));
    }
}
