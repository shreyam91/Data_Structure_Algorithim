// Question: Count Total Number of Colored Cells... 
// There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:
// At the first minute, color any arbitrary unit cell blue.
// Every minute thereafter, color blue every uncolored cell that touches a blue cell.
// Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.
// Return the number of colored cells at the end of n minutes.

// Example 1:
// Input: n = 1
// Output: 1
// Explanation: After 1 minute, there is only 1 blue cell, so we return 1.

package shreyam.leetCode;

public class Question2579 {
    public static long coloredCells(int n){
        long count = 1;
        long jumpSize = 4;
        while(n>1){
            count += jumpSize;
            jumpSize += 4;
            n--;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 1;
        long res = coloredCells(n);
        System.out.println(res);
    }
}
