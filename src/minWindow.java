import java.util.HashMap;
import java.util.Map;

/**
 * Created by winney on 16/5/11.
 */
public class minWindow {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     * Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (source.isEmpty() || target.isEmpty()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray()) {
            if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int start = -1;
        int end = 0;
        int i = 0;
        Map<Character, Integer> tmpMap = new HashMap<>(map);
        for (char c : source.toCharArray()) {
            if (tmpMap.get(c) != null) {
                if (start == -1) {
                    start = i;
                }
                if (tmpMap.get(c) == 1) {
                    tmpMap.remove(c);
                } else {
                    tmpMap.put(c, tmpMap.get(c) - 1);
                }
                if (tmpMap.isEmpty()) {
                    end = i;
                }
            }
            i++;
        }
        int start2 = 0;
        tmpMap = new HashMap<>(map);
        for (int j = end; j > 0; j--) {
            char c = source.charAt(j);
            if (tmpMap.get(c) != null) {
                if (tmpMap.get(c) == 1) {
                    tmpMap.remove(c);
                } else {
                    tmpMap.put(c, tmpMap.get(c) - 1);
                }
                if (tmpMap.isEmpty()) {
                    start2 = j;
                }
            }
        }
        if (end + 1 - start < target.length()) {
            return "";
        }

        return source.substring(start2, end + 1);


    }
}
