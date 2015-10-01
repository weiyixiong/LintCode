public class compareStrings {
	/**
	 * @param A
	 *            : A string includes Upper Case letters
	 * @param B
	 *            : A string includes Upper Case letter
	 * @return : if string A contains all of the characters in B return true
	 *         else return false
	 */
	public boolean compareStrings(String A, String B) {
		// write your code here
		int[] cache = new int[130];
		for (int i = 0; i < A.length(); i++) {
			cache[A.charAt(i)]++;
		}
		for (int i = 0; i < B.length(); i++) {
			cache[B.charAt(i)]--;
			if (cache[B.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}
}
