// Question: Minimize XOR... 
// Given two positive integers num1 and num2, find the positive integer x such that:
// x has the same number of set bits as num2, and
// The value x XOR num1 is minimal.
// Note that XOR is the bitwise XOR operation.
// Return the integer x. The test cases are generated such that x is uniquely determined.
// The number of set bits of an integer is the number of 1's in its binary representation.

// Example 1:
// Input: num1 = 3, num2 = 5
// Output: 3
// Explanation:
// The binary representations of num1 and num2 are 0011 and 0101, respectively.
// The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.

package shreyam.leetCode;

public class Question2429 {
    static int minimizeXOR(int num1, int num2){
        int count = Integer.bitCount(num2); 
        int res = 0;

        // Cancel set bits from highest to lowest weight
        for (int i = 31; i >= 0 && count > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                count--;
                res += (1 << i);
            }
        }

        // Set bits lowest to highest weight
        for (int i = 0; i < 32 && count > 0; i++) {
            if ((num1 & (1 << i)) == 0) {
                count--;
                res += (1 << i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int num1 = 3, num2 = 5;
        int res = minimizeXOR(num1, num2);
        System.out.println(res);
    }
}
