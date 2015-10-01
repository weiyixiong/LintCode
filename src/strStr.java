public class strStr {
	/**
	 * Returns a index to the first occurrence of target in source, or -1 if
	 * target is not part of source.
	 * 
	 * @param source
	 *            string to be scanned.
	 * @param target
	 *            string containing the sequence of characters to match.
	 */
	public int strStr(String source, String target) {
		// write your code here
		if (source == null || target == null) {
			return -1;
		}
		if (target.length() == 0) {
			return 0;
		}
		int i = 0;
		int j = 0;
		int index = 0;
		int[] next = new int[target.length()];
		getNext(target.toCharArray(), next);
		while (i < source.length() && j < target.length()) {
			if (source.charAt(i) == target.charAt(j)) {
				i++;
				j++;
			} else {
				index += j - next[j];
				if (next[j] != -1) {
					j = next[j];
				} else {
					j = 0;
					i++;
				}
			}
		}
		if (j == target.length()) {
			return index;
		}
		return -1;
	}

	public void getNext(char[] cs, int[] next) {
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < cs.length - 1) {
			if (k != -1 && cs[j] != cs[k]) {
				k = next[k];
			}
			j++;
			k++;
			if (cs[j] == cs[k]) {
				next[j] = next[k];
			} else {
				next[j] = k;
			}
		}

	}

}
