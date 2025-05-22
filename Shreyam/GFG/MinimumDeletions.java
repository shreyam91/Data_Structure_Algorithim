// Question: Minimum Deletions 

// Given a string s, write a program to delete the minimum number of characters from the string so that the resultant string is a palindrome, while maintaining the order of characters.

// Examples:
// Input: s = "aebcbda"
// Output: 2
// Explanation: Remove characters 'e' and 'd'.


package shreyam.gfg;

public class MinimumDeletions {
    static int minDeletions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        return n - longestCommonSubsequence(s, rev);
    }

    static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }
    public static void main(String[] args) {
       String s = "aebcbda";
        System.out.println(minDeletions(s));
    }
}

