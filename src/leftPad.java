/**
 * Created by winney on 16/8/17.
 */
public class leftPad {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size        the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        return leftPad(originalStr, size, ' ');
    }

    /**
     * @param originalStr the string we want to append to
     * @param size        the target length of the string
     * @param padChar     the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        int strLen = originalStr.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size - strLen; i++) {
            res.append(padChar);
        }
        return res.append(originalStr).toString();
    }
}
