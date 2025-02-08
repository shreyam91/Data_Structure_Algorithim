// Question: Construct Tree from Inorder & Preorder... 
// Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.
// Note: The output is written in postorder traversal.

// Examples:
// Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
// Output: [8, 7, 6, 1]. 

package shreyam.gfg;

public class ConstructTreeFromInorderPreorder {
    static class Node {
        int data;
        Node left, right;
    
        Node(int key) {
            data = key;
            left = right = null;
        }
    }
    static int pos;
    public static Node buildTree(int inorder[], int preorder[]) {
        pos =0;
        return solve(inorder,preorder,0,inorder.length-1);
    }

    static Node solve(int inorder[],int preorder[], int str,int end){
        if(str>inorder.length || str>end){
            return null;
        }
        Node root = new Node(preorder[pos]);
        int div =0;

        for(int i=str;i<=end;i++){
            if(preorder[pos] == inorder[i]){
                div = i;
                break;
            }
        }
        pos++;
        root.left = solve(inorder,preorder,str,div-1);
        root.right = solve(inorder,preorder,div+1,end);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {1,6,8,7};
        int[] preorder = {1,6,7,8};

        Node root = buildTree(inorder, preorder);

    }
}
