// Question: Count Numbers Containing Specific Digits 

// You are given an integer n representing the number of digits in a number, and an array arr[] containing digits from 0 to 9. Your have to count how many n-digit positive integers can be formed such that at least one digit from the array arr[] appears in the number.

// Examples:
// Input: n = 1, arr[] = [1, 2, 3]
// Output: 3

package shreyam.gfg;

public class CountNumbersContainingSpecificDigits {
    static int fastPow(int base, int exp) {
        int result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= base;
            }
            base *= base;
            exp = exp / 2;
        }
        return result;
    }

    static int countValid(int n, int[] arr) {
        
        boolean[] good = new boolean[10];
        for (int d : arr) good[d] = true;

        int c = 0, nonzero = 0;
        for (int d = 0; d < 10; d++) {
            if (!good[d]) {
                c++;
                if (d != 0) nonzero++;
            }
        }

    
        int total = 9 * fastPow(10, n - 1);
        int noneAllowed = (n == 1) ? nonzero : nonzero * fastPow(c, n - 1);
        return total - noneAllowed;
        
     }
    public static void main(String[] args) {
        int n = 1;
        int arr[] = {1, 2, 3};
        System.out.println(countValid(n, arr));
    }
}
