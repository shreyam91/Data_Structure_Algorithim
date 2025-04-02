// Question: BFS of graph... 
// Given a connected undirected graph represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.
// Note: Do traverse in the same order as they are in the given adjacency list.

// Examples:

// Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
// Output: [0, 2, 3, 1, 4]

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for (int neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        adj.add(new ArrayList<>(Arrays.asList(1, 2, 3))); 
        adj.add(new ArrayList<>(Arrays.asList(0)));       
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));    
        adj.add(new ArrayList<>(Arrays.asList(0)));       
        adj.add(new ArrayList<>(Arrays.asList(2)));       

        ArrayList<Integer> result = bfs(adj);
        
        System.out.println(result);

    }
}




// public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int V) {
//     ArrayList<Integer> list = new ArrayList<>();
//     int arr[] = new int[V+1];
//     Queue<Integer> q = new LinkedList<>();
//     arr[0] = 1;
//     q.add(0);
    
//     while(!q.isEmpty()){
//         int x = q.peek();
//         q.remove();
//         list.add(x);
        
//         for(int i=0; i<adj.get(x).size(); i++){
//             if(arr[adj.get(x).get(i)]==0){
//                 arr[adj.get(x).get(i)]=1;
//                 q.add(adj.get(x).get(i));
//             }
//         }
//     }
    
//     return list;
    
// }