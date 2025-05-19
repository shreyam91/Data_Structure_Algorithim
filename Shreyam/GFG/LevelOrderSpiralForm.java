// Question: Level Order in spiral form 
// Given a binary tree and the task is to find the spiral order traversal of the tree and return the list containing the elements.
// Spiral order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and for all the odd levels we print the node's value from left to right.
// For below tree, function should return [1, 2, 3, 4, 5, 6, 7]

// Examples:
// Input: root = [1, 3, 2]
// Output: [1, 3, 2]

package shreyam.gfg;

import java.util.*;

public class LevelOrderSpiralForm {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

     static ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> que = new LinkedList<>();
        que.add(root);

        boolean direction = false;

        while (!que.isEmpty()) {
            int n = que.size();
            Integer[] row = new Integer[n];

            for (int i = 0; i < n; i++) {
                Node node = que.poll();

                int idx = direction ? i : (n - 1 - i);
                row[idx] = node.data;

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }

            Collections.addAll(result, row);

            direction = !direction;
        }

        return result;
    }

    // Utility to build tree from level-order input array
     static Node buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2};  
        Node root = buildTree(arr);

        ArrayList<Integer> spiralOrder = findSpiral(root);
        System.out.println(spiralOrder);  
    }
}
