// Question: Count Subarrays with given XOR... 
// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

// Examples: 

// Input: arr[] = [4, 2, 2, 6, 4], k = 6
// Output: 4
// Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.

package Shreyam.GFG;

import java.util.*;

public class countSubarraysWithGivenXOR {
    public static int countSubarrays(int[] arr, int k){
        int length = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int preXOR =0, count =0;

        for(int i=0; i<length;i++){
            preXOR ^= arr[i];
            if(preXOR == k){
                count ++;
            }
            if(map.containsKey(preXOR ^ k)){
                count += map.get(preXOR ^ k);
            }
            map.put(preXOR,map.getOrDefault(preXOR, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] ={4,2,2,6,4};
        int k =6;

        int result = countSubarrays(arr, k);
        System.out.println("There are " + result + " subarrays.");
    }
}
