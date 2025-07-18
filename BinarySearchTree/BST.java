//All the properties of Binary tree
//Left Subtree nodes < Root
//right Subtree nodes >Root
//Left and Right Subtrees are also BST with no duplicates
//here we'll learn asumming with no duplicates but duplicates nodes can be added in to bst . It will be mentioned, when duplicate nodes will be used.
//Inorder traversal of BST gives a sorted sequence
//most problems will be solved using recursion i.e. by dividing into subproblems
//and making recursive calls on subtrees.
import java.util.ArrayList;
public class BST{
    static class Node{
        int data;
        Node left=null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            //insert in leftsubtree and return left subtree
            root.left = insert(root.left,val);
        }
        if(root.data<val){
            //similarly for right subtree
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root ==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //searching in bst 
    public static Boolean search(Node root,int key){//time complexity = o(H) where h is height of bst  
        if(root == null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        else if(root.data>key){
           return search(root.left, key);
        }
        else{
            return search(root.right,key);
        }
    }
    //Deleting nodes in bst
    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left = delete(root.left,val);
        }
        else if (root.data<val){
            root.right = delete(root.right,val);
        }
        else{//where root.data == val . that means finally we found the node to delete . so for this we have 3 cases
            //case 1 == no child
            if(root.left ==null && root.right==null){
                return null;
            }
            //case 2 = one child
            if(root.left==null) return root.right;
            else if(root.right==null){
                return root.left;
            }
            //case 3 = tow children . for this we have to find the inorderSuccesor ..IS = inorder succesor
            Node Is = inorderSuccesor(root.right);//finding IS in right subtree
            root.data = Is.data;//replace the data to be deleted with IS data
            root.right = delete(root.right,Is.data);//now delete original IS data which exist
        }
        return root;
    
    }
    public static Node inorderSuccesor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    //print in range
    public static void printInRange(Node root,int X,int Y){
        if(root==null){
            return ;
        }
        //case -1 where root lies b/w X and Y
        if(root.data>=X&&root.data<=Y){
            printInRange(root.left, X, Y);
            System.out.println(root.data+ " ");
            printInRange(root.right, X, Y);
        }
        //case -2  where x>root
        else if(root.data<=X){
            printInRange(root.right, X, Y);
        }
        else{
            printInRange(root.left, X, Y);
        }
    }
    
    //print root to leaf path
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    //another print path function in which we do not have -> at the end
    // public static void printPath(ArrayList<Integer> path){
    //     for (int i = 0; i < path.size(); i++) {
    //         if (i == path.size() - 1) {
    //             System.out.print(path.get(i)); // Avoid trailing "->"
    //         } else {
    //             System.out.print(path.get(i) + "->");
    //         }
    //     }
    //     System.out.println();
    // }
    public static void printRootToLeaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }

        path.add(root.data);//first add the root or current node to path

        if(root.left == null && root.right == null){
            printPath(path);//traverse untill the leaf node become null and print the path from root to leaf
        }
        else{
            printRootToLeaf(root.left, path);//then leftsubtree
            printRootToLeaf(root.right, path);//then right subtree
        }
        path.remove(path.size() - 1);//then remove the element to backtrack to previous element
    }

    public static void main(String args[]){
        int values[] = {8,5,6,3,10,11,14};
        Node root = null;
        //now run a loop which will traverse through our values array
        for(int i =0;i<values.length;i++){
            //it will pick one one value and insert in root
            root = insert(root,values[i]);
        }
        inorder(root);
        // if(search(root, 2)){
        //     System.out.println("key found");
        // }else System.out.println("Not found");
        // delete(root, 4);
        // System.out.println();
        // inorder(root);
        System.out.println();
        // printInRange(root, 4, 7);
        printRootToLeaf(root, new ArrayList<>());
    }
}