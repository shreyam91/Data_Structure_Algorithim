// Question: Count Subarrays With Score Less Than K... 
// The score of an array is defined as the product of its sum and its length.
// For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
// Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.
// A subarray is a contiguous sequence of elements within an array.

// Example 1:
// Input: nums = [2,1,4,3,5], k = 10
// Output: 6

package shreyam.leetCode;

public class Question2302 {
    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int left = 0, right = 0;    
        long sum = 0;               
        long count = 0;

        while (left < n) {
            while (right < n && (sum + nums[right]) * (right - left + 1) < k) {
                sum += nums[right++];
            }

            count += right - left;

            if (right == left) {
                right++;
            } else {
                sum -= nums[left];
            }
            left++;
        }

        return count;
    }
    public static void main(String[] args) {
        int []nums = {2,1,4,3,5};
        int k = 10;
        long res = countSubarrays(nums, k);
        System.out.println(res);
    }
}
