import java.util.ArrayList;

public class mergeSortedArray {
	/**
	 * @param A
	 *            : sorted integer array A which has m elements, but size of A
	 *            is m+n
	 * @param B
	 *            : sorted integer array B which has n elements
	 * @return: void
	 */
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		m--;
		n--;
		int i = m + n + 1;
		while (m >= 0 && n >= 0) {
			if (A[m] > B[n]) {
				A[i--] = A[m--];
			} else {
				A[i--] = B[n--];
			}
		}
		while (m >= 0) {
			A[i--] = A[m--];
		}
		while (n >= 0) {
			A[i--] = B[n--];
		}
	}

	/**
	 * @param A
	 *            and B: sorted integer array A and B.
	 * @return: A new sorted integer array
	 */
	public ArrayList<Integer> mergeSortedArray2(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int i = 0;
		int k = 0;
		while (i < A.size() && k < B.size()) {
			int a = A.get(i);
			int b = B.get(k);
			if (a > b) {
				res.add(b);
				k++;
			} else {
				res.add(a);
				i++;
			}
		}
		while (i < A.size()) {
			res.add(A.get(i++));
		}
		while (k < B.size()) {
			res.add(B.get(k++));
		}
		return res;

	}
}
