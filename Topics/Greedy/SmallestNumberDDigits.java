package Topics.Greedy;

import java.util.Arrays;

public class SmallestNumberDDigits {

    public static int smallestNumber(int d, int s){
        int[] num = new int[d];
        Arrays.fill(num, 9);
        int sum = d*9;

        for(int i = 0; i<d; i++){
            if(sum>s){
                if(i == 0){
                    int sub = Math.min(8, sum-s);
                    num[i] -= sub;
                    sum -= sub;
                } else{
                    int sub = Math.min(9, sum-s);
                    num[i] -= Math.min(9, sum-s);
                    sum -= sub;
                }
            }
        }
        int ans = convert(num);
        return ans;
    }
    private static int convert(int[] array) {
        int result = 0;
        int offset = 1;
        for(int i = array.length - 1; i >= 0; i--) {
            result += array[i]*offset;
            offset *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber(2, 9));
        System.out.println(smallestNumber(3, 20));
        System.out.println(smallestNumber(6, 42));
    }
}
