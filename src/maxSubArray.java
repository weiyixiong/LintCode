import java.util.Arrays;

/**
 * Created by winney on 15/12/24.
 */
public class maxSubArray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);

        int max = tmp[tmp.length - 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
