import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by winney on 15/12/24.
 */
public class maxSubArray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public static int maxSubArray(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);

        int max = tmp[tmp.length - 1];
        int min = tmp[0];
        int sum = 1;
        int start = 0;
        int end = 0;
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum *= nums[i];
            if (sum >= max) {
                max = sum;
            }
            if (sum < min) {
                min = sum;
                cache.put(i, start);
                end = i;
            }
            if (Math.abs(sum) <= 1) {
                start = i + 1;
                sum = 1;
            }
        }
        if (cache.isEmpty()) {
            return max;
        }
        int max2 = min;
        for (int i = cache.get(end); i < end; i++) {
            max2 /= nums[i];
            if (max2 >= max) {
                max = max2;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-3, -1, 3, 5, -6, -6, -1, 6, -3, -5, 1, 0, -6, -5, 0, -2, 6, 1, 0, 5};
        System.out.print(maxSubArray(a));
    }


}
