public class longestCommonPrefix {
	/**
	 * @param strs
	 *            : A list of strings
	 * @return: The longest common prefix
	 */
	public String longestCommonPrefix(String[] strs) {
		String res = "";
		int j = 0;
		if (strs.length == 0) {
			return res;
		}
		while (true) {
			if (j >= strs[0].length()) {
				return res;
			}
			char c = strs[0].charAt(j);
			for (int i = 0; i < strs.length; i++) {
				if (j >= strs[i].length() || strs[i].charAt(j) != c) {
					return res;
				}
			}
			res += c;
			j++;
		}
	}
}
