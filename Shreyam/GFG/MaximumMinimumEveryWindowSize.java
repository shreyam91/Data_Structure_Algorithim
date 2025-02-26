// Question: Maximum of minimum for every window size... 
// Given an array of integers arr[], the task is to find the maximum of the minimum values for every possible window size in the array, where the window size ranges from 1 to arr.size().
// More formally, for each window size k, determine the smallest element in all windows of size k, and then find the largest value among these minimums where 1<=k<=arr.size().

// Examples :
// Input: arr[] = [10, 20, 30, 50, 10, 70, 30]
// Output: [70, 30, 20, 10, 10, 10, 10] 

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaximumMinimumEveryWindowSize {

    public static ArrayList<Integer> maxOfMin(int[] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n + 1, Integer.MIN_VALUE));

        Stack<Integer> stack = new Stack<>();

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;

            result.set(len, Math.max(result.get(len), arr[i]));
        }

        for (int i = n - 1; i >= 1; i--) {
            result.set(i, Math.max(result.get(i), result.get(i + 1)));
        }

        result.remove(0);
        return result;


        // int n = arr.length;
        // int[] res = new int[n], len = new int[n];
        // Stack<Integer> s = new Stack<>();
        // for (int i = 0; i <= n; i++) {
        //     while (!s.isEmpty() && (i == n || arr[s.peek()] >= arr[i])) {
        //         int j = s.pop();
        //         len[j] = s.isEmpty() ? i : i - s.peek() - 1;
        //     }
        //     if (i < n) s.push(i);
        // }
        // for (int i = 0; i < n; i++) res[len[i] - 1] = Math.max(res[len[i] - 1], arr[i]);
        // for (int i = n - 2; i >= 0; i--) res[i] = Math.max(res[i], res[i + 1]);
        // ArrayList<Integer> ans = new ArrayList<>();
        // for (int r : res) ans.add(r);
        // return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};
        int n = arr.length;

        ArrayList<Integer> result = maxOfMin(arr, n);

        System.out.println("Maximum of Minimums for every window size: ");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
