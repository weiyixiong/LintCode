import java.util.*;

/**
 * Created by winney on 16/1/27.
 */
public class largestRectangleArea {
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
                for (Integer integer : stack) {
                    System.err.print(integer);
                }
                System.err.println();
            }

            stack.push(i);
        }

        return max;
    }

    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public static int largestRectangleArea2(int[] height) {
        int maxArea = 0;
        Set<Integer> standard = new HashSet<>();
        for (int i = 0; i < height.length; i++) {
            standard.add(height[i]);
        }
        for (Integer integer : standard) {
            int tmpArea = 0;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= integer && height[j] > 0) {
                    tmpArea += integer;
                    maxArea = Math.max(maxArea, tmpArea);
                } else {
                    tmpArea = 0;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] test = {2, 1, 5, 6, 2, 3};
        largestRectangleArea(test);
        largestRectangleArea2(test);

    }

}
