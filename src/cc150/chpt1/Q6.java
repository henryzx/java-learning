package cc150.chpt1;

/**
 * 1. 6 Write a function that adds two numbers. You should not use + or any arithmetic operators.
 * Created by zhengxiao on 7/13/14.
 */
public class Q6 {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }

    private static int add(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int s = a ^ b;
        int c = (a & b) << 1;
        return add(s, c);
    }
}
