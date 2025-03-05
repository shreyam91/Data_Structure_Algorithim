// Question: Longest String Chain... 
// You are given an array of words where each word consists of lowercase English letters. wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB. For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.
// Return the length of the longest possible word chain with words chosen from the given list of words in any order.

// Examples:
// Input: words[] = ["ba", "b", "a", "bca", "bda", "bdca"]
// Output: 4
// Explanation: One of the longest word chains is ["a", "ba", "bda", "bdca"].

package shreyam.gfg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public static int longestStringChain(String words[]) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1; 
        
        for (String word : words) {
            int currentLength = 1; 
            
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                
                if (dp.containsKey(predecessor)) {
                    currentLength = Math.max(currentLength, dp.get(predecessor) + 1);
                }
            }
            
            dp.put(word, currentLength);
            
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
    public static void main(String[] args) {
        String words[] = {"ba", "b", "a", "bca", "bda", "bdca"};
        int res = longestStringChain(words);
        System.out.println(res);
    }
}
