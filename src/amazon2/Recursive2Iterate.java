package amazon2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhengxiao on 14-3-12.
 */
public class Recursive2Iterate {

    public static void main(String[] args) {
        int count1 = iterate(10);
        System.out.println(count1);
        int count2 = recursive(10);
        System.out.println(count2);
        int count3 = iterate2(10);
        System.out.println(count3);
    }

    private static int recursive(int n) {
        if (n == 0) {
            return 0;
        } else {
            return recursive(n - 1) + n;
        }
    }

    private static int iterate(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += i;
        }
        return count;
    }

    private static int iterate2(int n) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int count = 0;

        while (true) {
            if (n == 0) {
                stack.push(0);
                break;
            } else {
                stack.push(n--);
            }
        }

        while (!stack.isEmpty()) {
            count += stack.pop();
        }

        return count;
    }
}
