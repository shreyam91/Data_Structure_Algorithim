// Question: Maximize the Number of Target Nodes After Connecting Trees II 

// Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]

// Output: [8,7,7,8,8]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question3373{
    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int bfs(int start, List<List<Integer>> adj, boolean[] included) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        int count = 0;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            
            if (level % 2 == 0)
                count += size;

            while (size-- > 0) {
                Pair currPair = q.poll();
                int curr = currPair.first;
                int parent = currPair.second;
                if (included != null && level % 2 == 0) {
                    
                    included[curr] = true;
                }
                for (int v : adj.get(curr)) {
                    if (v == parent) continue;
                    q.add(new Pair(v, curr));
                }
            }
            ++level;
        }
        return count;
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();

        for (int i = 0; i <= n1; i++) {
            adj1.add(new ArrayList<>());
        }
        for (int i = 0; i <= n2; i++) {
            adj2.add(new ArrayList<>());
        }

        for (int[] edge : edges1) {
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }
        for (int[] edge : edges2) {
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

        
        int even_count2 = bfs(0, adj2, null);            
        int odd_count2 = n2 - even_count2;                
        int best2 = Math.max(even_count2, odd_count2);

        
        boolean[] included = new boolean[n1];
        int even_count1 = bfs(0, adj1, included);

        int[] ans = new int[n1];
        for (int i = 0; i < n1; ++i) {
            if (included[i]) {
                
                ans[i] = even_count1 + best2;
            } else {
                
                ans[i] = (n1 - even_count1) + best2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int [][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};

        System.out.println(Arrays.toString(maxTargetNodes(edges1, edges2)));
    }
}