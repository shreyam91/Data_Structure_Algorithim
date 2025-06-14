// Question: Symmetric Tree

// Given the root of a binary tree, check whether it is symmetric, i.e., whether the tree is a mirror image of itself.
// A binary tree is symmetric if the left subtree is a mirror reflection of the right subtree.

// Examples:
// Input: root[] = [1, 2, 2, 3, 4, 4, 3]
// Output: True

package shreyam.gfg; 

public class SymmetricTree {

    // Node definition
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Check if tree is symmetric
    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    // Helper function to check mirror symmetry
    static boolean isMirror(Node l, Node r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.data != r.data) return false;
        return isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }

    // Build the tree manually or from array
    public static void main(String[] args) {
        /*
            Constructing the following symmetric tree:
                     1
                   /   \
                  2     2
                 / \   / \
                3  4  4   3
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isSymmetric(root));  // Output: true
    }
}
