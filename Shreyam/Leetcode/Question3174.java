// Question: Clear Digits... 
// You are given a string s.
// Your task is to remove all digits by doing this operation repeatedly:
// Delete the first digit and the closest non-digit character to its left.
// Return the resulting string after removing all digits.

// Example 1:
// Input: s = "abc"
// Output: "abc"
// Explanation:
// There is no digit in the string.

package shreyam.leetCode;

public class Question3174 {
    public static String clearDigits(String s) {
        StringBuilder res = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c >= '0' && c <= '9'){
                if(res.length() > 0){
                    res.deleteCharAt(res.length() -1);
                }
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s ="cb34";
        String res = clearDigits(s);
        System.out.println(res);
    }
}
