import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by winney on 16/4/22.
 */
public class spiralOrder {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        final int LEFT = 1;
        final int RIGHT = 2;
        final int UP = 3;
        final int DOWN = 4;
        int[] DIRECTION = {RIGHT, DOWN, LEFT, UP};
        int direction = DIRECTION[0];
        int directIndex = 0;

        for (int i = 0, j = -1; ; ) {

            switch (direction) {
                case RIGHT:
                    j++;
                    break;
                case DOWN:
                    i++;
                    break;
                case LEFT:
                    j--;
                    break;
                case UP:
                    i--;
                    break;
            }
            if (i < matrix.length && j < matrix[0].length && i >= 0 && j >= 0 && !visited[i][j]) {
                res.add(matrix[i][j]);
            }
            if (res.size() >= matrix.length * matrix[0].length) {
                return res;
            }

            if (direction == RIGHT) {
                if ((j == matrix[0].length - 1 || visited[i][j + 1])) {
                    direction = DIRECTION[++directIndex % DIRECTION.length];
                }
            } else if (direction == DOWN) {
                if ((i == matrix.length - 1 || visited[i + 1][j])) {
                    direction = DIRECTION[++directIndex % DIRECTION.length];
                }
            } else if (direction == LEFT) {
                if ((j <= 0 || visited[i][j - 1])) {
                    direction = DIRECTION[++directIndex % DIRECTION.length];
                }
            } else if (direction == UP) {
                if ((i <= 0 || visited[i - 1][j])) {
                    direction = DIRECTION[++directIndex % DIRECTION.length];
                }
            }
            if (i < matrix.length && j < matrix[0].length && i >= 0 && j >= 0 && !visited[i][j]) {
                visited[i][j] = true;
            }
        }


    }

    public static void main(String[] a) {
        int[][] martix = {{1, 2, 3, 4}, {6, 7, 8, 9}, {10, 11, 12, 13}, {20, 21, 22, 23}};
        spiralOrder(martix);


    }
}
