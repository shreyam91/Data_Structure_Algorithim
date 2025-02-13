// Question: Minimum Operations to Exceed Threshold Value II... 
// You are given a 0-indexed integer array nums, and an integer k.
// In one operation, you will:Take the two smallest integers x and y in nums.
// Remove x and y from nums.
// Add min(x, y) * 2 + max(x, y) anywhere in the array.
// Note that you can only apply the described operation if nums contains at least two elements.
// Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.

// Example 1:
// Input: nums = [2,11,10,1,3], k = 10
// Output: 2

package shreyam.leetCode;

import java.util.PriorityQueue;

public class Question3066 {
    static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minheap = new PriorityQueue<>();

        for(int num: nums){
            minheap.add((long)num);
        }

        int count = 0;
        while(!minheap.isEmpty()){
            long min1 = minheap.poll();
            if(min1 >= k){
                break;
            }
            long min2 = minheap.poll();

            minheap.add(2 * Math.min(min1, min2) + Math.max(min1, min2));
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2,11,10,1,3};
        int k = 10;
        int res = minOperations(nums, k);
        System.out.println(res);
    }
}
