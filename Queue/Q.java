package Queue;

public class Q {
    static class Queue{
        static int arr[];
        static int size;
        static int rear = -1;
        Queue(int n){
            arr = new int[n];
            this.size = n;
        }
        public static boolean isEmpty(){
            return rear ==-1;
        }
        //enque or adding
        public static void add(int data){
            if(rear == size-1){
                System.out.println("Full Queue");
                return;
            }
            rear ++;
            arr[rear] = data;
        }
        //deque or remove 
        
    }
    public static void main(){

    }
}
