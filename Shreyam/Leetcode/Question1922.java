// Question: Count Good Numbers... 
// A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
// For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
// Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
// A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

// Example 1:
// Input: n = 1
// Output: 5
// Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".

package shreyam.leetCode;

public class Question1922 {
    final static int MOD = 1000000007;

    private static long binaryExponentiation(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
    public static int countGoodNumbers(long n) {
        return (int)((binaryExponentiation(4, n / 2) * binaryExponentiation(5, n - n / 2)) % MOD);
        
    }
    public static void main(String[] args) {
        int n =1;
        int res = countGoodNumbers(n);
        System.out.println(res);
    }
}
