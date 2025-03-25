// Question: Check if Grid can be Cut into Sections... 
// You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid. Each rectangle is defined as follows:
// (startx, starty): The bottom-left corner of the rectangle.
// (endx, endy): The top-right corner of the rectangle.
// Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or two vertical cuts on the grid such that:
// Each of the three resulting sections formed by the cuts contains at least one rectangle.
// Every rectangle belongs to exactly one section.
// Return true if such cuts can be made; otherwise, return false.

// Example 1:
// Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
// Output: true

package shreyam.leetCode;

import java.util.Arrays;

public class Question3394 {
    public boolean checkValidCuts(int n, int[][] rectangles) {
    int[][] xs = new int[rectangles.length][2];
    int[][] ys = new int[rectangles.length][2];

    for (int i = 0; i < rectangles.length; ++i) {
      xs[i][0] = rectangles[i][0];
      xs[i][1] = rectangles[i][2];
      ys[i][0] = rectangles[i][1];
      ys[i][1] = rectangles[i][3];
    }

    return Math.max(countMerged(xs), countMerged(ys)) >= 3;
  }

  private int countMerged(int[][] intervals) {
    int count = 0;
    int prevEnd = 0;

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    for (int[] interval : intervals) {
      final int start = interval[0];
      final int end = interval[1];
      if (start < prevEnd) {
        prevEnd = Math.max(prevEnd, end);
      } else {
        prevEnd = end;
        ++count;
      }
    }

    return count;
  }

    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}};
        
        Question3394 question = new Question3394();
        boolean result = question.checkValidCuts(n, rectangles);
        System.out.println("Valid cuts: " + result);
    }
}
