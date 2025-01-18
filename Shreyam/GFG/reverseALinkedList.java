// Question: Reverse a linked list... 
// Given the head of a linked list, the task is to reverse this list and return the reversed head.

// Examples:
// Input: head: 1 -> 2 -> 3 -> 4 -> NULL
// Output: head: 4 -> 3 -> 2 -> 1 -> NULL

package Shreyam.GFG;

// import org.w3c.dom.Node;

// import org.w3c.dom.Node;

public class reverseALinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node reverseList(Node head) {
        Node tmpHead = null;
        while(head != null){
            Node next = head.next;
            if(tmpHead == null){
                tmpHead = head;
                tmpHead.next = null;
            }else{
                head.next = tmpHead;
                tmpHead = head;
            }
            head = next;
        }
        return tmpHead;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        reverseALinkedList reverser = new reverseALinkedList();
        Node reversedHead = reverser.reverseList(head);

        // Print the reversed list
        Node current = reversedHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
