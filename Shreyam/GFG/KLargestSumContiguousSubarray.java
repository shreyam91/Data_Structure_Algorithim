// Question: K-th Largest Sum Contiguous Subarray

// Given an array arr[] of size n, find the sum of the K-th largest sum among all contiguous subarrays. In other words, identify the K-th largest sum from all possible subarrays and return it.

// Examples:
// Input: arr[] = [3, 2, 1], k = 2 
// Output: 5

package shreyam.gfg;

import java.util.PriorityQueue;

public class KLargestSumContiguousSubarray {
    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum = sum + arr[j];
                
                if(q.size() < k){
                    q.offer(sum);
                }else if(sum > q.peek()){
                    q.poll();
                    q.offer(sum);
                }
            }
        }
        return q.peek();
    }
    public static void main(String[] args) {
        int arr[] = {3, 2, 1};
        int k = 2;

        System.out.println(kthLargest(arr, k));
    }
}
