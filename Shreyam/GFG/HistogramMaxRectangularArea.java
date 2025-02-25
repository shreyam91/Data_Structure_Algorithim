// Question: Histogram Max Rectangular Area... 
// You are given a histogram represented by an array arr, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.
// Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

// Examples:
// Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
// Output: 100
// Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.

package shreyam.gfg;

import java.util.Stack;

public class HistogramMaxRectangularArea {
    public static int getMaxArea(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < arr.length) {
            if (stack.isEmpty() || arr[stack.peek()] <= arr[index]) {
                stack.push(index++);
            } else {
                int topOfStack = stack.pop();
                int area = arr[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = arr[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int arr[] = {60, 20, 50, 40, 10, 50, 60};
        int res = getMaxArea(arr);
        System.out.println(res);
    }
}
