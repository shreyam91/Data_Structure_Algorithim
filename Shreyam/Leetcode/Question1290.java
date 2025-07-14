// Question: Convert Binary Number in a Linked List to Integer

// Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
// Return the decimal value of the number in the linked list.
// The most significant bit is at the head of the linked list.

// Example 1:
// Input: head = [1,0,1]
// Output: 5

package shreyam.leetCode;


public class Question1290 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        for (; head != null; head = head.next)
            ans = ans * 2 + head.val;
        return ans;
    }

    public static void main(String[] args) {
        // Input binary: 1 -> 0 -> 1
        int[] values = {1, 0, 1};

        // Build linked list from array
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        // Create an instance to call non-static method
        Question1290 solution = new Question1290();
        int decimalValue = solution.getDecimalValue(dummy.next);

        // Output the result
        System.out.println("Decimal value: " + decimalValue);
    }
}
