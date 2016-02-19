import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by winney on 16/2/19.
 */
public class validTree {


    /**
     * @param n     an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> cache = new HashMap<>();
        if (n > edges.length + 1) {
            return false;
        }
        for (int i = 0; i < edges.length; i++) {
            if (cache.get(edges[i][0]) == null) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(edges[i][1]);
                cache.put(edges[i][0], tmp);
            } else {
                cache.get(edges[i][0]).add(edges[i][1]);
            }
        }
        boolean res = true;
        for (int i = 0; i < n; i++) {
            res &= valid(cache, new boolean[n], i);
        }

        return res;
    }

    public boolean valid(HashMap<Integer, ArrayList<Integer>> edges, boolean[] visit, int start) {
        boolean res = true;
        ArrayList<Integer> tmp = edges.get(start);
        if (tmp == null) {
            return true;
        }
        for (Integer integer : tmp) {
            if (visit[integer] == true) {
                res = false;
            }
            visit[integer] = true;
            res |= valid(edges, visit, start);
        }
        return res;

    }
}
