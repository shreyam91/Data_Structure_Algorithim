// Question: Longest Substring with K Uniques

// You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.
// Note : If no such substring exists, return -1. 

// Examples:
// Input: s = "aabacbebebe", k = 3
// Output: 7

package shreyam.gfg;

public class LongestSubstringKUniques {
    public static int longestKSubstr(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int cnt = 0;
        int maxi = -1;
        int[] fre = new int[26];
        while (j < n) {

            fre[s.charAt(j) - 'a']++;
            if (fre[s.charAt(j) - 'a'] == 1) cnt++;
            while (cnt > k) {
                fre[s.charAt(i) - 'a']--;
                if (fre[s.charAt(i) - 'a'] == 0) cnt--;
                i++;
            }
            if (cnt == k) {
                maxi = Math.max(maxi, j - i + 1);
            }

            j++;
        }
        return maxi;
    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s, k));
    }
}
