package Serialize_And_Deserialize_BinaryTree;
// 🚀 Intuition:
// Serialization (Converting Tree → String):

// Use preorder traversal (root → left → right) to store the tree in a string.
// Represent null nodes explicitly as "null" to preserve the structure.
// Use a comma "," as a delimiter between values.
// Deserialization (Converting String → Tree):

// Convert the serialized string back into a tree using preorder traversal.
// Read values from the string in the same order as they were stored.
// If the value is "null", return null (indicating no node exists at that position).
// 📌 Approach:
// Serialization (Tree to String)

// Recursively traverse the tree in preorder.
// Append each node’s value to a string.
// If a node is null, append "null".
// Return the complete serialized string.
// Deserialization (String to Tree)

// Convert the serialized string into a list of values.
// Read values one by one.
// If a value is "null", return null.
// Otherwise, create a node and recursively build its left and right children.
// Return the root node of the reconstructed tree.
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Solution {

    // Helper function for serialization using preorder traversal
    private String recserialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,"; // Represent null nodes explicitly
        } else {
            str += root.val + ","; // Append current node's value
            str = recserialize(root.left, str); // Serialize left subtree
            str = recserialize(root.right, str); // Serialize right subtree
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recserialize(root, ""); // Start serialization from root
    }

    // Helper function for deserialization
    private TreeNode recdeserialize(List<String> strs) {
        if (strs.get(0).equals("null")) { // If current value is null, return null node
            strs.remove(0);
            return null;
        }

        // Create a new node with the current value
        TreeNode root = new TreeNode(Integer.valueOf(strs.get(0)));
        strs.remove(0); // Remove processed value

        // Recursively build left and right subtrees
        root.left = recdeserialize(strs);
        root.right = recdeserialize(strs);

        return root; // Return the reconstructed tree
    }

    // Decodes encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(","); // Split serialized string into values
        List<String> strList = new LinkedList<>(Arrays.asList(strArray)); // Convert to list
        return recdeserialize(strList); // Start deserialization from root
    }

    // Function to test serialization and deserialization
    public static void main(String[] args) {
        Solution codec = new Solution();

        // Construct the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the tree
        String serializedTree = codec.serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

        // Deserialize back to tree
        TreeNode deserialize = codec.deserialize(serializedTree);
        System.out.println("Tree Deserialized Successfully!");
    }
}

// Deserialization Steps:
// Read "1" → Create TreeNode(1), process left subtree.
// Read "2" → Create TreeNode(2), process left (null), right (null).
// Read "3" → Create TreeNode(3), process left subtree.
// Read "4" → Create TreeNode(4), process left (null), right (null).
// Read "5" → Create TreeNode(5), process left (null), right (null).
// 1
// / \
// 2   3
//   / \
//  4   5
// Time Complexity: O(N) for both serialization and deserialization, where N is the number of nodes in the tree.