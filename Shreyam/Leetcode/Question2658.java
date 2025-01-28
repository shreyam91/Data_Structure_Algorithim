// Question: Maximum Number of Fish in a Grid... 
// You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:
// A land cell if grid[r][c] = 0, or
// A water cell containing grid[r][c] fish, if grid[r][c] > 0.
// A fisher can start at any water cell (r, c) and can do the following operations any number of times:
// Catch all the fish at cell (r, c), or
// Move to any adjacent water cell.
// Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.
// An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

// Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
// Output: 7
// Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.

package Shreyam.LeetCode;

public class Question2658 {
    static int[] dir = {-1,0,1,0,-1};
    
        static boolean isValid(int x,int y, int m, int n){
                    return x >= 0 && x<  m && y >= 0 && y<n;
                }
            
                static int dfs(int[][] grid, boolean[][] visited, int m, int n, int x, int y){
                    int fishCount = grid[x][y];
                    for(int i=0;i<4;i++){
                        int newX = x + dir[i];
                    int newY = y + dir[i+1];
                    if(isValid(newX,newY,m,n) && !visited[newX][newY] && grid[newX][newY] > 0){
                visited[newX][newY] = true;
                fishCount += dfs(grid,visited,m,n,newX,newY);
            }
        }
        return fishCount;
    }
    public static int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxFish = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] >0){
                    visited[i][j] = true;

                    maxFish = Math.max(maxFish, dfs(grid,visited,m,n,i,j));
                }
            }
        }
        return maxFish;
    }
    public static void main(String[] args) {
        int[][] grid = {{9,10}};
        int res = findMaxFish(grid);
        System.out.println(res);
    }
}
