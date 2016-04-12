import java.security.MessageDigest;

/**
 * Created by winney on 16/3/31.
 */
public class MD5 {
    public static String EncodeMD5Hex(String text) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes("GB2312"));
        byte[] digest = md.digest();
        StringBuffer md5 = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            md5.append(Character.forDigit((digest[i] & 0xF0) >> 4, 16));
            md5.append(Character.forDigit((digest[i] & 0xF), 16));
        }
        return md5.toString().toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(EncodeMD5Hex("<POS tid='' tname='韦毅雄' simno='13146447806' gtime='2015-12-27 21:58:28' atime='2015-12-27 21:58:28' star='0' x='116367278' y='39951141' z='0' speed='0' dir='0' type='0' other='0'/>"));

        System.out.print(EncodeMD5Hex("YuYao<POS tid='' tname='' simno='13146447806' gtime='2015-12-27 21:58:28' atime='2015-12-27 21:58:28' star='0' x='116367278' y='39951141' z='0' speed='0' dir='0' type='0' other='0' />123"));
    }
}
