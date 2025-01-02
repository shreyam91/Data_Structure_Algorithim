// Question: Subarrays With Sum K (GFG) 
// Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

// Examples:

// Input: arr = [10, 2, -2, -20, 10], k = -10
// Output: 3
// Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.

package Shreyam.GFG;

import java.util.*;

public class subarraysWithSumK {
    public static int subarrayWithSum (int arr[],int k){
        if(k==0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0, count =0;

        for(int i=0; i<arr.length;i++){
            sum +=arr[i];
            if(sum == k) count++;
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum, 0) +1);
        }
        return count;
    }
    public static void main(String[] args) {
        int [] arr = {10, 2, -2, -20, 10};
        int k = -10;
        int result = subarrayWithSum(arr, k);
        System.out.println("Subarray of sum "+k+" is "+result);
        
    }
}
