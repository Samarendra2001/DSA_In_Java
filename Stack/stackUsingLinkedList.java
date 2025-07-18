

public class stackUsingLinkedList {
     class Node{
        int data;
        Node next;
        //constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    class Stack{
        public Node head;
        //check if stack empty or not
        public boolean isEmpty(){
            return head == null;
        }
        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head= head.next;
            return top;
        }
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String args[]){
        stackUsingLinkedList outer = new stackUsingLinkedList(); // Outer class instance
        Stack s1 = outer.new Stack(); // Inner class instance through outer class
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        while(!s1.isEmpty()){
            System.out.println(s1.peek());
            s1.pop();
        }
    }
}
