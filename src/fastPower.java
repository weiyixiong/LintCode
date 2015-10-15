public class fastPower {
	/*
	 * @param a, b, n: 32bit integers
	 * 
	 * @return: An integer
	 */
	int fastPower(int a, int b, int n) {
		long res = 0;
		if (a == 0 || b == 0)
			return 0;
		a = a % b;
		if (a > 0) {
			res = power(a, b, n);
			if (n < 0) {
				res = 1 / res;
			}
		} else {
			res = power(a, b, n);
			if (n % 2 == 1) {
				res = 0 - res;
			}
			if (n < 0) {
				res = 1 / res;
			}
		}
		return (int) res % b;
	}

	public long power(int a, int b, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return a;
		}
		long result = power(a, b, n >> 1);
		result = result * result % b;
		if ((n & 1) == 1) {
			result = result * a % b;
		}
		return result;
	}
}
