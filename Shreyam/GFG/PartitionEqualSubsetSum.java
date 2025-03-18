// Question: Partition Equal Subset Sum... 
// Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.
// Note: Each element must be in exactly one subset.
// Examples:
// Input: arr = [1, 5, 11, 5]
// Output: true

package shreyam.gfg;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    static Boolean [][] dp;
    static boolean equalPartition (int [] arr){
        int sum = Arrays.stream(arr).sum();
        if(sum %2 != 0) return false;
        int x = sum/2;
        dp = new Boolean [arr.length][x+1];
        return helper (0,arr,x);
    }

    static boolean helper (int ind, int[] arr, int sum){
        if(ind == arr.length){
            return sum == 0 ? true:false;
        }

        if(dp[ind][sum] != null) {
            return dp[ind][sum];
        }

        boolean res = false;

        if(arr[ind] <= sum){
            res |= helper(ind+1, arr, sum-arr[ind]);
        }

        res |= helper(ind+1, arr, sum);

        return dp[ind][sum] = res;
    }
    public static void main(String[] args) {
        int arr [] = {1,5,11,5};
        boolean res = equalPartition(arr);
        System.out.println(res);
 }   
}
