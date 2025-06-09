// Question: BST with Dead End 

// You are given a Binary Search Tree (BST) containing unique positive integers greater than 0.
// Your task is to determine whether the BST contains a dead end.
// Note: A dead end is a leaf node in the BST such that no new node can be inserted in the BST at or below this node while maintaining the BST property and the constraint that all node values must be > 0.

// Examples:
// Input: root[] = [8, 5, 9, 2, 7, N, N, 1]
// Output: true

package shreyam.gfg;

public class BSTWithDeadEnd {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public boolean isDeadEnd(Node root) {
        return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }

    static boolean checkDeadEnd(Node root, int min, int max) {
        if (root == null) {
            return false;
        }
        if (min == max) {
            return true;
        }
        return checkDeadEnd(root.left, min, root.data - 1) ||
               checkDeadEnd(root.right, root.data + 1, max);
    }

    // Helper method to insert a node in BST
    static Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insert(root.left, key);
        else root.right = insert(root.right, key);
        return root;
    }

    public static void main(String[] args) {
        BSTWithDeadEnd tree = new BSTWithDeadEnd();
        int[] values = {8, 5, 9, 2, 7, 1};

        Node root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        if (tree.isDeadEnd(root))
            System.out.println("The BST contains a dead end.");
        else
            System.out.println("The BST does NOT contain a dead end.");
    }
}
