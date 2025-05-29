// Question: Sum of nodes on the longest path

// Given a binary tree root[], you need to find the sum of the nodes on the longest path from the root to any leaf node. If two or more paths have the same length, the path with the maximum sum of node values should be considered.

// Examples:
// Input: root[] = [4, 2, 5, 7, 1, 2, 3, N, N, 6, N]
// Output: 13


package shreyam.gfg;

public class SumNodesTheLongestPath {

   static class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
    static int maxLen = 0; 
    static int maxSum = 0; 

    static void dfs(Node node, int currLen, int currSum) {
        if (node == null) {
            return; 
        }

        currLen += 1;             
        currSum += node.data;     

        
        if (node.left == null && node.right == null) {
            if (currLen > maxLen) {
                maxLen = currLen;
                maxSum = currSum;
            } else if (currLen == maxLen && currSum > maxSum) {
                maxSum = currSum;
            }
            return;
        }

        
        dfs(node.left, currLen, currSum);
        dfs(node.right, currLen, currSum);
    }

    public static int sumOfLongRootToLeafPath(Node root) {
        dfs(root, 0, 0);  
        return maxSum;    
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        root.right.left.left = new Node(6);

        int result = sumOfLongRootToLeafPath(root);
        System.out.println(result);
    }
}
