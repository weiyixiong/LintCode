public class updateBits {
	/**
	 * @param n
	 *            , m: Two integer
	 * @param i
	 *            , j: Two bit positions return: An integer
	 */
	public int updateBits(int n, int m, int i, int j) {
		int ntmp = n;
		int f = 1;
		for (int j2 = 0; j2 < i; j2++) {
			f <<= 1;
		}
		int i2 = i;
		while (i2 <= j) {
			int k = ntmp - f;
			if ((n & k) == (n - f)) {
				n &= k;
			}
			f <<= 1;
			i2++;
		}
		n += m << i;
		return n;
	}
}
