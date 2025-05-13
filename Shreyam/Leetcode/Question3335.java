// Question: Total Characters in String After Transformations I

// You are given a string s and an integer t, representing the number of transformations to perform. In one transformation, every character in s is replaced according to the following rules:
// If the character is 'z', replace it with the string "ab".
// Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
// Return the length of the resulting string after exactly t transformations.
// Since the answer may be very large, return it modulo 109 + 7.

// Example 1:
// Input: s = "abcyy", t = 2
// Output: 7

package shreyam.leetCode;

import java.util.Arrays;

public class Question3335 {
    public static int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
    int[] count = new int[26];

    for (final char c : s.toCharArray())
      ++count[c - 'a'];

    while (t-- > 0) {
      int[] newCount = new int[26];
      for (int i = 0; i < 25; i++)
        newCount[i + 1] = count[i];
      newCount[0] = count[25];
      newCount[1] = (newCount[1] + count[25]) % MOD;
      count = newCount;
    }

    return Arrays.stream(count).reduce(0, (a, b) -> (a + b) % MOD);
    }
    public static void main(String[] args) {
        String s = "abcyy";
        int t = 2;

        System.out.println(lengthAfterTransformations(s, t));
    }
}
