package Level_Order_Traversal;
// Intuition:
// The goal is to return the level order traversal of a binary tree, where each level of the tree is stored in a separate list.

// We use Depth-First Search (DFS) to traverse the tree and store nodes level by level in a list of lists (ans).
// If we reach a new level, we create a new list to store values at that level.
// We traverse left first, then right, ensuring values are added in correct order.
// Approach:
// Use DFS (Recursive Traversal): Start from the root at level 0 and pass level+1 for child nodes.
// Store Nodes by Levels:
// If ans.size() == level, it means we are visiting this level for the first time, so create a new list.
// Add the node's value to ans.get(level).
// Recursive Calls:
// First visit the left child (level+1).
// Then visit the right child (level+1).
// Return the ans list containing all levels
import java.util.*;

class Solution {
    // List to store nodes level-wise
    List<List<Integer>> ans = new ArrayList<>();
    
    // Helper function to perform DFS and store nodes by levels
    public void order(TreeNode node, int level) {
        // If we reach a new level, create a new list to store values at that level
        if (ans.size() == level) {
            ans.add(new ArrayList<Integer>());
        }
        
        // Add the current node's value to the corresponding level's list
        ans.get(level).add(node.val);
        
        // Recursively process the left child, increasing the level
        if (node.left != null) {
            order(node.left, level + 1);
        }
        
        // Recursively process the right child, increasing the level
        if (node.right != null) {
            order(node.right, level + 1);
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Edge case: If tree is empty, return empty list
        if (root == null) {
            return ans;
        }
        
        // Start DFS traversal from root at level 0
        order(root, 0);
        
        return ans;
    }

    // Main function to test the code
    public static void main(String[] args) {
        // Constructing a sample binary tree:
        //        3
        //       / \
        //      9   20
        //         /  \
        //        15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();
        List<List<Integer>> result = sol.levelOrder(root);
        
        System.out.println("Level Order Traversal: " + result);
        // Expected output: [[3], [9, 20], [15, 7]]
    }
}

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

