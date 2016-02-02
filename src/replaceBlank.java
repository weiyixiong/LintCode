/**
 * Created by winney on 16/2/1.
 */
public class replaceBlank {


    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        if (length == 0) {
            return 0;
        }
        char[] copy = string.clone();
        int j = 0;
        for (int i = 0; i < length; j++, i++) {
            if (copy[i] == ' ') {
                string[j++] = '%';
                string[j++] = '2';
                string[j] = '0';
            } else {
                string[j] = copy[i];
            }
        }
        return j + 1;

    }
}
