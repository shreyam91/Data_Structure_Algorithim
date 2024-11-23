package Shreyam.String;

import java.util.HashMap;
import java.util.Map;

public class ValidShuffleTwoStrings {
    static boolean validShuffle(String str1, String str2, String shuffle) {
        int n1 = str1.length();
        int n2 = str2.length();
        int n = shuffle.length();

        if (n != n1 + n2) return false;

        HashMap<Character, Integer> freq = new HashMap<>();

        // Add characters of str1 to the map
        for (int i = 0; i < n1; i++) {
            freq.put(str1.charAt(i), freq.getOrDefault(str1.charAt(i), 0) + 1);
        }

        // Add characters of str2 to the map
        for (int i = 0; i < n2; i++) {
            freq.put(str2.charAt(i), freq.getOrDefault(str2.charAt(i), 0) + 1);
        }

        // Check characters of shuffle
        for (int i = 0; i < n; i++) {
            char ch = shuffle.charAt(i);
            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) - 1);
                if (freq.get(ch) == 0) {
                    freq.remove(ch);
                }
            } else {
                return false;
            }
        }

        return freq.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "BA";
        String str2 = "XZ";
        String shuffle = "ABZX";

        if (validShuffle(str1, str2, shuffle)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
