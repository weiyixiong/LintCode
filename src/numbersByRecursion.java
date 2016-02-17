import java.util.ArrayList;
import java.util.List;

/**
 * Created by winney on 16/2/3.
 */
public class numbersByRecursion {
    /**
     * @param n: An integer.
     *           return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {

        List<Integer> res = new ArrayList<Integer>();

        RrecursionHelper(res, 1, n, 1);
        return res;
    }

    public void RrecursionHelper(List<Integer> src, int start, int n, int len) {
        if (n == 0) {
            return;
        }
        for (int i = start; ; i++) {
            if ((i + "").length() == len) {
                src.add(i);
            } else if ((i + "").length() > len) {
                RrecursionHelper(src, i, n - 1, len + 1);
                return;
            }
        }

    }


}
