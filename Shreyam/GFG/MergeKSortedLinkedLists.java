// Question: Merge K sorted linked lists... 
// Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.

// Examples:
// Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
// Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8

package shreyam.gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    static Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        for (Node n : arr) {
            if (n != null) {
                pq.add(n);
            }
        }

        Node newHead = null, tail = null;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll(); 

            if (newHead == null) {
                newHead = tmp;
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tmp;
            }

            if (tmp.next != null) {
                pq.add(tmp.next);
            }
        }

        return newHead;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);

        Node list2 = new Node(4);
        list2.next = new Node(5);

        Node list3 = new Node(5);
        list3.next = new Node(6);

        Node list4 = new Node(7);
        list4.next = new Node(8);

        List<Node> arr = new ArrayList<>();
        arr.add(list1);
        arr.add(list2);
        arr.add(list3);
        arr.add(list4);

        Node mergedHead = mergeKLists(arr);

        printList(mergedHead);
    }
}
