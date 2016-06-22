import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by winney on 16/5/12.
 */
public class permutationIndex {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public static long permutationIndexTimeExceededAnswer(int[] A) {
        int res = 1;
        int[] B = A.clone();
        int index = 0;
        Arrays.sort(B);

        long times = 0;
        int compareIndex;
        int range = 1;
        while (true) {
            System.out.println(Arrays.toString(B));
            while (B[index] == A[index]) {
                index++;
                if (index == A.length) {
                    System.out.print(times);
                    return res;
                }
            }
            compareIndex = B.length;
            while (range <= B.length) {
                int changed = -1;
                int max = --compareIndex;
                for (int i = max - 1; i >= B.length - range; i--) {
                    if (B[i] < B[max]) {
                        swap(B, i, max);
                        changed = i;
                        break;
                    }
                }
                if (changed != -1) {
                    res++;
                    for (int i = changed + 1; i < B.length; i++) {
                        for (int j = i; j < B.length; j++) {
                            if (B[i] > B[j]) {
                                swap(B, i, j);
                                times++;
                            }
                        }
                    }
                    range = 2;
                    break;
                } else if (compareIndex == 0) {
                    compareIndex = B.length;
                    range++;
                }

            }

        }

    }

    public static void swap(int[] target, int i, int j) {
        int tmp = target[i];
        target[i] = target[j];
        target[j] = tmp;
    }

    /**
     * @param A an integer array
     * @return a long integer
     */
    static long fac(int numerator) {

        long now = 1;
        for (int i = 1; i <= numerator; i++) {
            now *= (long) i;
        }
        return now;
    }

    static long generateNum(HashMap<Integer, Integer> hash) {
        long denominator = 1;
        int sum = 0;
        for (int val : hash.values()) {
            if (val == 0)
                continue;
            denominator *= fac(val);
            sum += val;
        }
        if (sum == 0) {
            return sum;
        }
        return fac(sum) / denominator;
    }

    public static long permutationIndex(int[] A) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            if (hash.containsKey(A[i]))
                hash.put(A[i], hash.get(A[i]) + 1);
            else {
                hash.put(A[i], 1);
            }
        }
        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    hash.put(A[j], hash.get(A[j]) - 1);
                    ans += generateNum(hash);
                    hash.put(A[j], hash.get(A[j]) + 1);

                }

            }
            hash.put(A[i], hash.get(A[i]) - 1);
        }

        return ans + 1;

    }

    public static void main(String[] a) {
        int[] A = {12, 11, 10, 156, 189, 25, 45, 33, 98, 13, 101, 102, 90};
        int[] B = {4, 3, 2, 1};
        int[] C = {3, 1, 2};
//        permutationIndexTimeExceededAnswer(A);
        System.out.print(permutationIndex(A));
    }
}
