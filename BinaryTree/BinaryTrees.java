import java.util.*;
//tree is non-linear or hirerchichal data structure
//binary tree has maximum two children 
//-1 represent null
//preorder = root->left->right
//inorder = left-root->right
//postorder =left->right->root
public class BinaryTrees{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(idx>=nodes.length || nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;//here it returns the newNode which is eventually root and it assigns to Node root in main function.
        }
    }

    public static void preorder(Node root){
        if(root==null){
            //System.out.println(-1);if want to print -1
            return;
        }
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
    //level order traversal
    public static void levelOrder(Node root){
        //first create a queue of linkedlist
        Queue<Node> q = new LinkedList<>();
        //1st add root and null;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();//remove the currnode or root
            if(currNode==null){ //and check if after removing curr node ,if curr node become null that means we have to print the data for 2nd line
                System.out.println();//so that's why we use a line break.  
                if(q.isEmpty()){//then if queue become empty then break the loop
                    break;
                }else{
                    q.add(null);//if queue is not empty then add null
                }
            }else{
                System.out.print(currNode.data+" ");//then print curr node data
                if(currNode.left!=null){
                    q.add(currNode.left);//its left child
                }
                if(currNode.right!=null){
                    q.add(currNode.right);//its right child
                }
            }
        }
    }
    //total count of nodes problem 
    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes+rightNodes+1;
    }
    //Sum of Nodes
    public static int sumOfNodes(Node root){
        if(root ==null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right) ;
        return  leftSum+rightSum+root.data ;
    }
    //here you might be wondering how the same code is working both for count and sum
    //key difference is only adding 1 and adding root data. this is due to recursion
    //see when it will call left sum for root(1), it will go to sumofNodes(2) and
    //it it self call for its lefttree with a root and if it is empty then it will return root.data.
    //root.data is for each and every subtree not for one main tree 
    //Dont confuse

    //Height of a Tree

    public static int heightOfTree(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(heightOfTree(root.left),heightOfTree(root.right))+1;
    }

    //Diameter of a Tree = Number of Nodes in the Longest path between any 2 nodes
    public static int diameterOfTree(Node root){
        if(root==null){
            return 0;
        }
        int diam1 = diameterOfTree(root.left);
        int diam2 = diameterOfTree(root.right);
        int diam3 = heightOfTree(root.left)+heightOfTree(root.right)+1;

        return Math.max(diam3,Math.max(diam2,diam1));
    }

    //diameter of tree - o(N) approach
    // public static int diameter2nd(Node root){
    //     if(root == null){
    //         return 0;
    //     }
        
    // }

    //Subtree of another tree
    public static boolean isIdentical(Node root,Node subRoot){
        if(root==null && subRoot==null){ //for leaf node
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }
        if(root.data ==subRoot.data){ //if data matches then check for left and right subtree recursively
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }
    public static boolean isSubtree(Node root,Node subRoot){
        if(subRoot==null){//it means there is no subtree. so always true
            return true;
        }
        if(root==null){//if there is no main tree then false
            return false;
        }
        if(root.data==subRoot.data){//if root matches in both tree
            if(isIdentical(root,subRoot)){//then we'll check whether its subtree is identical or not in isIdentical function
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);//similarly for left and right subtree
    }

    public static void main(String args[]){
        int nodes []= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //this can also be done but as it was declared static no point using instances of it
        //we can directly accesss the class methods without creating object or instances
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        int subTreenodes[] = {2,4,5};
        //BinaryTree.idx = -1;
        Node root = BinaryTree.buildTree(nodes);
        //BinaryTree.idx = -1;
        Node subRoot = BinaryTree.buildTree(subTreenodes);
        //also we can write in the following way
        // Node subRoot = new Node(2);
        // subRoot.right = new Node(5);
        // subRoot.left = new Node(4);
        //System.out.println(root.data);
        //preorder(root);
        // System.out.print("Here is Inorder traversal");
        // inorder(root);
        postorder(root);
        int totalNodes = countOfNodes(root);
        System.out.println("Total no of Nodes are " + totalNodes);
        System.out.println(sumOfNodes(root));
        System.out.println(heightOfTree(root));
        System.out.println(diameterOfTree(root));
        levelOrder(root);
        if(isSubtree(root, subRoot)){
            System.out.println("is a subtree");
        }else{
            System.out.println("not a subtree");
        }
    }
}