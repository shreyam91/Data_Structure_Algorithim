// Question:- Construct K Palindrome Strings... 
// Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

// Example 1:
// Input: s = "annabelle", k = 2
// Output: true
// Explanation: You can construct two palindromes using all characters in s.
// Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"

package Shreyam.leetCode;

public class Question1400 {
    static boolean constructPalindrome(String s, int k){
        if(k> s.length()) return false;
        if(k == s.length()) return true;

        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        int oddFreqCount = 0;
        for(int i =0; i<26; i++){
            if(freq[i]%2 != 0){
                oddFreqCount++;
            }
        }

        return oddFreqCount <= k;
    }
    public static void main(String[] args) {
        String s = "true";
        int k = 4;
        boolean result = constructPalindrome(s, k);
        System.out.println(result);
    }
}
