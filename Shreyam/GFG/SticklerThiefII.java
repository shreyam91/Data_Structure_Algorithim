// Question: SticklerThiefII... 

// You are given an array arr[] which represents houses arranged in a circle, where each house has a certain value. A thief aims to maximize the total stolen value without robbing two adjacent houses.
// Determine the maximum amount the thief can steal.
// Note: Since the houses are in a circle, the first and last houses are also considered adjacent.

// Examples:
// Input: arr[] = [2, 3, 2]
// Output: 3

package shreyam.gfg;

import java.util.Arrays;

public class SticklerThiefII {
    static int maxValue(int[] arr) {
        int n = arr.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        return Math.max(f1(n-2, arr, dp1, false), f1(n-1, arr, dp2, true));
            }
            static int f1(int ind, int arr[], int dp[], boolean fl){
        if(fl==false)
        if(ind<0) return 0;
        if(fl==true)
        if(ind<=0) return 0;
        
        if(dp[ind]!=-1) return dp[ind];
        
        int nt = f1(ind-1, arr, dp,fl);
        int t = arr[ind] + f1(ind-2, arr, dp,fl);
        
        return dp[ind] = Math.max(nt, t);
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, 2};
        int res = maxValue(arr);
        System.out.println(res);
    }   
}
