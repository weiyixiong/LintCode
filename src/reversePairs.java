import java.nio.channels.AlreadyBoundException;

/**
 * Created by winney on 16/4/29.
 */
public class reversePairs {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        int[] res = new int[1];
        mergeSort(A, res);
        return res[0];
    }

    public int[] mergeSort(int[] A, int[] res) {
        int len = A.length;
        if (len <= 1) {
            return A;
        }

        int[] B;
        if (len % 2 == 0) {
            B = new int[len / 2];
        } else {
            B = new int[len / 2 + 1];
        }
        int[] C = new int[A.length / 2];
        int index = 0;
        for (int i = 0; i < B.length; i++) {
            B[i] = A[index++];
        }
        for (int i = 0; i < C.length; i++) {
            C[i] = A[index++];
        }
        B = mergeSort(B, res);
        C = mergeSort(C, res);
        index = 0;
        int bi = 0;
        int ci = 0;
        while (index < len && ci < C.length && bi < B.length) {
            if (B[bi] <= C[ci]) {
                A[index++] = B[bi++];
            } else {
                res[0]+=B.length-bi;
                A[index++] = C[ci++];
            }
        }
        while (ci < C.length) {
            A[index++] = C[ci++];
        }
        while (bi < B.length) {
            A[index++] = B[bi++];
        }
        return A;
    }
}
