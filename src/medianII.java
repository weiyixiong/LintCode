import java.util.*;

/**
 * Created by winney on 16/1/28.
 */
public class medianII {
    class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return -Integer.compare(o1, o2);
        }
    }

    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            int[] result = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                result[i] = res.get(i);
            }
            return result;
        }

        int median = nums[0];
        PriorityQueue<Integer> maxHeap, minHeap;
        maxHeap = new PriorityQueue<Integer>(10, new MyComparator());
        minHeap = new PriorityQueue<Integer>(10, new MyComparator());

        res.add(median);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < median) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(-nums[i]);
            }

            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(-median);
                median = maxHeap.peek();
                maxHeap.poll();
            } else if (maxHeap.size() + 1 < minHeap.size()) {
                maxHeap.add(median);
                median = -minHeap.peek();
                minHeap.poll();
            }
            res.add(median);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
