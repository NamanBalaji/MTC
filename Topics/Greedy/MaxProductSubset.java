package Topics.Greedy;

public class MaxProductSubset {
    public static int maxProduct(int[] nums, int n){
        if(n ==1) return nums[n];

        int maxNeg = Integer.MIN_VALUE;
        int totalNeg = 0;
        int totalZero = 0;
        int product = 1;

        for(int i =0; i<n; i++){
            if(nums[i] == 0){
                totalZero++;

            }
            else if(nums[i] < 0){
                totalNeg++;
                maxNeg = Math.max(maxNeg, nums[i]);
                product =  product*nums[i];
            }
            else{
                product = product * nums[i];
            }
        }

        if(totalZero == n) return 0;
        if(totalNeg % 2 == 1){
            if(totalNeg == 1 && totalZero > 0 && totalZero +totalNeg == n){
                return 0;
            }
            product = product/maxNeg;
        }
        return product;
    }

    public static void main(String[] args) {
        int a[] = {-1, -1, -2, 4, 3};
        int n = a.length;
        System.out.println(maxProduct(a, n));
    }
}
