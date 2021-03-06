package cc150.chpt1;

/**
 * Created by zhengxiao on 3/31/14.
 */
public class Q1_2 {
    public static void main(String[] args) {
        System.out.println(count2s(35));
    }

    private static int count2s(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            // if contains 2
            boolean contains2 = false;
            int shiftedI = i;
            while (shiftedI > 0) {
                int lastDigit = lastDigit(shiftedI);
                if (lastDigit == 2) {
                    contains2 = true;
                    System.out.println(i);
                    break;
                }
                shiftedI = shiftRight(shiftedI);
            }
            if (contains2) {
                count++;
            }
        }
        return count;
    }

    private static int lastDigit(int i) {
        return i % 10;
    }

    private static int shiftRight(int i) {
        return i / 10;
    }
}
