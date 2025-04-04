// Question: Lowest Common Ancestor of Deepest Leaves... 
// Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.
// Recall that:
// The node of a binary tree is a leaf if and only if it has no children
// The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
// The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.
 
// Example 1:
// Input: root = [3,5,1,6,2,0,8,null,null,7,4]
// Output: [2,7,4]

package shreyam.leetCode;

public class Question1123 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    private Pair findLCA(TreeNode curr) {
        if (curr == null) {
            return new Pair(null, 0);
        }

        Pair left = findLCA(curr.left);
        Pair right = findLCA(curr.right);

        if (left.depth == right.depth) {
            return new Pair(curr, 1 + left.depth);
        } else if (left.depth > right.depth) {
            return new Pair(left.node, 1 + left.depth);
        } else {
            return new Pair(right.node, 1 + right.depth);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair res = findLCA(root);
        return res.node;
    }

    public static void main(String[] args) {
        // Manually create the tree:
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode root = new TreeNode(3, node5, node1);

        // Create an instance of the class and test the LCA method
        Question1123 solution = new Question1123();
        TreeNode lca = solution.lcaDeepestLeaves(root);
        System.out.println("LCA of deepest leaves: " + lca.val); // Expected output: 2
    }
}

