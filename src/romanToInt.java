import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by winney on 16/5/10.
 */
public class romanToInt {
    //    I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
    static Map<Character, Integer> map = new HashMap<>();
    static Set<Character> subChar = new HashSet<>();


    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        subChar.add('I');
        subChar.add('X');
        subChar.add('C');
    }

    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int addNum = 0;
        int res = 0;
        char preNum = 'T';
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            Integer mapPreNum = map.get(preNum);
            Integer mapCurr = map.get(tmp);
            if (mapPreNum != null && subChar.contains(preNum) && mapCurr > mapPreNum) {
                res -= 2 * mapPreNum;
                res += mapCurr;
                preNum = 'T';
                addNum = 0;
            } else {
                res += mapCurr;
                addNum++;
                if (addNum == 3 && i < s.length() - 1 && map.get(s.charAt(i + 1)) < mapCurr) {
                    preNum = 'T';
                    addNum = 0;
                } else {
                    preNum = 'F';
                }

            }
            if (preNum == 'F') {
                preNum = tmp;
            }

        }
        return res;
    }
}

