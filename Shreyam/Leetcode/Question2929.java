// Question:  Distribute Candies Among Children II 

// You are given two positive integers n and limit.
// Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies.

// Example 1:
// Input: n = 5, limit = 2
// Output: 3


package shreyam.leetCode;

public class Question2929 {
    private static long combinations(long n) {
        if (n < 0) {
            return 0;
        }
        return (n + 1) * (n + 2) / 2;
    }

    public static long distributeCandies(int n, int limit) {
        long allCombinations = combinations(n);
        long oneAboveLimitCombinations = 3 * combinations(n - (limit + 1));
        long twoAboveLimitCombinations = 3 * combinations(n - 2 * (limit + 1));
        long threeAboveLimitCombinations = combinations(n - 3 * (limit + 1));

        long invalidCombinations = oneAboveLimitCombinations - twoAboveLimitCombinations + threeAboveLimitCombinations;
        long validCombinations = allCombinations - invalidCombinations;
        return validCombinations;
    }
    public static void main(String[] args) {
        int n = 5, limit = 2;
        System.out.println(distributeCandies(n, limit));
    }
}
