// Question: Longest Unequal Adjacent Groups Subsequence I

// You are given a string array words and a binary array groups both of length n, where words[i] is associated with groups[i].
// Your task is to select the longest alternating subsequence from words. A subsequence of words is alternating if for any two consecutive strings in the sequence, their corresponding elements in the binary array groups differ. Essentially, you are to choose strings such that adjacent elements have non-matching corresponding bits in the groups array.
// Formally, you need to find the longest subsequence of an array of indices [0, 1, ..., n - 1] denoted as [i0, i1, ..., ik-1], such that groups[ij] != groups[ij+1] for each 0 <= j < k - 1 and then find the words corresponding to these indices.
// Return the selected subsequence. If there are multiple answers, return any of them.
// Note: The elements in words are distinct.

// Example 1:
// Input: words = ["e","a","b"], groups = [0,0,1]
// Output: ["e","b"]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question2900{
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
    int groupId = -1;
    int n = groups.length;

    for (int i = 0; i < n; ++i)
      if (groups[i] != groupId) {
        groupId = groups[i];
        ans.add(words[i]);
      }

    return ans;
    }
    public static void main(String[] args) {
        String [] words = {"e","a","b"};
        int[] groups = {0,0,1};

        System.out.println(getLongestSubsequence(words, groups));
    }
}