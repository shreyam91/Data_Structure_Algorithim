// Question: Split Array Largest Sum

// Given an array arr[] and an integer k, divide the array into k contiguous subarrays such that the maximum sum among these subarrays is minimized. Find this minimum possible maximum sum.

// Examples:
// Input: arr[] = [1, 2, 3, 4], k = 3
// Output: 4

package shreyam.gfg;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public static boolean check(int mid, int[] arr, int k) {
        int n = arr.length;

        int count = 1; 
        int sum   = 0; 

        for (int i = 0; i < n; i++) {
            if (arr[i] > mid) {
                return false;
            }

            sum += arr[i]; 

            if (sum > mid) {
                count++;
                sum = arr[i]; 
            }
        }
        return count <= k; 
    }
    public static int splitArray(int[] arr, int k) {
        int n = arr.length;

        int low    = Arrays.stream(arr).max().getAsInt(); 
        int high   = Arrays.stream(arr).sum(); 
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(mid, arr, k)) {
                result = mid;    
                high   = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
       int arr[] = {1, 2, 3, 4};
       int k = 3;
       System.out.println(splitArray(arr, k));
    }
}
