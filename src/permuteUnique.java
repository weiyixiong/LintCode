import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by winney on 15/12/14.
 */
public class permuteUnique {
    public static void main(String[] args) {
        ArrayList<Integer> S = new ArrayList<>();
        S.add(1);
        S.add(2);
        S.add(3);
        ArrayList<ArrayList<Integer>> res = permuteUnique(S);

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
            }
            System.out.println();
        }
    }


    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Collections.sort(S);
        pickNumbers(S, 0, res, new ArrayList<>(), new int[S.size()]);
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
