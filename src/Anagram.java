
public class Anagram {

	public boolean anagram(String s, String t) {
		if (t.length() != s.length()) {
			return false;
		}
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += s.charAt(i);
			res -= t.charAt(i);
		}
		if (res == 0) {
			return true;
		}
		return false;
	}
}
