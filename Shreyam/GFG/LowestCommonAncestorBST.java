// Question: Lowest Common Ancestor in a BST... 
// Given a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2). You may assume that both nodes exist in the tree. Find the Lowest Common Ancestor (LCA) of the given two nodes in the BST.
// LCA between two nodes n1 and n2 is defined as the lowest node that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).

// Examples:
// Input: root = [5, 4, 6, 3, N, N, 7, N, N, N, 8], n1 = 7, n2 = 8
// Output: 7
package shreyam.gfg;

public class LowestCommonAncestorBST {
    static class Node
    {
        int data;
        Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
    }
    static Node LCA(Node root, Node n1, Node n2) {
        while(root != null){
        if(root.data >n1.data && root.data > n2.data) root = root.left;
        else if(root.data < n1.data && root.data < n2.data){
            root = root.right;
        }
        else 
            break;
    }
        return root;
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    public static void main(String[] args) {

        int[] nodes = {5, 4, 6, 3, 7, 8}; 

        Node root = null;
        for (int nodeValue : nodes) {
            root = insert(root, nodeValue);
        }

        Node n1 = new Node(7);
        Node n2 = new Node(8);

        Node lca = LCA(root, n1, n2);

        if (lca != null) {
            System.out.println("LCA of " + n1.data + " and " + n2.data + " is " + lca.data);
        } else {
            System.out.println("LCA not found.");
        }
    }
}