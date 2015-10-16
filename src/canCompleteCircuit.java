public class canCompleteCircuit {
	/**
	 * @param gas
	 *            : an array of integers
	 * @param cost
	 *            : an array of integers
	 * @return: an integer
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int res = 0;
		int i = 0;
		int gasLast = 0;
		while (i < gas.length) {
			if (gas[i] >= cost[i]) {
				gasLast = gas[i] - cost[i];
				int j = i;
				while (i == 0 && j < gas.length - 1 || j != i - 1) {
					j++;
					if (j > gas.length - 1) {
						if (i == 0) {
							break;
						}
						j = 0;
					}
					if (gas[j] + gasLast >= cost[j]) {
						gasLast += gas[j] - cost[j];
					} else {
						gasLast += gas[j] - cost[j];
						break;
					}
				}

				if (j == i - 1 && gasLast >= 0 || i == 0 && j == gas.length) {
					return i;
				}
			}
			i++;
		}
		return -1;
	}

}
