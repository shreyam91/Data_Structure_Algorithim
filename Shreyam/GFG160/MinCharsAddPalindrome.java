// Question: Min Chars to Add for Palindrome... 
// Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.
// Note: A palindrome string is a sequence of characters that reads the same forward and backward.

// Examples:
// Input: s = "abc"
// Output: 2

package shreyam.GFG160;

public class MinCharsAddPalindrome {
    public static int minChar(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combine = s + "*" + rev;
        int n = combine.length();
        
        int[] lps = new int[n];
        
        for (int i = 1, len = 0; i < n;) {
            if (combine.charAt(i) == combine.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        
        return s.length() - lps[n - 1];
    }
    public static void main(String[] args) {
        String s = "abc";
        int res = minChar(s);
        System.out.println(res);
    }    
}
