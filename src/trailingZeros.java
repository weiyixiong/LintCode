public class trailingZeros {
	/*
	 * param n: As desciption return: An integer, denote the number of trailing
	 * zeros in n!
	 */
	public long trailingZeros(long n) {
		long res = 0;
		while (n > 0) {
			res += n / 5;
			n /= 5;
		}
		return res;
	}
}
