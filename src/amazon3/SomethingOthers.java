package amazon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhengxiao on 14-3-13.
 */
public class SomethingOthers {
    public static void main(String[] args) throws Exception {
        String input = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
        } catch (IOException ignored) {
        }

        if (input == null) return;
        String[] inputVariables = input.split(" ");
        if (inputVariables.length == 0 || inputVariables.length != 2) return;
        int n, m;
        try {
            n = Integer.parseInt(inputVariables[0]);
            m = Integer.parseInt(inputVariables[1]);
        } catch (NumberFormatException ignored) {
            return;
        }

        List<Integer> data = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            data.add(i);
        }

        int mIndex = data.indexOf(m);
        if (mIndex != -1) {
            data.remove(mIndex);
        }

        if (data.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        printList(data);

        List<Integer> next = new LinkedList<Integer>(data);
        int first = next.remove(0);
        next.add(first);
        printList(next);

        List<Integer> pre = new LinkedList<Integer>(data);
        int last = pre.remove(pre.size() - 1);
        pre.add(0, last);
        printList(pre);

    }

    private static void printList(List<Integer> data) {
        StringBuilder b = new StringBuilder();
        for (Integer integer : data) {
            if (b.length() != 0) b.append(' ');
            b.append(integer);
        }
        System.out.println(b.toString());
    }
}
