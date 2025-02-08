package Shreyam.gfg;

// Question: Add Number Linked Lists... 
// Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.
// For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.
// Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

// Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
// Output:  3 -> 9 -> 0
// Explanation: Given numbers are 45 and 345. There sum is 390.



public class AddNumberLinkedLists {
    static class Node {
        int data;
        Node next;
    
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static Node addTwoLists(Node num1, Node num2) {
        Node l1 = reverseList(num1);
        Node l2 = reverseList(num2);
        Node curr = null;
        int carry = 0;

        while(l1 != null || l2 != null || carry > 0){
            int value1 = l1 != null ? l1.data : 0;
            int value2 = l2 != null ? l2.data : 0;

            int sum = value1 + value2 + carry;
            carry = sum/10;
            Node tmp = new Node (sum%10);
            tmp.next = curr;
            curr=tmp;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        while(curr != null && curr.data == 0){
            curr = curr.next;
        }
        return curr == null ? new Node(0) : curr;
        
    }

    static Node reverseList(Node head){
        Node tmpHead = null;
        while(head != null){
            Node nex = head.next;
            if(tmpHead == null){
                tmpHead = head;
                tmpHead.next= null;
            }else{
                head.next = tmpHead;
                tmpHead=head;
            }
            head = nex;
        }
        return tmpHead;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node num1 = new Node(4);
        num1.next = new Node(5);
        // num1.next.next = new Node(6);  

        Node num2 = new Node(3);
        num2.next = new Node(4);
        num2.next.next = new Node(5);  

        Node result = addTwoLists(num1, num2);
        
        printList(result);
    }
}
