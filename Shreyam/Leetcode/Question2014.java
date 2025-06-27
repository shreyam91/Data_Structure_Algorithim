// Question: Longest Subsequence Repeated k Times

// You are given a string s of length n, and an integer k. You are tasked to find the longest subsequence repeated k times in string s.
// A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
// A subsequence seq is repeated k times in the string s if seq * k is a subsequence of s, where seq * k represents a string constructed by concatenating seq k times.
// For example, "bba" is repeated 2 times in the string "bababcba", because the string "bbabba", constructed by concatenating "bba" 2 times, is a subsequence of the string "bababcba".
// Return the longest subsequence repeated k times in string s. If multiple such subsequences are found, return the lexicographically largest one. If there is no such subsequence, return an empty string.

// Example 1:
// Input: s = "letsleetcode", k = 2
// Output: "let"

package shreyam.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Question2014{
    private static int countSubsequences(String s, String next) {
        int i = 0; 
        int j = 0; 
        int m = next.length();
        int subsequenceCount = 0;

        while (i < s.length()) {
            if (s.charAt(i) == next.charAt(j)) {
                j++;
                if (j == m) {
                    j = 0;
                    subsequenceCount++;
                }
            }
            i++;
        }
        return subsequenceCount;
    }

    public static String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; ++i) {
            freq[s.charAt(i) - 'a']++;
        }

        String curr = "";
        Queue<String> queue = new LinkedList<>();
        queue.offer(curr);
        String res = "";

        while (!queue.isEmpty()) {
            curr = queue.poll();
            
            for (char c = 'a'; c <= 'z'; ++c) {
                if (freq[c - 'a'] < k) {
                    continue;
                }
                String next = curr + c;
                if (countSubsequences(s, next) >= k) {
                    res = next;
                    queue.offer(next);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
       String s = "letsleetcode";
       int k = 2;
        System.out.println(longestSubsequenceRepeatedK(s, k));
    }
}