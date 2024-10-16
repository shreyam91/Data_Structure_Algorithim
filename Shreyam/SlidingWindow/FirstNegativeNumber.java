package Shreyam.SlidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeNumber {
    public static int[] firstNegativeNumber(int[] arr, int k){
        int n = arr.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i< n;i++){
            if(!deque.isEmpty() && deque.peek() <i-k+1){
                deque.poll();
            }

            if(arr[i] < 0){
                deque.add(i);
            }

            if(i>= k-1){
                if(deque.isEmpty()){
                    result[i-k+1] = 0;
                }else{
                    result[i-k+1] = arr[deque.peek()];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,-1,4,6,-2,4,6,8,9};
        int k = 3;

        int[] res = firstNegativeNumber(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
