package Shreyam.Stack;

import java.util.Stack;

public class NearestSmallerToRight {
    public static int[] nextSmallerElement(int[] arr){
        int n = arr.length;
        int result[] = new int[n];
        Stack<Integer>stack = new Stack<>();

        for(int i=n-1; i>=0 ;i--){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = stack.peek();
            }else{
                result[i] = -1;
            }
            stack.push(arr[i]);
            }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        int[] result = nextSmallerElement(arr);

        for(int i: result){
            System.out.print(i + " ");
        }
    }
}
