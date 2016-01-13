import sun.rmi.runtime.Log;

import java.util.Arrays;

/**
 * Created by winney on 16/1/11.
 */
public class isInterleave {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     *
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.equals(s1 + s2)) {
            return true;
        }
        int[][] flag = new int[2][s3.length()];
        int last = 0;
        for (int i = 0; i < s1.length(); i++) {
            int tmp = 0;
            for (int j = last; j < s3.length(); j++) {
                if (s3.charAt(j) == s1.charAt(i)) {
                    flag[0][j] = i + 1;
                    if (tmp == 0) {
                        tmp = i;
                    }
                }
            }
            last = tmp;
        }

        for (int i = 0; i < Math.max(s2.length(), s1.length()); i++) {
            int tmp = 0;
            for (int j = last; j < s3.length(); j++) {
                if (i < s2.length() && s3.charAt(j) == s2.charAt(i)) {
                    flag[1][j] = -(i + 1);
                    if (tmp == 0) {
                        tmp = i;
                    }
                } else if (flag[1][j] == 0 && flag[0][j] > 0) {
                    flag[1][j] = flag[0][j];
                }
            }
            last = tmp;
        }

        for (int i = 0; i < flag[0].length; i++) {
            if (flag[1][i] == 0) {
                return false;
            }
            System.out.println(flag[1][i] + "  " + flag[0][i]);
        }
        Arrays.sort(flag[1]);
        if (flag[1][0] == -s2.length() && flag[1][s3.length() - 1] == s1.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "sdfjas;dfjoisdufzjkndfasdkfja;sdfa;dfa;dfaskdjhfasdhjdfakhdgfkajdfasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfhakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh";
        String b = "dfnakdjnfjkzghdufguweygfasjkdfgb2gf8asf7tgbgasjkdfgasodf7asdgfajksdfguayfgaogfsdkagfsdhfajksdvfbgkadsghfakdsfgasduyfgajsdkfgajkdghfaksdgfuyadgfasjkdvfjsdkvfakfgauyksgfajkefgjkdasgfdjksfgadjkghfajksdfgaskdjfgasjkdgfuyaegfasdjkfgajkdfygadjskfgjkadfg";
        String c = "sdfjas;dfjoisdfnakdjnfjkzghdufguwdufzjkeygfasjkdfgb2gf8asf7ndtgbgasjkdfgasodf7asdfgfajkasdksdfguayfgaogfsdkagfsfjadhfajksdvfbgkadsghfa;sdkdsfgasduyfgajsdkfgafajkdghfaksdgfuyadgfas;dfjkdvfjsdkvfakfgauyksa;dgfajkefgjkdasgfdjksffaskdjhfasdhjdfakhdgadjkghfajgfkajdfksdfgaskdjfgasjkdgfuasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfyaegfasdjkfgajkdfygadjskfgjkadfghakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh";

        System.out.print(isInterleave("abcabc", "ac", "aabcabcc") + "");
//        System.out.print(isInterleave(a, b, c) + "");
    }
}
