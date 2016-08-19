/**
 * Created by winney on 16/8/18.
 */
public class wiggleSort {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            wiggleSortHelper(nums, i);
        }
    }

    public void wiggleSortHelper(int[] nums, int index) {
        if (index % 2 == 0 ? nums[index] > nums[index + 1] : nums[index] < nums[index + 1]) {
            swap(nums, index, index + 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
