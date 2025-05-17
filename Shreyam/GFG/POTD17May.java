// Question: Sort the given array after applying the given equation

// Given an integer array arr[] sorted in ascending order, along with three integers: A, B, and C. The task is to transform each element x in the array using the quadratic function A*(x2) + B*x + C. After applying this transformation to every element, return the modified array in sorted order.

// Examples:
// Input: arr[] = [-4, -2, 0, 2, 4], A = 1, B = 3, C = 5
// Output: [3, 5, 9, 15, 33]

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Collections;

public class POTD17May {
    public static  ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int x : arr) {
            int ans = A * x * x + B * x + C;
            result.add(ans); 
        }

        Collections.sort(result);

        return result;
        
    }
    public static void main(String[] args) {
        int arr[] = {-4, -2, 0, 2, 4};
        int A = 1, B = 3, C = 5;
        System.out.println(sortArray(arr, A, B, C));
    }
}
