// Question: Longest Palindrome by Concatenating Two Letter Words 

// You are given an array of strings words. Each element of words consists of two lowercase English letters.
// Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
// Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
// A palindrome is a string that reads the same forward and backward.

// Example 1:
// Input: words = ["lc","cl","gg"]
// Output: 6

package shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Question2131 {
    public static int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (map.getOrDefault(reversed, 0) > 0) {
                result += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (word.charAt(0) == word.charAt(1) && count > 0) {
                result += 2;
                break;
            }
        }

        return result;
    }
    public static void main(String[] args) {
       String[] words = {"lc","cl","gg"};
       System.out.println(longestPalindrome(words));
    }
}
