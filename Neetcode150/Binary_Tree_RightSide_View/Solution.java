package Binary_Tree_RightSide_View;
// Intuition:
// We need to return the rightmost node of each level in a binary tree. Since a level-order traversal (BFS) visits nodes level by level, the last node encountered at each level is the rightmost node.

// Approach:
// Use BFS (level-order traversal) with a queue to traverse the tree level by level.
// At each level, process all nodes.
// Add the last node of each level to the result list.
// Add child nodes (left first, then right) to the queue to continue traversal.
import java.util.*;

class TreeNode {
    int val; // Value of the current node
    TreeNode left, right; // Left and right child pointers

    // Constructor to initialize a tree node
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {
    
    /**
     * Function to return the right-side view of a binary tree.
     * The right-side view consists of the last visible node at each level when viewed from the right.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // List to store the rightmost nodes at each level
        
        // If the tree is empty, return an empty list
        if (root == null) {
            return result;
        }

        // Queue for level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start with the root node

        // Perform BFS (level-order traversal)
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level

            // Traverse all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Remove the front node from the queue

                // If this is the last node in the current level, add its value to the result list
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                // Add the left child to the queue if it exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // Add the right child to the queue if it exists
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return result; // Return the final list of right-side view nodes
    }

    /**
     * Main method to test the rightSideView function.
     */
    public static void main(String[] args) {
        Solution solution = new Solution(); // Create an instance of the Solution class

        // Construct the following Binary Tree:
        /*
                  1
                 / \
                2   3
                 \    \
                  5    4
        */
        
        TreeNode root = new TreeNode(1);   // Root node with value 1
        root.left = new TreeNode(2);       // Left child of root (2)
        root.right = new TreeNode(3);      // Right child of root (3)
        root.left.right = new TreeNode(5); // Right child of node 2 (5)
        root.right.right = new TreeNode(4); // Right child of node 3 (4)

        // Call the rightSideView function
        List<Integer> rightView = solution.rightSideView(root);

        // Output the result
        System.out.println("Right Side View of the Tree: " + rightView);
    }
}

