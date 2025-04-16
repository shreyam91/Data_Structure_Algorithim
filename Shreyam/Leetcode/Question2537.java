// Question: Count the nummber of Good SubArrays....
// Given an integer array nums and an integer k, return the number of good subarrays of nums.
// A subarray arr is good if there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,1,1,1,1], k = 10
// Output: 1
// Explanation: The only good subarray is the array nums itself.

package shreyam.leetCode;

import java.util.HashMap;

public class Question2537{
    public static long countGood(int[] nums, int k) {
        long n = nums.length;
        long left = 0, right = 0;
        long good_subarrays = 0;
        HashMap<Long, Long> freq = new HashMap<>();
        long equal_pairs = 0;

        while (left < n) {
            while (right < n && equal_pairs < k) {
                long num = nums[(int)right];
                freq.put(num, freq.getOrDefault(num, 0L) + 1);
                if (freq.get(num) >= 2) {
                    equal_pairs += freq.get(num) - 1;
                }
                right++;
            }
            if (equal_pairs >= k) {
                good_subarrays += n - right + 1;
            }

            long leftNum = nums[(int)left];
            freq.put(leftNum, freq.get(leftNum) - 1);
            if (freq.get(leftNum) > 0) {
                equal_pairs -= freq.get(leftNum);
            }
            left++;
        }
        return good_subarrays;    
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1};
        int k =10;

        long res = countGood(nums, k);
        System.out.println(res);
    }
}