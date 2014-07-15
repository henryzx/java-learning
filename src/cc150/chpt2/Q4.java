package cc150.chpt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2.4 Design an algorithm to find all pairs of integers within an array which sum to a specified value
 * Created by zhengxiao on 7/13/14.
 */
public class Q4 {
    public static class Pair {
        public int first;
        public int second;

        public Pair(int i1, int i2) {
            this.first = i1;
            this.second = i2;
        }

        @Override
        public String toString() {
            return String.format("[%s, %s)", first, second);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 6, 2};
        Pair[] pairs = findPairs(arr, 11);
        System.out.println("pairs: " + Arrays.toString(pairs));
    }

    private static Pair[] findPairs(int[] arr, int target) {
        List<Pair> pairs = new ArrayList<Pair>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (sum(arr, i, j) == target) {
                    pairs.add(new Pair(i, j));
                }
            }
        }
        return pairs.toArray(new Pair[pairs.size()]);
    }

    private static int sum(int[] arr, int i1, int i2) {
        int sum = 0;
        while (i1 < i2) {
            sum += arr[i1++];
        }
        return sum;
    }


}
