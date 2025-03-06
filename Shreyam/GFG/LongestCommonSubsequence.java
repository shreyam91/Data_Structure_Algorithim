// Question: Longest Common Subsequence... 
// Given two strings s1 and s2, return the length of their longest common subsequence (LCS). If there is no common subsequence, return 0.
// A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "ABE" is a subsequence of "ABCDE".

// Examples:
// Input: s1 = "ABCDGH", s2 = "AEDFHR"
// Output: 3
// Explanation: The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", which has a length of 3.

package shreyam.gfg;

public class LongestCommonSubsequence {
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int [][] sequence = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    sequence[i][j] = sequence[i - 1][j - 1] + 1;
                } else {
                    sequence[i][j] = Math.max(sequence[i - 1][j], sequence[i][j - 1]);
                }
            }
        }

        return sequence[n][m];
    }
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "AC";

        int res = lcs(s1, s2);
        System.out.println(res);
    }
}
