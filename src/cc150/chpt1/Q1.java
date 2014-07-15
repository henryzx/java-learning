package cc150.chpt1;

/**
 * Write a method to generate the nth Fibonacci number
 * Created by zhengxiao on 3/31/14.
 */
public class Q1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
