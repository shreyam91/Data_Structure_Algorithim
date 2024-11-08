package Shreyam.Stack;

import java.util.Stack;

public class MaxAreaRectangle {
    public static int maxRectangle(int[][]matrix){
        if(matrix.length == 0) return 0;
        int length = matrix.length;
        int maxArea=0;
        int[] height = new int [matrix[0].length];

        for(int i=0;i<length;i++){
            for(int j=0;j<matrix[0].length;j++){
                height[j] = matrix[i][j] == 1? height[j] +1 :0;
            }
            maxArea = Math.max(maxArea, maxHistogram(height));
        }
        return maxArea;
    }
    public static int maxHistogram (int[] height){
        Stack<Integer> stack = new Stack<>();
        int maxArea =0;
        int i=0;

        while(i < height.length){
            if(stack.isEmpty() || height[i] >= height[stack.peek()]){
                stack.push(i++);
            }else{
                int heights = height[stack.pop()];
                int width = stack.empty() ? i : i-stack.peek() -1;
                maxArea = Math.max(maxArea,heights*width);
            }
        }
        while(!stack.isEmpty()){
            int heights = height[stack.pop()];
            int width = stack.isEmpty() ? i :i-stack.peek() -1;
            maxArea = Math.max(maxArea,heights*width);
        }
        return maxArea;
    }    
    public static void main(String[] args) {
        int[][] matrix = {
            {0,1,1,0},
            {1,1,1,0},
            {1,1,1,1},
            {1,1,0,0}
        };
        int result = maxRectangle(matrix);
        System.out.println("Maximum rectangle area in given matrix are:" + result);
    }
}
