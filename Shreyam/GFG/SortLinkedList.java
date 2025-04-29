// Question: Sort a linked list of 0s, 1s and 2s... 
// Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

// Examples:
// Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
// Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2

package shreyam.gfg;

public class SortLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node segregate(Node head) {
        int zeros = 0, ones = 0, twos = 0;
        Node current = head;

        // Count 0s, 1s and 2s
        while (current != null) {
            if (current.data == 0) zeros++;
            else if (current.data == 1) ones++;
            else if (current.data == 2) twos++;
            current = current.next;
        }

        // Reassign values
        current = head;
        while (current != null) {
            if (zeros > 0) {
                current.data = 0;
                zeros--;
            } else if (ones > 0) {
                current.data = 1;
                ones--;
            } else {
                current.data = 2;
                twos--;
            }
            current = current.next;
        }

        return head;
    }

    // Utility method to print list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Creating the linked list: 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);

        System.out.println("Original List:");
        printList(head);

        head = segregate(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
