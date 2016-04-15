import java.awt.*;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by winney on 16/4/14.
 */
public class maxPoints {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        } else if (points.length == 1) {
            return 1;
        }
        HashMap<Double, Set<Integer>> cache = new HashMap<>();
        HashMap<Double, Set<Integer>> cache2 = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int i1 = i + 1; i1 < points.length; i1++) {
                if (points[i1].x - points[i].x == 0) {
                    double k = points[i1].x;
                    if (!cache2.containsKey(k)) {
                        Set<Integer> tmp = new HashSet<>();
                        tmp.add(i1);
                        tmp.add(i);
                        cache2.put(k, tmp);
                    } else {
                        Set<Integer> tmp = cache2.get(k);
                        tmp.add(i1);
                        tmp.add(i);
                    }
                    res = Math.max(res, cache2.get(k).size());

                } else {
                    double k = getK(points[i].x, points[i].y, points[i1].x, points[i1].y);
                    double m = (points[i1].x * points[i].y) - (points[i].x * points[i1].y) / (points[i1].x - points[i].x);
                    double key = hashCode(k, m);
                    if (!cache.containsKey(key)) {
                        Set<Integer> tmp = new HashSet<>();
                        tmp.add(i1);
                        tmp.add(i);
                        cache.put(key, tmp);
                    } else {
                        Set<Integer> tmp = cache.get(key);
                        tmp.add(i1);
                        tmp.add(i);
                    }
                    res = Math.max(res, cache.get(key).size());
                }

            }
        }
        return res;
    }

    public double getK(double x, double y, double x2, double y2) {
        return (y2 - y) / (x2 - x);
    }

    public int hashCode(double x, double y) {
        long bits = java.lang.Double.doubleToLongBits(x);
        bits ^= java.lang.Double.doubleToLongBits(y) * 31;
        return (((int) bits) ^ ((int) (bits >> 32)));
    }
}
