// Question: Maximum Difference by Remapping a Digit 

// ou are given an integer num. You know that Bob will sneakily remap one of the 10 possible digits (0 to 9) to another digit.
// Return the difference between the maximum and minimum values Bob can make by remapping exactly one digit in num.
// Notes:
// When Bob remaps a digit d1 to another digit d2, Bob replaces all occurrences of d1 in num with d2.
// Bob can remap a digit to itself, in which case num does not change.
// Bob can remap different digits for obtaining minimum and maximum values respectively.
// The resulting number after remapping can contain leading zeroes.
 
// Example 1:
// Input: num = 11891
// Output: 99009

package shreyam.leetCode;

public class Question2566 {
    public static int minMaxDifference(int num) {
        String s = Integer.toString(num);
        int n = s.length();

        char digit1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '9') {
                digit1 = s.charAt(i);
                break;
            }
        }

        StringBuilder maxStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == digit1) {
                maxStr.append('9');
            } else {
                maxStr.append(s.charAt(i));
            }
        }

        char digit2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                digit2 = s.charAt(i);
                break;
            }
        }

        StringBuilder minStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == digit2) {
                minStr.append('0');
            } else {
                minStr.append(s.charAt(i));
            }
        }

        int maxNum = Integer.parseInt(maxStr.toString());
        int minNum = Integer.parseInt(minStr.toString());

        return maxNum - minNum;
    }
    public static void main(String[] args) {
        int num = 11891;
        System.out.println(minMaxDifference(num));
    }
}
