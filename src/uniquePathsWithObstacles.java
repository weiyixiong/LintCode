/**
 * Created by winney on 15/12/18.
 */
public class uniquePathsWithObstacles {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            int[][] tmp = new int[i][i];
//            System.out.println(uniquePathsWithObstacles(tmp));
//            System.out.println(uniquePathsWithObstacles2(tmp));
        }
//        System.out.println(uniquePathsWithObstacles(new int[4][2]));
//        System.out.println(uniquePathsWithObstacles(new int[4][3]));
        System.out.println(uniquePathsWithObstacles(new int[3][4]));
        System.out.println(uniquePathsWithObstacles2(new int[3][4]));
//        System.out.println(uniquePathsWithObstacles(new int[4][4]));
//        System.out.println(uniquePathsWithObstacles(new int[4][5]));
    }

    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] paths = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                paths[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                } else {
                    paths[i][j] = 0;
                }
            }
        }

        return paths[n - 1][m - 1];

    }

    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        return uniquePathsWithObstaclesHelper(obstacleGrid, 0, 0, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    public static int uniquePathsWithObstaclesHelper(int[][] grid, int i, int j, int width, int height) {
        int res = 0;
        if (i == width && j == height) {
            return 1;
        }
        if (i < width && grid[i + 1][j] != 1) {
            res += uniquePathsWithObstaclesHelper(grid, i + 1, j, width, height);
        }
        if (j < height && grid[i][j + 1] != 1) {
            res += uniquePathsWithObstaclesHelper(grid, i, j + 1, width, height);
        }
        return res;
    }


}
