import java.util.*;

/**
 * Created by winney on 15/12/15.
 */
public class findLadders {
    //[qa, ya, yb, sb, sq]
    public static void main(String[] args) {
        String[] test = {
                "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};

        Set<String> dict = new HashSet<>();
        for (String t : test) {
            dict.add(t);
        }
        long time = System.currentTimeMillis();
        List<List<String>> res = findLadders2("qa", "sq", dict);
        System.out.print(System.currentTimeMillis() - time);
        System.out.println("===============================" + res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Queue<List<String>> cache = new LinkedList<>();
        Map<String, Integer> min = new HashMap<>();
        List<String> tmp = new ArrayList<>();
        tmp.add(start);
        cache.add(tmp);
        List<List<String>> res = new ArrayList<List<String>>();
        int minLen = Integer.MAX_VALUE;
        while (!cache.isEmpty()) {
            List<String> path = cache.poll();
            if (path.size() > minLen) {
                continue;
            }
            String startItem = path.get(path.size() - 1);
            if (startItem.equals(end) && path.size() <= minLen) {
                if (path.size() < minLen) {
                    res = new ArrayList<List<String>>();
                    minLen = path.size();
                }
                res.add(path);
                continue;
            }

            char[] tmpStr;
            String tmpString;
            for (int i = 'a'; i <= 'z'; i++) {
                for (int j = 0; j < startItem.length(); j++) {
                    tmpStr = startItem.toCharArray();
                    tmpStr[j] = (char) i;
                    tmpString = new String(tmpStr);
                    if (dict.contains(tmpString)) {
                        if (min.get(tmpString) == null || min.get(tmpString) >= path.size()) {
                            List<String> listTmp = new ArrayList<>(path);
                            listTmp.add(tmpString);
                            cache.add(listTmp);
                            min.put(tmpString, path.size());
                        }
                    }
                }
            }
        }
        return res;
    }


    /**
     * @param start, a string
     * @param end,   a string
     * @param dict,  a set of string
     * @return a list of lists of string
     */
    public static List<List<String>> findLadders2(String start, String end, Set<String> dict) {
        Queue<List<String>> cache = new LinkedList<>();
        Map<String, Integer> min = new HashMap<>();
        List<String> tmp = new ArrayList<>();
        List<String> lastRes = new ArrayList<>();
        String last = null;
        tmp.add(start);
        cache.add(tmp);
        List<List<String>> res = new ArrayList<List<String>>();
        int minLen = Integer.MAX_VALUE;
        while (!cache.isEmpty()) {
            List<String> path = cache.poll();
            if (path.size() > minLen) {
                continue;
            }
            String startItem = path.get(path.size() - 1);
            if (startItem.equals(end) && path.size() <= minLen) {
                if (path.size() < minLen) {
                    res = new ArrayList<List<String>>();
                    minLen = path.size();
                }
                res.add(path);
                continue;
            }
            if (last == null || !last.equals(startItem)) {
                lastRes.clear();
                last = startItem;
            } else {
                for (int i = 0; i < lastRes.size(); i++) {
                    String target = lastRes.get(i);
                    List<String> listTmp = new ArrayList<>(path);
                    listTmp.add(target);
                    cache.add(listTmp);
                    min.put(target, path.size());
                }
                continue;
            }

            Iterator<String> it = dict.iterator();
            while (it.hasNext()) {
                String target = it.next();
                if (calcDis(startItem, target, path)) {
                    lastRes.add(target);
                    if (min.get(target) == null || min.get(target) >= path.size()) {
                        List<String> listTmp = new ArrayList<>(path);
                        listTmp.add(target);
                        cache.add(listTmp);
                        min.put(target, path.size());
                    } else {
                        it.remove();
                    }
                }
            }
        }
        return res;
    }

    public static boolean calcDis(String start, String end, List<String> path) {
        int dis = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                dis++;
            }
        }
        return dis == 1 && !path.contains(end);
    }
}
