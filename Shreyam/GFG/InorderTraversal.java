// Question: Inorder Traversal... 
// Given a Binary Tree, your task is to return its In-Order Traversal.
// An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).

// Examples:
// Input: root[] = [1, 2, 3, 4, 5] 
// Output: [4, 2, 5, 1, 3]
// Explanation: The in-order traversal of the given binary tree is [4, 2, 5, 1, 3].

package shreyam.gfg;

import java.util.ArrayList;

public class InorderTraversal {
   static class Node {
        int data;
        Node left, right;
       Node(int item)    {
            data = item;
            left = right = null;
        }
    }

    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
         solve(root, ans);
         return ans;
    }
    void solve(Node root, ArrayList<Integer> ans) {
        if(root == null)
            return;
        solve(root.left, ans);
        ans.add(root.data);
        solve(root.right, ans);
    }

    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    public static void main(String[] args) {
        InorderTraversal tree = new InorderTraversal();
        
        Node root = null;
        int[] values = {1, 2, 3, 4, 5};
        for (int value : values) {
            root = tree.insert(root, value);
        }

        ArrayList<Integer> result = tree.inOrder(root);
        
        System.out.println("In-order Traversal: " + result);

    }
}
