import java.util.ArrayList;
import java.util.List;

/**
 * Created by winney on 15/11/21.
 */
public class combine {

    public static List<List<Integer>> combine(int n, int k) {
        long size = n;
        long size2 = k;
        for (int i = 0; i < k - 1; i++) {
            size *= n - i - 1;
            size2 *= k - i - 1;
        }
        size /= size2;
        if (size == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cache = new ArrayList<Integer>(k);
        for (int i = 1; i <= k; i++) {
            cache.add(i);
        }
        int last = k - 1;
        int index = 0;
        int lastBak = last;
        int indexBak = index;
        for (int i = 0; i < size; i++) {
            res.add(new ArrayList<>(cache));
            cache.set(last, cache.get(last) + 1);
            lastBak = last;
            indexBak = index;
            while (lastBak > 0 && cache.get(lastBak) > n - indexBak) {
                lastBak--;
                indexBak++;
                cache.set(lastBak, cache.get(lastBak) + 1);
            }
            if (lastBak != last) {
                while (lastBak < k - 1) {
                    cache.set(lastBak + 1, cache.get(lastBak++) + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        combine(15, 14);
    }
}
