import java.util.HashMap;

/**
 * Created by winney on 15/12/31.
 */
public class minDistance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }


    static int maxLen;

    public static int minDistance2(String word1, String word2) {
        int minLen = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minLen; i++) {
            int tmp = 0;
            for (int j = 0; j < minLen; j++) {
                while (j < minLen && i < minLen && word1.charAt(i) == word2.charAt(j)) {
                    i++;
                    j++;
                    tmp++;
                }
            }
            maxLen = Math.max(maxLen, tmp);
        }
        maxLen = word1.length() - maxLen + 5;
        return minDistanceHelper(word1, word2, 0);
    }

    public static int minDistanceHelper(String word1, String word2, int step) {
        int min = maxLen;
        if (word1.equals(word2)) {
            return 0;
        }
        if (step > maxLen) {
            return maxLen;
        }
        int tmpStep = 0;
        if (word1.length() < word2.length()) {
            for (int i = 0; i < word2.length(); i++) {
                if (i >= word1.length() || word1.charAt(i) != word2.charAt(i)) {
                    tmpStep = minDistanceHelper(insert(word1, i, word2.charAt(i)), word2, step + 1) + 1;
                    if (tmpStep > maxLen) {
                        return tmpStep;
                    }
                    min = Math.min(min, tmpStep);
                }
            }
        } else if (word1.length() > word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                if (i >= word2.length() || word1.charAt(i) != word2.charAt(i)) {
                    tmpStep = minDistanceHelper(delete(word1, i), word2, step + 1) + 1;
                    if (tmpStep > maxLen) {
                        return tmpStep;
                    }
                    min = Math.min(min, tmpStep);
                }

            }
        } else {
            int tmp = 0;
            int del = min;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    tmp++;
                    del = Math.min(del, minDistanceHelper(delete(word1, i), word2, step + 1) + 1);
                }
            }
            min = Math.min(min, tmp);
            min = Math.min(min, del);
        }
        return min;

    }

    public static String insert(String word, int index, char ch) {
        StringBuilder res = new StringBuilder(word);
        res.insert(index, ch);
        return res.toString();
    }

    public static String delete(String word, int index) {
        StringBuilder res = new StringBuilder(word);
        res.delete(index, index + 1);
        return res.toString();
    }

    public static String modifiy(String word, int index, char ch) {
        StringBuilder res = new StringBuilder(word);
        res.setCharAt(index, ch);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.print(minDistance("sea", "eat") + "");
        System.out.print(minDistance("mart", "karma") + "");
    }
}
