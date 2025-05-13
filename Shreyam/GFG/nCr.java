// Question: nCr

// Given two integer values n and r, the task is to find the value of Binomial Coefficient nCr
// A binomial coefficient nCr can be defined as the coefficient of xr in the expansion of (1 + x)n that gives the number of ways to choose r objects from a set of n objects without considering the order.
// The binomial coefficient nCr is calculated as : C(n,r) = n! / r! * (n-r) !
// Note: If r is greater than n, return 0.
// It is guaranteed that the value of nCr will fit within a 32-bit integer.

// Examples:
// Input: n = 5, r = 2
// Output: 10

package shreyam.gfg;

public class nCr{
    public static int nCr(int n, int r) {
        if (r > n) {
            return 0;
        }

        long sum = 1;

        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }
        return (int)sum;
    }
    public static void main(String[] args) {
        int n = 5, r = 2;
        System.out.println(nCr(n, r));
    }
}
