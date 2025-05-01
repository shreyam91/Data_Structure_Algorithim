// Question: Pascal Triangle... 
// Given a positive integer n, return the nth row of pascal's triangle.
// Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
// File:PascalTriangleAnimated2.gif

// Examples:
// Input: n = 4
// Output: [1, 3, 3, 1]
// Explanation: 4th row of pascal's triangle is [1, 3, 3, 1].

package shreyam.gfg;

import java.util.ArrayList;

public class PascalTriangle {
    static ArrayList<Integer> nthRowOfPascalTriangle(int n) {

        n--; 
        int prev = 1;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(prev);

        for (int i = 1; i <= n; i++) {
            int curr = (int)((long)prev * (n - i + 1) / i); 
            res.add(curr);
            prev = curr;
        }

        return res;       
    }
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> result = nthRowOfPascalTriangle(n);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
