// Question: K Sum Paths.... 
// Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).

// Input: k =7
// Output: 3

package shreyam.gfg;

import java.util.HashMap;
import java.util.Map;

public class KSumPaths {
   public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public int sumK(Node root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return get(root,map,0,k);
    }

    private int get(Node root, Map<Integer,Integer>map ,int sum,int k){
        if(root == null) return 0;
        sum += root.data;
        int ans =0;

        if(map.containsKey(sum-k)){
            ans += map.get(sum-k);
        }

        map.put(sum, map.getOrDefault(sum,0) +1);
        ans += get(root.left,map,sum,k);
        ans += get(root.right,map,sum,k);
        map.put(sum, map.get(sum)-1);

        return ans;
    }
    public static void main(String[] args) {
        KSumPaths tree = new KSumPaths();
        
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.right.right = new Node(11);

        int k = 7; // Example input for k
        System.out.println("Number of paths with sum " + k + ": " + tree.sumK(root, k));
    }
}
