// Question: Count Symmetric Integers... 
// You are given two positive integers low and high.
// An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.
// Return the number of symmetric integers in the range [low, high].
 
// Example 1:
// Input: low = 1, high = 100
// Output: 9
// Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.

package shreyam.leetCode;

public class Question2843{
    public static int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        for (int idx = low; idx <= high; idx++) {
            int num = idx;

            if (num > 10 && num <= 99) {
                if (num % 11 == 0) ans++;
            }
            else if (num > 1000 && num <= 9999) {
                int first = num % 10;     
                num /= 10;
                first += num % 10;        
                num /= 10;

                int second = num % 10;    
                num /= 10;
                second += num % 10;       

                if (first == second) {
                    ans++;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int low = 1;
        int high = 100;

        int res = countSymmetricIntegers(low, high);
        System.out.println(res);
    }
}