package shreyam.stack;

import java.util.Stack;

public class MinimumElementStackWithExtraSpace {
    private Stack<Integer> stack;  
    private Stack<Integer> minStack;  

    public MinimumElementStackWithExtraSpace(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x){
        stack.push(x);

        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop(){
        if(!stack.isEmpty()){
            int popped = stack.pop();

            if(popped == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int getMin(){
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        MinimumElementStackWithExtraSpace minStack = new MinimumElementStackWithExtraSpace();

        int[] arr = {11, 52,16, 8, 42, 9};

        for(int num : arr){
            minStack.push(num);
            System.out.println("Pushed " + num + " | Current Min: " + minStack.getMin());
        }

        System.out.println("\nPopping elements:");
        while(!minStack.stack.isEmpty()){
            minStack.pop();
            if (minStack.minStack.isEmpty()) {
                System.out.println("Popped | Stack is empty.");
            } else {
                System.out.println("Popped | Current Min: " + minStack.getMin());
            }
        }
    }
}
