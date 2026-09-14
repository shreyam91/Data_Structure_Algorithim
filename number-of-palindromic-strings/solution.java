class Solution {
    static final long MOD = 1000000007;

    public int palindromicStrings(int n, int k) {
        long ans = 0;
        long ways = 1;

        // m = number of pairs
        for (int m = 0; 2 * m <= n; m++) {

            if (m > 0) {
                ways = (ways * (k - m + 1)) % MOD;
            }

            // Even length = 2m
            if (m > 0) {
                ans = (ans + ways) % MOD;
            }

            // Odd length = 2m + 1
            if (2 * m + 1 <= n) {
                long oddWays = (ways * (k - m)) % MOD;
                ans = (ans + oddWays) % MOD;
            }
        }

        return (int) ans;
    }
}