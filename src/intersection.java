import java.util.HashSet;
import java.util.Set;

/**
 * Created by winney on 16/8/17.
 */
public class intersection {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set=new HashSet<Integer>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }

        Set<Integer> res=new HashSet<>();
        for (int i : nums2) {
            if (nums1Set.contains(i))
                res.add(i);
        }
        int[] ints = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            ints[i++] = re;
        }
        return ints;
    }

}
