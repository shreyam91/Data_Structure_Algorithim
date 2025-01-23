// Question: Clone List with Next and Random... 
// You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.
// Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.
// Return the head of the copied linked list.
// NOTE : Original linked list should remain unchanged.

// Input: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] 
// Output: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] 
// Explanation: 
// Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
// Node 2 points to Node 3 as its NEXT and Node 3 as its RANDOM.
// Node 3 points to Node 4 as its NEXT and NULL as its RANDOM.
// Node 4 points to NULL as its NEXT and Node 3 as its RANDOM.

package Shreyam.GFG;


public class CloneListWithNextAndRandom {
    static class Node  {
        int data;
        Node next;
        Node random;
    
        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }
    
        public static Node cloneLinkedList(Node head) {
            if(head == null) return null;
            Node curr = head;
            while(curr != null){
                Node copy = new Node(curr.data);
                copy.next = curr.next;
                curr.next = copy;
                curr = copy.next;
            }
            curr = head;
            while(curr != null){
                if(curr.random != null){
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }
            curr = head;
            Node copyH = head.next;
            while(curr != null){
                Node copy = curr.next;
                curr.next = copy.next;
                if(copy.next != null){
                    copy.next = copy.next.next;
                }
                curr = curr.next;
            }
         return copyH;
        }

        public static void printList(Node head) {
            Node curr = head;
            while (curr != null) {
                System.out.print("Data: " + curr.data);
                if (curr.random != null) {
                    System.out.print(", Random: " + curr.random.data);
                } else {
                    System.out.print(", Random: null");
                }
                System.out.println();
                curr = curr.next;
            }
        }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        // Setting random pointers
        head.random = third;
        second.random = head;
        third.random = second;
        fourth.random = third;

        System.out.println("Original List:");
        printList(head);

        // Cloning the linked list
        Node clonedHead = cloneLinkedList(head);

        System.out.println("\nCloned List:");
        printList(clonedHead);
    }   
}
