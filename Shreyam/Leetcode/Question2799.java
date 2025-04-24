// Question: Count Complete Subarrays in an Array... 
// You are given an array nums consisting of positive integers.
// We call a subarray of an array complete if the following condition is satisfied:
// The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
// Return the number of complete subarrays.
// A subarray is a contiguous non-empty part of an array.

// Example 1:
// Input: nums = [1,3,1,2,2]
// Output: 4

package shreyam.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question2799 {
    public static  int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }
        
        int totalUnique = uniqueSet.size();
        int res = 0;
        int i = 0;
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int j = 0; j < n; j++) {
            freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
            
            while (freqMap.size() == totalUnique) {
                res += (n - j);
                
                freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
                if (freqMap.get(nums[i]) == 0) {
                    freqMap.remove(nums[i]);
                }
                i++;
            }
        }
        
        return res;
    }
    public static void main(String[] args) {
        int [] nums = {1,3,1,2,2};
        int res = countCompleteSubarrays(nums);
        System.out.println(res);
    }
}
