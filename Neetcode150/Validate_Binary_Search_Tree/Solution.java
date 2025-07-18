package Validate_Binary_Search_Tree;
// Intuition
// A Binary Search Tree (BST) must satisfy the condition:
// For every node, all left subtree nodes must be smaller, and all right subtree nodes must be larger.
// The in-order traversal of a BST should produce a sorted (strictly increasing) sequence.
// We can validate the BST by performing an in-order traversal and checking if the current node value is always greater than the previous node.
// Approach
// Use in-order traversal (left → root → right).
// Maintain a variable prev to store the previous node's value.
// If at any point, the current node's value is less than or equal to prev, return false.
// Otherwise, update prev and continue checking the right subtree.
// If we successfully traverse the whole tree without violations, return true.
class Solution {
    public Integer prev; // Stores the previous node value in in-order traversal

    public boolean isValidBST(TreeNode root) {
        prev = null; // Initialize prev as null
        return inOrder(root); // Start in-order traversal
    }

    public boolean inOrder(TreeNode root) {
        if (root == null) {
            return true; // Base case: Empty tree is a valid BST
        }

        // Step 1: Recursively check the left subtree
        if (!inOrder(root.left)) {
            return false; // If left subtree is invalid, return false
        }

        // Step 2: Check the current node
        if (prev != null && root.val <= prev) {
            return false; // BST property violated, return false
        }

        // Update prev to the current node value
        prev = root.val;

        // Step 3: Recursively check the right subtree
        return inOrder(root.right);
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Creating a sample BST:
        //         5
        //        / \
        //       3   7
        //      / \  / \
        //     2   4 6  8

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        Solution sol = new Solution();
        System.out.println("Is valid BST? " + sol.isValidBST(root)); // Expected: true
    }
}

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

