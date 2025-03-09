// Question: Palindrome SubStrings.... 
// Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2. 

// Examples
// Input: s = "abaab"
// Output: 3
// Explanation: All palindromic substrings are : "aba" , "aa" , "baab".

package shreyam.gfg;

public class PalindromeSubstrings {
    public static int countPS(String s){
        int count =0;
        for(int i=0; i<s.length();i++){
            count += expandAroundCenter(s,i,i);
            count += expandAroundCenter(s,i,i+1);
        }
        return count;
    }

    public static int expandAroundCenter(String s, int left, int right){
        int count =0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if(right-left+1 >= 2){
                count++;
            }
            left--;
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        String str = "abaab";
        int res = countPS(str);
        System.out.println(res);
    }
}
