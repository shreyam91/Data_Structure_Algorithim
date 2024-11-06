package Shreyam.Stack;

import java.util.Stack;

public class NearestGreaterToLeft {
    public static int[] findPreviousGreater(int[] arr){
        int n = arr.length;
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i= 0;i<n;i++){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
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
        int[] arr = {1,3,2,4};
        int [] result = findPreviousGreater(arr);

        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
