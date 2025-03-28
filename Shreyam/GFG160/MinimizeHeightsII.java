// Question: Minimize the Heights II.... 

// Given an array arr[] denoting heights of N towers and a positive integer K.
// For each tower, you must perform exactly one of the following operations exactly once.
// Increase the height of the tower by K
// Decrease the height of the tower by K
// Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.
// You can find a slight modification of the problem here.
// Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

// Examples :
// Input: k = 2, arr[] = {1, 5, 8, 10}
// Output: 5

package shreyam.GFG160;

import java.util.Arrays;

public class MinimizeHeightsII {
    static int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        
        if(n==1){
            return 0;
        }
        
        int largest = arr[n-1];
        int shortest = arr[0];
        int ans = largest - shortest;
        
        for(int i=1; i<n; i++){
            largest = Math.max(arr[n-1]-k, arr[i-1] +k);
            shortest = Math.min(arr[0] +k, arr[i]-k);
            if(shortest < 0) continue;
            ans = Math.min(ans, largest-shortest);
        }
        return ans;
    }
    public static void main(String[] args) {
        int k =2;
        int arr[] = {1, 5, 8, 10};
        System.out.println(getMinDiff(arr, k));
    }
}
