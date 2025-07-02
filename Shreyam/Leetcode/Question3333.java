// Question: Find the Original Typed String II

// Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.
// You are given a string word, which represents the final output displayed on Alice's screen. You are also given a positive integer k.
// Return the total number of possible original strings that Alice might have intended to type, if she was trying to type a string of size at least k.
// Since the answer may be very large, return it modulo 109 + 7.

// Example 1:
// Input: word = "aabbccdd", k = 7
// Output: 5

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question3333 {
    public static int possibleStringCount(String word, int k) {
    List<Integer> groups = getConsecutiveLetters(word);
    final int totalCombinations =
        (int) groups.stream().mapToLong(Integer::longValue).reduce(1L, (a, b) -> a * b % MOD);
    if (k <= groups.size())
      return totalCombinations;

    int[] dp = new int[k];
    dp[0] = 1; 

    for (int i = 0; i < groups.size(); ++i) {
      int[] newDp = new int[k];
      int windowSum = 0;
      int group = groups.get(i);
      for (int j = i; j < k; ++j) {
        newDp[j] = (newDp[j] + windowSum) % MOD;
        windowSum = (windowSum + dp[j]) % MOD;
        if (j >= group)
          windowSum = (windowSum - dp[j - group] + MOD) % MOD;
      }
      dp = newDp;
    }

    final int invalidCombinations = Arrays.stream(dp).reduce(0, (a, b) -> (a + b) % MOD);
    return (totalCombinations - invalidCombinations + MOD) % MOD;
  }

  private static final int MOD = 1_000_000_007;

  private static List<Integer> getConsecutiveLetters(final String word) {
    List<Integer> groups = new ArrayList<>();
    int group = 1;
    for (int i = 1; i < word.length(); ++i)
      if (word.charAt(i) == word.charAt(i - 1)) {
        ++group;
      } else {
        groups.add(group);
        group = 1;
      }
    groups.add(group);
    return groups;
  }
    public static void main(String[] args) {
        String word = "aabbccdd";
        int k = 7;
        System.out.println(possibleStringCount(word, k));
    }
}
