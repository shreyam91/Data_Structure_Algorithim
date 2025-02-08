// Question:- Level order traversal... 

package shreyam.gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    
   public class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            while (size-- > 0) {
                Node tmp = q.poll();
                level.add(tmp.data);
                
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);
        root.right.left = tree.new Node(6);
        root.right.right = tree.new Node(7);

        ArrayList<ArrayList<Integer>> result = tree.levelOrder(root);
        
        for (ArrayList<Integer> level : result) {
            System.out.println(level);
        }
    }
}