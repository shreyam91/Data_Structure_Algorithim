// Question: Smallest range in K lists
// Given a 2d integer array arr[][] of size k*n, where each row is sorted in ascending order. Your task is to find the smallest range [l, r] that includes at least one element from each of the k lists. If more than one such ranges are found, return the first one.

// Examples:

// Input: n = 5, k = 3, arr[][] = [[4, 7, 9, 12, 15], [0, 8, 10, 14, 20], [6, 12, 16, 30, 50]]
// Output: [6, 8]

package shreyam.gfg;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SmallestRangeKLists {
    static class Node {
        int val, row, col;
        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public static ArrayList<Integer> findSmallestRange(int[][] arr) {
        int n = arr.length;    
        int m = arr[0].length; 

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b)->a.val - b.val);

        int maxVal   = Integer.MIN_VALUE;
        int maxEl    = -1;
        int minEl    = -1;
        int minRange = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minHeap.add(new Node(arr[i][0], i, 0));
            maxVal = Math.max(maxVal, arr[i][0]);
        }

        while (true) {
            Node top    = minHeap.poll(); 
            int  minVal = top.val;
            int  row    = top.row;
            int  col    = top.col;

            if (maxVal - minVal < minRange) {
                minRange = maxVal - minVal;
                minEl    = minVal;
                maxEl    = maxVal;
            }

            if (col + 1 == m) {
                break;
            }

            int nextVal = arr[row][col + 1];
            minHeap.add(new Node(nextVal, row, col + 1));

            maxVal = Math.max(maxVal, nextVal);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minEl);
        result.add(maxEl);
        return result;
    }
    public static void main(String[] args) {
        int n = 5, k = 3;
        int arr[][] = {{4, 7, 9, 12, 15}, {0, 8, 10, 14, 20}, {6, 12, 16, 30, 50}};

        System.out.println(findSmallestRange(arr));
    }
}
