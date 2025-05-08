// Question: Find Minimum Time to Reach Last Room 2

// There is a dungeon with n x m rooms arranged as a grid.
// You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two.
// Return the minimum time to reach the room (n - 1, m - 1).
// Two rooms are adjacent if they share a common wall, either horizontally or vertically.

// Example 1:
// Input: moveTime = [[0,4],[4,4]]
// Output: 7

package shreyam.leetCode;

import java.util.PriorityQueue;


public class Question3342 {
    private static final int[] dir = {-1, 0, 1, 0, -1};

    static class Node {
        int r, c, time, cost;

        Node(int r, int c, int time, int cost) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.cost = cost;
        }
    }

    static class Comparator implements java.util.Comparator<Node> {
        public int compare(Node p1, Node p2) {
            return Integer.compare(p1.time, p2.time);
        }
    }

    private static boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }

    public static int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator());
        minHeap.offer(new Node(0, 0, 0, 1));
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();

            if (curr.r == m - 1 && curr.c == n - 1)
                return curr.time;

            for (int i = 0; i < 4; ++i) {
                int newR = curr.r + dir[i];
                int newC = curr.c + dir[i + 1];
                int nextCost = curr.cost == 1 ? 2 : 1;

                if (isValid(newR, newC, m, n) && !visited[newR][newC]) {
                    int newTime = curr.cost + Math.max(curr.time, moveTime[newR][newC]);
                    Node newNode = new Node(newR, newC, newTime, nextCost);
                    minHeap.offer(newNode);
                    visited[newR][newC] = true;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] []moveTime = {{0,4},{4,4}};
        System.out.println(minTimeToReach(moveTime));
    }
}
