// Question: Maximum path sum from any node... 
// Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

// Examples:
// Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
// Output: 42

package shreyam.gfg;

public class MaximumPathSumFromAnyNode {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    static int max = Integer.MIN_VALUE;
       static int path(Node root){
            if(root == null) return 0;
            int l = Math.max(0, path(root.left));
            int r = Math.max(0,path(root.right));
    
            max = Math.max(max, root.data + l + r);
            return root.data + Math.max(l,r);
        }
    
        static int findMaxSum(Node node) {
            path(node);
            return max;
    }

    static Node buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        Node root = new Node(arr[0]);
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Left child
            if (arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        Integer[] arr = {10, 2, 10, 20, 1, null, -25, null, null, null, null, 3, 4};
        Node root = buildTree(arr);
        int result = findMaxSum(root);
        System.out.println("Maximum path sum: " + result);
    }
}
