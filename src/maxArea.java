/**
 * Created by winney on 16/5/9.
 */
public class maxArea {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int res = 0;
        for (int start = 0; start < heights.length; start++) {
            for (int end = start + 1; end < heights.length; end++) {
                res = Math.max(res, Math.min(heights[start], heights[end]) * (end - start));
            }
        }
        return res;
    }
}
