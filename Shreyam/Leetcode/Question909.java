// Question: Snakes and Ladders 

// Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
// Output: 4

package shreyam.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Question909{
    static int n;

    // Converts cell number to board coordinates considering the zigzag pattern
    private static int[] getCoord(int s) {
        int row = n - 1 - (s - 1) / n;
        int col = (s - 1) % n;
        
        if ((n % 2 == 1 && row % 2 == 1) || (n % 2 == 0 && row % 2 == 0)) {
            col = n - 1 - col;
        }
        
        return new int[]{row, col};
    }

    public static int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1); // Start from cell 1
        visited[n - 1][0] = true;
        
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                int curr = queue.poll();

                if (curr == n * n) return steps;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    int[] coord = getCoord(next);
                    int r = coord[0], c = coord[1];
                    
                    if (visited[r][c]) continue;

                    visited[r][c] = true;

                    if (board[r][c] == -1) {
                        queue.offer(next);
                    } else {
                        queue.offer(board[r][c]);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
    public static void main(String[] args) {
        int [][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}} ;

        System.out.println(snakesAndLadders(board));
    }
}