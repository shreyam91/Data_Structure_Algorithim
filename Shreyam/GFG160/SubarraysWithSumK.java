// Question: Subarrays with sum K... 
// Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.

// Examples:
// Input: arr = [10, 2, -2, -20, 10], k = -10
// Output: 3


package shreyam.GFG160;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithSumK {
    public static int countSubarrays(int arr[], int k) {
        if(k== 0) return 0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum =0, count=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(mp.containsKey(sum-k)){
                count += mp.get(sum-k);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(countSubarrays(arr, k));
    }
}
