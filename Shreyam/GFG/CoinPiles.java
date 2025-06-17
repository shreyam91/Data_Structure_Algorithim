// Question: Coin Piles

// You are given an array arr[] of integers, where each element represents the number of coins in a pile. You are also given an integer k.
// Your task is to remove the minimum number of coins such that the absolute difference between the number of coins in any two updated piles is at most k.

// Note: You can also remove a pile by removing all the coins of that pile.

// Examples:

// Input: arr[] = [2, 2, 2, 2], k = 0
// Output: 0

package shreyam.gfg;

import java.util.Arrays;

public class CoinPiles{
    public static int minimumCoins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i]+arr[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int remLeft = prefix[i];
            int upper = upperBound(arr, arr[i]+k);
            int remRight = prefix[n]-prefix[upper] - (n-upper)*(arr[i]+k);
            ans=Math.min(ans, remLeft + remRight);
        }
        return ans;
    }
    static int upperBound(int[] arr, int v){
        int lo=0,hi = arr.length-1, ans=-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]<=v){
                lo=mid+1;
                ans=mid+1;
            }
            else {
                hi=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2, 2, 2, 2};
        int k = 0;
        System.out.println(minimumCoins(arr, k));
    }
}
