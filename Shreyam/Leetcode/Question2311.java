// Question: Longest Binary Subsequence Less Than or Equal to K

// You are given a binary string s and a positive integer k.
// Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
// Note:
// The subsequence can contain leading zeroes.
// The empty string is considered to be equal to 0.
// A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 
// Example 1:
// Input: s = "1001010", k = 5
// Output: 5

package shreyam.leetCode;

public class Question2311{
    public static int longestSubsequence(String s, int k) {
        int n = s.length();
        long val = 0;
        int i = 0;
        while (i < Math.min(n, 32)) {
            if (s.charAt(n - i - 1) == '1') {
                long power = (long) Math.pow(2, i);
                if (val + power > k) {
                    break;
                }
                val += power;
            }
            i++;
        }
        int removed_count = 0;
        while (i < n) {
            if (s.charAt(n - i - 1) == '1') {
                removed_count++;
            }
            i++;
        }
        return n - removed_count;
        
    }
    public static void main(String[] args) {
        String s = "1001010";
        int k = 5;
        System.out.println(longestSubsequence(s, k));
    }
}