package Shreyam.Sliding_Window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSubarray {
    public static int[] maxSubArray(int[]arr,int k){
        int n = arr.length;

        int[] result = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }

            while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]){
                deque.pollLast();
            }

            deque.add(i);

            if(i>=k-1){
                result[i-k+1] = arr[deque.peek()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] res = maxSubArray(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
