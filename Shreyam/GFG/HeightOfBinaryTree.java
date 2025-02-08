// Question: Height of Binary Tree... 
// Given a binary tree, find its height.
// The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. A leaf node is a node that does not have any children.

// Input: root[] = [12, 8, 18, 5, 11] 
// Output: 2
// Explanation: One of the longest path from the root (node 12) goes through node 8 to node 5, which has 2 edges.

package Shreyam.gfg;

public class HeightOfBinaryTree {
    static class Node
    {
    int data;
    Node left, right;

    Node(int item)
        {
        data = item;
        left = right = null;
        }
    }
    int height(Node node) {
        if(node == null){
            return -1;
        }

        return Math.max(height(node.left), height(node.right))+1;
    }

    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }
    public static void main(String[] args) {
        HeightOfBinaryTree tree = new HeightOfBinaryTree();
        Node root = null;

        int arr[] = {12,8,18,5,11};
        for (int i = 0; i < arr.length; i++) {
            root = tree.insert(root, arr[i]);
        }

        System.out.println("Height of the tree: " + tree.height(root));
    }
}
