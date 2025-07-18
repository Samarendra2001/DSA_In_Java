
import java.util.*;
// class LL {
//     Node head;
//     private int size;
//     LL(){
//         this.size =0;
//     }
//     class Node{
//         String data;
//         Node next;

//        Node(String data){
//         this.data = data;
//         this.next = null;
//         size++;
//     }
//  }
//  //add at first node
//  public void addFirst(String data){
//     //first check if head is null
//     //so head is null that means ll is not exist so 1st we
//     //have to create a new node
//     Node newNode = new Node(data);
//     if(head==null){
//         head = newNode;
//         return;
//     }
//     newNode.next = head;
//     head = newNode;
//  }
//  //add last of a ll
//  public void addLast(String data){
//     Node newNode = new Node(data);
//     if(head == null){
//         newNode.next = head;
//         head = newNode;
//         return;
//     }
//     Node currNode = head;
//     while(currNode.next != null){
//         currNode = currNode.next;
//     }
//     currNode.next = newNode;
//  }
//  //Delete First
//  public void deleteFirst(){
//     if(head == null){
//         System.out.println("list is empty");
//         return;
//     }
//     size--;
//     head= head.next;
//  }
//  //delete last node
//  public void deletelast(){
//     if(head == null){
//         System.out.println("list is empty");
//         return;
//     }
//     size--;
//     //this corner case is bcz suppose list has only one node that is head
//     if(head.next==null){
//         head = null;
//         return;
//     }
//     Node secondLast = head;
//     Node lastNode = head.next;
//     while (lastNode.next!=null) {
//         lastNode = lastNode.next;
//         secondLast = secondLast.next;
//     }
//     secondLast.next = null;
//  }
//    //print
//  public void printList(){
//     if(head == null){
//         System.out.println("list is empty");
//         return;
//     }
//     Node currNode = head;
//     while(currNode !=null){
//         System.out.print(currNode.data +"->");
//         currNode = currNode.next;
//     }
//     System.out.println("NULL");
//  }
// public int getSize(){
//     return size;
// }
public class LL{
    public static void main(String args[]){
        //LL list = new LL();
        LinkedList<String>list=new LinkedList<String>();
        list.addFirst("S");
        list.addFirst("a");
        list.addFirst("m");
        list.addLast("Barick");
        // list.printList();
        // list.deleteFirst();
        // list.deletelast();
        // list.printList();
        // System.out.println(list.getSize());
        System.out.println(list.size());
        System.out.println(list);
        for(int i =0;i<list.size();i++){
            System.out.print(list.get(i)+" -> ");
        }
        System.out.println("null");
        list.removeFirst();
        list.removeLast();
        System.out.println(list);

     }
     
}
