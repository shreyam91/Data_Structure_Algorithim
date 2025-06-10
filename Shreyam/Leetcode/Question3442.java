// Question: Maximum Difference Between Even and Odd Frequency I 

// You are given a string s consisting of lowercase English letters.
// Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:
// a1 has an odd frequency in the string.
// a2 has an even frequency in the string.
// Return this maximum difference.

// Example 1:
// Input: s = "aaaaabbc"
// Output: 3

package shreyam.leetCode;

public class Question3442 {
    public static int maxDifference(String s) {
        int n = s.length();

        int maxOdd = 0;
        int minEven = n + 1;

        int[] freq = new int[26]; // for 'a' to 'z'

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            if (freq[i] % 2 == 0) {
                minEven = Math.min(minEven, freq[i]);
            } else {
                maxOdd = Math.max(maxOdd, freq[i]);
            }
        }

        return maxOdd - minEven;
    }
    public static void main(String[] args) {
        String s = "aaaaabbc";
        System.out.println(maxDifference(s));
    }
}
