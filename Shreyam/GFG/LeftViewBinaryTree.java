// Question: Left View of Binary Tree.. 

// You are given the root of a binary tree. Your task is to return the left view of the binary tree. The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.
// If the tree is empty, return an empty list.

// Examples :
// Input: root[] = [1, 2, 3, 4, 5, N, N]
// Output: [1, 2, 4]

package shreyam.gfg;

import java.util.ArrayList;

public class LeftViewBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int max_level = 0;

    static void leftViewUtil(ArrayList<Integer> result, Node root, int level) {
        if (root == null) return;

        if (max_level < level) {
            result.add(root.data);
            max_level = level;
        }

        leftViewUtil(result, root.left, level + 1);
        leftViewUtil(result, root.right, level + 1);
    }

    static ArrayList<Integer> leftView(Node root) {
        max_level = 0; // reset before use
        ArrayList<Integer> result = new ArrayList<>();
        leftViewUtil(result, root, 1);
        return result;
    }

    public static void main(String[] args) {
        // Manually construct the binary tree [1, 2, 3, 4, 5, N, N]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> leftViewResult = leftView(root);
        System.out.println("Left View of Binary Tree: " + leftViewResult);
    }
}
