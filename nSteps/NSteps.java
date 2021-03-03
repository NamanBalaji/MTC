package nSteps;
import java.util.*;
public class NSteps {
    public static int totalWays(int steps){
        int ways[]  = new int[steps+1];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        for (int i=3; i<=steps;  i++){
            ways[i] = ways[i-2] + ways[i-1] + ways[i-3]; 
        }
        return ways[steps];
    }
    public static void main(String args[]){
        Scanner  sc = new Scanner(System.in);
        System.out.println("Enter total number of steps: ");
        int val = sc.nextInt();
        int way = totalWays(val);
        System.out.println("Total number to ways to reach at top are " + way);
    }

}
