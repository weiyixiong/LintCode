import java.util.HashSet;

/**
 * Created by winney on 16/2/17.
 */
public class isHappy {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        HashSet<Integer> history = new HashSet<>();
        int tmp = n;
        while (!history.contains(tmp)) {
            int tmp2 = 0;
            history.add(tmp);
            while (tmp > 0) {
                tmp2 += Math.pow(tmp % 10, 2);
                tmp = tmp / 10;
            }
            if (tmp2 == 1) {
                return true;
            }
            tmp = tmp2;
        }
        return false;
    }

}
