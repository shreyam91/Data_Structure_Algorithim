// Question: Count the Number of Arrays with K Matching Adjacent Elements

// You are given three integers n, m, k. A good array arr of size n is defined as follows:
// Each element in arr is in the inclusive range [1, m].
// Exactly k indices i (where 1 <= i < n) satisfy the condition arr[i - 1] == arr[i].
// Return the number of good arrays that can be formed.
// Since the answer may be very large, return it modulo 109 + 7.

// Example 1:
// Input: n = 3, m = 2, k = 1
// Output: 4

package shreyam.leetCode;

public class Question3405{
    private static final int MOD = (int)1e9 + 7;
    private static int[] fact;
    private static int[] invFact;

    private static int binaryExp(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return (int)res;
    }

    private static int mmi(int val) {
        return binaryExp(val, MOD - 2);
    }

    private static void inverseFact(int n) {
        invFact = new int[n + 1];
        invFact[n] = mmi(fact[n]);
        for (int i = n; i > 0; i--) {
            invFact[i - 1] = (int)((1L * invFact[i] * i) % MOD);
        }
    }

    private static void factorial(int n) {
        fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (int)((1L * i * fact[i - 1]) % MOD);
        }
    }

    private static void precompute(int n) {
        factorial(n);
        inverseFact(n);
    }

    public static int countGoodArrays(int n, int m, int k) {
        precompute(n);

        int runWays = (int)((1L * fact[n - 1] * invFact[n - k - 1] % MOD * invFact[k]) % MOD);
        int waysToAssign = (int)(1L * m * binaryExp(m - 1, n - k - 1) % MOD);
        return (int)(1L * runWays * waysToAssign % MOD);
    }
    public static void main(String[] args) {
        int n = 3, m = 2, k = 1;
        System.out.println(countGoodArrays(n, m, k));
    }
}