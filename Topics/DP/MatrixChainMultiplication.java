package Topics.DP;

public class MatrixChainMultiplication {
    public static int findCost(int[] arr){
        int memo[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++){
            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
                memo[i][j] = 1000000;
                for(int k=i+1; k < j; k++){
                    q = memo[i][k] + memo[k][j] + arr[i]*arr[k]*arr[j];
                    if(q < memo[i][j]){
                        memo[i][j] = q;
                    }
                }
            }
        }
        return memo[0][arr.length-1];
    }

    public static int matrixChainRecursive(int i, int j, int arr[]){
        if(i==j)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int cost = matrixChainRecursive(i, k, arr) + matrixChainRecursive(k+1, j, arr) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(cost, min);
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,3,5,3};
        int cost = findCost(arr);
        System.out.println(cost);
        System.out.println(matrixChainRecursive(1, 4, arr));
    }
}
