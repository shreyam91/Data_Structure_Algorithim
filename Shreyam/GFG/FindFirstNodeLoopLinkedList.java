// Question: Find the first node of loop in linked list... 
// Given a head of the singly linked list. If a loop is present in the list then return the first node of the loop else return NULL.

// Custom Input format:
// A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

// Input: 1-> 3 -> 2 -> 4-> 5->
// Output: 3
// Explanation: We can see that there exists a loop in the given linked list and the first node of the loop is 3.

package Shreyam.gfg;

public class FindFirstNodeLoopLinkedList {
    static class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}
 static Node findFirstNode(Node head) {
    Node slow = head, fast = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast){
            slow=head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
    return null;
    
}

 static void createCycle(Node head, int cycleStartIndex) {
    Node current = head;
    Node cycleStartNode = null;
    int index = 0;
    
    while (current.next != null) {
        if (index == cycleStartIndex) {
            cycleStartNode = current;
        }
        current = current.next;
        index++;
    }
    current.next = cycleStartNode; // Create the cycle
}

 static Node createList(int[] values) {
    Node head = new Node(values[0]);
    Node current = head;
    for (int i = 1; i < values.length; i++) {
        current.next = new Node(values[i]);
        current = current.next;
    }
    return head;
}
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5}; // Sample list values
        Node head = createList(values);
        
        // Create a cycle in the list (e.g., cycle starting at index 2)
        createCycle(head, 2);

        // Find the first node in the cycle
        Node cycleStart = findFirstNode(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.data);
        } else {
            System.out.println("No cycle detected");
        }
    }
}
