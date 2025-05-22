// Question: Zero Array Transformation III 

// ou are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri].
// Each queries[i] represents the following action on nums:
// Decrement the value at each index in the range [li, ri] in nums by at most 1.
// The amount by which the value is decremented can be chosen independently for each index.
// A Zero Array is an array with all its elements equal to 0.
// Return the maximum number of elements that can be removed from queries, such that nums can still be converted to a zero array using the remaining queries. If it is not possible to convert nums to a zero array, return -1.

// Example 1:
// Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]
// Output: 1

package shreyam.leetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Question3362 {
    public static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        PriorityQueue<Integer> usedQuery = new PriorityQueue<>(); // Min-heap (stores end points)
        PriorityQueue<Integer> availableQuery = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap (stores end points)
        
        // Sort queries by start point
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int queryPos = 0;
        int appliedCount = 0;
        
        for (int i = 0; i < n; i++) {
            // Push all queries starting at `i` into availableQuery
            while (queryPos < queries.length && queries[queryPos][0] == i) {
                availableQuery.offer(queries[queryPos][1]);
                queryPos++;
            }
            
            // Adjust nums[i] by subtracting the number of active queries covering it
            nums[i] -= usedQuery.size();
            
            // Apply queries if nums[i] > 0
            while (nums[i] > 0 && !availableQuery.isEmpty() && availableQuery.peek() >= i) {
                int end = availableQuery.poll();
                usedQuery.offer(end);
                nums[i]--;
                appliedCount++;
            }
            
            // If nums[i] couldn't be reduced to zero
            if (nums[i] > 0) {
                return -1;
            }
            
            // Remove queries that end at `i` from usedQuery
            while (!usedQuery.isEmpty() && usedQuery.peek() == i) {
                usedQuery.poll();
            }
        }
        
        return queries.length - appliedCount;
    }
    public static void main(String[] args) {
        int [] nums = {2,0,2};
        int[][] queries = {{0,2},{0,2},{1,1}};
        System.out.println(maxRemoval(nums, queries));
    }
}
