/**
 * Created by winney on 16/2/1.
 */
public class searchMatrix2 {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] < target && matrix[i][matrix[0].length - 1] > target) {
                int start = 0;
                int end = matrix[0].length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (matrix[i][mid] == target) {
                        res++;
                        break;
                    } else if (matrix[i][mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return res;
    }


}
