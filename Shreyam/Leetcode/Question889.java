// Question: Construct Binary Tree from Preorder and Postorder Traversal
// Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

// If there exist multiple answers, you can return any of them.
// Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
// Output: [1,2,3,4,5,6,7]

package shreyam.leetCode;


public class Question889 {
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    private static int preIdx = 0;
    private static int postIdx = 0;

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode curr = new TreeNode(preorder[preIdx]);
        preIdx++;

        if (curr.val != postorder[postIdx]) {
            curr.left = constructFromPrePost(preorder, postorder);
        }
        if (curr.val != postorder[postIdx]) {
            curr.right = constructFromPrePost(preorder, postorder);
        }

        postIdx++;
        return curr;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // Visit left subtree, print root, and visit right subtree
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = constructFromPrePost(preorder, postorder);

    }
}
