public class partitionArray {
	/**
	 * @param nums
	 *            : The integer array you should partition
	 * @param k
	 *            : As description return: The index after partition
	 */
	public int partitionArray(int[] nums, int k) {
		int res = 0;
		int[] lt = new int[nums.length];
		int[] gt = new int[nums.length];
		int j = 0;
		int l = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				lt[j++] = nums[i];
			} else {
				gt[l++] = nums[i];
			}
		}
		int i = 0;
		res = j;
		while (j > 0) {
			nums[i++] = lt[--j];
		}
		while (l > 0) {
			nums[i++] = gt[--l];
		}
		return res;
	}

	public int partitionArray2(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			while (left < right + 1 && nums[left] < k) {
				left++;
			}
			while (left < right + 1 && nums[right] >= k) {
				right--;
			}
			if (left < right + 1 && nums[left] >= k && nums[right] < k) {
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
			}
		}
		return right + 1;
	}
}
