import java.util.ArrayList;
import java.util.List;

/**
 * Created by winney on 16/4/26.
 */
public class partition2 {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> item = new ArrayList<>();
        partitionHelper(s, item, res);
        return res;
    }

    public void partitionHelper(String s, List<String> item, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(item);
        }
        for (int i = 1; i < s.length(); i++) {
            List<String> list = new ArrayList<>(item);
            String substring = s.substring(0, i);
            if (isPlalindrome(substring)) {
                list.add(substring);
                partitionHelper(s.substring(i), list, res);
            }
        }
    }

    public boolean isPlalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
