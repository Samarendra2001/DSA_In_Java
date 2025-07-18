package Copy_List_With_Random_Pointer;

// We need to create a deep copy of a linked list where each node has both a next and a random pointer.

// Using a hashmap, we store already created copies of nodes to avoid duplication.
// Recursion is used to traverse and create new nodes while maintaining proper references.
import java.util.HashMap;

class Solution {
    
    // HashMap to store original nodes as keys and their copied nodes as values
    HashMap<Node, Node> visitedNode = new HashMap<>();
    
    public Node copyRandomList(Node head) {
   
        // Base case: If the original node is null, return null
        if (head == null) {
            return null;
        }
        
        // If the node is already copied, return the stored copy to prevent duplication
        if (visitedNode.containsKey(head)) {
            return visitedNode.get(head);
        }
        
        // Step 1: Create a new node with the same value as the original node
        Node newNode = new Node(head.val, null, null);
        
        // Step 2: Store this new node in the HashMap
        visitedNode.put(head, newNode);
        
        // Step 3: Recursively copy the `next` and `random` pointers
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        
        // Step 4: Return the newly created deep copy node
        return newNode;
    }

    // Helper function to print a linked list with random pointers
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.val + ", Random: " + 
                             (temp.random != null ? temp.random.val : "null") + "] -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Constructing a Linked List with Random Pointers
        // Example: [7, null] -> [13, 7] -> [11, 1] -> [10, 11] -> [1, 7]
        
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        
        // Setting up random pointers
        head.next.random = head; // 13 -> 7
        head.next.next.random = head.next.next.next.next; // 11 -> 1
        head.next.next.next.random = head.next.next; // 10 -> 11
        head.next.next.next.next.random = head; // 1 -> 7
        
        System.out.println("Original List:");
        printList(head);

        // Copy the list
        Solution sol = new Solution();
        Node copiedHead = sol.copyRandomList(head);

        System.out.println("Copied List:");
        printList(copiedHead);
    }
}

// Definition for a linked list node with a random pointer
class Node {
    int val;
    Node next;
    Node random;

    // Constructor for a node with only a value
    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    // Constructor for a node with value, next, and random pointers
    Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

