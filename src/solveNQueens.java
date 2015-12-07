import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by winney on 15/12/4.
 */
public class solveNQueens {

    public static void main(String[] args) {
//        System.out.print(solveNQueens(4));
        ArrayList<ArrayList<String>> res = solveNQueens2(9);
        System.out.print(res
                .size());
        for (int i = 0; i < res.size(); i++) {
//            for (int j = 0; j < res.get(i).size(); j++) {
//                System.out.println(res.get(i).get(j));
//            }
//            System.out.println();
//            System.out.println();
//            System.out.println();
        }
    }


    /**
     * Get all distinct N-Queen solutions
     *
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    static ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

        int[] calcCache = new int[n];
        for (int i = 0; i < n; i++) {
            calcCache[i] = i;
        }
        int y = n - 1;
        for (; ; ) {
            if (judge(calcCache, calcCache.length, n)) {
                res.add(recordRes(calcCache));
            }
            while (y > 0 && calcCache[y] == n - 1) {
                calcCache[y--] = 0;
                if (y == 0 && calcCache[y] == n - 1) {
                    return res;
                }
            }
            calcCache[y]++;
            y = n - 1;

        }
    }

    static ArrayList<ArrayList<String>> solveNQueens2(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        int[] calcCache = new int[n];
        solveNQueensHelper(calcCache, res, n, 0);

        return res;
    }

    static void solveNQueensHelper(int[] calcCache, ArrayList<ArrayList<String>> res, int n, int index) {
        if (n == index) {
            if (judge(calcCache, calcCache.length, n)) {
                res.add(recordRes(calcCache));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (judge(calcCache, index, n)) {
                for (int j = 0; j < n; j++) {
                    System.out.print(calcCache[j]);
                }
                System.out.println();
                solveNQueensHelper(calcCache.clone(), res, n, index + 1);
            }
            calcCache[index]++;

        }
    }

    public static ArrayList<String> recordRes(int[] target) {
        int n = target.length;
        ArrayList<String> res = new ArrayList<>(target.length);
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == target[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static boolean judge(int[] x, int n, int all) {
        int[] tmp = new int[all];
        for (int i = 0; i < n; i++) {
            if (tmp[x[i]] == 0) {
                tmp[x[i]] = 1;
            } else {
                return false;
            }
            for (int j = 1; i + j < n; j++) {
                if (i < n - 1 && Math.abs(x[i + j] - x[i]) == j) {
                    return false;
                }
            }

        }

        return true;
    }

}
