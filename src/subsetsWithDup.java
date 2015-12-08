import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by winney on 15/12/7.
 */
public class subsetsWithDup {

    public static void main(String[] args) {
//        System.out.print(solveNQueens(4));
        ArrayList<Integer> S = new ArrayList<>();
        S.add(1);
        S.add(2);
        S.add(2);
//        S.add(3);
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
        for (int i = 0; i <= S.size(); i++) {
            pickNumbers(S, i, res, new ArrayList<>());
        }
        return res;
    }

    private static void pickNumbers(ArrayList<Integer> s, int i, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> integers) {
        if (i == 0) {
//            System.out.print(Arrays.toString(integers.toArray()));
            if (!res.contains(integers)) {
                res.add(integers);
            }
            return;
        }
        for (int j = 0; j < s.size(); j++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(integers);
//            if (!integers.contains(s.get(j))) {
            tmp.add(s.get(j));
//            }
            pickNumbers(s, i - 1, res, tmp);
        }
    }
}
