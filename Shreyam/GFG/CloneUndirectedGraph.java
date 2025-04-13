// Question: Clone an Undirected Graph.... 
// Given a connected undirected graph represented by adjacency list, adjList[][] with n nodes, having a distinct label from 0 to n-1, where each adj[i] represents the list of vertices connected to vertex i.
// Create a clone of the graph, where each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.
// class Node {
//     val: integer
//     neighbors: List[Node]
// }
// Your task is to complete the function cloneGraph( ) which takes a starting node of the graph as input and returns the copy of the given node as a reference to the cloned graph.
// Note: If you return a correct copy of the given graph, then the driver code will print true; and if an incorrect copy is generated or when you return the original node, the driver code will print false.

// Examples :
// Input: n = 4, adjList[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
// Output: true



package shreyam.gfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneUndirectedGraph {
    class Node {
        int val;
        ArrayList<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    private HashMap<Node, Node> copies = new HashMap<>();

    Node cloneGraph(Node node) {
        if (node == null) return null;

        if (!copies.containsKey(node)) {
            Node clone = new Node(node.val);
            copies.put(node, clone);
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }

        return copies.get(node);
    }


    Node buildGraph(int[][] adjList) {
        if (adjList.length == 0) return null;

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < adjList.length; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < adjList.length; i++) {
            for (int neighborVal : adjList[i]) {
                nodes.get(i).neighbors.add(nodes.get(neighborVal));
            }
        }

        return nodes.get(0); 
    }

    public static void main(String[] args) {
        CloneUndirectedGraph solution = new CloneUndirectedGraph();
        int[][] adjList = {
            {1, 2},
            {0, 2},
            {0, 1, 3},
            {2}
        };

        Node originalGraph = solution.buildGraph(adjList);
        Node clonedGraph = solution.cloneGraph(originalGraph);

        System.out.println("Graph cloned successfully.");
    }
}
