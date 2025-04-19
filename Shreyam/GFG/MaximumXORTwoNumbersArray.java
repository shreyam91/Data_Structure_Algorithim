// Question: Maximum XOR of two numbers in an array... 
// Given an array arr[] of non-negative integers of size n. Find the maximum possible XOR between two numbers present in the array.

// Examples:
// Input: arr[] = [25, 10, 2, 8, 5, 3]
// Output: 28


package shreyam.gfg;

public class MaximumXORTwoNumbersArray {

    static class Node {
        Node zero;
        Node one;
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(int num) {
            Node temp = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0) {
                    if (temp.zero == null) {
                        temp.zero = new Node();
                    }
                    temp = temp.zero;
                } else {
                    if (temp.one == null) {
                        temp.one = new Node();
                    }
                    temp = temp.one;
                }
            }
        }

        public int findMax(int num) {
            Node temp = root;
            int maxXor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0) {
                    if (temp.one != null) {
                        maxXor |= (1 << i);
                        temp = temp.one;
                    } else {
                        temp = temp.zero;
                    }
                } else {
                    if (temp.zero != null) {
                        maxXor |= (1 << i);
                        temp = temp.zero;
                    } else {
                        temp = temp.one;
                    }
                }
            }
            return maxXor;
        }
    }

    public static int maxXor(int[] arr) {
        Trie trie = new Trie();
        int res = 0;

        trie.insert(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, trie.findMax(arr[i]));
            trie.insert(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {25, 10, 2, 8, 5, 3};
        int res = maxXor(arr);
        System.out.println("Maximum XOR of two numbers in the array: " + res);
    }
}
