// Question: LCS of three strings

// Given three strings s1, s2, and s3 containing uppercase letters, lowercase letters, and digits, find the length of longest common sub-sequence in all three given strings.

// Examples:
// Input: s1 = "geeks", s2 = "geeksfor", s3 = "geeksforgeeks"
// Output: 5
// Explanation: "geeks"is the longest common subsequence with length 5.

package shreyam.gfg;

public class LCSThreeStrrings{
    static int solve(String s1, String s2, String s3, int i, int j, int k, int[][][] dp) {
        
        if (i == 0 || j == 0 || k == 0) {
            return 0;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        
        if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
            
            return dp[i][j][k] = 1 + solve(s1, s2, s3, i - 1, j - 1, k - 1, dp);
        }

        return dp[i][j][k] = Math.max(
                   Math.max(solve(s1, s2, s3, i - 1, j, k, dp),
                            solve(s1, s2, s3, i, j - 1, k, dp)),
                   solve(s1, s2, s3, i, j, k - 1, dp));
    }
    static int lcsOf3(String s1, String s2, String s3) {
        int i = s1.length();
        int j = s2.length();
        int k = s3.length();

        int[][][] dp = new int[i + 1][j + 1][k + 1];

        for (int x = 0; x <= i; x++) {
            for (int y = 0; y <= j; y++) {
                for (int z = 0; z <= k; z++) {
                    dp[x][y][z] = -1;
                }
            }
        }

        return solve(s1, s2, s3, i, j, k, dp);
    }
    public static void main(String[] args) {
        String s1 = "geeks", s2 = "geeksfor", s3 = "geeksforgeeks";
        System.out.println(lcsOf3(s1, s2, s3));
    }
}
