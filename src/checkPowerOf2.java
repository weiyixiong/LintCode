public class checkPowerOf2 {
	/*
	 * @param n: An integer
	 * 
	 * @return: True or false
	 */
	public static boolean checkPowerOf2(int n) {
		if (n < 1) {
			return false;
		}
		while (n >= 1) {
			if (n % 2 == 1 && n != 1) {
				return false;
			}
			n = n >> 1;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkPowerOf2(64));
	}
}
