// Question: Longest Bounded-Difference Subarray... 
// Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x. If multiple such subarrays exist, return the one that starts at the smallest index.

// Examples: 
// Input: arr[] = [8, 4, 2, 6, 7], x = 4 
// Output: [4, 2, 6] 
// Explanation: The sub-array described by index [1..3], i.e. [4, 2, 6] contains no such difference of two elements which is greater than 4.

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LongestBoundedDifferenceSubarray {
    public static ArrayList<Integer> longestSubarray(int[]arr, int x){
        Deque<Integer> maxDq = new LinkedList<>();
        Deque<Integer> minDq = new LinkedList<>();

        int str=0, maxLen =0, ansStr=0;
        for(int end=0; end<arr.length;end++){
            while(!maxDq.isEmpty() && arr[maxDq.peekLast()] <= arr[end]){
                maxDq.pollLast();
            }
            maxDq.addLast(end);
            while(!minDq.isEmpty() && arr[minDq.peekLast()] >= arr[end]){
                minDq.pollLast();
            }
            minDq.addLast(end);

            while(arr[maxDq.peekFirst()] - arr[minDq.peekFirst()] > x){
                str++;
                if(maxDq.peekFirst()<str)maxDq.pollFirst();
                if(minDq.peekFirst()<str)minDq.pollFirst();
            }
            if(end-str + 1 > maxLen){
                maxLen = end-str+1;
                ansStr = str;
            }
        }

        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=ansStr; i<ansStr+maxLen;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {8,4,2,6,7};
        int x = 4;
        ArrayList<Integer> res = longestSubarray(arr, x);
        System.out.println(res);
    }
}
