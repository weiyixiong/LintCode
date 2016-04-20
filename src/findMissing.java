/**
 * Created by winney on 16/4/20.
 */
public class findMissing {

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public static int findMissing(int[] nums) {
        if (nums.length == 1) {
            return nums[0] + 1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int d = nums[1] > nums[0] ? 1 : -1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int res = (min * (nums.length + 1) + d * (nums.length * (nums.length + 1)) / 2) - sum;
        if (res == max + 1 && nums[1] < nums[0]) {
            return 0;
        }
        return res;
    }

    public static void main(String[] a) {
        int[] nums = {1, 2, 5, 4, 6, 7, 8, 9};
        System.out.print(findMissing(nums));
    }

}
