package amazon4;

/**
 * Created by zhengxiao on 4/15/14.
 */
public class StringCompresser {

    public static final String TARGET_STRING = "aaaabcddddeeee";
    public static final String TARGET_COMPRESSED_STRING = "a4bcd4e4";

    public static void main(String[] args) {
        String compressedString = compressString(TARGET_STRING);
        System.out.println(compressedString);
        System.out.println(compressedString.equals(TARGET_COMPRESSED_STRING));
    }

    private static String compressString(String target) {
        StringBuffer sb = new StringBuffer();
        char[] chars = target.toCharArray();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 >= chars.length || chars[i] != chars[i + 1]) {
                sb.append(chars[i]);
                if (count > 1)
                    sb.append(Integer.toString(count));
                count = 1;
            } else {
                count++;
            }
        }
        return sb.toString();
    }
}
