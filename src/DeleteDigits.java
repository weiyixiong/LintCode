import java.util.Arrays;

public class DeleteDigits {
	/**
	 * @param A
	 *            : A positive integer which has N digits, A is a string.
	 * @param k
	 *            : Remove k digits.
	 * @return: A string
	 */
	public static String DeleteDigits(String A, int k) {
		int len = A.length() - k;
		String res = "";
		int start = 0;
		int end = k + 1;
		char min = '9' + 1;
		while (res.length() < len) {
			// System.out.println(start + " " + end);
			for (int i = start; i < end; i++) {
				if (min > A.charAt(i)) {
					min = A.charAt(i);
					start = i;
				}
			}
			start++;
			end++;
			res += min;
			min = '9' + 1;
		}
		start = 0;
		while (res.charAt(start) == '0') {
			start++;
		}
		return res.substring(start);
	}

	public static void main(String[] args) {
		System.out
				.println(DeleteDigits("9876141516171818818181890001988181700198181778786761256512651653145345143", 55));
	}
}
