package problemes.TP1;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        System.out.println("Pushed " + x + " onto the stack");
    }

    public int pop() {
        int popped = q1.remove();
        System.out.println("Popped " + popped + " from the stack");
        return popped;
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

public class probleme225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        System.out.println("Top element: " + myStack.top());

        myStack.pop();
        System.out.println("Stack empty ? " + myStack.empty());

        myStack.push(3);
        System.out.println("Top element: " + myStack.top());

        myStack.pop();
        myStack.pop();
        System.out.println("Stack empty ? " + myStack.empty());
    }
}