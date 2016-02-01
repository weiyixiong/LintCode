/**
 * Created by winney on 16/2/1.
 */
public class fibonacci {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int num = 0;
            int num2 = 1;
            int num3 = 3;
            for (int i = 0; i < n - 2; i++) {
                if (i % 3 == 0) {
                    num3 = num + num2;
                } else if (i % 3 == 1) {
                    num = num3 + num2;
                } else {
                    num2 = num3 + num;
                }
            }
            return Math.max(num, Math.max(num2, num3));
        }
    }

}
