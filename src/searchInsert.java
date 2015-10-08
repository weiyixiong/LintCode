public class searchInsert {
	/**
	 * param A : an integer sorted array param target : an integer to be
	 * inserted return : an integer
	 */
	public int searchInsert(int[] A, int target) {
		int i = 0;
		int j = A.length - 1;
		while (i <= j) {
			int mid = (int) ((i + j) / 2);
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] > target) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return i;
	}
}
