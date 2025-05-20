// Question: Burning Tree 
// Given a binary tree and a target node, determine the minimum time required to burn the entire tree if the target node is set on fire. In one second, the fire spreads from a node to its left child, right child, and parent.
// Note: The tree contains unique values.

// Examples : 
// Input: root[] = [1, 2, 3, 4, 5, 6, 7], target = 2
// Output: 3

package shreyam.gfg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BurningTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

     static int minTime(Node root, int target) {
        Queue<Node> que = new LinkedList<>();
        Map<Node, Node> parent = new HashMap<>();
        Node tar = null;

        que.offer(root);
        parent.put(root, null);

        // Step 1: Map all parents and find target node
        while (!que.isEmpty()) {
            Node curr = que.poll();
            if (curr.data == target) {
                tar = curr;
            }

            if (curr.left != null) {
                que.offer(curr.left);
                parent.put(curr.left, curr);
            }

            if (curr.right != null) {
                que.offer(curr.right);
                parent.put(curr.right, curr);
            }
        }

        // Step 2: Burn the tree
        Map<Node, Boolean> visited = new HashMap<>();
        que.offer(tar);
        visited.put(tar, true);

        int time = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            boolean burned = false;

            while (size-- > 0) {
                Node curr = que.poll();

                if (curr.left != null && !visited.containsKey(curr.left)) {
                    que.offer(curr.left);
                    visited.put(curr.left, true);
                    burned = true;
                }

                if (curr.right != null && !visited.containsKey(curr.right)) {
                    que.offer(curr.right);
                    visited.put(curr.right, true);
                    burned = true;
                }

                Node par = parent.get(curr);
                if (par != null && !visited.containsKey(par)) {
                    que.offer(par);
                    visited.put(par, true);
                    burned = true;
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;
    }

    // Helper to build the binary tree from array (level-order)
     static Node buildTree(int[] arr) {
        if (arr.length == 0) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node curr = queue.poll();

            if (i < arr.length) {
                curr.left = new Node(arr[i++]);
                queue.offer(curr.left);
            }

            if (i < arr.length) {
                curr.right = new Node(arr[i++]);
                queue.offer(curr.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 2;

        Node root = buildTree(arr);
        int timeToBurn = minTime(root, target);
        System.out.println("Minimum time to burn the tree from node " + target + " is: " + timeToBurn);
    }
}
