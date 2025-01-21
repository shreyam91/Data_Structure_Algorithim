// Question: Linked List Group Reverse... 
// Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.

// Examples:
// Input: head = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8, k = 4
// Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5
// Explanation: The first 4 elements 1, 2, 2, 4 are reversed first and then the next 4 elements 5, 6, 7, 8. Hence, the resultant linked list is 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5.

package Shreyam.GFG;

public class LinkedListGroupReverse {
   static class Node{
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    public static Node reverseKGroup(Node head, int k) {

        if (k <= 1 || head == null) {
            return head;
        }

        int len = getLength(head);
        Node originalH = null, originalT = null, tmpH = null, tmpT = null;
        Node curr = head;
        while(len >0){
            int j =k;
            j = Math.min(j, len);
            while(j>0){
                Node nex = curr.next;
                if(tmpH == null){
                    tmpH = curr;
                    tmpT = curr;
                }else{
                    curr.next = tmpH;
                    tmpH = curr;
                }
                curr = nex;
                j--;
                len--;
            }
            if(originalH == null){
                originalH = tmpH;
                originalT = tmpT;
            }else{
                originalT.next = tmpH;
                originalT = tmpT;
            }
            tmpH = null;
            tmpT = null;
        }
        originalT.next = null;
        return originalH;
        
        }
        public static int getLength(Node head){
            int len =0;
            while(head != null){
                len++;
                head = head.next;
            }
            return len;
        }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static Node createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        Node head = new Node(values[0]);
        Node curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new Node(values[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = createList(values);

        System.out.println("Original List:");
        printList(head);

        head = reverseKGroup(head, 4);

        System.out.println("Reversed List in groups of 3:");
        printList(head);
    }
}
