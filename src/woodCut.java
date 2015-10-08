import java.util.Arrays;

public class woodCut {
	/**
	 * @param L
	 *            : Given n pieces of wood with length L[i]
	 * @param k
	 *            : An integer return: The maximum length of the small pieces.
	 */
	public int woodCut(int[] L, int k) {
		if (L.length == 0) {
			return 0;
		}
		Arrays.sort(L);
		long maxLen = L[L.length - 1];
		long minLen = 1;
		while (minLen <= maxLen) {
			long mid = (maxLen + minLen) / 2;
			int tmpk = getK(L, mid);
			if (tmpk < k) {
				maxLen = mid - 1;
			} else if (tmpk > k || getK(L, mid + 1) == tmpk) {
				minLen = mid + 1;
			} else {
				return (int) mid;
			}
		}
		return (int) minLen - 1;
	}

	public int getK(int[] L, long len) {
		int res = 0;
		for (int i = 0; i < L.length; i++) {
			res += L[i] / len;
		}
		return res;
	}
}
