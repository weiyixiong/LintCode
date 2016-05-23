import java.util.Arrays;

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

        int compareIndex;
        int range = 1;
        while (true) {
            System.out.println(Arrays.toString(B));
            while (B[index] == A[index]) {
                index++;
                if (index == A.length) {
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
    public long permutationIndex(int[] A) {
        


    }

    public static void main(String[] a) {
        int[] A = {1, 2, 3, 4};
        int[] B = {4, 3, 2, 1};
        int[] C = {3, 1, 2};
    }
}
