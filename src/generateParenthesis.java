import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 * Created by winney on 16/2/18.
 */
public class generateParenthesis {


    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        genHelper(res, n, 0, "");
        return res;
    }

    public void genHelper(ArrayList<String> res, int n, int left, String gen) {
        if (n == 0) {
            res.add(gen);
            return;
        }
        if (left != 0) {
            genHelper(res, n - 1, left - 1, gen + ")");
        }
        if (left < n) {
            genHelper(res, n, left + 1, gen + "(");
        }

    }

}
