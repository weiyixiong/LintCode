import java.util.Arrays;
import java.util.TreeMap;

public class threeSumClosest {
	/**
	 * @param numbers
	 *            : Give an array numbers of n integer
	 * @param target
	 *            : An integer
	 * @return : return the sum of the three integers, the sum closest target.
	 */
	public static int threeSumClosest(int[] numbers, int target) {
		int len = numbers.length;
		int j = 0;
		int k = len - 1;
		int res = Integer.MAX_VALUE;
		int result = Integer.MAX_VALUE;
		Arrays.sort(numbers);
		// System.out.println(Arrays.toString(numbers));
		for (int i = 1; i < len - 1; i++) {
			j = 0;
			k = len - 1;
			while (j < i && k > i) {
				int tmp = numbers[i] + numbers[j] + numbers[k];
//				System.out.println(tmp + "   " + i + "  " + j + "  " + k);
				int dis = Math.abs(target - tmp);
//				System.out.println(dis + "   " + i + "  " + j + "  " + k);
				if (res > dis) {
//					System.out.println(dis + "   " + i + "  " + j + "  " + k);
					res = dis;
					result = tmp;
				}
				int tmp2 = numbers[i] + numbers[j] + numbers[k - 1];
				int tmp3 = numbers[i] + numbers[j + 1] + numbers[k];
				if (Math.abs(target - tmp2) < Math.abs(target - tmp3)) {
					k--;
				} else {
					j++;
				}
			}
		}
		// System.out.println(res);
		// System.out.println(res);
		if (res < 0) {
			return 1;
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { -8, -0, -7, -101, -123,
				-1, -2, 1, 1, 4, -2, 0, -1, 0, -1111, 0, -1, -2, -3, -4, -5,
				-6, -100, -98, -111, -11 }, -101));
		System.out.println(threeSumClosest(new int[] { -2, -3, -4, -5, -100,
				99, 1, 4, 4, 4, 5, 1, 0, -1, 2, 3, 4, 5 }, 77));
		System.out.println(threeSumClosest(new int[] { -2, -3, 5, -1, -4, 5,
				-11, 7, 1, 2, 3, 4, -7, -1, -2, -3, -4, -5 }, 45));
		System.out.println(threeSumClosest(new int[] { 2, 7, 11, 15 }, 3));
		System.out.println(threeSumClosest(new int[] { 1, 0, -1, -1, -1, -1, 0,
				1, 1, 1, 2 }, 7));
	}
}
