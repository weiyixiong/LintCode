import java.util.ArrayList;

/**
 * Created by winney on 16/2/17.
 */
public class restoreIpAddresses {

    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s.length() == 0 || s.length() > 12) {
            return res;
        }
        restore(s, null, res, 0);
        return res;

    }
    public void restore(String s, String ip, ArrayList<String> res, int dot) {
        if (s.length() == 0) {
            if (dot == 3)
                res.add(ip);
            return;
        }
        for (int i = 0; i < 3 && i < s.length(); i++) {
            int tmp = Integer.parseInt(s.substring(0, i+1));
            if (tmp >= 0 && tmp <= 255) {
                if (ip != null) {
                    restore(s.substring(i+1), ip+"." + tmp, res, dot + 1);
                }else{
                    restore(s.substring(i+1), "" + tmp, res, dot);
                }
                if (tmp == 0) {
                    break;
                }
            }
        }
    }


}
