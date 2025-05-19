// Question: Predecessor and Successor

// You are given root node of the BST and an integer key. You need to find the in-order successor and predecessor of the given key. If either predecessor or successor is not found, then set it to NULL.
// Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 

// Examples :
// Input: root[] = [8, 1, 9, N, 4, N, 10, 3, N, N, N], key = 8
// Output: 4 9


package shreyam.gfg;

import java.util.ArrayList;

public class PredecessorAndSuccessor {
    static class Node {
        int data;
        Node left, right;
        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    private void inorder(Node root, ArrayList<Node> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);          
        result.add(root);                     
        inorder(root.right, result);          
    }

     ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> result = new ArrayList<>(); 
        inorder(root, result);                      

        Node pre = null;                            
        Node suc = null;                            

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).data < key) {
                pre = result.get(i);                
            } else if (result.get(i).data > key) {
                suc = result.get(i);                
                break;
            } else {
                if (i - 1 >= 0) {
                    pre = result.get(i - 1);        
                }
                if (i + 1 < result.size()) {
                    suc = result.get(i + 1);        
                }
                break;                              
            }
        }

        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre);                               
        ans.add(suc);                               
        return ans;                                 
    }

    // ✅ Moved outside of findPreSuc
    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        PredecessorAndSuccessor tree = new PredecessorAndSuccessor();
        int[] keys = {8, 1, 9, 4, 10, 3}; // Sample BST input
        Node root = null;

        for (int key : keys) {
            root = tree.insert(root, key);
        }

        int keyToSearch = 8;
        ArrayList<Node> result = tree.findPreSuc(root, keyToSearch);

        Node pre = result.get(0);
        Node suc = result.get(1);

        System.out.println("Predecessor: " + (pre != null ? pre.data : "None"));
        System.out.println("Successor: " + (suc != null ? suc.data : "None"));
    }
}
