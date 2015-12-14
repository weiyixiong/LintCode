import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by winney on 15/12/7.
 */
public class subsetsWithDup {

    public static void main(String[] args) {
        ArrayList<Integer> S = new ArrayList<>();
        S.add(1);
        S.add(2);
        S.add(2);
        ArrayList<ArrayList<Integer>> res = subsetsWithDup(S);

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
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Collections.sort(S);
        pickNumbers(S, 0, res, new ArrayList<>());
        return res;
    }

    private static void pickNumbers(ArrayList<Integer> s, int i, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> integers) {
        res.add(integers);
        if (i == s.size()) {
            return;
        }
        String last = null;
        for (int j = i; j < s.size(); j++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(integers);
            tmp.add(s.get(j));
            if (last != null && !last.equals(Arrays.toString(tmp.toArray())) || last == null) {
                last = Arrays.toString(tmp.toArray());
                pickNumbers(s, j + 1, res, tmp);
            }
        }
    }
}
