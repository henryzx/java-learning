package cc150.chpt2;

import java.util.Arrays;

/**
 * 2.1 Suppose we have an array a1, a2, ..., an, b1, b2, ..., bn. Implement an algorithm to change this array to a1, b1, a2, b2, ..., an, bn.
 * Created by zhengxiao on 7/13/14.
 */
public class Q1 {
    public static void main(String[] args) {
        int[] array = new int[6];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
        splitAndInsert(array, 0, array.length);
        System.out.println(" !end!");
        System.out.println(Arrays.toString(array));
    }

    private static void splitAndInsert(int[] array, int start, int end) {
        // divide into 4 region
        int newLength = end - start;
        if (newLength < 4) return;
        int regionStep = newLength / 4;

        // swap 2 and 3
        exchange(array, start + regionStep, start + 2 * regionStep, start + 2 * regionStep, start + 3 * regionStep);
        System.out.println(Arrays.toString(array));
        // then swap each of the result region
        splitAndInsert(array, start, start + 2 * regionStep);
        splitAndInsert(array, start + 2 * regionStep, start + regionStep * 4);
    }

    private static void exchange(int[] array, int iFromStart, int iFromEnd, int iToStart, int iToEnd) {
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
