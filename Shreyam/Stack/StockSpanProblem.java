package shreyam.stack;

import java.util.Stack;

public class StockSpanProblem {
    public static int[] stockSpan(int[] price){
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && price[stack.peek()] <= price[i]){
                stack.pop();
            }

            span[i] = stack.isEmpty() ? i+1:i-stack.peek();

            stack.push(i);
        }
        return span;
    }
    public static void main(String[] args) {
        int[] price = {100,80,60,70,60,75,85};
        int [] result = stockSpan(price);

        System.out.println("Stock prices:");
        for(int i:price){
            System.out.print(i + " ");
        }
        System.out.println("\nStock span:");
        for(int s: result){
            System.out.print(s + " ");
        }
    }
}


// This problem is based on nearest greater to left 