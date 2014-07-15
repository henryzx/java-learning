package cc150.chpt6;

/**
 * 6.4 Implement an algorithm to print all valid (eg, properly opened and closed) combina-
 * tions of n-pairs of parentheses.
 * EXAMPLE:
 * input: 3 (eg, 3 pairs of parentheses)
 * output: ()()(), ()(()), (())(), ((()))
 * Created by zhengxiao on 7/16/14.
 */
public class Q4 {
    public static void main(String[] args) {
        printAllValidPairs(5);
    }

    private static void printAllValidPairs(int n) {
        printParenInternal(n, n, n, "");
    }

    private static void printParenInternal(int n, int l, int r, String str) {
        if (l < 0 || r < 0) return;
        if (l == 0 && r == 0) {
            boolean isValid = true;
            int count = 0;
            for (char c : str.toCharArray()) {
                switch (c) {
                    case '(':
                        count++;
                        break;
                    case ')':
                        count--;
                        break;
                }
                if (count < 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                System.out.println(str);
        } else {
            if (l > 0) {// try a left paren
                printParenInternal(n, l - 1, r, str.concat("("));
            }
            if (r > 0) {
                printParenInternal(n, l, r - 1, str.concat(")"));
            }
        }
    }


}
