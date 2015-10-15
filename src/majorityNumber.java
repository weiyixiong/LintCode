import java.util.ArrayList;
import java.util.Collections;

public class majorityNumber {
	/**
	 * @param nums
	 *            : a list of integers
	 * @return: find a majority number
	 */
	public int majorityNumber(ArrayList<Integer> nums) {
		Collections.sort(nums);
		return nums.get(nums.size() / 2);
	}

}
