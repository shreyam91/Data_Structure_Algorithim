// Question: Three Consecutive Odds 

// Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.

// Example 1:
// Input: arr = [2,6,4,1]
// Output: false

package shreyam.leetCode;

public class Question1550{
    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (final int a : arr) {
            count = a % 2 == 0 ? 0 : count + 1;
        if (count == 3)
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int [] arr = {2,6,4,1};
        System.out.println(threeConsecutiveOdds(arr));
    }
}