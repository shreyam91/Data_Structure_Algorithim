// Question: Total Characters in String After Transformations II

// You are given a string s consisting of lowercase English letters, an integer t representing the number of transformations to perform, and an array nums of size 26. In one transformation, every character in s is replaced according to the following rules:
// Replace s[i] with the next nums[s[i] - 'a'] consecutive characters in the alphabet. For example, if s[i] = 'a' and nums[0] = 3, the character 'a' transforms into the next 3 consecutive characters ahead of it, which results in "bcd".
// The transformation wraps around the alphabet if it exceeds 'z'. For example, if s[i] = 'y' and nums[24] = 3, the character 'y' transforms into the next 3 consecutive characters ahead of it, which results in "zab".
// Return the length of the resulting string after exactly t transformations.
// Since the answer may be very large, return it modulo 109 + 7.

// Example 1:
// Input: s = "abcyy", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]
// Output: 7

package shreyam.leetCode;

import java.util.Arrays;
import java.util.List;

public class Question3337{
    public static int lengthAfterTransformations(String s, int t, List<Integer> nums) {
    int[][] T = getTransformationMatrix(nums);
    int[][] poweredT = matrixPow(T, t);
    int[] count = new int[26];
    long[] lengths = new long[26];

    for (final char c : s.toCharArray())
      ++count[c - 'a'];

    for (int i = 0; i < 26; ++i)
      for (int j = 0; j < 26; ++j) {
        lengths[j] += (long) count[i] * poweredT[i][j];
        lengths[j] %= MOD;
      }

    return (int) (Arrays.stream(lengths).sum() % MOD);
  }

  private static final int MOD = 1_000_000_007;

  private static int[][] getTransformationMatrix(List<Integer> nums) {
    int[][] T = new int[26][26];
    for (int i = 0; i < nums.size(); ++i)
      for (int step = 1; step <= nums.get(i); ++step)
        ++T[i][(i + step) % 26];
    return T;
  }

  private static int[][] getIdentityMatrix(int sz) {
    int[][] I = new int[sz][sz];
    for (int i = 0; i < sz; ++i)
      I[i][i] = 1;
    return I;
  }

  private static int[][] matrixMult(int[][] A, int[][] B) {
    final int sz = A.length;
    int[][] C = new int[sz][sz];
    for (int i = 0; i < sz; ++i)
      for (int j = 0; j < sz; ++j)
        for (int k = 0; k < sz; ++k)
          C[i][j] = (int) ((C[i][j] + (long) A[i][k] * B[k][j]) % MOD);
    return C;
  }

  private static int[][] matrixPow(int[][] M, int n) {
    if (n == 0)
      return getIdentityMatrix(M.length);
    if (n % 2 == 1)
      return matrixMult(M, matrixPow(M, n - 1));
    return matrixPow(matrixMult(M, M), n / 2);
  }
    public static void main(String[] args) {
        String s = "abcyy";
        int t = 2;
        List<Integer> nums = Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2);

        System.out.println(lengthAfterTransformations(s, t, nums));
    }
}