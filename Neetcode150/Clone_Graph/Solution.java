package Clone_Graph;
// 🔹 Approach
// Since the graph contains cycles (due to mutual connections between nodes), a simple recursive approach would revisit nodes multiple times, leading to infinite recursion.
// To prevent this, we use a HashMap (visited) to keep track of already cloned nodes.

// Steps
// Base Case: If node == null, return null.
// Check if the node is already cloned:
// If yes, return the cloned node to avoid re-processing.
// Clone the current node:
// Create a new node with the same value (node.val).
// Store it in visited HashMap.
// Clone the neighbors recursively:
// Traverse each neighbor in node.neighbors.
// Recursively call cloneGraph(neighbor).
// Add the cloned neighbor to the current node’s neighbors list.
// Return the cloned node.
import java.util.*;

class Node {
    public int val;  // Stores the value of the node
    public List<Node> neighbors;  // Stores the adjacent nodes

    // Constructor for an empty node
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    // Constructor to create a node with a value
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    // Constructor to create a node with value and neighbor list
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {
    
    // HashMap to store the mapping of original node -> cloned node
    private HashMap<Node, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        // Step 1: Base Case - If input graph is empty, return null
        if (node == null) {
            return null;
        }
        
        // Step 2: Check if the current node is already cloned
        // If yes, return its reference to avoid infinite recursion
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Step 3: Create a clone of the current node with an empty neighbor list
        Node cloneNode = new Node(node.val, new ArrayList<>());
        
        // Step 4: Store the cloned node in the HashMap
        visited.put(node, cloneNode);
        
        // Step 5: Clone all the neighbors recursively
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        // Step 6: Return the cloned node
        return cloneNode;
    }

    // ✅ Main method for testing
    public static void main(String[] args) {
        // Creating the graph: (1) -- (2) -- (3) -- (4) -- (1)
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Connecting the nodes
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Create an instance of Solution and clone the graph
        Solution solution = new Solution();
        Node clonedGraph = solution.cloneGraph(node1);

        System.out.println("Graph Cloned Successfully!");
    }
}

