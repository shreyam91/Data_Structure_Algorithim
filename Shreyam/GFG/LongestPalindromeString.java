// Question: Longest Palindrome in a String... 
// Given a string s, your task is to find the longest palindromic substring within s.
// A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).
// A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

// Examples :
// Input: s = “forgeeksskeegfor” 
// Output: “geeksskeeg”

package shreyam.gfg;

public class LongestPalindromeString {
    static String expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
    static String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }

        String longestPalin = "";
        for(int i=0;i<s.length();i++){

            String pal1 = expandAroundCenter(s, i, i);
            if(pal1.length() > longestPalin.length()){
                longestPalin = pal1;
            }

            String pal2 = expandAroundCenter(s, i, i+1);
            if(pal2.length() > longestPalin.length()){
                longestPalin = pal2;
            }
        }
            return longestPalin;
        
    }
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        String res = longestPalindrome(str);
        System.out.println(res);
    }
}
