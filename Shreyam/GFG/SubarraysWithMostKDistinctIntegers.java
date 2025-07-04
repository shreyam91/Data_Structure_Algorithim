// Question: Subarrays With At Most K Distinct Integers 
// You are given an array arr[] of positive integers and an integer k, find the number of subarrays in arr[] where the count of distinct integers is at most k.
// Note: A subarray is a contiguous part of an array.

// Examples:
// Input: arr[] = [1, 2, 2, 3], k = 2
// Output: 9

package shreyam.gfg;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithMostKDistinctIntegers {
    public static int countAtMostK(int arr[], int k) {
        int n = arr.length;
        int res = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        while (right < n) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);
            if (freq.get(arr[right]) == 1) k -= 1;
            while (k < 0) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) k += 1;
                left += 1;
            }
            res += (right - left + 1);
            right += 1;
        }
        return res;

    }
    public static void main(String[] args) {
       int arr[] = {1, 2, 2, 3};
       int k = 2;
       System.out.println(countAtMostK(arr, k));
    }
}
