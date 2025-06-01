// Question: Closest Neighbour in BST

// Given the root of a binary search tree and a number k, find the greatest number in the binary search tree that is less than or equal to k.
// Examples:

// Input: root = [10, 7, 15, 2, 8, 11, 16], k = 14
// Output: 11

package shreyam.gfg;

public class ClosestNeighbourBST {
    
    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

     static int findMaxFork(Node root, int k) {
        int result = -1;

        while (root != null) {
            if (root.data <= k) {
                result = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return result;
    }

     static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {10, 7, 15, 2, 8, 11, 16};
        Node root = null;

        for (int val : values) {
            root = insert(root, val);
        }

        int k = 14;
        System.out.println(findMaxFork(root, k));  
    }
}
