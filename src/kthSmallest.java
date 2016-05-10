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
        k--;
        if (matrix.length > 1 && matrix[0].length > 1 && matrix[0][1] > matrix[1][0]) {
            return matrix[k % h][k / h];
        } else {
            return matrix[k / w][k % w];
        }
    }

}
