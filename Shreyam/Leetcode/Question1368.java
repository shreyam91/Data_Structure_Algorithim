// Question: Minimum Cost to Make at Least One Valid Path in Grid... 
// Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:
// 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
// 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
// 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
// 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
// Notice that there could be some signs on the cells of the grid that point outside the grid.
// You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.
// You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.
// Return the minimum cost to make the grid have at least one valid path.
// Example 1:
// Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
// Output: 3
// Explanation: You will start at point (0, 0).
// The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
// The total cost = 3.

package shreyam.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Question1368 {
    public static int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});

        int[] dir = {0, 1, 0, -1, 0};

        Map<Pair<Integer, Integer>, Integer> mpDir = new HashMap<>();
        mpDir.put(new Pair<>(0, 1), 1);
        mpDir.put(new Pair<>(1, 0), 3);
        mpDir.put(new Pair<>(0, -1), 2);
        mpDir.put(new Pair<>(-1, 0), 4);

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[1];
            int y = top[2];

            if (x == n - 1 && y == m - 1) {
                return cost[x][y];
            }

            if (top[0] > cost[x][y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dir[i];
                int newY = y + dir[i + 1];

                if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    int dirCost = 0;

                    if (grid[x][y] != mpDir.get(new Pair<>(dir[i], dir[i + 1]))) {
                        dirCost = 1;
                    }

                    int newCost = top[0] + dirCost;

                    if (newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;
                        pq.offer(new int[]{newCost, newX, newY});
                    }
                }
            }
        }

        return cost[n - 1][m - 1];
    }

    private static class Pair<T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }
    }
    public static void main(String[] args) {
        int [][] arr = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
        int res = minCost(arr);
        System.out.println(res);
    }
}
