// Question: Minimum sum 
// Given an array arr[ ] consisting of digits, your task is to form two numbers using all the digits such that their sum is minimized. Return the minimum possible sum as a string with no leading zeroes.

// Examples :
// Input: arr[] = [6, 8, 4, 5, 2, 3]
// Output: "604"

package shreyam.gfg;

public class MinimumSum{
    static String addString(String s1, String s2) {
        int           i      = s1.length() - 1;
        int           j      = s2.length() - 1;
        int           c      = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || c > 0) {
            int sum = c;

            if (i >= 0) {
                sum += s1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += s2.charAt(j) - '0';
                j--;
            }

            result.append(sum % 10);
            c = sum / 10;
        }

        return result.reverse().toString();
    }
    
    static String minSum(int[] arr) {
        int[] count = new int[10]; // to count digit frequencies

        for (int num : arr) {
            count[num]++;
        }

        StringBuilder s1   = new StringBuilder();
        StringBuilder s2   = new StringBuilder();
        boolean       flag = true;

        for (int digit = 0; digit < 10; digit++) {
            while (count[digit]-- > 0) {
                if (flag) {
                    if (!(s1.length() == 0 && digit == 0)) {
                        s1.append(digit); // avoid leading 0
                    }
                    flag = false;
                } else {
                    if (!(s2.length() == 0 && digit == 0)) {
                        s2.append(digit);
                    }
                    flag = true;
                }
            }
        }

        return addString(s1.toString(), s2.toString());
    }
    public static void main(String[] args) {
        int arr[] = {6, 8, 4, 5, 2, 3};
        System.out.println(minSum(arr));
    }
}