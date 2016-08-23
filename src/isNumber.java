import com.sun.tools.javac.util.Assert;
import com.sun.tools.jdi.DoubleTypeImpl;

/**
 * Created by winney on 16/8/22.
 */
public class isNumber {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public static boolean isNumber(String s) {
        double res = Double.NaN;
        boolean hasSymbol = false;
        boolean hasE = false;
        boolean hasDot = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (Double.isNaN(res)) {
                    res = 0;
                }
                res *= 10;
                res += c - '0';
                continue;
            } else if (!Double.isNaN(res) && !hasDot && !hasE && c == 'e') {
                hasE = true;
            } else if (!hasDot && c == '.') {
                hasDot = true;
            } else if (!hasSymbol && (c == '+' || c == '-')) {
                hasSymbol = true;
            } else {
                return false;
            }

        }

        return s.length() != 0 && !Double.isNaN(res);

    }

    public static void main(String[] a) {
        Assert.check(isNumber(".") == false);
        Assert.check(isNumber("0.3") == true);
        Assert.check(isNumber("e3.") == false);
        Assert.check(isNumber("e") == false);
        Assert.check(isNumber("4.e") == false);
    }
}
