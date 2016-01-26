import java.util.*;

/**
 * Created by winney on 15/12/4.
 */
public class ladderLength {
    /**
     * @param start, a string
     * @param end,   a string
     * @param dict,  a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        java.util.Queue<List<String>> cache = new LinkedList<>();
        Map<String, Integer> min = new HashMap<>();
        List<String> tmp = new ArrayList<>();
        tmp.add(start);
        cache.add(tmp);
        while (!cache.isEmpty()) {
            List<String> path = cache.poll();
            String startItem = path.get(path.size() - 1);
            if (startItem.equals(end)) {
                return path.size();
            }
            for (String target : dict) {
                if (calcDis(startItem, target, path)) {
                    if (min.get(target) == null || min.get(target) > path.size()) {
                        List<String> listTmp = new ArrayList<>(path);
                        listTmp.add(target);
                        cache.add(listTmp);
                        min.put(target, path.size());
                    }
                }
            }
        }
        return 0;
    }


    public boolean calcDis(String start, String end, List<String> path) {
        int dis = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                dis++;
            }
        }
        return dis == 1 && !path.contains(end);
    }
}
