// Question: Sum of all substrings of a number 

// Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.
// Note: The number may have leading zeros.
// It is guaranteed that the total sum will fit within a 32-bit signed integer.

// Examples:
// Input: s = "6759"
// Output: 8421


package shreyam.gfg;

public class SumSubstringsNumber {
    public static int sumSubstrings(String s) {
        long sum = 0;
        long mf = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - '0') * (i + 1) * mf;
            mf = mf * 10 + 1;
        }
        return (int)sum;       
    }
    public static void main(String[] args) {
        String s = "6759";
        System.out.println(sumSubstrings(s));
    }
}
