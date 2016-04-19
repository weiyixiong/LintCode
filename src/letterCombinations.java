import java.util.ArrayList;

/**
 * Created by winney on 16/4/19.
 */
public class letterCombinations {
    String[] data = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {

        ArrayList<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        letterCombinationsHelper(digits, 0, "", res);
        return res;
    }

    public void letterCombinationsHelper(String digits, int i, String target, ArrayList<String> res) {
        if (i >= digits.length()) {
            res.add(target);
            return;
        }
        String dataItem = data[digits.charAt(i) - '0'];
        for (int j = 0; j < dataItem.length(); j++) {
            letterCombinationsHelper(digits, i + 1, target + dataItem.charAt(j), res);
        }
    }

}
