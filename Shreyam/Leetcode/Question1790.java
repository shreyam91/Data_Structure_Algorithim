// Question: Check if One String Swap can Make Strings Equal... 
// You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
// Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

// Example 1:
// Input: s1 = "bank", s2 = "kanb"
// Output: true
// Explanation: For example, swap the first character with the last character of s2 to make "bank".

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question1790 {
    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;

        int m = s1.length();
        int n = s2.length();

        int mismatches = 0;

        List<Character> mismatch = new ArrayList<>();
        int pos =0;
        while(pos <m){
            if(s1.charAt(pos) != s2.charAt(pos)){
                mismatch.add(s1.charAt(pos));
                mismatch.add(s2.charAt(pos));
                mismatches++;
            }
            pos++;
        }
        if(mismatch.size()==4){
            return (mismatch.get(0) == mismatch.get(3) && mismatch.get(1) == mismatch.get(2));
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        boolean result = areAlmostEqual(s1, s2);
        System.out.println(result);
    }
}
