import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class anagramsList {
    /**
     * @param strs : A list of strings
     * @return: A list of strings
     */
    public static List<String> anagrams(String[] strs) {
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Integer> records = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);
            if (records.containsKey(anagram)) {
                int index = records.get(anagram);
                if (index != -1) {
                    list.add(strs[index]);
                    records.put(anagram, -1);
                }
                list.add(strs[i]);
            } else {
                records.put(anagram, i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(anagrams(new String[]{"lint", "intl", "inlt", "code"}).toArray()));
    }
}
