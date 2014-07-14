package amazon;

/**
 * Original Website
 * <p/>
 * http://www.cnblogs.com/supersteven/archive/2012/09/20/2695383.html
 * <p/>
 * <p/>
 * Question:
 * <p/>
 * Given an array with positive integers and another integer for example{7 2 4} 9, you are required to generate an equation, by inserting operator add ("+") and minus ("-") among the array . The left side of equation are consist of the array and the right side of equation is the integer. here the result is 7-2+4=9
 * Created by zhengxiao on 14-3-9.
 * <p/>
 * <p/>
 * Rules:
 * <p/>
 * Don't include any space in the generated equation.
 * In case there is no way to create the equation, please output "Invalid". For example {1 1} 10, output is "Invalid"
 * The length of the integer array is from 1 to 15( include 1 and 15). If the length is 1, for example the input  {7} 7, the output is 7=7
 * There is no operator "+" or "-" in front of the first number:
 * Don't change the order of the numbers. For example:  {7 2 4}  9. 7-2+4=9 is correct answer, 4-2+7=9 is wrong answer.
 * There could be multiple input, meaning your function could be called multiple times. Do remember print a new line after the call.
 * <p/>
 * Sample Input and Output:
 * <p/>
 * Input:
 * <p/>
 * 1 2 3 4 10
 * <p/>
 * 1 2 3 4 5
 * <p/>
 * Output:
 * <p/>
 * 1+2+3+4=10
 * <p/>
 * Invalid
 */
public class Equation1 {

    public static final int[] inputNumbers = {7, 2, 4};
    public static final int expectOut = 9;

    public static void main(String[] args) {
        System.out.println(iterateMethod(inputNumbers, expectOut));
    }

    /**
     * Define each bit is an operant, 0 = "-", 1 = "+"
     *
     * @param inputNumbers
     * @param expectOut
     * @return
     */
    private static String iterateMethod(int[] inputNumbers, int expectOut) {
        int iterator = (1 << (inputNumbers.length)) - 1;
        System.out.println(Integer.toBinaryString(iterator));
        for (int i = 0; i <= iterator; i++) {
            // 一次迭代, 验证是否正确
            StringBuilder b = new StringBuilder();
            int total = 0;
            int checker = i;
            for (int inputNumber : inputNumbers) {
                int bit = checker & 1;
                System.out.println(String.format("checker %s", Integer.toBinaryString(checker)));
                checker >>>= 1;
                total += (bit == 0 ? inputNumber * -1 : inputNumber);
                // construct equation
                if (bit == 0)
                    b.append("-");
                else
                    b.append("+");
                b.append(inputNumber);
            }


            // 验证
            boolean equals = total == expectOut;
            System.out.println(String.format("actual total %s, expected %s, equals? %s; %s", total, expectOut, equals, b.toString()));

            if (equals) {
                return b.toString();
            }

        }
        return "Invalid";
    }
}
