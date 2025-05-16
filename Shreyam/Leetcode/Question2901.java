// Question: Longest Unequal Adjacent Groups Subsequence II

// You are given a string array words, and an array groups, both arrays having length n.
// The hamming distance between two strings of equal length is the number of positions at which the corresponding characters are different.
// You need to select the longest subsequence from an array of indices [0, 1, ..., n - 1], such that for the subsequence denoted as [i0, i1, ..., ik-1] having length k, the following holds:
// For adjacent indices in the subsequence, their corresponding groups are unequal, i.e., groups[ij] != groups[ij+1], for each j where 0 < j + 1 < k.
// words[ij] and words[ij+1] are equal in length, and the hamming distance between them is 1, where 0 < j + 1 < k, for all indices in the subsequence.
// Return a string array containing the words corresponding to the indices (in order) in the selected subsequence. If there are multiple answers, return any of them.
// Note: strings in words may be unequal in length.

// Example 1:
// Input: words = ["bab","dab","cab"], groups = [1,2,2]
// Output: ["bab","cab"]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question2901{
        public static  List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int n = groups.length;
    
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    
    int[] prev = new int[n];
    Arrays.fill(prev, -1);

    for (int i = 1; i < n; ++i)
      for (int j = 0; j < i; ++j) {
        if (groups[i] == groups[j])
          continue;
        if (words[i].length() != words[j].length())
          continue;
        if (hammingDist(words[i], words[j]) != 1)
          continue;
        if (dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
          prev[i] = j;
        }
      }

    
    int index = getMaxIndex(dp);
    while (index != -1) {
      ans.add(words[index]);
      index = prev[index];
    }

    Collections.reverse(ans);
    return ans;
  }

  private static int hammingDist(final String s1, final String s2) {
    int dist = 0;
    for (int i = 0; i < s1.length(); ++i)
      if (s1.charAt(i) != s2.charAt(i))
        ++dist;
    return dist;
  }

  private static int getMaxIndex(int[] dp) {
    int maxIndex = 0;
    for (int i = 0; i < dp.length; ++i)
      if (dp[i] > dp[maxIndex])
        maxIndex = i;
    return maxIndex;
  }
    public static void main(String[] args) {
        String [] words = {"bab","dab","cab"};
        int[] groups = {1,2,2};

        System.out.println(getWordsInLongestSubsequence(words, groups));
    }
}