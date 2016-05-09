/**
 * Created by winney on 16/5/6.
 */
public class kthSmallest {
    /**
     * @param matrix: a matrix of integers
     * @param k:      an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        int h = matrix.length;
        if (h == 0) {
            return 0;
        }
        int w = matrix[0].length;

        int res1 = matrix[k % h][k / h];
        int res2 = matrix[k / w][k % w];
        return Math.min(res1, res2);
    }

}
