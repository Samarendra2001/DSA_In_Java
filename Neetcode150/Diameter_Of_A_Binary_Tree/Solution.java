package Diameter_Of_A_Binary_Tree;

public class Solution {
    static int maxDiameter = 0; // Global variable to keep track of the maximum diameter

    // Definition of TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor to initialize a node
        TreeNode(int val) {
            this.val = val;
            this.left = null; // Initialize left and right as null
            this.right = null;
        }
    }

    // Function to calculate the diameter of the binary tree
    public static int diameterOfBinaryTree(TreeNode root) {
        getHeight(root); // Calls helper function to compute height and update maxDiameter
        return maxDiameter;
    }

    // Helper function to get height and update maxDiameter
    private static int getHeight(TreeNode node) {
        if (node == null) return 0; // Base case: if node is null, return 0

        int leftHeight = getHeight(node.left); // Recursively get left subtree height
        int rightHeight = getHeight(node.right); // Recursively get right subtree height

        // Update maxDiameter: sum of left and right heights
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of current node (1 + max of left and right height)
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Constructing a binary tree
        //        4
        //      /   \
        //     2     7
        //    / \   / \
        //   1   3 6   9

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Print the diameter of the tree
        System.out.println("Diameter of the tree: " + diameterOfBinaryTree(root));
    }
}
