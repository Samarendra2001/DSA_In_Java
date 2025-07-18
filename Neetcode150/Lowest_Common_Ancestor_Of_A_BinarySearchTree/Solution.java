package Lowest_Common_Ancestor_Of_A_BinarySearchTree;
// Intuition:
// The problem requires us to find the Lowest Common Ancestor (LCA) of two given nodes p and q in a Binary Search Tree (BST).

// In a BST, the left subtree contains smaller values, and the right subtree contains larger values.
// The LCA is the node where p and q split into different subtrees OR one of them is the root itself.
// Approach:
// Compare Values:
// If both p and q are greater than root.val, it means they lie in the right subtree.
// If both p and q are smaller than root.val, it means they lie in the left subtree.
// Otherwise, the root is the LCA, as it is the lowest node where p and q are in different subtrees.
// Recursive Calls:
// If p and q are both in the right subtree, recursively call lowestCommonAncestor(root.right, p, q).
// If p and q are both in the left subtree, recursively call lowestCommonAncestor(root.left, p, q).
// If neither of the above conditions is met, return the root (it is the LCA).
// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//     while (root != null) {
//         // If both p and q are greater than root, LCA must be in the right subtree
//         if (p.val > root.val && q.val > root.val) {
//             root = root.right;
//         }
//         // If both p and q are smaller than root, LCA must be in the left subtree
//         else if (p.val < root.val && q.val < root.val) {
//             root = root.left;
//         }
//         // If p and q are on different sides, or one is equal to root, then root is the LCA
//         else {
//             return root;
//         }
//     }
//     return null;
// }//iterative way
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Get the values of the root, p, and q
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        // If both p and q are greater than the root, search in the right subtree
        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If both p and q are smaller than the root, search in the left subtree
        if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If p and q are on different sides (or one is the root), the current node is the LCA
        return root;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Constructing a sample BST:
        //         6
        //        / \
        //       2   8
        //      / \  / \
        //     0   4 7  9
        //        / \
        //       3   5

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        Solution sol = new Solution();
        TreeNode lca = sol.lowestCommonAncestor(root, root.left, root.left.right); // Finding LCA of 2 and 4

        System.out.println("Lowest Common Ancestor: " + lca.val);
        // Expected output: 2 (since 2 is the ancestor of 4)
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

