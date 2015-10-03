import java.util.ArrayList;
import java.util.HashMap;

public class subarraySum {
	/**
	 * @param nums
	 *            : A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */
	public ArrayList<Integer> subarraySum(int[] nums) {
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		cache.put(0, 0);
		int sum = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (cache.get(sum) == null) {
				cache.put(sum, i + 1);
			} else {
				res.add(cache.get(sum));
				res.add(i);
				return res;
			}
		}
		return res;
	}
}
