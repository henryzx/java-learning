package cc150.chpt2;

import java.util.Arrays;

/**
 * 2.1 Suppose we have an array a1, a2, ..., an, b1, b2, ..., bn. Implement an algorithm to change this array to a1, b1, a2, b2, ..., an, bn.
 * Created by zhengxiao on 7/13/14.
 */
public class Q1S1 {
    public static void main(String[] args) {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
        splitAndInsert(array, 0, array.length);
        System.out.println(" !end!");
        System.out.println(Arrays.toString(array));
    }

    private static void splitAndInsert(int[] array, int p, int q) {
        // divide into 4 region
        if (p == q) return;

        int r = (p + q) / 2;
        // swap 2 and 3
        exchange(array, (p + r) / 2, r, (p + q) / 2, (r + q) / 2);
        System.out.println(Arrays.toString(array));
        // then swap each of the result region
        splitAndInsert(array, p, r);
        splitAndInsert(array, r + 1, q);
    }

    private static void exchange(int[] array, int iFromStart, int iFromEnd, int iToStart, int iToEnd) {
        int l1 = iFromEnd - iFromStart;
        int l2 = iToEnd - iToStart;
        if (l1 != l2)
            throw new IllegalArgumentException(String.format("length must be equal: l1 = %s, l2 = %s", l1, l2));
        int iTo = iToStart;
        for (int i = iFromStart; i < iFromEnd; i++) {
            swap(array, i, iTo);
            iTo++;
        }
    }

    private static void swap(int[] array, int iFrom, int iTo) {
        int oldTo = array[iTo];
        array[iTo] = array[iFrom];
        array[iFrom] = oldTo;
    }
}
