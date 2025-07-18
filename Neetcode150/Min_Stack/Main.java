package Min_Stack;

// Intuition
// We need to implement a stack that supports push, pop, top, and getMin in constant time (O(1)).
// The problem is maintaining the minimum value efficiently.
// Instead of using an additional data structure, we can modify each node in the stack to store the minimum value at that point.
// We use a custom Node class to keep track of:
// val → The actual stack value.
// min → The minimum value at that stack level.
// next → A reference to the next node.
class MinStack {
    private Node head; // The head (top) of the stack

    /** Initialize the stack (empty initially) */
    public MinStack() {
        head = null;
    }
      /** Custom Node class to store value, min, and reference to next node */
      private class Node {
        int val;  // Value of node
        int min;  // Minimum value up to this node
        Node next; // Reference to next node in stack
        
        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    /** Push a new value onto the stack */
    public void push(int val) {
        // If the stack is empty, the new node becomes the head with val as min
        if (head == null) {
            head = new Node(val, val, null);
        } 
        else {
            // Otherwise, create a new node where min is the minimum of current val and previous min
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    /** Remove the top element from the stack */
    public void pop() {
        if (head != null) {
            head = head.next; // Move head pointer to next node
        }
    }
    
    /** Get the top element of the stack */
    public int top() {
        return head.val;
    }
    
    /** Retrieve the minimum element in the stack */
    public int getMin() {
        return head.min;
    }
    
}

// **Main Class to Test the MinStack**
public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        
        // **Test Cases**
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // ✅ Expected Output: -3
        minStack.pop();
        System.out.println(minStack.top());    // ✅ Expected Output: 0
        System.out.println(minStack.getMin()); // ✅ Expected Output: -2
    }
}
