import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by winney on 15/11/24.
 */
public class combinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An   integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cache = new ArrayList<Integer>();
        Arrays.sort(candidates);
        int len = candidates.length;
        combinationSum(res, cache, candidates, target, 0);
        return res;
    }

    public void combinationSum(List<List<Integer>> res, List<Integer> cache, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(cache);
            return;
        } else if (target < 0 || target < candidates[0]) {
            return;
        }
        int len = candidates.length;
        for (int i = index; i < len; i++) {
            if (candidates[i] <= target) {
                int tmp = target - candidates[i];
                ArrayList<Integer> cacheT = new ArrayList<Integer>(cache);
                cacheT.add(candidates[i]);
                combinationSum(res, cacheT, candidates, tmp, i);
            }
        }
    }
}
