import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by winney on 15/12/15.
 */
public class permute {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Collections.sort(nums);
        pickNumbers(nums, 0, res, new ArrayList<>(), new int[nums.size()]);
        return res;
    }

    private static void pickNumbers(ArrayList<Integer> s, int i, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> integers, int[] flag) {
        if (i == s.size()) {
            res.add(integers);
            return;
        }
        for (int j = 0; j < s.size(); j++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(integers);
            int[] flagCp = flag.clone();
            tmp.add(s.get(j));
            flagCp[j] = 1;
            if (flag[j] != 1) {
                pickNumbers(s, i + 1, res, tmp, flagCp);
            }
        }
    }
}