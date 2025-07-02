// Question: Longest subarray with Atmost two distinct integers

// Given an array arr[] consisting of positive integers, your task is to find the length of the longest subarray that contains at most two distinct integers.

// Examples:
// Input: arr[] = [2, 1, 2]
// Output: 3


package shreyam.gfg;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayAtmostDistinctIntegers {
    public static int totalElements(int[] arr) {
    
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        int i      = 0;       
        int j      = 0;       
        int result = 0;

        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            while (map.size() > 2) {
                int count = map.get(arr[i]) - 1;
                if (count == 0) {
                    map.remove(arr[i]);     
                } else {
                    map.put(arr[i], count); 
                }
                i++;                        
            }

            
            result = Math.max(result, j - i + 1);
            j++;                           
        }

        return result;
    }
    public static void main(String[] args) {
       int arr[] = {2, 1, 2};
        System.out.println(totalElements(arr));
    }
}
