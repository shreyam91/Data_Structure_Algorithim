// Question: Minimum cost to connect all houses in a city... 
// Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate represents the location of each house, the task is to find the minimum cost to connect all the houses of the city.
// The cost of connecting two houses is the Manhattan Distance between the two points (xi, yi) and (xj, yj) i.e., |xi – xj| + |yi – yj|, where |p| denotes the absolute value of p.

// Examples :
// Input: n = 5 houses[][] = [[0, 7], [0, 9], [20, 7], [30, 7], [40, 70]]
// Output: 105

package shreyam.gfg;

import java.util.Arrays;

public class MinimumCostConnectHousesCity {
    public static int minCost(int[][] houses) {

        int n = houses.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int cost = 0;

        for (int i = 0; i < n; ++i) {
            int u = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }

            visited[u] = true;
            cost += minDist[u];

            for (int v = 0; v < n; ++v) {
                if (!visited[v]) {
                    int dist = Math.abs(houses[u][0] - houses[v][0]) + Math.abs(houses[u][1] - houses[v][1]);
                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }

        return cost;        
    }
    public static void main(String[] args) {
        // int n = 5; 
        int houses[][] = {{0, 7}, {0, 9}, {20, 7}, {30, 7}, {40, 70}};

        int res = minCost(houses);
        System.out.println(res);
    }
}
