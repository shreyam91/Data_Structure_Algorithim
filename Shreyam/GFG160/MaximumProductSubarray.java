// Question: Maximum Product Subarray... 
// Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].
// Note: It is guaranteed that the output fits in a 32-bit integer.

// Examples
// Input: arr[] = [-2, 6, -3, -10, 0, 2]
// Output: 180


package shreyam.GFG160;

public class MaximumProductSubarray {
    static int maxProduct(int[] arr) {
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(arr[i], maxProduct * arr[i]);
            minProduct = Math.min(arr[i], minProduct * arr[i]);

            result = Math.max(result, maxProduct);
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {-2, 6, -3, -10, 0, 2};
        System.out.println("Maximum product subarray is: " + maxProduct(arr));
    }
}
