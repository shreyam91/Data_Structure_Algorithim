// Question: Minimum Deletions to Make String K-Special

// You are given a string word and an integer k.
// We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.
// Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value of y.
// Return the minimum number of characters you need to delete to make word k-special.

// Example 1:
// Input: word = "aabcaba", k = 0
// Output: 3

package shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Question3085{
    public static int minimumDeletions(String word, int k) {
        int n = word.length();
        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency of each character
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int res = Integer.MAX_VALUE;

        for (int f1 : freq.values()) {
            int deletions = 0;

            for (int f2 : freq.values()) {
                if (f2 < f1) {
                    deletions += f2;
                } else if (f2 - f1 > k) {
                    deletions += (f2 - f1 - k);
                }
            }

            res = Math.min(res, deletions);
        }

        return res;
    }
    public static void main(String[] args) {
       String word = "aabcaba";
       int k = 0 ;
        System.out.println(minimumDeletions(word, k));
    }
}