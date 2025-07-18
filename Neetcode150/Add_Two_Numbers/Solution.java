package Add_Two_Numbers;
// We need to add two numbers represented as linked lists, where each node stores a single digit. The digits are stored in reverse order, meaning the least significant digit is first.

// We traverse both lists, digit by digit, adding them along with a carry (if any).
// A dummy node helps keep track of the result list while an ans pointer builds it.
// The carry is updated after each sum and is propagated forward

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node acts as a placeholder to simplify list creation
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;  // Pointer to traverse and build the result list
        int carry = 0;         // Carry for summation

        // Loop while there are digits in l1 or l2, or there's a carry left
        while (l1 != null || l2 != null || carry != 0) {
            // If l1 exists, take its value, else 0
            int x = (l1 != null) ? l1.val : 0;  
            // If l2 exists, take its value, else 0
            int y = (l2 != null) ? l2.val : 0;  
            // Sum current digits + carry
            int sum = carry + x + y;            

            carry = sum / 10;  // Update carry (e.g., 15 -> carry = 1)
            
            ans.next = new ListNode(sum % 10);  // Create a new node with the last digit of sum(like if greater than 10 so ones digit 'll be there so to find the ones place  like 17 %10 = 7 like this')
            ans = ans.next; // Move the pointer forward

            // Move l1 and l2 forward if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next; // Return the head of the new list (skip dummy)
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example: (2 -> 4 -> 3) + (5 -> 6 -> 4) = (7 -> 0 -> 8)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("Input List 1:");
        printList(l1);
        System.out.println("Input List 2:");
        printList(l2);

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.println("Sum List:");
        printList(result);
    }
}

