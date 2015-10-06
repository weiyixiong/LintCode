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

	/**
	 * @param A
	 *            : a array of integers
	 * @return : return an integer
	 * 给出数组A =[1,1,1,2,2,3]，你的函数应该返回长度5，此时A=[1,1,2,2,3]。
	 */
	public int removeDuplicates2(int[] nums) {
		int j = 0;
		int tmp = 0;
		boolean same = false;
		if (nums.length == 0) {
			return 0;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[j] != nums[i] && !same || nums[i] != tmp && same) {
				nums[++j] = nums[i];
				tmp = 0;
				same = false;
			} else {
				if (!same) {
					nums[++j] = nums[i];
				}
				tmp = nums[j];
				same = true;
			}

		}
		return j + 1;
	}
}
