// Question: Count Subarrays Where Max Element Appears At Least K Times..
// You are given an integer array nums and a positive integer k.
// Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
// A subarray is a contiguous sequence of elements within an array.

// Example 1:
// Input: nums = [1,3,2,3,3], k = 2
// Output: 6
// Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].

package shreyam.leetCode;

public class Question2962{
    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxEle = nums[0];
        long ans = 0;
        int cnt = 0, l = 0;

        
        for (int num : nums) {
            maxEle = Math.max(maxEle, num);
        }

        
        for (int r = 0; r < n; r++) {
            if (nums[r] == maxEle) {
                cnt++;
            }

            while (l <= r && cnt >= k) {
                ans += (n - r);
                if (nums[l] == maxEle) {
                    cnt--;
                }
                l++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
       int[] nums = {1,3,2,3,3};
       int k = 2;

       long res = countSubarrays(nums, k);
       System.out.println(res);

    }
}