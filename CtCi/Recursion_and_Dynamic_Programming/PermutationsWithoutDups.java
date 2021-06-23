package CtCi.Recursion_and_Dynamic_Programming;

import java.util.ArrayList;

public class PermutationsWithoutDups {
    public static ArrayList<String> getPermutations(String str) {
        ArrayList<String> result = new ArrayList<String>();
        getPermutations("", str, result);
        return result;
    }

    public static void getPermutations(String prefix, String remainder, ArrayList<String> result) {
        if(remainder.length() == 0) {
            result.add(prefix);
        }
        int len = remainder.length();
        for (int i = 0; i < len; i++){
            String before = remainder.substring(0, i);
            String after = remainder.substring(i+1);
            char c = remainder.charAt(i);
            getPermutations(prefix + c, before+after, result);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPermutations("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
    }
}
