// Question: Next element with greater frequency 

// Given an array arr[] of integers, for each element, find the closest (distance wise) to its right that has a higher frequency than the current element.
// If no such element exists, return -1 for that position.

// Examples:
// Input: arr[] = [2, 1, 1, 3, 2, 1]
// Output: [1, -1, -1, 2, 1, -1]

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextElementGreaterFrequency {
    public static ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer>    result = new ArrayList<>(Collections.nCopies(n, -1));
        Map<Integer, Integer> freq   = new HashMap<>();

        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        Stack<Integer> st = new Stack<>();   

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && freq.get(arr[i]) > freq.get(arr[st.peek()])) {
                result.set(st.pop(), arr[i]);
            }
            st.push(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 1, 3, 2, 1};
        System.out.println(findGreater(arr));
    }
}
