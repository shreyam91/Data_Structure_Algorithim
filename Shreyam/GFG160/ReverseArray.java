// Question: Reverse an Array... 
// You are given an array of integers arr[]. Your task is to reverse the given array.
// Note: Modify the array in place.

// Examples:
// Input: arr = [1, 4, 3, 2, 6, 5]
// Output: [5, 6, 2, 3, 4, 1]

package shreyam.GFG160;

import java.util.Arrays;

public class ReverseArray {
    public void reverseArray(int arr[]) {
        int s = 0;
        int e = arr.length - 1;

        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public static void main(String[] args) {

        ReverseArray reverseArrayObj = new ReverseArray();
        int[] arr = {1, 4, 3, 2, 6, 5};
        reverseArrayObj.reverseArray(arr);
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }
}
