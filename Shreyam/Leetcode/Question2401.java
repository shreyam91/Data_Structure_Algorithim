// Question: Longest Nice Subarray... 
// You are given an array nums consisting of positive integers.
// We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.
// Return the length of the longest nice subarray.
// A subarray is a contiguous part of an array.
// Note that subarrays of length 1 are always considered nice.

// Example 1:
// Input: nums = [1,3,8,48,10]
// Output: 3

package shreyam.leetCode;

public class Question2401 {
    public static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left =0;
        int right =0;

        int maxWindowSize = 0;
        int xorSum = 0;
        int currSum = 0;

        while(right < n){
            currSum += nums[right];
            xorSum ^= nums[right];

            while(xorSum != currSum){
                currSum -= nums[left];
                xorSum ^= nums[left];
                left++;
            }

            maxWindowSize = Math.max(maxWindowSize, right-left+1);
            right++;
        }

            return maxWindowSize;
        
    }
    public static void main(String[] args) {
        int [] nums = {1,3,8,48,10};
        int res = longestNiceSubarray(nums);
        System.out.println(res);
    }
}
