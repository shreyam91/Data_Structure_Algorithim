// Question: Divide Array Into Arrays With Max Difference

// You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.
// Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:
// The difference between any two elements in one array is less than or equal to k.
// Return a 2D array containing the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

// Example 1:
// Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
// Output: [[1,1,3],[3,4,5],[7,8,9]]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2966 {
    public static List<List<Integer>> divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 2; i < n; i += 3) {
            if (nums[i] - nums[i - 2] > k) {
                return new ArrayList<>();
            }
            List<Integer> triplet = new ArrayList<>();
            triplet.add(nums[i - 2]);
            triplet.add(nums[i - 1]);
            triplet.add(nums[i]);
            res.add(triplet);
        }
        return res;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,4,8,7,9,3,5,1};
        int k = 2;
        System.out.println(divideArray(nums, k));
    }
}
