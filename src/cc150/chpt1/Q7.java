package cc150.chpt1;

/**
 * 1. 7 Write a method to implement *, - , / operations. You should use only the + operator.
 * Created by zhengxiao on 7/13/14.
 */
public class Q7 {
    public static void main(String[] args) {
        System.out.println(multi(2, 4));
        System.out.println(minus(2));
        System.out.println(minus(2, 4));
        System.out.println(divide(4, 4));
    }

    public static int multi(int a, int b) {
        if (b > a) return multi(b, a);// b 要尽量小
        int sum = 0;
        while (b > 0) {
            sum += a;
            b--;
        }
        return sum;
    }

    public static int divide(int a, int b) {
        int quotient = 0;
        int dividend = a > 0 ? a : minus(a);
        int divider = b > 0 ? b : minus(b);
        while (dividend > 0) {
            dividend -= divider;
            quotient++;
        }

        if (a < 0 && b > 0 || a > 0 && b < 0) {
            quotient = minus(quotient);
        }
        return quotient;
    }

    public static int minus(int a, int b) {
        return a + minus(b);
    }

    public static int minus(int a) {
        int r = 0;
        int d = a < 0 ? 1 : -1;
        while (a != 0) {
            r += d;
            a += d;
        }
        return r;
    }
}
