// Question: Longest Harmonious Subsequence

// We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
// Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

// Example 1:
// Input: nums = [1,3,2,2,5,2,3,7]
// Output: 5


package shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Question594 {
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int minNum = num;
            int maxNum = num + 1;

            if (map.containsKey(maxNum)) {
                result = Math.max(result, map.get(minNum) + map.get(maxNum));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int [] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
}
