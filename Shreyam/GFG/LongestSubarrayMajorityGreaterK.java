// Question: Longest Subarray with Majority Greater than K

// Given an array arr[] and an integer k, the task is to find the length of longest subarray in which the count of elements greater than k is more than the count of elements less than or equal to k.

// Examples:
// Input: arr[] = [1, 2, 3, 4, 1], k = 2
// Output: 3

package shreyam.gfg;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayMajorityGreaterK {
    static int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
    prefixMap.put(0, -1);
    int prefixSum = 0, maxLength = 0;
    
    for (int i = 0; i < arr.length; i++) {
        prefixSum += (arr[i] > k) ? 1 : -1;
        
        if (prefixSum > 0) {
            maxLength = i + 1;
        } else {
            if (prefixMap.containsKey(prefixSum - 1)) {
                maxLength = Math.max(maxLength, i - prefixMap.get(prefixSum - 1));
            }
        }
        
        prefixMap.putIfAbsent(prefixSum, i);
    }
    
    return maxLength;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 1};
        int k = 2;

        System.out.println(longestSubarray(arr, k));
    }
}
