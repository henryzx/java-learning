package amazon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * http://www.cnblogs.com/supersteven/archive/2012/09/20/2695383.html
 * <p/>
 * There is a 5*5 matrix; the elements in this matrix are different integer from 0 to 24. The elements in this matrix are disordered. 0 is a special element. The upper element, under element, left element and right element of 0 can be exchanged with 0. Such exchange operations are named as ‘U’, ‘D’, ‘L’ and ‘R’.
 * <p/>
 * Operation "U" means 0 exchanged with its upper element.
 * <p/>
 * Operation "D" means 0 exchanged with its under element.
 * <p/>
 * Operation "L" means 0 exchanged with its left element.
 * <p/>
 * Operation "R" means 0 exchanged with its right element.
 * <p/>
 * <p/>
 * <p/>
 * For example, the original matrix is
 * <p/>
 * [20, 18, 7, 19, 10
 * <p/>
 * 24, 4, 15, 11, 9
 * <p/>
 * 13, 0, 22, 12, 14
 * <p/>
 * 23, 16, 1, 2, 5
 * <p/>
 * 21, 17, 8, 3, 6]
 * <p/>
 * With the operation sequence “URRDDL”, the new matrix will be
 * <p/>
 * [20, 18, 7, 19, 10
 * <p/>
 * 24, 15, 11, 12, 9
 * <p/>
 * 13, 4, 22, 2, 14
 * <p/>
 * 23, 16, 0, 1, 5
 * <p/>
 * 21, 17, 8, 3, 6]
 * <p/>
 * Now, we know the original matrix, the matrix after the operations and all the operations made on the original matrix. Please provide the correct sequence for the operations.
 * <p/>
 * The input will be the original matrix, the target matrix and an operation sequence with wrong order.
 * <p/>
 * If there is a correct sequence for this input, then print the correct sequence. Otherwise, print “None”.
 * <p/>
 * <p/>
 * <p/>
 * Rules and example:
 * <p/>
 * The elements in the original matrix are different.
 * The elements in the original matrix are random ordered.
 * The max lenght of operatoins is 15.
 * If "0" is already on the boundary, it is not possible to do further movement. for example, if 0 is in the top row, then there is no more "U".
 * The input will be the original matrix, the target matrix and an operation sequence with wrong order.
 * The output will be a correct operation sequence.
 * In case there is no way to get the target matrix with the input operations, please output “None”
 * Don’t include any space in the generated operation sequence.
 * For examples, the original matrix is
 * Example 1:
 * <p/>
 * [20, 18, 7, 19, 10
 * <p/>
 * 24, 4, 15, 11, 9
 * <p/>
 * 13, 0, 22, 12, 14
 * <p/>
 * 23, 16, 1, 2, 5
 * <p/>
 * 21, 17, 8, 3, 6]
 * <p/>
 * The target matrix is
 * <p/>
 * [20, 18, 7, 19, 10
 * <p/>
 * 24, 4, 0, 11, 9
 * <p/>
 * 13, 22, 15, 12, 14
 * <p/>
 * 23, 16, 1, 2, 5
 * <p/>
 * 21, 17, 8, 3, 6]
 * <p/>
 * The input operation sequence is “UR”
 * <p/>
 * The output operation sequence should be “RU”
 * <p/>
 * Example 2:
 * <p/>
 * [20, 18, 7, 19, 10
 * <p/>
 * 24, 4, 15, 11, 9
 * <p/>
 * 13, 0, 22, 12, 14
 * <p/>
 * 23, 16, 1, 2, 5
 * <p/>
 * 21, 17, 8, 3, 6]
 * <p/>
 * The target matrix is
 * <p/>
 * [20, 18, 7, 19, 10
 * <p/>
 * 24, 15, 11, 12, 9
 * <p/>
 * 13, 4, 22, 2, 14
 * <p/>
 * 23, 16, 0, 1, 5
 * <p/>
 * 21, 17, 8, 3, 6]
 * <p/>
 * The input operation sequence is “RRLUDD”
 * <p/>
 * The output operation sequence should be “URRDDL”
 * Created by zhengxiao on 14-3-9.
 */
public class Question2 {

    public static final int[][] originalMatrix = {
            {20, 18, 7, 19, 10},
            {24, 4, 15, 11, 9},
            {13, 0, 22, 12, 14},
            {23, 16, 1, 2, 5},
            {21, 17, 8, 3, 6},
    };

    public static final int[][] targetMatrix = {
            {20, 18, 7, 19, 10},
            {24, 15, 11, 12, 9},
            {13, 4, 22, 2, 14},
            {23, 16, 0, 1, 5},
            {21, 17, 8, 3, 6},
    };

    public static final char[] operations = "RRLUDD".toCharArray();
    public static final char[] expectedOperations = "URRDDL".toCharArray();


    public static void main(String[] args) {
        ArrayList<String> perms = new ArrayList<String>();
        perm(perms, operations, 0, operations.length - 1);

        System.out.println(String.format("operations.length %s, perm length expected %s, actual %s", operations.length, factorial(operations.length), perms.size()));
        // 找到0的坐标
        int y = 0;
        int x = 0;
        boolean found = false;
        outer:
        for (int[] intline : originalMatrix) {
            x = 0;
            for (int intx : intline) {
                if (intx == 0) {
                    found = true;
                    break outer;
                }
                x++;
            }
            y++;
        }
        if (!found) {
            System.out.println("not found");
            return;
        } else {
            System.out.println(String.format("found %s x %s", x, y));
        }

        for (String perm : perms) {
            // 一次迭代
            int[][] actualMatric = runThroughString(originalMatrix, perm, x, y);
            if ("URRDDL".equals(perm)) {
                System.out.println("this is the right matrix");
            }
            if (Arrays.deepEquals(actualMatric, targetMatrix)) {
                // 成功
                System.out.println("found operation: " + perm);
                break;
            } else {
                continue;
            }
        }
        System.out.println("not found");
    }

    private static int[][] runThroughString(int[][] originalMatrix, String perm, int startx, int starty) {
        int[][] copyMatrix = new int[originalMatrix.length][5];
        int l = 0;
        for (int[] ints : originalMatrix) {
            copyMatrix[l++] = Arrays.copyOf(ints, ints.length);
        }

        for (int i = 0; i < perm.length(); i++) {
            char op = perm.charAt(i);
            switch (op) {
                case 'R': {
                    int tox = startx + 1;
                    if (tox < 5) {
                        swapMulti(copyMatrix, startx, starty, tox, starty);
                        startx = tox;
                    }
                }
                break;
                case 'L': {
                    int tox = startx - 1;
                    if (tox >= 0) {
                        swapMulti(copyMatrix, startx, starty, tox, starty);
                        startx = tox;
                    }
                }
                break;
                case 'D': {
                    int toy = starty + 1;
                    if (toy < 5) {
                        swapMulti(copyMatrix, startx, starty, startx, toy);
                        starty = toy;
                    }
                }
                break;
                case 'U': {
                    int toy = starty - 1;
                    if (toy >= 0) {
                        swapMulti(copyMatrix, startx, starty, startx, toy);
                        starty = toy;
                    }
                }
                break;
            }
        }

        return copyMatrix;
    }

    public static void swapMulti(int[][] origin, int fromx, int fromy, int tox, int toy) {
        int originValue = origin[fromy][fromx];
        origin[fromy][fromx] = origin[toy][tox];
        origin[toy][tox] = originValue;
    }


    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static final void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void perm(ArrayList<String> perms, char buf[], int start, int end) {
        if (start == end) {
            System.out.println(new String(buf));
            perms.add(new String(buf));
            return;
        } else {
            for (int startIndex = start; startIndex <= end; startIndex++) {
                char[] subBuf = Arrays.copyOf(buf, buf.length);
                swap(subBuf, startIndex, start);
                perm(perms, subBuf, start + 1, end);
            }
        }
    }
}
