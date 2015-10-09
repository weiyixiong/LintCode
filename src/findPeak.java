public class findPeak {
	/**
	 * @param A
	 *            : An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeak(int[] A) {
		if (A.length < 3) {
			return 0;
		}
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
				return i;
			}
			if (A[i] > A[i + 1]) {
				i++;
			}
		}
		return 0;
	}
}
