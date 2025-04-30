// Question: Find length of Loop... 
// Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.
// Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist. If c is 0, then there is no loop.

// Examples:
// Input: head: 1 → 2 → 3 → 4 → 5, c = 2
// Output: 4

package shreyam.gfg;


class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

public class FindLengthOfLoop {
    public static int countNodesInLoop(Node head) {
        Node slow = head, fast = head;
        int count = 0;

        // Detect loop using Floyd’s Cycle Detection Algorithm
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Loop detected, now count the number of nodes in the loop
                Node temp = slow;
                do {
                    count++;
                    temp = temp.next;
                } while (temp != slow);
                return count;
            }
        }

        // No loop detected
        return 0;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 → 2 → 3 → 4 → 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop: 5 → 2
        head.next.next.next.next.next = head.next;

        // Output the length of the loop
        System.out.println(countNodesInLoop(head)); // Output: 4
    }
}
