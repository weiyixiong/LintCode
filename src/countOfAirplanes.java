import java.util.*;
import java.util.regex.Matcher;

/**
 * Created by winney on 16/2/17.
 */
public class countOfAirplanes {

    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (Interval airplane : airplanes) {
            for (int i = airplane.start; i < airplane.end; i++) {
                if (cache.get(i) == null) {
                    cache.put(i, 1);
                } else {
                    cache.put(i, cache.get(i) + 1);
                }
            }
        }
        int max = 0;
        for (Integer integer : cache.values()) {
            max = Math.max(max, integer.intValue());
        }
        return max;
    }
}
