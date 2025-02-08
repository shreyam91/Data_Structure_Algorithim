// Question: Construct Tree from Inorder & Preorder... 
// Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.
// Note: The output is written in postorder traversal.

// Examples:
// Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
// Output: [8, 7, 6, 1]. 

package shreyam.gfg;

public class ConstructTreeFromInorderPreorder {
    public static class Node {
        int data;
        Node left, right;
    
        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    static int pos;
    
    public static Node buildTree(int inorder[], int preorder[]) {
        pos = 0;  
        return solve(inorder, preorder, 0, inorder.length - 1);
    }

    public static Node solve(int inorder[], int preorder[], int start, int end) {
        if (start > end) {
            return null;
        }

        Node root = new Node(preorder[pos]);
        pos++; 
        int div = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.data) {
                div = i;
                break;
            }
        }

        root.left = solve(inorder, preorder, start, div - 1);
        root.right = solve(inorder, preorder, div + 1, end);

        return root;
    }

    public static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] inorder = {1, 6, 8, 7};
        int[] preorder = {1, 6, 7, 8};

        Node root = buildTree(inorder, preorder);

        System.out.println("Inorder traversal of the constructed tree:");
        inorderTraversal(root);  
    }
}