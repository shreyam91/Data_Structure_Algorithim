// Question: Count Servers that Communicate... 
// You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
// Return the number of servers that communicate with any other server.

// Input: grid = [[1,0],[0,1]]
// Output: 0
// Explanation: No servers can communicate with others.

package Shreyam.LeetCode;

public class Question1267 {
    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [] rowCount = new int[m];
        int [] colCount = new int[n];
        int totalServers =0;
        
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(grid[i][j]== 1){
                    rowCount[i]++;
                    colCount[j]++;
                    totalServers++;
                }
            }
        }
        for(int i=0; i<m ;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    totalServers--;
                }
            }
        }

        return totalServers;
        
    }
    public static void main(String[] args) {
        int [][] arr = {{1,0},{0,1}};
        int res = countServers(arr);
        System.out.println(res);
    }
}
