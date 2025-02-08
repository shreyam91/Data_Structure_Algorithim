// Question: Special Array I... 
// An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
// You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

// Example 1:
// Input: nums = [1]
// Output: true
// Explanation:
// There is only one element. So the answer is true.

package shreyam.leetCode;

public class Question3151 {
    public static boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] num = {1};
        boolean res = isArraySpecial(num);
        System.out.println(res);

    }
}
