public class bitSwapRequired {
	/**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int c = a ^ b;
		int res = 0;
		while (c != 0) {
			c &= c - 1;
			res++;
		}
		return res;
    }

	public static void main(String[] args) {
		// System.out.println(1 ^ 0);
		// bitSwapRequired(31, 67);
		System.out.println(bitSwapRequired(1, -1));
	}
}
