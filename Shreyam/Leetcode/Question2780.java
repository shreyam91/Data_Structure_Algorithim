// Question: Minimum Index of a Valid Split... 
// An element x of an integer array arr of length m is dominant if more than half the elements of arr have a value of x.
// You are given a 0-indexed integer array nums of length n with one dominant element.
// You can split nums at an index i into two arrays nums[0, ..., i] and nums[i + 1, ..., n - 1], but the split is only valid if:
// 0 <= i < n - 1
// nums[0, ..., i], and nums[i + 1, ..., n - 1] have the same dominant element.
// Here, nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j, both ends being inclusive. Particularly, if j < i then nums[i, ..., j] denotes an empty subarray.
// Return the minimum index of a valid split. If no valid split exists, return -1.

// Example 1:
// Input: nums = [1,2,2,2]
// Output: 2

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question2780 {
    private static int mooresVotingAlgo(List<Integer> nums) {
            int majority_element = nums.get(0);
            int freq = 1;
            for (int i = 1; i < nums.size(); ++i) {
                if (nums.get(i) != majority_element) {
                    freq--;
                } else {
                    freq++;
                }
                if (freq == 0) {
                    majority_element = nums.get(i);
                    freq = 1;
                }
            }
            return majority_element;
        }
    
        public static int minimumIndex(List<Integer> nums) {
            int n = nums.size();
            int majority_element = mooresVotingAlgo(nums);

        int max_freq = 0;
        for (int num : nums) {
            if (num == majority_element) {
                max_freq++;
            }
        }

        int prefix_count = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i) == majority_element) {
                prefix_count++;
                max_freq--;
            }
            if ((prefix_count > (i + 1) / 2) && (max_freq > (n - i - 1) / 2)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,2};
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        System.out.println(minimumIndex(numsList));
    }
}
