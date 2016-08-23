import com.sun.tools.javac.util.Assert;

/**
 * Created by winney on 16/8/23.
 */
public class countAndSay {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public static String countAndSay(int n) {
        String start = "";
        for (int i = 0; i < n; i++) {
            String tmp = "";
            char tmpChar = 0;
            int count = 0;
            for (int j = 0; j <= Math.max(1, start.length()); j++) {
                if (start.isEmpty()) {
                    tmp = "1";
                    continue;
                }
                if (j == start.length()) {
                    tmp = tmp + count + tmpChar;
                    continue;
                }
                char c = start.charAt(j);
                if (tmpChar == 0) {
                    tmpChar = c;
                    count++;
                } else if (tmpChar == c) {
                    count++;
                } else {
                    tmp = tmp + count + tmpChar;
                    tmpChar = c;
                    count = 1;
                }

            }
            start = tmp;
        }
        return start;

    }

    public static void main(String[] a) {
        System.out.println(countAndSay(4));

        for (int i = 0; i < 10; i++) {
            System.out.println(countAndSay(i));
        }

    }


}
