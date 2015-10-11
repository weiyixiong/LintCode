public class uniquePaths {
	public static int uniquePaths(int m, int n) {
		int[] v = new int[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = 1;
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				v[j] += v[j - 1];
				System.out.print(v[j] + " ");
			}
			System.out.println();
		}
		return v[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(4, 6));
	}
}
