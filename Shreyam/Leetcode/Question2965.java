// Question: Find Missing and Repeated values... 
// You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.
// Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

// Example 1:
// Input: grid = [[1,3],[2,2]]
// Output: [2,4]
// Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].

package shreyam.leetCode;

import java.util.HashSet;
import java.util.Set;

public class Question2965 {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> set = new HashSet<>();
        int a=0,b=0;

        for (int[] grid1 : grid) {
            for (int j = 0; j<grid[0].length; j++) {
                if (set.contains(grid1[j])) {
                    a = grid1[j];
                }
                set.add(grid1[j]);
            }
        }
        for(int i=1;i<= n*n; i++){
            if(!set.contains(i)){
                b=i;
                break;
            }
        }
        return new int[]{a,b};
    }
    public static void main(String[] args) {
        int grid[][] = {{1,3},{2,2}};
        int[] res = findMissingAndRepeatedValues(grid);

        for(int ele: res){
            System.out.print(ele + " ");
        } 
    }
}
