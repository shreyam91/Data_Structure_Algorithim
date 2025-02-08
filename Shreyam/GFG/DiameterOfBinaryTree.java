// Question: Diameter of a Binary Tree... 
// Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.

// Examples:
// Input: root[] = [1, 2, 3]
// Output: 2
// Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).

package Shreyam.gfg;

public class DiameterOfBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Solution {
        int ans = 0;  

        int diameter(Node root) {
            calc(root);  
            return ans;  
        }

        int calc(Node root) {
            if (root == null) {
                return 0;  
            }

            int leftHeight = calc(root.left);  
            int rightHeight = calc(root.right);  

            ans = Math.max(ans, leftHeight + rightHeight);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        Solution solution = new Solution();
        System.out.println("Diameter of the tree: " + solution.diameter(root));
    }
}
