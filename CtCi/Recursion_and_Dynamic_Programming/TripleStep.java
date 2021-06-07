package CtCi.Recursion_and_Dynamic_Programming;

public class TripleStep {
    public static int tripleStep(int stairs) {
        int[] cache = new int[stairs +1];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;

        for (int i = 3; i < stairs+1; i++){
            cache[i] = cache[i-1] + cache[i-2] +cache[i-3]; 
        }
        return cache[stairs];
    }

    public static void main(String[] args) {
        System.out.println("Total ways to climb 5 steps : " + tripleStep(5));
    }
}
