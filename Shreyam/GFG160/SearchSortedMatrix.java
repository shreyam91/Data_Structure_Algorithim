// Question: Search in a sorted Matrix... 
// Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present in the matrix or not.
// Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, and the first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.

// Examples:

// Input: mat[][] = [[1, 5, 9], [14, 20, 21], [30, 34, 43]], x = 14
// Output: true

package shreyam.GFG160;

public class SearchSortedMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0, end = n * m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = matrix[mid / m][mid % m];

            if (value == target) {
                return true;
            } else if (value < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int mat[][] = {{1, 5, 9}, {14, 20, 21}, {30, 34, 43}}, x = 14;
        boolean res = searchMatrix(mat, x);
        System.out.println(res);
    }
}
