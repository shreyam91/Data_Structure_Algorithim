// Question: Maximum sum of Non-adjacent nodes... 
// Given a binary tree with a value associated with each node. Your task is to select a subset of nodes such that the sum of their values is maximized, with the condition that no two selected nodes are directly connected that is, if a node is included in the subset, neither its parent nor its children can be included.

// Examples:
// Input: root[] = [11, 1, 2]
// Output: 11

package shreyam.gfg;

class Node {
    int data;
    Node left, right;

    public Node(int data) {  // Ensure this constructor is public
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MaximumSumNonadjacentNodes {
    public int[] dfs(Node root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int include = root.data + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{include, exclude};
    }

    public int getMaxSum(Node root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(1);
        root.right = new Node(2);

        MaximumSumNonadjacentNodes sol = new MaximumSumNonadjacentNodes();
        System.out.println("Maximum sum of non-adjacent nodes: " + sol.getMaxSum(root));
    }
}
