package cc150.chpt2;

/**
 * 2.3 You are given an array of integers (both positive and negative). Find the continuous
 * sequence with the largest sum. Return the sum.
 * EXAMPLE
 * input: {2, -8, 3, -2, 4, -10}
 * output: 5 [ eg, {3, -2, 4} ]
 * <p/>
 * Kadane算法
 * see http://blog.csdn.net/joylnwang/article/details/6859677
 * <p/>
 * 我们以array={−2, 1, −3, 4, −1, 2, 1, −5, 4}为例，来简单说明一下算法步骤。
 * 通过遍历，可以将数组分割为如下3个子串（-2），（1，-3），（4，-1，2，1，-5，4），
 * 这里对于（-2）这样的情况，单独分为一组。各子串的最大前缀和为-2，1，6，所以目标串的最大子串和为6。
 * Created by zhengxiao on 7/13/14.
 */
public class Q3S2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, -8, 3, -2, 4, -10};
        int largestArrSum = findLargestSubArraySum(arr);
        System.out.println(largestArrSum);
    }

    public static int findLargestSubArraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int data = arr[i];
            runningSum += data;
            if (runningSum > maxSum) {
                // 发现当前最大子序列，做快照
                maxSum = runningSum;
            }
            if (runningSum < 0) {
                // 分组结束，新分组开始
                // 重置 runningSum
                runningSum = 0;
            }
        }
        return maxSum;
    }
}
