package amazon2;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Let's assume that there is a simple market for beans. Every day there is a published bean price in the market.
 * Traders can buy or sell at the published price. There is a trader who time travelled to future and brought back
 * the price information for a number of days in the future. If you have this information and you are allowed to buy
 * and sell many times. How do you make the maximum profit? The price information will be given as an array of numbers.
 * Each number is for a day’s trading price. The numbers are all integers to simplify the problem.
 * You will need to return the index of the buy-in point and sell-out point for maximum profit.
 * <p/>
 * Rules:
 * <p/>
 * 1) The input line length less than 1000, and the trading price length less than 100;
 * <p/>
 * 2) The trading price is positive integer;
 * <p/>
 * 3) The trading prices are delimited  by ' '(single space);
 * <p/>
 * 4) Please make sure every buying and selling period shortest. especially, please ouput '-' if all the trading prices are the same or no trading point;
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * Sample Input and Output:
 * <p/>
 * Input 1
 * <p/>
 * 1 3 5 4 2 8 10
 * <p/>
 * Output 1
 * <p/>
 * 1 3 5 7
 * <p/>
 * To make the maximum profit, you should buy at $1 and sell at $5, and then buy at $5 and sell it at $10.
 * so the output is "1 3 5 7".
 * <p/>
 * Input 2
 * <p/>
 * 1 1 1 3 5 4 2 2 2 8 10
 * <p/>
 * Ouput 2
 * <p/>
 * 3 5 9 11
 * <p/>
 * <p/>
 * Created by zhengxiao on 14-3-12.
 */
public class Buy extends TestCase {

    public void testResult() {
        int[] inputs = {1, 3, 5, 4, 2, 8, 10};
        int[] expectOutput = {1, 3, 5, 7};
        int[] actualOutput = getMaxProfit(inputs);
        System.out.println(Arrays.toString(expectOutput));
        System.out.println(Arrays.toString(actualOutput));
        assertTrue(Arrays.equals(expectOutput, actualOutput));
    }

    private int[] getMaxProfit(int[] inputs) {


        ArrayList<Integer> ins = new ArrayList<Integer>();
        ArrayList<Integer> outs = new ArrayList<Integer>();

        int[] delta = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            if (i == 0) continue;
            if (inputs[i] > inputs[i - 1]) {
                delta[i] = 1;
            } else if (inputs[i] < inputs[i - 1]) {
                delta[i] = -1;
            }
        }

        // inner
        for (int i = 0; i < delta.length; i++) {
            if (i == 0) continue;
            if (delta[i] == 1 && (delta[i - 1] == -1 || delta[i - 1] == 0)) {
                // ins
                ins.add(i - 1);
            } else if (delta[i] == -1 && delta[i - 1] == 1) {
                // outs
                outs.add(i - 1);
            } else if (i == delta.length - 1) {
                if (delta[i] == 1) {
                    outs.add(i);
                }
            }
        }

        ArrayList<Integer> inOuts = new ArrayList<Integer>();
        int iIn = 0, iOut = 0;
        boolean isIn = true;
        boolean inEnd = false, outEnd = false;
        while (true) {
            if (isIn) {
                if (iIn == ins.size()) {
                    inEnd = true;
                } else {
                    inOuts.add(ins.get(iIn));
                    iIn++;
                }
            } else {
                if (iOut == outs.size()) {
                    outEnd = true;
                } else {
                    inOuts.add(outs.get(iOut));
                    iOut++;
                }
            }
            isIn = !isIn;
            if (inEnd && outEnd) break;

        }
        int i = 0;
        for (Integer inOut : inOuts) {
            inOuts.set(i, inOut + 1);
            i++;
        }
        return toPrimitive(inOuts);
    }

    public int[] toPrimitive(List<Integer> list) {
        int[] out = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            out[i] = list.get(i);
        }
        return out;
    }

}
