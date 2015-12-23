import com.sun.tools.corba.se.idl.InterfaceGen;
import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * Created by winney on 15/12/23.
 */
public class minimumTotal {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotal(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][0];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] = triangle[i][j] + Math.min(triangle[i - 1][j], triangle[i - 1][j - 1]);
                }
            }
        }
        int[] path = triangle[triangle.length - 1];
        Arrays.sort(path);
        return path[0];
    }

    public static void main(String[] args) {
        int[][] a = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.print(minimumTotal(a));
    }
}
