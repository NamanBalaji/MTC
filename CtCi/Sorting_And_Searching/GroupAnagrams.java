package CtCi.Sorting_And_Searching;

import java.util.*;

public class GroupAnagrams {
    public static void groupAnagrams(String[] array) {
        HashMap<String, List<String>> map = new HashMap<>();

        // Group words by Anagram (by putting into HashMap)
        for (String str : array) {
            String key = createKey(str);
            map.putIfAbsent(key, new ArrayList<String>());
            List<String> anagrams = map.get(key);
            anagrams.add(str);
        }

        // Copy HashMap entries to array
        int index = 0;
        for (List<String> list : map.values()) {
            for (String str : list) {
                array[index++] = str; // overwrite the old values
            }
        }
    }

    private static String createKey(String str) {
        int[] array = new int[26]; // 26 is number of letters. Java initializes all values to 0.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            array[ch - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int x : array) {
          sb.append(x);
          sb.append('-');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] array = {"hello", "hi", "ih", "obb", "bob", "helol", "olleh", "god", "loleh", "lolhe", "asd", "nwr", "gsegae", "fesf"};
        groupAnagrams(array);
        System.out.println(Arrays.toString(array));
    }
}
