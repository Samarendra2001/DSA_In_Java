import java.util.*;

public class stackUsingArrayList {
    static class Stack{
        static ArrayList<Integer>list=new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }
        //push
        public static void push(int data){
            list.add(data);
        }
        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.get(list.size()-1));
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[]){
        //in static case we can directly push and pop to stack without creating a stack s1
        Stack.push(10);
        Stack.push(20);
        Stack.push(30);
        Stack.push(40);
        while(!Stack.isEmpty()){
            System.out.println(Stack.peek());
            Stack.pop();
    }
        }
        
}
