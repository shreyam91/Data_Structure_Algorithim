// Question: Maximum Difference Between Even and Odd Frequency II

// You are given a string s and an integer k. Your task is to find the maximum difference between the frequency of two characters, freq[a] - freq[b], in a substring subs of s, such that:
// subs has a size of at least k.
// Character a has an odd frequency in subs.
// Character b has an even frequency in subs.
// Return the maximum difference.
// Note that subs can contain more than 2 distinct characters.

// Example 1:
// Input: s = "12233", k = 4
// Output: -1

package shreyam.leetCode;

import java.util.Arrays;

public class Question3445 {
    private static void precomputePrefixSum(int[] prefixSumA, int[] prefixSumB, 
                                   String s, int n, int a, int b) {
        prefixSumA[0] = prefixSumB[0] = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) - '0' == a)    prefixSumA[i+1] = 1 + prefixSumA[i];
            else                           prefixSumA[i+1] = prefixSumA[i];

            if (s.charAt(i) - '0' == b)    prefixSumB[i+1] = 1 + prefixSumB[i];
            else                           prefixSumB[i+1] = prefixSumB[i];
        }
    }

    private static int calculateDifference(String s, int k, int a, int b) {
        int n = s.length();
        int[] prefixSumA = new int[n+1];
        int[] prefixSumB = new int[n+1];
        precomputePrefixSum(prefixSumA, prefixSumB, s, n, a, b);

        int[] minVal = new int[4];  
        int[] minIdx = new int[4];
        Arrays.fill(minVal, Integer.MAX_VALUE);
        Arrays.fill(minIdx, -1);
        minVal[0] = minIdx[0] = 0; 

        int maxDiff = Integer.MIN_VALUE;
        for (int end = k; end <= n; ++end) {
            int parityA = prefixSumA[end] & 1;
            int parityB = prefixSumB[end] & 1;
            int parity = ((parityA ^ 1) << 1) + parityB;
            
            if (minVal[parity] != Integer.MAX_VALUE) {
                if (prefixSumB[minIdx[parity]] != prefixSumB[end]) {
                    maxDiff = Math.max(maxDiff, (prefixSumA[end] - prefixSumB[end]) - minVal[parity]);
                }
            }
            
            int start = end - k + 1;
            parityA = prefixSumA[start] & 1;
            parityB = prefixSumB[start] & 1;
            parity = (parityA << 1) + parityB;
            int startDiff = prefixSumA[start] - prefixSumB[start];
            
            if (startDiff < minVal[parity]) {
                minVal[parity] = startDiff;
                minIdx[parity] = start;
            }
        }
        return maxDiff;
}
public static int maxDifference(String s, int k) {
        int n = s.length();
        int maxDiff = Integer.MIN_VALUE;
        for (int a = 0; a <= 4; ++a) {
            for (int b = 0; b <= 4; ++b) {
                if (a == b) continue;
                int diff = calculateDifference(s, k, a, b);
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        return maxDiff;
    }
    public static void main(String[] args) {
        String s = "12233";
        int k = 4;
        System.out.println(maxDifference(s, k));
    }
}
