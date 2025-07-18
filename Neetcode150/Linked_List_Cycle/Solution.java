package Linked_List_Cycle;

// 🔹 Intuition
// We use two pointers (slow and fast) to traverse the linked list.

// slow moves one step at a time.
// fast moves two steps at a time.
// If there is a cycle, fast will eventually meet slow.
// If there is no cycle, fast will reach null.
// // Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        // If the list is empty, return false (no cycle)
        if (head == null) {
            return false;
        }
        
        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the linked list using two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer by 1 step
            fast = fast.next.next;     // Move fast pointer by 2 steps
            
            if (slow == fast) {        // If slow and fast meet, cycle is detected
                return true;
            }
        }

        return false;  // If fast reaches the end, there is no cycle
    }

    // 🟢 Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Linked List with Cycle
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Creating a cycle

        System.out.println("Has Cycle (Example 1)? " + solution.hasCycle(head1)); // Expected: true

        // Example 2: Linked List Without Cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("Has Cycle (Example 2)? " + solution.hasCycle(head2)); // Expected: false
    }
}
