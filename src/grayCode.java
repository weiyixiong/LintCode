import java.util.ArrayList;

/**
 * Created by winney on 16/5/4.
 */
public class grayCode {

    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        grayCodeHelper(res, n - 1, 0, 0, true, true);
        grayCodeHelper(res, n - 1, 0, 1, false, true);
        return res;
    }

    public void grayCodeHelper(ArrayList<Integer> res, int n, int init, int data, boolean first, boolean tmp) {
        if (!tmp) {
            data <<= 1;
            data += init;
        }
        if (n == 0) {
            res.add(data);
            return;
        }
        n--;
        if (first) {
            grayCodeHelper(res, n, 0, data, true, false);
            grayCodeHelper(res, n, 1, data, false, false);
        } else {
            grayCodeHelper(res, n, 1, data, true, false);
            grayCodeHelper(res, n, 0, data, false, false);
        }


    }
}
