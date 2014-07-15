package cc150.chpt2;

/**
 * 2.3 You are given an array of integers (both positive and negative). Find the continuous
 * sequence with the largest sum. Return the sum.
 * EXAMPLE
 * input: {2, -8, 3, -2, 4, -10}
 * output: 5 [ eg, {3, -2, 4} ]
 * <p/>
 * 穷举法
 * Created by zhengxiao on 7/13/14.
 */
public class Q3 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, -8, 3, -2, 4, -10};
        int largestArrSum = findLargestSubArraySum(arr);
        System.out.println(largestArrSum);
    }

    private static int findLargestSubArraySum(int[] arr) {
        int length = arr.length;

        int head = 0;
        int tail = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int sum = sum(arr, i, j);
                if (sum > maxSum) {
                    maxSum = sum;
                    head = i;
                    tail = j;
                }
            }
        }

        System.out.printf("head:%s, tail:%s\n", head, tail);

        return maxSum;
    }

    private static int sum(int[] arr, int head, int i) {
        int sum = 0;
        while (head < i && head < arr.length) {
            sum += arr[head];
            head++;
        }
        return sum;
    }
}
