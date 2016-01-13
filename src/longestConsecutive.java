import java.util.Arrays;

/**
 * Created by winney on 16/1/13.
 */
public class longestConsecutive {
    /**
     * @param num: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num.length <= 1) {
            return num.length;
        }
        Arrays.sort(num);
        int res = 0;
        int tmp = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == 1 + num[i - 1]) {
                tmp++;
            } else if (num[i] != num[i - 1]) {
                tmp = 0;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
