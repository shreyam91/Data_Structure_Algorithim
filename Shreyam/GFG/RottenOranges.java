// Question: Rotten Oranges... 
// Given a matrix mat[][] of dimension n * m where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
// 0 : Empty cell
// 1 : Cell have fresh oranges
// 2 : Cell have rotten oranges
// We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.
// Note: Your task is to return the minimum time to rot all the fresh oranges. If not possible returns -1.

// Examples:
// Input: mat[][] = [[0, 1, 2], [0, 1, 2], [2, 1, 1]]
// Output: 1

package shreyam.gfg;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int orangesRotting(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0, count = 0;
        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    vis[i][j] = 1;
                    q.offer(new int[]{0, i, j});  
                    count++;
                } else if (mat[i][j] == 1) {
                    count++;
                }
            }
        }

        int[] radd = {-1, 1, 0, 0};
        int[] cadd = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] front = q.poll();
            int t = front[0], row = front[1], col = front[2];
            
            ans = Math.max(ans, t);
            count--;
            
            for (int i = 0; i < 4; i++) {
                int nrow = row + radd[i], ncol = col + cadd[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                    vis[nrow][ncol] = 1;
                    q.offer(new int[]{t + 1, nrow, ncol});
                }
            }
        }

        return count == 0 ? ans : -1;
    }
    public static void main(String[] args) {
        int mat[][] = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        int res = orangesRotting(mat);
        System.out.println(res);

    }
}
