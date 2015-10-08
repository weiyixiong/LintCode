public class binarySearch {
	/**
	 * @param nums
	 *            : The integer array.
	 * @param target
	 *            : Target to find.
	 * @return: The first position of target. Position starts from 0.
	 */
	public int binarySearch(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (nums[mid] < target) {
				i = mid + 1;
			} else if (nums[mid] > target) {
				j = mid - 1;
			} else if (nums[mid] == target) {
				if (mid > 0 && nums[mid - 1] == target) {
					j = mid - 1;
					continue;
				}
				return mid;
			}
		}
		return -1;
	}
}
