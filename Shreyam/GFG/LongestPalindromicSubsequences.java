// Question: Longest Palindromic Subsequences.... 
// Given a string s, return the length of the longest palindromic subsequence.
// A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.
// A palindromic sequence is a sequence that reads the same forward and backward.

// Examples:
// Input: s = "bbabcbcab"
// Output: 7
// Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.

package shreyam.gfg;

import java.util.Arrays;

public class LongestPalindromicSubsequences {

    public static int f1(String s,String t, int i, int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        } 

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1 + f1(s,t,i-1,j-1,dp);
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int first = f1(s,t,i-1,j,dp);
        int second = f1(s,t,i,j-1,dp);

        return dp[i][j] = Math.max(first, second);
    }
    public static int longestPalinSubseq(String s) {
        int n = s.length();
        int [][] dp = new int[n][n];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        StringBuilder sb = new StringBuilder(s);
        String r = sb.reverse().toString();
        return f1(s,r,n-1,n-1, dp);
    }
    public static void main(String[] args) {
        String str = "bbabcbcab";
        int res = longestPalinSubseq(str);
        System.out.println(res);
    }
}
