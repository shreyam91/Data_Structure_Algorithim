// Question: Minimum Operations to Make Array Values Equal to K... 
// You are given an integer array nums and an integer k.
// An integer h is called valid if all values in the array that are strictly greater than h are identical.
// For example, if nums = [10, 8, 10, 8], a valid integer is h = 9 because all nums[i] > 9 are equal to 10, but 5 is not a valid integer.
// You are allowed to perform the following operation on nums:
// Select an integer h that is valid for the current values in nums.
// For each index i where nums[i] > h, set nums[i] to h.
// Return the minimum number of operations required to make every element in nums equal to k. If it is impossible to make all elements equal to k, return -1.

// Example 1:
// Input: nums = [5,2,5,4,5], k = 2
// Output: 2

package shreyam.leetCode;

import java.util.HashSet;
import java.util.Set;

public class Question3375 {
    public static int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(); 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) 
                return -1; 

            if (nums[i] > k) {
                set.add(nums[i]); 
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        int nums[] = {5,2,5,4,5};
        int k =2;

        int res = minOperations(nums, k);
        System.out.println(res);
    }
}