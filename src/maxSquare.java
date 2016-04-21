/**
 * Created by winney on 16/4/21.
 */
public class maxSquare {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[0].length; i1++) {
                if (matrix[i][i1] == 1) {
                    max = Math.max(max, findMax(matrix, i, i1, 1));
                }
            }
        }
        if (max == 1) {
            return max;
        }
        return max * max / 2;
    }

    public int findMax(int[][] matrix, int i, int j, int lenDif) {
        if (i + lenDif == matrix.length || j + lenDif == matrix[0].length) {
            return lenDif;
        }
        for (int k = 0; k < lenDif; k++) {
            if (matrix[i][j + k] == 0 || matrix[i + k][j] == 0 || matrix[i + k][j + k] == 0) {
                return lenDif;
            }
        }
        return findMax(matrix, i, j, lenDif + 1);

    }
}
