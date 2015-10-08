public class searchMatrix {
	/**
	 * @param matrix
	 *            , a list of lists of integers
	 * @param target
	 *            , an integer
	 * @return a boolean, indicate whether matrix contains target
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}
		int start = 0;
		int end = (matrix.length * matrix[0].length) - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int i = mid / matrix[0].length;
			int j = mid % matrix[0].length;
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
}
