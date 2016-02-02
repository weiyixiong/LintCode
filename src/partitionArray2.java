/**
 * Created by winney on 16/2/2.
 */
public class partitionArray2 {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] % 2 == 1) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }

}
