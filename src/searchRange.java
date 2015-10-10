public class searchRange {
	/**
	 * @param A
	 *            : an integer sorted array
	 * @param target
	 *            : an integer to be inserted return : a list of length 2,
	 *            [index1, index2]
	 */
	public int[] searchRange(int[] A, int target) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		int len = A.length - 1;
		int i = 0;
		int j = len;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (A[mid] == target && (mid == 0 || A[mid - 1] < A[mid])) {
				res[0] = mid;
				i = mid;
				j = len;
			}
			if (A[mid] == target && (mid == len || A[mid] < A[mid + 1])) {
				res[1] = mid;
				break;
			}
			if (res[0] == -1) {
				if (A[mid] < target) {
					i = mid + 1;
				} else {
					j = mid - 1;
				}
			} else {
				if (A[mid] > target) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}
			}

		}
		return res;
	}

}
