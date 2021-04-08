package CtCi.Arrays_and_Strings;

public class checkPermutation {
    public static boolean check(String s1, String s2){
        if (s1.length()!= s2.length()) return false;
        int []map = new int[128];
        for(int i=0; i<s1.length(); i++){
            map[s1.charAt(i)]++;
        }
        for(int i =0; i<s2.length(); i++){
            map[s2.charAt(i)]--;
            if(map[s2.charAt(i)]<0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = check(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
