// Question: Count the Number of Iddeal Arrays.... 
// You are given two integers n and maxValue, which are used to describe an ideal array.
// A 0-indexed integer array arr of length n is considered ideal if the following conditions hold:
// Every arr[i] is a value from 1 to maxValue, for 0 <= i < n.
// Every arr[i] is divisible by arr[i - 1], for 0 < i < n.
// Return the number of distinct ideal arrays of length n. Since the answer may be very large, return it modulo 109 + 7.

// Example 1:
// Input: n = 2, maxValue = 5
// Output: 10

package shreyam.leetCode;

public class Question2338{
    private static final int MOD = (int)1e9 + 7;
    private static long[][] count;
    private static long[][] prefixSum;
    private static long[] options;

    private static void countUniqueSequences(int curr, int idx, int maxValue) {
        options[idx]++;
        for (int j = 2; curr * j <= maxValue; ++j) {
            countUniqueSequences(curr * j, idx + 1, maxValue);
        }
    }

    public static int idealArrays(int n, int maxValue) {
        count = new long[15][10005];
        prefixSum = new long[15][10005];
        options = new long[15];

        // Pre-fill 1st row
        for (int i = 1; i <= 10000; ++i) {
            count[1][i] = 1;
            prefixSum[1][i] = i;
        }

        // Fill the count table
        for (int i = 2; i <= 14; ++i) {
            for (int j = i; j <= 10000; ++j) {
                count[i][j] = prefixSum[i - 1][j - 1];
                prefixSum[i][j] = (count[i][j] + prefixSum[i][j - 1]) % MOD;
                count[i][j] %= MOD;
            }
        }

        // Calculate options
        for (int i = 1; i <= maxValue; ++i) {
            countUniqueSequences(i, 1, maxValue);
        }

        // Count total ideal arrays
        long ans = 0;
        for (int i = 1; i <= 14; ++i) {
            long ways = (count[i][n] * options[i]) % MOD;
            ans = (ans + ways) % MOD;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        int n =2;
        int maxValue =5;

        int res = idealArrays(n, maxValue);
        System.out.println(res);
    }
}
