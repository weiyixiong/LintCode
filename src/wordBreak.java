import java.util.Set;

/**
 * Created by winney on 16/1/11.
 */
public class wordBreak {

    /**
     * @param s:    A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int maxLen = 0;
        for (String item : dict) {
            maxLen = Math.max(maxLen, item.length());
        }
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= maxLen && j <= s.length() - i; j++) {
                if (!flag[i]) {
                    continue;
                }
                String tmp = s.substring(i, i + j);
                if (dict.contains(tmp)) {
                    flag[i + j] = true;
                    if (i + j == s.length()) {
                        return true;
                    }
                }
            }
        }
        return flag[s.length()];
    }
}
