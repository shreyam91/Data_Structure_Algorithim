// Question: Min Cost Climbing Stairs... 
// Given an array of integers cost[] where cost[i] is the cost of the ith step on a staircase. Once the cost is paid, you can either climb one or two steps. Return the minimum cost to reach the top of the floor.
// Assume 0-based Indexing. You can either start from the step with index 0, or the step with index 1.

// Examples:
// Input: cost[] = [10, 15, 20]
// Output: 15

package shreyam.gfg;

public class MinCostClimbingStairs {
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];

        for(int i=2;i<n;i++){
            int curr = cost[i] + Math.min(first,second);
            first = second;
            second = curr;
        }
            return Math.min(first,second);
    }
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        int res = minCostClimbingStairs(cost);
        System.out.println(res);
    }
}
