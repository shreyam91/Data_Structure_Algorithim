// Question: Count Subarrays with given XOR
// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

// Examples: 
// Input: arr[] = [4, 2, 2, 6, 4], k = 6
// Output: 4

package shreyam.GFG160;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysGivenXOR {
    public static long subarrayXor(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int preXor = 0;
        long count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            preXor ^= arr[i];  
            
            if (preXor == k) count++;
            
            if (mp.containsKey(preXor ^ k)) {
                count += mp.get(preXor ^ k);
            }
        
            mp.put(preXor, mp.getOrDefault(preXor, 0) + 1);
        }
        
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(subarrayXor(arr, k));
    }
}
