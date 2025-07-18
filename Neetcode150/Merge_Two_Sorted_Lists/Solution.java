package Merge_Two_Sorted_Lists;

class Solution {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the starting point of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode merge = dummy; // Pointer to build the new merged list

        // Traverse both lists and merge in sorted order
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {  // If list1's value is smaller, attach it to merged list
                merge.next = list1;
                list1 = list1.next;  // Move list1 pointer
            } else {  // If list2's value is smaller, attach it to merged list
                merge.next = list2;
                list2 = list2.next;  // Move list2 pointer
            }
            merge = merge.next;  // Move merge pointer
        }

        // Attach any remaining elements from either list
        merge.next = (list1 != null) ? list1 : list2;

        return dummy.next; // The merged list starts after the dummy node bcz the dummy nodes starts at -1 so if we return 'dummy' then -1 would hv included . So that's why we returnd dummy.next
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

        // Creating first linked list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // Creating second linked list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        // Printing original lists
        System.out.println("List 1:");
        printList(list1);
        System.out.println("List 2:");
        printList(list2);

        // Merging both lists
        ListNode mergedHead = solution.mergeTwoLists(list1, list2);

        // Printing merged list
        System.out.println("Merged List:");
        printList(mergedHead);
    }
}

