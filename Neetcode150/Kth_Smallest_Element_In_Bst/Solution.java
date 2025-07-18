package Kth_Smallest_Element_In_Bst;
// Intuition
// A Binary Search Tree (BST) follows the property:
// Left subtree nodes are smaller than the root.
// Right subtree nodes are greater than the root.
// In-order traversal (Left → Root → Right) of a BST gives a sorted sequence.
// The kth smallest element will be the kth element encountered during in-order traversal.
// Approach (Recursive In-Order Traversal)
// Perform an in-order traversal to visit elements in sorted order.
// Maintain a counter (count) to track how many elements have been visited.
// Once count reaches k, store the result and stop traversal early.
// Return the stored result.

class Solution {
    private int count = 0; // Counter for tracking elements visited
    private int result = 0; // Stores the kth smallest element

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result; // Return the kth smallest element
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) return;

        // Traverse left subtree (smaller elements)
        inOrder(root.left, k);

        // Process the current node
        count++; // Increment counter
        if (count == k) {
            result = root.val; // Found kth smallest element
            return; // Stop traversal early
        }

        // Traverse right subtree (larger elements)
        inOrder(root.right, k);
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
        int k = 3;
        System.out.println("The " + k + "rd smallest element is: " + sol.kthSmallest(root, k)); // Expected: 4
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
// Iterative Approach (Using Stack)
// Instead of recursion, we use a stack for in-order traversal.
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode current = root;
//         int count = 0;

//         while (current != null || !stack.isEmpty()) {
//             // Traverse left subtree first
//             while (current != null) {
//                 stack.push(current);
//                 current = current.left;
//             }

//             // Process the current node
//             current = stack.pop();
//             count++;
//             if (count == k) return current.val; // Found kth smallest element

//             // Move to the right subtree
//             current = current.right;
//         }

//         return -1; // Should never reach here if input is valid
//     }
// }

