// Question: Serialize and deserialize a binary tree... 
// Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions serialize() : stores the tree into an array a and returns the array.
// deSerialize() : deserializes the array to the tree and returns the root of the tree.
// Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).

// Input: root = [1, 2, 3]
// Output: [2, 1, 3]

package shreyam.gfg;

import java.util.ArrayList;

public class SerializeDeserializeBinaryTree {
    static class Tree {
        int data;
        Tree left, right;

        Tree(int d) {
            data = d;
            left = right = null;
        }
    }

    static ArrayList<Integer> serialize(Tree root) {
        ArrayList<Integer> arr = new ArrayList<>();
        serialize(root, arr);
        return arr;
    }

    static void serialize(Tree root, ArrayList<Integer> arr) {
        if (root == null) {
            arr.add(-1); 
            return;
        }
        arr.add(root.data); 
        serialize(root.left, arr); 
        serialize(root.right, arr); 
    }

    static Tree deSerialize(ArrayList<Integer> arr) {
        int[] index = new int[1]; 
        return deSerialize(arr, index);
    }

    static Tree deSerialize(ArrayList<Integer> arr, int[] index) {
        if (arr.get(index[0]) == -1) {
            index[0]++; 
            return null;
        }

        Tree newNode = new Tree(arr.get(index[0]));
        index[0]++; 
        newNode.left = deSerialize(arr, index); 
        newNode.right = deSerialize(arr, index); 
        return newNode;
    }

    static void inorder(Tree root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        // Creating a simple binary tree
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);

        ArrayList<Integer> serialized = serialize(root);

        Tree deserializedRoot = deSerialize(serialized);

        System.out.print("In-order Traversal of Deserialized Tree: ");
        inorder(deserializedRoot);
    }
}
