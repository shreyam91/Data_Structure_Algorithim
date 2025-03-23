// Question: Number of Ways to Arrive at Destination... 
// You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
// You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
// Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.   

// Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
// Output: 4

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Question1976 {
    private static final int MOD = 1000000007;

    public static int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new long[]{road[1], road[2]});
            adj.get(road[1]).add(new long[]{road[0], road[2]});
        }

        PriorityQueue<long[]> minheap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        minheap.offer(new long[]{0, 0}); 
        boolean[] processed = new boolean[n];

        long[] countWays = new long[n]; 
        countWays[0] = 1; 
        long[] minCost = new long[n];
        Arrays.fill(minCost, Long.MAX_VALUE);
        minCost[0] = 0; 

        while (!minheap.isEmpty()) {
            long[] curr = minheap.poll();
            long cost = curr[0];
            int currNode = (int) curr[1];

            if (processed[currNode]) continue;
            processed[currNode] = true;

            for (long[] neighbor : adj.get(currNode)) {
                int nbr = (int) neighbor[0];
                long weight = neighbor[1];

                if (!processed[nbr]) {
                    if (cost + weight == minCost[nbr]) {
                        countWays[nbr] = (countWays[nbr] + countWays[currNode]) % MOD;
                    } else if (cost + weight < minCost[nbr]) {
                        minCost[nbr] = cost + weight;
                        countWays[nbr] = countWays[currNode];
                        minheap.offer(new long[]{minCost[nbr], nbr});
                    }
                }
            }
        }

        return (int) countWays[n - 1];
    }
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
            {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, 
            {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}
        };

        System.out.println(countPaths(n, roads));
    }
}
