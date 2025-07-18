package Balanced_Binary_Tree;

public class Solution {
    // Definition of a TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to check if the tree is balanced
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is balanced
        }

        int leftHeight = getHeight(root.left); // Get height of left subtree
        int rightHeight = getHeight(root.right); // Get height of right subtree

        // If the difference in height is greater than 1, the tree is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Recursively check if the left and right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Private helper function to get the height of the tree
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: height of an empty tree is 0
        }

        int leftHeight = getHeight(node.left); // Recursively get left subtree height
        int rightHeight = getHeight(node.right); // Recursively get right subtree height

        return Math.max(leftHeight, rightHeight) + 1; // Return height of current node
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Constructing a binary tree
        //        1
        //      /   \
        //     2     3
        //    / \   / 
        //   4   5 6   
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        // Check if the tree is balanced
        System.out.println("Is the tree balanced? " + solution.isBalanced(root));
    }
}

