import java.util.Stack;

/**
 * Created by winney on 16/1/18.
 */
public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                return 0;
            }
        }
    }

    public int top() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (!stack2.isEmpty()) {
                return stack2.peek();
            } else {
                return 0;
            }
        }

    }

}
