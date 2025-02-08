// Question: Mirror Tree.. 
// Given a binary tree, convert the binary tree to its Mirror tree.
// Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.     

// Examples:
// Input: root[] = [1, 2, 3, N, N, 4]
// Output: [1, 3, 2, N, 4]

package Shreyam.gfg;

public class MirrorTree {
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
    static void mirror(Node node) {
        solve(node);
            }
    static Node solve(Node node){
        if(node == null){
            return null;
        }
        Node mirroredLeft = solve(node.left);
        Node mirroredRight = solve(node.right);
        node.left = mirroredRight;
        node.right = mirroredLeft;
        return node;
    }

    static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Original tree (Inorder):");
        inorder(root);
        System.out.println();

        mirror(root);

        System.out.println("Mirrored tree (Inorder):");
        inorder(root);
        System.out.println();
    }
}
