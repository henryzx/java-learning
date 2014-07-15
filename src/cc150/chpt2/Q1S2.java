package cc150.chpt2;

import java.util.Arrays;

/**
 * 2.1 Suppose we have an array a1, a2, ..., an, b1, b2, ..., bn. Implement an algorithm to change this array to a1, b1, a2, b2, ..., an, bn.
 * Created by zhengxiao on 7/13/14.
 */
public class Q1S2 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
        shaffleByRotate(array);
        System.out.println(" !end!");
        System.out.println(Arrays.toString(array));
    }

    private static void shaffleByRotate(int[] array) {
        int N = array.length / 2;
        for (int i = 0, j = 1; i < N; i++, j += 2) {
            rightRotate(array, j, N + i);
        }
    }

    /**
     * right rotate sub-array arr[j] to arr[N+i]
     *
     * @param array
     * @param j
     * @param n
     */
    private static void rightRotate(int[] array, int j, int n) {
        if (n < j) throw new IllegalArgumentException("right rotate but n < j");
        int oldN = array[n];
        for (int i = n - 1; i >= j; i--) {
            array[i + 1] = array[i];
        }
        array[j] = oldN;
    }
}
