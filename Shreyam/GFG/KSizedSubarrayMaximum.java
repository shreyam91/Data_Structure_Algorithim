// Question: K Sized Subarray Maximum... 
// Given an array arr[] of integers and an integer k, your task is to find the maximum value for each contiguous subarray of size k. The output should be an array of maximum values corresponding to each contiguous subarray.

// Examples:
// Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
// Output: [3, 3, 4, 5, 5, 5, 6] 

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class KSizedSubarrayMaximum {
    public static ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Deque <Integer> deque = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(!deque.isEmpty() && deque.peekFirst() == i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k-1){
                ans.add(arr[deque.peekFirst()]);
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 4;
        ArrayList<Integer> res = maxOfSubarrays(arr, k);
        System.out.println(res);
    }
}

