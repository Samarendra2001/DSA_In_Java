package Invert_Binary_Tree;

//import javax.swing.tree.TreeNode;
    // Definition for a binary tree node
public class Solution {
static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = left;
        this.right = right;

    }

}


    // Invert the binary tree function
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        // Swap the left and right children
        root.left = right;
        root.right = left;

        return root;
    }

    // Helper method to print the tree in Pre-order traversal (Root -> Left -> Right)
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
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

        System.out.println("Original tree (Pre-order Traversal):");
        preOrder(root);  // Print original tree
        
        // Invert the binary tree
        root = invertTree(root);

        System.out.println("\nInverted tree (Pre-order Traversal):");
        preOrder(root);  // Print inverted tree
    }
 }

