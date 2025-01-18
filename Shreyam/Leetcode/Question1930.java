// Question:- Unique Length-3 Palindromic Subsequence 
// Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

// Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
// A palindrome is a string that reads the same forwards and backwards.
// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".

// Example 1:

// Input: s = "aabca"
// Output: 3
// Explanation: The 3 palindromic subsequences of length 3 are:
// - "aba" (subsequence of "aabca")
// - "aaa" (subsequence of "aabca")
// - "aca" (subsequence of "aabca").

package Shreyam.LeetCode;

import java.util.*;

public class Question1930 {
    public static int uniquePalindromicSubsequence(String s){
            int len = s.length();

            Map<Character,int[]> firstLast = new HashMap<>();
    
            for(int i=0;i<len;i++){
                char c = s.charAt(i);
                if(!firstLast.containsKey(c)){
                    firstLast.put(c, new int[]{i,i});
                }else{
                    firstLast.get(c)[1] =i;
                }
            }
            int count =0;
            for(Map.Entry<Character,int[]>entry:firstLast.entrySet()){
                int [] range = entry.getValue();
                if(range[0] == range[1]) continue;

                Set<Character> uniqueChar = new HashSet<>();
                for(int i=range[0]+1;i<range[1];i++){
                    uniqueChar.add(s.charAt(i));
                }
                count += uniqueChar.size();
            }
    
            return count;
            
        }
     public static void main(String[] args) {
        String s = "aabca";
        int result = uniquePalindromicSubsequence(s);
        System.out.println(" ");
        System.out.println("There are "+ result +" palindromic subsequence possible for given string..");
    
 }   
}
