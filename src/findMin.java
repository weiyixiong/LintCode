public class findMin {
	/**
	 * @param num
	 *            : a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin(int[] num) {
		int len = num.length;
		int i = 0;
		int j = len - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (mid == 0 && num[mid] < num[len - 1] || mid > 0 && num[mid - 1] > num[mid]) {
				return num[mid];
			}
			if (num[mid] > num[len - 1]) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return num[i + 1];
	}
}
