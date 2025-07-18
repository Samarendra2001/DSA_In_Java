package Merge_K_Sorted_Lists;

// Intuition
// We are given k sorted linked lists, and we need to merge them into a single sorted linked list efficiently.

// Instead of merging one by one (which is slow), we extract the smallest elements first using a Min-Heap (PriorityQueue).
// By inserting all elements into a Min-Heap, we can efficiently retrieve the smallest element in O(log k) time.

import java.util.PriorityQueue;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        // **Step 1: Create a Min-Heap to store node values**
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // **Step 2: Add all nodes' values from the k linked lists into the minHeap**
        for (ListNode list : lists) {  // Loop through each list
            while (list != null) {  // Traverse each linked list
                minHeap.add(list.val); // Add node value to minHeap
                list = list.next; // Move to next node
            }
        }

        // **Step 3: Create a dummy node for the merged list**
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;

        // **Step 4: Build the merged list by extracting values from minHeap**
        while (!minHeap.isEmpty()) {
            merge.next = new ListNode(minHeap.remove()); // Extract smallest element
            merge = merge.next; // Move merge pointer forward
        }

        // **Step 5: Return the merged linked list (skipping dummy node)**
        return dummy.next;
    }
       public static void main(String[] args) {
            // Creating multiple sorted linked lists
            ListNode list1 = new ListNode(1);
            list1.next = new ListNode(4);
            list1.next.next = new ListNode(5);
    
            ListNode list2 = new ListNode(1);
            list2.next = new ListNode(3);
            list2.next.next = new ListNode(4);
    
            ListNode list3 = new ListNode(2);
            list3.next = new ListNode(6);
    
            ListNode[] lists = {list1, list2, list3}; // Array of sorted lists
    
            // Merging k sorted lists
            Solution solution = new Solution();
            ListNode mergedHead = solution.mergeKLists(lists);
    
            // Print merged sorted linked list
            while (mergedHead != null) {
                System.out.print(mergedHead.val + " -> ");
                mergedHead = mergedHead.next;
            }
            System.out.println("null");
        }
    
}

