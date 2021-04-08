package CtCi.Arrays_and_Strings;

import java.util.Scanner;

public class IsUnique {
    public static boolean isUnique(String str){
        if (str.length() > 26) { // Only 26 characters
			return false;
		}
        boolean[] char_set = new boolean[128];
        for (int i=0; i<str.length(); i++){
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        sc.close();
        System.out.println("is Unique " + word+": " + isUnique(word));
    }
}
