package Construct_BinaryTree_from_InOrder_Preorder;

import java.util.HashMap;

class Solution {
    private int preIndex = 0; // Index to track preorder array
    private HashMap<Integer, Integer> inorderMap; // Store inorder indices for quick lookup

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        
        // Store inorder values with their indices in a HashMap
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return constructTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int inStart, int inEnd) {
        // Base Case: No elements left
        if (inStart > inEnd) return null;

        // Get the root node from preorder traversal
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder traversal
        int rootIndex = inorderMap.get(rootVal);

        // Recursively build left and right subtrees
        root.left = constructTree(preorder, inStart, rootIndex - 1);
        root.right = constructTree(preorder, rootIndex + 1, inEnd);

        return root;
    }

    // Helper function to print inorder traversal (for verification)
    private void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        TreeNode root = sol.buildTree(preorder, inorder);
        
        // Print inorder to verify correct tree structure
        System.out.print("Inorder traversal of constructed tree: ");
        sol.printInorder(root); // Expected Output: 9 3 15 20 7
    }
}

// TreeNode class definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
