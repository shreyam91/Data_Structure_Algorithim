// Question: Flood fill Algorithm... 
// You are given a 2D grid image[][] of size n*m, where each image[i][j] represents the color of a pixel in the image. Also provided a coordinate(sr, sc) representing the starting pixel (row and column) and a new color value newColor.
// Your task is to perform a flood fill starting from the pixel (sr, sc), changing its color to newColor and the color of all the connected pixels that have the same original color. Two pixels are considered connected if they are adjacent horizontally or vertically (not diagonally) and have the same original color.

// Examples:
// Input: image[][] = [[1, 1, 1, 0], [0, 1, 1, 1], [1, 0, 1, 1]], sr = 1, sc = 2, newColor = 2
// Output: [[2, 2, 2, 0], [0, 2, 2, 2], [1, 0, 2, 2]]

package shreyam.gfg;

public class FloodFillAlgorithm {
    static int n;
    static int m;
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
         n=image.length;
        m=image[0].length;
        
        int vis[][]=new int[n][m];
        
        dfs(image,sr,sc,vis,image[sr][sc],newColor);
        return image;
    }
    
    public static void dfs(int[][] image ,int r,int c,int[][] vis,int currColor,int newColor){
        if(r<0 || r>=n || c<0 || c>=m || image[r][c]!=currColor || vis[r][c]==1){
            return ;
        }
        
         vis[r][c]=1;
         image[r][c]=newColor;
         
         dfs(image,r-1,c,vis,currColor,newColor);
         dfs(image,r,c+1,vis,currColor,newColor);
         dfs(image,r+1,c,vis,currColor,newColor);
         dfs(image,r,c-1,vis,currColor,newColor);
    }
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1, 0},
            {0, 1, 1, 1},
            {1, 0, 1, 1}
        };
        int sr = 1, sc = 2, newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);

        System.out.println("Flood filled image:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
