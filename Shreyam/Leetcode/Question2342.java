// Question: Max Sum of a Pair with Equal Sum of Digits... 
// You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
// Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

// Example 1:
// Input: nums = [18,43,36,13,7]
// Output: 54
// Explanation: The pairs (i, j) that satisfy the conditions are:
// - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
// (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50. So the maximum sum that we can obtain is 54.

package shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Question2342 {
    private static int getDigitSum(int val){
        int sum =0;
        while(val != 0){
            sum += val %10;
            val /= 10;
        }
        return sum;
    }
    public static int maximumSum(int[] nums) {
        int maxSum = -1;
        Map<Integer,Integer> sumMaxVal = new HashMap<>();

        for(int ele: nums){
            int digitSum = getDigitSum(ele);
            if(sumMaxVal.containsKey(digitSum)){
                maxSum = Math.max(maxSum, ele+sumMaxVal.get(digitSum));
            }
            sumMaxVal.put(digitSum, Math.max(sumMaxVal.getOrDefault(digitSum, -1), ele));
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {18,43,36,13,7};
        int res = maximumSum(nums);
        System.out.println(res);
    }
}
