// Question: Dijkstra Algorithm... 
// Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
// You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.
// Note: The Graph is connected and doesn't contain any negative weight edge.

// Examples:
// Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
// Output: [4, 3, 0]

package shreyam.gfg;

import java.util.*;

public class DijkstraAlgorithm {
    static int ans = 0;

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) left[i] = arr[low + i];
        for (int i = 0; i < n2; i++) right[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                ans += (n1 - i); 
            }
        }

        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static int inversionCount(int[] arr) {
        ans = 0;
        mergeSort(arr, 0, arr.length - 1);
        return ans;
    }

    static class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt)); 
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.dist;
                if (d + weight < dist[v]) {
                    dist[v] = d + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        int src = 2;

        int[] distances = dijkstra(V, edges, src);
        System.out.println("Shortest distances from source node " + src + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + " = " + distances[i]);
        }

        int[] testArr = {2, 4, 1, 3, 5};
        int invCount = inversionCount(testArr);
        System.out.println("Inversion count of the array: " + invCount);
    }
}
