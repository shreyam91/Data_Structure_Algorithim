package shreyam.stack;

import java.util.Stack;

public class MaximumAreaHistogram {
    public static int maxArea(int[] height){
        int n= height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int maxArea =0;
        Stack<Integer> stack = new Stack<>();

        // NSL (nearest smaller left) 
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // NSR (nearest smaller right)
        for(int i=n-1; i>= 0; i--){
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate area...
        for(int i=0; i<n;i++){
            int width=right[i] - left[i] -1;
            int area = height[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;

    }
    public static void main(String[] args) {
        int[] height = {6,2,5,4,5,1,6};
        int result = maxArea(height);

        System.out.println("Maximum area of given height is:" + result);
    }
}
