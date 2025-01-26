// Question: Remove loop in Linked List... 
// Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list. The task is to remove the loop from the linked list (if it exists).
// Custom Input format:
// A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.
// The generated output will be true if there is no loop in list and other nodes in the list remain unchanged, otherwise, false.

// Examples:
// Input: head = 1 -> 3 -> 4, pos = 2
// Output: true

package Shreyam.GFG;

public class RemoveLoopInLinkedList {
    static class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) return;
        Node slow=head, fast = head, prev = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            prev = fast;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                prev = prev.next;
                while(slow!=fast){
                    slow = slow.next;
                    fast=fast.next;
                    prev = prev.next;
                }
                prev.next = null;
                return;
            }
        }
    }

    public static Node createLinkedListWithLoop() {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; 

        return head;
    }
    public static void main(String[] args) {
        Node head = createLinkedListWithLoop();
        
        removeLoop(head);
        
        System.out.println("Loop removed successfully (Check manually or with a print statement).");
    }
}
