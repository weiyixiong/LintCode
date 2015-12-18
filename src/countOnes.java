/**
 * Created by winney on 15/12/18.
 */
public class countOnes {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        int res = 0;
        while (num != 0) {
            num &= (num - 1);
            res++;
        }
        return res;
    }

}
