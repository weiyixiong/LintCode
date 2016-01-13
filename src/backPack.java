import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by winney on 16/1/11.
 */
public class backPack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public static int backPack(int m, int[] A) {
        boolean[][] flag = new boolean[A.length + 1][m + 1];
        flag[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                flag[i + 1][j] = flag[i][j];
                if (j >= A[i] && flag[i][j - A[i]]) {
                    flag[i + 1][j] = true;
                }
            }
        }

        for (int i = m; i >= 0; i--) {
            if (flag[A.length][i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                16, 16, 3, 5, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16
        };
        System.out.print(backPack(100, a));
    }
}
