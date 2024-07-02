

import java.util.Arrays;

public class heightChecker {
    public static void main(String[] args) {
        // int heights []= {1,1,1,2,3,4}; // Output = 0 
        // int heights []= {1,2,1,2,5,4}; // Output = 4
        int heights []= {1,4,1,2,3,2}; // Output = 3 

        heightChecker checker = new heightChecker();
        // int result = checker.getHeight(count);
        System.out.println(checker.getHeight(heights));
        
    }
    public int getHeight(int[] heights) {
        int count = 0;
        int [] expected = Arrays.copyOf(heights,heights.length);
        Arrays.sort(expected);

        for (int i=0;i<heights.length;i++) {
            if(heights[i] != expected[i]){
                count++;
            }
        }
        return count;
    }
}
    // <----------------------- Question -------------------------->

// A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

// You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

// Return the number of indices where heights[i] != expected[i].

 

// Example 1:

// Input: heights = [1,1,4,2,1,3]
// Output: 3
// Explanation: 
// heights:  [1,1,4,2,1,3]
// expected: [1,1,1,2,3,4]
// Indices 2, 4, and 5 do not match.
// Example 2:


