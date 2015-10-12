public class numTrees {
	/**
	 * @paramn n: An integer
	 * @return: An integer
	 */
	public int numTrees(int n) {
		if (n <= 0)
			return 1;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				// select j as root
				dp[i] += dp[j - 1] * dp[i - j];
		}
		return dp[n];
	}
}
