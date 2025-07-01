// Question: Substrings of length k with k-1 distinct elements

// Given a string s consisting only lowercase alphabets and an integer k. Find the count of all substrings of length k which have exactly k-1 distinct characters.

// Examples:

// Input: s = "abcc", k = 2
// Output: 1

package shreyam.gfg;

public class SubstringsDistinctElements {
    public static int substrCount(String s, int k) {
        int n = s.length();
        int result = 0;

        for (int i = 0; i <= n - k; i++) {
            int[] freq = new int[26]; 

            for (int j = i; j < i + k; j++) {
                freq[s.charAt(j) - 'a']++;
            }

            int count = 0;
            for (int l = 0; l < 26; l++) {
                if (freq[l] > 0) {
                    count++; 
                }
            }

            if (count == k - 1) {
                result++; 
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "abcc";
        int k = 2;
        System.out.println(substrCount(s, k));
    }
}
