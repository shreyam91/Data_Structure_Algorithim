// Question:- Check if a Paranthesis String can be valid... 
// A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

// It is ().
// It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
// It can be written as (A), where A is a valid parentheses string.
// You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

// If locked[i] is '1', you cannot change s[i].
// But if locked[i] is '0', you can change s[i] to either '(' or ')'.
// Return true if you can make s a valid parentheses string. Otherwise, return false.
// Example:- 
// Input: s = "))()))", locked = "010100"
// Output: true
// Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
// We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.

package shreyam.leetCode;

public class Question2116 {
    public static boolean canBeValid(String s, String locked) {
        int length = s.length();
        if(length % 2 != 0){
            return false;
        }
        int opening =0,closing =0;
        int wildCard =0;
         for(int i=0; i<length;i++){
            if(locked.charAt(i) == '0'){
                wildCard++;
            } else if(s.charAt(i)=='('){
                opening++;
            }else{
                closing++;
            }

            if(wildCard < (closing - opening)){
                return false;
            }
         }

         opening = closing = wildCard =0;
         for(int i=length-1;i>= 0;i--){
            if(locked.charAt(i) == '0'){
                wildCard++;
            }else if(s.charAt(i) == '('){
                opening++;
            }else {
                closing++;
            }

            if(wildCard < (opening - closing)){
                return false;
            }
         }
         return true;
    }
    public static void main(String[] args) {
        String s = "))()))";
        String locked = "010100";
        boolean result = canBeValid(s, locked);
        System.out.println(result);

    }
}
