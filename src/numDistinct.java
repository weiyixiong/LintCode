/**
 * Created by winney on 16/1/5.
 */
public class numDistinct {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public static int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        int[][] nums = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            nums[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < T.length(); j++) {
                System.out.print(nums[i][j] + "  ");
            }
            System.out.println();
        }
        return nums[S.length()][T.length()];

    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit") + "");
        System.out.println(numDistinct("anacondastreetracecar", "contra") + "");
        System.out.println(numDistinct("ddd", "dd") + "");
//        System.out.print(numDistinct("mart", "karma") + "");
    }

}
