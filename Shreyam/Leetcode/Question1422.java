// Ques:- Maximum Score After Splitting a String
// Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).

// The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.

// Example 1:

// Input: s = "011101"
// Output: 5 
// Explanation: 
// All possible ways of splitting s into two non-empty substrings are:
// left = "0" and right = "11101", score = 1 + 4 = 5 
// left = "01" and right = "1101", score = 1 + 3 = 4 
// left = "011" and right = "101", score = 1 + 2 = 3 
// left = "0111" and right = "01", score = 1 + 1 = 2 
// left = "01110" and right = "1", score = 2 + 1 = 3

package shreyam.leetCode;

public class Question1422 {
    public static int maxScore(String s){
        int length = s.length();
        int count =0;

        for(int i=0;i<length;i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }

        int left =0;
        int score =0;

        for(int i=0; i<length-1;i++){
            if(s.charAt(i) == '0'){
                left++;
            }else{
                count--;
            }
            score = Math.max(score, left+count);
        }
        return score;
    }
    public static void main(String[] args) {
        String s = "011101";
        int result = maxScore(s);
        System.out.println("Output :" + result);
    }
}
