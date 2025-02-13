// Question: Pair Sum in BST... 
// Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

// Examples:
// Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
// Output: True
// Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.

package shreyam.gfg;

import java.util.ArrayList;

public class PairSumBST {
   static class Node {
        int data;
        Node left, right;
    
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static void inorderTraversal(Node root,ArrayList<Integer>ls){
        if(root == null) return;
        inorderTraversal(root.left, ls);
        ls.add(root.data);
        inorderTraversal(root.right, ls);
    }

    static boolean findTarget(Node root, int target) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int left = 0, right = inorder.size() - 1;
        while (left < right) {
            int currentSum = inorder.get(left) + inorder.get(right);
            if (currentSum == target) return true;
            if (currentSum < target) left++;
            else
                right--;
        }
        return false;
    }
    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.right.right = new Node(4);
        root.right.right.right = new Node(9);


        int k = 12;
        boolean result = findTarget(root, k);
        System.out.println(result);
    }
}