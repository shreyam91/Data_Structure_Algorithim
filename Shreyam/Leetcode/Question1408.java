// Question:- String matching in an Array... 
// Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

// A substring is a contiguous sequence of characters within a string

// Example 1:

// Input: words = ["mass","as","hero","superhero"]
// Output: ["as","hero"]
// Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
// ["hero","as"] is also a valid answer.

package Shreyam.LeetCode;

import java.util.*;

public class Question1408 {
    // public static String[] stringMatching(String[] s){
        // <!-- Brute Force Approiach-->
        // int length = s.length;
        // List<String> resultList = new ArrayList<>();

        // for(int i=0;i<length;i++){
        //     for(int j=0;j<length;j++){
        //         if (i != j && s[i].contains(s[j])) {
        //             // If s[i] contains s[j], add s[j] to the result
        //             if (!resultList.contains(s[j])) {
        //                 resultList.add(s[j]);
        //             }
        //         }
        //     }
        // }
        // String[] result = new String[resultList.size()];
        // resultList.toArray(result);
        
        // return result;
    // }

        // <!--- Optimal Approach ---->
     // Precompute LPS (Longest Prefix Suffix) array for all words
    public static void precomputeLPS(List<String> words, List<int[]> lps) {
        for (String word : words) {
            int m = word.length();
            int[] wordLPS = new int[m];
    
            // Two-pointer approach to calculate LPS
            int i = 1, j = 0;
            while (i < m) {
                if (word.charAt(i) == word.charAt(j)) {
                    wordLPS[i] = j + 1;
                    i++;
                    j++;
                } else if (j > 0) {
                    j = wordLPS[j - 1];
                } else {
                    i++;
                }
            }
            lps.add(wordLPS);
        }
    }
    
    // Function to match the pattern using LPS
    public static boolean stringMatcher(String pattern, int[] patternLPS, String text) {
        int patternSize = pattern.length();
        int textSize = text.length();
        int i = 0; // pattern pointer
        int j = 0; // text pointer
    
        while (i < patternSize && j < textSize) {
            if (pattern.charAt(i) == text.charAt(j)) {
                i++;
                j++;
            }
            if (i == patternSize) {
                return true;
            }
    
            if (j < textSize && pattern.charAt(i) != text.charAt(j)) {
                if (i > 0) {
                    i = patternLPS[i - 1];
                } else {
                    j++;
                }
            }
        }
        return false;
    }
    
    public static String[] stringMatching(String[] words) {
        int n = words.length;
    
        // STEP-1: Sort by word size
        Arrays.sort(words, Comparator.comparingInt(String::length));
    
        // STEP-2: Precompute LPS for all words
        List<int[]> lps = new ArrayList<>();
        precomputeLPS(Arrays.asList(words), lps);
    
        // STEP-3: Match all O(N^2) combinations of words
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stringMatcher(words[i], lps.get(i), words[j])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        
        // Convert the result list to an array
        String[] result = new String[res.size()];
        return res.toArray(result);
    }   
     
    public static void main(String[] args) {
        String [] words ={"mass","as","hero","superhero"}; 
        // String [] result = stringMatching(words);
        String[] result = stringMatching(words);

        for (String word : result) {
            System.out.println(word);
        }
    }
    
}
