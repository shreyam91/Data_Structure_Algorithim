// Question: Is Binary Tree Heap... 
// You are given a binary tree, and the task is to determine whether it satisfies the properties of a max-heap.
// A binary tree is considered a max-heap if it satisfies the following conditions:
// Completeness: Every level of the tree, except possibly the last, is completely filled, and all nodes are as far left as possible.
// Max-Heap Property: The value of each node is greater than or equal to the values of its children.
// Examples:

// Input: root[] = [97, 46, 37, 12, 3, 7, 31, 6, 9]

// Output: true


package shreyam.gfg;



public class IsBinaryTreeHeap {

    // Static nested class so we can instantiate nodes from static context
    public static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // Count total number of nodes
    int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Check if binary tree is complete and follows max-heap property
    boolean isHeapUtil(Node root, int index, int totalNodes) {
        if (root == null) return true;

        // Check completeness: index should be less than totalNodes
        if (index >= totalNodes) return false;

        // Check heap property (max-heap)
        if (root.left != null && root.data < root.left.data) return false;
        if (root.right != null && root.data < root.right.data) return false;

        // Recursively check left and right subtrees
        return isHeapUtil(root.left, 2 * index + 1, totalNodes) &&
               isHeapUtil(root.right, 2 * index + 2, totalNodes);
    }

    // Entry method to check if the tree is a heap
    public boolean isHeap(Node tree) {
        int totalNodes = countNodes(tree);
        return isHeapUtil(tree, 0, totalNodes);
    }

    // Main method with a sample tree
    public static void main(String[] args) {
        // Creating the tree manually
        Node root = new Node(97);
        root.left = new Node(46);
        root.right = new Node(37);
        root.left.left = new Node(12);
        root.left.right = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(31);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(9);

        IsBinaryTreeHeap obj = new IsBinaryTreeHeap();
        System.out.println("Is the binary tree a heap? " + obj.isHeap(root));
    }
}

