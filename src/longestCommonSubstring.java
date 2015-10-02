public class longestCommonSubstring {

	/**
	 * @param A
	 *            , B: Two string.
	 * @return: the length of the longest common substring.
	 */
	public static int longestCommonSubstring(String A, String B) {
		// write your code here
		if (A.length() == 0 || B.length() == 0) {
			return 0;
		}
		char[] str1 = A.toCharArray();
		char[] str2 = B.toCharArray();
		int len1 = str1.length + 1;
		int len2 = str2.length + 1;
		int c[][] = new int[len1][len2];
		int res = 0;
		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;
					res = Math.max(res, c[i][j]);
				} else {
					c[i][j] = 0;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("a");
		// String str1 = new String("aab12345678cde");
		// String str2 = new String("ab1234yb1234567");
		System.out.println(longestCommonSubstring(str1, str2));
	}
}
