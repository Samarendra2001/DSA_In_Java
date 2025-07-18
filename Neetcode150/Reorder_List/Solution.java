package Reorder_List;

// We first find the middle of the linked list using 
//the slow and fast pointer approach. Then, we reverse the second half of the list and merge it back with the first half in an alternating manner.
class Solution {
    // Definition for a singly-linked list node
       static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
        this.val = val;
        this.next = null;
        }
    }
    public void reorderList(ListNode head) {
        
        if (head == null) {
            return;
        }
        
        // Step 1: Find the middle of the linked list using slow and fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null, curr = slow, temp;
        while (curr != null) {
            temp = curr.next;  // Store the next node
            curr.next = prev;  // Reverse the link
            prev = curr;       // Move prev forward
            curr = temp;       // Move curr forward
        }

        // Step 3: Merge the two halves alternatively
        ListNode first = head, second = prev;
        while (second.next != null) {
            temp = first.next;  // Store next node of first half
            first.next = second; // Connect first node to second node
            first = temp;        // Move first pointer forward
            
            temp = second.next;  // Store next node of second half
            second.next = first; // Connect second node to first half
            second = temp;       // Move second pointer forward
        }
    }

    // Helper function to print the list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a Linked List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        Solution sol = new Solution();
        sol.reorderList(head);

        System.out.println("Reordered List:");
        printList(head);
    }
}


