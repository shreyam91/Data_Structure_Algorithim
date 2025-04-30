// Question: Two Sum - Pair with Given Sum.. 
// Given an array arr[] of positive integers and another integer target. Determine if there exist two distinct indices such that the sum of their elements is equal to the target.

// Examples:
// Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
// Output: true

package shreyam.GFG160;

import java.util.HashSet;

public class TwoSumPairWithGivenSum {
    static boolean twoSum(int arr[], int target) {
        
        int n = arr.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i] + arr[j] == target)
        //         {
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        HashSet<Integer> pair = new HashSet<>();
        
        for(int i=0; i<n;i++){
            int complement = target-arr[i];
            
            if(pair.contains(complement)){
                return true;
            }
            pair.add(arr[i]);
        }
        
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 10, 8};
        int target = 16;
        boolean res = twoSum(arr, target);
        System.out.println(res);
    }
}
