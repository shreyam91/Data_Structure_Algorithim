// Question: Fixing Two nodes of a BST... 
// Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
// Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original linked list.
 
// Examples :
// Input: root = [10, 5, 8, 2, 20]
// Output: 1

package shreyam.gfg;

public class FixingTwoNodesOfBST {
    static class Node {
        int data;
        Node left;
        Node right;    
    }

    static Node first;
    static Node middle;
    static Node last;
    static Node prev;

    private void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.data > root.data) {
            if (first == null) {
                first = prev;
                middle = root; 
            } else {
                last = root; 
            }
        }
        prev = root; 

        inorder(root.right);
    }
    void correctBST(Node root) {
         first = middle = last = null;
        inorder(root);

        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }
}