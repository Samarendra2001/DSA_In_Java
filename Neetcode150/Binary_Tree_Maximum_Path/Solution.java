package Binary_Tree_Maximum_Path;

// 🚀 Intuition:
// In a binary tree, a path is any sequence of nodes that connects any two nodes, including the possibility of ending at a single node.
// The maximum path sum could be in the left subtree, right subtree, or pass through the current node.
// We need to consider all possible paths and update the maximum sum accordingly.
// 📌 Approach:
// Use Recursion:

// Recursively compute the maximum path sum from the left and right subtrees.
// Ignore negative sums by using Math.max(0, left/right path sum) (because a path with a negative sum is not useful).
// Compute Maximum Path at Each Node:

// The best path sum at a given node could be:
// The node alone.
// The node + left subtree.
// The node + right subtree.
// The node + both left and right subtrees.
// We update a global variable maxSum with the highest value found.
// Return the Best Path Sum:

// When returning to the parent node, we can only choose one child path (left or right).
// We return node.val + max(leftGain, rightGain), as this keeps the path valid.

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Solution {
    private int maxSum = Integer.MIN_VALUE; // Global variable to track maximum path sum

    // Helper function to compute maximum path sum
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0; // Base case: If node is null, return 0
        }

        // Recursively get max sum from left and right subtrees
        // If the sum is negative, discard it by taking max with 0
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Compute the best possible path sum including the current node
        int priceNewPath = node.val + leftGain + rightGain;

        // Update global maxSum if this path has a higher sum
        maxSum = Math.max(maxSum, priceNewPath);

        // Return the max path sum including either left or right child
        return node.val + Math.max(leftGain, rightGain);
    }

    // Main function to return the maximum path sum in the tree
    public int maxPathSum(TreeNode root) {
        maxGain(root); // Start recursive function
        return maxSum; // Return the final maximum path sum
    }

    // Function to test the implementation
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Construct the tree
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Find and print the maximum path sum
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root));
    }
}

