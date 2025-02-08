// Question:- Sum Pair closest to target.. 
// Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
// Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

// Examples:
// Input: arr[] = [10, 30, 20, 5], target = 25
// Output: [5, 20]
// Explanation: As 5 + 20 = 25 is closest to 25.

package Shreyam.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sumPairClosestToTarget {
    public static List<Integer> pairCloset(int[]arr,int target){

        // <---- Brute Force Approach --->
        // int len = arr.length;
        // int result[] = new int[2];
        // int closetDiff = Integer.MAX_VALUE;
        // for(int i=0; i<len;i++) {
        //     for(int j=i+1;j<len;j++){
        //         int sum = arr[i] + arr[j];
        //         int diff = Math.abs(target-sum);
        //         if(diff < closetDiff){
        //             closetDiff = diff;
        //             result[0] = arr[i];
        //             result[1] = arr[j];
        //         }
        //     }
        // }
        // return result;
        
        // <--- Optimal Approach ----> 
        Arrays.sort(arr);
        int start =0, end = arr.length-1;
        int diff = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        
        while(start<end){
            int pairSum = arr[start]+ arr[end];
            if (Math.abs(target - pairSum) < diff) {
                diff = Math.abs(target - pairSum);
                ans = Arrays.asList(arr[start], arr[end]);
            }
            
            if (pairSum < target) {
                start++;
            } else if (pairSum > target) {
                end--;
            } else {
                return ans;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {10,30,20,5};
        int target = 25;

        // int [] result =pairCloset(arr, target);
        // Arrays.sort(result);
        // System.out.println(Arrays.toString(result));

        List<Integer> closestPair = pairCloset(arr, target);
        System.out.println(closestPair);
    }
}
