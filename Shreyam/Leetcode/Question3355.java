// Question: Zero Array Transformation I 
// You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].
// For each queries[i]:
// Select a subset of indices within the range [li, ri] in nums.
// Decrement the values at the selected indices by 1.
// A Zero Array is an array where all elements are equal to 0.
// Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.

// Example 1:
// Input: nums = [1,0,1], queries = [[0,2]]
// Output: true

package shreyam.leetCode;

public class Question3355{
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            diff[start]++;
            if (end + 1 < n) {
                diff[end + 1]--;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
        
    }
    public static void main(String[] args) {
        int [] nums = {1,0,1};
        int[][] queries = {{0,2}};
        System.out.println(isZeroArray(nums, queries));
    }
}