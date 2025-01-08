// Question: Count the number of possible triangles... 
// Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. 

// A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

// Examples:

// Input: arr[] = [4, 6, 3, 7]
// Output: 3
// Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. Note that [3, 4, 7] is not a possible triangle. 

package Shreyam.GFG;

import java.util.Arrays;

public class countTheNumberOfPossibleTriangles {
    static int countTriangles(int[] arr) {
        Arrays.sort(arr);
        int count = 0, n = arr.length;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) count += (r-- - l);
                else ++l;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] arr = {4, 6, 3, 7};
        int result = countTriangles(arr);
        System.out.println("There are " + result + " traingles make using above number.");
    }
}
