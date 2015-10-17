import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class largestNumber {
	/**
	 * @param num
	 *            : A list of non negative integers
	 * @return: A string
	 */
	// 方法一 只适用于数组内不存在大于等于1000000000（2147483647）的数
	public static String largestNumber2(int[] num) {
		String res = "";
		Arrays.sort(num);
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		int flag = 1;
		while (num[num.length - 1] > Math.pow(10, flag)) {
			flag++;
		}
		int zero = (int) Math.pow(10, flag - 1);
		// printfUtil.printf(num);
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] < zero) {
				num[i] *= zero;
				table.put(num[i], (table.get(num[i]) == null ? 0 : table.get(num[i])) + 1);
			}
		}
		// printfUtil.printf(table);
		Arrays.sort(num);
		for (int i = num.length - 1; i >= 0; i--) {
			if (table.get(num[i]) != null && table.get(num[i]) > 0) {
				table.put(num[i], table.get(num[i]) - 1);
				num[i] /= zero;
			}
			res += num[i];
		}
		if (res.startsWith("0")) {
			return "0";
		}
		return res;
	}

	public static String largestNumber(int[] num) {
		String[] strs = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			strs[i] = Integer.toString(num[i]);
		}
		Arrays.sort(strs, new NumbersComparator());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			sb.append(strs[i]);
		}
		String result = sb.toString();
		int index = 0;
		while (index < result.length() && result.charAt(index) == '0') {
			index++;
		}
		if (index == result.length()) {
			return "0";
		}
		return result.substring(index);
	}

	static class NumbersComparator implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			return (s2 + s1).compareTo(s1 + s2);
		}
	}

	public static void main(String[] args) {
		int[] a = { 41, 23, 87, 55, 50, 53, 18, 9, 39, 63, 35, 33, 54, 25, 26, 49, 74, 61, 32, 81, 97, 99, 38, 96, 22,
				95, 35, 57, 80, 80, 16, 22, 17, 13, 89, 11, 75, 98, 57, 81, 69, 8, 10, 85, 13, 49, 66, 94, 80, 25, 13,
				85, 55, 12, 87, 50, 28, 96, 80, 43, 10, 24, 88, 52, 16, 92, 61, 28, 26, 78, 28, 28, 16, 1, 56, 31, 47,
				85, 27, 30, 85, 2, 30, 51, 84, 50, 3, 14, 97, 9, 91, 90, 63, 90, 92, 89, 76, 76, 67, 55 };
		System.out.println(largestNumber(a));

	}
}
