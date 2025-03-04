// Question: Check if Number is a Sum of Power of Three... 
// Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
// An integer y is a power of three if there exists an integer x such that y == 3x.

// Example 1:
// Input: n = 12
// Output: true
// Explanation: 12 = 3^1 + 3^2

package shreyam.leetCode;

public class Question1780 {
    public static boolean checkPowersOfThree(int n) {
        while(n>0){
            if(n%3 ==2){
                return false;
            }
            n /= 3;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 12;
        boolean res = checkPowersOfThree(n);
        System.out.println(res);
    }
}
