// Question: Number of Substrings Containing All Three Character... 
// Given a string s consisting only of characters a, b and c.
// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

// Example 1:
// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

package shreyam.leetCode;

public class Question1358 {
    public static  int numberOfSubstrings(String s) {
        int n = s.length();
        int subarrays = 0;
        int [] freq = new int[3];
        int left = 0, right =0;

        while(right < n){
            freq[s.charAt(right) - 'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                subarrays += n-right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
            return subarrays;
    }
    public static void main(String[] args) {
        String str = "abcabc";
        int res = numberOfSubstrings(str);
        System.out.println(res);
    }
}
