// Question: Partition Labels... 
// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
// Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
// Return a list of integers representing the size of these parts.

// Example 1:
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]



package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question763 {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
    int[] rightmost = new int[26];

    for (int i = 0; i < s.length(); ++i)
      rightmost[s.charAt(i) - 'a'] = i;

    int l = 0; 
    int r = 0; 

    for (int i = 0; i < s.length(); ++i) {
      r = Math.max(r, rightmost[s.charAt(i) - 'a']);
      if (r == i) {
        ans.add(i - l + 1);
        l = i + 1;
      }
    }

    return ans;
        
    }
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(s);
        System.out.println(result);
    }
}
