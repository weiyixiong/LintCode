import java.util.Arrays;

/**
 * Created by winney on 16/8/18.
 */
public class wiggleSort2 {
    /**
     * @param nums a list of integer
     * @return void
     */

    public void wiggleSort(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        // Find a median.
        int mid = nums[n / 2];
        // 3-way-partition-to-wiggly in O(n) time with O(1) space.
        int i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (nums[A(nums, j)] > mid) {
                swap(nums, A(nums, i), A(nums, j));
                i++;
                j++;
            } else if (nums[A(nums, j)] < mid) {
                swap(nums, A(nums, j), A(nums, k));
                k--;
            } else
                j++;
        }
    }


    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int A(int[] nums, int i) {
        return (1 + 2 * (i)) % (nums.length | 1);
    }
}
