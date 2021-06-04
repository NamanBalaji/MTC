package CtCi.Bit_Manipulation;

public class FlipBitToWin {
	
	public static int flipBitToWin(int[] num) {
		int maxConsecutiveOne = 0;
		int start = 0;
		int k = 1;
		int zeroCount = 0;
		
		for (int end = 0; end < num.length; end ++) {
			if (num[end] == 0) {
				zeroCount++;
			}
			
			while (zeroCount > k) {
				if(num[start] == 0) {
					zeroCount--;
				}
				start++;
			}
			maxConsecutiveOne = Math.max(maxConsecutiveOne, end-start+1);
		}
		return maxConsecutiveOne;
	}
	
	public static int[] convertToArray(int num) {
		 int[] digits = Integer.toString(num).chars().map(c -> c-'0').toArray();
		 return digits;
	}
	
	public static void main(String[] args) {
		int test = 11010111;
		int[] arr = convertToArray(test);
		System.out.println(flipBitToWin(arr));
	}
	
}
