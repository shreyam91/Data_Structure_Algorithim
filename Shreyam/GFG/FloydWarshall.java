// Question: Floyd Warshall... 
// You are given an weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n, where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
// The graph may contain negative edge weights, but it does not contain any negative weight cycles.
// Your task is to find the shortest distance between every pair of nodes i and j in the graph.
// Note: Modify the distances for every pair in place.

// Examples :
// Input: dist[][] = [[0, 4, 108, 5, 108], [108, 0, 1, 108, 6], [2, 108, 0, 3, 108], [108, 108, 1, 0, 2], [1, 108, 108, 4, 0]]
// Output: [[0, 4, 5, 5, 7], [3, 0, 1, 4, 6], [2, 6, 0, 3, 5], [3, 7, 1, 0, 2], [1, 5, 5, 4, 0]]


package shreyam.gfg;

public class FloydWarshall {
    public void floydWarshall(int[][] dist) {
        int V = dist.length;

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != 100000000 && dist[k][j] != 100000000 &&
                        dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    // Utility method to print the matrix
    public void printSolution(int[][] dist) {
        int V = dist.length;
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == 100000000)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] dist = {
            {0, 4, 100000000, 5, 100000000},
            {100000000, 0, 1, 100000000, 6},
            {2, 100000000, 0, 3, 100000000},
            {100000000, 100000000, 1, 0, 2},
            {1, 100000000, 100000000, 4, 0}
        };

        FloydWarshall fw = new FloydWarshall();
        fw.floydWarshall(dist);
        System.out.println("Shortest distances between every pair of vertices:");
        fw.printSolution(dist);
    }
}
