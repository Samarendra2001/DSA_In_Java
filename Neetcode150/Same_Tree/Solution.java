package Same_Tree;

public class Solution {
    // Definition of a TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor to initialize node value
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to check if two trees are the same
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, trees are identical
        if (p == null && q == null) {
            return true;
        }

        // If one of the nodes is null (but not both), trees are different
        if (p == null || q == null) {
            return false;
        }

        // If values of the current nodes do not match, trees are different
        if (p.val != q.val) {
            return false;
        }

        // Recursively check if left and right subtrees are the same
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Constructing Tree 1
        //        1
        //      /   \
        //     2     3
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        // Constructing Tree 2 (Same structure and values as Tree 1)
        //        1
        //      /   \
        //     2     3
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        // Constructing Tree 3 (Different structure)
        //        1
        //      /   
        //     2     
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);

        // Test cases
        System.out.println("Tree1 and Tree2 are same: " + solution.isSameTree(tree1, tree2)); // true
        System.out.println("Tree1 and Tree3 are same: " + solution.isSameTree(tree1, tree3)); // false
    }
}

