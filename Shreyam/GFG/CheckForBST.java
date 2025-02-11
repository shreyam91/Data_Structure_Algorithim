// Question: Check for BST... 
// Given the root of a binary tree. Check whether it is a BST or not.
// Note: We are considering that BSTs can not contain duplicate Nodes.
// A BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key. The right subtree of a node contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary search trees.

// Input: root = [2, 1, 3, N, N, N, 5]
// Output: true

package shreyam.gfg;

import java.util.ArrayList;
import java.util.List;

public class CheckForBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    void inorder(Node root,List<Integer>h){
        if(root == null){
            return ;
        }
        inorder(root.left, h);
        h.add(root.data);
        inorder(root.right,h);
    }

    boolean isBST(Node root){
        List<Integer> h = new ArrayList<>();
        inorder(root, h);
        for(int i=1;i<h.size();i++){
            if(h.get(i) <= h.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // int[] root = [2, 1, 3, null, null, null, 5];
        CheckForBST tree = new CheckForBST();
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(6);
        root.right = new Node(9);

        // Checking if the tree is a BST
        System.out.println("Is the tree a BST? " + tree.isBST(root));
    }
    
}
