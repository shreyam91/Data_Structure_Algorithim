// Question: Zero Array Transformation II... 
// You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].
// Each queries[i] represents the following action on nums:
// Decrement the value at each index in the range [li, ri] in nums by at most vali.
// The amount by which each value is decremented can be chosen independently for each index.
// A Zero Array is an array with all its elements equal to 0.
// Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.

// Example 1:
// Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
// Output: 2

package shreyam.leetCode;

public class Question3356 {
    public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int [] diff = new int[n+1];
        int sum =0, pos =0;

        for(int i=0; i<n;i++){
            while(sum+diff[i] < nums[i]){
                if(pos == queries.length)
                return -1;

                int start = queries[pos][0];
                int end = queries[pos][1];
                int val = queries[pos][2];
                pos++;

                if(end < i) continue;

                diff[Math.max(start, i)] += val;
                if(end + 1 <n) diff [end +1] -= val;
            }
            sum += diff[i];
        }
            return pos;
        
    }
    public static void main(String[] args) {
        int nums [] = {2,0,2};
        int[][] queries = {{0,2,1},{0,2,1},{1,1,3}};

        int res = minZeroArray(nums, queries);
        System.out.println(res);
    }
}
