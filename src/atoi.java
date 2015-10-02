public class atoi {
	/**
	 * @param str
	 *            : A string
	 * @return An integer
	 */
	public int atoi(String str) {
		int res = 0;
		int symNum = 0;
		if (str.trim().length() == 0) {
			return 0;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				if (res >= 1000000000) {
					if (str.trim().charAt(0) == '-') {
						return -2147483648;
					}
					return 2147483647;
				}
				if (res >= 214748364 && (str.charAt(i) - '0') > 7) {
					if (str.trim().charAt(0) == '-') {
						return -2147483648;
					}
					return 2147483647;
				}
				res = res * 10 + (str.charAt(i) - '0');
			} else if (str.charAt(i) == '.') {
				int tmp = 0;
				for (int j = str.length() - 1; str.charAt(j) != '.'; j--) {
					tmp = tmp / 10 + (str.charAt(j) - '0');
				}
				if (tmp != 0) {
					res += tmp;
				}
				break;
			} else if (str.charAt(i) != ' ' && res != 0) {
				break;
			} else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				symNum++;
				if (symNum > 1) {
					return 0;
				}
			}
		}
		if (str.trim().charAt(0) == '-') {
			res *= -1;
		}
		return res;
	}
}
