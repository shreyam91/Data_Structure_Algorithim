// Question: Prime List... 
// You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number. If more than one prime number exists at an equal distance, choose the smallest one. Return the head of the modified linked list.

// Examples :
// Input: head = 2 → 6 → 10
// Output: 2 → 5 → 11

package shreyam.gfg;

import java.util.Arrays;

public class PrimeList {

    static class Node {
        Node next;
        int val;

        public Node(int data) {
            val = data;
            next = null;
        }
    }

    static Node primeList(Node head) {
        int max = Integer.MIN_VALUE;
        Node cur = head;

        // Find the maximum value in the list
        while (cur != null) {
            max = Math.max(cur.val, max);
            cur = cur.next;
        }

        // Generate prime numbers up to max + 100
        boolean[] prime = new boolean[max + 100];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }

        // Replace non-prime values with nearest prime
        cur = head;
        while (cur != null) {
            if (!prime[cur.val]) {
                int left = cur.val - 1;
                int right = cur.val + 1;
                while (true) {
                    if (left >= 2 && prime[left]) {
                        cur.val = left;
                        break;
                    }
                    if (right < prime.length && prime[right]) {
                        cur.val = right;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    // Utility method to print linked list
    static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create list: 2 → 6 → 10
        Node head = new Node(2);
        head.next = new Node(6);
        head.next.next = new Node(10);

        head = primeList(head);
        printList(head); // Output should be: 2 5 11
    }
}
