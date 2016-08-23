/**
 * Created by winney on 16/8/22.
 */
public class reverseInteger {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        int result = 0;
        boolean isMinus = n < 0;
        int lastRes = 0;
        while (Math.abs(n) > 0) {
            result *= 10;
            result += (Math.abs(n) % 10);
            if (result != 0 && result * 10 / result != 10 && (Math.abs(n) % 10) != 0) {
                return 0;
            }
            n /= 10;
            lastRes = result;
        }
        if (isMinus) {
            result *= -1;
        }
        return result;
    }
}
