// Question: Count the Number of Powerful Integers... 
// ou are given three integers start, finish, and limit. You are also given a 0-indexed string s representing a positive integer.
// A positive integer x is called powerful if it ends with s (in other words, s is a suffix of x) and each digit in x is at most limit.
// Return the total number of powerful integers in the range [start..finish].
// A string x is a suffix of a string y if and only if x is a substring of y that starts from some index (including 0) in y and extends to the index y.length - 1. For example, 25 is a suffix of 5125 whereas 512 is not.

// Example 1:
// Input: start = 1, finish = 6000, limit = 4, s = "124"
// Output: 5


package shreyam.leetCode;

import java.util.Arrays;

public class Question2999 {
    private static final int MAX_DIGITS = 17;
    private static long[][] dp;

    private static boolean checkSubtract(String numStr, int numDigits, String suffix, int limit) {
        if (numDigits < suffix.length()) return false;

        String suffixOfNum = numStr.substring(numDigits - suffix.length());
        boolean subtract = Long.parseLong(suffixOfNum) < Long.parseLong(suffix);

        if (subtract) {
            for (int i = 0; i < numDigits - suffix.length(); ++i) {
                if ((numStr.charAt(i) - '0') > limit) {
                    subtract = false;
                    break;
                }
            }
        }
        return subtract;
    }

    private static long countValidNumbers(String numberStr, int idx, int maxDigits, 
                                  boolean isTight, int limit, String suffix) {
        if (idx == maxDigits) return 1;
        if (dp[idx][isTight ? 1 : 0] != -1) return dp[idx][isTight ? 1 : 0];

        int low, high;
        int suffixLen = suffix.length();

        if (idx >= maxDigits - suffixLen) {
            int suffixIdx = idx - (maxDigits - suffixLen);
            low = high = suffix.charAt(suffixIdx) - '0';
        } else {
            high = isTight ? Math.min(limit, numberStr.charAt(idx) - '0') : limit;
            low = 0;
        }

        long total = 0;
        for (int digit = low; digit <= high; ++digit) {
            boolean newTight = isTight && (digit == numberStr.charAt(idx) - '0');
            total += countValidNumbers(numberStr, idx + 1, maxDigits, newTight, limit, suffix);
        }

        dp[idx][isTight ? 1 : 0] = total;
        return total;
    }

    private static long solveUpTo(String numStr, int numDigits, int limit, String suffix) {
        dp = new long[MAX_DIGITS][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        long result = countValidNumbers(numStr, 0, numDigits, true, limit, suffix);
        if (checkSubtract(numStr, numDigits, suffix, limit)) {
            result--;
        }
        return result;
    }

    public static long numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
        long suffixVal = Long.parseLong(suffix);
        String finishStr = Long.toString(finish);
        String startStr = Long.toString(start - 1);

        int finishDigits = finishStr.length();
        int startDigits = startStr.length();

        long uptoFinish = (finish >= suffixVal) ? solveUpTo(finishStr, finishDigits, limit, suffix) : 0;
        long uptoStart = (suffixVal < start) ? solveUpTo(startStr, startDigits, limit, suffix) : 0;

        return uptoFinish - uptoStart;
    }
    public static void main(String[] args) {
        int start = 1;
        int finish = 6000;
        int limit = 4;
        String s = "124";

        long res = numberOfPowerfulInt(start, finish, limit, s);
        System.out.println(res);
    }
}
