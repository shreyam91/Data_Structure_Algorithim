// Question: Anagram... 
// Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, "act" and "tac" are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.
// Note: You can assume both the strings s1 & s2 are non-empty.

// Examples :
// Input: s1 = "geeks", s2 = "kseeg"
// Output: true

package shreyam.GFG160;

public class Anagram {
    public static boolean areAnagrams(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int [] freq1 = new int[26];
        int [] freq2 = new int[26];

        for(int i=0; i<s1.length();i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        for(int i=0;i<26;i++){
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s1 ="geeks";
        String s2 = "kseeg";

        boolean res = areAnagrams(s1, s2);
        System.out.println(res);

    }
}
