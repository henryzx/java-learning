package xiaomi;

/**
 * Created by zhengxiao on 7/9/14.
 */
public class StringTrim {

    /**
     * stRing     nAme  -> String Name
     *
     * @param inputString
     * @return
     */
    public static String trim(String inputString) {
        if (inputString == null) return null;
        char[] in = inputString.toCharArray();

        int i = 0;
        while (true) {
            int iNextWordStart = findNextWordStart(in, i);
            if (iNextWordStart == in.length) {
                int end = i;
                if (end - 1 >= 0 && in[end - 1] == ' ') end--;
                while (end < in.length) {
                    in[end] = '\0';
                    end++;
                }
                break;
            }
            int iWordEnd = findWordEnd(in, iNextWordStart);
            int wordWidth = iWordEnd - iNextWordStart;
            if (wordWidth == 0) break;
            swipeWord(in, iNextWordStart, iWordEnd, i);
            processWord(in, i, i + wordWidth);
            i = i + wordWidth + 1;
        }

        return new String(in);
    }

    private static void processWord(char[] in, int start, int end) {
        char initial = in[start];
        if (initial >= 'a' && initial <= 'z') {
            in[start] = (char) ((int) initial + 'A' - 'a');
        }
        while (++start < end) {
            char c = in[start];
            if (c >= 'A' && c <= 'Z') {
                in[start] = (char) (c - ('A' - 'a'));
            }
        }
    }

    private static int findNextWordStart(char[] in, int start) {
        while (start < in.length && in[start] == ' ') {
            start++;
        }
        return start;
    }

    private static int findWordEnd(char[] in, int start) {
        while (start < in.length && in[start] != ' ') {
            start++;
        }
        return start;
    }


    /**
     * @param in
     * @param wordStart include
     * @param wordEnd   exclude
     * @param to
     * @return
     */
    private static void swipeWord(char[] in, int wordStart, int wordEnd, int to) {
        for (int i = wordStart; i < wordEnd; i++) {
            swipe(in, i, to++);
        }
    }

    private static void swipe(char[] in, int from, int to) {
        char temp = in[to];
        in[to] = in[from];
        in[from] = temp;
    }

    public static void main(String[] args) {
        String input = "   stRing     nAme      ";
        String output = trim(input);
        System.out.printf("{%s}", input);
        System.out.printf("{%s}", output);
    }

}
