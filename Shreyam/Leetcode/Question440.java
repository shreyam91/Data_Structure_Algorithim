// Question: Kth Smallest in Lexicographical Order 

// Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].

// Example 1:
// Input: n = 13, k = 2
// Output: 10
// Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

package shreyam.leetCode;

public class Question440{
    public static long countPrefix(long prefix, long n) {
        long count = 0, curr = prefix, next = prefix + 1;
        while (curr <= n) {
            count += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return count;
    }

    public static int findKthNumber(int n, int k) {
        int prefix = 1;
        k = k - 1;
        while (k > 0) {
            long cnt = countPrefix(prefix, n);
            if (cnt <= k) {
                prefix++;
                k -= cnt;
            } else {
                prefix *= 10;
                k--;
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
       int n = 13, k = 2;
       System.out.println(findKthNumber(n, k));
    }
}