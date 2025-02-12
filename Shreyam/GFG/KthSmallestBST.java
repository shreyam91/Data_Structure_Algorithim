// Question: k-th Smallest in BST... 
// Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.

// Examples:
// Input: root = [2, 1, 3], k = 2
// o/p: 2

package shreyam.gfg;

import java.util.ArrayList;

public class KthSmallestBST {
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

    static int kthSmallest(Node root, int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        inorder(root,ls);
        if(k > 0 && k <= ls.size()){
            return ls.get(k-1);
        }
        return -1;
    }

    static void inorder(Node root,ArrayList<Integer>ls){
        if(root == null){
            return;
        }
        inorder(root.left, ls);
        ls.add(root.data);
        inorder(root.right, ls);
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        int k = 5;
        int result = kthSmallest(root, k);
        System.out.println("The " + k + "smallest element is: " + result);
    }
}
