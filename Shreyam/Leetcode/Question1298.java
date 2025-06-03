// Question: Maximum Candies You Can Get From Boxes

// You have n boxes labeled from 0 to n - 1. You are given four arrays: status, candies, keys, and containedBoxes where:
// status[i] is 1 if the ith box is open and 0 if the ith box is closed,
// candies[i] is the number of candies in the ith box,
// keys[i] is a list of the labels of the boxes you can open after opening the ith box.
// containedBoxes[i] is a list of the boxes you found inside the ith box.
// You are given an integer array initialBoxes that contains the labels of the boxes you initially have. You can take all the candies in any open box and you can use the keys in it to open new boxes and you also can use the boxes you find in it.
// Return the maximum number of candies you can get following the rules above.

// Example 1:
// Input: status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]
// Output: 16

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Question1298{
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < containedBoxes.length; i++) {
            graph.put(i, new ArrayList<>());
            for (int box : containedBoxes[i]) {
                graph.get(i).add(box);
            }
        }

        int n = candies.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] inQueue = new boolean[n];
        Set<Integer> pending = new HashSet<>();

        for (int box : initialBoxes) {
            queue.offer(box);
            inQueue[box] = true;
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();

            if (status[box] == 0) {
                pending.add(box);
                continue;
            }

            if (visited[box]) continue;
            visited[box] = true;
            totalCandies += candies[box];

            for (int key : keys[box]) {
                status[key] = 1;
                if (pending.contains(key)) {
                    queue.offer(key);
                    pending.remove(key);
                }
            }

            for (int neighbor : graph.getOrDefault(box, new ArrayList<>())) {
                if (!inQueue[neighbor]) {
                    queue.offer(neighbor);
                    inQueue[neighbor] = true;
                }
            }
        }

        return totalCandies;
    }
    public static void main(String[] args) {
        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = { {}, {}, {1}, {} };
        int[][] containedBoxes = { {1, 2}, {3}, {}, {} };
        int[] initialBoxes = {0};

        Question1298 q = new Question1298();
        int result = q.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
        System.out.println("Maximum Candies Collected: " + result);


    }
}