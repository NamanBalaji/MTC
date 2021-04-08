package CtCi.Arrays_and_Strings;

import java.util.HashMap;

public class PallindromePermutation{
    public static boolean pallindromePermutation(String s){
        String str = removeSpaces(s);
        char[] arr = str.toCharArray();
        HashMap <Character, Integer> map = new HashMap<> ();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        for (char key: map.keySet()) {
            count += map.get(key) % 2;
        }
        
        return count <= 1;
    }

    public static String removeSpaces(String s){
        s = s.toLowerCase(); 
        char[] withWhitespaces = s.toCharArray();
        int whiteSpaces = 0;
        int counter = 0;
        for (int i=0; i<s.length(); i++){
            if(withWhitespaces[i] == ' ') whiteSpaces++;
        }
        
        int length = s.length() - whiteSpaces;
        char[] newString = new char[length];

        for(int i=0; i<s.length(); i++){
            if(withWhitespaces[i]==' '){
                continue;
            }
            newString[counter] = withWhitespaces[i];
            counter++;
        }

        return String.valueOf(newString);
    }

    public static void main(String[] args) {
        String pali = "tact coa";
		System.out.println(pallindromePermutation(pali));
		String pali2 = "Zeus was deified saw Suez";
		System.out.println(pallindromePermutation(pali2));
    }
}