// Question: Painting a Grid with Three different color  

// You are given two integers m and n. Consider an m x n grid where each cell is initially white. You can paint each cell red, green, or blue. All cells must be painted.
// Return the number of ways to color the grid with no two adjacent cells having the same color. Since the answer can be very large, return it modulo 109 + 7.

 // Example 1:
// Input: m = 1, n = 1
// Output: 3

package shreyam.leetCode;

public class Question1931 {
  private static final int MOD = 1_000_000_007;
  private static int m, n;
  private static int[][] memo = new int[1000][1024]; // memo[col][prevColMask]

  public static int colorTheGrid(int mVal, int nVal) {
    m = mVal;
    n = nVal;
    for (int i = 0; i < n; ++i)
      for (int j = 0; j < 1024; ++j)
        memo[i][j] = -1;

    return dp(0, 0, 0, 0);
  }

  private static int dp(int r, int c, int prevColMask, int currColMask) {
    if (c == n)
      return 1;

    if (r == m) {
      if (memo[c][currColMask] != -1)
        return memo[c][currColMask];
      int res = dp(0, c + 1, currColMask, 0);
      memo[c][currColMask] = res;
      return res;
    }

    int ans = 0;
    for (int color = 1; color <= 3; ++color) {
      if (getColor(prevColMask, r) == color)
        continue;
      if (r > 0 && getColor(currColMask, r - 1) == color)
        continue;

      int newMask = setColor(currColMask, r, color);
      ans = (ans + dp(r + 1, c, prevColMask, newMask)) % MOD;
    }
    return ans;
  }

  private static int getColor(int mask, int r) {
    return (mask >> (r * 2)) & 3;
  }

  private static int setColor(int mask, int r, int color) {
    mask &= ~(3 << (r * 2));  // Clear previous color
    return mask | (color << (r * 2));
  }

  public static void main(String[] args) {
    int m =1,n=1;
    System.out.println(colorTheGrid(m, n)); 

  }
}
