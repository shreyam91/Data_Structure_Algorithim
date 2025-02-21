// Question: Find elements in Contaminated Binary Tree... 
// Input
// ["FindElements","find","find"]
// [[[-1,null,-1]],[1],[2]]
// Output
// [null,false,true]

package shreyam.leetCode;

import java.util.HashSet;
import java.util.Set;

public class Question1261 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;


        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static Set<Integer> nodeValues = new HashSet<>();

    public static void FindElements(TreeNode root) {
        if (root != null) {
            root.val = 0;
            nodeValues.add(0);
            recoveryBinaryTree(root.left, 1);
            recoveryBinaryTree(root.right, 2);
        }
    }

    private static void recoveryBinaryTree(TreeNode curr, int val) {
        if (curr == null) return;
        curr.val = val;
        nodeValues.add(val);
        recoveryBinaryTree(curr.left, 2 * val + 1);
        recoveryBinaryTree(curr.right, 2 * val + 2);
    }

    public static boolean find(int target) {
        return nodeValues.contains(target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);

        FindElements(root);

        System.out.println(find(1));  
        System.out.println(find(2));  
        System.out.println(find(5));  
    }
}