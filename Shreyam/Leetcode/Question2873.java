// Question: Maximum Value of an Ordered Triplet I... 
// You are given a 0-indexed integer array nums.
// Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
// The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].

// Example 1:
// Input: nums = [12,6,1,2,7]
// Output: 77

package shreyam.leetCode;

public class Question2873 {
    public static long maximumTripletValue(int[] nums) {
        long ans = 0;
        int maxDiff = 0; 
        int maxNum = 0;  
    
        for (final int num : nums) {
          ans = Math.max(ans, (long) maxDiff * num); 
          maxDiff = Math.max(maxDiff, maxNum - num); 
          maxNum = Math.max(maxNum, num);            
        }
    
        return ans;
      }
    public static void main(String[] args) {
        int nums [] = {12,6,1,2,7};
        long res = maximumTripletValue(nums);
        System.out.println(res);
    }
}
