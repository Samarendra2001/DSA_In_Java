package Reverse_Nodes_In_K_Group;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;  // Pointer to traverse the list
        ListNode ktail = null; // Keeps track of the last reversed group's tail
        ListNode newHead = null; // Will store the new head of the final list

        while (ptr != null) {
            int count = 0;
            ptr = head;

            // Check if there are at least k nodes left in the list
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }

            if (count == k) { // If we found k nodes, reverse them
                ListNode revHead = reverseLinkedList(head, k);

                if (newHead == null) {
                    newHead = revHead; // Set the new head after first reversal
                }

                if (ktail != null) {
                    ktail.next = revHead; // Connect the last reversed group
                }

                ktail = head; // Update ktail to the current segment's tail
                head = ptr; // Move head to the next segment
            }
        }

        // If some nodes remain unprocessed, attach them to the last reversed part
        if (ktail != null) {
            ktail.next = head;
        }

        return newHead == null ? head : newHead;
    }

    // Helper function to reverse exactly k nodes
    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode newHead = null; // New head of reversed segment
        ListNode ptr = head;

        while (k > 0) {
            ListNode nextNode = ptr.next; // Store next node
            ptr.next = newHead; // Reverse pointer
            newHead = ptr; // Move newHead forward
            ptr = nextNode; // Move ptr forward
            k--;
        }

        return newHead;
    }
}

// **Main function to test the solution**
public class Main {
    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        int k = 3; // Size of groups to reverse

        // Applying the function
        Solution solution = new Solution();
        ListNode newHead = solution.reverseKGroup(head, k);

        // Printing the modified linked list
        System.out.print("Reversed in K Groups: ");
        while (newHead != null) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
        System.out.println("null");
    }
}

// 🔹 Explanation of the Code
// 1️⃣ Reverse Groups of k Nodes
// We first check if k nodes exist in the list.
// If k nodes are found:
// We reverse them using reverseLinkedList().
// If it's the first reversed group, we set newHead.
// Otherwise, we connect the last reversed group.
// Move the head pointer to the next segment.
// 2️⃣ reverseLinkedList() Function
// Reverses exactly k nodes by:
// Storing the next node.
// Reversing the current node’s pointer.
// Moving newHead forward.
// Moving ptr forward.
// 3️⃣ Why Do We Need ktail?
// It keeps track of the tail of the last reversed group.
// Ensures smooth linking between reversed and non-reversed segments.
