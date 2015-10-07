import org.omg.IOP.Encoding;

public class sqrt {

	/**
	 * @param x
	 *            : An integer
	 * @return: The sqrt of x
	 */
	public static int sqrt(int x) {
		long start = 1, end = x;
		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			if (mid * mid <= x) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (end * end <= x) {
			return (int) end;
		}
		return (int) start;
	}

	public static void main(String[] args) {
		System.out.println(sqrt(999999999));
	}
}
