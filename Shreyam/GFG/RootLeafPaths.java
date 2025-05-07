// Question: Root to Leaf Paths

// Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.
// Note: The paths should be returned such that paths from the left subtree of any node are listed first, followed by paths from the right subtree.

// Examples:
// Input: root[] = [1, 2, 3, 4, 5, N, N]
// Output: [[1, 2, 4], [1, 2, 5], [1, 3]]

package shreyam.gfg;

import java.util.ArrayList;

public class RootLeafPaths{
    static class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public static ArrayList<ArrayList<Integer>> Paths(Node root) {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    
    ArrayList<Integer> currentPath = new ArrayList<>();
    
    findPaths(root, currentPath, paths);
    
    return paths;
}

private static void findPaths(Node node, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> paths) {
    if (node == null) {
        return;
    }
    
    currentPath.add(node.data);
    
    if (node.left == null && node.right == null) {
        paths.add(new ArrayList<>(currentPath));
    } else {
        findPaths(node.left, currentPath, paths);
        findPaths(node.right, currentPath, paths);
    }
    
    currentPath.remove(currentPath.size() - 1);
}
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        ArrayList<ArrayList<Integer>> result = Paths(root);
        
        System.out.println(result);
    }
}