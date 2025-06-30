// Question: Max min Height 

// Given a garden with n flowers planted in a row, that is represented by an array arr[], where arr[i] denotes the height of the ith flower.You will water them for k days. In one day you can water w continuous flowers. Whenever you water a flower its height increases by 1 unit. You have to maximize the minimum height of all flowers after  k days of watering.

// Examples:
// Input: arr[] = [2, 3, 4, 5, 1], k = 2, w = 2
// Output: 2

package shreyam.gfg;

public class MaxMinHeight {
    private static boolean isPossible(int[] arr, int k, int w, int targetHeight) {
        int n = arr.length;
        int[] water = new int[n + 1]; 
        int daysUsed  = 0;
        int currWater = 0;

        for (int i = 0; i < n; i++) {
            currWater += water[i]; 
            int currHeight = arr[i] + currWater;
            if (currHeight < targetHeight) {
                int need = targetHeight - currHeight; 
                daysUsed += need;
                if (daysUsed > k) {
                    return false;
                }
                currWater += need;
                water[i]  += need;       
                if (i + w <= n) {
                    water[i + w] -= need; 
                }
            }
        }
        return true;
    }
    
    public static int maxMinHeight(int[] arr, int k, int w) {
        int low = Integer.MAX_VALUE;

        for (int v : arr) {
            low = Math.min(low, v);
        }
        int high = low + k;

        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, k, w, mid)) {
                result = mid;      
                low    = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 1};
        int k = 2, w = 2;
        System.out.println(maxMinHeight(arr, k, w));
    }
}
