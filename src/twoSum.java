import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
	/*
	 * @param numbers : An array of Integer
	 * 
	 * @param target : target = numbers[index1] + numbers[index2]
	 * 
	 * @return : [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		for (int k = 0; k < numbers.length; k++) {
			cache.put(numbers[k], k + 1);
		}
		Arrays.sort(numbers);
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
			if (numbers[i] + numbers[j] > target) {
				j--;
			} else if (numbers[i] + numbers[j] < target) {
				i++;
			} else {
				int a = cache.get(numbers[i]);
				int b = cache.get(numbers[j]);
				res[0] = Math.min(a, b);
				res[1] = Math.max(a, b);
				return res;
			}
		}
		res[0] = cache.get(numbers[i]);
		res[1] = cache.get(numbers[j]);
		return res;
	}
}
