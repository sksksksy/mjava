package zhp.win.util;

import java.util.Base64;

public class EnDeCodeUtil {
    public static String EnCodeByBase64(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }
    public static String DecodeByBase64(byte[] dec){
        byte[] bytes=Base64.getDecoder().decode(dec);
        return new String(bytes);
    }
}
