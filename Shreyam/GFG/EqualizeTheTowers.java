// Question: Equalize the Towers 

// You are given an array heights[] representing the heights of towers and another array cost[] where each element represents the cost of modifying the height of respective tower.
// The goal is to make all towers of same height by either adding or removing blocks from each tower.
// Modifying the height of tower (add or remove) 'i' by 1 unit costs cost[i].
// Return the minimum cost to equalize the heights of all towers.

// Examples:
// Input: heights[] = [1, 2, 3], cost[] = [10, 100, 1000]
// Output: 120


package shreyam.gfg;

import java.util.Arrays;

public class EqualizeTheTowers{
    public static int minCost(int[] heights, int[] cost) {
        int lo = Arrays.stream(heights).min().getAsInt();
        int hi = Arrays.stream(heights).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        while(lo<=hi){
            int mid1 = lo+(hi-lo)/3;
            int mid2 = hi- (hi-lo)/3;
            
            int cost1 = getCost(heights, cost, mid1);
            int cost2 = getCost(heights, cost, mid2);
            
            ans=Math.min(ans, Math.min(cost1, cost2));
            if(cost1<cost2){
                hi = mid2-1;
            }
            else {
                lo = mid1+1;
            }
        }
        return ans;
    }
    static int getCost(int[] heights, int[] cost, int h){
        int totalCost = 0;
        for(int i=0;i<heights.length;i++){
            totalCost+=Math.abs(heights[i]-h)*cost[i];
        }
        return totalCost;
    }
    public static void main(String[] args) {
        int heights[] = {1, 2, 3}, cost[] = {10, 100, 1000};
        System.out.println(minCost(heights, cost));
    }
}