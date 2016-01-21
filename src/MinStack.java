import java.util.InputMismatchException;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;

/**
 * Created by winney on 16/1/18.
 */
public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public MinStack() {
        // do initialize if necessary
        stack = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        min = Math.min(min, number);
    }

    public int pop() {
        // write your code here
        int res = stack.pop();
        if (res == min) {
            min = Integer.MAX_VALUE;
            for (Integer integer : stack) {
                min = Math.min(min, integer);
            }
        }
        return res;
    }

    public int min() {
        // write your code here
        return min;
    }

}
