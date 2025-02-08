// Question: Longest Subarray with Sum K... 
// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

// Examples:
// Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
// Output: 6
// Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.

package shreyam.gfg;

import java.util.HashMap;

public class longestSubarrayWithSumK {
    static int subArrayWithSumK(int[] arr, int k){
        // <!-- Brute Force Approach -->
        // int len = arr.length;
        // int sum =0;
        // int maxLength =0;
        // for(int i=0; i<len; i++){
        //     for(int j=i; j<len;j++){
        //         sum += arr[j];
        //         if( sum == k){
        //             maxLength = Math.max(maxLength,j-i+1);
        //         }
        //     }
        // }
        // return maxLength;

        // <!-- Optimal Approach   (1.49 time)-->
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int maxLength =0;
        int curSum =0;

        for(int i=0;i<arr.length;i++){
            curSum += arr[i];
            
            if(curSum == k){
                maxLength = i+1;
            }

            if(sumMap.containsKey(curSum-k)){
                maxLength = Math.max(maxLength, i-sumMap.get(curSum-k));
            }

            if(!sumMap.containsKey(curSum)){
                sumMap.put(curSum, i);
            }

        }
        return maxLength;
        
    }
    public static void main(String[] args) {
        int arr[] = {-5, 8, -14, 2, 4, 12};
        int k = -5;
        int res = subArrayWithSumK(arr, k);
        System.out.println(res);
    }
}
