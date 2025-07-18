package Count_Good_nodes_In_ABinaryTree;
// Intuition:
// A good node in a binary tree is a node whose value is greater than or equal to all the values along the path from the root to that node.
// We traverse the tree using DFS (Depth-First Search), keeping track of the maximum value seen so far (maxSoFar). If the current node's value is greater than or equal to maxSoFar, it is a good node.

// Approach:
// Start DFS traversal from the root node with an initial maxSoFar set to Integer.MIN_VALUE.
// At each node:
// If the node's value ≥ maxSoFar, count it as a good node and update maxSoFar.
// Recursively check the left and right subtrees, passing the updated maxSoFar.
// Sum up the count from left and right subtrees and return the total number of good nodes.
class Solution {
    public int goodNodes(TreeNode root) {
        // Start DFS traversal from the root with initial maxSoFar as Integer.MIN_VALUE
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node, int maxSoFar) {
        // Base case: If we reach a null node, return 0 (no good nodes in null)
        if (node == null) {
            return 0;
        }

        int count = 0;
        // Check if the current node is a "good node"
        if (node.val >= maxSoFar) {
            count = 1; // Current node is good
            maxSoFar = node.val; // Update maxSoFar to current node's value
        }

        // Recursively count good nodes in the left and right subtrees
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        // Return the total count of good nodes in this subtree
        return count;
    }

    // Main function to test the code
    public static void main(String[] args) {
        // Creating a sample tree:
        //        3
        //       / \
        //      1   4
        //     /   / \
        //    3   1   5

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        Solution sol = new Solution();
        System.out.println("Number of good nodes: " + sol.goodNodes(root));
        // Expected output: 4 (Nodes: 3, 3, 4, 5)
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

