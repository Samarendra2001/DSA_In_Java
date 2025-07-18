package LRU_Cache;

import java.util.HashMap;

public class LRUCache {
    // Node class for doubly linked list
    private static class Node {
        int key; // Key stored in cache
        int value; // Value of the key
        Node prev, next; // Pointers to previous and next nodes

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity; // Maximum capacity of cache
    private final HashMap<Integer, Node> map; // HashMap to store key → Node mapping
    private final Node head, tail; // Dummy head and tail for easier operations

    // Constructor to initialize LRU cache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Create dummy head and tail nodes (they do not store actual values)
        head = new Node(0, 0); 
        tail = new Node(0, 0);

        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }

    // Get the value of a key from cache
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; // Key does not exist
        }

        Node node = map.get(key); // Get the node from HashMap
        remove(node); // Remove from current position
        insertAtHead(node); // Move it to the head (most recently used)
        return node.value; // Return value of the node
    }

    // Insert or update a key in the cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // If key exists, update its value
            Node node = map.get(key);
            node.value = value;
            remove(node); // Remove from current position
            insertAtHead(node); // Move it to head (most recently used)
        } else {
            if (map.size() == capacity) {
                // If capacity is full, remove the least recently used node
                map.remove(tail.prev.key); // Remove key from HashMap
                remove(tail.prev); // Remove node from doubly linked list
            }
            // Insert new node at head (most recently used position)
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    // Remove a node from the doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next; // Connect previous node to next node
        node.next.prev = node.prev; // Connect next node to previous node
    }

    // Insert a node at the head (most recently used)
    private void insertAtHead(Node node) {
        node.next = head.next; // Point new node to current first node
        node.next.prev = node; // Update previous pointer of first node
        head.next = node; // Move head pointer to new node
        node.prev = head; // Update new node's previous to head
    }

    // Main method for testing
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // Cache capacity = 2

        cache.put(1, 10); 
        cache.put(2, 20);
        System.out.println(cache.get(1)); // Output: 10 (1 is now MRU)

        cache.put(3, 30); // Evicts key 2 (LRU key)
        System.out.println(cache.get(2)); // Output: -1 (Key 2 was evicted)

        cache.put(4, 40); // Evicts key 1 (LRU key)
        System.out.println(cache.get(1)); // Output: -1 (Key 1 was evicted)
        System.out.println(cache.get(3)); // Output: 30
        System.out.println(cache.get(4)); // Output: 40
    }
}

// final keyWord  reassignment, but not modification of the object's content.
// It ensures that important references (like head/tail) remain constant.
// It improves code safety by preventing accidental reassignments.