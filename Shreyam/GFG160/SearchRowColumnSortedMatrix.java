// Question: Search in a Row-Column sorted matrix... 
// Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.

// Examples:
// Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
// Output: false

package shreyam.GFG160;

public class SearchRowColumnSortedMatrix {
    public static boolean matSearch(int mat[][], int x) {
        int m = mat.length;
        int n = mat[0].length;
        
        int row = 0,col = n-1;
        
        while(row < m && col >= 0){
            if(mat[row][col] == x){
                return true;
            }else if(mat[row][col] > x){
                col--;
            }else{
                row++;
            }
        }
        return false;
       }
    public static void main(String[] args) {
        int mat[][] = {{3, 30, 38},{20, 52, 54},{35, 60, 69}};
        int x = 62;

        boolean res = matSearch(mat, x);
        System.out.println(res);
    }
}
