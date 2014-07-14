package amazon2;

import javafx.util.Pair;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * consider a kind of configuration file in amazon sofeware system. this kind of configuration file's format looks like this:
 * <p/>
 * B=10;
 * <p/>
 * A={
 * <p/>
 * A=100;
 * <p/>
 * B=BDE;
 * <p/>
 * C=C;
 * <p/>
 * D={
 * <p/>
 * A=windows;
 * <p/>
 * B=mac;
 * <p/>
 * C={
 * <p/>
 * A=redhat;
 * <p/>
 * B=ubuntu;
 * <p/>
 * };
 * <p/>
 * };
 * <p/>
 * A+={
 * <p/>
 * A=200;
 * <p/>
 * E=1000;
 * <p/>
 * };
 * <p/>
 * to repsent the key of the configuration, we use period(.) delimated method. for example,A.B represents the element B in Map A, and  the value of A.B is BDE; similarly,  the value of A.D.C.A is redhat. the the represent string is called 'path expression'.
 * <p/>
 * the configuration also support append and override operation. for the above example, we use += operation to append or override the value in Map A. now the value of A.A is 200, and the value of A.E is 1000;
 * <p/>
 * Now, given a configuration strings and the key path of configuration, please return the value of configuration based the configuration strings.
 * Created by zhengxiao on 14-3-12.
 */
public class Question2 extends TestCase {
    public void testRules() {
        String[] input = {"A={A=1;B=2;C=3;E={A=100;};};", "A+={D=4;E={B=10;C=D;};};"};
        String[] exs = {"A.E.B", "B.D.E"};
        String[] expectedOut = {"10", "N/A"};

        String[] actualOut = calculateAndPrint(input, exs);
        System.out.println(Arrays.toString(expectedOut));
        System.out.println(Arrays.toString(actualOut));
        assertTrue(Arrays.equals(expectedOut, actualOut));
    }

    private String[] calculateAndPrint(String[] confs, String[] exs) {
        ArrayList<String> outputs = new ArrayList<String>();
        Parser parser = new Parser();
        for (int i = 0; i < confs.length; i++) {
            String conf = confs[i];
            parser.consume(conf);
        }
        for (String ex : exs) {
            outputs.add(parser.parse(ex));
        }
        return outputs.toArray(new String[0]);
    }

    public static class Parser {

        public String parse(String ex) {
            if (map.containsKey(ex)) {
                Object o = map.get(ex);
                if (o instanceof String) {
                    return (String) o;
                }
            }
            return "N/A";
        }

        /// consumer

        String in;
        int pos;
        Map<String, Object> map = new HashMap<String, Object>();

        public void consume(String conf) {
            this.in = conf;
            pos = 0;
            Pair<String, Object> pair = readAssign("");
            System.out.println(pair);
        }

        private Pair<String, Object> readAssign(String parentName) {
            String name = (String) nextValue(parentName);
            name = (!parentName.isEmpty() ? (parentName + ".") : "") + name;
            String operator = (String) nextValue(name);
            Object object = nextValue(name);
            String end = (String) nextValue(name);

            if (operator.equals("=")) {
                if (!map.containsKey(name))
                    map.put(name, object);
            } else if (operator.equals("+=")) {
                map.put(name, object);
            }
            return new Pair<String, Object>(name, object);
        }

        /**
         * 读取下一个完整token，如果是String 则返回string, 是 = 则返回 char等
         *
         * @param parentName
         * @return
         */
        private Object nextValue(String parentName) {
            char c = in.charAt(pos++);
            switch (c) {
                case '=':
                case ';':
                    return "" + c;
                case '+':
                    return c + "" + nextValue(parentName);
                case '{':
                    return readObject(parentName);
                default:
                    pos--;
                    return readString();
            }
        }

        private Object readObject(String parentName) {
            Map<String, Object> obj = new HashMap<String, Object>();
            while (pos < in.length()) { // assign 的循环
                int c = in.charAt(pos);
                if (c == '}') {
                    pos++; // skip this char
                    return obj;
                }
                Pair<String, Object> pair = readAssign(parentName);
                obj.put(pair.getKey(), pair.getValue());
            }
            throw new IllegalStateException("unfinished object");
        }

        private String readString() {
            int start = pos;
            while (pos < in.length()) {
                int c = in.charAt(pos++);
                if (";=+".indexOf(c) != -1) {
                    // found delimiter, break
                    pos--;
                    return in.substring(start, pos);
                }
            }
            throw new IllegalStateException("unfinished string");
        }
    }
}