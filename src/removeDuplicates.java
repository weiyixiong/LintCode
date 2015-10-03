public class removeDuplicates {
	/**
	 * @param A
	 *            : a array of integers
	 * @return : return an integer
	 */
	public int removeDuplicates(int[] nums) {
		int j = 0;
		if (nums.length == 0) {
			return 0;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[j] != nums[i]) {
				nums[++j] = nums[i];
			}
		}
		return j + 1;
	}
}
