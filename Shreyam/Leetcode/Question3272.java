// Question: Find the Count of Good Integers...
// You are given two positive integers n and k.
// An integer x is called k-palindromic if:
// x is a palindrome.
// x is divisible by k.
// An integer is called good if its digits can be rearranged to form a k-palindromic integer. For example, for k = 2, 2020 can be rearranged to form the k-palindromic integer 2002, whereas 1010 cannot be rearranged to form a k-palindromic integer.
// Return the count of good integers containing n digits.
// Note that any integer must not have leading zeros, neither before nor after rearrangement. For example, 1010 cannot be rearranged to form 101.

// Example 1:

// Input: n = 3, k = 5
// Output: 27


package shreyam.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question3272{
    private static long kPalindromes = 0;
    private static Set<Long> done = new HashSet<>();
    private static long[] fact = new long[11];

    private static void precomputeFactorial(int n) {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i <= 10; ++i)
            fact[i] = i * fact[i - 1];
    }

    private static long countAllPermutations(int[] freq, int n) {
        long count = fact[n];
        for (int i = 0; i <= 9; ++i)
            count /= fact[freq[i]];
        return count;
    }

    private static long allArrangements(String number, int n) {
        char[] numArray = number.toCharArray();
        Arrays.sort(numArray);
        String sortedNumber = new String(numArray);
        long num = Long.parseLong(sortedNumber);
        if (done.contains(num))
            return 0;

        done.add(num);
        int[] freq = new int[10];
        for (char c : sortedNumber.toCharArray())
            freq[c - '0']++;

        long totalPermutations = countAllPermutations(freq, n);
        long invalidPermutations = 0;
        if (freq[0] > 0) {
            freq[0]--;
            invalidPermutations = countAllPermutations(freq, n - 1);
        }
        return totalPermutations - invalidPermutations;
    }

    private static boolean isKPalindrome(String number, int n, int k) {
        return Long.parseLong(number) % k == 0;
    }

    private static void generatePalindromes(int pos, int n, StringBuilder number, int k) {
        if (pos >= (n + 1) / 2) {
            String numStr = number.toString();
            if (isKPalindrome(numStr, n, k))
                kPalindromes += allArrangements(numStr, n);
            return;
        }

        char start = (pos == 0) ? '1' : '0';
        while (start <= '9') {
            number.setCharAt(pos, start);
            number.setCharAt(n - pos - 1, start);
            generatePalindromes(pos + 1, n, number, k);
            start++;
        }
        number.setCharAt(pos, ' ');
    }

    public static long countGoodIntegers(int n, int k) {
        precomputeFactorial(n);
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < n; i++)
            number.append(' ');
        generatePalindromes(0, n, number, k);
        return kPalindromes;
    }
    public static void main(String[] args) {
        int n = 3, k = 5;
        long res = countGoodIntegers(n, k);
        System.out.println(res);
    }
}