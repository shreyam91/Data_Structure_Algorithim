// Question: Implement Atoi... 
// Given a string s, the objective is to convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.
// Cases for atoi() conversion:
// Skip any leading whitespaces.
// Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
// Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
// If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than -231, then return -231.
// Examples:

// Input: s = "-123"
// Output: -123

package shreyam.GFG160;

public class ImplementAtoi {
    public static int myAtoi(String s) {
        int i=0, sign =1;
        long ans =0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            ans = ans * 10 + (s.charAt(i) - '0');
            if (sign * ans >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * ans <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int) (sign * ans);  
    }
    public static void main(String[] args) {
        String s = "-123";
        int res = myAtoi(s);
        System.out.println(res);
    }
}
