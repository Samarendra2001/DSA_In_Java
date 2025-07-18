package Reverse_Linked_List;

class Solution {
    // Definition of a ListNode
    static class ListNode {
        int val;
        ListNode next;

        // Constructor to initialize a node
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to reverse a linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  // Previous pointer (initially null)
        ListNode curr = head;  // Current pointer (points to head)

        while (curr != null) {  // Traverse until the end of the list
            ListNode temp = curr.next;  // Store next node
            curr.next = prev;  // Reverse the link
            prev = curr;  // Move prev forward
            curr = temp;  // Move curr forward
        }

        return prev;  // New head of reversed list
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Printing original linked list
        System.out.println("Original Linked List:");
        printList(head);

        // Reversing the linked list
        ListNode reversedHead = solution.reverseList(head);

        // Printing reversed linked list
        System.out.println("Reversed Linked List:");
        printList(reversedHead);
    }
}
