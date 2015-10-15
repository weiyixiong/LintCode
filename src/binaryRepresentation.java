import java.util.Scanner;

public class binaryRepresentation {
	/**
	 * @param n
	 *            : Given a decimal number that is passed in as a string
	 * @return: A string
	 */
	public static String binaryRepresentation(String n) {
		String[] num = n.split("\\.");
		String res = praseInt(Integer.parseInt(num[0]));
		if (num.length == 2) {
			String tmp = parseDecimal(Double.parseDouble("0." + num[1]));
			if (!tmp.equals("ERROR")) {
				if (!tmp.contains("1")) {
					return res;
				}
				res += ".";
				res += tmp;
				if (tmp.length() > 32) {
					System.out.println(res);
					return "ERROR";
				}
			} else {
				return tmp;
			}

		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(binaryRepresentation("17817287.6418609619140625"));

	}

	final static char[] digits = { '0', '1' };

	private static String praseInt(int val) {
		int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
		int chars = Math.max(mag, 1);
		char[] buf = new char[chars];
		do {
			buf[--chars] = digits[val & 1];
			val >>>= 1;
		} while (val != 0 && chars > 0);
		return new String(buf);
	}

	private static String parseDecimal(double val) {
		int chars = 32;
		StringBuilder res = new StringBuilder();
		do {
			val *= 2;
			System.out.println(val);
			res.append(digits[(int) val]);
			val -= (int) val;
			if (chars < 0) {
				return "ERROR";
			}
		} while (val != 0);
		return res.toString();
	}
}
