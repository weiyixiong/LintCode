/**
 * Created by winney on 15/12/22.
 */
public class climbStairs {
    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 3) {
            return n;
        }
        int[] path = new int[n + 1];
        for (int i = 0; i <= 3; i++) {
            path[i] = i;
        }
        for (int i = 3; i <= n; i++) {
            path[i] = path[i - 1] + path[i - 2];
        }
        return path[n];
    }

    /**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs2(int n) {
        if (n <= 3) {
            return n;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(climbStairs(i) + " ");
            System.out.println(climbStairs2(i));
        }
    }
}
