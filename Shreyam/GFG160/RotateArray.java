// Question: Rotated Array... 
// Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.
// Note: Consider the array as circular.

// Examples :
// Input: arr[] = [1, 2, 3, 4, 5], d = 2
// Output: [3, 4, 5, 1, 2]
// Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.

package shreyam.GFG160;

public class RotateArray {
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
         d %= n;
         reverse(arr,0,d-1);
         reverse(arr,d,n-1);
         reverse(arr,0,n-1);
    }

    private static void reverse(int[]arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int d = 3 ;

        rotateArr(arr, d);

        System.out.print("Rotated array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
