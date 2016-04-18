import java.util.ArrayList;

/**
 * Created by winney on 16/4/18.
 */
public class continuousSubarraySum {
    /**
     * @param A an integer array
     * @return A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;
        int maxValue = 0;
        int maxValueCache = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > maxValue) {
                if (A[i] > 0) {
                    endIndex = i;
                    maxValue = sum;
                    if (maxValue > maxValueCache) {
                        result.clear();
                        result.add(startIndex);
                        result.add(endIndex);
                        maxValueCache = maxValue;
                    }
                }

            } else if (sum < 0) {
                maxValue = sum;
                sum = 0;
                if (sum>maxValue){
                    endIndex = startIndex = i + 1;
                }
            }
        }
        if (result.isEmpty()) {
            result.add(startIndex);
            result.add(endIndex);
        }
        return result;
    }
}
