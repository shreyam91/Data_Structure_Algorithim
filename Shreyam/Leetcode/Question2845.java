// Question: Count of Interesting Subarrays... 
// You are given a 0-indexed integer array nums, an integer modulo, and an integer k.
// Your task is to find the count of subarrays that are interesting.
// A subarray nums[l..r] is interesting if the following condition holds:
// Let cnt be the number of indices i in the range [l, r] such that nums[i] % modulo == k. Then, cnt % modulo == k.
// Return an integer denoting the count of interesting subarrays.
// Note: A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [3,2,4], modulo = 2, k = 1
// Output: 3

package shreyam.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question2845 {
    public static  long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        int prefix = 0; 
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
    
        for (final int num : nums) {
          if (num % modulo == k)
            prefix = (prefix + 1) % modulo;
          ans += prefixCount.getOrDefault((prefix - k + modulo) % modulo, 0);
          prefixCount.merge(prefix, 1, Integer::sum);
        }
    
        return ans;
      }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 2, 4);
        int modulo = 2, k = 1;
        long res = countInterestingSubarrays(nums, modulo, k);
        System.out.println(res);
    }
}
