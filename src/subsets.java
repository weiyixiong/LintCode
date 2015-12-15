import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by winney on 15/12/14.
 */
public class subsets {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        pickNumbers(nums, 0, res, new ArrayList<Integer>());
        return res;
    }

    private void pickNumbers(int[] s, int i, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> integers) {
        res.add(integers);
        if (i == s.length) {
            return;
        }
        for (int j = i; j < s.length; j++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(integers);
            tmp.add(s[j]);
            pickNumbers(s, j + 1, res, tmp);
        }
    }
}
