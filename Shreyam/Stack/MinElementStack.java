package Shreyam.stack;

import java.util.Stack;

public class MinElementStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

        public MinElementStack(){
            stack = new Stack<>();
            minStack = new Stack <>();
        }
    
        public void push(int x){
            stack.push(x);
            if(minStack.isEmpty() || x<= minStack.peek()){
                minStack.push(x);
            }
        }

        public void pop(){
            if(stack.isEmpty()){
                return;
            }
            int poppedElement = stack.pop();
            if(poppedElement == minStack.peek()){
                minStack.pop();
            }
        }

        public int getMin(){
            if(minStack.isEmpty()){
                throw new IllegalStateException("stack is Empty");
            }
            return minStack.peek();
        }
    public static void main(String[] args) {
        int[] arr = {5, 15, 12, 19, 21, 3, 9};
        
        MinElementStack minStack = new MinElementStack();
        
        System.out.println("Pushing elements to the stack:");
        for (int num : arr) {
            minStack.push(num);
            System.out.println("Pushed: " + num + ", Current Minimum: " + minStack.getMin());
        }
    }
}
