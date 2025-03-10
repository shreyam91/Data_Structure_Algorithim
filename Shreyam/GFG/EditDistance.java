// Question: Edit Distance... 
// Given two strings s1 and s2. Return the minimum number of operations required to convert s1 to s2. The possible operations are permitted:
// Insert a character at any position of the string.
// Remove any character from the string.
// Replace any character from the string with any other character.

// Examples:
// Input: s1 = "geek", s2 = "gesek"
// Output: 1
// Explanation: One operation is required, inserting 's' between two 'e' in s1.
package shreyam.gfg;

import java.util.Arrays;

public class EditDistance {
    public static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][]dp = new int[n+1][m+1];
        for(int[] row:dp) Arrays.fill(row, -1);
        return f(s1,s2,n,m,dp);
    }

    private static int f(String s1, String s2, int i, int j, int[][]dp){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = f(s1, s2, i-1, j-1, dp);
        }
        int rem = f(s1,s2,i-1,j,dp);
        int insert = f(s1, s2, i, j-1, dp);
        int replace = f(s1, s2, i-1, j-1, dp);
        return dp[i][j] = 1 + Math.min(rem, Math.min(insert,replace));
    }
    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "gesek";
        int res = editDistance(s1, s2);
        System.out.println(res);
    }
}
