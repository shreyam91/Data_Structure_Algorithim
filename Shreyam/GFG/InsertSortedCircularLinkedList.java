// Question: Insert in Sorted Circular Linked List

// Given a sorted circular linked list, the task is to insert a new node in this circular linked list so that it remains a sorted circular linked list.

// Examples:

// Input: head = 1->2->4, data = 2
// Output: 1->2->2->4

package shreyam.gfg;

public class InsertSortedCircularLinkedList {
    static class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

 static Node sortedInsert(Node head, int data) {
        Node prev = null;
        Node node = head;
        
        do {
            prev = node;
            node = node.next;
        } while(node != head);
        
        
        while(node.data < data) {
            node = node.next;
            prev = prev.next;
            if(node == head) {
                break;
            }
        }
        
        Node newNode = new Node(data);
        prev.next = newNode;
        newNode.next = node;
        
        if(head.data > data) {
            return newNode;
        } else {
            return head;
        }
    }

     static void printList(Node head) {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(4);
        head.next = second;
        second.next = third;
        third.next = head;  

        int data = 2;

        head = sortedInsert(head, data);  

        printList(head); 
    }
}