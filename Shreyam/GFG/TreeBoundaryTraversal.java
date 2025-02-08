// Question: Tree Boundary Traversal... 
// Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 
// Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.
// Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.
// Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.
// Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

// Examples:
// Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
// Output: [1, 2, 4, 8, 9, 6, 7, 3]

package shreyam.gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeBoundaryTraversal {
    static class Node
    {
        int data;
        Node left, right;

    public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList();
        if(node.left!=null || node.right!=null){
            ans.add(node.data);
        }
        leftNodes(node.left, ans);
        addLeaves(node, ans);
        rightRevNodes(node.right, ans);
        return ans;
    }
    void leftNodes(Node node, ArrayList<Integer> ans){
        if(node == null)
            return;
        if(node.left!=null){
            ans.add(node.data);
            leftNodes(node.left, ans);
        } else if(node.right!=null){
             ans.add(node.data);
            leftNodes(node.right, ans);
        }
    }
    void addLeaves(Node node, ArrayList<Integer> ans){
        if(node == null)
            return;
        addLeaves(node.left, ans);
        if(node.left==null && node.right == null){
             ans.add(node.data);
        }
         addLeaves(node.right, ans);
    }
    void rightRevNodes(Node node, ArrayList<Integer> ans){
        if(node == null)
            return;
        if(node.right!=null){
            
            rightRevNodes(node.right, ans);
            ans.add(node.data);
        } else if(node.left!=null){
            rightRevNodes(node.left, ans);
            ans.add(node.data);
        }
    }

    Node buildTree(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            if (arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeBoundaryTraversal tree = new TreeBoundaryTraversal();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, -1, -1, 8, 9, -1, -1, -1, -1};
        Node root = tree.buildTree(arr);
        ArrayList<Integer> boundary = tree.boundaryTraversal(root);        
        System.out.println(boundary);
    }
    
}
