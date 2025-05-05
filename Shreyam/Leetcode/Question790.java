// Question: Domino and Tromino Tiling... 
// You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
// Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
// In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

// Example 1:
// Input: n = 3
// Output: 5

package shreyam.leetCode;

public class Question790{
    public static int numTilings(int n) {

        final int M = 1000000007;

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        int[] t = new int[n + 1];

        t[1] = 1;
        t[2] = 2;
        t[3] = 5;

        for (int i = 4; i <= n; i++) {
            t[i] = (int)((2L * t[i - 1] % M + t[i - 3]) % M);
        }

        return t[n];
    }
    public static void main(String[] args) {
        int n =5;
        System.out.println(numTilings(n));
    }
}