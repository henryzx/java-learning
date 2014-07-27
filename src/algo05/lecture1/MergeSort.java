package algo05.lecture1;

import java.util.Arrays;

/**
 * Created by zhengxiao on 7/27/14.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] input = new int[]{5, 4, 3, 2, 1};
        int[] output = mergeSort(input);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(output));
    }

    private static int[] mergeSort(int[] input) {
        int length = input.length;
        int[] output = new int[length];
        if (length == 2) {
            // meet the minimal possible to sort, sort it now and return result
            if (input[0] < input[1]) {
                output[0] = input[0];
                output[1] = input[1];
            } else {
                output[0] = input[1];
                output[1] = input[0];
            }
            return output;
        } else if (length < 2) {
            // is not dividable, return now
            output = input;
            return output;
        }

        // is dividable, so we divide input into two

        int[] firstPart = Arrays.copyOfRange(input, 0, length / 2);
        int[] secondPart = Arrays.copyOfRange(input, length / 2, length);
        int[] firstPartSorted = mergeSort(firstPart);
        int[] secondPartSorted = mergeSort(secondPart);

        // merge
        int i1 = 0, i2 = 0;
        for (int i = 0; i < output.length; i++) {
            Integer first = null, second = null;
            if (i1 < firstPartSorted.length) {
                first = firstPartSorted[i1];
            }
            if (i2 < secondPartSorted.length) {
                second = secondPartSorted[i2];
            }
            if (first != null && second != null) {
                if (first < second) {
                    output[i] = first;
                    i1++;
                } else {
                    output[i] = second;
                    i2++;
                }
            } else if (first == null && second != null) {
                output[i] = second;
                i2++;
            } else if (first != null && second == null) {
                output[i] = first;
                i1++;
            }
        }
        return output;
    }
}
