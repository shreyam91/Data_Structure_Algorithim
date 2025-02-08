// Question: Find the number of Distinct Colors Among the Balls... 
// You are given an integer limit and a 2D array queries of size n x 2.
// There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are uncolored. For every query in queries that is of the form [x, y], you mark ball x with the color y. After each query, you need to find the number of distinct colors among the balls.
// Return an array result of length n, where result[i] denotes the number of distinct colors after ith query.
// Note that when answering a query, lack of a color will not be considered as a color.

// Example 1:
// Input: limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]
// Output: [1,2,2,3]. 

package Shreyam.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question3160 {
    public static List<Integer> queryResults(int limit, int[][] queries) {
        int n = queries.length;
        Map<Integer,Integer> colorFreq = new HashMap<>();
        Map<Integer,Integer> ballColor = new HashMap<>();
            List<Integer> res = new ArrayList<>();

            for(int i=0;i<n;i++){
                int ball = queries[i][0];
                int color = queries[i][1];

                if(ballColor.containsKey(ball)){
                    int prevColor = ballColor.get(ball);
                    colorFreq.put(prevColor,colorFreq.get(prevColor) -1);
                    if(colorFreq.get(prevColor) == 0){
                        colorFreq.remove(prevColor);
                    }
                }
                ballColor.put(ball, color);
                colorFreq.put(color, colorFreq.getOrDefault(color, 0) +1);
                res.add(colorFreq.size());
            }
            return res;
    }
    public static void main(String[] args) {
        int limit = 4;
        int[][] queries ={{1,4},{2,5},{1,3},{3,4}}; 
        List<Integer> result = queryResults(limit, queries);
        System.out.println(result);
    }
}
