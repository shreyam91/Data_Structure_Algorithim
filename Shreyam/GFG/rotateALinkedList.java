// Question:- Rotate a Linked List.. 
// Given the head of a singly linked list, your task is to left rotate the linked list k times.

// Examples:
// Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
// Output: 50 -> 10 -> 20 -> 30 -> 40
// Explanation:
// Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
// Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
// Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
// Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

package shreyam.gfg;

public class rotateALinkedList {
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
     Node rotate(Node head, int k) {
             if (head == null || head.next == null || k == 0) {
                 return head; 
             }
             int len =1;
             Node tmp = head;
             while(tmp.next != null){
                 len++;
                 tmp = tmp.next;
             }
             k = k% len;
             if(k==0) {
                 return head;
             }
             tmp.next = head;
             tmp=head;
             for(int i=1;i<k;i++){
                 tmp=tmp.next;
             }
             head = tmp.next;
             tmp.next = null;
             return head;
         }
          void printList(Node head) {
             Node tmp = head;
             while (tmp != null) {
                 System.out.print(tmp.data + " ");
                 tmp = tmp.next;
             }
             System.out.println();
         }
         public static void main(String[] args) {
             rotateALinkedList list = new rotateALinkedList();
             Node head = list.new Node(10);
             head.next = list.new Node(20);
             head.next.next = list.new Node(30);
             head.next.next.next = list.new Node(40);
             head.next.next.next.next = list.new Node(50);
     
             System.out.println("Original List:");
             list.printList(head);
     
             int k = 4;
             head = list.rotate(head, k);

        System.out.println("Rotated List by " + k + " positions:");
        list.printList(head);
    }
}
