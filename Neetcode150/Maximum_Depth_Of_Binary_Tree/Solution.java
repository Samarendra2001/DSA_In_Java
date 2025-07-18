package Maximum_Depth_Of_Binary_Tree;
public class Solution {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = left;
            this.right  = right;
        }
    }
    public static int depthOfaTree(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(depthOfaTree(root.left), depthOfaTree(root.right)) + 1;
    }
    public static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void main(String args[]){
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        preOrder(root);
        System.out.println();
        System.out.print(depthOfaTree(root));

    }
}
