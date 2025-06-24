// Question: Find All K-Distant Indices in an Array 

// You are given a 0-indexed integer array nums and two integers key and k. A k-distant index is an index i of nums for which there exists at least one index j such that |i - j| <= k and nums[j] == key.
// Return a list of all k-distant indices sorted in increasing order.

// Example 1:
// Input: nums = [3,4,9,1,3,9,5], key = 9, k = 1
// Output: [1,2,3,4,5,6]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question2200{
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(j - k, 0);
                int end = Math.min(j + k, n - 1);

                // Avoid adding duplicates
                if (!result.isEmpty() && result.get(result.size() - 1) >= start) {
                    start = result.get(result.size() - 1) + 1;
                }

                for (int i = start; i <= end; i++) {
                    result.add(i);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int [] nums = {3,4,9,1,3,9,5}; 
        int key = 9, k = 1;
        System.out.println(findKDistantIndices(nums, key, k));
    }
}