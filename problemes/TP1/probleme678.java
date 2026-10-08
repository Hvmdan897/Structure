package problemes.TP1;

import java.util.Stack;

public class probleme678 {
    public static void push(Stack<Integer> stack, int value) {
        stack.push(value);
        System.out.println("Pushed " + value + " onto the stack");
    }

    
    public static int pop(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = stack.pop();
        System.out.println("Popped " + popped + " from the stack");
        return popped;
    }

    public static int peek(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack.peek();
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                push(open, i);
            } else if (c == '*') {
                push(star, i);
            } else {
                if (!open.isEmpty()) {
                    pop(open);
                } else if (!star.isEmpty()) {
                    pop(star);
                } else {
                    return false;
                }
            }
        }

        while (!open.isEmpty()) {
            if (star.isEmpty()) return false;
            if (peek(open) > peek(star)) return false;
            pop(open);
            pop(star);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Chaîne \"()\" : ");
        System.out.println("Valide ? " + checkValidString("()"));

        System.out.println("Chaîne \"(*))\" : ");
        System.out.println("Valide ? " + checkValidString("(*))"));

        System.out.println("Chaîne \"*(\" : ");
        System.out.println("Valide ? " + checkValidString("*("));
    }
}