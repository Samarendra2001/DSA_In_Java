package Remove_The_NthNode_FromEnd_Of_List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);  // Step 1: Create a dummy node
        dummy.next = head;  // Attach dummy to head of the list

        ListNode first = dummy;
        ListNode second = dummy;

        // Step 2: Move 'first' pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Step 3: Move both pointers until 'first' reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 4: Remove the target node
        second.next = second.next.next;

        // Step 5: Return the new head (skip dummy node)
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Step 1: Construct the linked list 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);  // Output: 1 -> 2 -> 3 -> 4 -> 5 -> null

        int n = 2;  // Remove 2nd node from end

        // Step 2: Remove the N-th node from end
        head = removeNthFromEnd(head, n);

        System.out.println("Modified List after removing " + n + "th node from end:");
        printList(head);  // Expected Output: 1 -> 2 -> 3 -> 5 -> null
    }
}

