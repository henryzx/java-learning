package cc150.chpt2;

/**
 * 2.2 Design an algorithm and write code to remove the duplicate characters in a string with- out using any additional buffer. NOTE: One or two additional variables is fine. An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 * Created by zhengxiao on 7/13/14.
 */
public class Q2 {
    public static void main(String[] args) {
        System.out.println(removeDup("aaaabbbaadd"));
    }

    public static String removeDup(String inStr) {
        if (inStr == null) return null;
        char[] in = inStr.toCharArray();
        int length = inStr.length();
        if (length < 2) return inStr;

        int tail = 1;// splitter between existed and remaining
        outer:
        for (int i = 1; i < length; ++i) {
            char c = in[i];
            for (int j = 0; j < tail; ++j) {
                if (in[j] == c) {
                    // c以前看见过，是重复, 跳过
                    continue outer;
                }
            }
            // 没有找到重复项，将这项纳入tail前
            in[tail++] = c;
        }

        // clear up tail
        while (tail < length) {
            in[tail++] = '\0';
        }
        return new String(in);
    }

}
