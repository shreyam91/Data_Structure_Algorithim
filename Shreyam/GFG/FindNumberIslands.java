// Question: Find the number of islands... 

// Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.
// Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

// Examples:
// Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], ['W', 'L', 'W', 'W', 'L'], ['L', 'W', 'W', 'L', 'L'], ['W', 'W', 'W', 'W', 'W'], ['L', 'W', 'L', 'L', 'W']]
// Output: 4

package shreyam.gfg;

public class FindNumberIslands {

    public boolean isSafe(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;

        return (r >= 0) && (r < row) && (c >= 0) && (c < col) && grid[r][c] == 'L';
    }

    public void dfs(char[][] grid, int r, int c) {

        int[] rNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cNbr = {-1, 0, 1, -1, 1, -1, 0, 1};

        grid[r][c] = 'W';

        for (int k = 0; k < 8; ++k) {
            int newR = r + rNbr[k];
            int newC = c + cNbr[k];

            if (isSafe(grid, newR, newC)) {
                dfs(grid, newR, newC);
            }
        }
    }

    public int countIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {

                if (grid[r][c] == 'L') {
                    dfs(grid, r, c);
                    ++count;  
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'L', 'L', 'W', 'W', 'W'},
            {'W', 'L', 'W', 'W', 'L'},
            {'L', 'W', 'W', 'L', 'L'},
            {'W', 'W', 'W', 'W', 'W'},
            {'L', 'W', 'L', 'L', 'W'}
        };

        FindNumberIslands islands = new FindNumberIslands();
        int result = islands.countIslands(grid);

        System.out.println("Number of islands: " + result);
    }
}

