// Question: Sum of subarray minimum
// Difficulty: MediumAccuracy: 46.92%Submissions: 20K+Points: 4Average Time: 30m
// Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.
// Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.

// Examples:
// Input: arr[] = [3, 1, 2, 4]
// Output: 17

package shreyam.gfg;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumSubarrayMinimum {
    public static int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            // if empty, no smaller to left; else top of stack is NSL
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    public static int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }

    public static int sumSubMins(int[] arr) {
        int n = arr.length;
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int leftD = i - NSL[i];
            int rightD = NSR[i] - i;
            sum += arr[i] * leftD * rightD;
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 4};
        System.out.println(sumSubMins(arr));
    }
}
